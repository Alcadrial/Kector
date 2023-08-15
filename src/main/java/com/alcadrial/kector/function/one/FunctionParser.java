package com.alcadrial.kector.function.one;

import java.util.regex.Matcher;

import com.alcadrial.kector.Math;
import com.alcadrial.kector.util.FunctionFormatException;
import com.alcadrial.kector.util.Patterns;

class FunctionParser {
	
	private static record TokenData(Token token, String value, int index) {}
	
	private static final class TokenStream {
		
		public record ExploringData(int startIndex, int endIndex) {}
		
		private String s;
		private char variable;
		private int index;
		
		public TokenStream(String s, char variable)
		{
			this.s = s;
			this.variable = variable;
		}
		
		public TokenData peek()
		{
			return explore(false);
		}
		
		public TokenData next()
		{
			return explore(true);
		}
		
		private TokenData explore(boolean advance)
		{
			ExploringData data;
			for (int i = index; i < s.length(); i++)
			{
				data = searchNumber(i);
				if (data.startIndex != -1) return new TokenData(Token.NUMBER, s.substring(data.startIndex(), data.endIndex()), data.startIndex());
			}
			if (index == s.length()) return new TokenData(Token.END, "", index);
			return new TokenData(Token.INVALID, s.substring(index), index);
		}
		
		private ExploringData searchNumber(int index)
		{
			String s0 = s.substring(index);
			Matcher matcher = Patterns.floatPattern().matcher(s0);
			for (int i = 1; i < s0.length(); i++) if (matcher.region(0, i).find()) return new ExploringData(0, i);
			return new ExploringData(-1, -1);
		}
		
		public TokenStream advance()
		{
			next();
			return this;
		}
	}
	
	private FunctionParser()
	{
		
	}
	
	static Function1f valueOf(String s)
	{
		if (s == null) throw new FunctionFormatException("Cannot parse null string");
		int separatorIndex = s.indexOf(":");
		int separatorIndexError = s.lastIndexOf(":");
		if (separatorIndexError > separatorIndex) throw new FunctionFormatException("Wrong varible definition: char ':' used more than once");
		if (separatorIndex >= 0 && separatorIndex != 1) throw new FunctionFormatException("Wrong varible definition: definition must be of 1 char before ':'");
		if (!Character.isAlphabetic(s.charAt(separatorIndex))) throw new FunctionFormatException("Wrong varible definition: definition must be an alphabetic char");
		
		return valueOf(s, separatorIndex == -1 ? 'x' : s.charAt(0));
	}
	
	static Function1f valueOf(String s, char variable)
	{
		if (s == null) throw new FunctionFormatException("Cannot parse null string");
		if (!Character.isAlphabetic(variable)) throw new FunctionFormatException("The variable must be an alphabetic char");
		
		return valueOf(new TokenStream(s, variable), variable, null, true);
	}
	
	private static Function1f valueOf(TokenStream stream, char variable, TokenData lastBracket, boolean required)
	{
		TokenData t = stream.next();
		TokenData t0 = stream.peek();
		return switch (t.token())
		{
			case NUMBER /* 3 */ ->
			{
				float number = Float.parseFloat(t.value());
				yield switch (t0.token())
				{
					case VARIABLE /* 3x */ ->
					{
						stream.advance();
						TokenData t1 = stream.peek();
						if (t1.token().isOperation())//3x?
						{
							
						}
						yield Function1f.ofLinear(number, 0);
					}
					case ADDITION /* 3+ */ -> Function1f.ofAddition(Function1f.ofConstant(number), valueOf(stream.advance(), variable, lastBracket, true));
					case SUBTRACTION /* 3- */ -> Function1f.ofAddition(Function1f.ofConstant(number), valueOf(stream, variable, lastBracket, true));
					case MULTIPLICATION/* 3* */ -> Function1f.ofMultiplication(Function1f.ofConstant(number), valueOf(stream.advance(), variable, lastBracket, true));
					// case DIVISION /* 3/ */ -> NYI;
					case OVER /* 3^ */ ->
					{
						Function1f overed = valueOf(stream.advance(), variable, lastBracket, true);
						
						if (overed instanceof ConstantFunction1f f) yield Function1f.ofConstant(Math.exp(f.getCoeffiecient()));
						if (overed instanceof LinearFunction1f f && f == Function1f.ofIdentity()) yield Function1f.ofExponentialBase(number);
						
						yield Function1f.ofFunction(Function1f.ofExponentialBase(number), overed);
					}
					// case UNDER /* 3_ */ -> NYI;
					case OPEN_BRACKET /* 3( */, OPEN_SQUARE_BRACKET /* 3[ */, OPEN_CURLY_BRACKET /* 3{ */ -> valueOf(stream.advance(), variable, t, true);
					case CLOSED_BRACKET /* 3) */ ->
					{
						stream.advance();
						if (lastBracket == null) throw new FunctionFormatException("Found '" + t0.value() + "' but not a '(' before");
						if (lastBracket.token() == Token.OPEN_BRACKET) yield Function1f.ofConstant(number);
						throw new FunctionFormatException("Found '" + t0.value() + "' at " + t0.index() + " while searching for '" + lastBracket.value() + "' from " + lastBracket.index());
					}
					case CLOSED_SQUARE_BRACKET /* 3] */ ->
					{
						stream.advance();
						if (lastBracket == null) throw new FunctionFormatException("Found '" + t0.value() + "' but not a '[' before");
						if (lastBracket.token() == Token.OPEN_SQUARE_BRACKET) yield Function1f.ofConstant(number);
						throw new FunctionFormatException("Found '" + t0.value() + "' at " + t0.index() + " while searching for '" + lastBracket.value() + "' from " + lastBracket.index());
					}
					case CLOSED_CURLY_BRACKET /* 3} */ ->
					{
						stream.advance();
						if (lastBracket == null) throw new FunctionFormatException("Found '" + t0.value() + "' but not a '{' before");
						if (lastBracket.token() == Token.OPEN_CURLY_BRACKET) yield Function1f.ofConstant(number);
						throw new FunctionFormatException("Found '" + t0.value() + "' at " + t0.index() + " while searching for '" + lastBracket.value() + "' from " + lastBracket.index());
					}
					case END ->
					{
						stream.advance();
						yield Function1f.ofConstant(number);
					}
					case INVALID -> throw new FunctionFormatException("Invalid token at " + t0.index());
					default -> throw new FunctionFormatException("Token not yet supported at " + t0.index());
				};
			}
			case OPEN_BRACKET /* ( */, OPEN_SQUARE_BRACKET /* [ */, OPEN_CURLY_BRACKET /* { */ -> valueOf(stream.advance(), variable, t, true);
			case END ->
			{
				if (required) throw new FunctionFormatException("Incomplete function");
				yield null;
			}
			case INVALID -> throw new FunctionFormatException("Invalid token at " + t.index());
			default -> throw new FunctionFormatException("Token not yet supported at " + t.index());
		};
	}
	
	private enum Token {
		
		OPEN_BRACKET(3),
		OPEN_SQUARE_BRACKET(3),
		OPEN_CURLY_BRACKET(3),
		CLOSED_BRACKET(3),
		CLOSED_SQUARE_BRACKET(3),
		CLOSED_CURLY_BRACKET(3),
		ADDITION(2),
		SUBTRACTION(2),
		MULTIPLICATION(2),
		DIVISION(2),
		OVER(2),
		UNDER(2),
		SQUARE_ROOT(2),
		NUMBER(1),
		EULER_NUMBER(1),
		PI_NUMBER(1),
		VARIABLE(1),
		END(0),
		INVALID(0);
		
		private int value;
		
		Token(int value)
		{
			this.value = value;
		}
		
		public boolean isValue()
		{
			return value == 0;
		}
		
		public boolean isOperation()
		{
			return value == 1;
		}
		
		public boolean isBracket()
		{
			return value == 2;
		}
	}
	
}

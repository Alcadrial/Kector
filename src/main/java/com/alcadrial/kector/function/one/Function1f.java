package com.alcadrial.kector.function.one;

import com.alcadrial.kector.function.MathFunction;

public interface Function1f extends MathFunction<Float, Float> {
	
	/**
	 * <p>A Function <img src="http://latex.codecogs.com/png.latex?f" alt="f"/> equals to this:</p>
	 * <blockquote><img src="http://latex.codecogs.com/png.latex?f(x)=b^x" alt="f(x)=b^x"/></blockquote>
	 * where:
	 * <ul style="list-style-type: none;">
	 * <li> <img src="http://latex.codecogs.com/png.latex?b" alt="b"/> is the base;</li>
	 * </ul>
	 * 
	 * @author Alcadrial
	 */
	/**
	 * <blockquote><img src="http://latex.codecogs.com/png.latex?f(x)=0" alt="f(x)=0"/></blockquote>
	 * @return a function
	 */
	static ConstantFunction1f ofZero()
	{
		return ConstantFunction1f.ZERO_FUNCTION;
	}
	
	/**
	 * <blockquote><img src="http://latex.codecogs.com/png.latex?f(x)=x" alt="f(x)=x"/></blockquote>
	 * @return a function
	 */
	static LinearFunction1f ofIdentity()
	{
		return LinearFunction1f.IDENTITY_FUNCTION;
	}
	
	/**
	 * <blockquote><img src="http://latex.codecogs.com/png.latex?f(x)=a" alt="f(x)=a"/></blockquote>
	 * @param a is a constant
	 * @return a function
	 */
	static ConstantFunction1f ofConstant(float a)
	{
		if (a == 0) return ConstantFunction1f.ZERO_FUNCTION;
		return new ConstantFunction1f(a);
	}
	
	/**
	 * <blockquote><img src="http://latex.codecogs.com/png.latex?f(x)=mx+q" alt="f(x)=mx+q"/></blockquote>
	 * @param m is a constant
	 * @param q is a constant
	 * @return a function
	 */
	static LinearFunction1f ofLinear(float m, float q)
	{
		return new LinearFunction1f(m, q);
	}
	
	/**
	 * <blockquote><img src="http://latex.codecogs.com/png.latex?f(x)=f_0(x)+f_1(x)" alt="f(x)=f_0(x)+f_1(x)"/></blockquote>
	 * @param f0 is a function
	 * @param f1 is a function
	 * @return a function
	 */
	static AdditionFunction1f ofAddition(Function1f f0, Function1f f1)
	{
		return new AdditionFunction1f(f0, f1);
	}
	
	/**
	 * <blockquote><img src="http://latex.codecogs.com/png.latex?f(x)=f_0(x)*f_1(x)" alt="f(x)=f_0(x)*f_1(x)"/></blockquote>
	 * @param f0 is a function
	 * @param f1 is a function
	 * @return a function
	 */
	static MultiplicationFunction1f ofMultiplication(Function1f f0, Function1f f1)
	{
		return new MultiplicationFunction1f(f0, f1);
	}
	
	/**
	 * 
	 * <blockquote><img src="http://latex.codecogs.com/png.latex?f(x)=x^{\alpha}" alt="f(x)=x^{\alpha}"/></blockquote>
	 * @param alpha is a constant
	 * @return a function
	 */
	static MonomialFunction1f ofMonomial(float alpha)
	{
		return new MonomialFunction1f(alpha);
	}
	
	/**
	 * 
	 * <blockquote><img src="http://latex.codecogs.com/png.latex?f(x)=ax^{\alpha}" alt="f(x)=ax^{\alpha}"/></blockquote>
	 * @param a is a constant
	 * @param alpha is a constant
	 * @return a function
	 */
	static MonomialFunction1f ofMonomial(float a, float alpha)
	{
		return new MonomialFunction1f(a, alpha);
	}
	
	/**
	 * 
	 * <blockquote><img src="http://latex.codecogs.com/png.latex?f(x)=e^x" alt="f(x)=e^x"/></blockquote>
	 * <b>Where:</b>
	 * <ul style="list-style-type: none;">
	 * <li><b>e</b> is the euler number</li>
	 * </ul>
	 * @return a function
	 */
	static ExponentialFunction1f ofExponential()
	{
		return ExponentialFunction1f.EXPONENTIAL_FUNCTION;
	}
	
	/**
	 * 
	 * <blockquote><img src="http://latex.codecogs.com/png.latex?f(x)=ae^x" alt="f(x)=ae^x"/></blockquote>
	 * <b>Where:</b>
	 * <ul style="list-style-type: none;">
	 * <li><b>e</b> is the euler number</li>
	 * </ul>
	 * @param a is a constant
	 * @return a function
	 */
	static CoefficientEBasedExponentialFunction1f ofExponential(float a)
	{
		return new CoefficientEBasedExponentialFunction1f(a);
	}
	
	/**
	 * 
	 * <blockquote><img src="http://latex.codecogs.com/png.latex?f(x)=b^x" alt="f(x)=b^x"/></blockquote>
	 * @param b is a constant
	 * @return a function
	 */
	static ExponentialFunction1f ofExponentialBase(float b)
	{
		return new ExponentialFunction1f(b);
	}
	
	/**
	 * 
	 * <blockquote><img src="http://latex.codecogs.com/png.latex?f(x)=ab^x" alt="f(x)=ab^x"/></blockquote>
	 * @param a is a constant
	 * @param b is a constant
	 * @return a function
	 */
	static CoefficientExponentialFunction1f ofExponentialBase(float a, float b)
	{
		return new CoefficientExponentialFunction1f(a, b);
	}
	
	/**
	 * 
	 * <blockquote><img src="http://latex.codecogs.com/png.latex?f(x)=ln(x)" alt="f(x)=ln(x)"/></blockquote>
	 * <b>Where:</b>
	 * <ul style="list-style-type: none;">
	 * <li><b>ln</b> is the natural logarithm</li>
	 * </ul>
	 * @return a function
	 */
	static LogarithmicFunction1f ofLn()
	{
		return LogarithmicFunction1f.LN_FUNCTION;
	}
	
	/**
	 * 
	 * <blockquote><img src="http://latex.codecogs.com/png.latex?f(x)=log_b(x)" alt="f(x)=log_b(x)"/></blockquote>
	 * @param b is a constant
	 * @return a function
	 */
	static LogarithmicFunction1f ofLog(float b)
	{
		return new LogarithmicFunction1f(b);
	}
	
	/**
	 * 
	 * <blockquote><img src="http://latex.codecogs.com/png.latex?f(x)=f_0(f_1(x))" alt="f(x)=f_0(f_1(x))"/></blockquote>
	 * @param f0 is a function
	 * @param f1 is a function
	 * @return a function
	 */
	static FunctionOfFunction1f<Float> ofFunction(Function1f f0, Function1f f1)
	{
		return new FunctionOfFunction1fOf1f1f(f0, f1);
	}
	
	static Function1f valueOf(String s)
	{
		return FunctionParser.valueOf(s);
	}
	
	static Function1f valueOf(String s, char variable)
	{
		return FunctionParser.valueOf(s, variable);
	}
	
	Function1f derivate();
}

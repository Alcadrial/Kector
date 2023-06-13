package com.alcadrial.kector.function.one;

/**
 * <p>A {@link Function1f} <img src="http://latex.codecogs.com/png.latex?f" alt="f"/> equals to this:</p>
 * <blockquote><img src="http://latex.codecogs.com/png.latex?f(x)=f_0(x)+f_1(x)" alt="f(x)=f_0(x)+f_1(x)"/></blockquote>
 * where:
 * <ul style="list-style-type: none;">
 * <li> <img src="http://latex.codecogs.com/png.latex?f_0" alt="f_0"/> is a function;</li>
 * <li> <img src="http://latex.codecogs.com/png.latex?f_1" alt="f_1"/> is a function;</li>
 * </ul>
 * 
 * @author Alcadrial
 */
public class AdditionFunction1f implements Function1f {
	
	static final AdditionFunction1f ZERO_PLUS_ZERO_FUNCTION = new AdditionFunction1f(Function1f.ofZero(), Function1f.ofZero()) {
		
		@Override
		public String toString()
		{
			return "0";
		}
	};
	
	private Function1f function0;
	private Function1f function1;
	
	AdditionFunction1f(Function1f function0, Function1f function1)
	{
		this.function0 = function0;
		this.function1 = function1;
	}
	
	@Override
	public Float apply(Float x)
	{
		return function0.apply(x) + function1.apply(x);
	}
	
	@Override
	public AdditionFunction1f devirate()
	{
		return Function1f.ofAddition(function0.devirate(), function1.devirate());
	}
	
	public Function1f getFunction0()
	{
		return function0;
	}
	
	public Function1f getFunction1()
	{
		return function1;
	}
	
	@Override
	public boolean isZero()
	{
		return function0.isZero() && function1.isZero();
	}
	
	@Override
	public String toString()
	{
		String s = function0.toString();
		if (s.equals("0")) return function1.toString();
		String s0 = function1.toString();
		if (s0.equals("0")) return s;
		if (s0.startsWith("-")) return s + s0;
		return s + "+" + s0;
	}
}

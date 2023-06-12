package com.alcadrial.kector.function.one;

/**
 * <p>A {@link Function1f} <i>f</i> equals to this:</p>
 * <blockquote><img src="http://latex.codecogs.com/png.latex?f(x)=f_0(x)\times f_1(x)" /></blockquote>
 * <p>where:
 * <ul style="list-style-type: none;">
 * <li> <i>f<sub>0</sub></i> is a function;</li>
 * <li> <i>f<sub>1</sub></i> is a function;</li>
 * </p>
 * 
 * @author Alcadrial
 */
public class MultiplicationFunction1f implements Function1f {
	
	private Function1f function0;
	private Function1f function1;
	
	MultiplicationFunction1f(Function1f function0, Function1f function1)
	{
		this.function0 = function0;
		this.function1 = function1;
	}
	
	@Override
	public Float apply(Float x)
	{
		return function0.apply(x) * function1.apply(x);
	}
	
	@Override
	public AdditionFunction1f devirate()
	{
		return new AdditionFunction1f(new MultiplicationFunction1f(function0.devirate(), function1), new MultiplicationFunction1f(function0, function1.devirate()));
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
		return function0.isZero() || function1.isZero();
	}
}

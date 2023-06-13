package com.alcadrial.kector.function.onetothree;

import com.alcadrial.kector.vector.Vector3f;

/**
 * <p>A {@link Function1x3f} <img src="http://latex.codecogs.com/png.latex?f" /> equals to this:</p>
 * <blockquote><img src="http://latex.codecogs.com/png.latex?f(x)=f_0(x)\times f_1(x)" /></blockquote>
 * <p>where:
 * <ul style="list-style-type: none;">
 * <li> <img src="http://latex.codecogs.com/png.latex?f_0" /> is a function;</li>
 * <li> <img src="http://latex.codecogs.com/png.latex?f_1" /> is a function;</li>
 * </p>
 * 
 * @author Alcadrial
 */
public class MultiplicationFunction1x3f implements Function1x3f {
	
	private Function1x3f function0;
	private Function1x3f function1;
	
	MultiplicationFunction1x3f(Function1x3f function0, Function1x3f function1)
	{
		this.function0 = function0;
		this.function1 = function1;
	}
	
	@Override
	public Vector3f apply(Float x)
	{
		return function0.apply(x).multiply(function1.apply(x));
	}
	
	@Override
	public AdditionFunction1x3f devirate()
	{
		return Function1x3f.ofAddition(Function1x3f.ofMultiplication(function0.devirate(), function1), Function1x3f.ofMultiplication(function0, function1.devirate()));
	}
	
	public Function1x3f getFunction0()
	{
		return function0;
	}
	
	public Function1x3f getFunction1()
	{
		return function1;
	}
	
	@Override
	public boolean isZero()
	{
		return function0.isZero() || function1.isZero();
	}
}

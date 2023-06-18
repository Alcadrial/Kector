package com.alcadrial.kector.function.three;

import com.alcadrial.kector.vector.Vector3f;

/**
 * <p>A {@link Function3f} <img src="http://latex.codecogs.com/png.latex?f" alt="f"/> equals to this:</p>
 * <blockquote><img src="http://latex.codecogs.com/png.latex?f(x)=f_0(x)+f_1(x)" alt="f(x)=f_0(x)+f_1(x)"/></blockquote>
 * where:
 * <ul style="list-style-type: none;">
 * <li> <img src="http://latex.codecogs.com/png.latex?f_0" alt="f_0"/> is a function;</li>
 * <li> <img src="http://latex.codecogs.com/png.latex?f_1" alt="f_1"/> is a function;</li>
 * </ul>
 * 
 * @author Alcadrial
 */
public class AdditionFunction3f implements Function3f {
	
	private Function3f function0;
	private Function3f function1;
	
	AdditionFunction3f(Function3f function0, Function3f function1)
	{
		this.function0 = function0;
		this.function1 = function1;
	}
	
	@Override
	public Vector3f apply(Vector3f x)
	{
		return function0.apply(x).add(function1.apply(x));
	}
	
	@Override
	public Function3f derivateX()
	{
		return Function3f.ofAddition(function0.derivateX(), function1.derivateX());
	}
	
	@Override
	public Function3f derivateY()
	{
		return Function3f.ofAddition(function0.derivateY(), function1.derivateY());
	}
	
	@Override
	public Function3f derivateZ()
	{
		return Function3f.ofAddition(function0.derivateZ(), function1.derivateZ());
	}
	
	public Function3f getFunction0()
	{
		return function0;
	}
	
	public Function3f getFunction1()
	{
		return function1;
	}
	
	@Override
	public boolean isZero()
	{
		return function0.isZero() && function1.isZero();
	}
}

package com.alcadrial.kector.function.three;

import com.alcadrial.kector.function.threetoone.Function3x1f;
import com.alcadrial.kector.vector.Vector3f;

/**
 * <p>A {@link Function3f} <img src="http://latex.codecogs.com/png.latex?\nabla f" alt="\nabla f"/> that is the gradient of a function:</p>
 * <blockquote><img src="http://latex.codecogs.com/png.latex?\nabla f(\vec x)=(f'_x(\vec x);f'_y(\vec x);f'_z(\vec x))" alt="\nabla f(\vec x)=(f'_x(\vec x);f'_y(\vec x);f'_z(\vec x))"/></blockquote>
 * where:
 * <ul style="list-style-type: none;">
 * <li> <img src="http://latex.codecogs.com/png.latex?f'_x" alt="f'_x"/> is the partial derivate in respect to x;</li>
 * </ul>
 * 
 * @author Alcadrial
 */
public class GradientFunction3f implements Function3f {
	
	private Function3x1f xFunction;
	private Function3x1f yFunction;
	private Function3x1f zFunction;
	
	GradientFunction3f(Function3x1f function)
	{
		xFunction = function.derivateX();
		yFunction = function.derivateY();
		zFunction = function.derivateZ();
	}
	
	private GradientFunction3f(Function3x1f xFunction, Function3x1f yFunction, Function3x1f zFunction)
	{
		this.xFunction = xFunction;
		this.yFunction = yFunction;
		this.zFunction = zFunction;
	}
	
	@Override
	public Vector3f apply(Vector3f x)
	{
		return Vector3f.of(xFunction.apply(x), yFunction.apply(x), zFunction.apply(x));
	}
	
	@Override
	public Function3f derivateX()
	{
		return new GradientFunction3f(xFunction.derivateX(), yFunction.derivateX(), zFunction.derivateX());
	}
	
	@Override
	public Function3f derivateY()
	{
		return new GradientFunction3f(xFunction.derivateY(), yFunction.derivateY(), zFunction.derivateY());
	}
	
	@Override
	public Function3f derivateZ()
	{
		return new GradientFunction3f(xFunction.derivateZ(), yFunction.derivateZ(), zFunction.derivateZ());
	}
	
	public Function3x1f getXFunction()
	{
		return xFunction;
	}
	
	public Function3x1f getYFunction()
	{
		return yFunction;
	}
	
	public Function3x1f getZFunction()
	{
		return zFunction;
	}
	
	@Override
	public boolean isZero()
	{
		return xFunction.isZero() && yFunction.isZero() && zFunction.isZero();
	}
}

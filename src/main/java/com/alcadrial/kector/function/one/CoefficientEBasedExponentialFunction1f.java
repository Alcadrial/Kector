package com.alcadrial.kector.function.one;

import com.alcadrial.kector.Math;

/**
 * <p>A {@link Function1f} <img src="http://latex.codecogs.com/png.latex?f" alt="f"/> equals to this:</p>
 * <blockquote><img src="http://latex.codecogs.com/png.latex?f(x)=ab^x" alt="f(x)=ab^x"/></blockquote>
 * where:
 * <ul style="list-style-type: none;">
 * <li> <img src="http://latex.codecogs.com/png.latex?a" alt="a"/> is the coefficient;</li>
 * <li> <img src="http://latex.codecogs.com/png.latex?b" alt="b"/> is the base;</li>
 * </ul>
 * 
 * @author Alcadrial
 */
public class CoefficientEBasedExponentialFunction1f implements Function1f, CoefficientFunction1f {
	
	private float a;
	
	CoefficientEBasedExponentialFunction1f(float a)
	{
		this.a = a;
	}
	
	@Override
	public Float apply(Float x)
	{
		return a * Math.exp(x);
	}
	
	@Override
	public Function1f derivate()
	{
		return Function1f.ofExponential(a * a);
	}
	
	@Override
	public boolean isZero()
	{
		return a == 0;
	}
	
	@Override
	public float getCoeffiecient()
	{
		return a;
	}
	
	@Override
	public String toString()
	{
		return a + "e^x";
	}
}

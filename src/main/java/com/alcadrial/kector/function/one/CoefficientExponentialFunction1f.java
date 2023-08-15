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
public class CoefficientExponentialFunction1f implements Function1f, CoefficientFunction1f {
	
	private float base;
	private float correction;
	private float a;
	
	CoefficientExponentialFunction1f(float base, float a)
	{
		this.base = base;
		correction = Math.log(base);
		this.a = a;
	}
	
	@Override
	public Float apply(Float x)
	{
		return a * Math.exp(x * correction);
	}
	
	@Override
	public Function1f derivate()
	{
		return Function1f.ofExponentialBase(a * correction, base);
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
	
	public float getBase()
	{
		return base;
	}
	
	@Override
	public String toString()
	{
		return a + "*" + base + "^x";
	}
}

package com.alcadrial.kector.function.one;

import com.alcadrial.kector.Math;

/**
 * <p>A {@link Function1f} <i>f</i> equals to this:</p>
 * <blockquote><img src="http://latex.codecogs.com/png.latex?f(x)=ab^x" /></blockquote>
 * <p>where:
 * <ul style="list-style-type: none;">
 * <li> <i>a</i> is the coefficient;</li>
 * <li> <i>b</i> is the base;</li>
 * </p>
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
	public Function1f devirate()
	{
		return Function1f.ofExponential(a * correction, base);
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
}

package com.alcadrial.kector.function.one;

import com.alcadrial.kector.Math;

/**
 * <p>A {@link Function1f} <i>f</i> equals to this:</p>
 * <blockquote><img src="http://latex.codecogs.com/png.latex?f(x)=ax^{\alpha}" /></blockquote>
 * <p>where:
 * <ul style="list-style-type: none;">
 * <li> <img src="http://latex.codecogs.com/png.latex?a" /> is the coefficient;</li>
 * <li> <img src="http://latex.codecogs.com/png.latex?\alpha" /> is the power;</li>
 * </p>
 * 
 * @author Alcadrial
 */
public class PowerFunction1f implements Function1f, CoefficientFunction1f {
	
	private float power;
	private float a;
	
	PowerFunction1f(float power)
	{
		a = 1;
		this.power = power;
	}
	
	PowerFunction1f(float a, float power)
	{
		this.a = a;
		this.power = power;
	}
	
	@Override
	public Float apply(Float x)
	{
		if (a == 0) return a;
		return a * Math.pow(x, power);
	}
	
	@Override
	public CoefficientFunction1f devirate()
	{
		if (a == 0 || power == 0) return Function1f.ofZero();
		if (power == 1) return Function1f.ofConstant(a * power);
		if (power == 2) return Function1f.ofLinear(a * power);
		return Function1f.ofPower(a * power, power - 1);
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
		return a + "x^" + power;
	}
}

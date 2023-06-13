package com.alcadrial.kector.function.one;

import com.alcadrial.kector.Math;
import com.alcadrial.kector.util.StringUtils;

/**
 * <p>A {@link Function1f} <img src="http://latex.codecogs.com/png.latex?f" alt="f"/> equals to this:</p>
 * <blockquote><img src="http://latex.codecogs.com/png.latex?f(x)=ax^{\alpha}" alt="f(x)=ax^{\alpha}"/></blockquote>
 * where:
 * <ul style="list-style-type: none;">
 * <li> <img src="http://latex.codecogs.com/png.latex?a" alt="a"/> is the coefficient;</li>
 * <li> <img src="http://latex.codecogs.com/png.latex?\alpha" alt="\alpha"/> is the power;</li>
 * </ul>
 * 
 * @author Alcadrial
 */
public class MonomialFunction1f implements Function1f, CoefficientFunction1f {
	
	private float power;
	private float a;
	
	MonomialFunction1f(float power)
	{
		a = 1;
		this.power = power;
	}
	
	MonomialFunction1f(float a, float power)
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
		if (a == 0) return "0";
		if (power == 0) return StringUtils.toString(a);
		if (power == 1)
		{
			if (a == 1) return "x";
			if (a == -1) return "-x";
			return StringUtils.toString(a) + "x";
		}
		if (power < 0)
		{
			if (a == 1) return "x^(" + StringUtils.toString(power) + ")";
			if (a == -1) return "-x^(" + StringUtils.toString(power) + ")";
			return StringUtils.toString(a) + "x^(" + StringUtils.toString(power) + ")";
		}
		if (a == 1) return "x^" + StringUtils.toString(power);
		if (a == -1) return "-x^" + StringUtils.toString(power);
		return StringUtils.toString(a) + "x^" + StringUtils.toString(power);
	}
}

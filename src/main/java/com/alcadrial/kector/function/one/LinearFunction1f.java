package com.alcadrial.kector.function.one;

import com.alcadrial.kector.util.StringUtils;

/**
 * <p>A {@link Function1f} <img src="http://latex.codecogs.com/png.latex?f" alt="f"/> equals to this:</p>
 * <blockquote><img src="http://latex.codecogs.com/png.latex?f(x)=mx" alt="f(x)=mx"/></blockquote>
 * where:
 * <ul style="list-style-type: none;">
 * <li> <img src="http://latex.codecogs.com/png.latex?m" alt="m"/> is the angular coefficient of the line;</li>
 * </ul>
 * 
 * @author Alcadrial
 */
public class LinearFunction1f implements Function1f, CoefficientFunction1f {
	
	static final LinearFunction1f IDENTITY_FUNCTION = new LinearFunction1f(1, 0) {
		
		@Override
		public Float apply(Float x)
		{
			return x;
		}
	};
	
	private float m;
	private float q;
	
	LinearFunction1f(float m, float q)
	{
		this.m = m;
		this.q = q;
	}
	
	@Override
	public Float apply(Float x)
	{
		return m * x + q;
	}
	
	@Override
	public ConstantFunction1f derivate()
	{
		return Function1f.ofConstant(m);
	}
	
	@Override
	public boolean isZero()
	{
		return false;
	}
	
	/**
	 * @return the value <img src="http://latex.codecogs.com/png.latex?m" alt="m"/>
	 */
	@Override
	public float getCoeffiecient()
	{
		return m;
	}
	
	public float getTranslation()
	{
		return q;
	}
	
	@Override
	public String toString()
	{
		if (m == 0) return StringUtils.toString(q);
		if (m == 1)
		{
			if (q == 0) return "x";
			if (q < 0) return "x" + StringUtils.toString(q);
			return "x+" + StringUtils.toString(q);
		}
		if (m == -1)
		{
			if (q == 0) return "-x";
			if (q < 0) return "-x" + StringUtils.toString(q);
			return "-x+" + StringUtils.toString(q);
		}
		if (q < 0) return StringUtils.toString(m) + "x" + StringUtils.toString(q);
		return StringUtils.toString(m) + "x-" + StringUtils.toString(q);
	}
}

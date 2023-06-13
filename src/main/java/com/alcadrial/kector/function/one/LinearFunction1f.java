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
	
	static final LinearFunction1f ZERO_FUNCTION = new LinearFunction1f(0) {
		
		@Override
		public Float apply(Float x)
		{
			return 0F;
		}
		
		@Override
		public boolean isZero()
		{
			return true;
		}
	};
	static final LinearFunction1f IDENTITY_FUNCTION = new LinearFunction1f(1) {
		
		@Override
		public Float apply(Float x)
		{
			return x;
		}
	};
	
	private float m;
	
	LinearFunction1f(float m)
	{
		this.m = m;
	}
	
	@Override
	public Float apply(Float x)
	{
		return m * x;
	}
	
	@Override
	public ConstantFunction1f devirate()
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
	
	@Override
	public String toString()
	{
		if (m == 0) return "0";
		if (m == 1) return "x";
		if (m == -1) return "-x";
		return StringUtils.toString(m) + "x";
	}
}

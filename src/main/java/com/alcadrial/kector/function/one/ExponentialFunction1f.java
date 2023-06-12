package com.alcadrial.kector.function.one;

import com.alcadrial.kector.Math;

/**
 * <p>A {@link Function1f} <i>f</i> equals to this:</p>
 * <blockquote><img src="http://latex.codecogs.com/png.latex?f(x)=b^x" /></blockquote>
 * <p>where:
 * <ul style="list-style-type: none;">
 * <li> <i>b</i> is the base;</li>
 * </p>
 * 
 * @author Alcadrial
 */
public class ExponentialFunction1f implements Function1f {
	
	static final ExponentialFunction1f EXPONENTIAL_FUNCTION = new ExponentialFunction1f(Math.EF) {
		
		@Override
		public Float apply(Float x)
		{
			return Math.exp(x);
		}
		
		@Override
		public Function1f devirate()
		{
			return EXPONENTIAL_FUNCTION;
		}
	};
	
	private float base;
	private float correction;
	
	ExponentialFunction1f(float base)
	{
		this.base = base;
		correction = Math.log(base);
	}
	
	@Override
	public Float apply(Float x)
	{
		return Math.exp(x * correction);
	}
	
	@Override
	public Function1f devirate()
	{
		return Function1f.ofExponential(correction, base);
	}
	
	@Override
	public boolean isZero()
	{
		return false;
	}
	
	public float getBase()
	{
		return base;
	}
}

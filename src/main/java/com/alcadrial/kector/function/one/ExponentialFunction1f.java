package com.alcadrial.kector.function.one;

import com.alcadrial.kector.Math;
import com.alcadrial.kector.util.StringUtils;

/**
 * <p>A {@link Function1f} <img src="http://latex.codecogs.com/png.latex?f" alt="f"/> equals to this:</p>
 * <blockquote><img src="http://latex.codecogs.com/png.latex?f(x)=b^x" alt="f(x)=b^x"/></blockquote>
 * where:
 * <ul style="list-style-type: none;">
 * <li> <img src="http://latex.codecogs.com/png.latex?b" alt="b"/> is the base;</li>
 * </ul>
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
		public Function1f derivate()
		{
			return EXPONENTIAL_FUNCTION;
		}
		
		@Override
		public String toString()
		{
			return "e^x";
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
	public Function1f derivate()
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
	
	@Override
	public String toString()
	{
		return StringUtils.toString(base) + "^x";
	}
}

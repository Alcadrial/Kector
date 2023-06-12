package com.alcadrial.kector.function.one;

import com.alcadrial.kector.Math;

/**
 * <p>A {@link Function1f} <i>f</i> equals to this:</p>
 * <blockquote><img src="http://latex.codecogs.com/png.latex?f(x)=log_b(x)" /></blockquote>
 * <p>where:
 * <ul style="list-style-type: none;">
 * <li> <i>b</i> is the base;</li>
 * </p>
 * 
 * @author Alcadrial
 */
public class LogarithmicFunction1f implements Function1f {
	
	static final LogarithmicFunction1f LN_FUNCTION = new LogarithmicFunction1f(Math.EF) {
		
		@Override
		public Float apply(Float x)
		{
			return Math.log(x);
		}
		
		@Override
		public Function1f devirate()
		{
			return Function1f.ofPower(-1);
		}
	};
	
	private float base;
	private float correction;
	
	LogarithmicFunction1f(float base)
	{
		this.base = base;
		correction = Math.log(base);
	}
	
	@Override
	public Float apply(Float x)
	{
		return Math.log(x) / correction;
	}
	
	@Override
	public Function1f devirate()
	{
		return Function1f.ofPower(correction, -1);
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

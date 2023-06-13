package com.alcadrial.kector.function.one;

import com.alcadrial.kector.Math;
import com.alcadrial.kector.util.StringUtils;

/**
 * <p>A {@link Function1f} <img src="http://latex.codecogs.com/png.latex?f" alt="f"/> equals to this:</p>
 * <blockquote><img src="http://latex.codecogs.com/png.latex?f(x)=log_b(x)" alt="f(x)=log_b(x)"/></blockquote>
 * where:
 * <ul style="list-style-type: none;">
 * <li> <img src="http://latex.codecogs.com/png.latex?b" alt="b"/> is the base;</li>
 * </ul>
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
			return Function1f.ofMonomial(-1);
		}
		
		@Override
		public String toString()
		{
			return "ln(x)";
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
		return Function1f.ofMonomial(correction, -1);
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
		return "log" + StringUtils.toString(base) + "(x)";
	}
}

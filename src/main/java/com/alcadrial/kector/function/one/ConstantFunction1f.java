package com.alcadrial.kector.function.one;

import com.alcadrial.kector.util.StringUtils;

/**
 * <p>A {@link Function1f} <img src="http://latex.codecogs.com/png.latex?f" /> equals to this:</p>
 * <blockquote><img src="http://latex.codecogs.com/png.latex?f(x)=c" /></blockquote>
 * <p>where:
 * <ul style="list-style-type: none;">
 * <li> <img src="http://latex.codecogs.com/png.latex?c" /> is a constant;</li>
 * </p>
 * 
 * @author Alcadrial
 */
public class ConstantFunction1f implements Function1f, CoefficientFunction1f {
	
	static final ConstantFunction1f ZERO_FUNCTION = new ConstantFunction1f(0) {
		
		@Override
		public boolean isZero()
		{
			return true;
		}
	};
	
	private float constant;
	
	ConstantFunction1f(float constant)
	{
		this.constant = constant;
	}
	
	@Override
	public Float apply(Float x)
	{
		return constant;
	}
	
	@Override
	public ConstantFunction1f devirate()
	{
		return ZERO_FUNCTION;
	}
	
	@Override
	public boolean isZero()
	{
		return false;
	}
	
	@Override
	public float getCoeffiecient()
	{
		return constant;
	}
	
	@Override
	public String toString()
	{
		return StringUtils.toString(constant);
	}
}

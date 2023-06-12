package com.alcadrial.kector.function;

/**
 * <p>A {@link Function1f} <i>f</i> equals to this:</p>
 * <blockquote><img src="http://latex.codecogs.com/png.latex?f(x)=c" /></blockquote>
 * <p>where <i>c</i> is a constant.</p>
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
	
	public float getConstant()
	{
		return constant;
	}
	
	@Override
	public boolean isZero()
	{
		return false;
	}
	
	@Override
	public float getCoeffiecient()
	{
		return 0;
	}
}

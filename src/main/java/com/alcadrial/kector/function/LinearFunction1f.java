package com.alcadrial.kector.function;

/**
 * <p>A {@link Function1f} <i>f</i> equals to this:</p>
 * <blockquote><img src="http://latex.codecogs.com/png.latex?f(x)=mx" /></blockquote>
 * <p>where <i>m</i> is the angular coefficient of the line.</p>
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
	 * @return the value <i>m</i>
	 */
	@Override
	public float getCoeffiecient()
	{
		return m;
	}
}

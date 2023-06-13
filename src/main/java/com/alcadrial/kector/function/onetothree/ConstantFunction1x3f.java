package com.alcadrial.kector.function.onetothree;

import com.alcadrial.kector.vector.Vector3f;

/**
 * <p>A {@link Function1x3f} <img src="http://latex.codecogs.com/png.latex?f" /> equals to this:</p>
 * <blockquote><img src="http://latex.codecogs.com/png.latex?f(x)=c" /></blockquote>
 * <p>where:
 * <ul style="list-style-type: none;">
 * <li> <img src="http://latex.codecogs.com/png.latex?c" /> is a constant;</li>
 * </p>
 * 
 * @author Alcadrial
 */
public class ConstantFunction1x3f implements Function1x3f, CoefficientFunction1x3f {
	
	static final ConstantFunction1x3f ZERO_FUNCTION = new ConstantFunction1x3f(Vector3f.origin()) {
		
		@Override
		public boolean isZero()
		{
			return true;
		}
	};
	
	private Vector3f constant;
	
	ConstantFunction1x3f(Vector3f constant)
	{
		this.constant = Vector3f.copyOfImmutable(constant);
	}
	
	@Override
	public Vector3f apply(Float x)
	{
		return constant;
	}
	
	@Override
	public ConstantFunction1x3f devirate()
	{
		return ZERO_FUNCTION;
	}
	
	@Override
	public boolean isZero()
	{
		return false;
	}
	
	@Override
	public Vector3f getCoeffiecient()
	{
		return constant;
	}
	
	@Override
	public String toString()
	{
		return constant.toString();
	}
}

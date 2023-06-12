package com.alcadrial.kector.function.three;

import com.alcadrial.kector.vector.Vector3f;

/**
 * <p>A {@link Function3f} <i>f</i> equals to this:</p>
 * <blockquote><img src="http://latex.codecogs.com/png.latex?f(\vec{x})=\vec{c}" /></blockquote>
 * <p>where:
 * <ul style="list-style-type: none;">
 * <li> <img src="http://latex.codecogs.com/png.latex?\vec{c}" /> is a constant;</li>
 * </p>
 * 
 * @author Alcadrial
 */
public class ConstantFunction3f implements Function3f, CoefficientFunction3f {
	
	static final ConstantFunction3f ZERO_FUNCTION = new ConstantFunction3f(Vector3f.origin()) {
		
		@Override
		public boolean isZero()
		{
			return true;
		}
	};
	
	private Vector3f constant;
	
	ConstantFunction3f(Vector3f constant)
	{
		this.constant = Vector3f.copyOfImmutable(constant);
	}
	
	@Override
	public Vector3f apply(Vector3f x)
	{
		return constant;
	}
	
	@Override
	public ConstantFunction3f devirate()
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

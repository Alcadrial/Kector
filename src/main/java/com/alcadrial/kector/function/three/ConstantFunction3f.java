package com.alcadrial.kector.function.three;

import com.alcadrial.kector.vector.Vector3f;

/**
 * <p>A {@link Function3f} <img src="http://latex.codecogs.com/png.latex?f" alt="f"/> equals to this:</p>
 * <blockquote><img src="http://latex.codecogs.com/png.latex?f(\vec{x})=\vec{c}" alt="f(\vec{x})=\vec{c}"/></blockquote>
 * where:
 * <ul style="list-style-type: none;">
 * <li> <img src="http://latex.codecogs.com/png.latex?\vec{c}" alt="\vec{c}"/> is a constant;</li>
 * </ul>
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
	public Function3f derivateX()
	{
		return ZERO_FUNCTION;
	}
	
	@Override
	public Function3f derivateY()
	{
		return ZERO_FUNCTION;
	}
	
	@Override
	public Function3f derivateZ()
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

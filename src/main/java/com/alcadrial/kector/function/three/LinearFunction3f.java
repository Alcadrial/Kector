package com.alcadrial.kector.function.three;

import com.alcadrial.kector.vector.Vector3f;

/**
 * <p>A {@link Function3f} <img src="http://latex.codecogs.com/png.latex?f" alt="f"/> equals to this:</p>
 * <blockquote><img src="http://latex.codecogs.com/png.latex?f(\vec{x})=\vec{m}\vec{x}" alt="f(\vec{x})=\vec{m}\vec{x}"/></blockquote>
 * where:
 * <ul style="list-style-type: none;">
 * <li> <img src="http://latex.codecogs.com/png.latex?\vec{m}" alt="\vec{m}"/> is the angular coefficient of the line;</li>
 * </ul>
 * 
 * @author Alcadrial
 */
public class LinearFunction3f implements Function3f, CoefficientFunction3f {
	
	static final LinearFunction3f ZERO_FUNCTION = new LinearFunction3f(Vector3f.origin()) {
		
		@Override
		public Vector3f apply(Vector3f x)
		{
			return Vector3f.origin();
		}
		
		@Override
		public boolean isZero()
		{
			return true;
		}
	};
	static final LinearFunction3f IDENTITY_FUNCTION = new LinearFunction3f(Vector3f.of(1, 1, 1)) {
		
		@Override
		public Vector3f apply(Vector3f x)
		{
			return x;
		}
	};
	
	private Vector3f m;
	
	LinearFunction3f(Vector3f m)
	{
		this.m = Vector3f.copyOfImmutable(m);
	}
	
	@Override
	public Vector3f apply(Vector3f x)
	{
		return m.multiply(x);
	}
	
	@Override
	public Function3f derivateX()
	{
		return Function3f.ofConstant(m);
	}
	
	@Override
	public Function3f derivateY()
	{
		return Function3f.ofConstant(m);
	}
	
	@Override
	public Function3f derivateZ()
	{
		return Function3f.ofConstant(m);
	}
	
	@Override
	public boolean isZero()
	{
		return false;
	}
	
	/**
	 * @return the value <img src="http://latex.codecogs.com/png.latex?\vec{m}" alt="\vec{m}"/>
	 */
	@Override
	public Vector3f getCoeffiecient()
	{
		return m;
	}
	
	@Override
	public String toString()
	{
		return m + "x";
	}
}

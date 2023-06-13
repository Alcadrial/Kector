package com.alcadrial.kector.function.onetothree;

import com.alcadrial.kector.vector.Vector3f;

/**
 * <p>A {@link Function1x3f} <img src="http://latex.codecogs.com/png.latex?f" alt="f"/> equals to this:</p>
 * <blockquote><img src="http://latex.codecogs.com/png.latex?f(x)=\vec{m}x" alt="f(x)=\vec{m}x"/></blockquote>
 * where:
 * <ul style="list-style-type: none;">
 * <li> <img src="http://latex.codecogs.com/png.latex?\vec{m}" alt="\vec{m}"/> is the angular coefficient of the line;</li>
 * </ul>
 * 
 * @author Alcadrial
 */
public class LinearFunction1x3f implements Function1x3f, CoefficientFunction1x3f {
	
	static final LinearFunction1x3f ZERO_FUNCTION = new LinearFunction1x3f(Vector3f.origin()) {
		
		@Override
		public Vector3f apply(Float x)
		{
			return Vector3f.origin();
		}
		
		@Override
		public boolean isZero()
		{
			return true;
		}
	};
	static final LinearFunction1x3f IDENTITY_FUNCTION = new LinearFunction1x3f(Vector3f.of(1, 1, 1)) {
		
		@Override
		public Vector3f apply(Float x)
		{
			return Vector3f.of(x, x, x);
		}
	};
	
	private Vector3f m;
	
	LinearFunction1x3f(Vector3f m)
	{
		this.m = Vector3f.copyOfImmutable(m);
	}
	
	@Override
	public Vector3f apply(Float x)
	{
		return m.multiplyAll(x);
	}
	
	@Override
	public ConstantFunction1x3f devirate()
	{
		return Function1x3f.ofConstant(m);
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

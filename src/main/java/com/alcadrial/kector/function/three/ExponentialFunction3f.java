package com.alcadrial.kector.function.three;

import com.alcadrial.kector.Math;
import com.alcadrial.kector.vector.Vector3f;

/**
 * <p>A {@link Function3f} <i>f</i> equals to this:</p>
 * <blockquote><img src="http://latex.codecogs.com/png.latex?f(\vec{x})=\vec{b}^{\vec{x}}" /></blockquote>
 * <p>where:
 * <ul style="list-style-type: none;">
 * <li> <img src="http://latex.codecogs.com/png.latex?\vec{b}" /> is the base;</li>
 * </p>
 * 
 * @author Alcadrial
 */
public class ExponentialFunction3f implements Function3f {
	
	static final ExponentialFunction3f EXPONENTIAL_FUNCTION = new ExponentialFunction3f(Vector3f.of(Math.EF, Math.EF, Math.EF)) {
		
		@Override
		public Vector3f apply(Vector3f x)
		{
			return Math.exp(x);
		}
		
		@Override
		public Function3f devirate()
		{
			return EXPONENTIAL_FUNCTION;
		}
	};
	
	private Vector3f base;
	private Vector3f correction;
	
	ExponentialFunction3f(Vector3f base)
	{
		this.base = Vector3f.copyOfImmutable(base);
		correction = Math.log(base);
	}
	
	@Override
	public Vector3f apply(Vector3f x)
	{
		return Math.exp(x.multiply(correction));
	}
	
	@Override
	public Function3f devirate()
	{
		return Function3f.ofExponential(correction, base);
	}
	
	@Override
	public boolean isZero()
	{
		return false;
	}
	
	public Vector3f getBase()
	{
		return base;
	}
}

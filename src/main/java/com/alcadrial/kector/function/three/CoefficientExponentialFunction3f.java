package com.alcadrial.kector.function.three;

import com.alcadrial.kector.Math;
import com.alcadrial.kector.vector.Vector3f;

/**
 * <p>A {@link Function3f} <i>f</i> equals to this:</p>
 * <blockquote><img src="http://latex.codecogs.com/png.latex?f(\vec{x})=\vec{a}\vec{b}^{\vec{x}}" /></blockquote>
 * <p>where:
 * <ul style="list-style-type: none;">
 * <li> <img src="http://latex.codecogs.com/png.latex?\vec{a}" /> is the coefficient;</li>
 * <li> <img src="http://latex.codecogs.com/png.latex?\vec{b}" /> is the base;</li>
 * <li> <img src="http://latex.codecogs.com/png.latex?\vec{a}\vec{b}" /> is the scalar product of 
 * <img src="http://latex.codecogs.com/png.latex?\vec{a}" /> and <img src="http://latex.codecogs.com/png.latex?\vec{b}" />;</li>
 * </p>
 * 
 * @author Alcadrial
 */
public class CoefficientExponentialFunction3f implements Function3f, CoefficientFunction3f {
	
	private Vector3f base;
	private Vector3f correction;
	private Vector3f a;
	
	CoefficientExponentialFunction3f(Vector3f base, Vector3f a)
	{
		this.base = Vector3f.copyOfImmutable(base);
		correction = Math.log(base);
		this.a = Vector3f.copyOfImmutable(a);
	}
	
	@Override
	public Vector3f apply(Vector3f x)
	{
		return a.multiply(Math.exp(x.multiply(correction)));
	}
	
	@Override
	public Function3f devirate()
	{
		return Function3f.ofExponential(a.multiply(correction), base);
	}
	
	@Override
	public boolean isZero()
	{
		return a.equals(Vector3f.origin());
	}
	
	@Override
	public Vector3f getCoeffiecient()
	{
		return a;
	}
	
	public Vector3f getBase()
	{
		return base;
	}
}

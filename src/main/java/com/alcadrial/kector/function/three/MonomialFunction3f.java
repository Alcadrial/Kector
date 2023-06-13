package com.alcadrial.kector.function.three;

import com.alcadrial.kector.Math;
import com.alcadrial.kector.vector.Vector3f;

/**
 * <p>A {@link Function3f} <img src="http://latex.codecogs.com/png.latex?f" /> equals to this:</p>
 * <blockquote><img src="http://latex.codecogs.com/png.latex?f(\vec{x})=\vec{a}\vec{x}^{\vec{\alpha}}" /></blockquote>
 * <p>where:
 * <ul style="list-style-type: none;">
 * <li> <img src="http://latex.codecogs.com/png.latex?\vec{a}" /> is the coefficient;</li>
 * <li> <img src="http://latex.codecogs.com/png.latex?\vec{\alpha}" /> is the power;</li>
 * </p>
 * 
 * @author Alcadrial
 */
public class MonomialFunction3f implements Function3f, CoefficientFunction3f {
	
	private Vector3f power;
	private Vector3f a;
	
	MonomialFunction3f(Vector3f power)
	{
		a = Vector3f.ofImmutable(1, 1, 1);
		this.power = Vector3f.copyOfImmutable(power);
	}
	
	MonomialFunction3f(Vector3f a, Vector3f power)
	{
		this.a = Vector3f.copyOfImmutable(a);
		this.power = Vector3f.copyOfImmutable(power);
	}
	
	@Override
	public Vector3f apply(Vector3f x)
	{
		if (a.equals(Vector3f.origin())) return a;
		return Vector3f.of(a.x() * Math.pow(x.x(), power.x()), a.y() * Math.pow(x.y(), power.y()), a.z() * Math.pow(x.z(), power.z()));
	}
	
	@Override
	public CoefficientFunction3f devirate()
	{
		if (a.equals(Vector3f.origin()) || power.equals(Vector3f.origin())) return Function3f.ofZero();
		if (power.equals(Vector3f.of(1, 1, 1))) return Function3f.ofConstant(a.multiply(power));
		if (power.equals(Vector3f.of(2, 2, 2))) return Function3f.ofLinear(a.multiply(power));
		return Function3f.ofPower(a.multiply(power), power.subtractAll(1));
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
	
	@Override
	public String toString()
	{
		return a + "x^" + power;
	}
}

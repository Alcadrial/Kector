package com.alcadrial.kector.function.onetothree;

import com.alcadrial.kector.Math;
import com.alcadrial.kector.function.three.Function3f;
import com.alcadrial.kector.vector.Vector3f;

/**
 * <p>A {@link Function3f} <img src="http://latex.codecogs.com/png.latex?f" alt="f"/> equals to this:</p>
 * <blockquote><img src="http://latex.codecogs.com/png.latex?f(x)=\vec{a}x^{\alpha}" alt="f(x)=\vec{a}x^{\alpha}"/></blockquote>
 * where:
 * <ul style="list-style-type: none;">
 * <li> <img src="http://latex.codecogs.com/png.latex?\vec{a}" alt="\vec{a}"/> is the coefficient;</li>
 * <li> <img src="http://latex.codecogs.com/png.latex?\alpha" alt="\alpha"/> is the power;</li>
 * </ul>
 * 
 * @author Alcadrial
 */
public class MonomialFunction1x3f implements Function1x3f, CoefficientFunction1x3f {
	
	private float power;
	private Vector3f a;
	
	MonomialFunction1x3f(float power)
	{
		a = Vector3f.ofImmutable(1, 1, 1);
		this.power = power;
	}
	
	MonomialFunction1x3f(Vector3f a, float power)
	{
		this.a = Vector3f.copyOfImmutable(a);
		this.power = power;
	}
	
	@Override
	public Vector3f apply(Float x)
	{
		if (a.equals(Vector3f.origin())) return a;
		return a.multiplyAll(Math.pow(x, power));
	}
	
	@Override
	public CoefficientFunction1x3f devirate()
	{
		if (a.equals(Vector3f.origin()) || power == 0) return Function1x3f.ofZero();
		if (power == 1) return Function1x3f.ofConstant(a.multiplyAll(power));
		if (power == 2) return Function1x3f.ofLinear(a.multiplyAll(power));
		return Function1x3f.ofPower(a.multiplyAll(power), power - 1);
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

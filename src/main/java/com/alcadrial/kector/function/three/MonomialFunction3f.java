package com.alcadrial.kector.function.three;

import com.alcadrial.kector.Math;
import com.alcadrial.kector.vector.Vector3f;

/**
 * <p>A {@link Function3f} <img src="http://latex.codecogs.com/png.latex?f" alt="f"/> equals to this:</p>
 * <blockquote><img src="http://latex.codecogs.com/png.latex?f(\vec{x})=\vec{a}\vec{x}^{\vec{\alpha}}" alt="f(\vec{x})=\vec{a}\vec{x}^{\vec{\alpha}}"/></blockquote>
 * where:
 * <ul style="list-style-type: none;">
 * <li> <img src="http://latex.codecogs.com/png.latex?\vec{a}" alt="\vec{a}"/> is the coefficient;</li>
 * <li> <img src="http://latex.codecogs.com/png.latex?\vec{\alpha}" alt="\vec{\alpha}"/> is the power;</li>
 * </ul>
 * 
 * @author Alcadrial
 */
public class MonomialFunction3f implements Function3f, CoefficientFunction3f {
	
	private Vector3f grade;
	private Vector3f a;
	
	MonomialFunction3f(Vector3f grade)
	{
		a = Vector3f.ofImmutable(1, 1, 1);
		this.grade = Vector3f.copyOfImmutable(grade);
	}
	
	MonomialFunction3f(Vector3f a, Vector3f grade)
	{
		this.a = Vector3f.copyOfImmutable(a);
		this.grade = Vector3f.copyOfImmutable(grade);
	}
	
	@Override
	public Vector3f apply(Vector3f x)
	{
		if (a.equals(Vector3f.origin())) return a;
		return Vector3f.of(a.x() * Math.pow(x.x(), grade.x()), a.y() * Math.pow(x.y(), grade.y()), a.z() * Math.pow(x.z(), grade.z()));
	}
	
	@Override
	public CoefficientFunction3f devirate()
	{
		if (a.equals(Vector3f.origin()) || grade.equals(Vector3f.origin())) return Function3f.ofZero();
		if (grade.equals(Vector3f.of(1, 1, 1))) return Function3f.ofConstant(a.multiply(grade));
		if (grade.equals(Vector3f.of(2, 2, 2))) return Function3f.ofLinear(a.multiply(grade));
		return Function3f.ofMonomial(a.multiply(grade), grade.subtractAll(1));
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
		return a + "x^" + grade;
	}
}

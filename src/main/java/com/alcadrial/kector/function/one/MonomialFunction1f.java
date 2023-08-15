package com.alcadrial.kector.function.one;

import com.alcadrial.kector.Math;
import com.alcadrial.kector.util.StringUtils;

/**
 * <p>A {@link Function1f} <img src="http://latex.codecogs.com/png.latex?f" alt="f"/> equals to this:</p>
 * <blockquote><img src="http://latex.codecogs.com/png.latex?f(x)=ax^{\alpha}" alt="f(x)=ax^{\alpha}"/></blockquote>
 * where:
 * <ul style="list-style-type: none;">
 * <li> <img src="http://latex.codecogs.com/png.latex?a" alt="a"/> is the coefficient;</li>
 * <li> <img src="http://latex.codecogs.com/png.latex?\alpha" alt="\alpha"/> is the power;</li>
 * </ul>
 * 
 * @author Alcadrial
 */
public class MonomialFunction1f implements Function1f, CoefficientFunction1f {
	
	private float grade;
	private float a;
	
	MonomialFunction1f(float grade)
	{
		a = 1;
		this.grade = grade;
	}
	
	MonomialFunction1f(float a, float grade)
	{
		this.a = a;
		this.grade = grade;
	}
	
	@Override
	public Float apply(Float x)
	{
		if (a == 0) return a;
		return a * Math.pow(x, grade);
	}
	
	@Override
	public CoefficientFunction1f derivate()
	{
		if (a == 0 || grade == 0) return Function1f.ofZero();
		if (grade == 1) return Function1f.ofConstant(a * grade);
		return Function1f.ofMonomial(a * grade, grade - 1);
	}
	
	@Override
	public boolean isZero()
	{
		return a == 0;
	}
	
	@Override
	public float getCoeffiecient()
	{
		return a;
	}
	
	public float getGrade()
	{
		return grade;
	}
	
	@Override
	public String toString()
	{
		if (a == 0) return "0";
		if (grade == 0) return StringUtils.toString(a);
		if (grade == 1)
		{
			if (a == 1) return "x";
			if (a == -1) return "-x";
			return StringUtils.toString(a) + "x";
		}
		if (grade < 0)
		{
			if (a == 1) return "x^(" + StringUtils.toString(grade) + ")";
			if (a == -1) return "-x^(" + StringUtils.toString(grade) + ")";
			return StringUtils.toString(a) + "x^(" + StringUtils.toString(grade) + ")";
		}
		if (a == 1) return "x^" + StringUtils.toString(grade);
		if (a == -1) return "-x^" + StringUtils.toString(grade);
		return StringUtils.toString(a) + "x^" + StringUtils.toString(grade);
	}
}

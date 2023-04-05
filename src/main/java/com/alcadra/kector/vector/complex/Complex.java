package com.alcadra.kector.vector.complex;

import com.alcadra.kector.vector.MutableVector2f;
import com.alcadra.kector.vector.Vector2f;

public class Complex extends MutableVector2f {
	
	public Complex(Vector2f vector)
	{
		this(vector.x(), vector.y());
	}
	
	public Complex(float r, float i)
	{
		super(r, i);
		unitary();
	}
	
	public Complex multiply(Complex complex)
	{
		return new Complex(r() * complex.r() - i() * complex.i(), r() * complex.i() + i() * complex.r());
	}
	
	public MutableVector2f rotate(Vector2f v)
	{
		float r = r() * r();
		float i = i() * i();
		return new MutableVector2f(r * v.x() + i * v.x(), r * v.y() + i * v.y());
	}
	
	@Override
	public Complex conjugate()
	{
		return (Complex) super.conjugate();
	}
	
	public float r()
	{
		return X;
	}
	
	public float i()
	{
		return Y;
	}
	
	@Override
	public String toString()
	{
		String s = "";
		boolean b;
		if (b = (int) (r() * 1000) != 0) s += r();
		if ((int) (i() * 1000) != 0)
		{
			if (i() > 0)
			{
				if (b) s += " + ";
				s += i();
			}
			else if (b) s += " - " + -i();
			else s += i();
		}
		return s.length() == 0 ? "0" : s;
	}
}

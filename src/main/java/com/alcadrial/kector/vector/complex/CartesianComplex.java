package com.alcadrial.kector.vector.complex;

/*
public class CartesianComplex extends MutableVector2f implements ComplexVector {
	
	public CartesianComplex(Vector2f vector)
	{
		this(vector.x(), vector.y());
	}
	
	public CartesianComplex(Complex complex)
	{
		super(complex.r(), complex.i());
	}
	
	public CartesianComplex(float r, float i)
	{
		super(r, i);
	}
	
	@Override
	public Complex add(Complex complex)
	{
		X += complex.r();
		Y += complex.i();
		return this;
	}
	
	@Override
	public Complex multiply(Complex complex)
	{
		X = r() * complex.r() - i() * complex.i();
		Y = r() * complex.i() + i() * complex.r();
		return this;
	}
	
	@Override
	public Vector2f rotate(Vector2f v)
	{
		float r = r() * r();
		float i = i() * i();
		return Vector2f.of(r * v.x() + i * v.x(), r * v.y() + i * v.y());
	}
	
	@Override
	public ComplexVector conjugate()
	{
		super.conjugate();
		return this;
	}
	
	@Override
	public Vector2f asVector()
	{
		return this;
	}
	
	@Override
	public float r()
	{
		return X;
	}
	
	@Override
	public float i()
	{
		return Y;
	}
	
	@Override
	public Angle angle()
	{
		return Angle.of(Math.atan2(i(), r()), AngleUnit.RADIANS);
	}
	
	@Override
	public float angle(AngleUnit unit)
	{
		return angle().asFloat(unit);
	}
	
	@Override
	public float magnitude()
	{
		return (float) length();
	}
	
	@Override
	public Complex setR(float r)
	{
		X = r;
		return this;
	}
	
	@Override
	public Complex setI(float i)
	{
		Y = i;
		return this;
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
*/
package com.alcadrial.kector.vector.complex;

import com.alcadrial.kector.Math;
import com.alcadrial.kector.angle.Angle;
import com.alcadrial.kector.angle.AngleUnit;
import com.alcadrial.kector.vector.Vector2f;
import com.alcadrial.kector.vector.immutable.ImmutableVector2f;

public class ImmutableCartesianComplex extends ImmutableVector2f implements ComplexVector {
	
	private String toString;
	private final float r2;
	private final float i2;
	
	public ImmutableCartesianComplex(Vector2f vector)
	{
		this(vector.x(), vector.y());
	}
	
	public ImmutableCartesianComplex(Complex complex)
	{
		this(complex.r(), complex.i());
	}
	
	public ImmutableCartesianComplex(float r, float i)
	{
		super(r, i);
		r2 = r * r;
		i2 = i * i;
	}
	
	private ImmutableCartesianComplex(float r, float i, float r2, float i2)
	{
		super(r, i);
		this.r2 = r2;
		this.i2 = i2;
	}
	
	@Override
	public Complex add(Complex complex)
	{
		return new ImmutableCartesianComplex(r() + complex.r(), i() + complex.i());
	}
	
	@Override
	public Complex multiply(Complex complex)
	{
		return new ImmutableCartesianComplex(r() * complex.r() - i() * complex.i(), r() * complex.i() + i() * complex.r());
	}
	
	@Override
	public Vector2f rotate(Vector2f v)
	{
		return Vector2f.of(r2 * v.x() + i2 * v.x(), r2 * v.y() + i2 * v.y());
	}
	
	@Override
	public ComplexVector conjugate()
	{
		return new ImmutableCartesianComplex(r(), -i(), r2, i2);
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
		return new ImmutableCartesianComplex(r, i(), r2, i2);
	}
	
	@Override
	public Complex setI(float i)
	{
		return new ImmutableCartesianComplex(r(), i, r2, i2);
	}
	
	@Override
	public String toString()
	{
		if (toString == null)
		{
			toString = "";
			boolean b;
			if (b = (int) (r() * 1000) != 0) toString += r();
			if ((int) (i() * 1000) != 0)
			{
				if (i() > 0)
				{
					if (b) toString += " + ";
					toString += i();
				}
				else if (b) toString += " - " + -i();
				else toString += i();
			}
			toString = toString.length() == 0 ? "0" : toString;
		}
		return toString;
	}
}

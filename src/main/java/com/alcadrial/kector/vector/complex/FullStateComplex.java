package com.alcadrial.kector.vector.complex;

import com.alcadrial.kector.Math;
import com.alcadrial.kector.angle.Angle;
import com.alcadrial.kector.angle.AngleUnit;
import com.alcadrial.kector.vector.Vector2f;

public class FullStateComplex implements Complex {
	
	private float R;
	private float I;
	private float magnitude;
	private Angle angle;
	
	public FullStateComplex(Vector2f vector)
	{
		this(vector.x(), vector.y());
	}
	
	public FullStateComplex(float r, float i)
	{
		R = r;
		I = i;
		resetPolar();
	}
	
	public FullStateComplex(float magnitude, Angle angle)
	{
		this.magnitude = magnitude;
		this.angle = angle;
		resetCartesian();
	}
	
	public FullStateComplex(Complex complex)
	{
		R = complex.r();
		I = complex.i();
		magnitude = complex.magnitude();
		angle = complex.angle();
	}
	
	@Override
	public Complex add(Complex complex)
	{
		R += complex.r();
		I += complex.i();
		resetPolar();
		return this;
	}
	
	@Override
	public Complex multiply(Complex complex)
	{
		angle.add(complex.angle());
		magnitude *= complex.magnitude();
		resetCartesian();
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
	public Complex conjugate()
	{
		angle.opposite();
		I = -I;
		return this;
	}
	
	@Override
	public Vector2f asVector()
	{
		return Vector2f.of(r(), i());
	}
	
	@Override
	public float r()
	{
		return R;
	}
	
	@Override
	public float i()
	{
		return I;
	}
	
	@Override
	public Angle angle()
	{
		return Angle.copyOf(angle);
	}
	
	@Override
	public float angle(AngleUnit unit)
	{
		return angle.asFloat(unit);
	}
	
	@Override
	public float magnitude()
	{
		return magnitude;
	}
	
	@Override
	public Complex setR(float r)
	{
		R = r;
		resetPolar();
		return this;
	}
	
	@Override
	public Complex setI(float i)
	{
		I = i;
		resetPolar();
		return this;
	}
	
	private void resetCartesian()
	{
		float o = angle.asFloat();
		R = magnitude() * Math.cos(o);
		I = magnitude() * Math.sin(o);
	}
	
	private void resetPolar()
	{
		magnitude = Math.sqrt(r() * r() + i() * i());
		angle.setValue(AngleUnit.RADIANS, Math.atan2(i(), r()));
	}
}

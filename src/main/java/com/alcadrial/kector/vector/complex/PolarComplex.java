package com.alcadrial.kector.vector.complex;

/*
public class PolarComplex implements Complex {
	
	private float magnitude;
	private Angle angle;
	
	public PolarComplex(float magnitude, Angle angle)
	{
		this.magnitude = magnitude;
		this.angle = angle;
	}
	
	public PolarComplex(Vector2f vector, AngleUnit unit)
	{
		magnitude = vector.x();
		angle = Angle.of(vector.y(), unit);
	}
	
	public PolarComplex(Complex complex)
	{
		magnitude = complex.magnitude();
		angle = complex.angle();
	}
	
	@Override
	public Complex add(Complex complex)
	{
		double angle = this.angle.asDouble();
		double angle0 = complex.angle().asDouble(this.angle.getUnit());
		double magnitude0 = complex.magnitude();
		this.angle.setValue(Math.atan2(magnitude * Math.sin(angle) + magnitude0 * Math.sin(angle0), magnitude * Math.cos(angle) + magnitude0 * Math.cos(angle0)));
		magnitude = (float) Math.sqrt(magnitude * magnitude + magnitude0 * magnitude0 + 2 * magnitude * magnitude0 * Math.cos(angle - angle0));
		return this;
	}
	
	@Override
	public Complex multiply(Complex complex)
	{
		angle.add(complex.angle());
		magnitude *= complex.magnitude();
		return this;
	}
	
	@Override
	public Vector2f rotate(Vector2f v)
	{
		throw new UnsupportedOperationException("Not Yet Implemented");
	}
	
	@Override
	public Complex conjugate()
	{
		angle.opposite();
		return this;
	}
	
	@Override
	public Vector2f asVector()
	{
		float o = angle.asFloat();
		return Vector2f.of(magnitude * Math.cos(o), magnitude * Math.sin(o));
	}
	
	@Override
	public float r()
	{
		return magnitude * Math.cos(angle.asFloat());
	}
	
	@Override
	public float i()
	{
		return magnitude * Math.sin(angle.asFloat());
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
		float i = i();
		magnitude = Math.sqrt(r * r + i * i);
		angle.setValue(AngleUnit.RADIANS, Math.atan2(i, r));
		return this;
	}
	
	@Override
	public Complex setI(float i)
	{
		float r = r();
		magnitude = Math.sqrt(r * r + i * i);
		angle.setValue(AngleUnit.RADIANS, Math.atan2(i, r));
		return this;
	}
}
*/
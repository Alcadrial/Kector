package com.alcadrial.kector.vector.complex;

/*
public class ImmutablePolarComplex implements Complex {
	
	private final float magnitude;
	private final Angle angle;
	
	public ImmutablePolarComplex(float magnitude, Angle angle)
	{
		this.magnitude = magnitude;
		this.angle = Angle.copyOf(angle);
	}
	
	public ImmutablePolarComplex(Vector2f vector, AngleUnit unit)
	{
		magnitude = vector.x();
		angle = Angle.of(vector.y(), unit);
	}
	
	private ImmutablePolarComplex(float magnitude, Angle angle, boolean placeholder)
	{
		this.magnitude = magnitude;
		this.angle = Angle.copyOf(angle);
	}
	
	public ImmutablePolarComplex(Complex complex)
	{
		magnitude = complex.magnitude();
		angle = Angle.copyOf(complex.angle());
	}
	
	@Override
	public Complex add(Complex complex)
	{
		double angle = this.angle.asDouble();
		double angle0 = complex.angle().asDouble(this.angle.getUnit());
		double magnitude0 = complex.magnitude();
		Angle angle1 = Angle.of(Math.atan2(magnitude * Math.sin(angle) + magnitude0 * Math.sin(angle0), magnitude * Math.cos(angle) + magnitude0 * Math.cos(angle0)), this.angle.getUnit());
		float magnitude1 = (float) Math.sqrt(magnitude * magnitude + magnitude0 * magnitude0 + 2 * magnitude * magnitude0 * Math.cos(angle - angle0));
		return new ImmutablePolarComplex(magnitude1, angle1, true);
	}
	
	@Override
	public Complex multiply(Complex complex)
	{
		return new ImmutablePolarComplex(magnitude * complex.magnitude(), Angle.of(angle.asDouble() + complex.angle(angle.getUnit()), angle.getUnit()), true);
	}
	
	@Override
	public Vector2f rotate(Vector2f v)
	{
		throw new UnsupportedOperationException("Not Yet Implemented");
	}
	
	@Override
	public Complex conjugate()
	{
		return new ImmutablePolarComplex(magnitude, Angle.of(-angle.asDouble(), angle.getUnit()), true);
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
		return new ImmutablePolarComplex(Math.sqrt(r * r + i * i), Angle.of(Math.atan2(i, r), AngleUnit.RADIANS), true);
	}
	
	@Override
	public Complex setI(float i)
	{
		float r = r();
		return new ImmutablePolarComplex(Math.sqrt(r * r + i * i), Angle.of(Math.atan2(i, r), AngleUnit.RADIANS), true);
	}
}
*/
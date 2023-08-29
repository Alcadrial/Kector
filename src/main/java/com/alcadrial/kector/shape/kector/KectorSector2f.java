package com.alcadrial.kector.shape.kector;

import com.alcadrial.kector.Math;
import com.alcadrial.kector.angle.Angle;
import com.alcadrial.kector.angle.AngleUnit;
import com.alcadrial.kector.shape.api.Sector2f;
import com.alcadrial.kector.shape.api.curve.Segment2f;
import com.alcadrial.kector.shape.kector.curve.KectorSegment2fAB;
import com.alcadrial.kector.vector.Vector2f;

public class KectorSector2f implements Sector2f {
	
	private Angle startAngle;
	private Angle angle;
	private Vector2f origin;
	private float ray;
	
	public KectorSector2f(Angle startAngle, Angle angle, Vector2f origin, float ray)
	{
		this.startAngle = Angle.copyOf(startAngle, AngleUnit.RADIANS);
		this.angle = Angle.copyOf(angle, AngleUnit.RADIANS);
		this.origin = Vector2f.copyOfImmutable(origin);
		this.ray = ray;
	}
	
	@Override
	public boolean isConvex()
	{
		return angle.asDouble() <= Math.PI;//must grant [0;2π] bound
	}
	
	@Override
	public boolean isConcave()
	{
		double value = angle.asDouble();
		return value >= Math.PI && value < 2 * Math.PI;//must grant [0;2π] bound
	}
	
	@Override
	public float getRay()
	{
		return ray;
	}
	
	@Override
	public Angle getAngle()
	{
		return Angle.copyOf(angle);
	}
	
	@Override
	public Angle getStartAngle()
	{
		return Angle.copyOf(startAngle);
	}
	
	@Override
	public Angle getEndAngle()
	{
		return Angle.copyOf(angle).add(startAngle);
	}
	
	@Override
	public Vector2f getOrigin()
	{
		return origin;
	}
	
	@Override
	public Vector2f getA()
	{
		return Vector2f.of(ray, 0).rotate(getEndAngle()).add(origin);
	}
	
	@Override
	public Vector2f getB()
	{
		return Vector2f.of(ray, 0).rotate(startAngle).add(origin);
	}
	
	@Override
	public Segment2f getOASegment()
	{
		return new KectorSegment2fAB(origin, getA());
	}
	
	@Override
	public Segment2f getOBSegment()
	{
		return new KectorSegment2fAB(origin, getB());
	}
	
	@Override
	public float getPerimeter()
	{
		return (2 + angle.asFloat()) * ray;
	}
	
	@Override
	public float getArea()
	{
		return ray * ray * angle.asFloat() / 2;
	}
	
	@Override
	public Angle getAnglesSum()
	{
		return angle.add(Angle.PI_RAD);
	}
}

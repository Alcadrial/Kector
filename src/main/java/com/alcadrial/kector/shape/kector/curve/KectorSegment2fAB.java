package com.alcadrial.kector.shape.kector.curve;

import com.alcadrial.kector.angle.Angle;
import com.alcadrial.kector.angle.AngleUnit;
import com.alcadrial.kector.shape.api.curve.Segment2f;
import com.alcadrial.kector.vector.Vector2f;

public class KectorSegment2fAB implements Segment2f {
	
	private Vector2f a;
	private Vector2f b;
	
	public KectorSegment2fAB(Vector2f a, Vector2f b)
	{
		this.a = Vector2f.copyOfImmutable(a);
		this.b = Vector2f.copyOfImmutable(b);
	}
	
	@Override
	public Vector2f getA()
	{
		return a;
	}
	
	@Override
	public Vector2f getB()
	{
		return b;
	}
	
	@Override
	public Angle getAngle()
	{
		return Angle.of(Math.atan2(b.y() - a.y(), b.x() - a.x()), AngleUnit.RADIANS);
	}
	
	@Override
	public float getLength()
	{
		return (float) b.subtract(a).length();
	}
}

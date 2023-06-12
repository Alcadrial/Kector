package com.alcadrial.kector.shape.bidimensional;

import com.alcadrial.kector.Math;
import com.alcadrial.kector.angle.Angle;
import com.alcadrial.kector.angle.AngleUnit;
import com.alcadrial.kector.point.Point2f;
import com.alcadrial.kector.vector.Vector2f;

public class Line2f {
	
	private Angle angle;
	private float translation;
	
	public Line2f(Point2f a, Point2f b)
	{
		float dx = a.getX() - b.getX();
		angle = Angle.of(Math.atan2(a.getY() - b.getY(), dx), AngleUnit.RADIANS);
		translation = (a.getX() * b.getY() - a.getY() * b.getX()) / dx;
	}
	
	public Line2f(Vector2f a, Vector2f b)
	{
		float dx = a.x() - b.x();
		angle = Angle.of(Math.atan2(a.y() - b.y(), dx), AngleUnit.RADIANS);
		translation = (a.x() * b.y() - a.y() * b.x()) / dx;
	}
	
	public Line2f(Angle angle, float translation)
	{
		this.angle = angle;
		this.translation = translation;
	}
	
	public boolean contains(Point2f point)
	{
		if (angle.asFloat(AngleUnit.TURNS) == 1) return point.getX() == translation;
		return getY(point.getX()) == point.getY();
	}
	
	public boolean contains(Vector2f point)
	{
		if (angle.asFloat(AngleUnit.TURNS) == 1) return point.x() == translation;
		return getY(point.x()) == point.y();
	}
	
	public float getY(float x)
	{
		if (angle.asFloat(AngleUnit.TURNS) == 1) return 0;
		return (float) (Math.tan(angle.asDouble(AngleUnit.RADIANS)) * x + translation);
	}
	
	public Angle getAngle()
	{
		return angle;
	}
	
	public float getTranslation()
	{
		return translation;
	}
}

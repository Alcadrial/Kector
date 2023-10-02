package com.alcadrial.kector.shape.kector.curve;

import com.alcadrial.kector.Math;
import com.alcadrial.kector.angle.Angle;
import com.alcadrial.kector.angle.AngleUnit;
import com.alcadrial.kector.point.Point2f;
import com.alcadrial.kector.shape.api.ImplementationSpecialization;
import com.alcadrial.kector.shape.api.curve.Line2f;
import com.alcadrial.kector.vector.Vector2f;

public class KectorLine2fAngle implements Line2f {
	
	private Angle angle;
	private float translation;
	
	public KectorLine2fAngle(Point2f a, Point2f b)
	{
		float dx = a.getX() - b.getX();
		angle = Angle.of(Math.atan2(a.getY() - b.getY(), dx), AngleUnit.RADIANS);
		translation = (a.getX() * b.getY() - a.getY() * b.getX()) / dx;
	}
	
	public KectorLine2fAngle(Vector2f a, Vector2f b)
	{
		float dx = a.x() - b.x();
		angle = Angle.of(Math.atan2(a.y() - b.y(), dx), AngleUnit.RADIANS);
		translation = (a.x() * b.y() - a.y() * b.x()) / dx;
	}
	
	public KectorLine2fAngle(Angle angle, float translation)
	{
		this.angle = Angle.copyOf(angle, AngleUnit.RADIANS);
		this.translation = translation;
	}
	
	public boolean contains(Point2f point)
	{
		if (angle.asFloat(AngleUnit.TURNS) == 0.25) return point.getX() == translation;
		return getY(point.getX()) == point.getY();
	}
	
	public boolean contains(Vector2f point)
	{
		if (angle.asFloat(AngleUnit.TURNS) == 0.25) return point.x() == translation;
		return getY(point.x()) == point.y();
	}
	
	@Override
	public float getX(float y)
	{
		if (angle.asFloat(AngleUnit.TURNS) == 0)
		{
			if (getHorizontalTranslation() == y) return 0;
			return Float.NaN;
		}
		return (float) (Math.cotan(angle.asDouble()) * y + getHorizontalTranslation());
	}
	
	@Override
	public float getY(float x)
	{
		if (angle.asFloat(AngleUnit.TURNS) == 0.25)
		{
			if (getVerticalTranslation() == x) return 0;
			return Float.NaN;
		}
		return (float) (Math.tan(angle.asDouble()) * x + getVerticalTranslation());
	}
	
	@Override
	public Angle getAngle()
	{
		return angle;
	}
	
	@Override
	public float getAngularCoefficient()
	{
		return Math.tan(angle.asFloat());
	}
	
	public float getTranslation()
	{
		return translation;
	}
	
	@Override
	public float getHorizontalTranslation()
	{
		if (angle.asFloat(AngleUnit.TURNS) == 0.25) return translation;
		return 0;
	}
	
	@Override
	public float getVerticalTranslation()
	{
		if (angle.asFloat(AngleUnit.TURNS) == 0.25) return 0;
		return translation;
	}
	
	@Override
	public ImplementationSpecialization getAngleSpecialization()
	{
		return ImplementationSpecialization.ANGLE;
	}
}

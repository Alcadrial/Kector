package com.alcadrial.kector.shape.kector.curve;

import com.alcadrial.kector.Math;
import com.alcadrial.kector.angle.Angle;
import com.alcadrial.kector.angle.AngleUnit;
import com.alcadrial.kector.point.Point2f;
import com.alcadrial.kector.shape.api.ImplementationSpecialization;
import com.alcadrial.kector.shape.api.curve.Line2f;
import com.alcadrial.kector.vector.Vector2f;

public class KectorLine2fLinear implements Line2f {
	
	private float angularCoefficient;
	private float translation;
	
	public KectorLine2fLinear(Point2f a, Point2f b)
	{
		float dx = a.getX() - b.getX();
		angularCoefficient = (a.getY() - b.getY()) / dx;
		translation = (a.getX() * b.getY() - a.getY() * b.getX()) / dx;
	}
	
	public KectorLine2fLinear(Vector2f a, Vector2f b)
	{
		float dx = a.x() - b.x();
		angularCoefficient = (a.y() - b.y()) / dx;
		translation = (a.x() * b.y() - a.y() * b.x()) / dx;
	}
	
	public KectorLine2fLinear(float angularCoefficient, float translation)
	{
		this.angularCoefficient = angularCoefficient;
		this.translation = translation;
	}
	
	public boolean contains(Point2f point)
	{
		if (Float.isInfinite(angularCoefficient)) return point.getX() == translation;
		return getY(point.getX()) == point.getY();
	}
	
	public boolean contains(Vector2f point)
	{
		if (Float.isInfinite(angularCoefficient)) return point.x() == translation;
		return getY(point.x()) == point.y();
	}
	
	@Override
	public float getY(float x)
	{
		if (Float.isInfinite(angularCoefficient))
		{
			if (translation == x) return 0;
			return Float.NaN;
		}
		return angularCoefficient * x + translation;
	}
	
	@Override
	public Angle getAngle()
	{
		return Angle.of(Math.atan(angularCoefficient), AngleUnit.RADIANS);
	}
	
	@Override
	public float getAngularCoefficient()
	{
		return angularCoefficient;
	}
	
	public float getTranslation()
	{
		return translation;
	}
	
	@Override
	public float getHorizontalTranslation()
	{
		if (Float.isInfinite(angularCoefficient)) return translation;
		return 0;
	}
	
	@Override
	public float getVerticalTranslation()
	{
		if (Float.isInfinite(angularCoefficient)) return 0;
		return translation;
	}
	
	@Override
	public ImplementationSpecialization getAngleSpecialization()
	{
		return ImplementationSpecialization.CONSTANT;
	}
}

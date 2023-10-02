package com.alcadrial.kector.shape.kector.curve;

import com.alcadrial.kector.Math;
import com.alcadrial.kector.angle.Angle;
import com.alcadrial.kector.angle.AngleUnit;
import com.alcadrial.kector.misc.Direction1f;
import com.alcadrial.kector.shape.api.ImplementationSpecialization;
import com.alcadrial.kector.shape.api.curve.SemiLine2f;
import com.alcadrial.kector.vector.Vector2f;

public class KectorSemiLine2fConstant implements SemiLine2f {
	
	private Vector2f origin;
	private float angularCoefficient;
	private Direction1f direction;
	
	public KectorSemiLine2fConstant(Vector2f origin, float angularCoefficient, Direction1f direction)
	{
		this.origin = origin;
		this.angularCoefficient = angularCoefficient;
		this.direction = direction;
	}
	
	@Override
	public Angle getAngle()
	{
		return Angle.of(Math.tan(angularCoefficient), AngleUnit.RADIANS);
	}
	
	@Override
	public float getAngularCoefficient()
	{
		return angularCoefficient;
	}
	
	@Override
	public Vector2f getOrigin()
	{
		return origin;
	}
	
	@Override
	public Direction1f getXDirection()
	{
		return direction;
	}
	
	@Override
	public Direction1f getYDirection()
	{
		return Direction1f.of(angularCoefficient > 0);
	}
	
	@Override
	public ImplementationSpecialization getAngleSpecialization()
	{
		return ImplementationSpecialization.ANGLE;
	}
}

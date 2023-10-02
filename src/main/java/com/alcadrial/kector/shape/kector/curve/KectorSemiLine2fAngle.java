package com.alcadrial.kector.shape.kector.curve;

import com.alcadrial.kector.Math;
import com.alcadrial.kector.angle.Angle;
import com.alcadrial.kector.misc.Direction1f;
import com.alcadrial.kector.shape.api.ImplementationSpecialization;
import com.alcadrial.kector.shape.api.curve.SemiLine2f;
import com.alcadrial.kector.vector.Vector2f;

public class KectorSemiLine2fAngle implements SemiLine2f {
	
	private Angle angle;
	private Vector2f origin;
	
	public KectorSemiLine2fAngle(Angle angle, Vector2f origin)
	{
		this.angle = angle;
		this.origin = origin;
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
	
	@Override
	public Direction1f getXDirection()
	{
		return Direction1f.of(angle.between(Angle.NEGATIVE_HALF_PI_RAD, Angle.HALF_PI_RAD));
	}
	
	@Override
	public Direction1f getYDirection()
	{
		return Direction1f.of(angle.between(Angle.HALF_PI_RAD, Angle.NEGATIVE_HALF_PI_RAD));
	}
	
	@Override
	public Vector2f getOrigin()
	{
		return origin;
	}
	
	@Override
	public ImplementationSpecialization getAngleSpecialization()
	{
		return ImplementationSpecialization.ANGLE;
	}
}

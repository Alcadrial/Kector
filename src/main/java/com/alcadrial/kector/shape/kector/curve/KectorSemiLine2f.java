package com.alcadrial.kector.shape.kector.curve;

import com.alcadrial.kector.angle.Angle;
import com.alcadrial.kector.shape.api.curve.SemiLine2f;
import com.alcadrial.kector.vector.Vector2f;

public class KectorSemiLine2f implements SemiLine2f {
	
	private Angle angle;
	private Vector2f origin;
	
	public KectorSemiLine2f(Angle angle, Vector2f origin)
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
	public Vector2f getOrigin()
	{
		return origin;
	}
}

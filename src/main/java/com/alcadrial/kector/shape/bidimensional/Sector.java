package com.alcadrial.kector.shape.bidimensional;

import com.alcadrial.kector.angle.Angle;

public class Sector {
	
	private Angle angle;
	private float ray;
	
	public Sector(Angle angle, float ray)
	{
		this.angle = angle;
		this.ray = ray;
	}
	
	public Angle getAngle()
	{
		return angle;
	}
	
	public float getRay()
	{
		return ray;
	}
}

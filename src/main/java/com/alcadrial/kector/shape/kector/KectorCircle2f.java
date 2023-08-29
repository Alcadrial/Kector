package com.alcadrial.kector.shape.kector;

import com.alcadrial.kector.Math;
import com.alcadrial.kector.shape.api.Circle2f;
import com.alcadrial.kector.vector.Vector2f;

public class KectorCircle2f implements Circle2f {
	
	private float ray;
	private Vector2f origin;
	
	public KectorCircle2f(float ray, Vector2f origin)
	{
		this.ray = ray;
		this.origin = Vector2f.copyOfImmutable(origin);
	}
	
	@Override
	public boolean isConvex()
	{
		return true;
	}
	
	@Override
	public boolean isConcave()
	{
		return false;
	}
	
	@Override
	public float getRay()
	{
		return ray;
	}
	
	@Override
	public Vector2f getOrigin()
	{
		return origin;
	}
	
	@Override
	public float getPerimeter()
	{
		return 2 * Math.PIF * ray;
	}
	
	@Override
	public float getArea()
	{
		return Math.PIF * ray * ray;
	}
}

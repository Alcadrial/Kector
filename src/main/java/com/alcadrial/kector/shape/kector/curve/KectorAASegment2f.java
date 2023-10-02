package com.alcadrial.kector.shape.kector.curve;

import com.alcadrial.kector.shape.api.curve.AASegment2f;
import com.alcadrial.kector.vector.Vector2f;

public class KectorAASegment2f implements AASegment2f {
	
	private Vector2f origin;
	private float length;
	private boolean isVertical;
	
	public KectorAASegment2f(Vector2f origin, float length, boolean isVertical)
	{
		this.origin = Vector2f.copyOfImmutable(origin);
		this.length = length;
		this.isVertical = isVertical;
	}
	
	@Override
	public Vector2f getA()
	{
		return origin;
	}
	
	@Override
	public Vector2f getB()
	{
		return isVertical ? origin.add(0, length) : origin.add(length, 0);
	}
	
	@Override
	public float getLength()
	{
		return length;
	}
	
	@Override
	public boolean isVertical()
	{
		return isVertical;
	}
	
	@Override
	public boolean isHorizontal()
	{
		return !isVertical;
	}
}

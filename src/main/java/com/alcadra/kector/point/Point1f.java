package com.alcadra.kector.point;

public class Point1f extends Point2f {
	
	public Point1f(float x)
	{
		super(x, 0);
	}
	
	@Override
	public String toString()
	{
		return "{" + getX() + "}";
	}
}

package com.alcadra.kector.point;

public class Point2f extends Point3f {
	
	public Point2f(float x, float y)
	{
		super(x, y, 0);
	}
	
	@Override
	public String toString()
	{
		return "{" + getX() + ", " + getY() + "}";
	}
}

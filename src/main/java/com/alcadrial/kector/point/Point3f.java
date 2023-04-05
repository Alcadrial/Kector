package com.alcadrial.kector.point;

public class Point3f extends Point4f {
	
	public Point3f(float x, float y, float z)
	{
		super(x, y, z, 0);
	}
	
	@Override
	public String toString()
	{
		return "{" + getX() + ", " + getY() + ", " + getZ() + "}";
	}
}

package com.alcadra.kector.point;

public class Point4f {
	
	private final float X;
	private final float Y;
	private final float Z;
	private final float W;
	
	public Point4f(float x, float y, float z, float w)
	{
		X = x;
		Y = y;
		Z = z;
		W = w;
	}
	
	public float getX()
	{
		return X;
	}
	
	public float getY()
	{
		return Y;
	}
	
	public float getZ()
	{
		return Z;
	}
	
	public float getW()
	{
		return W;
	}
	
	@Override
	public String toString()
	{
		return "{" + X + ", " + Y + ", " + Z + ", " + W + "}";
	}
}

package com.alcadrial.kector.vector.readonly;

import com.alcadrial.kector.vector.AbstractVector2d;
import com.alcadrial.kector.vector.Vector2ir;
import com.alcadrial.kector.vector.Vector2lr;
import com.alcadrial.kector.vector.Vector2fr;
import com.alcadrial.kector.vector.Vector2dr;
public class ReadOnlyVector2d extends AbstractVector2d {

	public static final ReadOnlyVector2d ZERO = new ReadOnlyVector2d(0, 0);

	protected final double x;
	protected final double y;

	public ReadOnlyVector2d(int x, int y)
	{
		this((double) x, (double) y);
	}
	public ReadOnlyVector2d(long x, long y)
	{
		this((double) x, (double) y);
	}
	public ReadOnlyVector2d(float x, float y)
	{
		this((double) x, (double) y);
	}
	public ReadOnlyVector2d(double x, double y)
	{
		this.x = x;
		this.y = y;
	}
	public ReadOnlyVector2d(Vector2ir vector)
	{
		this(vector.x(), vector.y());
	}
	public ReadOnlyVector2d(Vector2lr vector)
	{
		this(vector.x(), vector.y());
	}
	public ReadOnlyVector2d(Vector2fr vector)
	{
		this(vector.x(), vector.y());
	}
	public ReadOnlyVector2d(Vector2dr vector)
	{
		this((double) vector.x(), (double) vector.y());
	}

	public double x()
	{
		return x;
	}
	public double y()
	{
		return y;
	}
	public String toString()
	{
		StringBuilder ss = new StringBuilder(25);
		return ss.append("Vector2dr{").append(x()).append(", ").append(y()).append("}").toString();
	}
}
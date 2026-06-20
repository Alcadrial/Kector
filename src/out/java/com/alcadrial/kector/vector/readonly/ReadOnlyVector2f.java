package com.alcadrial.kector.vector.readonly;

import com.alcadrial.kector.vector.AbstractVector2f;
import com.alcadrial.kector.vector.Vector2ir;
import com.alcadrial.kector.vector.Vector2lr;
import com.alcadrial.kector.vector.Vector2fr;
import com.alcadrial.kector.vector.Vector2dr;
public class ReadOnlyVector2f extends AbstractVector2f {

	public static final ReadOnlyVector2f ZERO = new ReadOnlyVector2f(0, 0);

	protected final float x;
	protected final float y;

	public ReadOnlyVector2f(int x, int y)
	{
		this((float) x, (float) y);
	}
	public ReadOnlyVector2f(long x, long y)
	{
		this((float) x, (float) y);
	}
	public ReadOnlyVector2f(float x, float y)
	{
		this.x = x;
		this.y = y;
	}
	public ReadOnlyVector2f(double x, double y)
	{
		this((float) x, (float) y);
	}
	public ReadOnlyVector2f(Vector2ir vector)
	{
		this(vector.x(), vector.y());
	}
	public ReadOnlyVector2f(Vector2lr vector)
	{
		this(vector.x(), vector.y());
	}
	public ReadOnlyVector2f(Vector2fr vector)
	{
		this(vector.x(), vector.y());
	}
	public ReadOnlyVector2f(Vector2dr vector)
	{
		this((float) vector.x(), (float) vector.y());
	}

	public float x()
	{
		return x;
	}
	public float y()
	{
		return y;
	}
}
package com.alcadrial.kector.vector.readonly;

import com.alcadrial.kector.vector.AbstractVector3f;
import com.alcadrial.kector.vector.Vector2ir;
import com.alcadrial.kector.vector.Vector2lr;
import com.alcadrial.kector.vector.Vector2fr;
import com.alcadrial.kector.vector.Vector2dr;
import com.alcadrial.kector.vector.Vector3ir;
import com.alcadrial.kector.vector.Vector3lr;
import com.alcadrial.kector.vector.Vector3fr;
import com.alcadrial.kector.vector.Vector3dr;
public class ReadOnlyVector3f extends AbstractVector3f {

	public static final ReadOnlyVector3f ZERO = new ReadOnlyVector3f(0, 0, 0);

	protected final float x;
	protected final float y;
	protected final float z;

	public ReadOnlyVector3f(int x, int y, int z)
	{
		this((float) x, (float) y, (float) z);
	}
	public ReadOnlyVector3f(long x, long y, long z)
	{
		this((float) x, (float) y, (float) z);
	}
	public ReadOnlyVector3f(float x, float y, float z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}
	public ReadOnlyVector3f(double x, double y, double z)
	{
		this((float) x, (float) y, (float) z);
	}
	public ReadOnlyVector3f(Vector2ir vector, int z)
	{
		this(vector.x(), vector.y(), z);
	}
	public ReadOnlyVector3f(Vector2lr vector, long z)
	{
		this(vector.x(), vector.y(), z);
	}
	public ReadOnlyVector3f(Vector2fr vector, float z)
	{
		this(vector.x(), vector.y(), z);
	}
	public ReadOnlyVector3f(Vector2dr vector, double z)
	{
		this((float) vector.x(), (float) vector.y(), (float) z);
	}
	public ReadOnlyVector3f(Vector3ir vector)
	{
		this(vector.x(), vector.y(), vector.z());
	}
	public ReadOnlyVector3f(Vector3lr vector)
	{
		this(vector.x(), vector.y(), vector.z());
	}
	public ReadOnlyVector3f(Vector3fr vector)
	{
		this(vector.x(), vector.y(), vector.z());
	}
	public ReadOnlyVector3f(Vector3dr vector)
	{
		this((float) vector.x(), (float) vector.y(), (float) vector.z());
	}

	public float x()
	{
		return x;
	}
	public float y()
	{
		return y;
	}
	public float z()
	{
		return z;
	}
}
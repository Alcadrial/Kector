package com.alcadrial.kector.vector.readonly;

import com.alcadrial.kector.vector.AbstractVector3d;
import com.alcadrial.kector.vector.Vector2ir;
import com.alcadrial.kector.vector.Vector2lr;
import com.alcadrial.kector.vector.Vector2fr;
import com.alcadrial.kector.vector.Vector2dr;
import com.alcadrial.kector.vector.Vector3ir;
import com.alcadrial.kector.vector.Vector3lr;
import com.alcadrial.kector.vector.Vector3fr;
import com.alcadrial.kector.vector.Vector3dr;
public class ReadOnlyVector3d extends AbstractVector3d {

	public static final ReadOnlyVector3d ZERO = new ReadOnlyVector3d(0, 0, 0);

	protected final double x;
	protected final double y;
	protected final double z;

	public ReadOnlyVector3d(int x, int y, int z)
	{
		this((double) x, (double) y, (double) z);
	}
	public ReadOnlyVector3d(long x, long y, long z)
	{
		this((double) x, (double) y, (double) z);
	}
	public ReadOnlyVector3d(float x, float y, float z)
	{
		this((double) x, (double) y, (double) z);
	}
	public ReadOnlyVector3d(double x, double y, double z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}
	public ReadOnlyVector3d(Vector2ir vector, int z)
	{
		this(vector.x(), vector.y(), z);
	}
	public ReadOnlyVector3d(Vector2lr vector, long z)
	{
		this(vector.x(), vector.y(), z);
	}
	public ReadOnlyVector3d(Vector2fr vector, float z)
	{
		this(vector.x(), vector.y(), z);
	}
	public ReadOnlyVector3d(Vector2dr vector, double z)
	{
		this((double) vector.x(), (double) vector.y(), (double) z);
	}
	public ReadOnlyVector3d(Vector3ir vector)
	{
		this(vector.x(), vector.y(), vector.z());
	}
	public ReadOnlyVector3d(Vector3lr vector)
	{
		this(vector.x(), vector.y(), vector.z());
	}
	public ReadOnlyVector3d(Vector3fr vector)
	{
		this(vector.x(), vector.y(), vector.z());
	}
	public ReadOnlyVector3d(Vector3dr vector)
	{
		this((double) vector.x(), (double) vector.y(), (double) vector.z());
	}

	public double x()
	{
		return x;
	}
	public double y()
	{
		return y;
	}
	public double z()
	{
		return z;
	}
}
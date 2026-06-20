package com.alcadrial.kector.vector.readonly;

import com.alcadrial.kector.vector.AbstractVector4d;
import com.alcadrial.kector.vector.Vector2ir;
import com.alcadrial.kector.vector.Vector2lr;
import com.alcadrial.kector.vector.Vector2fr;
import com.alcadrial.kector.vector.Vector2dr;
import com.alcadrial.kector.vector.Vector3ir;
import com.alcadrial.kector.vector.Vector3lr;
import com.alcadrial.kector.vector.Vector3fr;
import com.alcadrial.kector.vector.Vector3dr;
import com.alcadrial.kector.vector.Vector4ir;
import com.alcadrial.kector.vector.Vector4lr;
import com.alcadrial.kector.vector.Vector4fr;
import com.alcadrial.kector.vector.Vector4dr;
public class ReadOnlyVector4d extends AbstractVector4d {

	public static final ReadOnlyVector4d ZERO = new ReadOnlyVector4d(0, 0, 0, 0);
	public static final ReadOnlyVector4d PROJECTIVE_ZERO = new ReadOnlyVector4d(0, 0, 0, 1);

	protected final double x;
	protected final double y;
	protected final double z;
	protected final double w;

	public ReadOnlyVector4d(int x, int y, int z, int w)
	{
		this((double) x, (double) y, (double) z, (double) w);
	}
	public ReadOnlyVector4d(long x, long y, long z, long w)
	{
		this((double) x, (double) y, (double) z, (double) w);
	}
	public ReadOnlyVector4d(float x, float y, float z, float w)
	{
		this((double) x, (double) y, (double) z, (double) w);
	}
	public ReadOnlyVector4d(double x, double y, double z, double w)
	{
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
	}
	public ReadOnlyVector4d(Vector2ir vector, int z, int w)
	{
		this(vector.x(), vector.y(), z, w);
	}
	public ReadOnlyVector4d(Vector2lr vector, long z, long w)
	{
		this(vector.x(), vector.y(), z, w);
	}
	public ReadOnlyVector4d(Vector2fr vector, float z, float w)
	{
		this(vector.x(), vector.y(), z, w);
	}
	public ReadOnlyVector4d(Vector2dr vector, double z, double w)
	{
		this((double) vector.x(), (double) vector.y(), (double) z, (double) w);
	}
	public ReadOnlyVector4d(Vector3ir vector, int w)
	{
		this(vector.x(), vector.y(), vector.z(), w);
	}
	public ReadOnlyVector4d(Vector3lr vector, long w)
	{
		this(vector.x(), vector.y(), vector.z(), w);
	}
	public ReadOnlyVector4d(Vector3fr vector, float w)
	{
		this(vector.x(), vector.y(), vector.z(), w);
	}
	public ReadOnlyVector4d(Vector3dr vector, double w)
	{
		this((double) vector.x(), (double) vector.y(), (double) vector.z(), (double) w);
	}
	public ReadOnlyVector4d(Vector4ir vector)
	{
		this(vector.x(), vector.y(), vector.z(), vector.w());
	}
	public ReadOnlyVector4d(Vector4lr vector)
	{
		this(vector.x(), vector.y(), vector.z(), vector.w());
	}
	public ReadOnlyVector4d(Vector4fr vector)
	{
		this(vector.x(), vector.y(), vector.z(), vector.w());
	}
	public ReadOnlyVector4d(Vector4dr vector)
	{
		this((double) vector.x(), (double) vector.y(), (double) vector.z(), (double) vector.w());
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
	public double w()
	{
		return w;
	}
}
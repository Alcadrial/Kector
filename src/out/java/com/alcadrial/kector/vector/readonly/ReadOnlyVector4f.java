package com.alcadrial.kector.vector.readonly;

import com.alcadrial.kector.vector.AbstractVector4f;
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
public class ReadOnlyVector4f extends AbstractVector4f {

	public static final ReadOnlyVector4f ZERO = new ReadOnlyVector4f(0, 0, 0, 0);
	public static final ReadOnlyVector4f PROJECTIVE_ZERO = new ReadOnlyVector4f(0, 0, 0, 1);

	protected final float x;
	protected final float y;
	protected final float z;
	protected final float w;

	public ReadOnlyVector4f(int x, int y, int z, int w)
	{
		this((float) x, (float) y, (float) z, (float) w);
	}
	public ReadOnlyVector4f(long x, long y, long z, long w)
	{
		this((float) x, (float) y, (float) z, (float) w);
	}
	public ReadOnlyVector4f(float x, float y, float z, float w)
	{
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
	}
	public ReadOnlyVector4f(double x, double y, double z, double w)
	{
		this((float) x, (float) y, (float) z, (float) w);
	}
	public ReadOnlyVector4f(Vector2ir vector, int z, int w)
	{
		this(vector.x(), vector.y(), z, w);
	}
	public ReadOnlyVector4f(Vector2lr vector, long z, long w)
	{
		this(vector.x(), vector.y(), z, w);
	}
	public ReadOnlyVector4f(Vector2fr vector, float z, float w)
	{
		this(vector.x(), vector.y(), z, w);
	}
	public ReadOnlyVector4f(Vector2dr vector, double z, double w)
	{
		this((float) vector.x(), (float) vector.y(), (float) z, (float) w);
	}
	public ReadOnlyVector4f(Vector3ir vector, int w)
	{
		this(vector.x(), vector.y(), vector.z(), w);
	}
	public ReadOnlyVector4f(Vector3lr vector, long w)
	{
		this(vector.x(), vector.y(), vector.z(), w);
	}
	public ReadOnlyVector4f(Vector3fr vector, float w)
	{
		this(vector.x(), vector.y(), vector.z(), w);
	}
	public ReadOnlyVector4f(Vector3dr vector, double w)
	{
		this((float) vector.x(), (float) vector.y(), (float) vector.z(), (float) w);
	}
	public ReadOnlyVector4f(Vector4ir vector)
	{
		this(vector.x(), vector.y(), vector.z(), vector.w());
	}
	public ReadOnlyVector4f(Vector4lr vector)
	{
		this(vector.x(), vector.y(), vector.z(), vector.w());
	}
	public ReadOnlyVector4f(Vector4fr vector)
	{
		this(vector.x(), vector.y(), vector.z(), vector.w());
	}
	public ReadOnlyVector4f(Vector4dr vector)
	{
		this((float) vector.x(), (float) vector.y(), (float) vector.z(), (float) vector.w());
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
	public float w()
	{
		return w;
	}
}
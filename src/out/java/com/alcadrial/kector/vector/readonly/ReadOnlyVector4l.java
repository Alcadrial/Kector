package com.alcadrial.kector.vector.readonly;

import java.math.RoundingMode;
import static com.alcadrial.kector.Math.*;
import com.alcadrial.kector.vector.AbstractVector4l;
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
public class ReadOnlyVector4l extends AbstractVector4l {

	public static final ReadOnlyVector4l ZERO = new ReadOnlyVector4l(0, 0, 0, 0);
	public static final ReadOnlyVector4l PROJECTIVE_ZERO = new ReadOnlyVector4l(0, 0, 0, 1);

	protected final long x;
	protected final long y;
	protected final long z;
	protected final long w;

	public ReadOnlyVector4l(int x, int y, int z, int w)
	{
		this((long) x, (long) y, (long) z, (long) w);
	}
	public ReadOnlyVector4l(long x, long y, long z, long w)
	{
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
	}
	public ReadOnlyVector4l(float x, float y, float z, float w, RoundingMode roundingMode)
	{
		this(toLong(x, roundingMode), toLong(y, roundingMode), toLong(z, roundingMode), toLong(w, roundingMode));
	}
	public ReadOnlyVector4l(double x, double y, double z, double w, RoundingMode roundingMode)
	{
		this(toLong(x, roundingMode), toLong(y, roundingMode), toLong(z, roundingMode), toLong(w, roundingMode));
	}
	public ReadOnlyVector4l(Vector2ir vector, int z, int w)
	{
		this(vector.x(), vector.y(), z, w);
	}
	public ReadOnlyVector4l(Vector2lr vector, long z, long w)
	{
		this(vector.x(), vector.y(), z, w);
	}
	public ReadOnlyVector4l(Vector2fr vector, float z, float w, RoundingMode roundingMode)
	{
		this(toLong(vector.x(), roundingMode), toLong(vector.y(), roundingMode), toLong(z, roundingMode), toLong(w, roundingMode));
	}
	public ReadOnlyVector4l(Vector2dr vector, double z, double w, RoundingMode roundingMode)
	{
		this(toLong(vector.x(), roundingMode), toLong(vector.y(), roundingMode), toLong(z, roundingMode), toLong(w, roundingMode));
	}
	public ReadOnlyVector4l(Vector3ir vector, int w)
	{
		this(vector.x(), vector.y(), vector.z(), w);
	}
	public ReadOnlyVector4l(Vector3lr vector, long w)
	{
		this(vector.x(), vector.y(), vector.z(), w);
	}
	public ReadOnlyVector4l(Vector3fr vector, float w, RoundingMode roundingMode)
	{
		this(toLong(vector.x(), roundingMode), toLong(vector.y(), roundingMode), toLong(vector.z(), roundingMode), toLong(w, roundingMode));
	}
	public ReadOnlyVector4l(Vector3dr vector, double w, RoundingMode roundingMode)
	{
		this(toLong(vector.x(), roundingMode), toLong(vector.y(), roundingMode), toLong(vector.z(), roundingMode), toLong(w, roundingMode));
	}
	public ReadOnlyVector4l(Vector4ir vector)
	{
		this(vector.x(), vector.y(), vector.z(), vector.w());
	}
	public ReadOnlyVector4l(Vector4lr vector)
	{
		this(vector.x(), vector.y(), vector.z(), vector.w());
	}
	public ReadOnlyVector4l(Vector4fr vector, RoundingMode roundingMode)
	{
		this(toLong(vector.x(), roundingMode), toLong(vector.y(), roundingMode), toLong(vector.z(), roundingMode), toLong(vector.w(), roundingMode));
	}
	public ReadOnlyVector4l(Vector4dr vector, RoundingMode roundingMode)
	{
		this(toLong(vector.x(), roundingMode), toLong(vector.y(), roundingMode), toLong(vector.z(), roundingMode), toLong(vector.w(), roundingMode));
	}

	public long x()
	{
		return x;
	}
	public long y()
	{
		return y;
	}
	public long z()
	{
		return z;
	}
	public long w()
	{
		return w;
	}
	public String toString()
	{
		StringBuilder ss = new StringBuilder(25);
		return ss.append("Vector4lr{").append(x()).append(", ").append(y()).append(", ").append(z()).append(", ").append(w()).append("}").toString();
	}
}
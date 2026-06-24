package com.alcadrial.kector.vector.readonly;

import java.math.RoundingMode;
import static com.alcadrial.kector.Math.*;
import com.alcadrial.kector.vector.AbstractVector3l;
import com.alcadrial.kector.vector.Vector2ir;
import com.alcadrial.kector.vector.Vector2lr;
import com.alcadrial.kector.vector.Vector2fr;
import com.alcadrial.kector.vector.Vector2dr;
import com.alcadrial.kector.vector.Vector3ir;
import com.alcadrial.kector.vector.Vector3lr;
import com.alcadrial.kector.vector.Vector3fr;
import com.alcadrial.kector.vector.Vector3dr;
public class ReadOnlyVector3l extends AbstractVector3l {

	public static final ReadOnlyVector3l ZERO = new ReadOnlyVector3l(0, 0, 0);

	protected final long x;
	protected final long y;
	protected final long z;

	public ReadOnlyVector3l(int x, int y, int z)
	{
		this((long) x, (long) y, (long) z);
	}
	public ReadOnlyVector3l(long x, long y, long z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}
	public ReadOnlyVector3l(float x, float y, float z, RoundingMode roundingMode)
	{
		this(toLong(x, roundingMode), toLong(y, roundingMode), toLong(z, roundingMode));
	}
	public ReadOnlyVector3l(double x, double y, double z, RoundingMode roundingMode)
	{
		this(toLong(x, roundingMode), toLong(y, roundingMode), toLong(z, roundingMode));
	}
	public ReadOnlyVector3l(Vector2ir vector, int z)
	{
		this(vector.x(), vector.y(), z);
	}
	public ReadOnlyVector3l(Vector2lr vector, long z)
	{
		this(vector.x(), vector.y(), z);
	}
	public ReadOnlyVector3l(Vector2fr vector, float z, RoundingMode roundingMode)
	{
		this(toLong(vector.x(), roundingMode), toLong(vector.y(), roundingMode), toLong(z, roundingMode));
	}
	public ReadOnlyVector3l(Vector2dr vector, double z, RoundingMode roundingMode)
	{
		this(toLong(vector.x(), roundingMode), toLong(vector.y(), roundingMode), toLong(z, roundingMode));
	}
	public ReadOnlyVector3l(Vector3ir vector)
	{
		this(vector.x(), vector.y(), vector.z());
	}
	public ReadOnlyVector3l(Vector3lr vector)
	{
		this(vector.x(), vector.y(), vector.z());
	}
	public ReadOnlyVector3l(Vector3fr vector, RoundingMode roundingMode)
	{
		this(toLong(vector.x(), roundingMode), toLong(vector.y(), roundingMode), toLong(vector.z(), roundingMode));
	}
	public ReadOnlyVector3l(Vector3dr vector, RoundingMode roundingMode)
	{
		this(toLong(vector.x(), roundingMode), toLong(vector.y(), roundingMode), toLong(vector.z(), roundingMode));
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
	public String toString()
	{
		StringBuilder ss = new StringBuilder(25);
		return ss.append("Vector3lr{").append(x()).append(", ").append(y()).append(", ").append(z()).append("}").toString();
	}
}
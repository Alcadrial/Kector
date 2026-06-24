package com.alcadrial.kector.vector.readonly;

import java.math.RoundingMode;
import static com.alcadrial.kector.Math.*;
import com.alcadrial.kector.vector.AbstractVector3i;
import com.alcadrial.kector.vector.Vector2ir;
import com.alcadrial.kector.vector.Vector2lr;
import com.alcadrial.kector.vector.Vector2fr;
import com.alcadrial.kector.vector.Vector2dr;
import com.alcadrial.kector.vector.Vector3ir;
import com.alcadrial.kector.vector.Vector3lr;
import com.alcadrial.kector.vector.Vector3fr;
import com.alcadrial.kector.vector.Vector3dr;
public class ReadOnlyVector3i extends AbstractVector3i {

	public static final ReadOnlyVector3i ZERO = new ReadOnlyVector3i(0, 0, 0);

	protected final int x;
	protected final int y;
	protected final int z;

	public ReadOnlyVector3i(int x, int y, int z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}
	public ReadOnlyVector3i(long x, long y, long z)
	{
		this((int) x, (int) y, (int) z);
	}
	public ReadOnlyVector3i(float x, float y, float z, RoundingMode roundingMode)
	{
		this(toInt(x, roundingMode), toInt(y, roundingMode), toInt(z, roundingMode));
	}
	public ReadOnlyVector3i(double x, double y, double z, RoundingMode roundingMode)
	{
		this(toInt(x, roundingMode), toInt(y, roundingMode), toInt(z, roundingMode));
	}
	public ReadOnlyVector3i(Vector2ir vector, int z)
	{
		this(vector.x(), vector.y(), z);
	}
	public ReadOnlyVector3i(Vector2lr vector, long z)
	{
		this((int) vector.x(), (int) vector.y(), (int) z);
	}
	public ReadOnlyVector3i(Vector2fr vector, float z, RoundingMode roundingMode)
	{
		this(toInt(vector.x(), roundingMode), toInt(vector.y(), roundingMode), toInt(z, roundingMode));
	}
	public ReadOnlyVector3i(Vector2dr vector, double z, RoundingMode roundingMode)
	{
		this(toInt(vector.x(), roundingMode), toInt(vector.y(), roundingMode), toInt(z, roundingMode));
	}
	public ReadOnlyVector3i(Vector3ir vector)
	{
		this(vector.x(), vector.y(), vector.z());
	}
	public ReadOnlyVector3i(Vector3lr vector)
	{
		this((int) vector.x(), (int) vector.y(), (int) vector.z());
	}
	public ReadOnlyVector3i(Vector3fr vector, RoundingMode roundingMode)
	{
		this(toInt(vector.x(), roundingMode), toInt(vector.y(), roundingMode), toInt(vector.z(), roundingMode));
	}
	public ReadOnlyVector3i(Vector3dr vector, RoundingMode roundingMode)
	{
		this(toInt(vector.x(), roundingMode), toInt(vector.y(), roundingMode), toInt(vector.z(), roundingMode));
	}

	public int x()
	{
		return x;
	}
	public int y()
	{
		return y;
	}
	public int z()
	{
		return z;
	}
	public String toString()
	{
		StringBuilder ss = new StringBuilder(25);
		return ss.append("Vector3ir{").append(x()).append(", ").append(y()).append(", ").append(z()).append("}").toString();
	}
}
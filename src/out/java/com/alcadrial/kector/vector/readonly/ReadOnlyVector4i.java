package com.alcadrial.kector.vector.readonly;

import java.math.RoundingMode;
import static com.alcadrial.kector.Math.*;
import com.alcadrial.kector.vector.AbstractVector4i;
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
public class ReadOnlyVector4i extends AbstractVector4i {

	public static final ReadOnlyVector4i ZERO = new ReadOnlyVector4i(0, 0, 0, 0);
	public static final ReadOnlyVector4i PROJECTIVE_ZERO = new ReadOnlyVector4i(0, 0, 0, 1);

	protected final int x;
	protected final int y;
	protected final int z;
	protected final int w;

	public ReadOnlyVector4i(int x, int y, int z, int w)
	{
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
	}
	public ReadOnlyVector4i(long x, long y, long z, long w)
	{
		this((int) x, (int) y, (int) z, (int) w);
	}
	public ReadOnlyVector4i(float x, float y, float z, float w, RoundingMode roundingMode)
	{
		this(toInt(x, roundingMode), toInt(y, roundingMode), toInt(z, roundingMode), toInt(w, roundingMode));
	}
	public ReadOnlyVector4i(double x, double y, double z, double w, RoundingMode roundingMode)
	{
		this(toInt(x, roundingMode), toInt(y, roundingMode), toInt(z, roundingMode), toInt(w, roundingMode));
	}
	public ReadOnlyVector4i(Vector2ir vector, int z, int w)
	{
		this(vector.x(), vector.y(), z, w);
	}
	public ReadOnlyVector4i(Vector2lr vector, long z, long w)
	{
		this((int) vector.x(), (int) vector.y(), (int) z, (int) w);
	}
	public ReadOnlyVector4i(Vector2fr vector, float z, float w, RoundingMode roundingMode)
	{
		this(toInt(vector.x(), roundingMode), toInt(vector.y(), roundingMode), toInt(z, roundingMode), toInt(w, roundingMode));
	}
	public ReadOnlyVector4i(Vector2dr vector, double z, double w, RoundingMode roundingMode)
	{
		this(toInt(vector.x(), roundingMode), toInt(vector.y(), roundingMode), toInt(z, roundingMode), toInt(w, roundingMode));
	}
	public ReadOnlyVector4i(Vector3ir vector, int w)
	{
		this(vector.x(), vector.y(), vector.z(), w);
	}
	public ReadOnlyVector4i(Vector3lr vector, long w)
	{
		this((int) vector.x(), (int) vector.y(), (int) vector.z(), (int) w);
	}
	public ReadOnlyVector4i(Vector3fr vector, float w, RoundingMode roundingMode)
	{
		this(toInt(vector.x(), roundingMode), toInt(vector.y(), roundingMode), toInt(vector.z(), roundingMode), toInt(w, roundingMode));
	}
	public ReadOnlyVector4i(Vector3dr vector, double w, RoundingMode roundingMode)
	{
		this(toInt(vector.x(), roundingMode), toInt(vector.y(), roundingMode), toInt(vector.z(), roundingMode), toInt(w, roundingMode));
	}
	public ReadOnlyVector4i(Vector4ir vector)
	{
		this(vector.x(), vector.y(), vector.z(), vector.w());
	}
	public ReadOnlyVector4i(Vector4lr vector)
	{
		this((int) vector.x(), (int) vector.y(), (int) vector.z(), (int) vector.w());
	}
	public ReadOnlyVector4i(Vector4fr vector, RoundingMode roundingMode)
	{
		this(toInt(vector.x(), roundingMode), toInt(vector.y(), roundingMode), toInt(vector.z(), roundingMode), toInt(vector.w(), roundingMode));
	}
	public ReadOnlyVector4i(Vector4dr vector, RoundingMode roundingMode)
	{
		this(toInt(vector.x(), roundingMode), toInt(vector.y(), roundingMode), toInt(vector.z(), roundingMode), toInt(vector.w(), roundingMode));
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
	public int w()
	{
		return w;
	}
	public String toString()
	{
		StringBuilder ss = new StringBuilder(25);
		return ss.append("Vector4ir{").append(x()).append(", ").append(y()).append(", ").append(z()).append(", ").append(w()).append("}").toString();
	}
}
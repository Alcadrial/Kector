package com.alcadrial.kector.vector.readonly;

import java.math.RoundingMode;
import static com.alcadrial.kector.Math.*;
import com.alcadrial.kector.vector.AbstractVector2l;
import com.alcadrial.kector.vector.Vector2ir;
import com.alcadrial.kector.vector.Vector2lr;
import com.alcadrial.kector.vector.Vector2fr;
import com.alcadrial.kector.vector.Vector2dr;
public class ReadOnlyVector2l extends AbstractVector2l {

	public static final ReadOnlyVector2l ZERO = new ReadOnlyVector2l(0, 0);

	protected final long x;
	protected final long y;

	public ReadOnlyVector2l(int x, int y)
	{
		this((long) x, (long) y);
	}
	public ReadOnlyVector2l(long x, long y)
	{
		this.x = x;
		this.y = y;
	}
	public ReadOnlyVector2l(float x, float y, RoundingMode roundingMode)
	{
		this(toLong(x, roundingMode), toLong(y, roundingMode));
	}
	public ReadOnlyVector2l(double x, double y, RoundingMode roundingMode)
	{
		this(toLong(x, roundingMode), toLong(y, roundingMode));
	}
	public ReadOnlyVector2l(Vector2ir vector)
	{
		this(vector.x(), vector.y());
	}
	public ReadOnlyVector2l(Vector2lr vector)
	{
		this(vector.x(), vector.y());
	}
	public ReadOnlyVector2l(Vector2fr vector, RoundingMode roundingMode)
	{
		this(toLong(vector.x(), roundingMode), toLong(vector.y(), roundingMode));
	}
	public ReadOnlyVector2l(Vector2dr vector, RoundingMode roundingMode)
	{
		this(toLong(vector.x(), roundingMode), toLong(vector.y(), roundingMode));
	}

	public long x()
	{
		return x;
	}
	public long y()
	{
		return y;
	}
	public String toString()
	{
		StringBuilder ss = new StringBuilder(25);
		return ss.append("Vector2lr{").append(x()).append(", ").append(y()).append("}").toString();
	}
}
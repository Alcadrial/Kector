package com.alcadrial.kector.vector.readonly;

import java.math.RoundingMode;
import static com.alcadrial.kector.Math.*;
import com.alcadrial.kector.vector.AbstractVector2i;
import com.alcadrial.kector.vector.Vector2ir;
import com.alcadrial.kector.vector.Vector2lr;
import com.alcadrial.kector.vector.Vector2fr;
import com.alcadrial.kector.vector.Vector2dr;
public class ReadOnlyVector2i extends AbstractVector2i {

	public static final ReadOnlyVector2i ZERO = new ReadOnlyVector2i(0, 0);

	protected final int x;
	protected final int y;

	public ReadOnlyVector2i(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	public ReadOnlyVector2i(long x, long y)
	{
		this((int) x, (int) y);
	}
	public ReadOnlyVector2i(float x, float y, RoundingMode roundingMode)
	{
		this(toInt(x, roundingMode), toInt(y, roundingMode));
	}
	public ReadOnlyVector2i(double x, double y, RoundingMode roundingMode)
	{
		this(toInt(x, roundingMode), toInt(y, roundingMode));
	}
	public ReadOnlyVector2i(Vector2ir vector)
	{
		this(vector.x(), vector.y());
	}
	public ReadOnlyVector2i(Vector2lr vector)
	{
		this((int) vector.x(), (int) vector.y());
	}
	public ReadOnlyVector2i(Vector2fr vector, RoundingMode roundingMode)
	{
		this(toInt(vector.x(), roundingMode), toInt(vector.y(), roundingMode));
	}
	public ReadOnlyVector2i(Vector2dr vector, RoundingMode roundingMode)
	{
		this(toInt(vector.x(), roundingMode), toInt(vector.y(), roundingMode));
	}

	public int x()
	{
		return x;
	}
	public int y()
	{
		return y;
	}
	public String toString()
	{
		StringBuilder ss = new StringBuilder(25);
		return ss.append("Vector2ir{").append(x()).append(", ").append(y()).append("}").toString();
	}
}
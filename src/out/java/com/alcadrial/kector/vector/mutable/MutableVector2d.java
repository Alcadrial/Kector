package com.alcadrial.kector.vector.mutable;

import static com.alcadrial.kector.Math.*;
import com.alcadrial.kector.vector.AbstractVector2d;
import com.alcadrial.kector.vector.Vector2d;
import com.alcadrial.kector.vector.Vector2ir;
import com.alcadrial.kector.vector.Vector2lr;
import com.alcadrial.kector.vector.Vector2fr;
import com.alcadrial.kector.vector.Vector2dr;
public class MutableVector2d extends AbstractVector2d implements Vector2d {

	protected double x;
	protected double y;

	public MutableVector2d(int x, int y)
	{
		this((double) x, (double) y);
	}
	public MutableVector2d(long x, long y)
	{
		this((double) x, (double) y);
	}
	public MutableVector2d(float x, float y)
	{
		this((double) x, (double) y);
	}
	public MutableVector2d(double x, double y)
	{
		this.x = x;
		this.y = y;
	}
	public MutableVector2d(Vector2ir vector)
	{
		this(vector.x(), vector.y());
	}
	public MutableVector2d(Vector2lr vector)
	{
		this(vector.x(), vector.y());
	}
	public MutableVector2d(Vector2fr vector)
	{
		this(vector.x(), vector.y());
	}
	public MutableVector2d(Vector2dr vector)
	{
		this((double) vector.x(), (double) vector.y());
	}

	public Vector2d add(Vector2ir vector)
	{
		return add(vector.x(), vector.y());
	}

	public Vector2d subtract(Vector2ir vector)
	{
		return subtract(vector.x(), vector.y());
	}

	public Vector2d multiply(Vector2ir vector)
	{
		return multiply(vector.x(), vector.y());
	}

	public Vector2d divide(Vector2ir vector)
	{
		return divide(vector.x(), vector.y());
	}

	public Vector2d setAll(Vector2ir vector)
	{
		return x(vector.x()).y(vector.y());
	}
	public Vector2d add(Vector2lr vector)
	{
		return add(vector.x(), vector.y());
	}
	public Vector2d add(long x, long y)
	{
		this.x += x;
		this.y += y;
		return this;
	}

	public Vector2d subtract(Vector2lr vector)
	{
		return subtract(vector.x(), vector.y());
	}
	public Vector2d subtract(long x, long y)
	{
		this.x -= x;
		this.y -= y;
		return this;
	}

	public Vector2d multiply(Vector2lr vector)
	{
		return multiply(vector.x(), vector.y());
	}
	public Vector2d multiply(long x, long y)
	{
		this.x *= x;
		this.y *= y;
		return this;
	}

	public Vector2d divide(Vector2lr vector)
	{
		return divide(vector.x(), vector.y());
	}
	public Vector2d divide(long x, long y)
	{
		this.x /= x;
		this.y /= y;
		return this;
	}

	public Vector2d setAll(Vector2lr vector)
	{
		return x(vector.x()).y(vector.y());
	}
	public Vector2d add(Vector2fr vector)
	{
		return add(vector.x(), vector.y());
	}

	public Vector2d subtract(Vector2fr vector)
	{
		return subtract(vector.x(), vector.y());
	}

	public Vector2d multiply(Vector2fr vector)
	{
		return multiply(vector.x(), vector.y());
	}

	public Vector2d divide(Vector2fr vector)
	{
		return divide(vector.x(), vector.y());
	}

	public Vector2d setAll(Vector2fr vector)
	{
		return x(vector.x()).y(vector.y());
	}
	public Vector2d add(Vector2dr vector)
	{
		return add((double) vector.x(), (double) vector.y());
	}
	public Vector2d add(double x, double y)
	{
		this.x += x;
		this.y += y;
		return this;
	}

	public Vector2d subtract(Vector2dr vector)
	{
		return subtract((double) vector.x(), (double) vector.y());
	}
	public Vector2d subtract(double x, double y)
	{
		this.x -= x;
		this.y -= y;
		return this;
	}

	public Vector2d multiply(Vector2dr vector)
	{
		return multiply((double) vector.x(), (double) vector.y());
	}
	public Vector2d multiply(double x, double y)
	{
		this.x *= x;
		this.y *= y;
		return this;
	}

	public Vector2d divide(Vector2dr vector)
	{
		return divide((double) vector.x(), (double) vector.y());
	}
	public Vector2d divide(double x, double y)
	{
		this.x /= x;
		this.y /= y;
		return this;
	}

	public Vector2d setAll(Vector2dr vector)
	{
		return x(vector.x()).y(vector.y());
	}
	public Vector2d opposite()
	{
		x = -x;
		y = -y;
		return this;
	}
	public Vector2d absolute()
	{
		x = abs(x);
		y = abs(y);
		return this;
	}
	public Vector2d conjugate()
	{
		y = -y;
		return this;
	}
	public Vector2d normalize()
	{
		return divideAll(length());
	}
	public Vector2d unitary()
	{
		return normalize();
	}

	public Vector2d addAll(long value)
	{
		return add(value, value);
	}
	public Vector2d addAll(double value)
	{
		return add(value, value);
	}
	public Vector2d subtractAll(long value)
	{
		return subtract(value, value);
	}
	public Vector2d subtractAll(double value)
	{
		return subtract(value, value);
	}
	public Vector2d multiplyAll(long value)
	{
		return multiply(value, value);
	}
	public Vector2d multiplyAll(double value)
	{
		return multiply(value, value);
	}
	public Vector2d divideAll(long value)
	{
		return divide(value, value);
	}
	public Vector2d divideAll(double value)
	{
		return divide(value, value);
	}

	public double x()
	{
		return x;
	}
	public double y()
	{
		return y;
	}
	public Vector2d setX(double x)
	{
		return x(x);
	}
	public Vector2d x(double x)
	{
		this.x = x;
		return this;
	}
	public Vector2d setY(double y)
	{
		return y(y);
	}
	public Vector2d y(double y)
	{
		this.y = y;
		return this;
	}
	public Vector2d setAll(double x, double y)
	{
		return x(x).y(y);
	}
	public String toString()
	{
		StringBuilder ss = new StringBuilder(25);
		return ss.append("Vector2d{").append(x()).append(", ").append(y()).append("}").toString();
	}
}
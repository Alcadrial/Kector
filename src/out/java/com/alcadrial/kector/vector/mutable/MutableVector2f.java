package com.alcadrial.kector.vector.mutable;

import static com.alcadrial.kector.Math.*;
import com.alcadrial.kector.vector.AbstractVector2f;
import com.alcadrial.kector.vector.Vector2f;
import com.alcadrial.kector.vector.Vector2ir;
import com.alcadrial.kector.vector.Vector2lr;
import com.alcadrial.kector.vector.Vector2fr;
import com.alcadrial.kector.vector.Vector2dr;
public class MutableVector2f extends AbstractVector2f implements Vector2f {

	protected float x;
	protected float y;

	public MutableVector2f(int x, int y)
	{
		this((float) x, (float) y);
	}
	public MutableVector2f(long x, long y)
	{
		this((float) x, (float) y);
	}
	public MutableVector2f(float x, float y)
	{
		this.x = x;
		this.y = y;
	}
	public MutableVector2f(double x, double y)
	{
		this((float) x, (float) y);
	}
	public MutableVector2f(Vector2ir vector)
	{
		this(vector.x(), vector.y());
	}
	public MutableVector2f(Vector2lr vector)
	{
		this(vector.x(), vector.y());
	}
	public MutableVector2f(Vector2fr vector)
	{
		this(vector.x(), vector.y());
	}
	public MutableVector2f(Vector2dr vector)
	{
		this((float) vector.x(), (float) vector.y());
	}

	public Vector2f add(Vector2ir vector)
	{
		return add(vector.x(), vector.y());
	}
	public Vector2f add(int x, int y)
	{
		this.x += x;
		this.y += y;
		return this;
	}

	public Vector2f subtract(Vector2ir vector)
	{
		return subtract(vector.x(), vector.y());
	}
	public Vector2f subtract(int x, int y)
	{
		this.x -= x;
		this.y -= y;
		return this;
	}

	public Vector2f multiply(Vector2ir vector)
	{
		return multiply(vector.x(), vector.y());
	}
	public Vector2f multiply(int x, int y)
	{
		this.x *= x;
		this.y *= y;
		return this;
	}

	public Vector2f divide(Vector2ir vector)
	{
		return divide(vector.x(), vector.y());
	}
	public Vector2f divide(int x, int y)
	{
		this.x /= x;
		this.y /= y;
		return this;
	}

	public Vector2f setAll(Vector2ir vector)
	{
		return x(vector.x()).y(vector.y());
	}
	public Vector2f add(Vector2lr vector)
	{
		return add(vector.x(), vector.y());
	}

	public Vector2f subtract(Vector2lr vector)
	{
		return subtract(vector.x(), vector.y());
	}

	public Vector2f multiply(Vector2lr vector)
	{
		return multiply(vector.x(), vector.y());
	}

	public Vector2f divide(Vector2lr vector)
	{
		return divide(vector.x(), vector.y());
	}

	public Vector2f setAll(Vector2lr vector)
	{
		return x(vector.x()).y(vector.y());
	}
	public Vector2f add(Vector2fr vector)
	{
		return add(vector.x(), vector.y());
	}
	public Vector2f add(float x, float y)
	{
		this.x += x;
		this.y += y;
		return this;
	}

	public Vector2f subtract(Vector2fr vector)
	{
		return subtract(vector.x(), vector.y());
	}
	public Vector2f subtract(float x, float y)
	{
		this.x -= x;
		this.y -= y;
		return this;
	}

	public Vector2f multiply(Vector2fr vector)
	{
		return multiply(vector.x(), vector.y());
	}
	public Vector2f multiply(float x, float y)
	{
		this.x *= x;
		this.y *= y;
		return this;
	}

	public Vector2f divide(Vector2fr vector)
	{
		return divide(vector.x(), vector.y());
	}
	public Vector2f divide(float x, float y)
	{
		this.x /= x;
		this.y /= y;
		return this;
	}

	public Vector2f setAll(Vector2fr vector)
	{
		return x(vector.x()).y(vector.y());
	}
	public Vector2f add(Vector2dr vector)
	{
		return add((float) vector.x(), (float) vector.y());
	}

	public Vector2f subtract(Vector2dr vector)
	{
		return subtract((float) vector.x(), (float) vector.y());
	}

	public Vector2f multiply(Vector2dr vector)
	{
		return multiply((float) vector.x(), (float) vector.y());
	}

	public Vector2f divide(Vector2dr vector)
	{
		return divide((float) vector.x(), (float) vector.y());
	}

	public Vector2f setAll(Vector2dr vector)
	{
		return x((float) vector.x()).y((float) vector.y());
	}
	public Vector2f opposite()
	{
		x = -x;
		y = -y;
		return this;
	}
	public Vector2f absolute()
	{
		x = abs(x);
		y = abs(y);
		return this;
	}
	public Vector2f conjugate()
	{
		y = -y;
		return this;
	}
	public Vector2f normalize()
	{
		return divideAll(length());
	}
	public Vector2f unitary()
	{
		return normalize();
	}

	public Vector2f addAll(int value)
	{
		return add(value, value);
	}
	public Vector2f addAll(float value)
	{
		return add(value, value);
	}
	public Vector2f subtractAll(int value)
	{
		return subtract(value, value);
	}
	public Vector2f subtractAll(float value)
	{
		return subtract(value, value);
	}
	public Vector2f multiplyAll(int value)
	{
		return multiply(value, value);
	}
	public Vector2f multiplyAll(float value)
	{
		return multiply(value, value);
	}
	public Vector2f divideAll(int value)
	{
		return divide(value, value);
	}
	public Vector2f divideAll(float value)
	{
		return divide(value, value);
	}

	public float x()
	{
		return x;
	}
	public float y()
	{
		return y;
	}
	public Vector2f setX(float x)
	{
		return x(x);
	}
	public Vector2f x(float x)
	{
		this.x = x;
		return this;
	}
	public Vector2f setY(float y)
	{
		return y(y);
	}
	public Vector2f y(float y)
	{
		this.y = y;
		return this;
	}
	public Vector2f setAll(float x, float y)
	{
		return x(x).y(y);
	}
}
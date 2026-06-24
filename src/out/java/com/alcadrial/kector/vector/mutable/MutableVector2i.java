package com.alcadrial.kector.vector.mutable;

import java.math.RoundingMode;
import static com.alcadrial.kector.Math.*;
import com.alcadrial.kector.vector.AbstractVector2i;
import com.alcadrial.kector.vector.Vector2i;
import com.alcadrial.kector.vector.Vector2ir;
import com.alcadrial.kector.vector.Vector2lr;
import com.alcadrial.kector.vector.Vector2fr;
import com.alcadrial.kector.vector.Vector2dr;
public class MutableVector2i extends AbstractVector2i implements Vector2i {

	protected int x;
	protected int y;

	public MutableVector2i(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	public MutableVector2i(long x, long y)
	{
		this((int) x, (int) y);
	}
	public MutableVector2i(float x, float y, RoundingMode roundingMode)
	{
		this(toInt(x, roundingMode), toInt(y, roundingMode));
	}
	public MutableVector2i(double x, double y, RoundingMode roundingMode)
	{
		this(toInt(x, roundingMode), toInt(y, roundingMode));
	}
	public MutableVector2i(Vector2ir vector)
	{
		this(vector.x(), vector.y());
	}
	public MutableVector2i(Vector2lr vector)
	{
		this((int) vector.x(), (int) vector.y());
	}
	public MutableVector2i(Vector2fr vector, RoundingMode roundingMode)
	{
		this(toInt(vector.x(), roundingMode), toInt(vector.y(), roundingMode));
	}
	public MutableVector2i(Vector2dr vector, RoundingMode roundingMode)
	{
		this(toInt(vector.x(), roundingMode), toInt(vector.y(), roundingMode));
	}

	public Vector2i add(Vector2ir vector)
	{
		return add(vector.x(), vector.y());
	}
	public Vector2i add(int x, int y)
	{
		this.x += x;
		this.y += y;
		return this;
	}

	public Vector2i subtract(Vector2ir vector)
	{
		return subtract(vector.x(), vector.y());
	}
	public Vector2i subtract(int x, int y)
	{
		this.x -= x;
		this.y -= y;
		return this;
	}

	public Vector2i multiply(Vector2ir vector)
	{
		return multiply(vector.x(), vector.y());
	}
	public Vector2i multiply(int x, int y)
	{
		this.x *= x;
		this.y *= y;
		return this;
	}

	public Vector2i divide(Vector2ir vector)
	{
		return divide(vector.x(), vector.y());
	}
	public Vector2i divide(int x, int y)
	{
		this.x /= x;
		this.y /= y;
		return this;
	}

	public Vector2i setAll(Vector2ir vector)
	{
		return x(vector.x()).y(vector.y());
	}
	public Vector2i add(Vector2lr vector)
	{
		return add((int) vector.x(), (int) vector.y());
	}

	public Vector2i subtract(Vector2lr vector)
	{
		return subtract((int) vector.x(), (int) vector.y());
	}

	public Vector2i multiply(Vector2lr vector)
	{
		return multiply((int) vector.x(), (int) vector.y());
	}

	public Vector2i divide(Vector2lr vector)
	{
		return divide((int) vector.x(), (int) vector.y());
	}

	public Vector2i setAll(Vector2lr vector)
	{
		return x((int) vector.x()).y((int) vector.y());
	}
	public Vector2i add(Vector2fr vector, RoundingMode roundingMode)
	{
		return add(toInt(vector.x(), roundingMode), toInt(vector.y(), roundingMode));
	}
	public Vector2i add(float x, float y, RoundingMode roundingMode)
	{
		return add(toInt(x, roundingMode), toInt(y, roundingMode));
	}

	public Vector2i subtract(Vector2fr vector, RoundingMode roundingMode)
	{
		return subtract(toInt(vector.x(), roundingMode), toInt(vector.y(), roundingMode));
	}
	public Vector2i subtract(float x, float y, RoundingMode roundingMode)
	{
		return subtract(toInt(x, roundingMode), toInt(y, roundingMode));
	}

	public Vector2i multiply(Vector2fr vector, RoundingMode roundingMode)
	{
		return multiply(toInt(vector.x(), roundingMode), toInt(vector.y(), roundingMode));
	}
	public Vector2i multiply(float x, float y, RoundingMode roundingMode)
	{
		return multiply(toInt(x, roundingMode), toInt(y, roundingMode));
	}

	public Vector2i divide(Vector2fr vector, RoundingMode roundingMode)
	{
		return divide(toInt(vector.x(), roundingMode), toInt(vector.y(), roundingMode));
	}
	public Vector2i divide(float x, float y, RoundingMode roundingMode)
	{
		return divide(toInt(x, roundingMode), toInt(y, roundingMode));
	}

	public Vector2i setAll(Vector2fr vector, RoundingMode roundingMode)
	{
		return x(toInt(vector.x(), roundingMode)).y(toInt(vector.y(), roundingMode));
	}
	public Vector2i add(Vector2dr vector, RoundingMode roundingMode)
	{
		return add(toInt(vector.x(), roundingMode), toInt(vector.y(), roundingMode));
	}

	public Vector2i subtract(Vector2dr vector, RoundingMode roundingMode)
	{
		return subtract(toInt(vector.x(), roundingMode), toInt(vector.y(), roundingMode));
	}

	public Vector2i multiply(Vector2dr vector, RoundingMode roundingMode)
	{
		return multiply(toInt(vector.x(), roundingMode), toInt(vector.y(), roundingMode));
	}

	public Vector2i divide(Vector2dr vector, RoundingMode roundingMode)
	{
		return divide(toInt(vector.x(), roundingMode), toInt(vector.y(), roundingMode));
	}

	public Vector2i setAll(Vector2dr vector, RoundingMode roundingMode)
	{
		return x(toInt(vector.x(), roundingMode)).y(toInt(vector.y(), roundingMode));
	}
	public Vector2i opposite()
	{
		x = -x;
		y = -y;
		return this;
	}
	public Vector2i absolute()
	{
		x = abs(x);
		y = abs(y);
		return this;
	}
	public Vector2i conjugate()
	{
		y = -y;
		return this;
	}
	public Vector2i normalize()
	{
		int a = abs(x()), b;
		int i = 0;
		b = abs(y());
		if (a < b)
		{
			a = b;
			i = 1;
		}
		switch (i)
		{
			case 0 -> {
				x /= a;
				y = 0;
			}
			case 1 -> {
				x = 0;
				y /= a;
			}
		}
		return this;
	}
	public Vector2i unitary()
	{
		return normalize();
	}

	public Vector2i addAll(float value, RoundingMode roundingMode)
	{
		return add(value, value, roundingMode);
	}
	public Vector2i addAll(int value)
	{
		return add(value, value);
	}
	public Vector2i subtractAll(float value, RoundingMode roundingMode)
	{
		return subtract(value, value, roundingMode);
	}
	public Vector2i subtractAll(int value)
	{
		return subtract(value, value);
	}
	public Vector2i multiplyAll(float value, RoundingMode roundingMode)
	{
		return multiply(value, value, roundingMode);
	}
	public Vector2i multiplyAll(int value)
	{
		return multiply(value, value);
	}
	public Vector2i divideAll(float value, RoundingMode roundingMode)
	{
		return divide(value, value, roundingMode);
	}
	public Vector2i divideAll(int value)
	{
		return divide(value, value);
	}

	public int x()
	{
		return x;
	}
	public int y()
	{
		return y;
	}
	public Vector2i setX(int x)
	{
		return x(x);
	}
	public Vector2i x(int x)
	{
		this.x = x;
		return this;
	}
	public Vector2i setY(int y)
	{
		return y(y);
	}
	public Vector2i y(int y)
	{
		this.y = y;
		return this;
	}
	public Vector2i setAll(int x, int y)
	{
		return x(x).y(y);
	}
	public String toString()
	{
		StringBuilder ss = new StringBuilder(25);
		return ss.append("Vector2i{").append(x()).append(", ").append(y()).append("}").toString();
	}
}
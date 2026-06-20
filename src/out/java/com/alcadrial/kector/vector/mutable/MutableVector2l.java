package com.alcadrial.kector.vector.mutable;

import java.math.RoundingMode;
import static com.alcadrial.kector.Math.*;
import com.alcadrial.kector.vector.AbstractVector2l;
import com.alcadrial.kector.vector.Vector2l;
import com.alcadrial.kector.vector.Vector2ir;
import com.alcadrial.kector.vector.Vector2lr;
import com.alcadrial.kector.vector.Vector2fr;
import com.alcadrial.kector.vector.Vector2dr;
public class MutableVector2l extends AbstractVector2l implements Vector2l {

	protected long x;
	protected long y;

	public MutableVector2l(int x, int y)
	{
		this((long) x, (long) y);
	}
	public MutableVector2l(long x, long y)
	{
		this.x = x;
		this.y = y;
	}
	public MutableVector2l(float x, float y, RoundingMode roundingMode)
	{
		this(toLong(x, roundingMode), toLong(y, roundingMode));
	}
	public MutableVector2l(double x, double y, RoundingMode roundingMode)
	{
		this(toLong(x, roundingMode), toLong(y, roundingMode));
	}
	public MutableVector2l(Vector2ir vector)
	{
		this(vector.x(), vector.y());
	}
	public MutableVector2l(Vector2lr vector)
	{
		this(vector.x(), vector.y());
	}
	public MutableVector2l(Vector2fr vector, RoundingMode roundingMode)
	{
		this(toLong(vector.x(), roundingMode), toLong(vector.y(), roundingMode));
	}
	public MutableVector2l(Vector2dr vector, RoundingMode roundingMode)
	{
		this(toLong(vector.x(), roundingMode), toLong(vector.y(), roundingMode));
	}

	public Vector2l add(Vector2ir vector)
	{
		return add(vector.x(), vector.y());
	}

	public Vector2l subtract(Vector2ir vector)
	{
		return subtract(vector.x(), vector.y());
	}

	public Vector2l multiply(Vector2ir vector)
	{
		return multiply(vector.x(), vector.y());
	}

	public Vector2l divide(Vector2ir vector)
	{
		return divide(vector.x(), vector.y());
	}

	public Vector2l setAll(Vector2ir vector)
	{
		return x(vector.x()).y(vector.y());
	}
	public Vector2l add(Vector2lr vector)
	{
		return add(vector.x(), vector.y());
	}
	public Vector2l add(long x, long y)
	{
		this.x += x;
		this.y += y;
		return this;
	}

	public Vector2l subtract(Vector2lr vector)
	{
		return subtract(vector.x(), vector.y());
	}
	public Vector2l subtract(long x, long y)
	{
		this.x -= x;
		this.y -= y;
		return this;
	}

	public Vector2l multiply(Vector2lr vector)
	{
		return multiply(vector.x(), vector.y());
	}
	public Vector2l multiply(long x, long y)
	{
		this.x *= x;
		this.y *= y;
		return this;
	}

	public Vector2l divide(Vector2lr vector)
	{
		return divide(vector.x(), vector.y());
	}
	public Vector2l divide(long x, long y)
	{
		this.x /= x;
		this.y /= y;
		return this;
	}

	public Vector2l setAll(Vector2lr vector)
	{
		return x(vector.x()).y(vector.y());
	}
	public Vector2l add(Vector2fr vector, RoundingMode roundingMode)
	{
		return add(toLong(vector.x(), roundingMode), toLong(vector.y(), roundingMode));
	}

	public Vector2l subtract(Vector2fr vector, RoundingMode roundingMode)
	{
		return subtract(toLong(vector.x(), roundingMode), toLong(vector.y(), roundingMode));
	}

	public Vector2l multiply(Vector2fr vector, RoundingMode roundingMode)
	{
		return multiply(toLong(vector.x(), roundingMode), toLong(vector.y(), roundingMode));
	}

	public Vector2l divide(Vector2fr vector, RoundingMode roundingMode)
	{
		return divide(toLong(vector.x(), roundingMode), toLong(vector.y(), roundingMode));
	}

	public Vector2l setAll(Vector2fr vector, RoundingMode roundingMode)
	{
		return x(toLong(vector.x(), roundingMode)).y(toLong(vector.y(), roundingMode));
	}
	public Vector2l add(Vector2dr vector, RoundingMode roundingMode)
	{
		return add(toLong(vector.x(), roundingMode), toLong(vector.y(), roundingMode));
	}
	public Vector2l add(double x, double y, RoundingMode roundingMode)
	{
		return add(toLong(x, roundingMode), toLong(y, roundingMode));
	}

	public Vector2l subtract(Vector2dr vector, RoundingMode roundingMode)
	{
		return subtract(toLong(vector.x(), roundingMode), toLong(vector.y(), roundingMode));
	}
	public Vector2l subtract(double x, double y, RoundingMode roundingMode)
	{
		return subtract(toLong(x, roundingMode), toLong(y, roundingMode));
	}

	public Vector2l multiply(Vector2dr vector, RoundingMode roundingMode)
	{
		return multiply(toLong(vector.x(), roundingMode), toLong(vector.y(), roundingMode));
	}
	public Vector2l multiply(double x, double y, RoundingMode roundingMode)
	{
		return multiply(toLong(x, roundingMode), toLong(y, roundingMode));
	}

	public Vector2l divide(Vector2dr vector, RoundingMode roundingMode)
	{
		return divide(toLong(vector.x(), roundingMode), toLong(vector.y(), roundingMode));
	}
	public Vector2l divide(double x, double y, RoundingMode roundingMode)
	{
		return divide(toLong(x, roundingMode), toLong(y, roundingMode));
	}

	public Vector2l setAll(Vector2dr vector, RoundingMode roundingMode)
	{
		return x(toLong(vector.x(), roundingMode)).y(toLong(vector.y(), roundingMode));
	}
	public Vector2l opposite()
	{
		x = -x;
		y = -y;
		return this;
	}
	public Vector2l absolute()
	{
		x = abs(x);
		y = abs(y);
		return this;
	}
	public Vector2l conjugate()
	{
		y = -y;
		return this;
	}
	public Vector2l normalize()
	{
		long a = abs(x()), b;
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
	public Vector2l unitary()
	{
		return normalize();
	}

	public Vector2l addAll(double value, RoundingMode roundingMode)
	{
		return add(value, value, roundingMode);
	}
	public Vector2l addAll(long value)
	{
		return add(value, value);
	}
	public Vector2l subtractAll(double value, RoundingMode roundingMode)
	{
		return subtract(value, value, roundingMode);
	}
	public Vector2l subtractAll(long value)
	{
		return subtract(value, value);
	}
	public Vector2l multiplyAll(double value, RoundingMode roundingMode)
	{
		return multiply(value, value, roundingMode);
	}
	public Vector2l multiplyAll(long value)
	{
		return multiply(value, value);
	}
	public Vector2l divideAll(double value, RoundingMode roundingMode)
	{
		return divide(value, value, roundingMode);
	}
	public Vector2l divideAll(long value)
	{
		return divide(value, value);
	}

	public long x()
	{
		return x;
	}
	public long y()
	{
		return y;
	}
	public Vector2l setX(long x)
	{
		return x(x);
	}
	public Vector2l x(long x)
	{
		this.x = x;
		return this;
	}
	public Vector2l setY(long y)
	{
		return y(y);
	}
	public Vector2l y(long y)
	{
		this.y = y;
		return this;
	}
	public Vector2l setAll(long x, long y)
	{
		return x(x).y(y);
	}
}
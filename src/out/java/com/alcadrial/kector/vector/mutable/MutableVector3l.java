package com.alcadrial.kector.vector.mutable;

import java.math.RoundingMode;
import static com.alcadrial.kector.Math.*;
import com.alcadrial.kector.vector.AbstractVector3l;
import com.alcadrial.kector.vector.Vector3l;
import com.alcadrial.kector.vector.Vector2ir;
import com.alcadrial.kector.vector.Vector2lr;
import com.alcadrial.kector.vector.Vector2fr;
import com.alcadrial.kector.vector.Vector2dr;
import com.alcadrial.kector.vector.Vector3ir;
import com.alcadrial.kector.vector.Vector3lr;
import com.alcadrial.kector.vector.Vector3fr;
import com.alcadrial.kector.vector.Vector3dr;
public class MutableVector3l extends AbstractVector3l implements Vector3l {

	protected long x;
	protected long y;
	protected long z;

	public MutableVector3l(int x, int y, int z)
	{
		this((long) x, (long) y, (long) z);
	}
	public MutableVector3l(long x, long y, long z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}
	public MutableVector3l(float x, float y, float z, RoundingMode roundingMode)
	{
		this(toLong(x, roundingMode), toLong(y, roundingMode), toLong(z, roundingMode));
	}
	public MutableVector3l(double x, double y, double z, RoundingMode roundingMode)
	{
		this(toLong(x, roundingMode), toLong(y, roundingMode), toLong(z, roundingMode));
	}
	public MutableVector3l(Vector2ir vector, int z)
	{
		this(vector.x(), vector.y(), z);
	}
	public MutableVector3l(Vector2lr vector, long z)
	{
		this(vector.x(), vector.y(), z);
	}
	public MutableVector3l(Vector2fr vector, float z, RoundingMode roundingMode)
	{
		this(toLong(vector.x(), roundingMode), toLong(vector.y(), roundingMode), toLong(z, roundingMode));
	}
	public MutableVector3l(Vector2dr vector, double z, RoundingMode roundingMode)
	{
		this(toLong(vector.x(), roundingMode), toLong(vector.y(), roundingMode), toLong(z, roundingMode));
	}
	public MutableVector3l(Vector3ir vector)
	{
		this(vector.x(), vector.y(), vector.z());
	}
	public MutableVector3l(Vector3lr vector)
	{
		this(vector.x(), vector.y(), vector.z());
	}
	public MutableVector3l(Vector3fr vector, RoundingMode roundingMode)
	{
		this(toLong(vector.x(), roundingMode), toLong(vector.y(), roundingMode), toLong(vector.z(), roundingMode));
	}
	public MutableVector3l(Vector3dr vector, RoundingMode roundingMode)
	{
		this(toLong(vector.x(), roundingMode), toLong(vector.y(), roundingMode), toLong(vector.z(), roundingMode));
	}

	public Vector3l add(Vector2ir vector)
	{
		return add(vector.x(), vector.y());
	}

	public Vector3l subtract(Vector2ir vector)
	{
		return subtract(vector.x(), vector.y());
	}

	public Vector3l multiply(Vector2ir vector)
	{
		return multiply(vector.x(), vector.y());
	}

	public Vector3l divide(Vector2ir vector)
	{
		return divide(vector.x(), vector.y());
	}

	public Vector3l setAll(Vector2ir vector)
	{
		return x(vector.x()).y(vector.y());
	}
	public Vector3l add(Vector2lr vector)
	{
		return add(vector.x(), vector.y());
	}
	public Vector3l add(long x, long y)
	{
		this.x += x;
		this.y += y;
		return this;
	}

	public Vector3l subtract(Vector2lr vector)
	{
		return subtract(vector.x(), vector.y());
	}
	public Vector3l subtract(long x, long y)
	{
		this.x -= x;
		this.y -= y;
		return this;
	}

	public Vector3l multiply(Vector2lr vector)
	{
		return multiply(vector.x(), vector.y());
	}
	public Vector3l multiply(long x, long y)
	{
		this.x *= x;
		this.y *= y;
		return this;
	}

	public Vector3l divide(Vector2lr vector)
	{
		return divide(vector.x(), vector.y());
	}
	public Vector3l divide(long x, long y)
	{
		this.x /= x;
		this.y /= y;
		return this;
	}

	public Vector3l setAll(Vector2lr vector)
	{
		return x(vector.x()).y(vector.y());
	}
	public Vector3l add(Vector2fr vector, RoundingMode roundingMode)
	{
		return add(toLong(vector.x(), roundingMode), toLong(vector.y(), roundingMode));
	}

	public Vector3l subtract(Vector2fr vector, RoundingMode roundingMode)
	{
		return subtract(toLong(vector.x(), roundingMode), toLong(vector.y(), roundingMode));
	}

	public Vector3l multiply(Vector2fr vector, RoundingMode roundingMode)
	{
		return multiply(toLong(vector.x(), roundingMode), toLong(vector.y(), roundingMode));
	}

	public Vector3l divide(Vector2fr vector, RoundingMode roundingMode)
	{
		return divide(toLong(vector.x(), roundingMode), toLong(vector.y(), roundingMode));
	}

	public Vector3l setAll(Vector2fr vector, RoundingMode roundingMode)
	{
		return x(toLong(vector.x(), roundingMode)).y(toLong(vector.y(), roundingMode));
	}
	public Vector3l add(Vector2dr vector, RoundingMode roundingMode)
	{
		return add(toLong(vector.x(), roundingMode), toLong(vector.y(), roundingMode));
	}
	public Vector3l add(double x, double y, RoundingMode roundingMode)
	{
		return add(toLong(x, roundingMode), toLong(y, roundingMode), toLong(z, roundingMode));
	}

	public Vector3l subtract(Vector2dr vector, RoundingMode roundingMode)
	{
		return subtract(toLong(vector.x(), roundingMode), toLong(vector.y(), roundingMode));
	}
	public Vector3l subtract(double x, double y, RoundingMode roundingMode)
	{
		return subtract(toLong(x, roundingMode), toLong(y, roundingMode), toLong(z, roundingMode));
	}

	public Vector3l multiply(Vector2dr vector, RoundingMode roundingMode)
	{
		return multiply(toLong(vector.x(), roundingMode), toLong(vector.y(), roundingMode));
	}
	public Vector3l multiply(double x, double y, RoundingMode roundingMode)
	{
		return multiply(toLong(x, roundingMode), toLong(y, roundingMode), toLong(z, roundingMode));
	}

	public Vector3l divide(Vector2dr vector, RoundingMode roundingMode)
	{
		return divide(toLong(vector.x(), roundingMode), toLong(vector.y(), roundingMode));
	}
	public Vector3l divide(double x, double y, RoundingMode roundingMode)
	{
		return divide(toLong(x, roundingMode), toLong(y, roundingMode), toLong(z, roundingMode));
	}

	public Vector3l setAll(Vector2dr vector, RoundingMode roundingMode)
	{
		return x(toLong(vector.x(), roundingMode)).y(toLong(vector.y(), roundingMode));
	}
	public Vector3l add(Vector3ir vector)
	{
		return add(vector.x(), vector.y(), vector.z());
	}

	public Vector3l subtract(Vector3ir vector)
	{
		return subtract(vector.x(), vector.y(), vector.z());
	}

	public Vector3l multiply(Vector3ir vector)
	{
		return multiply(vector.x(), vector.y(), vector.z());
	}

	public Vector3l divide(Vector3ir vector)
	{
		return divide(vector.x(), vector.y(), vector.z());
	}

	public Vector3l setAll(Vector3ir vector)
	{
		return x(vector.x()).y(vector.y()).z(vector.z());
	}
	public Vector3l add(Vector3lr vector)
	{
		return add(vector.x(), vector.y(), vector.z());
	}
	public Vector3l add(long x, long y, long z)
	{
		this.x += x;
		this.y += y;
		this.z += z;
		return this;
	}

	public Vector3l subtract(Vector3lr vector)
	{
		return subtract(vector.x(), vector.y(), vector.z());
	}
	public Vector3l subtract(long x, long y, long z)
	{
		this.x -= x;
		this.y -= y;
		this.z -= z;
		return this;
	}

	public Vector3l multiply(Vector3lr vector)
	{
		return multiply(vector.x(), vector.y(), vector.z());
	}
	public Vector3l multiply(long x, long y, long z)
	{
		this.x *= x;
		this.y *= y;
		this.z *= z;
		return this;
	}

	public Vector3l divide(Vector3lr vector)
	{
		return divide(vector.x(), vector.y(), vector.z());
	}
	public Vector3l divide(long x, long y, long z)
	{
		this.x /= x;
		this.y /= y;
		this.z /= z;
		return this;
	}

	public Vector3l setAll(Vector3lr vector)
	{
		return x(vector.x()).y(vector.y()).z(vector.z());
	}
	public Vector3l add(Vector3fr vector, RoundingMode roundingMode)
	{
		return add(toLong(vector.x(), roundingMode), toLong(vector.y(), roundingMode), toLong(vector.z(), roundingMode));
	}

	public Vector3l subtract(Vector3fr vector, RoundingMode roundingMode)
	{
		return subtract(toLong(vector.x(), roundingMode), toLong(vector.y(), roundingMode), toLong(vector.z(), roundingMode));
	}

	public Vector3l multiply(Vector3fr vector, RoundingMode roundingMode)
	{
		return multiply(toLong(vector.x(), roundingMode), toLong(vector.y(), roundingMode), toLong(vector.z(), roundingMode));
	}

	public Vector3l divide(Vector3fr vector, RoundingMode roundingMode)
	{
		return divide(toLong(vector.x(), roundingMode), toLong(vector.y(), roundingMode), toLong(vector.z(), roundingMode));
	}

	public Vector3l setAll(Vector3fr vector, RoundingMode roundingMode)
	{
		return x(toLong(vector.x(), roundingMode)).y(toLong(vector.y(), roundingMode)).z(toLong(vector.z(), roundingMode));
	}
	public Vector3l add(Vector3dr vector, RoundingMode roundingMode)
	{
		return add(toLong(vector.x(), roundingMode), toLong(vector.y(), roundingMode), toLong(vector.z(), roundingMode));
	}
	public Vector3l add(double x, double y, double z, RoundingMode roundingMode)
	{
		return add(toLong(x, roundingMode), toLong(y, roundingMode), toLong(z, roundingMode));
	}

	public Vector3l subtract(Vector3dr vector, RoundingMode roundingMode)
	{
		return subtract(toLong(vector.x(), roundingMode), toLong(vector.y(), roundingMode), toLong(vector.z(), roundingMode));
	}
	public Vector3l subtract(double x, double y, double z, RoundingMode roundingMode)
	{
		return subtract(toLong(x, roundingMode), toLong(y, roundingMode), toLong(z, roundingMode));
	}

	public Vector3l multiply(Vector3dr vector, RoundingMode roundingMode)
	{
		return multiply(toLong(vector.x(), roundingMode), toLong(vector.y(), roundingMode), toLong(vector.z(), roundingMode));
	}
	public Vector3l multiply(double x, double y, double z, RoundingMode roundingMode)
	{
		return multiply(toLong(x, roundingMode), toLong(y, roundingMode), toLong(z, roundingMode));
	}

	public Vector3l divide(Vector3dr vector, RoundingMode roundingMode)
	{
		return divide(toLong(vector.x(), roundingMode), toLong(vector.y(), roundingMode), toLong(vector.z(), roundingMode));
	}
	public Vector3l divide(double x, double y, double z, RoundingMode roundingMode)
	{
		return divide(toLong(x, roundingMode), toLong(y, roundingMode), toLong(z, roundingMode));
	}

	public Vector3l setAll(Vector3dr vector, RoundingMode roundingMode)
	{
		return x(toLong(vector.x(), roundingMode)).y(toLong(vector.y(), roundingMode)).z(toLong(vector.z(), roundingMode));
	}
	public Vector3l opposite()
	{
		x = -x;
		y = -y;
		z = -z;
		return this;
	}
	public Vector3l absolute()
	{
		x = abs(x);
		y = abs(y);
		z = abs(z);
		return this;
	}
	public Vector3l conjugate()
	{
		y = -y;
		z = -z;
		return this;
	}
	public Vector3l normalize()
	{
		long a = abs(x()), b;
		int i = 0;
		b = abs(y());
		if (a < b)
		{
			a = b;
			i = 1;
		}
		b = abs(z());
		if (a < b)
		{
			a = b;
			i = 2;
		}
		switch (i)
		{
			case 0 -> {
				x /= a;
				y = 0;
				z = 0;
			}
			case 1 -> {
				x = 0;
				y /= a;
				z = 0;
			}
			case 2 -> {
				x = 0;
				y = 0;
				z /= a;
			}
		}
		return this;
	}
	public Vector3l unitary()
	{
		return normalize();
	}

	public Vector3l addAll(double value, RoundingMode roundingMode)
	{
		return add(value, value, value, roundingMode);
	}
	public Vector3l addAll(long value)
	{
		return add(value, value, value);
	}
	public Vector3l subtractAll(double value, RoundingMode roundingMode)
	{
		return subtract(value, value, value, roundingMode);
	}
	public Vector3l subtractAll(long value)
	{
		return subtract(value, value, value);
	}
	public Vector3l multiplyAll(double value, RoundingMode roundingMode)
	{
		return multiply(value, value, value, roundingMode);
	}
	public Vector3l multiplyAll(long value)
	{
		return multiply(value, value, value);
	}
	public Vector3l divideAll(double value, RoundingMode roundingMode)
	{
		return divide(value, value, value, roundingMode);
	}
	public Vector3l divideAll(long value)
	{
		return divide(value, value, value);
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
	public Vector3l setX(long x)
	{
		return x(x);
	}
	public Vector3l x(long x)
	{
		this.x = x;
		return this;
	}
	public Vector3l setY(long y)
	{
		return y(y);
	}
	public Vector3l y(long y)
	{
		this.y = y;
		return this;
	}
	public Vector3l setZ(long z)
	{
		return z(z);
	}
	public Vector3l z(long z)
	{
		this.z = z;
		return this;
	}
	public Vector3l setAll(long x, long y)
	{
		return x(x).y(y);
	}
	public Vector3l setAll(long x, long y, long z)
	{
		return x(x).y(y).z(z);
	}
}
package com.alcadrial.kector.vector.mutable;

import java.math.RoundingMode;
import static com.alcadrial.kector.Math.*;
import com.alcadrial.kector.vector.AbstractVector4l;
import com.alcadrial.kector.vector.Vector4l;
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
public class MutableVector4l extends AbstractVector4l implements Vector4l {

	protected long x;
	protected long y;
	protected long z;
	protected long w;

	public MutableVector4l(int x, int y, int z, int w)
	{
		this((long) x, (long) y, (long) z, (long) w);
	}
	public MutableVector4l(long x, long y, long z, long w)
	{
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
	}
	public MutableVector4l(float x, float y, float z, float w, RoundingMode roundingMode)
	{
		this(toLong(x, roundingMode), toLong(y, roundingMode), toLong(z, roundingMode), toLong(w, roundingMode));
	}
	public MutableVector4l(double x, double y, double z, double w, RoundingMode roundingMode)
	{
		this(toLong(x, roundingMode), toLong(y, roundingMode), toLong(z, roundingMode), toLong(w, roundingMode));
	}
	public MutableVector4l(Vector2ir vector, int z, int w)
	{
		this(vector.x(), vector.y(), z, w);
	}
	public MutableVector4l(Vector2lr vector, long z, long w)
	{
		this(vector.x(), vector.y(), z, w);
	}
	public MutableVector4l(Vector2fr vector, float z, float w, RoundingMode roundingMode)
	{
		this(toLong(vector.x(), roundingMode), toLong(vector.y(), roundingMode), toLong(z, roundingMode), toLong(w, roundingMode));
	}
	public MutableVector4l(Vector2dr vector, double z, double w, RoundingMode roundingMode)
	{
		this(toLong(vector.x(), roundingMode), toLong(vector.y(), roundingMode), toLong(z, roundingMode), toLong(w, roundingMode));
	}
	public MutableVector4l(Vector3ir vector, int w)
	{
		this(vector.x(), vector.y(), vector.z(), w);
	}
	public MutableVector4l(Vector3lr vector, long w)
	{
		this(vector.x(), vector.y(), vector.z(), w);
	}
	public MutableVector4l(Vector3fr vector, float w, RoundingMode roundingMode)
	{
		this(toLong(vector.x(), roundingMode), toLong(vector.y(), roundingMode), toLong(vector.z(), roundingMode), toLong(w, roundingMode));
	}
	public MutableVector4l(Vector3dr vector, double w, RoundingMode roundingMode)
	{
		this(toLong(vector.x(), roundingMode), toLong(vector.y(), roundingMode), toLong(vector.z(), roundingMode), toLong(w, roundingMode));
	}
	public MutableVector4l(Vector4ir vector)
	{
		this(vector.x(), vector.y(), vector.z(), vector.w());
	}
	public MutableVector4l(Vector4lr vector)
	{
		this(vector.x(), vector.y(), vector.z(), vector.w());
	}
	public MutableVector4l(Vector4fr vector, RoundingMode roundingMode)
	{
		this(toLong(vector.x(), roundingMode), toLong(vector.y(), roundingMode), toLong(vector.z(), roundingMode), toLong(vector.w(), roundingMode));
	}
	public MutableVector4l(Vector4dr vector, RoundingMode roundingMode)
	{
		this(toLong(vector.x(), roundingMode), toLong(vector.y(), roundingMode), toLong(vector.z(), roundingMode), toLong(vector.w(), roundingMode));
	}

	public Vector4l add(Vector2ir vector)
	{
		return add(vector.x(), vector.y());
	}

	public Vector4l subtract(Vector2ir vector)
	{
		return subtract(vector.x(), vector.y());
	}

	public Vector4l multiply(Vector2ir vector)
	{
		return multiply(vector.x(), vector.y());
	}

	public Vector4l divide(Vector2ir vector)
	{
		return divide(vector.x(), vector.y());
	}

	public Vector4l setAll(Vector2ir vector)
	{
		return x(vector.x()).y(vector.y());
	}
	public Vector4l add(Vector2lr vector)
	{
		return add(vector.x(), vector.y());
	}
	public Vector4l add(long x, long y)
	{
		this.x += x;
		this.y += y;
		return this;
	}

	public Vector4l subtract(Vector2lr vector)
	{
		return subtract(vector.x(), vector.y());
	}
	public Vector4l subtract(long x, long y)
	{
		this.x -= x;
		this.y -= y;
		return this;
	}

	public Vector4l multiply(Vector2lr vector)
	{
		return multiply(vector.x(), vector.y());
	}
	public Vector4l multiply(long x, long y)
	{
		this.x *= x;
		this.y *= y;
		return this;
	}

	public Vector4l divide(Vector2lr vector)
	{
		return divide(vector.x(), vector.y());
	}
	public Vector4l divide(long x, long y)
	{
		this.x /= x;
		this.y /= y;
		return this;
	}

	public Vector4l setAll(Vector2lr vector)
	{
		return x(vector.x()).y(vector.y());
	}
	public Vector4l add(Vector2fr vector, RoundingMode roundingMode)
	{
		return add(toLong(vector.x(), roundingMode), toLong(vector.y(), roundingMode));
	}

	public Vector4l subtract(Vector2fr vector, RoundingMode roundingMode)
	{
		return subtract(toLong(vector.x(), roundingMode), toLong(vector.y(), roundingMode));
	}

	public Vector4l multiply(Vector2fr vector, RoundingMode roundingMode)
	{
		return multiply(toLong(vector.x(), roundingMode), toLong(vector.y(), roundingMode));
	}

	public Vector4l divide(Vector2fr vector, RoundingMode roundingMode)
	{
		return divide(toLong(vector.x(), roundingMode), toLong(vector.y(), roundingMode));
	}

	public Vector4l setAll(Vector2fr vector, RoundingMode roundingMode)
	{
		return x(toLong(vector.x(), roundingMode)).y(toLong(vector.y(), roundingMode));
	}
	public Vector4l add(Vector2dr vector, RoundingMode roundingMode)
	{
		return add(toLong(vector.x(), roundingMode), toLong(vector.y(), roundingMode));
	}
	public Vector4l add(double x, double y, RoundingMode roundingMode)
	{
		return add(toLong(x, roundingMode), toLong(y, roundingMode), toLong(z, roundingMode), toLong(w, roundingMode));
	}

	public Vector4l subtract(Vector2dr vector, RoundingMode roundingMode)
	{
		return subtract(toLong(vector.x(), roundingMode), toLong(vector.y(), roundingMode));
	}
	public Vector4l subtract(double x, double y, RoundingMode roundingMode)
	{
		return subtract(toLong(x, roundingMode), toLong(y, roundingMode), toLong(z, roundingMode), toLong(w, roundingMode));
	}

	public Vector4l multiply(Vector2dr vector, RoundingMode roundingMode)
	{
		return multiply(toLong(vector.x(), roundingMode), toLong(vector.y(), roundingMode));
	}
	public Vector4l multiply(double x, double y, RoundingMode roundingMode)
	{
		return multiply(toLong(x, roundingMode), toLong(y, roundingMode), toLong(z, roundingMode), toLong(w, roundingMode));
	}

	public Vector4l divide(Vector2dr vector, RoundingMode roundingMode)
	{
		return divide(toLong(vector.x(), roundingMode), toLong(vector.y(), roundingMode));
	}
	public Vector4l divide(double x, double y, RoundingMode roundingMode)
	{
		return divide(toLong(x, roundingMode), toLong(y, roundingMode), toLong(z, roundingMode), toLong(w, roundingMode));
	}

	public Vector4l setAll(Vector2dr vector, RoundingMode roundingMode)
	{
		return x(toLong(vector.x(), roundingMode)).y(toLong(vector.y(), roundingMode));
	}
	public Vector4l add(Vector3ir vector)
	{
		return add(vector.x(), vector.y(), vector.z());
	}

	public Vector4l subtract(Vector3ir vector)
	{
		return subtract(vector.x(), vector.y(), vector.z());
	}

	public Vector4l multiply(Vector3ir vector)
	{
		return multiply(vector.x(), vector.y(), vector.z());
	}

	public Vector4l divide(Vector3ir vector)
	{
		return divide(vector.x(), vector.y(), vector.z());
	}

	public Vector4l setAll(Vector3ir vector)
	{
		return x(vector.x()).y(vector.y()).z(vector.z());
	}
	public Vector4l add(Vector3lr vector)
	{
		return add(vector.x(), vector.y(), vector.z());
	}
	public Vector4l add(long x, long y, long z)
	{
		this.x += x;
		this.y += y;
		this.z += z;
		return this;
	}

	public Vector4l subtract(Vector3lr vector)
	{
		return subtract(vector.x(), vector.y(), vector.z());
	}
	public Vector4l subtract(long x, long y, long z)
	{
		this.x -= x;
		this.y -= y;
		this.z -= z;
		return this;
	}

	public Vector4l multiply(Vector3lr vector)
	{
		return multiply(vector.x(), vector.y(), vector.z());
	}
	public Vector4l multiply(long x, long y, long z)
	{
		this.x *= x;
		this.y *= y;
		this.z *= z;
		return this;
	}

	public Vector4l divide(Vector3lr vector)
	{
		return divide(vector.x(), vector.y(), vector.z());
	}
	public Vector4l divide(long x, long y, long z)
	{
		this.x /= x;
		this.y /= y;
		this.z /= z;
		return this;
	}

	public Vector4l setAll(Vector3lr vector)
	{
		return x(vector.x()).y(vector.y()).z(vector.z());
	}
	public Vector4l add(Vector3fr vector, RoundingMode roundingMode)
	{
		return add(toLong(vector.x(), roundingMode), toLong(vector.y(), roundingMode), toLong(vector.z(), roundingMode));
	}

	public Vector4l subtract(Vector3fr vector, RoundingMode roundingMode)
	{
		return subtract(toLong(vector.x(), roundingMode), toLong(vector.y(), roundingMode), toLong(vector.z(), roundingMode));
	}

	public Vector4l multiply(Vector3fr vector, RoundingMode roundingMode)
	{
		return multiply(toLong(vector.x(), roundingMode), toLong(vector.y(), roundingMode), toLong(vector.z(), roundingMode));
	}

	public Vector4l divide(Vector3fr vector, RoundingMode roundingMode)
	{
		return divide(toLong(vector.x(), roundingMode), toLong(vector.y(), roundingMode), toLong(vector.z(), roundingMode));
	}

	public Vector4l setAll(Vector3fr vector, RoundingMode roundingMode)
	{
		return x(toLong(vector.x(), roundingMode)).y(toLong(vector.y(), roundingMode)).z(toLong(vector.z(), roundingMode));
	}
	public Vector4l add(Vector3dr vector, RoundingMode roundingMode)
	{
		return add(toLong(vector.x(), roundingMode), toLong(vector.y(), roundingMode), toLong(vector.z(), roundingMode));
	}
	public Vector4l add(double x, double y, double z, RoundingMode roundingMode)
	{
		return add(toLong(x, roundingMode), toLong(y, roundingMode), toLong(z, roundingMode), toLong(w, roundingMode));
	}

	public Vector4l subtract(Vector3dr vector, RoundingMode roundingMode)
	{
		return subtract(toLong(vector.x(), roundingMode), toLong(vector.y(), roundingMode), toLong(vector.z(), roundingMode));
	}
	public Vector4l subtract(double x, double y, double z, RoundingMode roundingMode)
	{
		return subtract(toLong(x, roundingMode), toLong(y, roundingMode), toLong(z, roundingMode), toLong(w, roundingMode));
	}

	public Vector4l multiply(Vector3dr vector, RoundingMode roundingMode)
	{
		return multiply(toLong(vector.x(), roundingMode), toLong(vector.y(), roundingMode), toLong(vector.z(), roundingMode));
	}
	public Vector4l multiply(double x, double y, double z, RoundingMode roundingMode)
	{
		return multiply(toLong(x, roundingMode), toLong(y, roundingMode), toLong(z, roundingMode), toLong(w, roundingMode));
	}

	public Vector4l divide(Vector3dr vector, RoundingMode roundingMode)
	{
		return divide(toLong(vector.x(), roundingMode), toLong(vector.y(), roundingMode), toLong(vector.z(), roundingMode));
	}
	public Vector4l divide(double x, double y, double z, RoundingMode roundingMode)
	{
		return divide(toLong(x, roundingMode), toLong(y, roundingMode), toLong(z, roundingMode), toLong(w, roundingMode));
	}

	public Vector4l setAll(Vector3dr vector, RoundingMode roundingMode)
	{
		return x(toLong(vector.x(), roundingMode)).y(toLong(vector.y(), roundingMode)).z(toLong(vector.z(), roundingMode));
	}
	public Vector4l add(Vector4ir vector)
	{
		return add(vector.x(), vector.y(), vector.z(), vector.w());
	}

	public Vector4l subtract(Vector4ir vector)
	{
		return subtract(vector.x(), vector.y(), vector.z(), vector.w());
	}

	public Vector4l multiply(Vector4ir vector)
	{
		return multiply(vector.x(), vector.y(), vector.z(), vector.w());
	}

	public Vector4l divide(Vector4ir vector)
	{
		return divide(vector.x(), vector.y(), vector.z(), vector.w());
	}

	public Vector4l setAll(Vector4ir vector)
	{
		return x(vector.x()).y(vector.y()).z(vector.z()).w(vector.w());
	}
	public Vector4l add(Vector4lr vector)
	{
		return add(vector.x(), vector.y(), vector.z(), vector.w());
	}
	public Vector4l add(long x, long y, long z, long w)
	{
		this.x += x;
		this.y += y;
		this.z += z;
		this.w += w;
		return this;
	}

	public Vector4l subtract(Vector4lr vector)
	{
		return subtract(vector.x(), vector.y(), vector.z(), vector.w());
	}
	public Vector4l subtract(long x, long y, long z, long w)
	{
		this.x -= x;
		this.y -= y;
		this.z -= z;
		this.w -= w;
		return this;
	}

	public Vector4l multiply(Vector4lr vector)
	{
		return multiply(vector.x(), vector.y(), vector.z(), vector.w());
	}
	public Vector4l multiply(long x, long y, long z, long w)
	{
		this.x *= x;
		this.y *= y;
		this.z *= z;
		this.w *= w;
		return this;
	}

	public Vector4l divide(Vector4lr vector)
	{
		return divide(vector.x(), vector.y(), vector.z(), vector.w());
	}
	public Vector4l divide(long x, long y, long z, long w)
	{
		this.x /= x;
		this.y /= y;
		this.z /= z;
		this.w /= w;
		return this;
	}

	public Vector4l setAll(Vector4lr vector)
	{
		return x(vector.x()).y(vector.y()).z(vector.z()).w(vector.w());
	}
	public Vector4l add(Vector4fr vector, RoundingMode roundingMode)
	{
		return add(toLong(vector.x(), roundingMode), toLong(vector.y(), roundingMode), toLong(vector.z(), roundingMode), toLong(vector.w(), roundingMode));
	}

	public Vector4l subtract(Vector4fr vector, RoundingMode roundingMode)
	{
		return subtract(toLong(vector.x(), roundingMode), toLong(vector.y(), roundingMode), toLong(vector.z(), roundingMode), toLong(vector.w(), roundingMode));
	}

	public Vector4l multiply(Vector4fr vector, RoundingMode roundingMode)
	{
		return multiply(toLong(vector.x(), roundingMode), toLong(vector.y(), roundingMode), toLong(vector.z(), roundingMode), toLong(vector.w(), roundingMode));
	}

	public Vector4l divide(Vector4fr vector, RoundingMode roundingMode)
	{
		return divide(toLong(vector.x(), roundingMode), toLong(vector.y(), roundingMode), toLong(vector.z(), roundingMode), toLong(vector.w(), roundingMode));
	}

	public Vector4l setAll(Vector4fr vector, RoundingMode roundingMode)
	{
		return x(toLong(vector.x(), roundingMode)).y(toLong(vector.y(), roundingMode)).z(toLong(vector.z(), roundingMode)).w(toLong(vector.w(), roundingMode));
	}
	public Vector4l add(Vector4dr vector, RoundingMode roundingMode)
	{
		return add(toLong(vector.x(), roundingMode), toLong(vector.y(), roundingMode), toLong(vector.z(), roundingMode), toLong(vector.w(), roundingMode));
	}
	public Vector4l add(double x, double y, double z, double w, RoundingMode roundingMode)
	{
		return add(toLong(x, roundingMode), toLong(y, roundingMode), toLong(z, roundingMode), toLong(w, roundingMode));
	}

	public Vector4l subtract(Vector4dr vector, RoundingMode roundingMode)
	{
		return subtract(toLong(vector.x(), roundingMode), toLong(vector.y(), roundingMode), toLong(vector.z(), roundingMode), toLong(vector.w(), roundingMode));
	}
	public Vector4l subtract(double x, double y, double z, double w, RoundingMode roundingMode)
	{
		return subtract(toLong(x, roundingMode), toLong(y, roundingMode), toLong(z, roundingMode), toLong(w, roundingMode));
	}

	public Vector4l multiply(Vector4dr vector, RoundingMode roundingMode)
	{
		return multiply(toLong(vector.x(), roundingMode), toLong(vector.y(), roundingMode), toLong(vector.z(), roundingMode), toLong(vector.w(), roundingMode));
	}
	public Vector4l multiply(double x, double y, double z, double w, RoundingMode roundingMode)
	{
		return multiply(toLong(x, roundingMode), toLong(y, roundingMode), toLong(z, roundingMode), toLong(w, roundingMode));
	}

	public Vector4l divide(Vector4dr vector, RoundingMode roundingMode)
	{
		return divide(toLong(vector.x(), roundingMode), toLong(vector.y(), roundingMode), toLong(vector.z(), roundingMode), toLong(vector.w(), roundingMode));
	}
	public Vector4l divide(double x, double y, double z, double w, RoundingMode roundingMode)
	{
		return divide(toLong(x, roundingMode), toLong(y, roundingMode), toLong(z, roundingMode), toLong(w, roundingMode));
	}

	public Vector4l setAll(Vector4dr vector, RoundingMode roundingMode)
	{
		return x(toLong(vector.x(), roundingMode)).y(toLong(vector.y(), roundingMode)).z(toLong(vector.z(), roundingMode)).w(toLong(vector.w(), roundingMode));
	}
	public Vector4l opposite()
	{
		x = -x;
		y = -y;
		z = -z;
		w = -w;
		return this;
	}
	public Vector4l absolute()
	{
		x = abs(x);
		y = abs(y);
		z = abs(z);
		w = abs(w);
		return this;
	}
	public Vector4l conjugate()
	{
		y = -y;
		z = -z;
		w = -w;
		return this;
	}
	public Vector4l normalize()
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
		b = abs(w());
		if (a < b)
		{
			a = b;
			i = 3;
		}
		switch (i)
		{
			case 0 -> {
				x /= a;
				y = 0;
				z = 0;
				w = 0;
			}
			case 1 -> {
				x = 0;
				y /= a;
				z = 0;
				w = 0;
			}
			case 2 -> {
				x = 0;
				y = 0;
				z /= a;
				w = 0;
			}
			case 3 -> {
				x = 0;
				y = 0;
				z = 0;
				w /= a;
			}
		}
		return this;
	}
	public Vector4l unitary()
	{
		return normalize();
	}

	public Vector4l addAll(double value, RoundingMode roundingMode)
	{
		return add(value, value, value, value, roundingMode);
	}
	public Vector4l addAll(long value)
	{
		return add(value, value, value, value);
	}
	public Vector4l subtractAll(double value, RoundingMode roundingMode)
	{
		return subtract(value, value, value, value, roundingMode);
	}
	public Vector4l subtractAll(long value)
	{
		return subtract(value, value, value, value);
	}
	public Vector4l multiplyAll(double value, RoundingMode roundingMode)
	{
		return multiply(value, value, value, value, roundingMode);
	}
	public Vector4l multiplyAll(long value)
	{
		return multiply(value, value, value, value);
	}
	public Vector4l divideAll(double value, RoundingMode roundingMode)
	{
		return divide(value, value, value, value, roundingMode);
	}
	public Vector4l divideAll(long value)
	{
		return divide(value, value, value, value);
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
	public long w()
	{
		return w;
	}
	public Vector4l setX(long x)
	{
		return x(x);
	}
	public Vector4l x(long x)
	{
		this.x = x;
		return this;
	}
	public Vector4l setY(long y)
	{
		return y(y);
	}
	public Vector4l y(long y)
	{
		this.y = y;
		return this;
	}
	public Vector4l setZ(long z)
	{
		return z(z);
	}
	public Vector4l z(long z)
	{
		this.z = z;
		return this;
	}
	public Vector4l setW(long w)
	{
		return w(w);
	}
	public Vector4l w(long w)
	{
		this.w = w;
		return this;
	}
	public Vector4l setAll(long x, long y)
	{
		return x(x).y(y);
	}
	public Vector4l setAll(long x, long y, long z)
	{
		return x(x).y(y).z(z);
	}
	public Vector4l setAll(long x, long y, long z, long w)
	{
		return x(x).y(y).z(z).w(w);
	}
	public String toString()
	{
		StringBuilder ss = new StringBuilder(25);
		return ss.append("Vector4l{").append(x()).append(", ").append(y()).append(", ").append(z()).append(", ").append(w()).append("}").toString();
	}
}
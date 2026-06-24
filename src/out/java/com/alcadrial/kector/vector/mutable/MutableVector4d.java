package com.alcadrial.kector.vector.mutable;

import static com.alcadrial.kector.Math.*;
import com.alcadrial.kector.vector.AbstractVector4d;
import com.alcadrial.kector.vector.Vector4d;
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
public class MutableVector4d extends AbstractVector4d implements Vector4d {

	protected double x;
	protected double y;
	protected double z;
	protected double w;

	public MutableVector4d(int x, int y, int z, int w)
	{
		this((double) x, (double) y, (double) z, (double) w);
	}
	public MutableVector4d(long x, long y, long z, long w)
	{
		this((double) x, (double) y, (double) z, (double) w);
	}
	public MutableVector4d(float x, float y, float z, float w)
	{
		this((double) x, (double) y, (double) z, (double) w);
	}
	public MutableVector4d(double x, double y, double z, double w)
	{
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
	}
	public MutableVector4d(Vector2ir vector, int z, int w)
	{
		this(vector.x(), vector.y(), z, w);
	}
	public MutableVector4d(Vector2lr vector, long z, long w)
	{
		this(vector.x(), vector.y(), z, w);
	}
	public MutableVector4d(Vector2fr vector, float z, float w)
	{
		this(vector.x(), vector.y(), z, w);
	}
	public MutableVector4d(Vector2dr vector, double z, double w)
	{
		this((double) vector.x(), (double) vector.y(), (double) z, (double) w);
	}
	public MutableVector4d(Vector3ir vector, int w)
	{
		this(vector.x(), vector.y(), vector.z(), w);
	}
	public MutableVector4d(Vector3lr vector, long w)
	{
		this(vector.x(), vector.y(), vector.z(), w);
	}
	public MutableVector4d(Vector3fr vector, float w)
	{
		this(vector.x(), vector.y(), vector.z(), w);
	}
	public MutableVector4d(Vector3dr vector, double w)
	{
		this((double) vector.x(), (double) vector.y(), (double) vector.z(), (double) w);
	}
	public MutableVector4d(Vector4ir vector)
	{
		this(vector.x(), vector.y(), vector.z(), vector.w());
	}
	public MutableVector4d(Vector4lr vector)
	{
		this(vector.x(), vector.y(), vector.z(), vector.w());
	}
	public MutableVector4d(Vector4fr vector)
	{
		this(vector.x(), vector.y(), vector.z(), vector.w());
	}
	public MutableVector4d(Vector4dr vector)
	{
		this((double) vector.x(), (double) vector.y(), (double) vector.z(), (double) vector.w());
	}

	public Vector4d add(Vector2ir vector)
	{
		return add(vector.x(), vector.y());
	}

	public Vector4d subtract(Vector2ir vector)
	{
		return subtract(vector.x(), vector.y());
	}

	public Vector4d multiply(Vector2ir vector)
	{
		return multiply(vector.x(), vector.y());
	}

	public Vector4d divide(Vector2ir vector)
	{
		return divide(vector.x(), vector.y());
	}

	public Vector4d setAll(Vector2ir vector)
	{
		return x(vector.x()).y(vector.y());
	}
	public Vector4d add(Vector2lr vector)
	{
		return add(vector.x(), vector.y());
	}
	public Vector4d add(long x, long y)
	{
		this.x += x;
		this.y += y;
		return this;
	}

	public Vector4d subtract(Vector2lr vector)
	{
		return subtract(vector.x(), vector.y());
	}
	public Vector4d subtract(long x, long y)
	{
		this.x -= x;
		this.y -= y;
		return this;
	}

	public Vector4d multiply(Vector2lr vector)
	{
		return multiply(vector.x(), vector.y());
	}
	public Vector4d multiply(long x, long y)
	{
		this.x *= x;
		this.y *= y;
		return this;
	}

	public Vector4d divide(Vector2lr vector)
	{
		return divide(vector.x(), vector.y());
	}
	public Vector4d divide(long x, long y)
	{
		this.x /= x;
		this.y /= y;
		return this;
	}

	public Vector4d setAll(Vector2lr vector)
	{
		return x(vector.x()).y(vector.y());
	}
	public Vector4d add(Vector2fr vector)
	{
		return add(vector.x(), vector.y());
	}

	public Vector4d subtract(Vector2fr vector)
	{
		return subtract(vector.x(), vector.y());
	}

	public Vector4d multiply(Vector2fr vector)
	{
		return multiply(vector.x(), vector.y());
	}

	public Vector4d divide(Vector2fr vector)
	{
		return divide(vector.x(), vector.y());
	}

	public Vector4d setAll(Vector2fr vector)
	{
		return x(vector.x()).y(vector.y());
	}
	public Vector4d add(Vector2dr vector)
	{
		return add((double) vector.x(), (double) vector.y());
	}
	public Vector4d add(double x, double y)
	{
		this.x += x;
		this.y += y;
		return this;
	}

	public Vector4d subtract(Vector2dr vector)
	{
		return subtract((double) vector.x(), (double) vector.y());
	}
	public Vector4d subtract(double x, double y)
	{
		this.x -= x;
		this.y -= y;
		return this;
	}

	public Vector4d multiply(Vector2dr vector)
	{
		return multiply((double) vector.x(), (double) vector.y());
	}
	public Vector4d multiply(double x, double y)
	{
		this.x *= x;
		this.y *= y;
		return this;
	}

	public Vector4d divide(Vector2dr vector)
	{
		return divide((double) vector.x(), (double) vector.y());
	}
	public Vector4d divide(double x, double y)
	{
		this.x /= x;
		this.y /= y;
		return this;
	}

	public Vector4d setAll(Vector2dr vector)
	{
		return x(vector.x()).y(vector.y());
	}
	public Vector4d add(Vector3ir vector)
	{
		return add(vector.x(), vector.y(), vector.z());
	}

	public Vector4d subtract(Vector3ir vector)
	{
		return subtract(vector.x(), vector.y(), vector.z());
	}

	public Vector4d multiply(Vector3ir vector)
	{
		return multiply(vector.x(), vector.y(), vector.z());
	}

	public Vector4d divide(Vector3ir vector)
	{
		return divide(vector.x(), vector.y(), vector.z());
	}

	public Vector4d setAll(Vector3ir vector)
	{
		return x(vector.x()).y(vector.y()).z(vector.z());
	}
	public Vector4d add(Vector3lr vector)
	{
		return add(vector.x(), vector.y(), vector.z());
	}
	public Vector4d add(long x, long y, long z)
	{
		this.x += x;
		this.y += y;
		this.z += z;
		return this;
	}

	public Vector4d subtract(Vector3lr vector)
	{
		return subtract(vector.x(), vector.y(), vector.z());
	}
	public Vector4d subtract(long x, long y, long z)
	{
		this.x -= x;
		this.y -= y;
		this.z -= z;
		return this;
	}

	public Vector4d multiply(Vector3lr vector)
	{
		return multiply(vector.x(), vector.y(), vector.z());
	}
	public Vector4d multiply(long x, long y, long z)
	{
		this.x *= x;
		this.y *= y;
		this.z *= z;
		return this;
	}

	public Vector4d divide(Vector3lr vector)
	{
		return divide(vector.x(), vector.y(), vector.z());
	}
	public Vector4d divide(long x, long y, long z)
	{
		this.x /= x;
		this.y /= y;
		this.z /= z;
		return this;
	}

	public Vector4d setAll(Vector3lr vector)
	{
		return x(vector.x()).y(vector.y()).z(vector.z());
	}
	public Vector4d add(Vector3fr vector)
	{
		return add(vector.x(), vector.y(), vector.z());
	}

	public Vector4d subtract(Vector3fr vector)
	{
		return subtract(vector.x(), vector.y(), vector.z());
	}

	public Vector4d multiply(Vector3fr vector)
	{
		return multiply(vector.x(), vector.y(), vector.z());
	}

	public Vector4d divide(Vector3fr vector)
	{
		return divide(vector.x(), vector.y(), vector.z());
	}

	public Vector4d setAll(Vector3fr vector)
	{
		return x(vector.x()).y(vector.y()).z(vector.z());
	}
	public Vector4d add(Vector3dr vector)
	{
		return add((double) vector.x(), (double) vector.y(), (double) vector.z());
	}
	public Vector4d add(double x, double y, double z)
	{
		this.x += x;
		this.y += y;
		this.z += z;
		return this;
	}

	public Vector4d subtract(Vector3dr vector)
	{
		return subtract((double) vector.x(), (double) vector.y(), (double) vector.z());
	}
	public Vector4d subtract(double x, double y, double z)
	{
		this.x -= x;
		this.y -= y;
		this.z -= z;
		return this;
	}

	public Vector4d multiply(Vector3dr vector)
	{
		return multiply((double) vector.x(), (double) vector.y(), (double) vector.z());
	}
	public Vector4d multiply(double x, double y, double z)
	{
		this.x *= x;
		this.y *= y;
		this.z *= z;
		return this;
	}

	public Vector4d divide(Vector3dr vector)
	{
		return divide((double) vector.x(), (double) vector.y(), (double) vector.z());
	}
	public Vector4d divide(double x, double y, double z)
	{
		this.x /= x;
		this.y /= y;
		this.z /= z;
		return this;
	}

	public Vector4d setAll(Vector3dr vector)
	{
		return x(vector.x()).y(vector.y()).z(vector.z());
	}
	public Vector4d add(Vector4ir vector)
	{
		return add(vector.x(), vector.y(), vector.z(), vector.w());
	}

	public Vector4d subtract(Vector4ir vector)
	{
		return subtract(vector.x(), vector.y(), vector.z(), vector.w());
	}

	public Vector4d multiply(Vector4ir vector)
	{
		return multiply(vector.x(), vector.y(), vector.z(), vector.w());
	}

	public Vector4d divide(Vector4ir vector)
	{
		return divide(vector.x(), vector.y(), vector.z(), vector.w());
	}

	public Vector4d setAll(Vector4ir vector)
	{
		return x(vector.x()).y(vector.y()).z(vector.z()).w(vector.w());
	}
	public Vector4d add(Vector4lr vector)
	{
		return add(vector.x(), vector.y(), vector.z(), vector.w());
	}
	public Vector4d add(long x, long y, long z, long w)
	{
		this.x += x;
		this.y += y;
		this.z += z;
		this.w += w;
		return this;
	}

	public Vector4d subtract(Vector4lr vector)
	{
		return subtract(vector.x(), vector.y(), vector.z(), vector.w());
	}
	public Vector4d subtract(long x, long y, long z, long w)
	{
		this.x -= x;
		this.y -= y;
		this.z -= z;
		this.w -= w;
		return this;
	}

	public Vector4d multiply(Vector4lr vector)
	{
		return multiply(vector.x(), vector.y(), vector.z(), vector.w());
	}
	public Vector4d multiply(long x, long y, long z, long w)
	{
		this.x *= x;
		this.y *= y;
		this.z *= z;
		this.w *= w;
		return this;
	}

	public Vector4d divide(Vector4lr vector)
	{
		return divide(vector.x(), vector.y(), vector.z(), vector.w());
	}
	public Vector4d divide(long x, long y, long z, long w)
	{
		this.x /= x;
		this.y /= y;
		this.z /= z;
		this.w /= w;
		return this;
	}

	public Vector4d setAll(Vector4lr vector)
	{
		return x(vector.x()).y(vector.y()).z(vector.z()).w(vector.w());
	}
	public Vector4d add(Vector4fr vector)
	{
		return add(vector.x(), vector.y(), vector.z(), vector.w());
	}

	public Vector4d subtract(Vector4fr vector)
	{
		return subtract(vector.x(), vector.y(), vector.z(), vector.w());
	}

	public Vector4d multiply(Vector4fr vector)
	{
		return multiply(vector.x(), vector.y(), vector.z(), vector.w());
	}

	public Vector4d divide(Vector4fr vector)
	{
		return divide(vector.x(), vector.y(), vector.z(), vector.w());
	}

	public Vector4d setAll(Vector4fr vector)
	{
		return x(vector.x()).y(vector.y()).z(vector.z()).w(vector.w());
	}
	public Vector4d add(Vector4dr vector)
	{
		return add((double) vector.x(), (double) vector.y(), (double) vector.z(), (double) vector.w());
	}
	public Vector4d add(double x, double y, double z, double w)
	{
		this.x += x;
		this.y += y;
		this.z += z;
		this.w += w;
		return this;
	}

	public Vector4d subtract(Vector4dr vector)
	{
		return subtract((double) vector.x(), (double) vector.y(), (double) vector.z(), (double) vector.w());
	}
	public Vector4d subtract(double x, double y, double z, double w)
	{
		this.x -= x;
		this.y -= y;
		this.z -= z;
		this.w -= w;
		return this;
	}

	public Vector4d multiply(Vector4dr vector)
	{
		return multiply((double) vector.x(), (double) vector.y(), (double) vector.z(), (double) vector.w());
	}
	public Vector4d multiply(double x, double y, double z, double w)
	{
		this.x *= x;
		this.y *= y;
		this.z *= z;
		this.w *= w;
		return this;
	}

	public Vector4d divide(Vector4dr vector)
	{
		return divide((double) vector.x(), (double) vector.y(), (double) vector.z(), (double) vector.w());
	}
	public Vector4d divide(double x, double y, double z, double w)
	{
		this.x /= x;
		this.y /= y;
		this.z /= z;
		this.w /= w;
		return this;
	}

	public Vector4d setAll(Vector4dr vector)
	{
		return x(vector.x()).y(vector.y()).z(vector.z()).w(vector.w());
	}
	public Vector4d opposite()
	{
		x = -x;
		y = -y;
		z = -z;
		w = -w;
		return this;
	}
	public Vector4d absolute()
	{
		x = abs(x);
		y = abs(y);
		z = abs(z);
		w = abs(w);
		return this;
	}
	public Vector4d conjugate()
	{
		y = -y;
		z = -z;
		w = -w;
		return this;
	}
	public Vector4d normalize()
	{
		return divideAll(length());
	}
	public Vector4d unitary()
	{
		return normalize();
	}

	public Vector4d addAll(long value)
	{
		return add(value, value, value, value);
	}
	public Vector4d addAll(double value)
	{
		return add(value, value, value, value);
	}
	public Vector4d subtractAll(long value)
	{
		return subtract(value, value, value, value);
	}
	public Vector4d subtractAll(double value)
	{
		return subtract(value, value, value, value);
	}
	public Vector4d multiplyAll(long value)
	{
		return multiply(value, value, value, value);
	}
	public Vector4d multiplyAll(double value)
	{
		return multiply(value, value, value, value);
	}
	public Vector4d divideAll(long value)
	{
		return divide(value, value, value, value);
	}
	public Vector4d divideAll(double value)
	{
		return divide(value, value, value, value);
	}

	public double x()
	{
		return x;
	}
	public double y()
	{
		return y;
	}
	public double z()
	{
		return z;
	}
	public double w()
	{
		return w;
	}
	public Vector4d setX(double x)
	{
		return x(x);
	}
	public Vector4d x(double x)
	{
		this.x = x;
		return this;
	}
	public Vector4d setY(double y)
	{
		return y(y);
	}
	public Vector4d y(double y)
	{
		this.y = y;
		return this;
	}
	public Vector4d setZ(double z)
	{
		return z(z);
	}
	public Vector4d z(double z)
	{
		this.z = z;
		return this;
	}
	public Vector4d setW(double w)
	{
		return w(w);
	}
	public Vector4d w(double w)
	{
		this.w = w;
		return this;
	}
	public Vector4d setAll(double x, double y)
	{
		return x(x).y(y);
	}
	public Vector4d setAll(double x, double y, double z)
	{
		return x(x).y(y).z(z);
	}
	public Vector4d setAll(double x, double y, double z, double w)
	{
		return x(x).y(y).z(z).w(w);
	}
	public String toString()
	{
		StringBuilder ss = new StringBuilder(25);
		return ss.append("Vector4d{").append(x()).append(", ").append(y()).append(", ").append(z()).append(", ").append(w()).append("}").toString();
	}
}
package com.alcadrial.kector.vector.mutable;

import static com.alcadrial.kector.Math.*;
import com.alcadrial.kector.vector.AbstractVector3d;
import com.alcadrial.kector.vector.Vector3d;
import com.alcadrial.kector.vector.Vector2ir;
import com.alcadrial.kector.vector.Vector2lr;
import com.alcadrial.kector.vector.Vector2fr;
import com.alcadrial.kector.vector.Vector2dr;
import com.alcadrial.kector.vector.Vector3ir;
import com.alcadrial.kector.vector.Vector3lr;
import com.alcadrial.kector.vector.Vector3fr;
import com.alcadrial.kector.vector.Vector3dr;
public class MutableVector3d extends AbstractVector3d implements Vector3d {

	protected double x;
	protected double y;
	protected double z;

	public MutableVector3d(int x, int y, int z)
	{
		this((double) x, (double) y, (double) z);
	}
	public MutableVector3d(long x, long y, long z)
	{
		this((double) x, (double) y, (double) z);
	}
	public MutableVector3d(float x, float y, float z)
	{
		this((double) x, (double) y, (double) z);
	}
	public MutableVector3d(double x, double y, double z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}
	public MutableVector3d(Vector2ir vector, int z)
	{
		this(vector.x(), vector.y(), z);
	}
	public MutableVector3d(Vector2lr vector, long z)
	{
		this(vector.x(), vector.y(), z);
	}
	public MutableVector3d(Vector2fr vector, float z)
	{
		this(vector.x(), vector.y(), z);
	}
	public MutableVector3d(Vector2dr vector, double z)
	{
		this((double) vector.x(), (double) vector.y(), (double) z);
	}
	public MutableVector3d(Vector3ir vector)
	{
		this(vector.x(), vector.y(), vector.z());
	}
	public MutableVector3d(Vector3lr vector)
	{
		this(vector.x(), vector.y(), vector.z());
	}
	public MutableVector3d(Vector3fr vector)
	{
		this(vector.x(), vector.y(), vector.z());
	}
	public MutableVector3d(Vector3dr vector)
	{
		this((double) vector.x(), (double) vector.y(), (double) vector.z());
	}

	public Vector3d add(Vector2ir vector)
	{
		return add(vector.x(), vector.y());
	}

	public Vector3d subtract(Vector2ir vector)
	{
		return subtract(vector.x(), vector.y());
	}

	public Vector3d multiply(Vector2ir vector)
	{
		return multiply(vector.x(), vector.y());
	}

	public Vector3d divide(Vector2ir vector)
	{
		return divide(vector.x(), vector.y());
	}

	public Vector3d setAll(Vector2ir vector)
	{
		return x(vector.x()).y(vector.y());
	}
	public Vector3d add(Vector2lr vector)
	{
		return add(vector.x(), vector.y());
	}
	public Vector3d add(long x, long y)
	{
		this.x += x;
		this.y += y;
		return this;
	}

	public Vector3d subtract(Vector2lr vector)
	{
		return subtract(vector.x(), vector.y());
	}
	public Vector3d subtract(long x, long y)
	{
		this.x -= x;
		this.y -= y;
		return this;
	}

	public Vector3d multiply(Vector2lr vector)
	{
		return multiply(vector.x(), vector.y());
	}
	public Vector3d multiply(long x, long y)
	{
		this.x *= x;
		this.y *= y;
		return this;
	}

	public Vector3d divide(Vector2lr vector)
	{
		return divide(vector.x(), vector.y());
	}
	public Vector3d divide(long x, long y)
	{
		this.x /= x;
		this.y /= y;
		return this;
	}

	public Vector3d setAll(Vector2lr vector)
	{
		return x(vector.x()).y(vector.y());
	}
	public Vector3d add(Vector2fr vector)
	{
		return add(vector.x(), vector.y());
	}

	public Vector3d subtract(Vector2fr vector)
	{
		return subtract(vector.x(), vector.y());
	}

	public Vector3d multiply(Vector2fr vector)
	{
		return multiply(vector.x(), vector.y());
	}

	public Vector3d divide(Vector2fr vector)
	{
		return divide(vector.x(), vector.y());
	}

	public Vector3d setAll(Vector2fr vector)
	{
		return x(vector.x()).y(vector.y());
	}
	public Vector3d add(Vector2dr vector)
	{
		return add((double) vector.x(), (double) vector.y());
	}
	public Vector3d add(double x, double y)
	{
		this.x += x;
		this.y += y;
		return this;
	}

	public Vector3d subtract(Vector2dr vector)
	{
		return subtract((double) vector.x(), (double) vector.y());
	}
	public Vector3d subtract(double x, double y)
	{
		this.x -= x;
		this.y -= y;
		return this;
	}

	public Vector3d multiply(Vector2dr vector)
	{
		return multiply((double) vector.x(), (double) vector.y());
	}
	public Vector3d multiply(double x, double y)
	{
		this.x *= x;
		this.y *= y;
		return this;
	}

	public Vector3d divide(Vector2dr vector)
	{
		return divide((double) vector.x(), (double) vector.y());
	}
	public Vector3d divide(double x, double y)
	{
		this.x /= x;
		this.y /= y;
		return this;
	}

	public Vector3d setAll(Vector2dr vector)
	{
		return x(vector.x()).y(vector.y());
	}
	public Vector3d add(Vector3ir vector)
	{
		return add(vector.x(), vector.y(), vector.z());
	}

	public Vector3d subtract(Vector3ir vector)
	{
		return subtract(vector.x(), vector.y(), vector.z());
	}

	public Vector3d multiply(Vector3ir vector)
	{
		return multiply(vector.x(), vector.y(), vector.z());
	}

	public Vector3d divide(Vector3ir vector)
	{
		return divide(vector.x(), vector.y(), vector.z());
	}

	public Vector3d setAll(Vector3ir vector)
	{
		return x(vector.x()).y(vector.y()).z(vector.z());
	}
	public Vector3d add(Vector3lr vector)
	{
		return add(vector.x(), vector.y(), vector.z());
	}
	public Vector3d add(long x, long y, long z)
	{
		this.x += x;
		this.y += y;
		this.z += z;
		return this;
	}

	public Vector3d subtract(Vector3lr vector)
	{
		return subtract(vector.x(), vector.y(), vector.z());
	}
	public Vector3d subtract(long x, long y, long z)
	{
		this.x -= x;
		this.y -= y;
		this.z -= z;
		return this;
	}

	public Vector3d multiply(Vector3lr vector)
	{
		return multiply(vector.x(), vector.y(), vector.z());
	}
	public Vector3d multiply(long x, long y, long z)
	{
		this.x *= x;
		this.y *= y;
		this.z *= z;
		return this;
	}

	public Vector3d divide(Vector3lr vector)
	{
		return divide(vector.x(), vector.y(), vector.z());
	}
	public Vector3d divide(long x, long y, long z)
	{
		this.x /= x;
		this.y /= y;
		this.z /= z;
		return this;
	}

	public Vector3d setAll(Vector3lr vector)
	{
		return x(vector.x()).y(vector.y()).z(vector.z());
	}
	public Vector3d add(Vector3fr vector)
	{
		return add(vector.x(), vector.y(), vector.z());
	}

	public Vector3d subtract(Vector3fr vector)
	{
		return subtract(vector.x(), vector.y(), vector.z());
	}

	public Vector3d multiply(Vector3fr vector)
	{
		return multiply(vector.x(), vector.y(), vector.z());
	}

	public Vector3d divide(Vector3fr vector)
	{
		return divide(vector.x(), vector.y(), vector.z());
	}

	public Vector3d setAll(Vector3fr vector)
	{
		return x(vector.x()).y(vector.y()).z(vector.z());
	}
	public Vector3d add(Vector3dr vector)
	{
		return add((double) vector.x(), (double) vector.y(), (double) vector.z());
	}
	public Vector3d add(double x, double y, double z)
	{
		this.x += x;
		this.y += y;
		this.z += z;
		return this;
	}

	public Vector3d subtract(Vector3dr vector)
	{
		return subtract((double) vector.x(), (double) vector.y(), (double) vector.z());
	}
	public Vector3d subtract(double x, double y, double z)
	{
		this.x -= x;
		this.y -= y;
		this.z -= z;
		return this;
	}

	public Vector3d multiply(Vector3dr vector)
	{
		return multiply((double) vector.x(), (double) vector.y(), (double) vector.z());
	}
	public Vector3d multiply(double x, double y, double z)
	{
		this.x *= x;
		this.y *= y;
		this.z *= z;
		return this;
	}

	public Vector3d divide(Vector3dr vector)
	{
		return divide((double) vector.x(), (double) vector.y(), (double) vector.z());
	}
	public Vector3d divide(double x, double y, double z)
	{
		this.x /= x;
		this.y /= y;
		this.z /= z;
		return this;
	}

	public Vector3d setAll(Vector3dr vector)
	{
		return x(vector.x()).y(vector.y()).z(vector.z());
	}
	public Vector3d opposite()
	{
		x = -x;
		y = -y;
		z = -z;
		return this;
	}
	public Vector3d absolute()
	{
		x = abs(x);
		y = abs(y);
		z = abs(z);
		return this;
	}
	public Vector3d conjugate()
	{
		y = -y;
		z = -z;
		return this;
	}
	public Vector3d normalize()
	{
		return divideAll(length());
	}
	public Vector3d unitary()
	{
		return normalize();
	}

	public Vector3d addAll(long value)
	{
		return add(value, value, value);
	}
	public Vector3d addAll(double value)
	{
		return add(value, value, value);
	}
	public Vector3d subtractAll(long value)
	{
		return subtract(value, value, value);
	}
	public Vector3d subtractAll(double value)
	{
		return subtract(value, value, value);
	}
	public Vector3d multiplyAll(long value)
	{
		return multiply(value, value, value);
	}
	public Vector3d multiplyAll(double value)
	{
		return multiply(value, value, value);
	}
	public Vector3d divideAll(long value)
	{
		return divide(value, value, value);
	}
	public Vector3d divideAll(double value)
	{
		return divide(value, value, value);
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
	public Vector3d setX(double x)
	{
		return x(x);
	}
	public Vector3d x(double x)
	{
		this.x = x;
		return this;
	}
	public Vector3d setY(double y)
	{
		return y(y);
	}
	public Vector3d y(double y)
	{
		this.y = y;
		return this;
	}
	public Vector3d setZ(double z)
	{
		return z(z);
	}
	public Vector3d z(double z)
	{
		this.z = z;
		return this;
	}
	public Vector3d setAll(double x, double y)
	{
		return x(x).y(y);
	}
	public Vector3d setAll(double x, double y, double z)
	{
		return x(x).y(y).z(z);
	}
	public String toString()
	{
		StringBuilder ss = new StringBuilder(25);
		return ss.append("Vector3d{").append(x()).append(", ").append(y()).append(", ").append(z()).append("}").toString();
	}
}
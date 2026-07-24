package com.alcadrial.kector.vector.mutable;

import static com.alcadrial.kector.Math.*;
import com.alcadrial.kector.vector.AbstractVector4f;
import com.alcadrial.kector.vector.Vector4f;
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
public class MutableVector4f extends AbstractVector4f implements Vector4f {

	protected float x;
	protected float y;
	protected float z;
	protected float w;

	public MutableVector4f(int x, int y, int z, int w)
	{
		this((float) x, (float) y, (float) z, (float) w);
	}
	public MutableVector4f(long x, long y, long z, long w)
	{
		this((float) x, (float) y, (float) z, (float) w);
	}
	public MutableVector4f(float x, float y, float z, float w)
	{
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
	}
	public MutableVector4f(double x, double y, double z, double w)
	{
		this((float) x, (float) y, (float) z, (float) w);
	}
	public MutableVector4f(Vector2ir vector, int z, int w)
	{
		this(vector.x(), vector.y(), z, w);
	}
	public MutableVector4f(Vector2lr vector, long z, long w)
	{
		this(vector.x(), vector.y(), z, w);
	}
	public MutableVector4f(Vector2fr vector, float z, float w)
	{
		this(vector.x(), vector.y(), z, w);
	}
	public MutableVector4f(Vector2dr vector, double z, double w)
	{
		this((float) vector.x(), (float) vector.y(), (float) z, (float) w);
	}
	public MutableVector4f(Vector3ir vector, int w)
	{
		this(vector.x(), vector.y(), vector.z(), w);
	}
	public MutableVector4f(Vector3lr vector, long w)
	{
		this(vector.x(), vector.y(), vector.z(), w);
	}
	public MutableVector4f(Vector3fr vector, float w)
	{
		this(vector.x(), vector.y(), vector.z(), w);
	}
	public MutableVector4f(Vector3dr vector, double w)
	{
		this((float) vector.x(), (float) vector.y(), (float) vector.z(), (float) w);
	}
	public MutableVector4f(Vector4ir vector)
	{
		this(vector.x(), vector.y(), vector.z(), vector.w());
	}
	public MutableVector4f(Vector4lr vector)
	{
		this(vector.x(), vector.y(), vector.z(), vector.w());
	}
	public MutableVector4f(Vector4fr vector)
	{
		this(vector.x(), vector.y(), vector.z(), vector.w());
	}
	public MutableVector4f(Vector4dr vector)
	{
		this((float) vector.x(), (float) vector.y(), (float) vector.z(), (float) vector.w());
	}

	public Vector4f add(Vector2ir vector)
	{
		return add(vector.x(), vector.y());
	}
	public Vector4f add(int x, int y)
	{
		this.x += x;
		this.y += y;
		return this;
	}

	public Vector4f subtract(Vector2ir vector)
	{
		return subtract(vector.x(), vector.y());
	}
	public Vector4f subtract(int x, int y)
	{
		this.x -= x;
		this.y -= y;
		return this;
	}

	public Vector4f multiply(Vector2ir vector)
	{
		return multiply(vector.x(), vector.y());
	}
	public Vector4f multiply(int x, int y)
	{
		this.x *= x;
		this.y *= y;
		return this;
	}

	public Vector4f divide(Vector2ir vector)
	{
		return divide(vector.x(), vector.y());
	}
	public Vector4f divide(int x, int y)
	{
		this.x /= x;
		this.y /= y;
		return this;
	}

	public Vector4f setAll(Vector2ir vector)
	{
		return x(vector.x()).y(vector.y());
	}
	public Vector4f add(Vector2lr vector)
	{
		return add(vector.x(), vector.y());
	}

	public Vector4f subtract(Vector2lr vector)
	{
		return subtract(vector.x(), vector.y());
	}

	public Vector4f multiply(Vector2lr vector)
	{
		return multiply(vector.x(), vector.y());
	}

	public Vector4f divide(Vector2lr vector)
	{
		return divide(vector.x(), vector.y());
	}

	public Vector4f setAll(Vector2lr vector)
	{
		return x(vector.x()).y(vector.y());
	}
	public Vector4f add(Vector2fr vector)
	{
		return add(vector.x(), vector.y());
	}
	public Vector4f add(float x, float y)
	{
		this.x += x;
		this.y += y;
		return this;
	}

	public Vector4f subtract(Vector2fr vector)
	{
		return subtract(vector.x(), vector.y());
	}
	public Vector4f subtract(float x, float y)
	{
		this.x -= x;
		this.y -= y;
		return this;
	}

	public Vector4f multiply(Vector2fr vector)
	{
		return multiply(vector.x(), vector.y());
	}
	public Vector4f multiply(float x, float y)
	{
		this.x *= x;
		this.y *= y;
		return this;
	}

	public Vector4f divide(Vector2fr vector)
	{
		return divide(vector.x(), vector.y());
	}
	public Vector4f divide(float x, float y)
	{
		this.x /= x;
		this.y /= y;
		return this;
	}

	public Vector4f setAll(Vector2fr vector)
	{
		return x(vector.x()).y(vector.y());
	}
	public Vector4f add(Vector2dr vector)
	{
		return add((float) vector.x(), (float) vector.y());
	}

	public Vector4f subtract(Vector2dr vector)
	{
		return subtract((float) vector.x(), (float) vector.y());
	}

	public Vector4f multiply(Vector2dr vector)
	{
		return multiply((float) vector.x(), (float) vector.y());
	}

	public Vector4f divide(Vector2dr vector)
	{
		return divide((float) vector.x(), (float) vector.y());
	}

	public Vector4f setAll(Vector2dr vector)
	{
		return x((float) vector.x()).y((float) vector.y());
	}
	public Vector4f add(Vector3ir vector)
	{
		return add(vector.x(), vector.y(), vector.z());
	}
	public Vector4f add(int x, int y, int z)
	{
		this.x += x;
		this.y += y;
		this.z += z;
		return this;
	}

	public Vector4f subtract(Vector3ir vector)
	{
		return subtract(vector.x(), vector.y(), vector.z());
	}
	public Vector4f subtract(int x, int y, int z)
	{
		this.x -= x;
		this.y -= y;
		this.z -= z;
		return this;
	}

	public Vector4f multiply(Vector3ir vector)
	{
		return multiply(vector.x(), vector.y(), vector.z());
	}
	public Vector4f multiply(int x, int y, int z)
	{
		this.x *= x;
		this.y *= y;
		this.z *= z;
		return this;
	}

	public Vector4f divide(Vector3ir vector)
	{
		return divide(vector.x(), vector.y(), vector.z());
	}
	public Vector4f divide(int x, int y, int z)
	{
		this.x /= x;
		this.y /= y;
		this.z /= z;
		return this;
	}

	public Vector4f crossProduct(Vector3ir vector)
	{
		return crossProduct(vector.x(), vector.y(), vector.z());
	}
	public Vector4f crossProduct(int x, int y, int z)
	{
		float x0 = this.y * z - this.z * y;
		float y0 = this.z * x - this.x * z;
		float z0 = this.x * y - this.y * x;
		this.x = x0;
		this.y = y0;
		this.z = z0;
		return this;
	}

	public Vector4f setAll(Vector3ir vector)
	{
		return x(vector.x()).y(vector.y()).z(vector.z());
	}
	public Vector4f add(Vector3lr vector)
	{
		return add(vector.x(), vector.y(), vector.z());
	}

	public Vector4f subtract(Vector3lr vector)
	{
		return subtract(vector.x(), vector.y(), vector.z());
	}

	public Vector4f multiply(Vector3lr vector)
	{
		return multiply(vector.x(), vector.y(), vector.z());
	}

	public Vector4f divide(Vector3lr vector)
	{
		return divide(vector.x(), vector.y(), vector.z());
	}

	public Vector4f crossProduct(Vector3lr vector)
	{
		return crossProduct(vector.x(), vector.y(), vector.z());
	}

	public Vector4f setAll(Vector3lr vector)
	{
		return x(vector.x()).y(vector.y()).z(vector.z());
	}
	public Vector4f add(Vector3fr vector)
	{
		return add(vector.x(), vector.y(), vector.z());
	}
	public Vector4f add(float x, float y, float z)
	{
		this.x += x;
		this.y += y;
		this.z += z;
		return this;
	}

	public Vector4f subtract(Vector3fr vector)
	{
		return subtract(vector.x(), vector.y(), vector.z());
	}
	public Vector4f subtract(float x, float y, float z)
	{
		this.x -= x;
		this.y -= y;
		this.z -= z;
		return this;
	}

	public Vector4f multiply(Vector3fr vector)
	{
		return multiply(vector.x(), vector.y(), vector.z());
	}
	public Vector4f multiply(float x, float y, float z)
	{
		this.x *= x;
		this.y *= y;
		this.z *= z;
		return this;
	}

	public Vector4f divide(Vector3fr vector)
	{
		return divide(vector.x(), vector.y(), vector.z());
	}
	public Vector4f divide(float x, float y, float z)
	{
		this.x /= x;
		this.y /= y;
		this.z /= z;
		return this;
	}

	public Vector4f crossProduct(Vector3fr vector)
	{
		return crossProduct(vector.x(), vector.y(), vector.z());
	}
	public Vector4f crossProduct(float x, float y, float z)
	{
		float x0 = this.y * z - this.z * y;
		float y0 = this.z * x - this.x * z;
		float z0 = this.x * y - this.y * x;
		this.x = x0;
		this.y = y0;
		this.z = z0;
		return this;
	}

	public Vector4f setAll(Vector3fr vector)
	{
		return x(vector.x()).y(vector.y()).z(vector.z());
	}
	public Vector4f add(Vector3dr vector)
	{
		return add((float) vector.x(), (float) vector.y(), (float) vector.z());
	}

	public Vector4f subtract(Vector3dr vector)
	{
		return subtract((float) vector.x(), (float) vector.y(), (float) vector.z());
	}

	public Vector4f multiply(Vector3dr vector)
	{
		return multiply((float) vector.x(), (float) vector.y(), (float) vector.z());
	}

	public Vector4f divide(Vector3dr vector)
	{
		return divide((float) vector.x(), (float) vector.y(), (float) vector.z());
	}

	public Vector4f crossProduct(Vector3dr vector)
	{
		return crossProduct((float) vector.x(), (float) vector.y(), (float) vector.z());
	}

	public Vector4f setAll(Vector3dr vector)
	{
		return x((float) vector.x()).y((float) vector.y()).z((float) vector.z());
	}
	public Vector4f add(Vector4ir vector)
	{
		return add(vector.x(), vector.y(), vector.z(), vector.w());
	}
	public Vector4f add(int x, int y, int z, int w)
	{
		this.x += x;
		this.y += y;
		this.z += z;
		this.w += w;
		return this;
	}

	public Vector4f subtract(Vector4ir vector)
	{
		return subtract(vector.x(), vector.y(), vector.z(), vector.w());
	}
	public Vector4f subtract(int x, int y, int z, int w)
	{
		this.x -= x;
		this.y -= y;
		this.z -= z;
		this.w -= w;
		return this;
	}

	public Vector4f multiply(Vector4ir vector)
	{
		return multiply(vector.x(), vector.y(), vector.z(), vector.w());
	}
	public Vector4f multiply(int x, int y, int z, int w)
	{
		this.x *= x;
		this.y *= y;
		this.z *= z;
		this.w *= w;
		return this;
	}

	public Vector4f divide(Vector4ir vector)
	{
		return divide(vector.x(), vector.y(), vector.z(), vector.w());
	}
	public Vector4f divide(int x, int y, int z, int w)
	{
		this.x /= x;
		this.y /= y;
		this.z /= z;
		this.w /= w;
		return this;
	}

	public Vector4f projectiveCrossProduct(Vector4ir vector)
	{
		return projectiveCrossProduct(vector.x(), vector.y(), vector.z(), vector.w());
	}
	public Vector4f projectiveCrossProduct(int x, int y, int z, int w)
	{
		float x0 = this.y * z - this.z * y;
		float y0 = this.z * x - this.x * z;
		float z0 = this.x * y - this.y * x;
		this.x = x0;
		this.y = y0;
		this.z = z0;
		this.w *= w;
		return this;
	}

	public Vector4f setAll(Vector4ir vector)
	{
		return x(vector.x()).y(vector.y()).z(vector.z()).w(vector.w());
	}
	public Vector4f add(Vector4lr vector)
	{
		return add(vector.x(), vector.y(), vector.z(), vector.w());
	}

	public Vector4f subtract(Vector4lr vector)
	{
		return subtract(vector.x(), vector.y(), vector.z(), vector.w());
	}

	public Vector4f multiply(Vector4lr vector)
	{
		return multiply(vector.x(), vector.y(), vector.z(), vector.w());
	}

	public Vector4f divide(Vector4lr vector)
	{
		return divide(vector.x(), vector.y(), vector.z(), vector.w());
	}

	public Vector4f projectiveCrossProduct(Vector4lr vector)
	{
		return projectiveCrossProduct(vector.x(), vector.y(), vector.z(), vector.w());
	}

	public Vector4f setAll(Vector4lr vector)
	{
		return x(vector.x()).y(vector.y()).z(vector.z()).w(vector.w());
	}
	public Vector4f add(Vector4fr vector)
	{
		return add(vector.x(), vector.y(), vector.z(), vector.w());
	}
	public Vector4f add(float x, float y, float z, float w)
	{
		this.x += x;
		this.y += y;
		this.z += z;
		this.w += w;
		return this;
	}

	public Vector4f subtract(Vector4fr vector)
	{
		return subtract(vector.x(), vector.y(), vector.z(), vector.w());
	}
	public Vector4f subtract(float x, float y, float z, float w)
	{
		this.x -= x;
		this.y -= y;
		this.z -= z;
		this.w -= w;
		return this;
	}

	public Vector4f multiply(Vector4fr vector)
	{
		return multiply(vector.x(), vector.y(), vector.z(), vector.w());
	}
	public Vector4f multiply(float x, float y, float z, float w)
	{
		this.x *= x;
		this.y *= y;
		this.z *= z;
		this.w *= w;
		return this;
	}

	public Vector4f divide(Vector4fr vector)
	{
		return divide(vector.x(), vector.y(), vector.z(), vector.w());
	}
	public Vector4f divide(float x, float y, float z, float w)
	{
		this.x /= x;
		this.y /= y;
		this.z /= z;
		this.w /= w;
		return this;
	}

	public Vector4f projectiveCrossProduct(Vector4fr vector)
	{
		return projectiveCrossProduct(vector.x(), vector.y(), vector.z(), vector.w());
	}
	public Vector4f projectiveCrossProduct(float x, float y, float z, float w)
	{
		float x0 = this.y * z - this.z * y;
		float y0 = this.z * x - this.x * z;
		float z0 = this.x * y - this.y * x;
		this.x = x0;
		this.y = y0;
		this.z = z0;
		this.w *= w;
		return this;
	}

	public Vector4f setAll(Vector4fr vector)
	{
		return x(vector.x()).y(vector.y()).z(vector.z()).w(vector.w());
	}
	public Vector4f add(Vector4dr vector)
	{
		return add((float) vector.x(), (float) vector.y(), (float) vector.z(), (float) vector.w());
	}

	public Vector4f subtract(Vector4dr vector)
	{
		return subtract((float) vector.x(), (float) vector.y(), (float) vector.z(), (float) vector.w());
	}

	public Vector4f multiply(Vector4dr vector)
	{
		return multiply((float) vector.x(), (float) vector.y(), (float) vector.z(), (float) vector.w());
	}

	public Vector4f divide(Vector4dr vector)
	{
		return divide((float) vector.x(), (float) vector.y(), (float) vector.z(), (float) vector.w());
	}

	public Vector4f projectiveCrossProduct(Vector4dr vector)
	{
		return projectiveCrossProduct((float) vector.x(), (float) vector.y(), (float) vector.z(), (float) vector.w());
	}

	public Vector4f setAll(Vector4dr vector)
	{
		return x((float) vector.x()).y((float) vector.y()).z((float) vector.z()).w((float) vector.w());
	}
	public Vector4f opposite()
	{
		x = -x;
		y = -y;
		z = -z;
		w = -w;
		return this;
	}
	public Vector4f absolute()
	{
		x = abs(x);
		y = abs(y);
		z = abs(z);
		w = abs(w);
		return this;
	}
	public Vector4f conjugate()
	{
		y = -y;
		z = -z;
		w = -w;
		return this;
	}
	public Vector4f normalize()
	{
		return divideAll(length());
	}
	public Vector4f unitary()
	{
		return normalize();
	}

	public Vector4f addAll(int value)
	{
		return add(value, value, value, value);
	}
	public Vector4f addAll(float value)
	{
		return add(value, value, value, value);
	}
	public Vector4f subtractAll(int value)
	{
		return subtract(value, value, value, value);
	}
	public Vector4f subtractAll(float value)
	{
		return subtract(value, value, value, value);
	}
	public Vector4f multiplyAll(int value)
	{
		return multiply(value, value, value, value);
	}
	public Vector4f multiplyAll(float value)
	{
		return multiply(value, value, value, value);
	}
	public Vector4f divideAll(int value)
	{
		return divide(value, value, value, value);
	}
	public Vector4f divideAll(float value)
	{
		return divide(value, value, value, value);
	}

	public float x()
	{
		return x;
	}
	public float y()
	{
		return y;
	}
	public float z()
	{
		return z;
	}
	public float w()
	{
		return w;
	}
	public Vector4f setX(float x)
	{
		return x(x);
	}
	public Vector4f x(float x)
	{
		this.x = x;
		return this;
	}
	public Vector4f setY(float y)
	{
		return y(y);
	}
	public Vector4f y(float y)
	{
		this.y = y;
		return this;
	}
	public Vector4f setZ(float z)
	{
		return z(z);
	}
	public Vector4f z(float z)
	{
		this.z = z;
		return this;
	}
	public Vector4f setW(float w)
	{
		return w(w);
	}
	public Vector4f w(float w)
	{
		this.w = w;
		return this;
	}
	public Vector4f setAll(float x, float y)
	{
		return x(x).y(y);
	}
	public Vector4f setAll(float x, float y, float z)
	{
		return x(x).y(y).z(z);
	}
	public Vector4f setAll(float x, float y, float z, float w)
	{
		return x(x).y(y).z(z).w(w);
	}
	public String toString()
	{
		StringBuilder ss = new StringBuilder(25);
		return ss.append("Vector4f{").append(x()).append(", ").append(y()).append(", ").append(z()).append(", ").append(w()).append("}").toString();
	}
}
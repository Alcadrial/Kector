package com.alcadrial.kector.vector.mutable;

import static com.alcadrial.kector.Math.*;
import com.alcadrial.kector.vector.AbstractVector3f;
import com.alcadrial.kector.vector.Vector3f;
import com.alcadrial.kector.vector.Vector2ir;
import com.alcadrial.kector.vector.Vector2lr;
import com.alcadrial.kector.vector.Vector2fr;
import com.alcadrial.kector.vector.Vector2dr;
import com.alcadrial.kector.vector.Vector3ir;
import com.alcadrial.kector.vector.Vector3lr;
import com.alcadrial.kector.vector.Vector3fr;
import com.alcadrial.kector.vector.Vector3dr;
public class MutableVector3f extends AbstractVector3f implements Vector3f {

	protected float x;
	protected float y;
	protected float z;

	public MutableVector3f(int x, int y, int z)
	{
		this((float) x, (float) y, (float) z);
	}
	public MutableVector3f(long x, long y, long z)
	{
		this((float) x, (float) y, (float) z);
	}
	public MutableVector3f(float x, float y, float z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}
	public MutableVector3f(double x, double y, double z)
	{
		this((float) x, (float) y, (float) z);
	}
	public MutableVector3f(Vector2ir vector, int z)
	{
		this(vector.x(), vector.y(), z);
	}
	public MutableVector3f(Vector2lr vector, long z)
	{
		this(vector.x(), vector.y(), z);
	}
	public MutableVector3f(Vector2fr vector, float z)
	{
		this(vector.x(), vector.y(), z);
	}
	public MutableVector3f(Vector2dr vector, double z)
	{
		this((float) vector.x(), (float) vector.y(), (float) z);
	}
	public MutableVector3f(Vector3ir vector)
	{
		this(vector.x(), vector.y(), vector.z());
	}
	public MutableVector3f(Vector3lr vector)
	{
		this(vector.x(), vector.y(), vector.z());
	}
	public MutableVector3f(Vector3fr vector)
	{
		this(vector.x(), vector.y(), vector.z());
	}
	public MutableVector3f(Vector3dr vector)
	{
		this((float) vector.x(), (float) vector.y(), (float) vector.z());
	}

	public Vector3f add(Vector2ir vector)
	{
		return add(vector.x(), vector.y());
	}
	public Vector3f add(int x, int y)
	{
		this.x += x;
		this.y += y;
		return this;
	}

	public Vector3f subtract(Vector2ir vector)
	{
		return subtract(vector.x(), vector.y());
	}
	public Vector3f subtract(int x, int y)
	{
		this.x -= x;
		this.y -= y;
		return this;
	}

	public Vector3f multiply(Vector2ir vector)
	{
		return multiply(vector.x(), vector.y());
	}
	public Vector3f multiply(int x, int y)
	{
		this.x *= x;
		this.y *= y;
		return this;
	}

	public Vector3f divide(Vector2ir vector)
	{
		return divide(vector.x(), vector.y());
	}
	public Vector3f divide(int x, int y)
	{
		this.x /= x;
		this.y /= y;
		return this;
	}

	public Vector3f setAll(Vector2ir vector)
	{
		return x(vector.x()).y(vector.y());
	}
	public Vector3f add(Vector2lr vector)
	{
		return add(vector.x(), vector.y());
	}

	public Vector3f subtract(Vector2lr vector)
	{
		return subtract(vector.x(), vector.y());
	}

	public Vector3f multiply(Vector2lr vector)
	{
		return multiply(vector.x(), vector.y());
	}

	public Vector3f divide(Vector2lr vector)
	{
		return divide(vector.x(), vector.y());
	}

	public Vector3f setAll(Vector2lr vector)
	{
		return x(vector.x()).y(vector.y());
	}
	public Vector3f add(Vector2fr vector)
	{
		return add(vector.x(), vector.y());
	}
	public Vector3f add(float x, float y)
	{
		this.x += x;
		this.y += y;
		return this;
	}

	public Vector3f subtract(Vector2fr vector)
	{
		return subtract(vector.x(), vector.y());
	}
	public Vector3f subtract(float x, float y)
	{
		this.x -= x;
		this.y -= y;
		return this;
	}

	public Vector3f multiply(Vector2fr vector)
	{
		return multiply(vector.x(), vector.y());
	}
	public Vector3f multiply(float x, float y)
	{
		this.x *= x;
		this.y *= y;
		return this;
	}

	public Vector3f divide(Vector2fr vector)
	{
		return divide(vector.x(), vector.y());
	}
	public Vector3f divide(float x, float y)
	{
		this.x /= x;
		this.y /= y;
		return this;
	}

	public Vector3f setAll(Vector2fr vector)
	{
		return x(vector.x()).y(vector.y());
	}
	public Vector3f add(Vector2dr vector)
	{
		return add((float) vector.x(), (float) vector.y());
	}

	public Vector3f subtract(Vector2dr vector)
	{
		return subtract((float) vector.x(), (float) vector.y());
	}

	public Vector3f multiply(Vector2dr vector)
	{
		return multiply((float) vector.x(), (float) vector.y());
	}

	public Vector3f divide(Vector2dr vector)
	{
		return divide((float) vector.x(), (float) vector.y());
	}

	public Vector3f setAll(Vector2dr vector)
	{
		return x((float) vector.x()).y((float) vector.y());
	}
	public Vector3f add(Vector3ir vector)
	{
		return add(vector.x(), vector.y(), vector.z());
	}
	public Vector3f add(int x, int y, int z)
	{
		this.x += x;
		this.y += y;
		this.z += z;
		return this;
	}

	public Vector3f subtract(Vector3ir vector)
	{
		return subtract(vector.x(), vector.y(), vector.z());
	}
	public Vector3f subtract(int x, int y, int z)
	{
		this.x -= x;
		this.y -= y;
		this.z -= z;
		return this;
	}

	public Vector3f multiply(Vector3ir vector)
	{
		return multiply(vector.x(), vector.y(), vector.z());
	}
	public Vector3f multiply(int x, int y, int z)
	{
		this.x *= x;
		this.y *= y;
		this.z *= z;
		return this;
	}

	public Vector3f divide(Vector3ir vector)
	{
		return divide(vector.x(), vector.y(), vector.z());
	}
	public Vector3f divide(int x, int y, int z)
	{
		this.x /= x;
		this.y /= y;
		this.z /= z;
		return this;
	}

	public Vector3f setAll(Vector3ir vector)
	{
		return x(vector.x()).y(vector.y()).z(vector.z());
	}
	public Vector3f add(Vector3lr vector)
	{
		return add(vector.x(), vector.y(), vector.z());
	}

	public Vector3f subtract(Vector3lr vector)
	{
		return subtract(vector.x(), vector.y(), vector.z());
	}

	public Vector3f multiply(Vector3lr vector)
	{
		return multiply(vector.x(), vector.y(), vector.z());
	}

	public Vector3f divide(Vector3lr vector)
	{
		return divide(vector.x(), vector.y(), vector.z());
	}

	public Vector3f setAll(Vector3lr vector)
	{
		return x(vector.x()).y(vector.y()).z(vector.z());
	}
	public Vector3f add(Vector3fr vector)
	{
		return add(vector.x(), vector.y(), vector.z());
	}
	public Vector3f add(float x, float y, float z)
	{
		this.x += x;
		this.y += y;
		this.z += z;
		return this;
	}

	public Vector3f subtract(Vector3fr vector)
	{
		return subtract(vector.x(), vector.y(), vector.z());
	}
	public Vector3f subtract(float x, float y, float z)
	{
		this.x -= x;
		this.y -= y;
		this.z -= z;
		return this;
	}

	public Vector3f multiply(Vector3fr vector)
	{
		return multiply(vector.x(), vector.y(), vector.z());
	}
	public Vector3f multiply(float x, float y, float z)
	{
		this.x *= x;
		this.y *= y;
		this.z *= z;
		return this;
	}

	public Vector3f divide(Vector3fr vector)
	{
		return divide(vector.x(), vector.y(), vector.z());
	}
	public Vector3f divide(float x, float y, float z)
	{
		this.x /= x;
		this.y /= y;
		this.z /= z;
		return this;
	}

	public Vector3f setAll(Vector3fr vector)
	{
		return x(vector.x()).y(vector.y()).z(vector.z());
	}
	public Vector3f add(Vector3dr vector)
	{
		return add((float) vector.x(), (float) vector.y(), (float) vector.z());
	}

	public Vector3f subtract(Vector3dr vector)
	{
		return subtract((float) vector.x(), (float) vector.y(), (float) vector.z());
	}

	public Vector3f multiply(Vector3dr vector)
	{
		return multiply((float) vector.x(), (float) vector.y(), (float) vector.z());
	}

	public Vector3f divide(Vector3dr vector)
	{
		return divide((float) vector.x(), (float) vector.y(), (float) vector.z());
	}

	public Vector3f setAll(Vector3dr vector)
	{
		return x((float) vector.x()).y((float) vector.y()).z((float) vector.z());
	}
	public Vector3f opposite()
	{
		x = -x;
		y = -y;
		z = -z;
		return this;
	}
	public Vector3f absolute()
	{
		x = abs(x);
		y = abs(y);
		z = abs(z);
		return this;
	}
	public Vector3f conjugate()
	{
		y = -y;
		z = -z;
		return this;
	}
	public Vector3f normalize()
	{
		return divideAll(length());
	}
	public Vector3f unitary()
	{
		return normalize();
	}

	public Vector3f addAll(int value)
	{
		return add(value, value, value);
	}
	public Vector3f addAll(float value)
	{
		return add(value, value, value);
	}
	public Vector3f subtractAll(int value)
	{
		return subtract(value, value, value);
	}
	public Vector3f subtractAll(float value)
	{
		return subtract(value, value, value);
	}
	public Vector3f multiplyAll(int value)
	{
		return multiply(value, value, value);
	}
	public Vector3f multiplyAll(float value)
	{
		return multiply(value, value, value);
	}
	public Vector3f divideAll(int value)
	{
		return divide(value, value, value);
	}
	public Vector3f divideAll(float value)
	{
		return divide(value, value, value);
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
	public Vector3f setX(float x)
	{
		return x(x);
	}
	public Vector3f x(float x)
	{
		this.x = x;
		return this;
	}
	public Vector3f setY(float y)
	{
		return y(y);
	}
	public Vector3f y(float y)
	{
		this.y = y;
		return this;
	}
	public Vector3f setZ(float z)
	{
		return z(z);
	}
	public Vector3f z(float z)
	{
		this.z = z;
		return this;
	}
	public Vector3f setAll(float x, float y)
	{
		return x(x).y(y);
	}
	public Vector3f setAll(float x, float y, float z)
	{
		return x(x).y(y).z(z);
	}
}
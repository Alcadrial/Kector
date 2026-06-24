package com.alcadrial.kector.vector.mutable;

import java.math.RoundingMode;
import static com.alcadrial.kector.Math.*;
import com.alcadrial.kector.vector.AbstractVector3i;
import com.alcadrial.kector.vector.Vector3i;
import com.alcadrial.kector.vector.Vector2ir;
import com.alcadrial.kector.vector.Vector2lr;
import com.alcadrial.kector.vector.Vector2fr;
import com.alcadrial.kector.vector.Vector2dr;
import com.alcadrial.kector.vector.Vector3ir;
import com.alcadrial.kector.vector.Vector3lr;
import com.alcadrial.kector.vector.Vector3fr;
import com.alcadrial.kector.vector.Vector3dr;
public class MutableVector3i extends AbstractVector3i implements Vector3i {

	protected int x;
	protected int y;
	protected int z;

	public MutableVector3i(int x, int y, int z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}
	public MutableVector3i(long x, long y, long z)
	{
		this((int) x, (int) y, (int) z);
	}
	public MutableVector3i(float x, float y, float z, RoundingMode roundingMode)
	{
		this(toInt(x, roundingMode), toInt(y, roundingMode), toInt(z, roundingMode));
	}
	public MutableVector3i(double x, double y, double z, RoundingMode roundingMode)
	{
		this(toInt(x, roundingMode), toInt(y, roundingMode), toInt(z, roundingMode));
	}
	public MutableVector3i(Vector2ir vector, int z)
	{
		this(vector.x(), vector.y(), z);
	}
	public MutableVector3i(Vector2lr vector, long z)
	{
		this((int) vector.x(), (int) vector.y(), (int) z);
	}
	public MutableVector3i(Vector2fr vector, float z, RoundingMode roundingMode)
	{
		this(toInt(vector.x(), roundingMode), toInt(vector.y(), roundingMode), toInt(z, roundingMode));
	}
	public MutableVector3i(Vector2dr vector, double z, RoundingMode roundingMode)
	{
		this(toInt(vector.x(), roundingMode), toInt(vector.y(), roundingMode), toInt(z, roundingMode));
	}
	public MutableVector3i(Vector3ir vector)
	{
		this(vector.x(), vector.y(), vector.z());
	}
	public MutableVector3i(Vector3lr vector)
	{
		this((int) vector.x(), (int) vector.y(), (int) vector.z());
	}
	public MutableVector3i(Vector3fr vector, RoundingMode roundingMode)
	{
		this(toInt(vector.x(), roundingMode), toInt(vector.y(), roundingMode), toInt(vector.z(), roundingMode));
	}
	public MutableVector3i(Vector3dr vector, RoundingMode roundingMode)
	{
		this(toInt(vector.x(), roundingMode), toInt(vector.y(), roundingMode), toInt(vector.z(), roundingMode));
	}

	public Vector3i add(Vector2ir vector)
	{
		return add(vector.x(), vector.y());
	}
	public Vector3i add(int x, int y)
	{
		this.x += x;
		this.y += y;
		return this;
	}

	public Vector3i subtract(Vector2ir vector)
	{
		return subtract(vector.x(), vector.y());
	}
	public Vector3i subtract(int x, int y)
	{
		this.x -= x;
		this.y -= y;
		return this;
	}

	public Vector3i multiply(Vector2ir vector)
	{
		return multiply(vector.x(), vector.y());
	}
	public Vector3i multiply(int x, int y)
	{
		this.x *= x;
		this.y *= y;
		return this;
	}

	public Vector3i divide(Vector2ir vector)
	{
		return divide(vector.x(), vector.y());
	}
	public Vector3i divide(int x, int y)
	{
		this.x /= x;
		this.y /= y;
		return this;
	}

	public Vector3i setAll(Vector2ir vector)
	{
		return x(vector.x()).y(vector.y());
	}
	public Vector3i add(Vector2lr vector)
	{
		return add((int) vector.x(), (int) vector.y());
	}

	public Vector3i subtract(Vector2lr vector)
	{
		return subtract((int) vector.x(), (int) vector.y());
	}

	public Vector3i multiply(Vector2lr vector)
	{
		return multiply((int) vector.x(), (int) vector.y());
	}

	public Vector3i divide(Vector2lr vector)
	{
		return divide((int) vector.x(), (int) vector.y());
	}

	public Vector3i setAll(Vector2lr vector)
	{
		return x((int) vector.x()).y((int) vector.y());
	}
	public Vector3i add(Vector2fr vector, RoundingMode roundingMode)
	{
		return add(toInt(vector.x(), roundingMode), toInt(vector.y(), roundingMode));
	}
	public Vector3i add(float x, float y, RoundingMode roundingMode)
	{
		return add(toInt(x, roundingMode), toInt(y, roundingMode), toInt(z, roundingMode));
	}

	public Vector3i subtract(Vector2fr vector, RoundingMode roundingMode)
	{
		return subtract(toInt(vector.x(), roundingMode), toInt(vector.y(), roundingMode));
	}
	public Vector3i subtract(float x, float y, RoundingMode roundingMode)
	{
		return subtract(toInt(x, roundingMode), toInt(y, roundingMode), toInt(z, roundingMode));
	}

	public Vector3i multiply(Vector2fr vector, RoundingMode roundingMode)
	{
		return multiply(toInt(vector.x(), roundingMode), toInt(vector.y(), roundingMode));
	}
	public Vector3i multiply(float x, float y, RoundingMode roundingMode)
	{
		return multiply(toInt(x, roundingMode), toInt(y, roundingMode), toInt(z, roundingMode));
	}

	public Vector3i divide(Vector2fr vector, RoundingMode roundingMode)
	{
		return divide(toInt(vector.x(), roundingMode), toInt(vector.y(), roundingMode));
	}
	public Vector3i divide(float x, float y, RoundingMode roundingMode)
	{
		return divide(toInt(x, roundingMode), toInt(y, roundingMode), toInt(z, roundingMode));
	}

	public Vector3i setAll(Vector2fr vector, RoundingMode roundingMode)
	{
		return x(toInt(vector.x(), roundingMode)).y(toInt(vector.y(), roundingMode));
	}
	public Vector3i add(Vector2dr vector, RoundingMode roundingMode)
	{
		return add(toInt(vector.x(), roundingMode), toInt(vector.y(), roundingMode));
	}

	public Vector3i subtract(Vector2dr vector, RoundingMode roundingMode)
	{
		return subtract(toInt(vector.x(), roundingMode), toInt(vector.y(), roundingMode));
	}

	public Vector3i multiply(Vector2dr vector, RoundingMode roundingMode)
	{
		return multiply(toInt(vector.x(), roundingMode), toInt(vector.y(), roundingMode));
	}

	public Vector3i divide(Vector2dr vector, RoundingMode roundingMode)
	{
		return divide(toInt(vector.x(), roundingMode), toInt(vector.y(), roundingMode));
	}

	public Vector3i setAll(Vector2dr vector, RoundingMode roundingMode)
	{
		return x(toInt(vector.x(), roundingMode)).y(toInt(vector.y(), roundingMode));
	}
	public Vector3i add(Vector3ir vector)
	{
		return add(vector.x(), vector.y(), vector.z());
	}
	public Vector3i add(int x, int y, int z)
	{
		this.x += x;
		this.y += y;
		this.z += z;
		return this;
	}

	public Vector3i subtract(Vector3ir vector)
	{
		return subtract(vector.x(), vector.y(), vector.z());
	}
	public Vector3i subtract(int x, int y, int z)
	{
		this.x -= x;
		this.y -= y;
		this.z -= z;
		return this;
	}

	public Vector3i multiply(Vector3ir vector)
	{
		return multiply(vector.x(), vector.y(), vector.z());
	}
	public Vector3i multiply(int x, int y, int z)
	{
		this.x *= x;
		this.y *= y;
		this.z *= z;
		return this;
	}

	public Vector3i divide(Vector3ir vector)
	{
		return divide(vector.x(), vector.y(), vector.z());
	}
	public Vector3i divide(int x, int y, int z)
	{
		this.x /= x;
		this.y /= y;
		this.z /= z;
		return this;
	}

	public Vector3i setAll(Vector3ir vector)
	{
		return x(vector.x()).y(vector.y()).z(vector.z());
	}
	public Vector3i add(Vector3lr vector)
	{
		return add((int) vector.x(), (int) vector.y(), (int) vector.z());
	}

	public Vector3i subtract(Vector3lr vector)
	{
		return subtract((int) vector.x(), (int) vector.y(), (int) vector.z());
	}

	public Vector3i multiply(Vector3lr vector)
	{
		return multiply((int) vector.x(), (int) vector.y(), (int) vector.z());
	}

	public Vector3i divide(Vector3lr vector)
	{
		return divide((int) vector.x(), (int) vector.y(), (int) vector.z());
	}

	public Vector3i setAll(Vector3lr vector)
	{
		return x((int) vector.x()).y((int) vector.y()).z((int) vector.z());
	}
	public Vector3i add(Vector3fr vector, RoundingMode roundingMode)
	{
		return add(toInt(vector.x(), roundingMode), toInt(vector.y(), roundingMode), toInt(vector.z(), roundingMode));
	}
	public Vector3i add(float x, float y, float z, RoundingMode roundingMode)
	{
		return add(toInt(x, roundingMode), toInt(y, roundingMode), toInt(z, roundingMode));
	}

	public Vector3i subtract(Vector3fr vector, RoundingMode roundingMode)
	{
		return subtract(toInt(vector.x(), roundingMode), toInt(vector.y(), roundingMode), toInt(vector.z(), roundingMode));
	}
	public Vector3i subtract(float x, float y, float z, RoundingMode roundingMode)
	{
		return subtract(toInt(x, roundingMode), toInt(y, roundingMode), toInt(z, roundingMode));
	}

	public Vector3i multiply(Vector3fr vector, RoundingMode roundingMode)
	{
		return multiply(toInt(vector.x(), roundingMode), toInt(vector.y(), roundingMode), toInt(vector.z(), roundingMode));
	}
	public Vector3i multiply(float x, float y, float z, RoundingMode roundingMode)
	{
		return multiply(toInt(x, roundingMode), toInt(y, roundingMode), toInt(z, roundingMode));
	}

	public Vector3i divide(Vector3fr vector, RoundingMode roundingMode)
	{
		return divide(toInt(vector.x(), roundingMode), toInt(vector.y(), roundingMode), toInt(vector.z(), roundingMode));
	}
	public Vector3i divide(float x, float y, float z, RoundingMode roundingMode)
	{
		return divide(toInt(x, roundingMode), toInt(y, roundingMode), toInt(z, roundingMode));
	}

	public Vector3i setAll(Vector3fr vector, RoundingMode roundingMode)
	{
		return x(toInt(vector.x(), roundingMode)).y(toInt(vector.y(), roundingMode)).z(toInt(vector.z(), roundingMode));
	}
	public Vector3i add(Vector3dr vector, RoundingMode roundingMode)
	{
		return add(toInt(vector.x(), roundingMode), toInt(vector.y(), roundingMode), toInt(vector.z(), roundingMode));
	}

	public Vector3i subtract(Vector3dr vector, RoundingMode roundingMode)
	{
		return subtract(toInt(vector.x(), roundingMode), toInt(vector.y(), roundingMode), toInt(vector.z(), roundingMode));
	}

	public Vector3i multiply(Vector3dr vector, RoundingMode roundingMode)
	{
		return multiply(toInt(vector.x(), roundingMode), toInt(vector.y(), roundingMode), toInt(vector.z(), roundingMode));
	}

	public Vector3i divide(Vector3dr vector, RoundingMode roundingMode)
	{
		return divide(toInt(vector.x(), roundingMode), toInt(vector.y(), roundingMode), toInt(vector.z(), roundingMode));
	}

	public Vector3i setAll(Vector3dr vector, RoundingMode roundingMode)
	{
		return x(toInt(vector.x(), roundingMode)).y(toInt(vector.y(), roundingMode)).z(toInt(vector.z(), roundingMode));
	}
	public Vector3i opposite()
	{
		x = -x;
		y = -y;
		z = -z;
		return this;
	}
	public Vector3i absolute()
	{
		x = abs(x);
		y = abs(y);
		z = abs(z);
		return this;
	}
	public Vector3i conjugate()
	{
		y = -y;
		z = -z;
		return this;
	}
	public Vector3i normalize()
	{
		int a = abs(x()), b;
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
	public Vector3i unitary()
	{
		return normalize();
	}

	public Vector3i addAll(float value, RoundingMode roundingMode)
	{
		return add(value, value, value, roundingMode);
	}
	public Vector3i addAll(int value)
	{
		return add(value, value, value);
	}
	public Vector3i subtractAll(float value, RoundingMode roundingMode)
	{
		return subtract(value, value, value, roundingMode);
	}
	public Vector3i subtractAll(int value)
	{
		return subtract(value, value, value);
	}
	public Vector3i multiplyAll(float value, RoundingMode roundingMode)
	{
		return multiply(value, value, value, roundingMode);
	}
	public Vector3i multiplyAll(int value)
	{
		return multiply(value, value, value);
	}
	public Vector3i divideAll(float value, RoundingMode roundingMode)
	{
		return divide(value, value, value, roundingMode);
	}
	public Vector3i divideAll(int value)
	{
		return divide(value, value, value);
	}

	public int x()
	{
		return x;
	}
	public int y()
	{
		return y;
	}
	public int z()
	{
		return z;
	}
	public Vector3i setX(int x)
	{
		return x(x);
	}
	public Vector3i x(int x)
	{
		this.x = x;
		return this;
	}
	public Vector3i setY(int y)
	{
		return y(y);
	}
	public Vector3i y(int y)
	{
		this.y = y;
		return this;
	}
	public Vector3i setZ(int z)
	{
		return z(z);
	}
	public Vector3i z(int z)
	{
		this.z = z;
		return this;
	}
	public Vector3i setAll(int x, int y)
	{
		return x(x).y(y);
	}
	public Vector3i setAll(int x, int y, int z)
	{
		return x(x).y(y).z(z);
	}
	public String toString()
	{
		StringBuilder ss = new StringBuilder(25);
		return ss.append("Vector3i{").append(x()).append(", ").append(y()).append(", ").append(z()).append("}").toString();
	}
}
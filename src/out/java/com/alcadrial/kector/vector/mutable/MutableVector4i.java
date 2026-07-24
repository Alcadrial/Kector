package com.alcadrial.kector.vector.mutable;

import java.math.RoundingMode;
import static com.alcadrial.kector.Math.*;
import com.alcadrial.kector.vector.AbstractVector4i;
import com.alcadrial.kector.vector.Vector4i;
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
public class MutableVector4i extends AbstractVector4i implements Vector4i {

	protected int x;
	protected int y;
	protected int z;
	protected int w;

	public MutableVector4i(int x, int y, int z, int w)
	{
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
	}
	public MutableVector4i(long x, long y, long z, long w)
	{
		this((int) x, (int) y, (int) z, (int) w);
	}
	public MutableVector4i(float x, float y, float z, float w, RoundingMode roundingMode)
	{
		this(toInt(x, roundingMode), toInt(y, roundingMode), toInt(z, roundingMode), toInt(w, roundingMode));
	}
	public MutableVector4i(double x, double y, double z, double w, RoundingMode roundingMode)
	{
		this(toInt(x, roundingMode), toInt(y, roundingMode), toInt(z, roundingMode), toInt(w, roundingMode));
	}
	public MutableVector4i(Vector2ir vector, int z, int w)
	{
		this(vector.x(), vector.y(), z, w);
	}
	public MutableVector4i(Vector2lr vector, long z, long w)
	{
		this((int) vector.x(), (int) vector.y(), (int) z, (int) w);
	}
	public MutableVector4i(Vector2fr vector, float z, float w, RoundingMode roundingMode)
	{
		this(toInt(vector.x(), roundingMode), toInt(vector.y(), roundingMode), toInt(z, roundingMode), toInt(w, roundingMode));
	}
	public MutableVector4i(Vector2dr vector, double z, double w, RoundingMode roundingMode)
	{
		this(toInt(vector.x(), roundingMode), toInt(vector.y(), roundingMode), toInt(z, roundingMode), toInt(w, roundingMode));
	}
	public MutableVector4i(Vector3ir vector, int w)
	{
		this(vector.x(), vector.y(), vector.z(), w);
	}
	public MutableVector4i(Vector3lr vector, long w)
	{
		this((int) vector.x(), (int) vector.y(), (int) vector.z(), (int) w);
	}
	public MutableVector4i(Vector3fr vector, float w, RoundingMode roundingMode)
	{
		this(toInt(vector.x(), roundingMode), toInt(vector.y(), roundingMode), toInt(vector.z(), roundingMode), toInt(w, roundingMode));
	}
	public MutableVector4i(Vector3dr vector, double w, RoundingMode roundingMode)
	{
		this(toInt(vector.x(), roundingMode), toInt(vector.y(), roundingMode), toInt(vector.z(), roundingMode), toInt(w, roundingMode));
	}
	public MutableVector4i(Vector4ir vector)
	{
		this(vector.x(), vector.y(), vector.z(), vector.w());
	}
	public MutableVector4i(Vector4lr vector)
	{
		this((int) vector.x(), (int) vector.y(), (int) vector.z(), (int) vector.w());
	}
	public MutableVector4i(Vector4fr vector, RoundingMode roundingMode)
	{
		this(toInt(vector.x(), roundingMode), toInt(vector.y(), roundingMode), toInt(vector.z(), roundingMode), toInt(vector.w(), roundingMode));
	}
	public MutableVector4i(Vector4dr vector, RoundingMode roundingMode)
	{
		this(toInt(vector.x(), roundingMode), toInt(vector.y(), roundingMode), toInt(vector.z(), roundingMode), toInt(vector.w(), roundingMode));
	}

	public Vector4i add(Vector2ir vector)
	{
		return add(vector.x(), vector.y());
	}
	public Vector4i add(int x, int y)
	{
		this.x += x;
		this.y += y;
		return this;
	}

	public Vector4i subtract(Vector2ir vector)
	{
		return subtract(vector.x(), vector.y());
	}
	public Vector4i subtract(int x, int y)
	{
		this.x -= x;
		this.y -= y;
		return this;
	}

	public Vector4i multiply(Vector2ir vector)
	{
		return multiply(vector.x(), vector.y());
	}
	public Vector4i multiply(int x, int y)
	{
		this.x *= x;
		this.y *= y;
		return this;
	}

	public Vector4i divide(Vector2ir vector)
	{
		return divide(vector.x(), vector.y());
	}
	public Vector4i divide(int x, int y)
	{
		this.x /= x;
		this.y /= y;
		return this;
	}

	public Vector4i setAll(Vector2ir vector)
	{
		return x(vector.x()).y(vector.y());
	}
	public Vector4i add(Vector2lr vector)
	{
		return add((int) vector.x(), (int) vector.y());
	}

	public Vector4i subtract(Vector2lr vector)
	{
		return subtract((int) vector.x(), (int) vector.y());
	}

	public Vector4i multiply(Vector2lr vector)
	{
		return multiply((int) vector.x(), (int) vector.y());
	}

	public Vector4i divide(Vector2lr vector)
	{
		return divide((int) vector.x(), (int) vector.y());
	}

	public Vector4i setAll(Vector2lr vector)
	{
		return x((int) vector.x()).y((int) vector.y());
	}
	public Vector4i add(Vector2fr vector, RoundingMode roundingMode)
	{
		return add(toInt(vector.x(), roundingMode), toInt(vector.y(), roundingMode));
	}
	public Vector4i add(float x, float y, RoundingMode roundingMode)
	{
		return add(toInt(x, roundingMode), toInt(y, roundingMode), toInt(z, roundingMode), toInt(w, roundingMode));
	}

	public Vector4i subtract(Vector2fr vector, RoundingMode roundingMode)
	{
		return subtract(toInt(vector.x(), roundingMode), toInt(vector.y(), roundingMode));
	}
	public Vector4i subtract(float x, float y, RoundingMode roundingMode)
	{
		return subtract(toInt(x, roundingMode), toInt(y, roundingMode), toInt(z, roundingMode), toInt(w, roundingMode));
	}

	public Vector4i multiply(Vector2fr vector, RoundingMode roundingMode)
	{
		return multiply(toInt(vector.x(), roundingMode), toInt(vector.y(), roundingMode));
	}
	public Vector4i multiply(float x, float y, RoundingMode roundingMode)
	{
		return multiply(toInt(x, roundingMode), toInt(y, roundingMode), toInt(z, roundingMode), toInt(w, roundingMode));
	}

	public Vector4i divide(Vector2fr vector, RoundingMode roundingMode)
	{
		return divide(toInt(vector.x(), roundingMode), toInt(vector.y(), roundingMode));
	}
	public Vector4i divide(float x, float y, RoundingMode roundingMode)
	{
		return divide(toInt(x, roundingMode), toInt(y, roundingMode), toInt(z, roundingMode), toInt(w, roundingMode));
	}

	public Vector4i setAll(Vector2fr vector, RoundingMode roundingMode)
	{
		return x(toInt(vector.x(), roundingMode)).y(toInt(vector.y(), roundingMode));
	}
	public Vector4i add(Vector2dr vector, RoundingMode roundingMode)
	{
		return add(toInt(vector.x(), roundingMode), toInt(vector.y(), roundingMode));
	}

	public Vector4i subtract(Vector2dr vector, RoundingMode roundingMode)
	{
		return subtract(toInt(vector.x(), roundingMode), toInt(vector.y(), roundingMode));
	}

	public Vector4i multiply(Vector2dr vector, RoundingMode roundingMode)
	{
		return multiply(toInt(vector.x(), roundingMode), toInt(vector.y(), roundingMode));
	}

	public Vector4i divide(Vector2dr vector, RoundingMode roundingMode)
	{
		return divide(toInt(vector.x(), roundingMode), toInt(vector.y(), roundingMode));
	}

	public Vector4i setAll(Vector2dr vector, RoundingMode roundingMode)
	{
		return x(toInt(vector.x(), roundingMode)).y(toInt(vector.y(), roundingMode));
	}
	public Vector4i add(Vector3ir vector)
	{
		return add(vector.x(), vector.y(), vector.z());
	}
	public Vector4i add(int x, int y, int z)
	{
		this.x += x;
		this.y += y;
		this.z += z;
		return this;
	}

	public Vector4i subtract(Vector3ir vector)
	{
		return subtract(vector.x(), vector.y(), vector.z());
	}
	public Vector4i subtract(int x, int y, int z)
	{
		this.x -= x;
		this.y -= y;
		this.z -= z;
		return this;
	}

	public Vector4i multiply(Vector3ir vector)
	{
		return multiply(vector.x(), vector.y(), vector.z());
	}
	public Vector4i multiply(int x, int y, int z)
	{
		this.x *= x;
		this.y *= y;
		this.z *= z;
		return this;
	}

	public Vector4i divide(Vector3ir vector)
	{
		return divide(vector.x(), vector.y(), vector.z());
	}
	public Vector4i divide(int x, int y, int z)
	{
		this.x /= x;
		this.y /= y;
		this.z /= z;
		return this;
	}

	public Vector4i crossProduct(Vector3ir vector)
	{
		return crossProduct(vector.x(), vector.y(), vector.z());
	}
	public Vector4i crossProduct(int x, int y, int z)
	{
		int x0 = this.y * z - this.z * y;
		int y0 = this.z * x - this.x * z;
		int z0 = this.x * y - this.y * x;
		this.x = x0;
		this.y = y0;
		this.z = z0;
		return this;
	}

	public Vector4i setAll(Vector3ir vector)
	{
		return x(vector.x()).y(vector.y()).z(vector.z());
	}
	public Vector4i add(Vector3lr vector)
	{
		return add((int) vector.x(), (int) vector.y(), (int) vector.z());
	}

	public Vector4i subtract(Vector3lr vector)
	{
		return subtract((int) vector.x(), (int) vector.y(), (int) vector.z());
	}

	public Vector4i multiply(Vector3lr vector)
	{
		return multiply((int) vector.x(), (int) vector.y(), (int) vector.z());
	}

	public Vector4i divide(Vector3lr vector)
	{
		return divide((int) vector.x(), (int) vector.y(), (int) vector.z());
	}

	public Vector4i crossProduct(Vector3lr vector)
	{
		return crossProduct((int) vector.x(), (int) vector.y(), (int) vector.z());
	}

	public Vector4i setAll(Vector3lr vector)
	{
		return x((int) vector.x()).y((int) vector.y()).z((int) vector.z());
	}
	public Vector4i add(Vector3fr vector, RoundingMode roundingMode)
	{
		return add(toInt(vector.x(), roundingMode), toInt(vector.y(), roundingMode), toInt(vector.z(), roundingMode));
	}
	public Vector4i add(float x, float y, float z, RoundingMode roundingMode)
	{
		return add(toInt(x, roundingMode), toInt(y, roundingMode), toInt(z, roundingMode), toInt(w, roundingMode));
	}

	public Vector4i subtract(Vector3fr vector, RoundingMode roundingMode)
	{
		return subtract(toInt(vector.x(), roundingMode), toInt(vector.y(), roundingMode), toInt(vector.z(), roundingMode));
	}
	public Vector4i subtract(float x, float y, float z, RoundingMode roundingMode)
	{
		return subtract(toInt(x, roundingMode), toInt(y, roundingMode), toInt(z, roundingMode), toInt(w, roundingMode));
	}

	public Vector4i multiply(Vector3fr vector, RoundingMode roundingMode)
	{
		return multiply(toInt(vector.x(), roundingMode), toInt(vector.y(), roundingMode), toInt(vector.z(), roundingMode));
	}
	public Vector4i multiply(float x, float y, float z, RoundingMode roundingMode)
	{
		return multiply(toInt(x, roundingMode), toInt(y, roundingMode), toInt(z, roundingMode), toInt(w, roundingMode));
	}

	public Vector4i divide(Vector3fr vector, RoundingMode roundingMode)
	{
		return divide(toInt(vector.x(), roundingMode), toInt(vector.y(), roundingMode), toInt(vector.z(), roundingMode));
	}
	public Vector4i divide(float x, float y, float z, RoundingMode roundingMode)
	{
		return divide(toInt(x, roundingMode), toInt(y, roundingMode), toInt(z, roundingMode), toInt(w, roundingMode));
	}

	public Vector4i crossProduct(Vector3fr vector, RoundingMode roundingMode)
	{
		return crossProduct(toInt(vector.x(), roundingMode), toInt(vector.y(), roundingMode), toInt(vector.z(), roundingMode));
	}
	public Vector4i crossProduct(float x, float y, float z, RoundingMode roundingMode)
	{
		return crossProduct(toInt(x, roundingMode), toInt(y, roundingMode), toInt(z, roundingMode));
	}

	public Vector4i setAll(Vector3fr vector, RoundingMode roundingMode)
	{
		return x(toInt(vector.x(), roundingMode)).y(toInt(vector.y(), roundingMode)).z(toInt(vector.z(), roundingMode));
	}
	public Vector4i add(Vector3dr vector, RoundingMode roundingMode)
	{
		return add(toInt(vector.x(), roundingMode), toInt(vector.y(), roundingMode), toInt(vector.z(), roundingMode));
	}

	public Vector4i subtract(Vector3dr vector, RoundingMode roundingMode)
	{
		return subtract(toInt(vector.x(), roundingMode), toInt(vector.y(), roundingMode), toInt(vector.z(), roundingMode));
	}

	public Vector4i multiply(Vector3dr vector, RoundingMode roundingMode)
	{
		return multiply(toInt(vector.x(), roundingMode), toInt(vector.y(), roundingMode), toInt(vector.z(), roundingMode));
	}

	public Vector4i divide(Vector3dr vector, RoundingMode roundingMode)
	{
		return divide(toInt(vector.x(), roundingMode), toInt(vector.y(), roundingMode), toInt(vector.z(), roundingMode));
	}

	public Vector4i crossProduct(Vector3dr vector, RoundingMode roundingMode)
	{
		return crossProduct(toInt(vector.x(), roundingMode), toInt(vector.y(), roundingMode), toInt(vector.z(), roundingMode));
	}

	public Vector4i setAll(Vector3dr vector, RoundingMode roundingMode)
	{
		return x(toInt(vector.x(), roundingMode)).y(toInt(vector.y(), roundingMode)).z(toInt(vector.z(), roundingMode));
	}
	public Vector4i add(Vector4ir vector)
	{
		return add(vector.x(), vector.y(), vector.z(), vector.w());
	}
	public Vector4i add(int x, int y, int z, int w)
	{
		this.x += x;
		this.y += y;
		this.z += z;
		this.w += w;
		return this;
	}

	public Vector4i subtract(Vector4ir vector)
	{
		return subtract(vector.x(), vector.y(), vector.z(), vector.w());
	}
	public Vector4i subtract(int x, int y, int z, int w)
	{
		this.x -= x;
		this.y -= y;
		this.z -= z;
		this.w -= w;
		return this;
	}

	public Vector4i multiply(Vector4ir vector)
	{
		return multiply(vector.x(), vector.y(), vector.z(), vector.w());
	}
	public Vector4i multiply(int x, int y, int z, int w)
	{
		this.x *= x;
		this.y *= y;
		this.z *= z;
		this.w *= w;
		return this;
	}

	public Vector4i divide(Vector4ir vector)
	{
		return divide(vector.x(), vector.y(), vector.z(), vector.w());
	}
	public Vector4i divide(int x, int y, int z, int w)
	{
		this.x /= x;
		this.y /= y;
		this.z /= z;
		this.w /= w;
		return this;
	}

	public Vector4i projectiveCrossProduct(Vector4ir vector)
	{
		return projectiveCrossProduct(vector.x(), vector.y(), vector.z(), vector.w());
	}
	public Vector4i projectiveCrossProduct(int x, int y, int z, int w)
	{
		int x0 = this.y * z - this.z * y;
		int y0 = this.z * x - this.x * z;
		int z0 = this.x * y - this.y * x;
		this.x = x0;
		this.y = y0;
		this.z = z0;
		this.w *= w;
		return this;
	}

	public Vector4i setAll(Vector4ir vector)
	{
		return x(vector.x()).y(vector.y()).z(vector.z()).w(vector.w());
	}
	public Vector4i add(Vector4lr vector)
	{
		return add((int) vector.x(), (int) vector.y(), (int) vector.z(), (int) vector.w());
	}

	public Vector4i subtract(Vector4lr vector)
	{
		return subtract((int) vector.x(), (int) vector.y(), (int) vector.z(), (int) vector.w());
	}

	public Vector4i multiply(Vector4lr vector)
	{
		return multiply((int) vector.x(), (int) vector.y(), (int) vector.z(), (int) vector.w());
	}

	public Vector4i divide(Vector4lr vector)
	{
		return divide((int) vector.x(), (int) vector.y(), (int) vector.z(), (int) vector.w());
	}

	public Vector4i projectiveCrossProduct(Vector4lr vector)
	{
		return projectiveCrossProduct((int) vector.x(), (int) vector.y(), (int) vector.z(), (int) vector.w());
	}

	public Vector4i setAll(Vector4lr vector)
	{
		return x((int) vector.x()).y((int) vector.y()).z((int) vector.z()).w((int) vector.w());
	}
	public Vector4i add(Vector4fr vector, RoundingMode roundingMode)
	{
		return add(toInt(vector.x(), roundingMode), toInt(vector.y(), roundingMode), toInt(vector.z(), roundingMode), toInt(vector.w(), roundingMode));
	}
	public Vector4i add(float x, float y, float z, float w, RoundingMode roundingMode)
	{
		return add(toInt(x, roundingMode), toInt(y, roundingMode), toInt(z, roundingMode), toInt(w, roundingMode));
	}

	public Vector4i subtract(Vector4fr vector, RoundingMode roundingMode)
	{
		return subtract(toInt(vector.x(), roundingMode), toInt(vector.y(), roundingMode), toInt(vector.z(), roundingMode), toInt(vector.w(), roundingMode));
	}
	public Vector4i subtract(float x, float y, float z, float w, RoundingMode roundingMode)
	{
		return subtract(toInt(x, roundingMode), toInt(y, roundingMode), toInt(z, roundingMode), toInt(w, roundingMode));
	}

	public Vector4i multiply(Vector4fr vector, RoundingMode roundingMode)
	{
		return multiply(toInt(vector.x(), roundingMode), toInt(vector.y(), roundingMode), toInt(vector.z(), roundingMode), toInt(vector.w(), roundingMode));
	}
	public Vector4i multiply(float x, float y, float z, float w, RoundingMode roundingMode)
	{
		return multiply(toInt(x, roundingMode), toInt(y, roundingMode), toInt(z, roundingMode), toInt(w, roundingMode));
	}

	public Vector4i divide(Vector4fr vector, RoundingMode roundingMode)
	{
		return divide(toInt(vector.x(), roundingMode), toInt(vector.y(), roundingMode), toInt(vector.z(), roundingMode), toInt(vector.w(), roundingMode));
	}
	public Vector4i divide(float x, float y, float z, float w, RoundingMode roundingMode)
	{
		return divide(toInt(x, roundingMode), toInt(y, roundingMode), toInt(z, roundingMode), toInt(w, roundingMode));
	}

	public Vector4i projectiveCrossProduct(Vector4fr vector, RoundingMode roundingMode)
	{
		return projectiveCrossProduct(toInt(vector.x(), roundingMode), toInt(vector.y(), roundingMode), toInt(vector.z(), roundingMode), toInt(vector.w(), roundingMode));
	}
	public Vector4i projectiveCrossProduct(float x, float y, float z, float w, RoundingMode roundingMode)
	{
		return projectiveCrossProduct(toInt(x, roundingMode), toInt(y, roundingMode), toInt(z, roundingMode), toInt(w, roundingMode));
	}

	public Vector4i setAll(Vector4fr vector, RoundingMode roundingMode)
	{
		return x(toInt(vector.x(), roundingMode)).y(toInt(vector.y(), roundingMode)).z(toInt(vector.z(), roundingMode)).w(toInt(vector.w(), roundingMode));
	}
	public Vector4i add(Vector4dr vector, RoundingMode roundingMode)
	{
		return add(toInt(vector.x(), roundingMode), toInt(vector.y(), roundingMode), toInt(vector.z(), roundingMode), toInt(vector.w(), roundingMode));
	}

	public Vector4i subtract(Vector4dr vector, RoundingMode roundingMode)
	{
		return subtract(toInt(vector.x(), roundingMode), toInt(vector.y(), roundingMode), toInt(vector.z(), roundingMode), toInt(vector.w(), roundingMode));
	}

	public Vector4i multiply(Vector4dr vector, RoundingMode roundingMode)
	{
		return multiply(toInt(vector.x(), roundingMode), toInt(vector.y(), roundingMode), toInt(vector.z(), roundingMode), toInt(vector.w(), roundingMode));
	}

	public Vector4i divide(Vector4dr vector, RoundingMode roundingMode)
	{
		return divide(toInt(vector.x(), roundingMode), toInt(vector.y(), roundingMode), toInt(vector.z(), roundingMode), toInt(vector.w(), roundingMode));
	}

	public Vector4i projectiveCrossProduct(Vector4dr vector, RoundingMode roundingMode)
	{
		return projectiveCrossProduct(toInt(vector.x(), roundingMode), toInt(vector.y(), roundingMode), toInt(vector.z(), roundingMode), toInt(vector.w(), roundingMode));
	}

	public Vector4i setAll(Vector4dr vector, RoundingMode roundingMode)
	{
		return x(toInt(vector.x(), roundingMode)).y(toInt(vector.y(), roundingMode)).z(toInt(vector.z(), roundingMode)).w(toInt(vector.w(), roundingMode));
	}
	public Vector4i opposite()
	{
		x = -x;
		y = -y;
		z = -z;
		w = -w;
		return this;
	}
	public Vector4i absolute()
	{
		x = abs(x);
		y = abs(y);
		z = abs(z);
		w = abs(w);
		return this;
	}
	public Vector4i conjugate()
	{
		y = -y;
		z = -z;
		w = -w;
		return this;
	}
	public Vector4i normalize()
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
	public Vector4i unitary()
	{
		return normalize();
	}

	public Vector4i addAll(float value, RoundingMode roundingMode)
	{
		return add(value, value, value, value, roundingMode);
	}
	public Vector4i addAll(int value)
	{
		return add(value, value, value, value);
	}
	public Vector4i subtractAll(float value, RoundingMode roundingMode)
	{
		return subtract(value, value, value, value, roundingMode);
	}
	public Vector4i subtractAll(int value)
	{
		return subtract(value, value, value, value);
	}
	public Vector4i multiplyAll(float value, RoundingMode roundingMode)
	{
		return multiply(value, value, value, value, roundingMode);
	}
	public Vector4i multiplyAll(int value)
	{
		return multiply(value, value, value, value);
	}
	public Vector4i divideAll(float value, RoundingMode roundingMode)
	{
		return divide(value, value, value, value, roundingMode);
	}
	public Vector4i divideAll(int value)
	{
		return divide(value, value, value, value);
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
	public int w()
	{
		return w;
	}
	public Vector4i setX(int x)
	{
		return x(x);
	}
	public Vector4i x(int x)
	{
		this.x = x;
		return this;
	}
	public Vector4i setY(int y)
	{
		return y(y);
	}
	public Vector4i y(int y)
	{
		this.y = y;
		return this;
	}
	public Vector4i setZ(int z)
	{
		return z(z);
	}
	public Vector4i z(int z)
	{
		this.z = z;
		return this;
	}
	public Vector4i setW(int w)
	{
		return w(w);
	}
	public Vector4i w(int w)
	{
		this.w = w;
		return this;
	}
	public Vector4i setAll(int x, int y)
	{
		return x(x).y(y);
	}
	public Vector4i setAll(int x, int y, int z)
	{
		return x(x).y(y).z(z);
	}
	public Vector4i setAll(int x, int y, int z, int w)
	{
		return x(x).y(y).z(z).w(w);
	}
	public String toString()
	{
		StringBuilder ss = new StringBuilder(25);
		return ss.append("Vector4i{").append(x()).append(", ").append(y()).append(", ").append(z()).append(", ").append(w()).append("}").toString();
	}
}
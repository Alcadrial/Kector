package com.alcadra.math.vector.immutable;

import com.alcadra.math.matrix.Matrix3f;
import com.alcadra.math.matrix.Matrix4f;
import com.alcadra.math.point.Point2f;
import com.alcadra.math.vector.AbstractVector2f;
import com.alcadra.math.vector.Vector2f;
import com.alcadra.math.vector.Vector2i;
import com.alcadra.math.vector.Vector3f;
import com.alcadra.math.vector.Vector3i;
import com.alcadra.math.vector.Vector4f;

public class ImmutableVector2f extends AbstractVector2f implements Vector2f, Vector3f, Vector4f {
	
	protected final float X;
	protected final float Y;
	protected final int hashcode;
	
	public ImmutableVector2f(Vector2f vector)
	{
		this(vector.x(), vector.y());
	}
	
	public ImmutableVector2f(Vector2i vector)
	{
		this(vector.x(), vector.y());
	}
	
	public ImmutableVector2f(float x, float y)
	{
		X = x;
		Y = y;
		hashcode = 31 * (31 + Float.floatToIntBits(X)) + Float.floatToIntBits(Y);
	}
	
	@Override
	public Vector2f add(float x, float y)
	{
		return Vector2f.of(X + x, Y + y);
	}
	
	@Override
	public Vector3f add(float x, float y, float z)
	{
		if (z == 0) return add(x, y);
		return Vector2f.of(X + x, Y + y, z);
	}
	
	@Override
	public Vector4f add(float x, float y, float z, float w)
	{
		if (w == 0) return add(x, y, z);
		return Vector2f.of(X + x, Y + y, z, w);
	}
	
	@Override
	public Vector2f subtract(float x, float y)
	{
		return Vector2f.of(X - x, Y - y);
	}
	
	@Override
	public Vector3f subtract(float x, float y, float z)
	{
		if (z == 0) return subtract(x, y);
		return Vector2f.of(X - x, Y - y, -z);
	}
	
	@Override
	public Vector4f subtract(float x, float y, float z, float w)
	{
		if (w == 0) return subtract(x, y, z);
		return Vector2f.of(X - x, Y - y, -z, -w);
	}
	
	@Override
	public Vector2f multiply(float x, float y)
	{
		return Vector2f.of(X * x, Y * y);
	}
	
	@Override
	public Vector2f multiply(float x, float y, float z)
	{
		return multiply(x, y);
	}
	
	@Override
	public Vector2f multiply(float x, float y, float z, float w)
	{
		return multiply(x, y);
	}
	
	@Override
	public Vector2f multiply(Matrix3f matrix)
	{
		float[] m = matrix.toArray();
		float x = X * m[0] + X * m[3] + X * m[6];
		float y = Y * m[1] + Y * m[4] + Y * m[7];
		return Vector2f.of(x, y);
	}
	
	@Override
	public Vector2f multiply(Matrix4f matrix)
	{
		float[] m = matrix.toArray();
		float x = X * m[0] + X * m[4] + X * m[8] + X * m[12];
		float y = Y * m[1] + Y * m[5] + Y * m[9] + Y * m[13];
		return Vector2f.of(x, y);
	}
	
	@Override
	public Vector2f divide(float x, float y)
	{
		return Vector2f.of(X / x, Y / y);
	}
	
	@Override
	public Vector2f divide(float x, float y, float z)
	{
		return divide(x, y);
	}
	
	@Override
	public Vector2f divide(float x, float y, float z, float w)
	{
		return divide(x, y);
	}
	
	@Override
	public Vector3f crossProduct(Vector3f vector)
	{
		return Vector2f.of(Y * vector.z(), -X * vector.z(), X * vector.y() - Y * vector.x());
	}
	
	@Override
	public Vector3f crossProduct(Vector3i vector)
	{
		return Vector2f.of(Y * vector.z(), -X * vector.z(), X * vector.y() - Y * vector.x());
	}
	
	@Override
	public Vector2f perpendicular()
	{
		return Vector2f.of(-Y, X);
	}
	
	@Override
	public Vector2f opposite()
	{
		return Vector2f.of(-X, -Y);
	}
	
	@Override
	public Vector2f absolute()
	{
		return Vector2f.of(X < 0 ? -X : X, Y < 0 ? -Y : Y);
	}
	
	@Override
	public Vector2f conjugate()
	{
		return Vector2f.of(X, -Y);
	}
	
	@Override
	public float x()
	{
		return X;
	}
	
	@Override
	public float y()
	{
		return Y;
	}
	
	@Override
	public float z()
	{
		return 0;
	}
	
	@Override
	public float w()
	{
		return 0;
	}
	
	@Override
	public Vector2f setX(float x)
	{
		return Vector2f.of(x, Y);
	}
	
	@Override
	public Vector2f setY(float y)
	{
		return Vector2f.of(X, y);
	}
	
	@Override
	public Vector3f setZ(float z)
	{
		if (z == 0) return this;
		return Vector2f.of(X, Y, z);
	}
	
	@Override
	public Vector4f setW(float w)
	{
		if (w == 0) return this;
		return Vector2f.of(X, Y, 0, w);
	}
	
	@Override
	public Vector2f setAll(float x, float y)
	{
		return Vector2f.of(x, y);
	}
	
	@Override
	public Vector3f setAll(float x, float y, float z)
	{
		if (z == 0) return setAll(x, y);
		return Vector2f.of(x, y, z);
	}
	
	@Override
	public Vector4f setAll(float x, float y, float z, float w)
	{
		if (w == 0) return setAll(x, y, z);
		return Vector2f.of(x, y, z, w);
	}
	
	@Override
	public Vector2f xy()
	{
		return Vector2f.of(X, Y);
	}
	
	@Override
	public Vector2f zw()
	{
		return Vector2f.origin();
	}
	
	@Override
	public Vector3f xy1()
	{
		return Vector2f.of(X, Y, 1);
	}
	
	@Override
	public Vector2f xyz()
	{
		return Vector2f.of(X, Y);
	}
	
	@Override
	public Vector4f xyz1()
	{
		return Vector2f.of(X, Y, 0, 1);
	}
	
	@Override
	public Vector2f xz()
	{
		return Vector2f.of(X, 0);
	}
	
	@Override
	public Vector2f yzw()
	{
		return Vector2f.of(Y, 0);
	}
	
	@Override
	public Vector4f zwxy()
	{
		return Vector2f.of(0, 0, X, Y);
	}
	
	@Override
	public Point2f asPoint()
	{
		return new Point2f(X, Y);
	}
	
	@Override
	public int hashCode()
	{
		return hashcode;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		return obj instanceof Vector2f v && v.x() == X && v.y() == Y;
	}
	
	@Override
	public String toString()
	{
		return "Vector2f{x=" + X + ", y=" + Y + "}";
	}
}

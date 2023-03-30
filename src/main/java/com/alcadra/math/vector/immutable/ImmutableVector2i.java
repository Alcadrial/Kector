package com.alcadra.math.vector.immutable;

import java.math.RoundingMode;

import com.alcadra.math.Math;
import com.alcadra.math.matrix.Matrix3f;
import com.alcadra.math.matrix.Matrix4f;
import com.alcadra.math.point.Point2f;
import com.alcadra.math.vector.AbstractVector2i;
import com.alcadra.math.vector.Vector2f;
import com.alcadra.math.vector.Vector2i;
import com.alcadra.math.vector.Vector3f;
import com.alcadra.math.vector.Vector3i;
import com.alcadra.math.vector.Vector4f;
import com.alcadra.math.vector.Vector4i;

public class ImmutableVector2i extends AbstractVector2i {
	
	protected final int X;
	protected final int Y;
	protected final int hashcode;
	
	public ImmutableVector2i(Vector2i vector)
	{
		this(vector.x(), vector.y());
	}
	
	public ImmutableVector2i(Vector2f vector)
	{
		this(vector, RoundingMode.DOWN);
	}
	
	public ImmutableVector2i(Vector2f vector, RoundingMode roundingMode)
	{
		this(Math.toInt(vector.x(), roundingMode), Math.toInt(vector.y(), roundingMode));
	}
	
	public ImmutableVector2i(float x, float y)
	{
		this(x, y, RoundingMode.DOWN);
	}
	
	public ImmutableVector2i(float x, float y, RoundingMode roundingMode)
	{
		this(Math.toInt(x, roundingMode), Math.toInt(y, roundingMode));
	}
	
	public ImmutableVector2i(int x, int y)
	{
		X = x;
		Y = y;
		hashcode = 31 * (31 + X) + Y;
	}
	
	@Override
	public Vector2i add(int x, int y)
	{
		return Vector2i.of(X + x, Y + y);
	}
	
	@Override
	public Vector3i add(int x, int y, int z)
	{
		if (z == 0) return add(x, y);
		return Vector2i.of(X + x, Y + y, z);
	}
	
	@Override
	public Vector4i add(int x, int y, int z, int w)
	{
		if (w == 0) return add(x, y, z);
		return Vector2i.of(X + x, Y + y, z, w);
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
	public Vector2i subtract(int x, int y)
	{
		return Vector2i.of(X - x, Y - y);
	}
	
	@Override
	public Vector3i subtract(int x, int y, int z)
	{
		if (z == 0) return subtract(x, y);
		return Vector2i.of(X - x, Y - y, -z);
	}
	
	@Override
	public Vector4i subtract(int x, int y, int z, int w)
	{
		if (w == 0) return subtract(x, y, z);
		return Vector2i.of(X - x, Y - y, -z, -w);
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
	public Vector2i multiply(int x, int y)
	{
		return Vector2i.of(X * x, Y * y);
	}
	
	@Override
	public Vector2i multiply(int x, int y, int z)
	{
		return multiply(x, y);
	}
	
	@Override
	public Vector2i multiply(int x, int y, int z, int w)
	{
		return multiply(x, y);
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
	public Vector2i divide(int x, int y)
	{
		return Vector2i.of(X / x, Y / y);
	}
	
	@Override
	public Vector2i divide(int x, int y, int z)
	{
		return divide(x, y);
	}
	
	@Override
	public Vector2i divide(int x, int y, int z, int w)
	{
		return divide(x, y);
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
	public Vector3i crossProduct(Vector3i vector)
	{
		return Vector2i.of(Y * vector.z(), -X * vector.z(), X * vector.y() - Y * vector.x());
	}
	
	@Override
	public Vector3f crossProduct(Vector3f vector)
	{
		return Vector2f.of(Y * vector.z(), -X * vector.z(), X * vector.y() - Y * vector.x());
	}
	
	@Override
	public Vector2i perpendicular()
	{
		return Vector2i.of(-Y, X);
	}
	
	@Override
	public Vector2i opposite()
	{
		return Vector2i.of(-X, -Y);
	}
	
	@Override
	public Vector2i absolute()
	{
		return Vector2i.of(X < 0 ? -X : X, Y < 0 ? -Y : Y);
	}
	
	@Override
	public Vector2i conjugate()
	{
		return Vector2i.of(X, -Y);
	}
	
	@Override
	public int x()
	{
		return X;
	}
	
	@Override
	public int y()
	{
		return Y;
	}
	
	@Override
	public int z()
	{
		return 0;
	}
	
	@Override
	public int w()
	{
		return 0;
	}
	
	@Override
	public Vector2i setX(int x)
	{
		return Vector2i.of(x, Y);
	}
	
	@Override
	public Vector2i setY(int y)
	{
		return Vector2i.of(X, y);
	}
	
	@Override
	public Vector3i setZ(int z)
	{
		if (z == 0) return this;
		return Vector2i.of(X, Y, z);
	}
	
	@Override
	public Vector4i setW(int w)
	{
		if (w == 0) return this;
		return Vector2i.of(X, Y, 0, w);
	}
	
	@Override
	public Vector2i setAll(int x, int y)
	{
		return Vector2i.of(x, y);
	}
	
	@Override
	public Vector3i setAll(int x, int y, int z)
	{
		if (z == 0) return setAll(x, y);
		return Vector2i.of(x, y, z);
	}
	
	@Override
	public Vector4i setAll(int x, int y, int z, int w)
	{
		if (w == 0) return setAll(x, y, z);
		return Vector2i.of(x, y, z, w);
	}
	
	@Override
	public Vector2i xy()
	{
		return Vector2i.of(X, Y);
	}
	
	@Override
	public Vector3i xy1()
	{
		return Vector2i.of(X, Y, 1);
	}
	
	@Override
	public Vector2i xyz()
	{
		return Vector2i.of(X, Y);
	}
	
	@Override
	public Vector4i xyz1()
	{
		return Vector2i.of(X, Y, 0, 1);
	}
	
	@Override
	public Vector2i xz()
	{
		return Vector2i.of(X, 0);
	}
	
	@Override
	public Vector2i yzw()
	{
		return Vector2i.of(Y, 0);
	}
	
	@Override
	public Vector4i zwxy()
	{
		return Vector2i.of(0, 0, X, Y);
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
		return obj instanceof Vector2i v && v.x() == X && v.y() == Y;
	}
	
	@Override
	public String toString()
	{
		return "Vector2i{x=" + X + ", y=" + Y + "}";
	}
}

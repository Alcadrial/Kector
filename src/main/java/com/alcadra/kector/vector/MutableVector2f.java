package com.alcadra.kector.vector;

import com.alcadra.kector.matrix.Matrix3f;
import com.alcadra.kector.matrix.Matrix4f;
import com.alcadra.kector.point.Point2f;

public class MutableVector2f extends AbstractVector2f implements Vector2f, Vector3f, Vector4f {
	
	protected float X;
	protected float Y;
	
	public MutableVector2f(Vector2f vector)
	{
		this(vector.x(), vector.y());
	}
	
	public MutableVector2f(Vector2i vector)
	{
		this(vector.x(), vector.y());
	}
	
	public MutableVector2f(float x, float y)
	{
		X = x;
		Y = y;
	}
	
	@Override
	public Vector2f add(float x, float y)
	{
		X += x;
		Y += y;
		return this;
	}
	
	@Override
	public Vector3f add(float x, float y, float z)
	{
		if (z == 0) return add(x, y);
		return new MutableVector3f(X + x, Y + y, z);
	}
	
	@Override
	public Vector4f add(float x, float y, float z, float w)
	{
		if (w == 0) return add(x, y, z);
		return new MutableVector4f(X + x, Y + y, z, w);
	}
	
	@Override
	public Vector2f subtract(float x, float y)
	{
		X -= x;
		Y -= y;
		return this;
	}
	
	@Override
	public Vector3f subtract(float x, float y, float z)
	{
		if (z == 0) return subtract(x, y);
		return new MutableVector3f(X - x, Y - y, -z);
	}
	
	@Override
	public Vector4f subtract(float x, float y, float z, float w)
	{
		if (w == 0) return subtract(x, y, z);
		return new MutableVector4f(X - x, Y - y, -z, -w);
	}
	
	@Override
	public Vector2f multiply(float x, float y)
	{
		X *= x;
		Y *= y;
		return this;
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
		X = x;
		Y = y;
		return this;
	}
	
	@Override
	public Vector2f multiply(Matrix4f matrix)
	{
		float[] m = matrix.toArray();
		float x = X * m[0] + X * m[4] + X * m[8] + X * m[12];
		float y = Y * m[1] + Y * m[5] + Y * m[9] + Y * m[13];
		X = x;
		Y = y;
		return this;
	}
	
	@Override
	public Vector2f divide(float x, float y)
	{
		X /= x;
		Y /= y;
		return this;
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
		return new MutableVector3f(Y * vector.z(), -X * vector.z(), X * vector.y() - Y * vector.x());
	}
	
	@Override
	public Vector3f crossProduct(Vector3i vector)
	{
		return new MutableVector3f(Y * vector.z(), -X * vector.z(), X * vector.y() - Y * vector.x());
	}
	
	@Override
	public Vector2f perpendicular()
	{
		float x = X;
		X = -Y;
		Y = x;
		return this;
	}
	
	@Override
	public Vector2f opposite()
	{
		X = -X;
		Y = -Y;
		return this;
	}
	
	@Override
	public Vector2f absolute()
	{
		if (X < 0) X = -X;
		if (Y < 0) Y = -Y;
		return this;
	}
	
	@Override
	public Vector2f conjugate()
	{
		Y = -Y;
		return this;
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
		X = x;
		return this;
	}
	
	@Override
	public Vector2f setY(float y)
	{
		Y = y;
		return this;
	}
	
	@Override
	public Vector3f setZ(float z)
	{
		if (z == 0) return this;
		return Vector3f.of(X, Y, z);
	}
	
	@Override
	public Vector4f setW(float w)
	{
		if (w == 0) return this;
		return Vector4f.of(X, Y, 0, w);
	}
	
	@Override
	public Vector2f setAll(float x, float y)
	{
		X = x;
		Y = y;
		return this;
	}
	
	@Override
	public Vector3f setAll(float x, float y, float z)
	{
		if (z == 0) return setAll(x, y);
		return Vector3f.of(x, y, z);
	}
	
	@Override
	public Vector4f setAll(float x, float y, float z, float w)
	{
		if (w == 0) return setAll(x, y, z);
		return Vector4f.of(x, y, z, w);
	}
	
	@Override
	public Vector2f xy()
	{
		return new MutableVector2f(X, Y);
	}
	
	@Override
	public Vector2f zw()
	{
		return Vector2f.origin();
	}
	
	@Override
	public Vector3f xy1()
	{
		return new MutableVector3f(X, Y, 1);
	}
	
	@Override
	public Vector2f xyz()
	{
		return new MutableVector2f(X, Y);
	}
	
	@Override
	public Vector4f xyz1()
	{
		return new MutableVector4f(X, Y, 0, 1);
	}
	
	@Override
	public Vector2f xz()
	{
		return new MutableVector2f(X, 0);
	}
	
	@Override
	public Vector2f yzw()
	{
		return new MutableVector2f(Y, 0);
	}
	
	@Override
	public Vector4f zwxy()
	{
		return new MutableVector4f(0, 0, X, Y);
	}
	
	@Override
	public Point2f asPoint()
	{
		return new Point2f(X, Y);
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

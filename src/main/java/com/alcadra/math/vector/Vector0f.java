package com.alcadra.math.vector;

import com.alcadra.math.matrix.Matrix3f;
import com.alcadra.math.matrix.Matrix4f;
import com.alcadra.math.point.Point1f;

public class Vector0f extends AbstractVector2f {
	
	public static final Vector0f ORIGIN = new Vector0f();
	
	private Vector0f()
	{}
	
	@Override
	public Vector2f add(float x, float y)
	{
		return new MutableVector2f(x, y);
	}
	
	@Override
	public Vector3f add(float x, float y, float z)
	{
		return new MutableVector3f(x, y, z);
	}
	
	@Override
	public Vector4f add(float x, float y, float z, float w)
	{
		return new MutableVector4f(x, y, z, w);
	}
	
	@Override
	public Vector2f subtract(float x, float y)
	{
		return new MutableVector2f(-x, -y);
	}
	
	@Override
	public Vector3f subtract(float x, float y, float z)
	{
		return new MutableVector3f(-x, -y, -z);
	}
	
	@Override
	public Vector4f subtract(float x, float y, float z, float w)
	{
		return new MutableVector4f(-x, -y, -z, -w);
	}
	
	@Override
	public Vector2f multiply(float x, float y)
	{
		return this;
	}
	
	@Override
	public Vector3f multiply(float x, float y, float z)
	{
		return this;
	}
	
	@Override
	public Vector4f multiply(float x, float y, float z, float w)
	{
		return this;
	}
	
	@Override
	public Vector3f multiply(Matrix3f matrix)
	{
		return this;
	}
	
	@Override
	public Vector4f multiply(Matrix4f matrix)
	{
		return this;
	}
	
	@Override
	public Vector2f divide(float x, float y)
	{
		return this;
	}
	
	@Override
	public Vector3f divide(float x, float y, float z)
	{
		return this;
	}
	
	@Override
	public Vector4f divide(float x, float y, float z, float w)
	{
		return this;
	}
	
	@Override
	public Vector3f crossProduct(Vector3f vector)
	{
		throw new ArithmeticException("0-dimensional vectors have no cross product");
	}
	
	@Override
	public Vector3f crossProduct(Vector3i vector)
	{
		throw new ArithmeticException("0-dimensional vectors have no cross product");
	}
	
	@Override
	public Vector2f perpendicular()
	{
		throw new ArithmeticException("0-dimensional vectors have no perpendicular");
	}
	
	@Override
	public Vector2f opposite()
	{
		return this;
	}
	
	@Override
	public Vector2f absolute()
	{
		return this;
	}
	
	@Override
	public Vector2f conjugate()
	{
		return this;
	}
	
	@Override
	public float x()
	{
		return 0;
	}
	
	@Override
	public float y()
	{
		return 0;
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
		if (x == 0) return this;
		return Vector2f.of(x, 0);
	}
	
	@Override
	public Vector2f setY(float y)
	{
		if (y == 0) return this;
		return Vector2f.of(0, y);
	}
	
	@Override
	public Vector3f setZ(float z)
	{
		if (z == 0) return this;
		return Vector3f.of(0, 0, z);
	}
	
	@Override
	public Vector4f setW(float w)
	{
		if (w == 0) return this;
		return Vector4f.of(0, 0, 0, w);
	}
	
	@Override
	public Vector2f setAll(float x, float y)
	{
		if (x == 0 && y == 0) return this;
		return Vector2f.of(x, y);
	}
	
	@Override
	public Vector3f setAll(float x, float y, float z)
	{
		if (x == 0 && y == 0 && z == 0) return this;
		return Vector3f.of(x, y, z);
	}
	
	@Override
	public Vector4f setAll(float x, float y, float z, float w)
	{
		if (x == 0 && y == 0 && z == 0 && w == 0) return this;
		return Vector4f.of(x, y, z, w);
	}
	
	@Override
	public Vector3f xy1()
	{
		return Vector3f.of(0, 0, 1);
	}
	
	@Override
	public Vector4f xyz1()
	{
		return Vector4f.of(0, 0, 0, 1);
	}
	
	@Override
	public Vector2f xy()
	{
		return this;
	}
	
	@Override
	public Vector2f xz()
	{
		return this;
	}
	
	@Override
	public Vector3f xyz()
	{
		return this;
	}
	
	@Override
	public Vector3f yzw()
	{
		return this;
	}
	
	@Override
	public Vector4f zwxy()
	{
		return this;
	}
	
	@Override
	public Point1f asPoint()
	{
		return new Point1f(0);
	}
}

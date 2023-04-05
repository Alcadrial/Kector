package com.alcadrial.kector.vector;

import com.alcadrial.kector.matrix.Matrix3f;
import com.alcadrial.kector.matrix.Matrix4f;
import com.alcadrial.kector.point.Point1f;

public class Vector0i extends AbstractVector2i {
	
	public static final Vector0i ORIGIN = new Vector0i();
	
	private Vector0i()
	{}
	
	@Override
	public Vector2i add(int x, int y)
	{
		return new MutableVector2i(x, y);
	}
	
	@Override
	public Vector3i add(int x, int y, int z)
	{
		return new MutableVector3i(x, y, z);
	}
	
	@Override
	public Vector4i add(int x, int y, int z, int w)
	{
		return new MutableVector4i(x, y, z, w);
	}
	
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
	public Vector2i subtract(int x, int y)
	{
		return new MutableVector2i(-x, -y);
	}
	
	@Override
	public Vector3i subtract(int x, int y, int z)
	{
		return new MutableVector3i(-x, -y, -z);
	}
	
	@Override
	public Vector4i subtract(int x, int y, int z, int w)
	{
		return new MutableVector4i(-x, -y, -z, -w);
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
	public Vector0i multiply(int x, int y)
	{
		return this;
	}
	
	@Override
	public Vector0i multiply(int x, int y, int z)
	{
		return this;
	}
	
	@Override
	public Vector0i multiply(int x, int y, int z, int w)
	{
		return this;
	}
	
	@Override
	public Vector0f multiply(float x, float y)
	{
		return Vector0f.ORIGIN;
	}
	
	@Override
	public Vector0f multiply(float x, float y, float z)
	{
		return Vector0f.ORIGIN;
	}
	
	@Override
	public Vector0f multiply(float x, float y, float z, float w)
	{
		return Vector0f.ORIGIN;
	}
	
	@Override
	public Vector0f multiply(Matrix3f matrix)
	{
		return Vector0f.ORIGIN;
	}
	
	@Override
	public Vector0f multiply(Matrix4f matrix)
	{
		return Vector0f.ORIGIN;
	}
	
	@Override
	public Vector0i divide(int x, int y)
	{
		return this;
	}
	
	@Override
	public Vector0i divide(int x, int y, int z)
	{
		return this;
	}
	
	@Override
	public Vector0i divide(int x, int y, int z, int w)
	{
		return this;
	}
	
	@Override
	public Vector0f divide(float x, float y)
	{
		return Vector0f.ORIGIN;
	}
	
	@Override
	public Vector0f divide(float x, float y, float z)
	{
		return Vector0f.ORIGIN;
	}
	
	@Override
	public Vector0f divide(float x, float y, float z, float w)
	{
		return Vector0f.ORIGIN;
	}
	
	@Override
	public Vector3i crossProduct(Vector3i vector)
	{
		throw new ArithmeticException("0-dimensional vectors have no cross product");
	}
	
	@Override
	public Vector3f crossProduct(Vector3f vector)
	{
		throw new ArithmeticException("0-dimensional vectors have no cross product");
	}
	
	@Override
	public Vector2i perpendicular()
	{
		throw new ArithmeticException("0-dimensional vectors have no perpendicular");
	}
	
	@Override
	public Vector2i opposite()
	{
		return this;
	}
	
	@Override
	public Vector2i absolute()
	{
		return this;
	}
	
	@Override
	public Vector2i conjugate()
	{
		return this;
	}
	
	@Override
	public int x()
	{
		return 0;
	}
	
	@Override
	public int y()
	{
		return 0;
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
		if (x == 0) return this;
		return Vector2i.of(x, 0);
	}
	
	@Override
	public Vector2i setY(int y)
	{
		if (y == 0) return this;
		return Vector2i.of(0, y);
	}
	
	@Override
	public Vector3i setZ(int z)
	{
		if (z == 0) return this;
		return Vector3i.of(0, 0, z);
	}
	
	@Override
	public Vector4i setW(int w)
	{
		if (w == 0) return this;
		return Vector4i.of(0, 0, 0, w);
	}
	
	@Override
	public Vector2i setAll(int x, int y)
	{
		if (x == 0 && y == 0) return this;
		return Vector2i.of(x, y);
	}
	
	@Override
	public Vector3i setAll(int x, int y, int z)
	{
		if (x == 0 && y == 0 && z == 0) return this;
		return Vector3i.of(x, y, z);
	}
	
	@Override
	public Vector4i setAll(int x, int y, int z, int w)
	{
		if (x == 0 && y == 0 && z == 0 && w == 0) return this;
		return Vector4i.of(x, y, z, w);
	}
	
	@Override
	public Vector3i xy1()
	{
		return Vector3i.of(0, 0, 1);
	}
	
	@Override
	public Vector4i xyz1()
	{
		return Vector4i.of(0, 0, 0, 1);
	}
	
	@Override
	public Vector2i xy()
	{
		return this;
	}
	
	@Override
	public Vector2i xz()
	{
		return this;
	}
	
	@Override
	public Vector3i xyz()
	{
		return this;
	}
	
	@Override
	public Vector3i yzw()
	{
		return this;
	}
	
	@Override
	public Vector4i zwxy()
	{
		return this;
	}
	
	@Override
	public Point1f asPoint()
	{
		return new Point1f(0);
	}
}

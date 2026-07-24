package com.alcadrial.kector.vector;

import com.alcadrial.kector.vector.mutable.MutableVector4f;

/**
 * A 4-dimensional vector {X, Y, Z, W}
 */
public interface Vector4f extends Vector4fr, Vector3f {

	static Vector4f of()
	{
		return new MutableVector4f(0, 0, 0, 0);
	}
	
	static Vector4f of(float x, float y, float z, float w)
	{
		return new MutableVector4f(x, y, z, w);
	}
	
	static Vector4f of(Vector2ir value, int z, int w)
	{
		return new MutableVector4f(value, z, w);
	}

	static Vector4f of(Vector2lr value, long z, long w)
	{
		return new MutableVector4f(value, z, w);
	}

	static Vector4f of(Vector2fr value, float z, float w)
	{
		return new MutableVector4f(value, z, w);
	}

	static Vector4f of(Vector2dr value, double z, double w)
	{
		return new MutableVector4f(value, z, w);
	}

	static Vector4f of(Vector3ir value, int w)
	{
		return new MutableVector4f(value, w);
	}

	static Vector4f of(Vector3lr value, long w)
	{
		return new MutableVector4f(value, w);
	}

	static Vector4f of(Vector3fr value, float w)
	{
		return new MutableVector4f(value, w);
	}

	static Vector4f of(Vector3dr value, double w)
	{
		return new MutableVector4f(value, w);
	}

	static Vector4f of(Vector4ir value)
	{
		return new MutableVector4f(value);
	}

	static Vector4f of(Vector4lr value)
	{
		return new MutableVector4f(value);
	}

	static Vector4f of(Vector4fr value)
	{
		return new MutableVector4f(value);
	}

	static Vector4f of(Vector4dr value)
	{
		return new MutableVector4f(value);
	}

	Vector4f add(Vector4ir vector);
	Vector4f add(Vector4lr vector);
	Vector4f add(Vector4fr vector);
	Vector4f add(Vector4dr vector);
	Vector4f add(float x, float y, float z, float w);
	Vector4f add(int x, int y, int z, int w);
	Vector4f addAll(int value);
	Vector4f addAll(float value);

	Vector4f subtract(Vector4ir vector);
	Vector4f subtract(Vector4lr vector);
	Vector4f subtract(Vector4fr vector);
	Vector4f subtract(Vector4dr vector);
	Vector4f subtract(float x, float y, float z, float w);
	Vector4f subtract(int x, int y, int z, int w);
	Vector4f subtractAll(int value);
	Vector4f subtractAll(float value);

	Vector4f multiply(Vector4ir vector);
	Vector4f multiply(Vector4lr vector);
	Vector4f multiply(Vector4fr vector);
	Vector4f multiply(Vector4dr vector);
	Vector4f multiply(float x, float y, float z, float w);
	Vector4f multiply(int x, int y, int z, int w);
	Vector4f multiplyAll(int value);
	Vector4f multiplyAll(float value);

	Vector4f divide(Vector4ir vector);
	Vector4f divide(Vector4lr vector);
	Vector4f divide(Vector4fr vector);
	Vector4f divide(Vector4dr vector);
	Vector4f divide(float x, float y, float z, float w);
	Vector4f divide(int x, int y, int z, int w);
	Vector4f divideAll(int value);
	Vector4f divideAll(float value);

	Vector4f projectiveCrossProduct(Vector4ir vector);
	Vector4f projectiveCrossProduct(Vector4lr vector);
	Vector4f projectiveCrossProduct(Vector4fr vector);
	Vector4f projectiveCrossProduct(Vector4dr vector);
	Vector4f projectiveCrossProduct(float x, float y, float z, float w);
	Vector4f projectiveCrossProduct(int x, int y, int z, int w);

	Vector4f opposite();
	Vector4f absolute();
	Vector4f conjugate();
	Vector4f normalize();
	Vector4f unitary();

	float getX();
	float x();
	float getY();
	float y();
	float getZ();
	float z();
	float getW();
	float w();

	Vector4f setX(float x);
	Vector4f x(float x);
	Vector4f setY(float y);
	Vector4f y(float y);
	Vector4f setZ(float z);
	Vector4f z(float z);
	Vector4f setW(float w);
	Vector4f w(float w);

	Vector4f setAll(float x, float y, float z, float w);
	Vector4f setAll(Vector4ir vector);
	Vector4f setAll(Vector4lr vector);
	Vector4f setAll(Vector4fr vector);
	Vector4f setAll(Vector4dr vector);

}
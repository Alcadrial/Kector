package com.alcadrial.kector.vector;

import com.alcadrial.kector.vector.mutable.MutableVector3f;

/**
 * A 3-dimensional vector {X, Y, Z}
 */
public interface Vector3f extends Vector3fr, Vector2f {

	static Vector3f of()
	{
		return new MutableVector3f(0, 0, 0);
	}
	
	static Vector3f of(float x, float y, float z)
	{
		return new MutableVector3f(x, y, z);
	}
	
	static Vector3f of(Vector2ir value, int z)
	{
		return new MutableVector3f(value, z);
	}

	static Vector3f of(Vector2lr value, long z)
	{
		return new MutableVector3f(value, z);
	}

	static Vector3f of(Vector2fr value, float z)
	{
		return new MutableVector3f(value, z);
	}

	static Vector3f of(Vector2dr value, double z)
	{
		return new MutableVector3f(value, z);
	}

	static Vector3f of(Vector3ir value)
	{
		return new MutableVector3f(value);
	}

	static Vector3f of(Vector3lr value)
	{
		return new MutableVector3f(value);
	}

	static Vector3f of(Vector3fr value)
	{
		return new MutableVector3f(value);
	}

	static Vector3f of(Vector3dr value)
	{
		return new MutableVector3f(value);
	}

	Vector3f add(Vector3ir vector);
	Vector3f add(Vector3lr vector);
	Vector3f add(Vector3fr vector);
	Vector3f add(Vector3dr vector);
	Vector3f add(float x, float y, float z);
	Vector3f add(int x, int y, int z);
	Vector3f addAll(int value);
	Vector3f addAll(float value);

	Vector3f subtract(Vector3ir vector);
	Vector3f subtract(Vector3lr vector);
	Vector3f subtract(Vector3fr vector);
	Vector3f subtract(Vector3dr vector);
	Vector3f subtract(float x, float y, float z);
	Vector3f subtract(int x, int y, int z);
	Vector3f subtractAll(int value);
	Vector3f subtractAll(float value);

	Vector3f multiply(Vector3ir vector);
	Vector3f multiply(Vector3lr vector);
	Vector3f multiply(Vector3fr vector);
	Vector3f multiply(Vector3dr vector);
	Vector3f multiply(float x, float y, float z);
	Vector3f multiply(int x, int y, int z);
	Vector3f multiplyAll(int value);
	Vector3f multiplyAll(float value);

	Vector3f divide(Vector3ir vector);
	Vector3f divide(Vector3lr vector);
	Vector3f divide(Vector3fr vector);
	Vector3f divide(Vector3dr vector);
	Vector3f divide(float x, float y, float z);
	Vector3f divide(int x, int y, int z);
	Vector3f divideAll(int value);
	Vector3f divideAll(float value);

	Vector3f crossProduct(Vector3ir vector);
	Vector3f crossProduct(Vector3lr vector);
	Vector3f crossProduct(Vector3fr vector);
	Vector3f crossProduct(Vector3dr vector);
	Vector3f crossProduct(float x, float y, float z);
	Vector3f crossProduct(int x, int y, int z);

	Vector3f opposite();
	Vector3f absolute();
	Vector3f conjugate();
	Vector3f normalize();
	Vector3f unitary();

	float getX();
	float x();
	float getY();
	float y();
	float getZ();
	float z();

	Vector3f setX(float x);
	Vector3f x(float x);
	Vector3f setY(float y);
	Vector3f y(float y);
	Vector3f setZ(float z);
	Vector3f z(float z);

	Vector3f setAll(float x, float y, float z);
	Vector3f setAll(Vector3ir vector);
	Vector3f setAll(Vector3lr vector);
	Vector3f setAll(Vector3fr vector);
	Vector3f setAll(Vector3dr vector);

}
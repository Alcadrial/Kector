package com.alcadrial.kector.vector;

import com.alcadrial.kector.vector.mutable.MutableVector3d;

/**
 * A 3-dimensional vector {X, Y, Z}
 */
public interface Vector3d extends Vector3dr, Vector2d {

	static Vector3d of()
	{
		return new MutableVector3d(0, 0, 0);
	}
	
	static Vector3d of(double x, double y, double z)
	{
		return new MutableVector3d(x, y, z);
	}
	
	static Vector3d of(Vector2ir value, int z)
	{
		return new MutableVector3d(value, z);
	}

	static Vector3d of(Vector2lr value, long z)
	{
		return new MutableVector3d(value, z);
	}

	static Vector3d of(Vector2fr value, float z)
	{
		return new MutableVector3d(value, z);
	}

	static Vector3d of(Vector2dr value, double z)
	{
		return new MutableVector3d(value, z);
	}

	static Vector3d of(Vector3ir value)
	{
		return new MutableVector3d(value);
	}

	static Vector3d of(Vector3lr value)
	{
		return new MutableVector3d(value);
	}

	static Vector3d of(Vector3fr value)
	{
		return new MutableVector3d(value);
	}

	static Vector3d of(Vector3dr value)
	{
		return new MutableVector3d(value);
	}

	Vector3d add(Vector3ir vector);
	Vector3d add(Vector3lr vector);
	Vector3d add(Vector3fr vector);
	Vector3d add(Vector3dr vector);
	Vector3d add(double x, double y, double z);
	Vector3d add(long x, long y, long z);
	Vector3d addAll(long value);
	Vector3d addAll(double value);

	Vector3d subtract(Vector3ir vector);
	Vector3d subtract(Vector3lr vector);
	Vector3d subtract(Vector3fr vector);
	Vector3d subtract(Vector3dr vector);
	Vector3d subtract(double x, double y, double z);
	Vector3d subtract(long x, long y, long z);
	Vector3d subtractAll(long value);
	Vector3d subtractAll(double value);

	Vector3d multiply(Vector3ir vector);
	Vector3d multiply(Vector3lr vector);
	Vector3d multiply(Vector3fr vector);
	Vector3d multiply(Vector3dr vector);
	Vector3d multiply(double x, double y, double z);
	Vector3d multiply(long x, long y, long z);
	Vector3d multiplyAll(long value);
	Vector3d multiplyAll(double value);

	Vector3d divide(Vector3ir vector);
	Vector3d divide(Vector3lr vector);
	Vector3d divide(Vector3fr vector);
	Vector3d divide(Vector3dr vector);
	Vector3d divide(double x, double y, double z);
	Vector3d divide(long x, long y, long z);
	Vector3d divideAll(long value);
	Vector3d divideAll(double value);

	Vector3d crossProduct(Vector3ir vector);
	Vector3d crossProduct(Vector3lr vector);
	Vector3d crossProduct(Vector3fr vector);
	Vector3d crossProduct(Vector3dr vector);
	Vector3d crossProduct(double x, double y, double z);
	Vector3d crossProduct(long x, long y, long z);

	Vector3d opposite();
	Vector3d absolute();
	Vector3d conjugate();
	Vector3d normalize();
	Vector3d unitary();

	double getX();
	double x();
	double getY();
	double y();
	double getZ();
	double z();

	Vector3d setX(double x);
	Vector3d x(double x);
	Vector3d setY(double y);
	Vector3d y(double y);
	Vector3d setZ(double z);
	Vector3d z(double z);

	Vector3d setAll(double x, double y, double z);
	Vector3d setAll(Vector3ir vector);
	Vector3d setAll(Vector3lr vector);
	Vector3d setAll(Vector3fr vector);
	Vector3d setAll(Vector3dr vector);

}
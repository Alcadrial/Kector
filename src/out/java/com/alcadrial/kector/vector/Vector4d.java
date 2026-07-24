package com.alcadrial.kector.vector;

import com.alcadrial.kector.vector.mutable.MutableVector4d;

/**
 * A 4-dimensional vector {X, Y, Z, W}
 */
public interface Vector4d extends Vector4dr, Vector3d {

	static Vector4d of()
	{
		return new MutableVector4d(0, 0, 0, 0);
	}
	
	static Vector4d of(double x, double y, double z, double w)
	{
		return new MutableVector4d(x, y, z, w);
	}
	
	static Vector4d of(Vector2ir value, int z, int w)
	{
		return new MutableVector4d(value, z, w);
	}

	static Vector4d of(Vector2lr value, long z, long w)
	{
		return new MutableVector4d(value, z, w);
	}

	static Vector4d of(Vector2fr value, float z, float w)
	{
		return new MutableVector4d(value, z, w);
	}

	static Vector4d of(Vector2dr value, double z, double w)
	{
		return new MutableVector4d(value, z, w);
	}

	static Vector4d of(Vector3ir value, int w)
	{
		return new MutableVector4d(value, w);
	}

	static Vector4d of(Vector3lr value, long w)
	{
		return new MutableVector4d(value, w);
	}

	static Vector4d of(Vector3fr value, float w)
	{
		return new MutableVector4d(value, w);
	}

	static Vector4d of(Vector3dr value, double w)
	{
		return new MutableVector4d(value, w);
	}

	static Vector4d of(Vector4ir value)
	{
		return new MutableVector4d(value);
	}

	static Vector4d of(Vector4lr value)
	{
		return new MutableVector4d(value);
	}

	static Vector4d of(Vector4fr value)
	{
		return new MutableVector4d(value);
	}

	static Vector4d of(Vector4dr value)
	{
		return new MutableVector4d(value);
	}

	Vector4d add(Vector4ir vector);
	Vector4d add(Vector4lr vector);
	Vector4d add(Vector4fr vector);
	Vector4d add(Vector4dr vector);
	Vector4d add(double x, double y, double z, double w);
	Vector4d add(long x, long y, long z, long w);
	Vector4d addAll(long value);
	Vector4d addAll(double value);

	Vector4d subtract(Vector4ir vector);
	Vector4d subtract(Vector4lr vector);
	Vector4d subtract(Vector4fr vector);
	Vector4d subtract(Vector4dr vector);
	Vector4d subtract(double x, double y, double z, double w);
	Vector4d subtract(long x, long y, long z, long w);
	Vector4d subtractAll(long value);
	Vector4d subtractAll(double value);

	Vector4d multiply(Vector4ir vector);
	Vector4d multiply(Vector4lr vector);
	Vector4d multiply(Vector4fr vector);
	Vector4d multiply(Vector4dr vector);
	Vector4d multiply(double x, double y, double z, double w);
	Vector4d multiply(long x, long y, long z, long w);
	Vector4d multiplyAll(long value);
	Vector4d multiplyAll(double value);

	Vector4d divide(Vector4ir vector);
	Vector4d divide(Vector4lr vector);
	Vector4d divide(Vector4fr vector);
	Vector4d divide(Vector4dr vector);
	Vector4d divide(double x, double y, double z, double w);
	Vector4d divide(long x, long y, long z, long w);
	Vector4d divideAll(long value);
	Vector4d divideAll(double value);

	Vector4d projectiveCrossProduct(Vector4ir vector);
	Vector4d projectiveCrossProduct(Vector4lr vector);
	Vector4d projectiveCrossProduct(Vector4fr vector);
	Vector4d projectiveCrossProduct(Vector4dr vector);
	Vector4d projectiveCrossProduct(double x, double y, double z, double w);
	Vector4d projectiveCrossProduct(long x, long y, long z, long w);

	Vector4d opposite();
	Vector4d absolute();
	Vector4d conjugate();
	Vector4d normalize();
	Vector4d unitary();

	double getX();
	double x();
	double getY();
	double y();
	double getZ();
	double z();
	double getW();
	double w();

	Vector4d setX(double x);
	Vector4d x(double x);
	Vector4d setY(double y);
	Vector4d y(double y);
	Vector4d setZ(double z);
	Vector4d z(double z);
	Vector4d setW(double w);
	Vector4d w(double w);

	Vector4d setAll(double x, double y, double z, double w);
	Vector4d setAll(Vector4ir vector);
	Vector4d setAll(Vector4lr vector);
	Vector4d setAll(Vector4fr vector);
	Vector4d setAll(Vector4dr vector);

}
package com.alcadrial.kector.vector;

import java.math.RoundingMode;
import com.alcadrial.kector.vector.mutable.MutableVector4l;

/**
 * A 4-dimensional vector {X, Y, Z, W}
 */
public interface Vector4l extends Vector4lr, Vector3l {

	static Vector4l of()
	{
		return new MutableVector4l(0, 0, 0, 0);
	}
	
	static Vector4l of(long x, long y, long z, long w)
	{
		return new MutableVector4l(x, y, z, w);
	}
	
	static Vector4l of(double x, double y, double z, double w, RoundingMode roundingMode)
	{
		return new MutableVector4l(x, y, z, w, roundingMode);
	}
	
	static Vector4l of(Vector2ir value, int z, int w)
	{
		return new MutableVector4l(value, z, w);
	}

	static Vector4l of(Vector2lr value, long z, long w)
	{
		return new MutableVector4l(value, z, w);
	}

	static Vector4l of(Vector2fr value, float z, float w, RoundingMode roundingMode)
	{
		return new MutableVector4l(value, z, w, roundingMode);
	}

	static Vector4l of(Vector2dr value, double z, double w, RoundingMode roundingMode)
	{
		return new MutableVector4l(value, z, w, roundingMode);
	}

	static Vector4l of(Vector3ir value, int w)
	{
		return new MutableVector4l(value, w);
	}

	static Vector4l of(Vector3lr value, long w)
	{
		return new MutableVector4l(value, w);
	}

	static Vector4l of(Vector3fr value, float w, RoundingMode roundingMode)
	{
		return new MutableVector4l(value, w, roundingMode);
	}

	static Vector4l of(Vector3dr value, double w, RoundingMode roundingMode)
	{
		return new MutableVector4l(value, w, roundingMode);
	}

	static Vector4l of(Vector4ir value)
	{
		return new MutableVector4l(value);
	}

	static Vector4l of(Vector4lr value)
	{
		return new MutableVector4l(value);
	}

	static Vector4l of(Vector4fr value, RoundingMode roundingMode)
	{
		return new MutableVector4l(value, roundingMode);
	}

	static Vector4l of(Vector4dr value, RoundingMode roundingMode)
	{
		return new MutableVector4l(value, roundingMode);
	}

	Vector4l add(Vector4ir vector);
	Vector4l add(Vector4lr vector);
	Vector4l add(Vector4fr vector, RoundingMode roundingMode);
	Vector4l add(Vector4dr vector, RoundingMode roundingMode);
	Vector4l add(long x, long y, long z, long w);
	Vector4l add(double x, double y, double z, double w, RoundingMode roundingMode);
	Vector4l addAll(double value, RoundingMode roundingMode);
	Vector4l addAll(long value);

	Vector4l subtract(Vector4ir vector);
	Vector4l subtract(Vector4lr vector);
	Vector4l subtract(Vector4fr vector, RoundingMode roundingMode);
	Vector4l subtract(Vector4dr vector, RoundingMode roundingMode);
	Vector4l subtract(long x, long y, long z, long w);
	Vector4l subtract(double x, double y, double z, double w, RoundingMode roundingMode);
	Vector4l subtractAll(double value, RoundingMode roundingMode);
	Vector4l subtractAll(long value);

	Vector4l multiply(Vector4ir vector);
	Vector4l multiply(Vector4lr vector);
	Vector4l multiply(Vector4fr vector, RoundingMode roundingMode);
	Vector4l multiply(Vector4dr vector, RoundingMode roundingMode);
	Vector4l multiply(long x, long y, long z, long w);
	Vector4l multiply(double x, double y, double z, double w, RoundingMode roundingMode);
	Vector4l multiplyAll(double value, RoundingMode roundingMode);
	Vector4l multiplyAll(long value);

	Vector4l divide(Vector4ir vector);
	Vector4l divide(Vector4lr vector);
	Vector4l divide(Vector4fr vector, RoundingMode roundingMode);
	Vector4l divide(Vector4dr vector, RoundingMode roundingMode);
	Vector4l divide(long x, long y, long z, long w);
	Vector4l divide(double x, double y, double z, double w, RoundingMode roundingMode);
	Vector4l divideAll(double value, RoundingMode roundingMode);
	Vector4l divideAll(long value);

	Vector4l opposite();
	Vector4l absolute();
	Vector4l conjugate();
	Vector4l normalize();
	Vector4l unitary();

	long getX();
	long x();
	long getY();
	long y();
	long getZ();
	long z();
	long getW();
	long w();

	Vector4l setX(long x);
	Vector4l x(long x);
	Vector4l setY(long y);
	Vector4l y(long y);
	Vector4l setZ(long z);
	Vector4l z(long z);
	Vector4l setW(long w);
	Vector4l w(long w);

	Vector4l setAll(long x, long y, long z, long w);
	Vector4l setAll(Vector4ir vector);
	Vector4l setAll(Vector4lr vector);
	Vector4l setAll(Vector4fr vector, RoundingMode roundingMode);
	Vector4l setAll(Vector4dr vector, RoundingMode roundingMode);

}
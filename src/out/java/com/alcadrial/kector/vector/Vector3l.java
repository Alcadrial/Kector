package com.alcadrial.kector.vector;

import java.math.RoundingMode;
import com.alcadrial.kector.vector.mutable.MutableVector3l;

/**
 * A 3-dimensional vector {X, Y, Z}
 */
public interface Vector3l extends Vector3lr, Vector2l {

	static Vector3l of()
	{
		return new MutableVector3l(0, 0, 0);
	}
	
	static Vector3l of(long x, long y, long z)
	{
		return new MutableVector3l(x, y, z);
	}
	
	static Vector3l of(double x, double y, double z, RoundingMode roundingMode)
	{
		return new MutableVector3l(x, y, z, roundingMode);
	}
	
	static Vector3l of(Vector2ir value, int z)
	{
		return new MutableVector3l(value, z);
	}

	static Vector3l of(Vector2lr value, long z)
	{
		return new MutableVector3l(value, z);
	}

	static Vector3l of(Vector2fr value, float z, RoundingMode roundingMode)
	{
		return new MutableVector3l(value, z, roundingMode);
	}

	static Vector3l of(Vector2dr value, double z, RoundingMode roundingMode)
	{
		return new MutableVector3l(value, z, roundingMode);
	}

	static Vector3l of(Vector3ir value)
	{
		return new MutableVector3l(value);
	}

	static Vector3l of(Vector3lr value)
	{
		return new MutableVector3l(value);
	}

	static Vector3l of(Vector3fr value, RoundingMode roundingMode)
	{
		return new MutableVector3l(value, roundingMode);
	}

	static Vector3l of(Vector3dr value, RoundingMode roundingMode)
	{
		return new MutableVector3l(value, roundingMode);
	}

	Vector3l add(Vector3ir vector);
	Vector3l add(Vector3lr vector);
	Vector3l add(Vector3fr vector, RoundingMode roundingMode);
	Vector3l add(Vector3dr vector, RoundingMode roundingMode);
	Vector3l add(long x, long y, long z);
	Vector3l add(double x, double y, double z, RoundingMode roundingMode);
	Vector3l addAll(double value, RoundingMode roundingMode);
	Vector3l addAll(long value);

	Vector3l subtract(Vector3ir vector);
	Vector3l subtract(Vector3lr vector);
	Vector3l subtract(Vector3fr vector, RoundingMode roundingMode);
	Vector3l subtract(Vector3dr vector, RoundingMode roundingMode);
	Vector3l subtract(long x, long y, long z);
	Vector3l subtract(double x, double y, double z, RoundingMode roundingMode);
	Vector3l subtractAll(double value, RoundingMode roundingMode);
	Vector3l subtractAll(long value);

	Vector3l multiply(Vector3ir vector);
	Vector3l multiply(Vector3lr vector);
	Vector3l multiply(Vector3fr vector, RoundingMode roundingMode);
	Vector3l multiply(Vector3dr vector, RoundingMode roundingMode);
	Vector3l multiply(long x, long y, long z);
	Vector3l multiply(double x, double y, double z, RoundingMode roundingMode);
	Vector3l multiplyAll(double value, RoundingMode roundingMode);
	Vector3l multiplyAll(long value);

	Vector3l divide(Vector3ir vector);
	Vector3l divide(Vector3lr vector);
	Vector3l divide(Vector3fr vector, RoundingMode roundingMode);
	Vector3l divide(Vector3dr vector, RoundingMode roundingMode);
	Vector3l divide(long x, long y, long z);
	Vector3l divide(double x, double y, double z, RoundingMode roundingMode);
	Vector3l divideAll(double value, RoundingMode roundingMode);
	Vector3l divideAll(long value);

	Vector3l crossProduct(Vector3ir vector);
	Vector3l crossProduct(Vector3lr vector);
	Vector3l crossProduct(Vector3fr vector, RoundingMode roundingMode);
	Vector3l crossProduct(Vector3dr vector, RoundingMode roundingMode);
	Vector3l crossProduct(long x, long y, long z);
	Vector3l crossProduct(double x, double y, double z, RoundingMode roundingMode);

	Vector3l opposite();
	Vector3l absolute();
	Vector3l conjugate();
	Vector3l normalize();
	Vector3l unitary();

	long getX();
	long x();
	long getY();
	long y();
	long getZ();
	long z();

	Vector3l setX(long x);
	Vector3l x(long x);
	Vector3l setY(long y);
	Vector3l y(long y);
	Vector3l setZ(long z);
	Vector3l z(long z);

	Vector3l setAll(long x, long y, long z);
	Vector3l setAll(Vector3ir vector);
	Vector3l setAll(Vector3lr vector);
	Vector3l setAll(Vector3fr vector, RoundingMode roundingMode);
	Vector3l setAll(Vector3dr vector, RoundingMode roundingMode);

}
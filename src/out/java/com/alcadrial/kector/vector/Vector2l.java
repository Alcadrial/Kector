package com.alcadrial.kector.vector;

import java.math.RoundingMode;
import com.alcadrial.kector.vector.mutable.MutableVector2l;

/**
 * A 2-dimensional vector {X, Y}
 */
public interface Vector2l extends Vector2lr {

	static Vector2l of()
	{
		return new MutableVector2l(0, 0);
	}
	
	static Vector2l of(long x, long y)
	{
		return new MutableVector2l(x, y);
	}
	
	static Vector2l of(double x, double y, RoundingMode roundingMode)
	{
		return new MutableVector2l(x, y, roundingMode);
	}
	
	static Vector2l of(Vector2ir value)
	{
		return new MutableVector2l(value);
	}

	static Vector2l of(Vector2lr value)
	{
		return new MutableVector2l(value);
	}

	static Vector2l of(Vector2fr value, RoundingMode roundingMode)
	{
		return new MutableVector2l(value, roundingMode);
	}

	static Vector2l of(Vector2dr value, RoundingMode roundingMode)
	{
		return new MutableVector2l(value, roundingMode);
	}

	Vector2l add(Vector2ir vector);
	Vector2l add(Vector2lr vector);
	Vector2l add(Vector2fr vector, RoundingMode roundingMode);
	Vector2l add(Vector2dr vector, RoundingMode roundingMode);
	Vector2l add(long x, long y);
	Vector2l add(double x, double y, RoundingMode roundingMode);
	Vector2l addAll(double value, RoundingMode roundingMode);
	Vector2l addAll(long value);

	Vector2l subtract(Vector2ir vector);
	Vector2l subtract(Vector2lr vector);
	Vector2l subtract(Vector2fr vector, RoundingMode roundingMode);
	Vector2l subtract(Vector2dr vector, RoundingMode roundingMode);
	Vector2l subtract(long x, long y);
	Vector2l subtract(double x, double y, RoundingMode roundingMode);
	Vector2l subtractAll(double value, RoundingMode roundingMode);
	Vector2l subtractAll(long value);

	Vector2l multiply(Vector2ir vector);
	Vector2l multiply(Vector2lr vector);
	Vector2l multiply(Vector2fr vector, RoundingMode roundingMode);
	Vector2l multiply(Vector2dr vector, RoundingMode roundingMode);
	Vector2l multiply(long x, long y);
	Vector2l multiply(double x, double y, RoundingMode roundingMode);
	Vector2l multiplyAll(double value, RoundingMode roundingMode);
	Vector2l multiplyAll(long value);

	Vector2l divide(Vector2ir vector);
	Vector2l divide(Vector2lr vector);
	Vector2l divide(Vector2fr vector, RoundingMode roundingMode);
	Vector2l divide(Vector2dr vector, RoundingMode roundingMode);
	Vector2l divide(long x, long y);
	Vector2l divide(double x, double y, RoundingMode roundingMode);
	Vector2l divideAll(double value, RoundingMode roundingMode);
	Vector2l divideAll(long value);

	Vector2l opposite();
	Vector2l absolute();
	Vector2l conjugate();
	Vector2l normalize();
	Vector2l unitary();

	long getX();
	long x();
	long getY();
	long y();

	Vector2l setX(long x);
	Vector2l x(long x);
	Vector2l setY(long y);
	Vector2l y(long y);

	Vector2l setAll(long x, long y);
	Vector2l setAll(Vector2ir vector);
	Vector2l setAll(Vector2lr vector);
	Vector2l setAll(Vector2fr vector, RoundingMode roundingMode);
	Vector2l setAll(Vector2dr vector, RoundingMode roundingMode);

}
package com.alcadrial.kector.vector;

import com.alcadrial.kector.vector.mutable.MutableVector2d;

/**
 * A 2-dimensional vector {X, Y}
 */
public interface Vector2d extends Vector2dr {

	static Vector2d of()
	{
		return new MutableVector2d(0, 0);
	}
	
	static Vector2d of(double x, double y)
	{
		return new MutableVector2d(x, y);
	}
	
	static Vector2d of(Vector2ir value)
	{
		return new MutableVector2d(value);
	}

	static Vector2d of(Vector2lr value)
	{
		return new MutableVector2d(value);
	}

	static Vector2d of(Vector2fr value)
	{
		return new MutableVector2d(value);
	}

	static Vector2d of(Vector2dr value)
	{
		return new MutableVector2d(value);
	}

	Vector2d add(Vector2ir vector);
	Vector2d add(Vector2lr vector);
	Vector2d add(Vector2fr vector);
	Vector2d add(Vector2dr vector);
	Vector2d add(double x, double y);
	Vector2d add(long x, long y);
	Vector2d addAll(long value);
	Vector2d addAll(double value);

	Vector2d subtract(Vector2ir vector);
	Vector2d subtract(Vector2lr vector);
	Vector2d subtract(Vector2fr vector);
	Vector2d subtract(Vector2dr vector);
	Vector2d subtract(double x, double y);
	Vector2d subtract(long x, long y);
	Vector2d subtractAll(long value);
	Vector2d subtractAll(double value);

	Vector2d multiply(Vector2ir vector);
	Vector2d multiply(Vector2lr vector);
	Vector2d multiply(Vector2fr vector);
	Vector2d multiply(Vector2dr vector);
	Vector2d multiply(double x, double y);
	Vector2d multiply(long x, long y);
	Vector2d multiplyAll(long value);
	Vector2d multiplyAll(double value);

	Vector2d divide(Vector2ir vector);
	Vector2d divide(Vector2lr vector);
	Vector2d divide(Vector2fr vector);
	Vector2d divide(Vector2dr vector);
	Vector2d divide(double x, double y);
	Vector2d divide(long x, long y);
	Vector2d divideAll(long value);
	Vector2d divideAll(double value);

	Vector2d opposite();
	Vector2d absolute();
	Vector2d conjugate();
	Vector2d normalize();
	Vector2d unitary();

	double getX();
	double x();
	double getY();
	double y();

	Vector2d setX(double x);
	Vector2d x(double x);
	Vector2d setY(double y);
	Vector2d y(double y);

	Vector2d setAll(double x, double y);
	Vector2d setAll(Vector2ir vector);
	Vector2d setAll(Vector2lr vector);
	Vector2d setAll(Vector2fr vector);
	Vector2d setAll(Vector2dr vector);

}
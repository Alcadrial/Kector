package com.alcadrial.kector.vector;

import com.alcadrial.kector.vector.mutable.MutableVector2f;

/**
 * A 2-dimensional vector {X, Y}
 */
public interface Vector2f extends Vector2fr {

	static Vector2f of()
	{
		return new MutableVector2f(0, 0);
	}
	
	static Vector2f of(float x, float y)
	{
		return new MutableVector2f(x, y);
	}
	
	static Vector2f of(Vector2ir value)
	{
		return new MutableVector2f(value);
	}

	static Vector2f of(Vector2lr value)
	{
		return new MutableVector2f(value);
	}

	static Vector2f of(Vector2fr value)
	{
		return new MutableVector2f(value);
	}

	static Vector2f of(Vector2dr value)
	{
		return new MutableVector2f(value);
	}

	Vector2f add(Vector2ir vector);
	Vector2f add(Vector2lr vector);
	Vector2f add(Vector2fr vector);
	Vector2f add(Vector2dr vector);
	Vector2f add(float x, float y);
	Vector2f add(int x, int y);
	Vector2f addAll(int value);
	Vector2f addAll(float value);

	Vector2f subtract(Vector2ir vector);
	Vector2f subtract(Vector2lr vector);
	Vector2f subtract(Vector2fr vector);
	Vector2f subtract(Vector2dr vector);
	Vector2f subtract(float x, float y);
	Vector2f subtract(int x, int y);
	Vector2f subtractAll(int value);
	Vector2f subtractAll(float value);

	Vector2f multiply(Vector2ir vector);
	Vector2f multiply(Vector2lr vector);
	Vector2f multiply(Vector2fr vector);
	Vector2f multiply(Vector2dr vector);
	Vector2f multiply(float x, float y);
	Vector2f multiply(int x, int y);
	Vector2f multiplyAll(int value);
	Vector2f multiplyAll(float value);

	Vector2f divide(Vector2ir vector);
	Vector2f divide(Vector2lr vector);
	Vector2f divide(Vector2fr vector);
	Vector2f divide(Vector2dr vector);
	Vector2f divide(float x, float y);
	Vector2f divide(int x, int y);
	Vector2f divideAll(int value);
	Vector2f divideAll(float value);

	Vector2f opposite();
	Vector2f absolute();
	Vector2f conjugate();
	Vector2f normalize();
	Vector2f unitary();

	float getX();
	float x();
	float getY();
	float y();

	Vector2f setX(float x);
	Vector2f x(float x);
	Vector2f setY(float y);
	Vector2f y(float y);

	Vector2f setAll(float x, float y);
	Vector2f setAll(Vector2ir vector);
	Vector2f setAll(Vector2lr vector);
	Vector2f setAll(Vector2fr vector);
	Vector2f setAll(Vector2dr vector);

}
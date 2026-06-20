package com.alcadrial.kector.vector;

import java.math.RoundingMode;
import com.alcadrial.kector.vector.mutable.MutableVector2i;

/**
 * A 2-dimensional vector {X, Y}
 */
public interface Vector2i extends Vector2ir {

	static Vector2i of()
	{
		return new MutableVector2i(0, 0);
	}
	
	static Vector2i of(int x, int y)
	{
		return new MutableVector2i(x, y);
	}
	
	static Vector2i of(float x, float y, RoundingMode roundingMode)
	{
		return new MutableVector2i(x, y, roundingMode);
	}
	
	static Vector2i of(Vector2ir value)
	{
		return new MutableVector2i(value);
	}

	static Vector2i of(Vector2lr value)
	{
		return new MutableVector2i(value);
	}

	static Vector2i of(Vector2fr value, RoundingMode roundingMode)
	{
		return new MutableVector2i(value, roundingMode);
	}

	static Vector2i of(Vector2dr value, RoundingMode roundingMode)
	{
		return new MutableVector2i(value, roundingMode);
	}

	Vector2i add(Vector2ir vector);
	Vector2i add(Vector2lr vector);
	Vector2i add(Vector2fr vector, RoundingMode roundingMode);
	Vector2i add(Vector2dr vector, RoundingMode roundingMode);
	Vector2i add(int x, int y);
	Vector2i add(float x, float y, RoundingMode roundingMode);
	Vector2i addAll(float value, RoundingMode roundingMode);
	Vector2i addAll(int value);

	Vector2i subtract(Vector2ir vector);
	Vector2i subtract(Vector2lr vector);
	Vector2i subtract(Vector2fr vector, RoundingMode roundingMode);
	Vector2i subtract(Vector2dr vector, RoundingMode roundingMode);
	Vector2i subtract(int x, int y);
	Vector2i subtract(float x, float y, RoundingMode roundingMode);
	Vector2i subtractAll(float value, RoundingMode roundingMode);
	Vector2i subtractAll(int value);

	Vector2i multiply(Vector2ir vector);
	Vector2i multiply(Vector2lr vector);
	Vector2i multiply(Vector2fr vector, RoundingMode roundingMode);
	Vector2i multiply(Vector2dr vector, RoundingMode roundingMode);
	Vector2i multiply(int x, int y);
	Vector2i multiply(float x, float y, RoundingMode roundingMode);
	Vector2i multiplyAll(float value, RoundingMode roundingMode);
	Vector2i multiplyAll(int value);

	Vector2i divide(Vector2ir vector);
	Vector2i divide(Vector2lr vector);
	Vector2i divide(Vector2fr vector, RoundingMode roundingMode);
	Vector2i divide(Vector2dr vector, RoundingMode roundingMode);
	Vector2i divide(int x, int y);
	Vector2i divide(float x, float y, RoundingMode roundingMode);
	Vector2i divideAll(float value, RoundingMode roundingMode);
	Vector2i divideAll(int value);

	Vector2i opposite();
	Vector2i absolute();
	Vector2i conjugate();
	Vector2i normalize();
	Vector2i unitary();

	int getX();
	int x();
	int getY();
	int y();

	Vector2i setX(int x);
	Vector2i x(int x);
	Vector2i setY(int y);
	Vector2i y(int y);

	Vector2i setAll(int x, int y);
	Vector2i setAll(Vector2ir vector);
	Vector2i setAll(Vector2lr vector);
	Vector2i setAll(Vector2fr vector, RoundingMode roundingMode);
	Vector2i setAll(Vector2dr vector, RoundingMode roundingMode);

}
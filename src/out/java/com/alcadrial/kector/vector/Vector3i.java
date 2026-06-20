package com.alcadrial.kector.vector;

import java.math.RoundingMode;
import com.alcadrial.kector.vector.mutable.MutableVector3i;

/**
 * A 3-dimensional vector {X, Y, Z}
 */
public interface Vector3i extends Vector3ir, Vector2i {

	static Vector3i of()
	{
		return new MutableVector3i(0, 0, 0);
	}
	
	static Vector3i of(int x, int y, int z)
	{
		return new MutableVector3i(x, y, z);
	}
	
	static Vector3i of(float x, float y, float z, RoundingMode roundingMode)
	{
		return new MutableVector3i(x, y, z, roundingMode);
	}
	
	static Vector3i of(Vector2ir value, int z)
	{
		return new MutableVector3i(value, z);
	}

	static Vector3i of(Vector2lr value, long z)
	{
		return new MutableVector3i(value, z);
	}

	static Vector3i of(Vector2fr value, float z, RoundingMode roundingMode)
	{
		return new MutableVector3i(value, z, roundingMode);
	}

	static Vector3i of(Vector2dr value, double z, RoundingMode roundingMode)
	{
		return new MutableVector3i(value, z, roundingMode);
	}

	static Vector3i of(Vector3ir value)
	{
		return new MutableVector3i(value);
	}

	static Vector3i of(Vector3lr value)
	{
		return new MutableVector3i(value);
	}

	static Vector3i of(Vector3fr value, RoundingMode roundingMode)
	{
		return new MutableVector3i(value, roundingMode);
	}

	static Vector3i of(Vector3dr value, RoundingMode roundingMode)
	{
		return new MutableVector3i(value, roundingMode);
	}

	Vector3i add(Vector3ir vector);
	Vector3i add(Vector3lr vector);
	Vector3i add(Vector3fr vector, RoundingMode roundingMode);
	Vector3i add(Vector3dr vector, RoundingMode roundingMode);
	Vector3i add(int x, int y, int z);
	Vector3i add(float x, float y, float z, RoundingMode roundingMode);
	Vector3i addAll(float value, RoundingMode roundingMode);
	Vector3i addAll(int value);

	Vector3i subtract(Vector3ir vector);
	Vector3i subtract(Vector3lr vector);
	Vector3i subtract(Vector3fr vector, RoundingMode roundingMode);
	Vector3i subtract(Vector3dr vector, RoundingMode roundingMode);
	Vector3i subtract(int x, int y, int z);
	Vector3i subtract(float x, float y, float z, RoundingMode roundingMode);
	Vector3i subtractAll(float value, RoundingMode roundingMode);
	Vector3i subtractAll(int value);

	Vector3i multiply(Vector3ir vector);
	Vector3i multiply(Vector3lr vector);
	Vector3i multiply(Vector3fr vector, RoundingMode roundingMode);
	Vector3i multiply(Vector3dr vector, RoundingMode roundingMode);
	Vector3i multiply(int x, int y, int z);
	Vector3i multiply(float x, float y, float z, RoundingMode roundingMode);
	Vector3i multiplyAll(float value, RoundingMode roundingMode);
	Vector3i multiplyAll(int value);

	Vector3i divide(Vector3ir vector);
	Vector3i divide(Vector3lr vector);
	Vector3i divide(Vector3fr vector, RoundingMode roundingMode);
	Vector3i divide(Vector3dr vector, RoundingMode roundingMode);
	Vector3i divide(int x, int y, int z);
	Vector3i divide(float x, float y, float z, RoundingMode roundingMode);
	Vector3i divideAll(float value, RoundingMode roundingMode);
	Vector3i divideAll(int value);

	Vector3i opposite();
	Vector3i absolute();
	Vector3i conjugate();
	Vector3i normalize();
	Vector3i unitary();

	int getX();
	int x();
	int getY();
	int y();
	int getZ();
	int z();

	Vector3i setX(int x);
	Vector3i x(int x);
	Vector3i setY(int y);
	Vector3i y(int y);
	Vector3i setZ(int z);
	Vector3i z(int z);

	Vector3i setAll(int x, int y, int z);
	Vector3i setAll(Vector3ir vector);
	Vector3i setAll(Vector3lr vector);
	Vector3i setAll(Vector3fr vector, RoundingMode roundingMode);
	Vector3i setAll(Vector3dr vector, RoundingMode roundingMode);

}
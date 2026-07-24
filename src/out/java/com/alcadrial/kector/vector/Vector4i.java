package com.alcadrial.kector.vector;

import java.math.RoundingMode;
import com.alcadrial.kector.vector.mutable.MutableVector4i;

/**
 * A 4-dimensional vector {X, Y, Z, W}
 */
public interface Vector4i extends Vector4ir, Vector3i {

	static Vector4i of()
	{
		return new MutableVector4i(0, 0, 0, 0);
	}
	
	static Vector4i of(int x, int y, int z, int w)
	{
		return new MutableVector4i(x, y, z, w);
	}
	
	static Vector4i of(float x, float y, float z, float w, RoundingMode roundingMode)
	{
		return new MutableVector4i(x, y, z, w, roundingMode);
	}
	
	static Vector4i of(Vector2ir value, int z, int w)
	{
		return new MutableVector4i(value, z, w);
	}

	static Vector4i of(Vector2lr value, long z, long w)
	{
		return new MutableVector4i(value, z, w);
	}

	static Vector4i of(Vector2fr value, float z, float w, RoundingMode roundingMode)
	{
		return new MutableVector4i(value, z, w, roundingMode);
	}

	static Vector4i of(Vector2dr value, double z, double w, RoundingMode roundingMode)
	{
		return new MutableVector4i(value, z, w, roundingMode);
	}

	static Vector4i of(Vector3ir value, int w)
	{
		return new MutableVector4i(value, w);
	}

	static Vector4i of(Vector3lr value, long w)
	{
		return new MutableVector4i(value, w);
	}

	static Vector4i of(Vector3fr value, float w, RoundingMode roundingMode)
	{
		return new MutableVector4i(value, w, roundingMode);
	}

	static Vector4i of(Vector3dr value, double w, RoundingMode roundingMode)
	{
		return new MutableVector4i(value, w, roundingMode);
	}

	static Vector4i of(Vector4ir value)
	{
		return new MutableVector4i(value);
	}

	static Vector4i of(Vector4lr value)
	{
		return new MutableVector4i(value);
	}

	static Vector4i of(Vector4fr value, RoundingMode roundingMode)
	{
		return new MutableVector4i(value, roundingMode);
	}

	static Vector4i of(Vector4dr value, RoundingMode roundingMode)
	{
		return new MutableVector4i(value, roundingMode);
	}

	Vector4i add(Vector4ir vector);
	Vector4i add(Vector4lr vector);
	Vector4i add(Vector4fr vector, RoundingMode roundingMode);
	Vector4i add(Vector4dr vector, RoundingMode roundingMode);
	Vector4i add(int x, int y, int z, int w);
	Vector4i add(float x, float y, float z, float w, RoundingMode roundingMode);
	Vector4i addAll(float value, RoundingMode roundingMode);
	Vector4i addAll(int value);

	Vector4i subtract(Vector4ir vector);
	Vector4i subtract(Vector4lr vector);
	Vector4i subtract(Vector4fr vector, RoundingMode roundingMode);
	Vector4i subtract(Vector4dr vector, RoundingMode roundingMode);
	Vector4i subtract(int x, int y, int z, int w);
	Vector4i subtract(float x, float y, float z, float w, RoundingMode roundingMode);
	Vector4i subtractAll(float value, RoundingMode roundingMode);
	Vector4i subtractAll(int value);

	Vector4i multiply(Vector4ir vector);
	Vector4i multiply(Vector4lr vector);
	Vector4i multiply(Vector4fr vector, RoundingMode roundingMode);
	Vector4i multiply(Vector4dr vector, RoundingMode roundingMode);
	Vector4i multiply(int x, int y, int z, int w);
	Vector4i multiply(float x, float y, float z, float w, RoundingMode roundingMode);
	Vector4i multiplyAll(float value, RoundingMode roundingMode);
	Vector4i multiplyAll(int value);

	Vector4i divide(Vector4ir vector);
	Vector4i divide(Vector4lr vector);
	Vector4i divide(Vector4fr vector, RoundingMode roundingMode);
	Vector4i divide(Vector4dr vector, RoundingMode roundingMode);
	Vector4i divide(int x, int y, int z, int w);
	Vector4i divide(float x, float y, float z, float w, RoundingMode roundingMode);
	Vector4i divideAll(float value, RoundingMode roundingMode);
	Vector4i divideAll(int value);

	Vector4i projectiveCrossProduct(Vector4ir vector);
	Vector4i projectiveCrossProduct(Vector4lr vector);
	Vector4i projectiveCrossProduct(Vector4fr vector, RoundingMode roundingMode);
	Vector4i projectiveCrossProduct(Vector4dr vector, RoundingMode roundingMode);
	Vector4i projectiveCrossProduct(int x, int y, int z, int w);
	Vector4i projectiveCrossProduct(float x, float y, float z, float w, RoundingMode roundingMode);

	Vector4i opposite();
	Vector4i absolute();
	Vector4i conjugate();
	Vector4i normalize();
	Vector4i unitary();

	int getX();
	int x();
	int getY();
	int y();
	int getZ();
	int z();
	int getW();
	int w();

	Vector4i setX(int x);
	Vector4i x(int x);
	Vector4i setY(int y);
	Vector4i y(int y);
	Vector4i setZ(int z);
	Vector4i z(int z);
	Vector4i setW(int w);
	Vector4i w(int w);

	Vector4i setAll(int x, int y, int z, int w);
	Vector4i setAll(Vector4ir vector);
	Vector4i setAll(Vector4lr vector);
	Vector4i setAll(Vector4fr vector, RoundingMode roundingMode);
	Vector4i setAll(Vector4dr vector, RoundingMode roundingMode);

}
package com.alcadrial.kector.vector;

import com.alcadrial.kector.vector.readonly.ReadOnlyVector4f;

/**
 * A read-only 4-dimensional vector {X, Y, Z, W}
 */
public interface Vector4fr extends Vector3fr {

	static Vector4fr of()
	{
		return ReadOnlyVector4f.ZERO;
	}
	
	static Vector4fr ofProjective()
	{
		return ReadOnlyVector4f.PROJECTIVE_ZERO;
	}
	
	static Vector4fr of(float x, float y, float z, float w)
	{
		return new ReadOnlyVector4f(x, y, z, w);
	}
	
	static Vector4fr of(Vector2ir value, int z, int w)
	{
		return new ReadOnlyVector4f(value, z, w);
	}

	static Vector4fr of(Vector2lr value, long z, long w)
	{
		return new ReadOnlyVector4f(value, z, w);
	}

	static Vector4fr of(Vector2fr value, float z, float w)
	{
		return new ReadOnlyVector4f(value, z, w);
	}

	static Vector4fr of(Vector2dr value, double z, double w)
	{
		return new ReadOnlyVector4f(value, z, w);
	}

	static Vector4fr of(Vector3ir value, int w)
	{
		return new ReadOnlyVector4f(value, w);
	}

	static Vector4fr of(Vector3lr value, long w)
	{
		return new ReadOnlyVector4f(value, w);
	}

	static Vector4fr of(Vector3fr value, float w)
	{
		return new ReadOnlyVector4f(value, w);
	}

	static Vector4fr of(Vector3dr value, double w)
	{
		return new ReadOnlyVector4f(value, w);
	}

	static Vector4fr of(Vector4ir value)
	{
		return new ReadOnlyVector4f(value);
	}

	static Vector4fr of(Vector4lr value)
	{
		return new ReadOnlyVector4f(value);
	}

	static Vector4fr of(Vector4fr value)
	{
		return new ReadOnlyVector4f(value);
	}

	static Vector4fr of(Vector4dr value)
	{
		return new ReadOnlyVector4f(value);
	}

	double squareLength();
	double absoluteLength();
	double absoluteSize();
	float length();
	float size();
	float maxSize();

	float squareDistance(Vector4ir vector);
	float squareDistance(Vector4lr vector);
	double squareDistance(Vector4fr vector);
	double squareDistance(Vector4dr vector);
	float absoluteDistance(Vector4ir vector);
	float absoluteDistance(Vector4lr vector);
	double absoluteDistance(Vector4fr vector);
	double absoluteDistance(Vector4dr vector);
	float dotProduct(Vector4ir vector);
	float dotProduct(Vector4lr vector);
	double dotProduct(Vector4fr vector);
	double dotProduct(Vector4dr vector);
	float distance(Vector4ir vector);
	float distance(Vector4lr vector);
	float distance(Vector4fr vector);
	double distance(Vector4dr vector);
	float maxDistance(Vector4ir vector);
	float maxDistance(Vector4lr vector);
	float maxDistance(Vector4fr vector);
	double maxDistance(Vector4dr vector);

	int hashcode();
	boolean equals(Vector4ir vector);
	boolean equals(Vector4lr vector);
	boolean equals(Vector4fr vector);
	boolean equals(Vector4dr vector);

	boolean isGreater(Vector4ir vector);
	boolean isGreater(Vector4lr vector);
	boolean isGreater(Vector4fr vector);
	boolean isGreater(Vector4dr vector);
	boolean isMinor(Vector4ir vector);
	boolean isMinor(Vector4lr vector);
	boolean isMinor(Vector4fr vector);
	boolean isMinor(Vector4dr vector);

	float getX();
	float x();
	float getY();
	float y();
	float getZ();
	float z();
	float getW();
	float w();

}
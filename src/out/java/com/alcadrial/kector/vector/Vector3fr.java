package com.alcadrial.kector.vector;

import com.alcadrial.kector.vector.readonly.ReadOnlyVector3f;

/**
 * A read-only 3-dimensional vector {X, Y, Z}
 */
public interface Vector3fr extends Vector2fr {

	static Vector3fr of()
	{
		return ReadOnlyVector3f.ZERO;
	}
	
	static Vector3fr of(float x, float y, float z)
	{
		return new ReadOnlyVector3f(x, y, z);
	}
	
	static Vector3fr of(Vector2ir value, int z)
	{
		return new ReadOnlyVector3f(value, z);
	}

	static Vector3fr of(Vector2lr value, long z)
	{
		return new ReadOnlyVector3f(value, z);
	}

	static Vector3fr of(Vector2fr value, float z)
	{
		return new ReadOnlyVector3f(value, z);
	}

	static Vector3fr of(Vector2dr value, double z)
	{
		return new ReadOnlyVector3f(value, z);
	}

	static Vector3fr of(Vector3ir value)
	{
		return new ReadOnlyVector3f(value);
	}

	static Vector3fr of(Vector3lr value)
	{
		return new ReadOnlyVector3f(value);
	}

	static Vector3fr of(Vector3fr value)
	{
		return new ReadOnlyVector3f(value);
	}

	static Vector3fr of(Vector3dr value)
	{
		return new ReadOnlyVector3f(value);
	}

	double squareLength();
	double absoluteLength();
	double absoluteSize();
	float length();
	float size();
	float maxSize();

	float squareDistance(Vector3ir vector);
	float squareDistance(Vector3lr vector);
	double squareDistance(Vector3fr vector);
	double squareDistance(Vector3dr vector);
	float absoluteDistance(Vector3ir vector);
	float absoluteDistance(Vector3lr vector);
	double absoluteDistance(Vector3fr vector);
	double absoluteDistance(Vector3dr vector);
	float dotProduct(Vector3ir vector);
	float dotProduct(Vector3lr vector);
	double dotProduct(Vector3fr vector);
	double dotProduct(Vector3dr vector);
	float distance(Vector3ir vector);
	float distance(Vector3lr vector);
	float distance(Vector3fr vector);
	double distance(Vector3dr vector);
	float maxDistance(Vector3ir vector);
	float maxDistance(Vector3lr vector);
	float maxDistance(Vector3fr vector);
	double maxDistance(Vector3dr vector);

	int hashcode();
	boolean equals(Vector3ir vector);
	boolean equals(Vector3lr vector);
	boolean equals(Vector3fr vector);
	boolean equals(Vector3dr vector);

	boolean isGreater(Vector3ir vector);
	boolean isGreater(Vector3lr vector);
	boolean isGreater(Vector3fr vector);
	boolean isGreater(Vector3dr vector);
	boolean isMinor(Vector3ir vector);
	boolean isMinor(Vector3lr vector);
	boolean isMinor(Vector3fr vector);
	boolean isMinor(Vector3dr vector);

	float getX();
	float x();
	float getY();
	float y();
	float getZ();
	float z();

}
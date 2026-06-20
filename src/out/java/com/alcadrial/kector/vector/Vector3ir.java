package com.alcadrial.kector.vector;

import java.math.RoundingMode;
import com.alcadrial.kector.vector.readonly.ReadOnlyVector3i;

/**
 * A read-only 3-dimensional vector {X, Y, Z}
 */
public interface Vector3ir extends Vector2ir {

	static Vector3ir of()
	{
		return ReadOnlyVector3i.ZERO;
	}
	
	static Vector3ir of(int x, int y, int z)
	{
		return new ReadOnlyVector3i(x, y, z);
	}
	
	static Vector3ir of(float x, float y, float z, RoundingMode roundingMode)
	{
		return new ReadOnlyVector3i(x, y, z, roundingMode);
	}
	
	static Vector3ir of(Vector2ir value, int z)
	{
		return new ReadOnlyVector3i(value, z);
	}

	static Vector3ir of(Vector2lr value, long z)
	{
		return new ReadOnlyVector3i(value, z);
	}

	static Vector3ir of(Vector2fr value, float z, RoundingMode roundingMode)
	{
		return new ReadOnlyVector3i(value, z, roundingMode);
	}

	static Vector3ir of(Vector2dr value, double z, RoundingMode roundingMode)
	{
		return new ReadOnlyVector3i(value, z, roundingMode);
	}

	static Vector3ir of(Vector3ir value)
	{
		return new ReadOnlyVector3i(value);
	}

	static Vector3ir of(Vector3lr value)
	{
		return new ReadOnlyVector3i(value);
	}

	static Vector3ir of(Vector3fr value, RoundingMode roundingMode)
	{
		return new ReadOnlyVector3i(value, roundingMode);
	}

	static Vector3ir of(Vector3dr value, RoundingMode roundingMode)
	{
		return new ReadOnlyVector3i(value, roundingMode);
	}

	long squareLength();
	long absoluteLength();
	long absoluteSize();
	float length();
	float size();
	int maxSize();

	long squareDistance(Vector3ir vector);
	long squareDistance(Vector3lr vector);
	float squareDistance(Vector3fr vector);
	double squareDistance(Vector3dr vector);
	long absoluteDistance(Vector3ir vector);
	long absoluteDistance(Vector3lr vector);
	float absoluteDistance(Vector3fr vector);
	double absoluteDistance(Vector3dr vector);
	long dotProduct(Vector3ir vector);
	long dotProduct(Vector3lr vector);
	float dotProduct(Vector3fr vector);
	double dotProduct(Vector3dr vector);
	float distance(Vector3ir vector);
	double distance(Vector3lr vector);
	float distance(Vector3fr vector);
	double distance(Vector3dr vector);
	int maxDistance(Vector3ir vector);
	long maxDistance(Vector3lr vector);
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

	int getX();
	int x();
	int getY();
	int y();
	int getZ();
	int z();

}
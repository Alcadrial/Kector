package com.alcadrial.kector.vector;

import java.math.RoundingMode;
import com.alcadrial.kector.vector.readonly.ReadOnlyVector3l;

/**
 * A read-only 3-dimensional vector {X, Y, Z}
 */
public interface Vector3lr extends Vector2lr {

	static Vector3lr of()
	{
		return ReadOnlyVector3l.ZERO;
	}
	
	static Vector3lr of(long x, long y, long z)
	{
		return new ReadOnlyVector3l(x, y, z);
	}
	
	static Vector3lr of(double x, double y, double z, RoundingMode roundingMode)
	{
		return new ReadOnlyVector3l(x, y, z, roundingMode);
	}
	
	static Vector3lr of(Vector2ir value, int z)
	{
		return new ReadOnlyVector3l(value, z);
	}

	static Vector3lr of(Vector2lr value, long z)
	{
		return new ReadOnlyVector3l(value, z);
	}

	static Vector3lr of(Vector2fr value, float z, RoundingMode roundingMode)
	{
		return new ReadOnlyVector3l(value, z, roundingMode);
	}

	static Vector3lr of(Vector2dr value, double z, RoundingMode roundingMode)
	{
		return new ReadOnlyVector3l(value, z, roundingMode);
	}

	static Vector3lr of(Vector3ir value)
	{
		return new ReadOnlyVector3l(value);
	}

	static Vector3lr of(Vector3lr value)
	{
		return new ReadOnlyVector3l(value);
	}

	static Vector3lr of(Vector3fr value, RoundingMode roundingMode)
	{
		return new ReadOnlyVector3l(value, roundingMode);
	}

	static Vector3lr of(Vector3dr value, RoundingMode roundingMode)
	{
		return new ReadOnlyVector3l(value, roundingMode);
	}

	double squareLength();
	double absoluteLength();
	double absoluteSize();
	double length();
	double size();
	long maxSize();

	long squareDistance(Vector3ir vector);
	double squareDistance(Vector3lr vector);
	float squareDistance(Vector3fr vector);
	double squareDistance(Vector3dr vector);
	long absoluteDistance(Vector3ir vector);
	double absoluteDistance(Vector3lr vector);
	float absoluteDistance(Vector3fr vector);
	double absoluteDistance(Vector3dr vector);
	long dotProduct(Vector3ir vector);
	double dotProduct(Vector3lr vector);
	float dotProduct(Vector3fr vector);
	double dotProduct(Vector3dr vector);
	double distance(Vector3ir vector);
	double distance(Vector3lr vector);
	float distance(Vector3fr vector);
	double distance(Vector3dr vector);
	long maxDistance(Vector3ir vector);
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

	long getX();
	long x();
	long getY();
	long y();
	long getZ();
	long z();

}
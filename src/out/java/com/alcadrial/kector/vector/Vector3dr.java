package com.alcadrial.kector.vector;

import com.alcadrial.kector.vector.readonly.ReadOnlyVector3d;

/**
 * A read-only 3-dimensional vector {X, Y, Z}
 */
public interface Vector3dr extends Vector2dr {

	static Vector3dr of()
	{
		return ReadOnlyVector3d.ZERO;
	}
	
	static Vector3dr of(double x, double y, double z)
	{
		return new ReadOnlyVector3d(x, y, z);
	}
	
	static Vector3dr of(Vector2ir value, int z)
	{
		return new ReadOnlyVector3d(value, z);
	}

	static Vector3dr of(Vector2lr value, long z)
	{
		return new ReadOnlyVector3d(value, z);
	}

	static Vector3dr of(Vector2fr value, float z)
	{
		return new ReadOnlyVector3d(value, z);
	}

	static Vector3dr of(Vector2dr value, double z)
	{
		return new ReadOnlyVector3d(value, z);
	}

	static Vector3dr of(Vector3ir value)
	{
		return new ReadOnlyVector3d(value);
	}

	static Vector3dr of(Vector3lr value)
	{
		return new ReadOnlyVector3d(value);
	}

	static Vector3dr of(Vector3fr value)
	{
		return new ReadOnlyVector3d(value);
	}

	static Vector3dr of(Vector3dr value)
	{
		return new ReadOnlyVector3d(value);
	}

	double squareLength();
	double absoluteLength();
	double absoluteSize();
	double length();
	double size();
	double maxSize();

	double squareDistance(Vector3ir vector);
	double squareDistance(Vector3lr vector);
	double squareDistance(Vector3fr vector);
	double squareDistance(Vector3dr vector);
	double absoluteDistance(Vector3ir vector);
	double absoluteDistance(Vector3lr vector);
	double absoluteDistance(Vector3fr vector);
	double absoluteDistance(Vector3dr vector);
	double dotProduct(Vector3ir vector);
	double dotProduct(Vector3lr vector);
	double dotProduct(Vector3fr vector);
	double dotProduct(Vector3dr vector);
	double distance(Vector3ir vector);
	double distance(Vector3lr vector);
	double distance(Vector3fr vector);
	double distance(Vector3dr vector);
	double maxDistance(Vector3ir vector);
	double maxDistance(Vector3lr vector);
	double maxDistance(Vector3fr vector);
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

	double getX();
	double x();
	double getY();
	double y();
	double getZ();
	double z();

}
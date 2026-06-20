package com.alcadrial.kector.vector;

import com.alcadrial.kector.vector.readonly.ReadOnlyVector4d;

/**
 * A read-only 4-dimensional vector {X, Y, Z, W}
 */
public interface Vector4dr extends Vector3dr {

	static Vector4dr of()
	{
		return ReadOnlyVector4d.ZERO;
	}
	
	static Vector4dr ofProjective()
	{
		return ReadOnlyVector4d.PROJECTIVE_ZERO;
	}
	
	static Vector4dr of(double x, double y, double z, double w)
	{
		return new ReadOnlyVector4d(x, y, z, w);
	}
	
	static Vector4dr of(Vector2ir value, int z, int w)
	{
		return new ReadOnlyVector4d(value, z, w);
	}

	static Vector4dr of(Vector2lr value, long z, long w)
	{
		return new ReadOnlyVector4d(value, z, w);
	}

	static Vector4dr of(Vector2fr value, float z, float w)
	{
		return new ReadOnlyVector4d(value, z, w);
	}

	static Vector4dr of(Vector2dr value, double z, double w)
	{
		return new ReadOnlyVector4d(value, z, w);
	}

	static Vector4dr of(Vector3ir value, int w)
	{
		return new ReadOnlyVector4d(value, w);
	}

	static Vector4dr of(Vector3lr value, long w)
	{
		return new ReadOnlyVector4d(value, w);
	}

	static Vector4dr of(Vector3fr value, float w)
	{
		return new ReadOnlyVector4d(value, w);
	}

	static Vector4dr of(Vector3dr value, double w)
	{
		return new ReadOnlyVector4d(value, w);
	}

	static Vector4dr of(Vector4ir value)
	{
		return new ReadOnlyVector4d(value);
	}

	static Vector4dr of(Vector4lr value)
	{
		return new ReadOnlyVector4d(value);
	}

	static Vector4dr of(Vector4fr value)
	{
		return new ReadOnlyVector4d(value);
	}

	static Vector4dr of(Vector4dr value)
	{
		return new ReadOnlyVector4d(value);
	}

	double squareLength();
	double absoluteLength();
	double absoluteSize();
	double length();
	double size();
	double maxSize();

	double squareDistance(Vector4ir vector);
	double squareDistance(Vector4lr vector);
	double squareDistance(Vector4fr vector);
	double squareDistance(Vector4dr vector);
	double absoluteDistance(Vector4ir vector);
	double absoluteDistance(Vector4lr vector);
	double absoluteDistance(Vector4fr vector);
	double absoluteDistance(Vector4dr vector);
	double dotProduct(Vector4ir vector);
	double dotProduct(Vector4lr vector);
	double dotProduct(Vector4fr vector);
	double dotProduct(Vector4dr vector);
	double distance(Vector4ir vector);
	double distance(Vector4lr vector);
	double distance(Vector4fr vector);
	double distance(Vector4dr vector);
	double maxDistance(Vector4ir vector);
	double maxDistance(Vector4lr vector);
	double maxDistance(Vector4fr vector);
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

	double getX();
	double x();
	double getY();
	double y();
	double getZ();
	double z();
	double getW();
	double w();

}
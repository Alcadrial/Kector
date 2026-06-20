package com.alcadrial.kector.vector;

import java.math.RoundingMode;
import com.alcadrial.kector.vector.readonly.ReadOnlyVector4l;

/**
 * A read-only 4-dimensional vector {X, Y, Z, W}
 */
public interface Vector4lr extends Vector3lr {

	static Vector4lr of()
	{
		return ReadOnlyVector4l.ZERO;
	}
	
	static Vector4lr ofProjective()
	{
		return ReadOnlyVector4l.PROJECTIVE_ZERO;
	}
	
	static Vector4lr of(long x, long y, long z, long w)
	{
		return new ReadOnlyVector4l(x, y, z, w);
	}
	
	static Vector4lr of(double x, double y, double z, double w, RoundingMode roundingMode)
	{
		return new ReadOnlyVector4l(x, y, z, w, roundingMode);
	}
	
	static Vector4lr of(Vector2ir value, int z, int w)
	{
		return new ReadOnlyVector4l(value, z, w);
	}

	static Vector4lr of(Vector2lr value, long z, long w)
	{
		return new ReadOnlyVector4l(value, z, w);
	}

	static Vector4lr of(Vector2fr value, float z, float w, RoundingMode roundingMode)
	{
		return new ReadOnlyVector4l(value, z, w, roundingMode);
	}

	static Vector4lr of(Vector2dr value, double z, double w, RoundingMode roundingMode)
	{
		return new ReadOnlyVector4l(value, z, w, roundingMode);
	}

	static Vector4lr of(Vector3ir value, int w)
	{
		return new ReadOnlyVector4l(value, w);
	}

	static Vector4lr of(Vector3lr value, long w)
	{
		return new ReadOnlyVector4l(value, w);
	}

	static Vector4lr of(Vector3fr value, float w, RoundingMode roundingMode)
	{
		return new ReadOnlyVector4l(value, w, roundingMode);
	}

	static Vector4lr of(Vector3dr value, double w, RoundingMode roundingMode)
	{
		return new ReadOnlyVector4l(value, w, roundingMode);
	}

	static Vector4lr of(Vector4ir value)
	{
		return new ReadOnlyVector4l(value);
	}

	static Vector4lr of(Vector4lr value)
	{
		return new ReadOnlyVector4l(value);
	}

	static Vector4lr of(Vector4fr value, RoundingMode roundingMode)
	{
		return new ReadOnlyVector4l(value, roundingMode);
	}

	static Vector4lr of(Vector4dr value, RoundingMode roundingMode)
	{
		return new ReadOnlyVector4l(value, roundingMode);
	}

	double squareLength();
	double absoluteLength();
	double absoluteSize();
	double length();
	double size();
	long maxSize();

	long squareDistance(Vector4ir vector);
	double squareDistance(Vector4lr vector);
	float squareDistance(Vector4fr vector);
	double squareDistance(Vector4dr vector);
	long absoluteDistance(Vector4ir vector);
	double absoluteDistance(Vector4lr vector);
	float absoluteDistance(Vector4fr vector);
	double absoluteDistance(Vector4dr vector);
	long dotProduct(Vector4ir vector);
	double dotProduct(Vector4lr vector);
	float dotProduct(Vector4fr vector);
	double dotProduct(Vector4dr vector);
	double distance(Vector4ir vector);
	double distance(Vector4lr vector);
	float distance(Vector4fr vector);
	double distance(Vector4dr vector);
	long maxDistance(Vector4ir vector);
	long maxDistance(Vector4lr vector);
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

	long getX();
	long x();
	long getY();
	long y();
	long getZ();
	long z();
	long getW();
	long w();

}
package com.alcadrial.kector.vector;

import java.math.RoundingMode;
import com.alcadrial.kector.vector.readonly.ReadOnlyVector4i;

/**
 * A read-only 4-dimensional vector {X, Y, Z, W}
 */
public interface Vector4ir extends Vector3ir {

	static Vector4ir of()
	{
		return ReadOnlyVector4i.ZERO;
	}
	
	static Vector4ir ofProjective()
	{
		return ReadOnlyVector4i.PROJECTIVE_ZERO;
	}
	
	static Vector4ir of(int x, int y, int z, int w)
	{
		return new ReadOnlyVector4i(x, y, z, w);
	}
	
	static Vector4ir of(float x, float y, float z, float w, RoundingMode roundingMode)
	{
		return new ReadOnlyVector4i(x, y, z, w, roundingMode);
	}
	
	static Vector4ir of(Vector2ir value, int z, int w)
	{
		return new ReadOnlyVector4i(value, z, w);
	}

	static Vector4ir of(Vector2lr value, long z, long w)
	{
		return new ReadOnlyVector4i(value, z, w);
	}

	static Vector4ir of(Vector2fr value, float z, float w, RoundingMode roundingMode)
	{
		return new ReadOnlyVector4i(value, z, w, roundingMode);
	}

	static Vector4ir of(Vector2dr value, double z, double w, RoundingMode roundingMode)
	{
		return new ReadOnlyVector4i(value, z, w, roundingMode);
	}

	static Vector4ir of(Vector3ir value, int w)
	{
		return new ReadOnlyVector4i(value, w);
	}

	static Vector4ir of(Vector3lr value, long w)
	{
		return new ReadOnlyVector4i(value, w);
	}

	static Vector4ir of(Vector3fr value, float w, RoundingMode roundingMode)
	{
		return new ReadOnlyVector4i(value, w, roundingMode);
	}

	static Vector4ir of(Vector3dr value, double w, RoundingMode roundingMode)
	{
		return new ReadOnlyVector4i(value, w, roundingMode);
	}

	static Vector4ir of(Vector4ir value)
	{
		return new ReadOnlyVector4i(value);
	}

	static Vector4ir of(Vector4lr value)
	{
		return new ReadOnlyVector4i(value);
	}

	static Vector4ir of(Vector4fr value, RoundingMode roundingMode)
	{
		return new ReadOnlyVector4i(value, roundingMode);
	}

	static Vector4ir of(Vector4dr value, RoundingMode roundingMode)
	{
		return new ReadOnlyVector4i(value, roundingMode);
	}

	long squareLength();
	long absoluteLength();
	long absoluteSize();
	float length();
	float size();
	int maxSize();

	long squareDistance(Vector4ir vector);
	long squareDistance(Vector4lr vector);
	float squareDistance(Vector4fr vector);
	double squareDistance(Vector4dr vector);
	long absoluteDistance(Vector4ir vector);
	long absoluteDistance(Vector4lr vector);
	float absoluteDistance(Vector4fr vector);
	double absoluteDistance(Vector4dr vector);
	long dotProduct(Vector4ir vector);
	long dotProduct(Vector4lr vector);
	float dotProduct(Vector4fr vector);
	double dotProduct(Vector4dr vector);
	float distance(Vector4ir vector);
	double distance(Vector4lr vector);
	float distance(Vector4fr vector);
	double distance(Vector4dr vector);
	int maxDistance(Vector4ir vector);
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

	int getX();
	int x();
	int getY();
	int y();
	int getZ();
	int z();
	int getW();
	int w();

}
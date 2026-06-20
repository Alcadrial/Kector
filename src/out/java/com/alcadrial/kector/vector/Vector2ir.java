package com.alcadrial.kector.vector;

import java.math.RoundingMode;
import com.alcadrial.kector.vector.readonly.ReadOnlyVector2i;

/**
 * A read-only 2-dimensional vector {X, Y}
 */
public interface Vector2ir {

	static Vector2ir of()
	{
		return ReadOnlyVector2i.ZERO;
	}
	
	static Vector2ir of(int x, int y)
	{
		return new ReadOnlyVector2i(x, y);
	}
	
	static Vector2ir of(float x, float y, RoundingMode roundingMode)
	{
		return new ReadOnlyVector2i(x, y, roundingMode);
	}
	
	static Vector2ir of(Vector2ir value)
	{
		return new ReadOnlyVector2i(value);
	}

	static Vector2ir of(Vector2lr value)
	{
		return new ReadOnlyVector2i(value);
	}

	static Vector2ir of(Vector2fr value, RoundingMode roundingMode)
	{
		return new ReadOnlyVector2i(value, roundingMode);
	}

	static Vector2ir of(Vector2dr value, RoundingMode roundingMode)
	{
		return new ReadOnlyVector2i(value, roundingMode);
	}

	long squareLength();
	long absoluteLength();
	long absoluteSize();
	float length();
	float size();
	int maxSize();

	long squareDistance(Vector2ir vector);
	long squareDistance(Vector2lr vector);
	float squareDistance(Vector2fr vector);
	double squareDistance(Vector2dr vector);
	long absoluteDistance(Vector2ir vector);
	long absoluteDistance(Vector2lr vector);
	float absoluteDistance(Vector2fr vector);
	double absoluteDistance(Vector2dr vector);
	long dotProduct(Vector2ir vector);
	long dotProduct(Vector2lr vector);
	float dotProduct(Vector2fr vector);
	double dotProduct(Vector2dr vector);
	float distance(Vector2ir vector);
	double distance(Vector2lr vector);
	float distance(Vector2fr vector);
	double distance(Vector2dr vector);
	int maxDistance(Vector2ir vector);
	long maxDistance(Vector2lr vector);
	float maxDistance(Vector2fr vector);
	double maxDistance(Vector2dr vector);

	int hashcode();
	boolean equals(Vector2ir vector);
	boolean equals(Vector2lr vector);
	boolean equals(Vector2fr vector);
	boolean equals(Vector2dr vector);

	boolean isGreater(Vector2ir vector);
	boolean isGreater(Vector2lr vector);
	boolean isGreater(Vector2fr vector);
	boolean isGreater(Vector2dr vector);
	boolean isMinor(Vector2ir vector);
	boolean isMinor(Vector2lr vector);
	boolean isMinor(Vector2fr vector);
	boolean isMinor(Vector2dr vector);

	int getX();
	int x();
	int getY();
	int y();

}
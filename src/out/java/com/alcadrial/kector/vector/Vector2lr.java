package com.alcadrial.kector.vector;

import java.math.RoundingMode;
import com.alcadrial.kector.vector.readonly.ReadOnlyVector2l;

/**
 * A read-only 2-dimensional vector {X, Y}
 */
public interface Vector2lr {

	static Vector2lr of()
	{
		return ReadOnlyVector2l.ZERO;
	}
	
	static Vector2lr of(long x, long y)
	{
		return new ReadOnlyVector2l(x, y);
	}
	
	static Vector2lr of(double x, double y, RoundingMode roundingMode)
	{
		return new ReadOnlyVector2l(x, y, roundingMode);
	}
	
	static Vector2lr of(Vector2ir value)
	{
		return new ReadOnlyVector2l(value);
	}

	static Vector2lr of(Vector2lr value)
	{
		return new ReadOnlyVector2l(value);
	}

	static Vector2lr of(Vector2fr value, RoundingMode roundingMode)
	{
		return new ReadOnlyVector2l(value, roundingMode);
	}

	static Vector2lr of(Vector2dr value, RoundingMode roundingMode)
	{
		return new ReadOnlyVector2l(value, roundingMode);
	}

	double squareLength();
	double absoluteLength();
	double absoluteSize();
	double length();
	double size();
	long maxSize();

	long squareDistance(Vector2ir vector);
	double squareDistance(Vector2lr vector);
	float squareDistance(Vector2fr vector);
	double squareDistance(Vector2dr vector);
	long absoluteDistance(Vector2ir vector);
	double absoluteDistance(Vector2lr vector);
	float absoluteDistance(Vector2fr vector);
	double absoluteDistance(Vector2dr vector);
	long dotProduct(Vector2ir vector);
	double dotProduct(Vector2lr vector);
	float dotProduct(Vector2fr vector);
	double dotProduct(Vector2dr vector);
	double distance(Vector2ir vector);
	double distance(Vector2lr vector);
	float distance(Vector2fr vector);
	double distance(Vector2dr vector);
	long maxDistance(Vector2ir vector);
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

	long getX();
	long x();
	long getY();
	long y();

}
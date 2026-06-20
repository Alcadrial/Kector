package com.alcadrial.kector.vector;

import com.alcadrial.kector.vector.readonly.ReadOnlyVector2d;

/**
 * A read-only 2-dimensional vector {X, Y}
 */
public interface Vector2dr {

	static Vector2dr of()
	{
		return ReadOnlyVector2d.ZERO;
	}
	
	static Vector2dr of(double x, double y)
	{
		return new ReadOnlyVector2d(x, y);
	}
	
	static Vector2dr of(Vector2ir value)
	{
		return new ReadOnlyVector2d(value);
	}

	static Vector2dr of(Vector2lr value)
	{
		return new ReadOnlyVector2d(value);
	}

	static Vector2dr of(Vector2fr value)
	{
		return new ReadOnlyVector2d(value);
	}

	static Vector2dr of(Vector2dr value)
	{
		return new ReadOnlyVector2d(value);
	}

	double squareLength();
	double absoluteLength();
	double absoluteSize();
	double length();
	double size();
	double maxSize();

	double squareDistance(Vector2ir vector);
	double squareDistance(Vector2lr vector);
	double squareDistance(Vector2fr vector);
	double squareDistance(Vector2dr vector);
	double absoluteDistance(Vector2ir vector);
	double absoluteDistance(Vector2lr vector);
	double absoluteDistance(Vector2fr vector);
	double absoluteDistance(Vector2dr vector);
	double dotProduct(Vector2ir vector);
	double dotProduct(Vector2lr vector);
	double dotProduct(Vector2fr vector);
	double dotProduct(Vector2dr vector);
	double distance(Vector2ir vector);
	double distance(Vector2lr vector);
	double distance(Vector2fr vector);
	double distance(Vector2dr vector);
	double maxDistance(Vector2ir vector);
	double maxDistance(Vector2lr vector);
	double maxDistance(Vector2fr vector);
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

	double getX();
	double x();
	double getY();
	double y();

}
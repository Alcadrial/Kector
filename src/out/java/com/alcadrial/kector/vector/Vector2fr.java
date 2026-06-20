package com.alcadrial.kector.vector;

import com.alcadrial.kector.vector.readonly.ReadOnlyVector2f;

/**
 * A read-only 2-dimensional vector {X, Y}
 */
public interface Vector2fr {

	static Vector2fr of()
	{
		return ReadOnlyVector2f.ZERO;
	}
	
	static Vector2fr of(float x, float y)
	{
		return new ReadOnlyVector2f(x, y);
	}
	
	static Vector2fr of(Vector2ir value)
	{
		return new ReadOnlyVector2f(value);
	}

	static Vector2fr of(Vector2lr value)
	{
		return new ReadOnlyVector2f(value);
	}

	static Vector2fr of(Vector2fr value)
	{
		return new ReadOnlyVector2f(value);
	}

	static Vector2fr of(Vector2dr value)
	{
		return new ReadOnlyVector2f(value);
	}

	double squareLength();
	double absoluteLength();
	double absoluteSize();
	float length();
	float size();
	float maxSize();

	float squareDistance(Vector2ir vector);
	float squareDistance(Vector2lr vector);
	double squareDistance(Vector2fr vector);
	double squareDistance(Vector2dr vector);
	float absoluteDistance(Vector2ir vector);
	float absoluteDistance(Vector2lr vector);
	double absoluteDistance(Vector2fr vector);
	double absoluteDistance(Vector2dr vector);
	float dotProduct(Vector2ir vector);
	float dotProduct(Vector2lr vector);
	double dotProduct(Vector2fr vector);
	double dotProduct(Vector2dr vector);
	float distance(Vector2ir vector);
	float distance(Vector2lr vector);
	float distance(Vector2fr vector);
	double distance(Vector2dr vector);
	float maxDistance(Vector2ir vector);
	float maxDistance(Vector2lr vector);
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

	float getX();
	float x();
	float getY();
	float y();

}
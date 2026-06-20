package com.alcadrial.kector.vector;

import java.util.Objects;
import org.jspecify.annotations.Nullable;
import com.alcadrial.kector.VectorMath;

public abstract class AbstractVector2d implements Vector2dr {

	protected AbstractVector2d() {}

	public double squareLength()
	{
		return VectorMath.squareLength(this);
	}
	public double absoluteLength()
	{
		return VectorMath.absoluteLength(this);
	}
	public double absoluteSize()
	{
		return VectorMath.absoluteSize(this);
	}
	public double length()
	{
		return VectorMath.length(this);
	}
	public double size()
	{
		return VectorMath.size(this);
	}
	public double maxSize()
	{
		return VectorMath.maxSize(this);
	}

	public double squareDistance(Vector2ir vector)
	{
		return VectorMath.squareDistance(vector, this);
	}
	public double squareDistance(Vector2lr vector)
	{
		return VectorMath.squareDistance(vector, this);
	}
	public double squareDistance(Vector2fr vector)
	{
		return VectorMath.squareDistance(vector, this);
	}
	public double squareDistance(Vector2dr vector)
	{
		return VectorMath.squareDistance(this, vector);
	}
	public double absoluteDistance(Vector2ir vector)
	{
		return VectorMath.absoluteDistance(vector, this);
	}
	public double absoluteDistance(Vector2lr vector)
	{
		return VectorMath.absoluteDistance(vector, this);
	}
	public double absoluteDistance(Vector2fr vector)
	{
		return VectorMath.absoluteDistance(vector, this);
	}
	public double absoluteDistance(Vector2dr vector)
	{
		return VectorMath.absoluteDistance(this, vector);
	}
	public double dotProduct(Vector2ir vector)
	{
		return VectorMath.dotProduct(vector, this);
	}
	public double dotProduct(Vector2lr vector)
	{
		return VectorMath.dotProduct(vector, this);
	}
	public double dotProduct(Vector2fr vector)
	{
		return VectorMath.dotProduct(vector, this);
	}
	public double dotProduct(Vector2dr vector)
	{
		return VectorMath.dotProduct(this, vector);
	}
	public double distance(Vector2ir vector)
	{
		return VectorMath.distance(vector, this);
	}
	public double distance(Vector2lr vector)
	{
		return VectorMath.distance(vector, this);
	}
	public double distance(Vector2fr vector)
	{
		return VectorMath.distance(vector, this);
	}
	public double distance(Vector2dr vector)
	{
		return VectorMath.distance(this, vector);
	}
	public double maxDistance(Vector2ir vector)
	{
		return VectorMath.maxDistance(vector, this);
	}
	public double maxDistance(Vector2lr vector)
	{
		return VectorMath.maxDistance(vector, this);
	}
	public double maxDistance(Vector2fr vector)
	{
		return VectorMath.maxDistance(vector, this);
	}
	public double maxDistance(Vector2dr vector)
	{
		return VectorMath.maxDistance(this, vector);
	}

	public int hashcode()
	{
		return Objects.hash(x(), y());
	}
	public boolean equals(Vector2ir v)
	{
		return VectorMath.looseEquals(v, this);
	}
	public boolean equals(Vector2lr v)
	{
		return VectorMath.looseEquals(v, this);
	}
	public boolean equals(Vector2fr v)
	{
		return VectorMath.looseEquals(v, this);
	}
	public boolean equals(Vector2dr v)
	{
		return VectorMath.looseEquals(this, v);
	}
	@Override
	public boolean equals(@Nullable Object obj)
	{
		if (obj instanceof Vector2ir v) return equals(v);
		if (obj instanceof Vector2lr v) return equals(v);
		if (obj instanceof Vector2fr v) return equals(v);
		if (obj instanceof Vector2dr v) return equals(v);
		return false;
	}

	public boolean isGreater(Vector2ir v)
	{
		return x() > v.x() && y() > v.y();
	}
	public boolean isGreater(Vector2lr v)
	{
		return x() > v.x() && y() > v.y();
	}
	public boolean isGreater(Vector2fr v)
	{
		return x() > v.x() && y() > v.y();
	}
	public boolean isGreater(Vector2dr v)
	{
		return x() > v.x() && y() > v.y();
	}
	public boolean isMinor(Vector2ir v)
	{
		return x() < v.x() && y() < v.y();
	}
	public boolean isMinor(Vector2lr v)
	{
		return x() < v.x() && y() < v.y();
	}
	public boolean isMinor(Vector2fr v)
	{
		return x() < v.x() && y() < v.y();
	}
	public boolean isMinor(Vector2dr v)
	{
		return x() < v.x() && y() < v.y();
	}

	public double getX()
	{
		return x();
	}
	public double getY()
	{
		return y();
	}

}
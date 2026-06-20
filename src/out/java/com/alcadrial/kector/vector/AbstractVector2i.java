package com.alcadrial.kector.vector;

import java.util.Objects;
import org.jspecify.annotations.Nullable;
import com.alcadrial.kector.VectorMath;

public abstract class AbstractVector2i implements Vector2ir {

	protected AbstractVector2i() {}

	public long squareLength()
	{
		return VectorMath.squareLength(this);
	}
	public long absoluteLength()
	{
		return VectorMath.absoluteLength(this);
	}
	public long absoluteSize()
	{
		return VectorMath.absoluteSize(this);
	}
	public float length()
	{
		return VectorMath.length(this);
	}
	public float size()
	{
		return VectorMath.size(this);
	}
	public int maxSize()
	{
		return VectorMath.maxSize(this);
	}

	public long squareDistance(Vector2ir vector)
	{
		return VectorMath.squareDistance(this, vector);
	}
	public long squareDistance(Vector2lr vector)
	{
		return VectorMath.squareDistance(this, vector);
	}
	public float squareDistance(Vector2fr vector)
	{
		return VectorMath.squareDistance(this, vector);
	}
	public double squareDistance(Vector2dr vector)
	{
		return VectorMath.squareDistance(this, vector);
	}
	public long absoluteDistance(Vector2ir vector)
	{
		return VectorMath.absoluteDistance(this, vector);
	}
	public long absoluteDistance(Vector2lr vector)
	{
		return VectorMath.absoluteDistance(this, vector);
	}
	public float absoluteDistance(Vector2fr vector)
	{
		return VectorMath.absoluteDistance(this, vector);
	}
	public double absoluteDistance(Vector2dr vector)
	{
		return VectorMath.absoluteDistance(this, vector);
	}
	public long dotProduct(Vector2ir vector)
	{
		return VectorMath.dotProduct(this, vector);
	}
	public long dotProduct(Vector2lr vector)
	{
		return VectorMath.dotProduct(this, vector);
	}
	public float dotProduct(Vector2fr vector)
	{
		return VectorMath.dotProduct(this, vector);
	}
	public double dotProduct(Vector2dr vector)
	{
		return VectorMath.dotProduct(this, vector);
	}
	public float distance(Vector2ir vector)
	{
		return VectorMath.distance(this, vector);
	}
	public double distance(Vector2lr vector)
	{
		return VectorMath.distance(this, vector);
	}
	public float distance(Vector2fr vector)
	{
		return VectorMath.distance(this, vector);
	}
	public double distance(Vector2dr vector)
	{
		return VectorMath.distance(this, vector);
	}
	public int maxDistance(Vector2ir vector)
	{
		return VectorMath.maxDistance(this, vector);
	}
	public long maxDistance(Vector2lr vector)
	{
		return VectorMath.maxDistance(this, vector);
	}
	public float maxDistance(Vector2fr vector)
	{
		return VectorMath.maxDistance(this, vector);
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
		return VectorMath.looseEquals(this, v);
	}
	public boolean equals(Vector2lr v)
	{
		return VectorMath.looseEquals(this, v);
	}
	public boolean equals(Vector2fr v)
	{
		return VectorMath.looseEquals(this, v);
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

	public int getX()
	{
		return x();
	}
	public int getY()
	{
		return y();
	}

}
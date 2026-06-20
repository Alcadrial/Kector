package com.alcadrial.kector.vector;

import java.util.Objects;
import org.jspecify.annotations.Nullable;
import com.alcadrial.kector.VectorMath;

public abstract class AbstractVector3l extends AbstractVector2l implements Vector3lr {

	protected AbstractVector3l() {}

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
	public long maxSize()
	{
		return VectorMath.maxSize(this);
	}

	public long squareDistance(Vector3ir vector)
	{
		return VectorMath.squareDistance(vector, this);
	}
	public double squareDistance(Vector3lr vector)
	{
		return VectorMath.squareDistance(this, vector);
	}
	public float squareDistance(Vector3fr vector)
	{
		return VectorMath.squareDistance(this, vector);
	}
	public double squareDistance(Vector3dr vector)
	{
		return VectorMath.squareDistance(this, vector);
	}
	public long absoluteDistance(Vector3ir vector)
	{
		return VectorMath.absoluteDistance(vector, this);
	}
	public double absoluteDistance(Vector3lr vector)
	{
		return VectorMath.absoluteDistance(this, vector);
	}
	public float absoluteDistance(Vector3fr vector)
	{
		return VectorMath.absoluteDistance(this, vector);
	}
	public double absoluteDistance(Vector3dr vector)
	{
		return VectorMath.absoluteDistance(this, vector);
	}
	public long dotProduct(Vector3ir vector)
	{
		return VectorMath.dotProduct(vector, this);
	}
	public double dotProduct(Vector3lr vector)
	{
		return VectorMath.dotProduct(this, vector);
	}
	public float dotProduct(Vector3fr vector)
	{
		return VectorMath.dotProduct(this, vector);
	}
	public double dotProduct(Vector3dr vector)
	{
		return VectorMath.dotProduct(this, vector);
	}
	public double distance(Vector3ir vector)
	{
		return VectorMath.distance(vector, this);
	}
	public double distance(Vector3lr vector)
	{
		return VectorMath.distance(this, vector);
	}
	public float distance(Vector3fr vector)
	{
		return VectorMath.distance(this, vector);
	}
	public double distance(Vector3dr vector)
	{
		return VectorMath.distance(this, vector);
	}
	public long maxDistance(Vector3ir vector)
	{
		return VectorMath.maxDistance(vector, this);
	}
	public long maxDistance(Vector3lr vector)
	{
		return VectorMath.maxDistance(this, vector);
	}
	public float maxDistance(Vector3fr vector)
	{
		return VectorMath.maxDistance(this, vector);
	}
	public double maxDistance(Vector3dr vector)
	{
		return VectorMath.maxDistance(this, vector);
	}

	public int hashcode()
	{
		return Objects.hash(x(), y(), z());
	}
	public boolean equals(Vector3ir v)
	{
		return VectorMath.looseEquals(v, this);
	}
	public boolean equals(Vector3lr v)
	{
		return VectorMath.looseEquals(this, v);
	}
	public boolean equals(Vector3fr v)
	{
		return VectorMath.looseEquals(this, v);
	}
	public boolean equals(Vector3dr v)
	{
		return VectorMath.looseEquals(this, v);
	}
	@Override
	public boolean equals(@Nullable Object obj)
	{
		if (obj instanceof Vector3ir v) return equals(v);
		if (obj instanceof Vector3lr v) return equals(v);
		if (obj instanceof Vector3fr v) return equals(v);
		if (obj instanceof Vector3dr v) return equals(v);
		return super.equals(obj);
	}

	public boolean isGreater(Vector3ir v)
	{
		return x() > v.x() && y() > v.y() && z() > v.z();
	}
	public boolean isGreater(Vector3lr v)
	{
		return x() > v.x() && y() > v.y() && z() > v.z();
	}
	public boolean isGreater(Vector3fr v)
	{
		return x() > v.x() && y() > v.y() && z() > v.z();
	}
	public boolean isGreater(Vector3dr v)
	{
		return x() > v.x() && y() > v.y() && z() > v.z();
	}
	public boolean isMinor(Vector3ir v)
	{
		return x() < v.x() && y() < v.y() && z() < v.z();
	}
	public boolean isMinor(Vector3lr v)
	{
		return x() < v.x() && y() < v.y() && z() < v.z();
	}
	public boolean isMinor(Vector3fr v)
	{
		return x() < v.x() && y() < v.y() && z() < v.z();
	}
	public boolean isMinor(Vector3dr v)
	{
		return x() < v.x() && y() < v.y() && z() < v.z();
	}

	public long getX()
	{
		return x();
	}
	public long getY()
	{
		return y();
	}
	public long getZ()
	{
		return z();
	}

}
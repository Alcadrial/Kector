package com.alcadrial.kector.vector;

import java.util.Objects;
import org.jspecify.annotations.Nullable;
import com.alcadrial.kector.VectorMath;

public abstract class AbstractVector4l extends AbstractVector3l implements Vector4lr {

	protected AbstractVector4l() {}

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

	public long squareDistance(Vector4ir vector)
	{
		return VectorMath.squareDistance(vector, this);
	}
	public double squareDistance(Vector4lr vector)
	{
		return VectorMath.squareDistance(this, vector);
	}
	public float squareDistance(Vector4fr vector)
	{
		return VectorMath.squareDistance(this, vector);
	}
	public double squareDistance(Vector4dr vector)
	{
		return VectorMath.squareDistance(this, vector);
	}
	public long absoluteDistance(Vector4ir vector)
	{
		return VectorMath.absoluteDistance(vector, this);
	}
	public double absoluteDistance(Vector4lr vector)
	{
		return VectorMath.absoluteDistance(this, vector);
	}
	public float absoluteDistance(Vector4fr vector)
	{
		return VectorMath.absoluteDistance(this, vector);
	}
	public double absoluteDistance(Vector4dr vector)
	{
		return VectorMath.absoluteDistance(this, vector);
	}
	public long dotProduct(Vector4ir vector)
	{
		return VectorMath.dotProduct(vector, this);
	}
	public double dotProduct(Vector4lr vector)
	{
		return VectorMath.dotProduct(this, vector);
	}
	public float dotProduct(Vector4fr vector)
	{
		return VectorMath.dotProduct(this, vector);
	}
	public double dotProduct(Vector4dr vector)
	{
		return VectorMath.dotProduct(this, vector);
	}
	public double distance(Vector4ir vector)
	{
		return VectorMath.distance(vector, this);
	}
	public double distance(Vector4lr vector)
	{
		return VectorMath.distance(this, vector);
	}
	public float distance(Vector4fr vector)
	{
		return VectorMath.distance(this, vector);
	}
	public double distance(Vector4dr vector)
	{
		return VectorMath.distance(this, vector);
	}
	public long maxDistance(Vector4ir vector)
	{
		return VectorMath.maxDistance(vector, this);
	}
	public long maxDistance(Vector4lr vector)
	{
		return VectorMath.maxDistance(this, vector);
	}
	public float maxDistance(Vector4fr vector)
	{
		return VectorMath.maxDistance(this, vector);
	}
	public double maxDistance(Vector4dr vector)
	{
		return VectorMath.maxDistance(this, vector);
	}

	public int hashcode()
	{
		return Objects.hash(x(), y(), z(), w());
	}
	public boolean equals(Vector4ir v)
	{
		return VectorMath.looseEquals(v, this);
	}
	public boolean equals(Vector4lr v)
	{
		return VectorMath.looseEquals(this, v);
	}
	public boolean equals(Vector4fr v)
	{
		return VectorMath.looseEquals(this, v);
	}
	public boolean equals(Vector4dr v)
	{
		return VectorMath.looseEquals(this, v);
	}
	@Override
	public boolean equals(@Nullable Object obj)
	{
		if (obj instanceof Vector4ir v) return equals(v);
		if (obj instanceof Vector4lr v) return equals(v);
		if (obj instanceof Vector4fr v) return equals(v);
		if (obj instanceof Vector4dr v) return equals(v);
		return super.equals(obj);
	}

	public boolean isGreater(Vector4ir v)
	{
		return x() > v.x() && y() > v.y() && z() > v.z() && w() > v.w();
	}
	public boolean isGreater(Vector4lr v)
	{
		return x() > v.x() && y() > v.y() && z() > v.z() && w() > v.w();
	}
	public boolean isGreater(Vector4fr v)
	{
		return x() > v.x() && y() > v.y() && z() > v.z() && w() > v.w();
	}
	public boolean isGreater(Vector4dr v)
	{
		return x() > v.x() && y() > v.y() && z() > v.z() && w() > v.w();
	}
	public boolean isMinor(Vector4ir v)
	{
		return x() < v.x() && y() < v.y() && z() < v.z() && w() < v.w();
	}
	public boolean isMinor(Vector4lr v)
	{
		return x() < v.x() && y() < v.y() && z() < v.z() && w() < v.w();
	}
	public boolean isMinor(Vector4fr v)
	{
		return x() < v.x() && y() < v.y() && z() < v.z() && w() < v.w();
	}
	public boolean isMinor(Vector4dr v)
	{
		return x() < v.x() && y() < v.y() && z() < v.z() && w() < v.w();
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
	public long getW()
	{
		return w();
	}

}
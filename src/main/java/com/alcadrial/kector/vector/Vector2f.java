package com.alcadrial.kector.vector;

import java.util.List;

import com.alcadrial.kector.point.Point2f;
import com.alcadrial.kector.vector.getter.Vector2fGetter;
import com.alcadrial.kector.vector.immutable.ImmutableVector2f;
import com.alcadrial.kector.vector.immutable.ImmutableVector3f;
import com.alcadrial.kector.vector.immutable.ImmutableVector4f;

/**
 * A 2-dimensions vector {X, Y}
 */
public interface Vector2f extends Vector3f, Vector2fGetter {
	
	static Vector4f of(float x, float y, float z, float w)
	{
		return new MutableVector4f(x, y, z, w);
	}
	
	static Vector3f of(float x, float y, float z)
	{
		return new MutableVector3f(x, y, z);
	}
	
	static Vector2f of(float x, float y)
	{
		return new MutableVector2f(x, y);
	}
	
	static Vector4f of(Vector4i v)
	{
		return new MutableVector4f(v);
	}
	
	static Vector4f of(Vector2f v, Vector2f w)
	{
		return new MutableVector4f(v.x(), v.y(), w.x(), w.y());
	}
	
	static Vector4f of(Vector2i v, Vector2i w)
	{
		return new MutableVector4f(v.x(), v.y(), w.x(), w.y());
	}
	
	static Vector3f of(Vector3i v)
	{
		return new MutableVector3f(v);
	}
	
	static Vector2f of(Vector2i v)
	{
		return new MutableVector2f(v);
	}
	
	static Vector4f copyOf(Vector4f v)
	{
		return new MutableVector4f(v);
	}
	
	static Vector3f copyOf(Vector3f v)
	{
		return new MutableVector3f(v);
	}
	
	static Vector2f copyOf(Vector2f v)
	{
		return new MutableVector2f(v);
	}
	
	static Vector4f ofImmutable(float x, float y, float z, float w)
	{
		return new ImmutableVector4f(x, y, z, w);
	}
	
	static Vector3f ofImmutable(float x, float y, float z)
	{
		return new ImmutableVector3f(x, y, z);
	}
	
	static Vector2f ofImmutable(float x, float y)
	{
		return new ImmutableVector2f(x, y);
	}
	
	static Vector4f ofImmutable(Vector4i v)
	{
		return new ImmutableVector4f(v);
	}
	
	static Vector4f ofImmutable(Vector2f v, Vector2f w)
	{
		return new ImmutableVector4f(v.x(), v.y(), w.x(), w.y());
	}
	
	static Vector4f ofImmutable(Vector2i v, Vector2i w)
	{
		return new ImmutableVector4f(v.x(), v.y(), w.x(), w.y());
	}
	
	static Vector3f ofImmutable(Vector3i v)
	{
		return new ImmutableVector3f(v);
	}
	
	static Vector2f ofImmutable(Vector2i v)
	{
		return new ImmutableVector2f(v);
	}
	
	static Vector4f copyOfImmutable(Vector4f v)
	{
		return new ImmutableVector4f(v);
	}
	
	static Vector3f copyOfImmutable(Vector3f v)
	{
		return new ImmutableVector3f(v);
	}
	
	static Vector2f copyOfImmutable(Vector2f v)
	{
		return new ImmutableVector2f(v);
	}
	
	static Vector2f origin()
	{
		return Vector0f.ORIGIN;
	}
	
	Vector2f add(Vector2f vector);
	Vector2f add(Vector2i vector);
	@Override
	Vector2f addAll(float value);
	Vector2f add(float x, float y);
	
	Vector2f subtract(Vector2f vector);
	Vector2f subtract(Vector2i vector);
	@Override
	Vector2f subtractAll(float value);
	Vector2f subtract(float x, float y);
	
	Vector2f multiply(Vector2f vector);
	Vector2f multiply(Vector2i vector);
	@Override
	Vector2f multiplyAll(float value);
	Vector2f multiply(float x, float y);
	
	Vector2f divide(Vector2f vector);
	Vector2f divide(Vector2i vector);
	@Override
	Vector2f divideAll(float value);
	Vector2f divide(float x, float y);
	
	Vector2f perpendicular();
	@Override
	Vector2f opposite();
	@Override
	Vector2f absolute();
	@Override
	Vector2f conjugate();
	@Override
	Vector2f unitary();
	
	boolean isGreater(Vector2f vector);
	boolean isMinor(Vector2f vector);
	boolean isGreater(Vector2i vector);
	boolean isMinor(Vector2i vector);
	
	@Override
	Vector2f setX(float x);
	@Override
	Vector2f setY(float y);
	Vector2f setAll(float x, float y);
	Vector2f setAll(Vector2f vector);
	
	Vector3f xy1();
	@Override
	Vector4f xyz1();
	@Override
	Point2f asPoint();
	
	@Override
	double length();
	@Override
	double size();
	double distance(Vector2f vector);
	double distance(Vector2i vector);
	
	@Override
	List<Float> getValues();
	@Override
	float[] getValuesArray();
}

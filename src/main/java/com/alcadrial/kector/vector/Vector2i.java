package com.alcadrial.kector.vector;

import java.math.RoundingMode;
import java.util.List;

import com.alcadrial.kector.point.Point2f;
import com.alcadrial.kector.vector.getter.Vector2iGetter;
import com.alcadrial.kector.vector.immutable.ImmutableVector2i;
import com.alcadrial.kector.vector.immutable.ImmutableVector3i;
import com.alcadrial.kector.vector.immutable.ImmutableVector4i;

/**
 * A 2-dimensions vector {X, Y}
 */
public interface Vector2i extends Vector3i, Vector2iGetter {
	
	static Vector4i of(int x, int y, int z, int w)
	{
		return new MutableVector4i(x, y, z, w);
	}
	
	static Vector4i of(float x, float y, float z, float w, RoundingMode roundingMode)
	{
		return new MutableVector4i(x, y, z, w, roundingMode);
	}
	
	static Vector3i of(int x, int y, int z)
	{
		return new MutableVector3i(x, y, z);
	}
	
	static Vector3i of(float x, float y, float z, RoundingMode roundingMode)
	{
		return new MutableVector3i(x, y, z, roundingMode);
	}
	
	static Vector2i of(int x, int y)
	{
		return new MutableVector2i(x, y);
	}
	
	static Vector2i of(float x, float y, RoundingMode roundingMode)
	{
		return new MutableVector2i(x, y, roundingMode);
	}
	
	static Vector4i of(Vector4f v)
	{
		return new MutableVector4i(v);
	}
	
	static Vector4i of(Vector4f v, RoundingMode roundingMode)
	{
		return new MutableVector4i(v, roundingMode);
	}
	
	static Vector4i of(Vector2i v, Vector2i w)
	{
		return new MutableVector4i(v.x(), v.y(), w.x(), w.y());
	}
	
	static Vector4i of(Vector2f v, Vector2f w)
	{
		return new MutableVector4i(v.x(), v.y(), w.x(), w.y());
	}
	
	static Vector4i of(Vector2f v, Vector2f w, RoundingMode roundingMode)
	{
		return new MutableVector4i(v.x(), v.y(), w.x(), w.y(), roundingMode);
	}
	
	static Vector3i of(Vector3f v)
	{
		return new MutableVector3i(v);
	}
	
	static Vector3i of(Vector3f v, RoundingMode roundingMode)
	{
		return new MutableVector3i(v, roundingMode);
	}
	
	static Vector2i of(Vector2f v)
	{
		return new MutableVector2i(v);
	}
	
	static Vector2i of(Vector2f v, RoundingMode roundingMode)
	{
		return new MutableVector2i(v, roundingMode);
	}
	
	static Vector4i copyOf(Vector4i v)
	{
		return new MutableVector4i(v);
	}
	
	static Vector3i copyOf(Vector3i v)
	{
		return new MutableVector3i(v);
	}
	
	static Vector2i copyOf(Vector2i v)
	{
		return new MutableVector2i(v);
	}
	
	static Vector4i ofImmutable(int x, int y, int z, int w)
	{
		return new ImmutableVector4i(x, y, z, w);
	}
	
	static Vector4i ofImmutable(float x, float y, float z, float w, RoundingMode roundingMode)
	{
		return new ImmutableVector4i(x, y, z, w, roundingMode);
	}
	
	static Vector4i ofImmutable(Vector2i v, Vector2i w)
	{
		return new ImmutableVector4i(v.x(), v.y(), w.x(), w.y());
	}
	
	static Vector4i ofImmutable(Vector2f v, Vector2f w)
	{
		return new ImmutableVector4i(v.x(), v.y(), w.x(), w.y());
	}
	
	static Vector4i ofImmutable(Vector2f v, Vector2f w, RoundingMode roundingMode)
	{
		return new ImmutableVector4i(v.x(), v.y(), w.x(), w.y(), roundingMode);
	}
	
	static Vector3i ofImmutable(int x, int y, int z)
	{
		return new ImmutableVector3i(x, y, z);
	}
	
	static Vector3i ofImmutable(float x, float y, float z, RoundingMode roundingMode)
	{
		return new ImmutableVector3i(x, y, z, roundingMode);
	}
	
	static Vector2i ofImmutable(int x, int y)
	{
		return new ImmutableVector2i(x, y);
	}
	
	static Vector2i ofImmutable(float x, float y, RoundingMode roundingMode)
	{
		return new ImmutableVector2i(x, y, roundingMode);
	}
	
	static Vector4i ofImmutable(Vector4f v)
	{
		return new ImmutableVector4i(v);
	}
	
	static Vector4i ofImmutable(Vector4f v, RoundingMode roundingMode)
	{
		return new ImmutableVector4i(v, roundingMode);
	}
	
	static Vector3i ofImmutable(Vector3f v)
	{
		return new ImmutableVector3i(v);
	}
	
	static Vector3i ofImmutable(Vector3f v, RoundingMode roundingMode)
	{
		return new ImmutableVector3i(v, roundingMode);
	}
	
	static Vector2i ofImmutable(Vector2f v)
	{
		return new ImmutableVector2i(v);
	}
	
	static Vector2i ofImmutable(Vector2f v, RoundingMode roundingMode)
	{
		return new ImmutableVector2i(v, roundingMode);
	}
	
	static Vector4i copyOfImmutable(Vector4i v)
	{
		return new ImmutableVector4i(v);
	}
	
	static Vector3i copyOfImmutable(Vector3i v)
	{
		return new ImmutableVector3i(v);
	}
	
	static Vector2i copyOfImmutable(Vector2i v)
	{
		return new ImmutableVector2i(v);
	}
	
	static Vector2i origin()
	{
		return Vector0i.ORIGIN;
	}
	
	Vector2i add(Vector2i vector);
	@Override
	Vector2i addAll(int value);
	Vector2i add(int x, int y);
	Vector2f add(Vector2f vector);
	@Override
	Vector2f addAll(float value);
	Vector2f add(float x, float y);
	
	Vector2i subtract(Vector2i vector);
	@Override
	Vector2i subtractAll(int value);
	Vector2i subtract(int x, int y);
	Vector2f subtract(Vector2f vector);
	@Override
	Vector2f subtractAll(float value);
	Vector2f subtract(float x, float y);
	
	Vector2i multiply(Vector2i vector);
	@Override
	Vector2i multiplyAll(int value);
	Vector2i multiply(int x, int y);
	Vector2f multiply(Vector2f vector);
	@Override
	Vector2f multiplyAll(float value);
	Vector2f multiply(float x, float y);
	
	Vector2i divide(Vector2i vector);
	@Override
	Vector2i divideAll(int value);
	Vector2i divide(int x, int y);
	Vector2f divide(Vector2f vector);
	@Override
	Vector2f divideAll(float value);
	Vector2f divide(float x, float y);
	
	Vector2i perpendicular();
	@Override
	Vector2i opposite();
	@Override
	Vector2i absolute();
	@Override
	Vector2i conjugate();
	@Override
	Vector2f unitary();
	
	boolean isGreater(Vector2i vector);
	boolean isMinor(Vector2i vector);
	boolean isGreater(Vector2f vector);
	boolean isMinor(Vector2f vector);
	
	@Override
	Vector2i setX(int x);
	@Override
	Vector2i setY(int y);
	Vector2i setAll(int x, int y);
	Vector2i setAll(Vector2i vector);
	
	Vector3i xy1();
	@Override
	Vector4i xyz1();
	@Override
	Point2f asPoint();
	
	@Override
	double length();
	@Override
	double size();
	double distance(Vector2i vector);
	double distance(Vector2f vector);
	
	@Override
	List<Integer> getValues();
	@Override
	int[] getValuesArray();
}

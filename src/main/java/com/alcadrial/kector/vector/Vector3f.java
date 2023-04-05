package com.alcadrial.kector.vector;

import java.util.List;

import com.alcadrial.kector.matrix.Matrix3f;
import com.alcadrial.kector.point.Point3f;
import com.alcadrial.kector.vector.getter.Vector3fGetter;
import com.alcadrial.kector.vector.immutable.ImmutableVector2f;
import com.alcadrial.kector.vector.immutable.ImmutableVector3f;
import com.alcadrial.kector.vector.immutable.ImmutableVector4f;

/**
 * A 3-dimensions vector {X, Y, Z}
 */
public interface Vector3f extends Vector4f, Vector3fGetter {
	
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
	
	static Vector3f origin()
	{
		return Vector0f.ORIGIN;
	}
	
	Vector3f add(Vector3f vector);
	Vector3f add(Vector3i vector);
	@Override
	Vector3f addAll(float value);
	Vector3f add(float x, float y, float z);
	
	Vector3f subtract(Vector3f vector);
	Vector3f subtract(Vector3i vector);
	@Override
	Vector3f subtractAll(float value);
	Vector3f subtract(float x, float y, float z);
	
	Vector3f multiply(Vector3f vector);
	Vector3f multiply(Vector3i vector);
	@Override
	Vector3f multiplyAll(float value);
	Vector3f multiply(float x, float y, float z);
	Vector3f multiply(Matrix3f matrix);
	
	Vector3f divide(Vector3f vector);
	Vector3f divide(Vector3i vector);
	@Override
	Vector3f divideAll(float value);
	Vector3f divide(float x, float y, float z);
	
	/**
	 * Instantiate a new Vector
	 * @param vector
	 * @return
	 */
	Vector3f crossProduct(Vector3f vector);
	/**
	 * Instantiate a new Vector
	 * @param vector
	 * @return
	 */
	Vector3f crossProduct(Vector3i vector);
	
	@Override
	Vector3f opposite();
	@Override
	Vector3f absolute();
	@Override
	Vector3f conjugate();
	@Override
	Vector3f unitary();
	
	boolean isGreater(Vector3f vector);
	boolean isMinor(Vector3f vector);
	boolean isGreater(Vector3i vector);
	boolean isMinor(Vector3i vector);
	
	@Override
	Vector3f setX(float x);
	@Override
	Vector3f setY(float y);
	@Override
	Vector3f setZ(float z);
	Vector3f setAll(float x, float y, float z);
	Vector3f setAll(Vector3f vector);
	
	/**
	 * Instantiate a new Vector
	 * @param vector
	 * @return
	 */
	@Override
	Vector2f xy();
	/**
	 * Instantiate a new Vector
	 * @param vector
	 * @return
	 */
	Vector2f xz();
	/**
	 * Instantiate a new Vector
	 * @param vector
	 * @return
	 */
	Vector4f xyz1();
	@Override
	Point3f asPoint();
	
	@Override
	double length();
	@Override
	double size();
	double distance(Vector3f vector);
	double distance(Vector3i vector);
	
	@Override
	List<Float> getValues();
	@Override
	float[] getValuesArray();
}

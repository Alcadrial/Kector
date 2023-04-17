package com.alcadrial.kector.vector;

import java.util.List;

import com.alcadrial.kector.matrix.Matrix4f;
import com.alcadrial.kector.point.Point4f;
import com.alcadrial.kector.vector.getter.Vector4fGetter;
import com.alcadrial.kector.vector.immutable.ImmutableVector2f;
import com.alcadrial.kector.vector.immutable.ImmutableVector3f;
import com.alcadrial.kector.vector.immutable.ImmutableVector4f;

/**
 * A 4-dimensions vector {X, Y, Z, W}
 */
public interface Vector4f extends Vector4fGetter, NormalizableVector<Vector4f> {
	
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
	
	Vector4f add(Vector4f vector);
	Vector4f add(Vector4i vector);
	Vector4f addAll(float value);
	Vector4f add(float x, float y, float z, float w);
	
	Vector4f subtract(Vector4f vector);
	Vector4f subtract(Vector4i vector);
	Vector4f subtractAll(float value);
	Vector4f subtract(float x, float y, float z, float w);
	
	Vector4f multiply(Vector4f vector);
	Vector4f multiply(Vector4i vector);
	Vector4f multiplyAll(float value);
	Vector4f multiply(float x, float y, float z, float w);
	Vector4f multiply(Matrix4f matrix);
	
	Vector4f divide(Vector4f vector);
	Vector4f divide(Vector4i vector);
	Vector4f divideAll(float value);
	Vector4f divide(float x, float y, float z, float w);
	
	Vector4f opposite();
	Vector4f absolute();
	Vector4f conjugate();
	
	boolean isGreater(Vector4f vector);
	boolean isMinor(Vector4f vector);
	boolean isGreater(Vector4i vector);
	boolean isMinor(Vector4i vector);
	
	Vector4f setX(float x);
	Vector4f setY(float y);
	Vector4f setZ(float z);
	Vector4f setW(float w);
	Vector4f setAll(float x, float y, float z, float w);
	Vector4f setAll(Vector4f vector);
	
	/**
	 * Instantiate a new Vector
	 * 
	 * @return
	 */
	Vector2f xy();
	/**
	 * Instantiate a new Vector
	 * 
	 * @return
	 */
	Vector2f zw();
	/**
	 * Instantiate a new Vector
	 * 
	 * @return
	 */
	Vector3f xyz();
	/**
	 * Instantiate a new Vector
	 * 
	 * @return
	 */
	Vector3f yzw();
	/**
	 * Instantiate a new Vector
	 * 
	 * @return
	 */
	Vector4f zwxy();
	Point4f asPoint();
	
	double length();
	double size();
	double distance(Vector4f vector);
	double distance(Vector4i vector);
	
	List<Float> getValues();
	float[] getValuesArray();
}

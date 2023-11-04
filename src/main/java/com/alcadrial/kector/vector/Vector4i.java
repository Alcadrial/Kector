package com.alcadrial.kector.vector;

import java.math.RoundingMode;
import java.util.List;

import com.alcadrial.kector.matrix.Matrix4f;
import com.alcadrial.kector.point.Point4f;
import com.alcadrial.kector.vector.getter.Vector4iGetter;
import com.alcadrial.kector.vector.immutable.ImmutableVector2i;
import com.alcadrial.kector.vector.immutable.ImmutableVector3i;
import com.alcadrial.kector.vector.immutable.ImmutableVector4i;

/**
 * A 4-dimensions vector {X, Y, Z, W}
 */
public interface Vector4i extends Vector4iGetter, NormalizableVector<Vector4f> {
	
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
	
	static Vector4i origin()
	{
		return Vector0i.ORIGIN;
	}
	
	Vector4i add(Vector4i vector);
	Vector4i addAll(int value);
	Vector4i add(int x, int y, int z, int w);
	Vector4f add(Vector4f vector);
	Vector4f addAll(float value);
	Vector4f add(float x, float y, float z, float w);
	
	Vector4i subtract(Vector4i vector);
	Vector4i subtractAll(int value);
	Vector4i subtract(int x, int y, int z, int w);
	Vector4f subtract(Vector4f vector);
	Vector4f subtractAll(float value);
	Vector4f subtract(float x, float y, float z, float w);
	
	Vector4i multiply(Vector4i vector);
	Vector4i multiplyAll(int value);
	Vector4i multiply(int x, int y, int z, int w);
	Vector4f multiply(Vector4f vector);
	Vector4f multiplyAll(float value);
	Vector4f multiply(float x, float y, float z, float w);
	Vector4f multiply(Matrix4f matrix);
	
	Vector4i divide(Vector4i vector);
	Vector4i divideAll(int value);
	Vector4i divide(int x, int y, int z, int w);
	Vector4f divide(Vector4f vector);
	Vector4f divideAll(float value);
	Vector4f divide(float x, float y, float z, float w);
	
	float dotProduct(Vector4f vector);
	int dotProduct(Vector4i vector);
	
	Vector4i opposite();
	Vector4i absolute();
	Vector4i conjugate();
	
	boolean isGreater(Vector4i vector);
	boolean isMinor(Vector4i vector);
	boolean isGreater(Vector4f vector);
	boolean isMinor(Vector4f vector);
	
	Vector4i setX(int x);
	Vector4i setY(int y);
	Vector4i setZ(int z);
	Vector4i setW(int w);
	Vector4i setAll(int x, int y, int z, int w);
	Vector4i setAll(Vector4i vector);
	
	Vector2i xy();
	Vector3i xyz();
	Vector3i yzw();
	Vector4i zwxy();
	Point4f asPoint();
	
	double squareLength();
	double length();
	double size();
	double distance(Vector4i vector);
	double distance(Vector4f vector);
	
	double axialLength();
	double axialSize();
	double axialDistance(Vector4i vector);
	double axialDistance(Vector4f vector);
	
	List<Integer> getValues();
	int[] getValuesArray();
}

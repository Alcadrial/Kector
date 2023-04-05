package com.alcadra.kector.vector;

import java.math.RoundingMode;
import java.util.List;

import com.alcadra.kector.matrix.Matrix3f;
import com.alcadra.kector.matrix.Matrix4f;
import com.alcadra.kector.point.Point3f;
import com.alcadra.kector.vector.getter.Vector3iGetter;
import com.alcadra.kector.vector.immutable.ImmutableVector2i;
import com.alcadra.kector.vector.immutable.ImmutableVector3i;
import com.alcadra.kector.vector.immutable.ImmutableVector4i;

/**
 * A 3-dimensions vector {X, Y, Z}
 */
public interface Vector3i extends Vector4i, Vector3iGetter {
	
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
	
	static Vector3i origin()
	{
		return Vector0i.ORIGIN;
	}
	
	Vector3i add(Vector3i vector);
	@Override
	Vector3i addAll(int value);
	Vector3i add(int x, int y, int z);
	/**
	 * Instantiate a new Vector
	 * @param vector
	 * @return
	 */
	Vector3f add(Vector3f vector);
	/**
	 * Instantiate a new Vector
	 * @param vector
	 * @return
	 */
	@Override
	Vector3f addAll(float value);
	/**
	 * Instantiate a new Vector
	 * @param vector
	 * @return
	 */
	Vector3f add(float x, float y, float z);
	
	Vector3i subtract(Vector3i vector);
	@Override
	Vector3i subtractAll(int value);
	Vector3i subtract(int x, int y, int z);
	/**
	 * Instantiate a new Vector
	 * @param vector
	 * @return
	 */
	Vector3f subtract(Vector3f vector);
	/**
	 * Instantiate a new Vector
	 * @param vector
	 * @return
	 */
	@Override
	Vector3f subtractAll(float value);
	/**
	 * Instantiate a new Vector
	 * @param vector
	 * @return
	 */
	Vector3f subtract(float x, float y, float z);
	
	Vector3i multiply(Vector3i vector);
	@Override
	Vector3i multiplyAll(int value);
	Vector3i multiply(int x, int y, int z);
	/**
	 * Instantiate a new Vector
	 * @param vector
	 * @return
	 */
	Vector3f multiply(Vector3f vector);
	/**
	 * Instantiate a new Vector
	 * @param vector
	 * @return
	 */
	@Override
	Vector3f multiplyAll(float value);
	/**
	 * Instantiate a new Vector
	 * @param vector
	 * @return
	 */
	Vector3f multiply(float x, float y, float z);
	/**
	 * Instantiate a new Vector
	 * @param vector
	 * @return
	 */
	Vector3f multiply(Matrix3f matrix);
	/**
	 * Instantiate a new Vector
	 * @param vector
	 * @return
	 */
	@Override
	Vector3f multiply(Matrix4f matrix);
	
	Vector3i divide(Vector3i vector);
	@Override
	Vector3i divideAll(int value);
	Vector3i divide(int x, int y, int z);
	/**
	 * Instantiate a new Vector
	 * @param vector
	 * @return
	 */
	Vector3f divide(Vector3f vector);
	/**
	 * Instantiate a new Vector
	 * @param vector
	 * @return
	 */
	@Override
	Vector3f divideAll(float value);
	/**
	 * Instantiate a new Vector
	 * @param vector
	 * @return
	 */
	Vector3f divide(float x, float y, float z);
	
	/**
	 * Instantiate a new Vector
	 * @param vector
	 * @return
	 */
	Vector3i crossProduct(Vector3i vector);
	/**
	 * Instantiate a new Vector
	 * @param vector
	 * @return
	 */
	Vector3f crossProduct(Vector3f vector);
	
	@Override
	Vector3i opposite();
	@Override
	Vector3i absolute();
	@Override
	Vector3i conjugate();
	/**
	 * Instantiate a new Vector
	 * @param vector
	 * @return
	 */
	@Override
	Vector3f unitary();
	
	boolean isGreater(Vector3i vector);
	boolean isMinor(Vector3i vector);
	boolean isGreater(Vector3f vector);
	boolean isMinor(Vector3f vector);
	
	@Override
	Vector3i setX(int x);
	@Override
	Vector3i setY(int y);
	@Override
	Vector3i setZ(int z);
	Vector3i setAll(int x, int y, int z);
	Vector3i setAll(Vector3i vector);
	
	/**
	 * Instantiate a new Vector
	 * @param vector
	 * @return
	 */
	@Override
	Vector2i xy();
	/**
	 * Instantiate a new Vector
	 * @param vector
	 * @return
	 */
	Vector2i xz();
	/**
	 * Instantiate a new Vector
	 * @param vector
	 * @return
	 */
	Vector4i xyz1();
	@Override
	Point3f asPoint();
	
	@Override
	double length();
	@Override
	double size();
	double distance(Vector3i vector);
	double distance(Vector3f vector);
	
	@Override
	List<Integer> getValues();
	@Override
	int[] getValuesArray();
}

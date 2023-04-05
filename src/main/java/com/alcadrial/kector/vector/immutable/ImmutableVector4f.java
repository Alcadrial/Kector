package com.alcadrial.kector.vector.immutable;

import com.alcadrial.kector.matrix.Matrix4f;
import com.alcadrial.kector.point.Point4f;
import com.alcadrial.kector.vector.AbstractVector4f;
import com.alcadrial.kector.vector.Vector2f;
import com.alcadrial.kector.vector.Vector3f;
import com.alcadrial.kector.vector.Vector4f;
import com.alcadrial.kector.vector.Vector4i;

public class ImmutableVector4f extends AbstractVector4f implements Vector4f {
	
	protected final float X;
	protected final float Y;
	protected final float Z;
	protected final float W;
	protected final int hashcode;
	
	public ImmutableVector4f(Vector4f vector)
	{
		this(vector.x(), vector.y(), vector.z(), vector.w());
	}
	
	public ImmutableVector4f(Vector4i vector)
	{
		this(vector.x(), vector.y(), vector.z(), vector.w());
	}
	
	public ImmutableVector4f(float x, float y, float z, float w)
	{
		X = x;
		Y = y;
		Z = z;
		W = w;
		hashcode = 31 * (31 * (31 * (31 + Float.floatToIntBits(X)) + Float.floatToIntBits(Y)) + Float.floatToIntBits(Z)) + Float.floatToIntBits(W);
	}
	
	@Override
	public Vector4f add(float x, float y, float z, float w)
	{
		return Vector4f.of(X + x, Y + y, Z + z, W + w);
	}
	
	@Override
	public Vector4f subtract(float x, float y, float z, float w)
	{
		return Vector4f.of(X - x, Y - y, Z - z, W - w);
	}
	
	@Override
	public Vector4f multiply(float x, float y, float z, float w)
	{
		return Vector4f.of(X * x, Y * y, Z * z, W * w);
	}
	
	@Override
	public Vector4f divide(float x, float y, float z, float w)
	{
		return Vector4f.of(X / x, Y / y, Z / z, W / w);
	}
	
	@Override
	public Vector4f multiply(Matrix4f matrix)
	{
		float[] m = matrix.toArray();
		float x = X * m[0] + X * m[4] + X * m[8] + X * m[12];
		float y = Y * m[1] + Y * m[5] + Y * m[9] + Y * m[13];
		float z = Z * m[2] + Z * m[6] + Z * m[10] + Z * m[14];
		float w = W * m[3] + W * m[7] + W * m[11] + W * m[15];
		return Vector4f.of(x, y, z, w);
	}
	
	@Override
	public Vector4f opposite()
	{
		return Vector4f.of(-X, -Y, -Z, -W);
	}
	
	@Override
	public Vector4f absolute()
	{
		return Vector4f.of(X < 0 ? -X : X, Y < 0 ? -Y : Y, Z < 0 ? -Z : Z, W < 0 ? -W : W);
	}
	
	@Override
	public Vector4f conjugate()
	{
		return Vector4f.of(X, -Y, -Z, -W);
	}
	
	@Override
	public float x()
	{
		return X;
	}
	
	@Override
	public float y()
	{
		return Y;
	}
	
	@Override
	public float z()
	{
		return Z;
	}
	
	@Override
	public float w()
	{
		return W;
	}
	
	@Override
	public Vector4f setX(float x)
	{
		return Vector4f.of(x, Y, Z, W);
	}
	
	@Override
	public Vector4f setY(float y)
	{
		return Vector4f.of(X, y, Z, W);
	}
	
	@Override
	public Vector4f setZ(float z)
	{
		return Vector4f.of(X, Y, z, W);
	}
	
	@Override
	public Vector4f setW(float w)
	{
		return Vector4f.of(X, Y, Z, w);
	}
	
	@Override
	public Vector4f setAll(float x, float y, float z, float w)
	{
		return Vector4f.of(x, y, z, w);
	}
	
	@Override
	public Vector2f xy()
	{
		return Vector4f.of(X, Y);
	}
	
	@Override
	public Vector2f zw()
	{
		return Vector4f.of(Z, W);
	}
	
	@Override
	public Vector3f xyz()
	{
		return Vector4f.of(X, Y, Z);
	}
	
	@Override
	public Vector3f yzw()
	{
		return Vector4f.of(Y, Z, W);
	}
	
	@Override
	public Vector4f zwxy()
	{
		return Vector4f.of(Z, W, X, Y);
	}
	
	@Override
	public Point4f asPoint()
	{
		return new Point4f(X, Y, Z, W);
	}
	
	@Override
	public int hashCode()
	{
		return hashcode;
	}
	
	@Override
	public boolean equals(Object o)
	{
		return o instanceof Vector4f v && equals(v);
	}
	
	public boolean equals(Vector2f vector)
	{
		return vector.x() == X && vector.y() == Y && 0 == Z && 0 == W;
	}
	
	public boolean equals(Vector3f vector)
	{
		return vector.x() == X && vector.y() == Y && vector.z() == Z && 0 == W;
	}
	
	public boolean equals(Vector4f vector)
	{
		return vector.x() == X && vector.y() == Y && vector.z() == Z && vector.w() == W;
	}
	
	@Override
	public String toString()
	{
		return "Vector4f{x=" + X + ", y=" + Y + ", z=" + Z + ", w=" + W + "}";
	}
}

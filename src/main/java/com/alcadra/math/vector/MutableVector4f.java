package com.alcadra.math.vector;

import com.alcadra.math.matrix.Matrix4f;
import com.alcadra.math.point.Point4f;

public class MutableVector4f extends AbstractVector4f implements Vector4f {
	
	protected float X;
	protected float Y;
	protected float Z;
	protected float W;
	
	public MutableVector4f(Vector4f vector)
	{
		this(vector.x(), vector.y(), vector.z(), vector.w());
	}
	
	public MutableVector4f(Vector4i vector)
	{
		this(vector.x(), vector.y(), vector.z(), vector.w());
	}
	
	public MutableVector4f(float x, float y, float z, float w)
	{
		X = x;
		Y = y;
		Z = z;
		W = w;
	}
	
	@Override
	public Vector4f add(float x, float y, float z, float w)
	{
		X += x;
		Y += y;
		Z += z;
		W += w;
		return this;
	}
	
	@Override
	public Vector4f subtract(float x, float y, float z, float w)
	{
		X -= x;
		Y -= y;
		Z -= z;
		W -= w;
		return this;
	}
	
	@Override
	public Vector4f multiply(float x, float y, float z, float w)
	{
		X *= x;
		Y *= y;
		Z *= z;
		W *= w;
		return this;
	}
	
	@Override
	public Vector4f divide(float x, float y, float z, float w)
	{
		X /= x;
		Y /= y;
		Z /= z;
		W /= w;
		return this;
	}
	
	@Override
	public Vector4f multiply(Matrix4f matrix)
	{
		float[] m = matrix.toArray();
		float x = X * m[0] + X * m[4] + X * m[8] + X * m[12];
		float y = Y * m[1] + Y * m[5] + Y * m[9] + Y * m[13];
		float z = Z * m[2] + Z * m[6] + Z * m[10] + Z * m[14];
		float w = W * m[3] + W * m[7] + W * m[11] + W * m[15];
		X = x;
		Y = y;
		Z = z;
		W = w;
		return this;
	}
	
	@Override
	public Vector4f opposite()
	{
		X = -X;
		Y = -Y;
		Z = -Z;
		W = -W;
		return this;
	}
	
	@Override
	public Vector4f absolute()
	{
		if (X < 0) X = -X;
		if (Y < 0) Y = -Y;
		if (Z < 0) Z = -Z;
		if (W < 0) W = -W;
		return this;
	}
	
	@Override
	public Vector4f conjugate()
	{
		Y = -Y;
		Z = -Z;
		W = -W;
		return this;
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
		X = x;
		return this;
	}
	
	@Override
	public Vector4f setY(float y)
	{
		Y = y;
		return this;
	}
	
	@Override
	public Vector4f setZ(float z)
	{
		Z = z;
		return this;
	}
	
	@Override
	public Vector4f setW(float w)
	{
		W = w;
		return this;
	}
	
	@Override
	public Vector4f setAll(float x, float y, float z, float w)
	{
		X = x;
		Y = y;
		Z = z;
		W = w;
		return this;
	}
	
	@Override
	public Vector2f xy()
	{
		return new MutableVector2f(X, Y);
	}
	
	@Override
	public Vector2f zw()
	{
		return new MutableVector2f(Z, W);
	}
	
	@Override
	public Vector3f xyz()
	{
		return new MutableVector3f(X, Y, Z);
	}
	
	@Override
	public Vector3f yzw()
	{
		return new MutableVector3f(Y, Z, W);
	}
	
	@Override
	public Vector4f zwxy()
	{
		return new MutableVector4f(Z, W, X, Y);
	}
	
	@Override
	public Point4f asPoint()
	{
		return new Point4f(X, Y, Z, W);
	}
	
	@Override
	public int hashCode()
	{
		int result = 1;
		result = 31 * result + Float.floatToIntBits(X);
		result = 31 * result + Float.floatToIntBits(Y);
		result = 31 * result + Float.floatToIntBits(Z);
		return 31 * result + Float.floatToIntBits(W);
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

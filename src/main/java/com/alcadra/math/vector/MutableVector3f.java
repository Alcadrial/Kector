package com.alcadra.math.vector;

import com.alcadra.math.matrix.Matrix3f;
import com.alcadra.math.matrix.Matrix4f;
import com.alcadra.math.point.Point3f;

public class MutableVector3f extends AbstractVector3f implements Vector3f, Vector4f {
	
	protected float X;
	protected float Y;
	protected float Z;
	
	public MutableVector3f(Vector3f vector)
	{
		this(vector.x(), vector.y(), vector.z());
	}
	
	public MutableVector3f(Vector3i vector)
	{
		this(vector.x(), vector.y(), vector.z());
	}
	
	public MutableVector3f(float x, float y, float z)
	{
		X = x;
		Y = y;
		Z = z;
	}
	
	@Override
	public Vector3f add(float x, float y, float z)
	{
		X += x;
		Y += y;
		Z += z;
		return this;
	}
	
	@Override
	public Vector4f add(float x, float y, float z, float w)
	{
		if (w == 0) return add(x, y, z);
		return new MutableVector4f(X + x, Y + y, Z + z, w);
	}
	
	@Override
	public Vector3f subtract(float x, float y, float z)
	{
		X -= x;
		Y -= y;
		Z -= z;
		return this;
	}
	
	@Override
	public Vector4f subtract(float x, float y, float z, float w)
	{
		if (w == 0) return subtract(x, y, z);
		return new MutableVector4f(X - x, Y - y, Z - z, -w);
	}
	
	@Override
	public Vector3f multiply(float x, float y, float z)
	{
		X *= x;
		Y *= y;
		Z *= z;
		return this;
	}
	
	@Override
	public Vector3f multiply(float x, float y, float z, float w)
	{
		return multiply(x, y, z);
	}
	
	@Override
	public Vector3f divide(float x, float y, float z)
	{
		X /= x;
		Y /= y;
		Z /= z;
		return this;
	}
	
	@Override
	public Vector3f divide(float x, float y, float z, float w)
	{
		return divide(x, y, z);
	}
	
	@Override
	public Vector3f multiply(Matrix3f matrix)
	{
		float[] m = matrix.toArray();
		float x = X * m[0] + X * m[3] + X * m[6];
		float y = Y * m[1] + Y * m[4] + Y * m[7];
		float z = Z * m[2] + Z * m[5] + Z * m[8];
		X = x;
		Y = y;
		Z = z;
		return this;
	}
	
	@Override
	public Vector3f multiply(Matrix4f matrix)
	{
		float[] m = matrix.toArray();
		float x = X * m[0] + X * m[4] + X * m[8] + X * m[12];
		float y = Y * m[1] + Y * m[5] + Y * m[9] + Y * m[13];
		float z = Z * m[2] + Z * m[6] + Z * m[10] + Z * m[14];
		X = x;
		Y = y;
		Z = z;
		return this;
	}
	
	@Override
	public Vector3f crossProduct(Vector3f vector)
	{
		return new MutableVector3f(Y * vector.z() - Z * vector.y(), Z * vector.x() - X * vector.z(), X * vector.y() - Y * vector.x());
	}
	
	@Override
	public Vector3f crossProduct(Vector3i vector)
	{
		return new MutableVector3f(Y * vector.z() - Z * vector.y(), Z * vector.x() - X * vector.z(), X * vector.y() - Y * vector.x());
	}
	
	@Override
	public Vector3f opposite()
	{
		X = -X;
		Y = -Y;
		Z = -Z;
		return this;
	}
	
	@Override
	public Vector3f absolute()
	{
		if (X < 0) X = -X;
		if (Y < 0) Y = -Y;
		if (Z < 0) Z = -Z;
		return this;
	}
	
	@Override
	public Vector3f conjugate()
	{
		Y = -Y;
		Z = -Z;
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
		return 0;
	}
	
	@Override
	public Vector3f setX(float x)
	{
		X = x;
		return this;
	}
	
	@Override
	public Vector3f setY(float y)
	{
		Y = y;
		return this;
	}
	
	@Override
	public Vector3f setZ(float z)
	{
		Z = z;
		return this;
	}
	
	@Override
	public Vector4f setW(float w)
	{
		if (w == 0) return this;
		return Vector4f.of(X, Y, Z, w);
	}
	
	@Override
	public Vector3f setAll(float x, float y, float z)
	{
		X = x;
		Y = y;
		Z = z;
		return this;
	}
	
	@Override
	public Vector4f setAll(float x, float y, float z, float w)
	{
		if (w == 0) return setAll(x, y, z);
		return Vector4f.of(x, y, z, w);
	}
	
	@Override
	public Vector2f xy()
	{
		return new MutableVector2f(X, Y);
	}
	
	@Override
	public Vector3f xyz()
	{
		return new MutableVector3f(this);
	}
	
	@Override
	public Vector2f xz()
	{
		return new MutableVector2f(X, Z);
	}
	
	@Override
	public Vector2f zw()
	{
		return new MutableVector2f(Z, 0);
	}
	
	@Override
	public Vector2f yzw()
	{
		return new MutableVector2f(Y, Z);
	}
	
	@Override
	public Vector4f xyz1()
	{
		return new MutableVector4f(X, Y, Z, 1);
	}
	
	@Override
	public Vector4f zwxy()
	{
		return new MutableVector4f(Z, 0, X, Y);
	}
	
	@Override
	public Point3f asPoint()
	{
		return new Point3f(X, Y, Z);
	}
	
	@Override
	public int hashCode()
	{
		int result = 1;
		result = 31 * result + Float.floatToIntBits(X);
		result = 31 * result + Float.floatToIntBits(Y);
		return 31 * result + Float.floatToIntBits(Z);
	}
	
	@Override
	public boolean equals(Object obj)
	{
		return obj instanceof Vector3f vector3f && equals(vector3f) || obj instanceof Vector4f vector4f && equals(vector4f);
	}
	
	public boolean equals(Vector3f vector)
	{
		return vector.x() == X && vector.y() == Y && vector.z() == Z;
	}
	
	public boolean equals(Vector4f vector)
	{
		return vector.x() == X && vector.y() == Y && vector.z() == Z && vector.w() == 0;
	}
	
	@Override
	public String toString()
	{
		return "Vector3f{x=" + X + ", y=" + Y + ", z=" + Z + "}";
	}
}

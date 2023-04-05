package com.alcadrial.kector.vector.immutable;

import com.alcadrial.kector.matrix.Matrix3f;
import com.alcadrial.kector.matrix.Matrix4f;
import com.alcadrial.kector.point.Point3f;
import com.alcadrial.kector.vector.AbstractVector3f;
import com.alcadrial.kector.vector.Vector2f;
import com.alcadrial.kector.vector.Vector3f;
import com.alcadrial.kector.vector.Vector3i;
import com.alcadrial.kector.vector.Vector4f;

public class ImmutableVector3f extends AbstractVector3f implements Vector3f, Vector4f {
	
	protected final float X;
	protected final float Y;
	protected final float Z;
	protected final int hashcode;
	
	public ImmutableVector3f(Vector3f vector)
	{
		this(vector.x(), vector.y(), vector.z());
	}
	
	public ImmutableVector3f(Vector3i vector)
	{
		this(vector.x(), vector.y(), vector.z());
	}
	
	public ImmutableVector3f(float x, float y, float z)
	{
		X = x;
		Y = y;
		Z = z;
		hashcode = 31 * (31 * (31 + Float.floatToIntBits(X)) + Float.floatToIntBits(Y)) + Float.floatToIntBits(Z);
	}
	
	@Override
	public Vector3f add(float x, float y, float z)
	{
		return Vector3f.of(X + x, Y + y, Z + z);
	}
	
	@Override
	public Vector4f add(float x, float y, float z, float w)
	{
		if (w == 0) return add(x, y, z);
		return Vector3f.of(X + x, Y + y, Z + z, w);
	}
	
	@Override
	public Vector3f subtract(float x, float y, float z)
	{
		return Vector3f.of(X - x, Y - y, Z - z);
	}
	
	@Override
	public Vector4f subtract(float x, float y, float z, float w)
	{
		if (w == 0) return subtract(x, y, z);
		return Vector3f.of(X - x, Y - y, Z - z, -w);
	}
	
	@Override
	public Vector3f multiply(float x, float y, float z)
	{
		return Vector3f.of(X * x, Y * y, Z * z);
	}
	
	@Override
	public Vector3f multiply(float x, float y, float z, float w)
	{
		return multiply(x, y, z);
	}
	
	@Override
	public Vector3f divide(float x, float y, float z)
	{
		return Vector3f.of(X / x, Y / y, Z / z);
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
		return Vector3f.of(x, y, z);
	}
	
	@Override
	public Vector3f multiply(Matrix4f matrix)
	{
		float[] m = matrix.toArray();
		float x = X * m[0] + X * m[4] + X * m[8] + X * m[12];
		float y = Y * m[1] + Y * m[5] + Y * m[9] + Y * m[13];
		float z = Z * m[2] + Z * m[6] + Z * m[10] + Z * m[14];
		return Vector3f.of(x, y, z);
	}
	
	@Override
	public Vector3f crossProduct(Vector3f vector)
	{
		return Vector3f.of(Y * vector.z() - Z * vector.y(), Z * vector.x() - X * vector.z(), X * vector.y() - Y * vector.x());
	}
	
	@Override
	public Vector3f crossProduct(Vector3i vector)
	{
		return Vector3f.of(Y * vector.z() - Z * vector.y(), Z * vector.x() - X * vector.z(), X * vector.y() - Y * vector.x());
	}
	
	@Override
	public Vector3f opposite()
	{
		return Vector3f.of(-X, -Y, -Z);
	}
	
	@Override
	public Vector3f absolute()
	{
		return Vector3f.of(X < 0 ? -X : X, Y < 0 ? -Y : Y, Z < 0 ? -Z : Z);
	}
	
	@Override
	public Vector3f conjugate()
	{
		return Vector3f.of(X, -Y, -Z);
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
		return Vector3f.of(x, Y, Z);
	}
	
	@Override
	public Vector3f setY(float y)
	{
		return Vector3f.of(X, y, Z);
	}
	
	@Override
	public Vector3f setZ(float z)
	{
		return Vector3f.of(X, Y, z);
	}
	
	@Override
	public Vector4f setW(float w)
	{
		if (w == 0) return this;
		return Vector3f.of(X, Y, Z, w);
	}
	
	@Override
	public Vector3f setAll(float x, float y, float z)
	{
		return Vector3f.of(x, y, z);
	}
	
	@Override
	public Vector4f setAll(float x, float y, float z, float w)
	{
		if (w == 0) return setAll(x, y, z);
		return Vector3f.of(x, y, z, w);
	}
	
	@Override
	public Vector2f xy()
	{
		return Vector3f.of(X, Y);
	}
	
	@Override
	public Vector3f xyz()
	{
		return Vector3f.copyOf(this);
	}
	
	@Override
	public Vector2f xz()
	{
		return Vector3f.of(X, Z);
	}
	
	@Override
	public Vector2f zw()
	{
		return Vector3f.of(Z, 0);
	}
	
	@Override
	public Vector2f yzw()
	{
		return Vector3f.of(Y, Z);
	}
	
	@Override
	public Vector4f xyz1()
	{
		return Vector3f.of(X, Y, Z, 1);
	}
	
	@Override
	public Vector4f zwxy()
	{
		return Vector3f.of(Z, 0, X, Y);
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
		return obj instanceof Vector3f vector3f && equals(vector3f);
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

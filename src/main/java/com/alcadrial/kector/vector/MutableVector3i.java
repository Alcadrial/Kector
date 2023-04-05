package com.alcadrial.kector.vector;

import java.math.RoundingMode;

import com.alcadrial.kector.Math;
import com.alcadrial.kector.matrix.Matrix3f;
import com.alcadrial.kector.matrix.Matrix4f;
import com.alcadrial.kector.point.Point3f;

public class MutableVector3i extends AbstractVector3i {
	
	protected int X;
	protected int Y;
	protected int Z;
	
	protected MutableVector3i(Vector3i vector)
	{
		this(vector.x(), vector.y(), vector.z());
	}
	
	protected MutableVector3i(Vector3f vector)
	{
		this(vector, RoundingMode.DOWN);
	}
	
	protected MutableVector3i(Vector3f vector, RoundingMode roundingMode)
	{
		this(vector.x(), vector.y(), vector.z(), roundingMode);
	}
	
	protected MutableVector3i(float x, float y, float z)
	{
		this(x, y, z, RoundingMode.DOWN);
	}
	
	protected MutableVector3i(float x, float y, float z, RoundingMode roundingMode)
	{
		this(Math.toInt(x, roundingMode), Math.toInt(y, roundingMode), Math.toInt(z, roundingMode));
	}
	
	protected MutableVector3i(int x, int y, int z)
	{
		X = x;
		Y = y;
		Z = z;
	}
	
	@Override
	public Vector3i add(int x, int y, int z)
	{
		X += x;
		Y += y;
		Z += z;
		return this;
	}
	
	@Override
	public Vector3f add(float x, float y, float z)
	{
		return new MutableVector3f(X + x, Y + y, Z + z);
	}
	
	@Override
	public Vector4i add(int x, int y, int z, int w)
	{
		if (w == 0) return add(x, y, z);
		return new MutableVector4i(X + x, Y + y, Z + z, w);
	}
	
	@Override
	public Vector4f add(float x, float y, float z, float w)
	{
		if (w == 0) return add(x, y, z);
		return new MutableVector4f(X + x, Y + y, Z + z, w);
	}
	
	@Override
	public Vector3i subtract(int x, int y, int z)
	{
		X -= x;
		Y -= y;
		Z -= z;
		return this;
	}
	
	@Override
	public Vector3f subtract(float x, float y, float z)
	{
		return new MutableVector3f(X - x, Y - y, Z - z);
	}
	
	@Override
	public Vector4i subtract(int x, int y, int z, int w)
	{
		if (w == 0) return subtract(x, y, z);
		return new MutableVector4i(X - x, Y - y, Z - z, -w);
	}
	
	@Override
	public Vector4f subtract(float x, float y, float z, float w)
	{
		if (w == 0) return subtract(x, y, z);
		return new MutableVector4f(X - x, Y - y, Z - z, -w);
	}
	
	@Override
	public Vector3i multiply(int x, int y, int z)
	{
		X *= x;
		Y *= y;
		Z *= z;
		return this;
	}
	
	@Override
	public Vector3f multiply(float x, float y, float z)
	{
		return new MutableVector3f(X * x, Y * y, Z * z);
	}
	
	@Override
	public Vector3i multiply(int x, int y, int z, int w)
	{
		return multiply(x, y, z);
	}
	
	@Override
	public Vector3f multiply(float x, float y, float z, float w)
	{
		return multiply(x, y, z);
	}
	
	@Override
	public Vector3i divide(int x, int y, int z)
	{
		X /= x;
		Y /= y;
		Z /= z;
		return this;
	}
	
	@Override
	public Vector3f divide(float x, float y, float z)
	{
		return new MutableVector3f(X * x, Y * y, Z * z);
	}
	
	@Override
	public Vector3i divide(int x, int y, int z, int w)
	{
		return divide(x, y, z);
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
		return new MutableVector3f(x, y, z);
	}
	
	@Override
	public Vector3f multiply(Matrix4f matrix)
	{
		float[] m = matrix.toArray();
		float x = X * m[0] + X * m[4] + X * m[8] + X * m[12];
		float y = Y * m[1] + Y * m[5] + Y * m[9] + Y * m[13];
		float z = Z * m[2] + Z * m[6] + Z * m[10] + Z * m[14];
		return new MutableVector3f(x, y, z);
	}
	
	@Override
	public Vector3i crossProduct(Vector3i vector)
	{
		return new MutableVector3i(Y * vector.z() - Z * vector.y(), Z * vector.x() - X * vector.z(), X * vector.y() - Y * vector.x());
	}
	
	@Override
	public Vector3f crossProduct(Vector3f vector)
	{
		return new MutableVector3f(Y * vector.z() - Z * vector.y(), Z * vector.x() - X * vector.z(), X * vector.y() - Y * vector.x());
	}
	
	@Override
	public Vector3i opposite()
	{
		X = -X;
		Y = -Y;
		Z = -Z;
		return this;
	}
	
	@Override
	public Vector3i absolute()
	{
		if (X < 0) X = -X;
		if (Y < 0) Y = -Y;
		if (Z < 0) Z = -Z;
		return this;
	}
	
	@Override
	public Vector3i conjugate()
	{
		Y = -Y;
		Z = -Z;
		return this;
	}
	
	@Override
	public int x()
	{
		return X;
	}
	
	@Override
	public int y()
	{
		return Y;
	}
	
	@Override
	public int z()
	{
		return Z;
	}
	
	@Override
	public int w()
	{
		return 0;
	}
	
	@Override
	public Vector3i setX(int x)
	{
		X = x;
		return this;
	}
	
	@Override
	public Vector3i setY(int y)
	{
		Y = y;
		return this;
	}
	
	@Override
	public Vector3i setZ(int z)
	{
		Z = z;
		return this;
	}
	
	@Override
	public Vector4i setW(int w)
	{
		if (w == 0) return this;
		return Vector4i.of(X, Y, Z, w);
	}
	
	@Override
	public Vector3i setAll(int x, int y, int z)
	{
		X = x;
		Y = y;
		Z = z;
		return this;
	}
	
	@Override
	public Vector4i setAll(int x, int y, int z, int w)
	{
		if (w == 0) return setAll(x, y, z);
		return Vector4i.of(x, y, z, w);
	}
	
	@Override
	public Vector2i xy()
	{
		return new MutableVector2i(X, Y);
	}
	
	@Override
	public Vector3i xyz()
	{
		return new MutableVector3i(this);
	}
	
	@Override
	public Vector2i xz()
	{
		return new MutableVector2i(X, Z);
	}
	
	@Override
	public Vector2i yzw()
	{
		return new MutableVector2i(Y, Z);
	}
	
	@Override
	public Vector4i xyz1()
	{
		return new MutableVector4i(X, Y, Z, 1);
	}
	
	@Override
	public Vector4i zwxy()
	{
		return new MutableVector4i(Z, 0, X, Y);
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
		result = 31 * result + X;
		result = 31 * result + Y;
		return 31 * result + Z;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		return obj instanceof MutableVector3i v && v.x() == X && v.y() == Y && v.z() == Z;
	}
	
	@Override
	public String toString()
	{
		return "Vector3i{x=" + X + ", y=" + Y + ", z=" + Z + "}";
	}
}

package com.alcadra.kector.vector.immutable;

import java.math.RoundingMode;

import com.alcadra.kector.Math;
import com.alcadra.kector.matrix.Matrix4f;
import com.alcadra.kector.point.Point4f;
import com.alcadra.kector.vector.AbstractVector4i;
import com.alcadra.kector.vector.Vector2i;
import com.alcadra.kector.vector.Vector3i;
import com.alcadra.kector.vector.Vector4f;
import com.alcadra.kector.vector.Vector4i;

public class ImmutableVector4i extends AbstractVector4i {
	
	protected final int X;
	protected final int Y;
	protected final int Z;
	protected final int W;
	protected final int hashcode;
	
	public ImmutableVector4i(Vector4i vector)
	{
		this(vector.x(), vector.y(), vector.z(), vector.w());
	}
	
	public ImmutableVector4i(Vector4f vector)
	{
		this(vector, RoundingMode.DOWN);
	}
	
	public ImmutableVector4i(Vector4f vector, RoundingMode roundingMode)
	{
		this(vector.x(), vector.y(), vector.z(), vector.w(), roundingMode);
	}
	
	public ImmutableVector4i(float x, float y, float z, float w)
	{
		this(x, y, z, w, RoundingMode.DOWN);
	}
	
	public ImmutableVector4i(float x, float y, float z, float w, RoundingMode roundingMode)
	{
		this(Math.toInt(x, roundingMode), Math.toInt(y, roundingMode), Math.toInt(z, roundingMode), Math.toInt(w, roundingMode));
	}
	
	public ImmutableVector4i(int x, int y, int z, int w)
	{
		X = x;
		Y = y;
		Z = z;
		W = w;
		hashcode = 31 * (31 * (31 * (31 + X) + Y) + Z) + W;
	}
	
	@Override
	public Vector4i add(int x, int y, int z, int w)
	{
		return Vector4i.of(X + x, Y + y, Z + z, W + w);
	}
	
	@Override
	public Vector4f add(float x, float y, float z, float w)
	{
		return Vector4f.of(X + x, Y + y, Z + z, W + w);
	}
	
	@Override
	public Vector4i subtract(int x, int y, int z, int w)
	{
		return Vector4i.of(X - x, Y - y, Z - z, W - w);
	}
	
	@Override
	public Vector4f subtract(float x, float y, float z, float w)
	{
		return Vector4f.of(X - x, Y - y, Z - z, W - w);
	}
	
	@Override
	public Vector4i multiply(int x, int y, int z, int w)
	{
		return Vector4i.of(X * x, Y * y, Z * z, W * w);
	}
	
	@Override
	public Vector4f multiply(float x, float y, float z, float w)
	{
		return Vector4f.of(X * x, Y * y, Z * z, W * w);
	}
	
	@Override
	public Vector4f multiply(Matrix4f matrix)
	{
		float[] m = matrix.toArray();
		float x = x() * m[0] + x() * m[4] + x() * m[8] + x() * m[12];
		float y = y() * m[1] + y() * m[5] + y() * m[9] + y() * m[13];
		float z = z() * m[2] + z() * m[6] + z() * m[10] + z() * m[14];
		float w = w() * m[3] + w() * m[7] + w() * m[11] + w() * m[15];
		return Vector4f.of(x, y, z, w);
	}
	
	@Override
	public Vector4i divide(int x, int y, int z, int w)
	{
		return Vector4i.of(X / x, Y / y, Z / z, W / w);
	}
	
	@Override
	public Vector4f divide(float x, float y, float z, float w)
	{
		return Vector4f.of(X / x, Y / y, Z / z, W / w);
	}
	
	@Override
	public Vector4i opposite()
	{
		return Vector4i.of(-X, -Y, -Z, -W);
	}
	
	@Override
	public Vector4i absolute()
	{
		return Vector4i.of(X < 0 ? -X : X, Y < 0 ? -Y : Y, Z < 0 ? -Z : Z, W < 0 ? -W : W);
	}
	
	@Override
	public Vector4i conjugate()
	{
		return Vector4i.of(X, -Y, -Z, -W);
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
		return W;
	}
	
	@Override
	public Vector4i setX(int x)
	{
		return Vector4i.of(x, Y, Z, W);
	}
	
	@Override
	public Vector4i setY(int y)
	{
		return Vector4i.of(X, y, Z, W);
	}
	
	@Override
	public Vector4i setZ(int z)
	{
		return Vector4i.of(X, Y, z, W);
	}
	
	@Override
	public Vector4i setW(int w)
	{
		return Vector4i.of(X, Y, Z, w);
	}
	
	@Override
	public Vector4i setAll(int x, int y, int z, int w)
	{
		return Vector4i.of(X, Y, Z, W);
	}
	
	@Override
	public Vector2i xy()
	{
		return Vector4i.of(X, Y);
	}
	
	@Override
	public Vector3i xyz()
	{
		return Vector4i.of(X, Y, Z);
	}
	
	@Override
	public Vector3i yzw()
	{
		return Vector4i.of(Y, Z, W);
	}
	
	@Override
	public Vector4i zwxy()
	{
		return Vector4i.of(Z, W, X, Y);
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
	public boolean equals(Object obj)
	{
		return obj instanceof Vector4i v && v.x() == X && v.y() == Y && v.z() == Z && v.w() == W;
	}
	
	@Override
	public String toString()
	{
		return "Vector4i{x=" + X + ", y=" + Y + ", z=" + Z + ", w=" + W + "}";
	}
}

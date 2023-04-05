package com.alcadrial.kector.vector;

import java.math.RoundingMode;

import com.alcadrial.kector.Math;
import com.alcadrial.kector.matrix.Matrix4f;
import com.alcadrial.kector.point.Point4f;

public class MutableVector4i extends AbstractVector4i {
	
	protected int X;
	protected int Y;
	protected int Z;
	protected int W;
	
	protected MutableVector4i(Vector4i vector)
	{
		this(vector.x(), vector.y(), vector.z(), vector.w());
	}
	
	protected MutableVector4i(Vector4f vector)
	{
		this(vector, RoundingMode.DOWN);
	}
	
	protected MutableVector4i(Vector4f vector, RoundingMode roundingMode)
	{
		this(vector.x(), vector.y(), vector.z(), vector.w(), roundingMode);
	}
	
	protected MutableVector4i(float x, float y, float z, float w)
	{
		this(x, y, z, w, RoundingMode.DOWN);
	}
	
	protected MutableVector4i(float x, float y, float z, float w, RoundingMode roundingMode)
	{
		this(Math.toInt(x, roundingMode), Math.toInt(y, roundingMode), Math.toInt(z, roundingMode), Math.toInt(w, roundingMode));
	}
	
	protected MutableVector4i(int x, int y, int z, int w)
	{
		X = x;
		Y = y;
		Z = z;
		W = w;
	}
	
	@Override
	public Vector4i add(int x, int y, int z, int w)
	{
		X += x;
		Y += y;
		Z += z;
		W += w;
		return this;
	}
	
	@Override
	public Vector4f add(float x, float y, float z, float w)
	{
		return new MutableVector4f(X + x, Y + y, Z + z, W + w);
	}
	
	@Override
	public Vector4i subtract(int x, int y, int z, int w)
	{
		X -= x;
		Y -= y;
		Z -= z;
		W -= w;
		return this;
	}
	
	@Override
	public Vector4f subtract(float x, float y, float z, float w)
	{
		return new MutableVector4f(X - x, Y - y, Z - z, W - w);
	}
	
	@Override
	public Vector4i multiply(int x, int y, int z, int w)
	{
		X *= x;
		Y *= y;
		Z *= z;
		W *= w;
		return this;
	}
	
	@Override
	public Vector4f multiply(float x, float y, float z, float w)
	{
		return new MutableVector4f(X * x, Y * y, Z * z, W * w);
	}
	
	@Override
	public Vector4f multiply(Matrix4f matrix)
	{
		float[] m = matrix.toArray();
		float x = x() * m[0] + x() * m[4] + x() * m[8] + x() * m[12];
		float y = y() * m[1] + y() * m[5] + y() * m[9] + y() * m[13];
		float z = z() * m[2] + z() * m[6] + z() * m[10] + z() * m[14];
		float w = w() * m[3] + w() * m[7] + w() * m[11] + w() * m[15];
		return new MutableVector4f(x, y, z, w);
	}
	
	@Override
	public Vector4i divide(int x, int y, int z, int w)
	{
		X /= x;
		Y /= y;
		Z /= z;
		W /= w;
		return this;
	}
	
	@Override
	public Vector4f divide(float x, float y, float z, float w)
	{
		return new MutableVector4f(X / x, Y / y, Z / z, W / w);
	}
	
	@Override
	public Vector4i opposite()
	{
		X = -X;
		Y = -Y;
		Z = -Z;
		W = -W;
		return this;
	}
	
	@Override
	public Vector4i absolute()
	{
		if (X < 0) X = -X;
		if (Y < 0) Y = -Y;
		if (Z < 0) Z = -Z;
		if (W < 0) W = -W;
		return this;
	}
	
	@Override
	public Vector4i conjugate()
	{
		Y = -Y;
		Z = -Z;
		W = -W;
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
		return W;
	}
	
	@Override
	public Vector4i setX(int x)
	{
		X = x;
		return this;
	}
	
	@Override
	public Vector4i setY(int y)
	{
		Y = y;
		return this;
	}
	
	@Override
	public Vector4i setZ(int z)
	{
		Z = z;
		return this;
	}
	
	@Override
	public Vector4i setW(int w)
	{
		W = w;
		return this;
	}
	
	@Override
	public Vector4i setAll(int x, int y, int z, int w)
	{
		X = x;
		Y = y;
		Z = z;
		W = w;
		return this;
	}
	
	@Override
	public Vector2i xy()
	{
		return new MutableVector2i(X, Y);
	}
	
	@Override
	public Vector3i xyz()
	{
		return new MutableVector3i(X, Y, Z);
	}
	
	@Override
	public Vector3i yzw()
	{
		return new MutableVector3i(Y, Z, W);
	}
	
	@Override
	public Vector4i zwxy()
	{
		return new MutableVector4i(Z, W, X, Y);
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
		result = 31 * result + X;
		result = 31 * result + Y;
		result = 31 * result + Z;
		return 31 * result + W;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		return obj instanceof MutableVector4i v && v.x() == X && v.y() == Y && v.z() == Z && v.w() == W;
	}
	
	@Override
	public String toString()
	{
		return "Vector4i{x=" + X + ", y=" + Y + ", z=" + Z + ", w=" + W + "}";
	}
}

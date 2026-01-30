package com.alcadrial.kector.vector.complex;

import com.alcadrial.kector.Math;
import com.alcadrial.kector.angle.Angle;
import com.alcadrial.kector.angle.AngleUnit;
import com.alcadrial.kector.annotation.Direction;
import com.alcadrial.kector.annotation.NoZeroComponents;
import com.alcadrial.kector.annotation.Preserve;
import com.alcadrial.kector.annotation.Unitary;
import com.alcadrial.kector.matrix.Matrix4f;
import com.alcadrial.kector.vector.MutableVector3f;
import com.alcadrial.kector.vector.MutableVector4f;
import com.alcadrial.kector.vector.Vector2f;
import com.alcadrial.kector.vector.Vector3f;
import com.alcadrial.kector.vector.Vector3i;
import com.alcadrial.kector.vector.Vector4f;
import com.alcadrial.kector.vector.axis.Axis;

/**
 * <ul>
 * <li>i*i=-1</li>
 * <li>j*j=-1</li>
 * <li>k*k=-1</li>
 * <li>i*j=k</li>
 * <li>i*k=-j</li>
 * <li>j*i=-k</li>
 * <li>j*k=i</li>
 * <li>k*i=j</li>
 * <li>k*j=-i</li>
 * </ul>
 */
public class Quaternion extends MutableVector4f implements IQuaternion {
	
	public static final Quaternion IDENTITY = new Quaternion(1, 0, 0, 0);
	public static final Quaternion X_HALF = new Quaternion(Axis.X, Math.HALF_PIF);
	public static final Quaternion X_OPPOSITE = new Quaternion(Axis.X, Math.PIF);
	public static final Quaternion X_NEGATIVE_HALF = new Quaternion(Axis.X, -Math.HALF_PIF);
	public static final Quaternion Y_HALF = new Quaternion(Axis.Y, Math.HALF_PIF);
	public static final Quaternion Y_OPPOSITE = new Quaternion(Axis.Y, Math.PIF);
	public static final Quaternion Y_NEGATIVE_HALF = new Quaternion(Axis.Y, -Math.HALF_PIF);
	public static final Quaternion Z_HALF = new Quaternion(Axis.Z, Math.HALF_PIF);
	public static final Quaternion Z_OPPOSITE = new Quaternion(Axis.Z, Math.PIF);
	public static final Quaternion Z_NEGATIVE_HALF = new Quaternion(Axis.Z, -Math.HALF_PIF);
	
	@Deprecated
	private static Vector4f factory(@Direction Vector3f axis, Angle angle)
	{
		return factory(axis, angle.asFloat(AngleUnit.RADIANS));
	}
	
	@Deprecated
	private static Vector4f factory(@Direction Vector3i axis, Angle angle)
	{
		return factory(axis, angle.asFloat(AngleUnit.RADIANS));
	}
	
	private static Vector4f factory(@Direction Vector3f axis, @com.alcadrial.kector.annotation.Angle(AngleUnit.RADIANS) float angle)
	{
		float angleValue = angle / 2;
		float s = Math.sin(angleValue);
		return new MutableVector4f(axis.x() * s, axis.y() * s, axis.z() * s, Math.cos(angleValue));
	}
	
	private static Vector4f factory(@Direction Vector3i axis, @com.alcadrial.kector.annotation.Angle(AngleUnit.RADIANS) float angle)
	{
		float angleValue = angle / 2;
		float s = Math.sin(angleValue);
		return new MutableVector4f(axis.x() * s, axis.y() * s, axis.z() * s, Math.cos(angleValue));
	}
	
	@Deprecated
	private static Vector4f factory(Angle xRotation, Angle yRotation, Angle zRotation)
	{
		return factory(xRotation.asFloat(AngleUnit.RADIANS), yRotation.asFloat(AngleUnit.RADIANS), zRotation.asFloat(AngleUnit.RADIANS));
	}
	
	private static Vector4f factory(@com.alcadrial.kector.annotation.Angle(AngleUnit.RADIANS) float xRotation, @com.alcadrial.kector.annotation.Angle(AngleUnit.RADIANS) float yRotation, @com.alcadrial.kector.annotation.Angle(AngleUnit.RADIANS) float zRotation)
	{
		float xCos = Math.cos(xRotation);
		float xSin = Math.sin(xRotation);
		float yCos = Math.cos(yRotation);
		float ySin = Math.sin(yRotation);
		float zCos = Math.cos(zRotation);
		float zSin = Math.sin(zRotation);
		return new MutableVector4f(xSin * yCos * zCos - xCos * ySin * zSin, xCos * ySin * zCos + xSin * yCos * zSin, xCos * yCos * zSin - xSin * ySin * zCos, xCos * yCos * zCos + xSin * ySin * zSin);
	}
	
	@Deprecated
	public Quaternion(@Direction Vector3i axis, Angle angle)
	{
		super(factory(axis, angle));
	}
	
	@Deprecated
	public Quaternion(@Direction Vector3f axis, Angle angle)
	{
		super(factory(axis, angle));
	}
	
	public Quaternion(@Direction Vector3i axis, @com.alcadrial.kector.annotation.Angle(AngleUnit.RADIANS) float angle)
	{
		super(factory(axis, angle));
	}
	
	public Quaternion(@Direction Vector3f axis, @com.alcadrial.kector.annotation.Angle(AngleUnit.RADIANS) float angle)
	{
		super(factory(axis, angle));
	}
	
	public Quaternion(@com.alcadrial.kector.annotation.Angle(AngleUnit.RADIANS) float xRotation, @com.alcadrial.kector.annotation.Angle(AngleUnit.RADIANS) float yRotation, @com.alcadrial.kector.annotation.Angle(AngleUnit.RADIANS) float zRotation)
	{
		super(factory(xRotation, yRotation, zRotation));
	}
	
	@Deprecated
	public Quaternion(Angle xRotation, Angle yRotation, Angle zRotation)
	{
		super(factory(xRotation, yRotation, zRotation));
	}
	
	public Quaternion(@Unitary Vector4f quaternion)
	{
		super(quaternion);
	}
	
	public Quaternion(float r, float i, float j, float k)
	{
		super(i, j, k, r);
	}
	
	public Quaternion(Quaternion quaternion)
	{
		super(quaternion);
	}
	
	@Override
	public Quaternion multiply(IQuaternion q)
	{
		return new Quaternion(r() * q.r() - i() * q.i() - j() * q.j() - k() * q.k(), r() * q.i() + i() * q.r() + j() * q.k() - k() * q.j(), r() * q.j() + j() * q.r() - i() * q.k() + k() * q.i(), r() * q.k() + k() * q.r() + i() * q.j() - j() * q.i());
	}
	
	public Quaternion multiply(Quaternion q)
	{
		return multiply((IQuaternion) q);
	}
	
	@Override
	public Quaternion conjugate()
	{
		return new Quaternion(r(), -i(), -j(), -k());
	}
	
	@Override
	@Preserve({NoZeroComponents.class, Unitary.class})
	public Vector3f rotate(Vector2f v)
	{
		float r2 = r() * r();
		float i2 = i() * i();
		float j2 = j() * j();
		float k2 = k() * k();
		return new MutableVector3f(v.x() * (r2 + i2 - j2 - k2) + 2 * v.y() * (i() * j() - r() * k()), v.y() * (r2 - i2 + j2 - k2) + 2 * v.x() * (r() * k() + i() * j()), 2 * (v.x() * (-r() * j() + i() * k()) + v.y() * (r() * i() + j() * k())));
	}
	
	@Override
	@Preserve({NoZeroComponents.class, Unitary.class})
	public Vector3f rotate(Vector3f v)
	{
		float r2 = r() * r();
		float i2 = i() * i();
		float j2 = j() * j();
		float k2 = k() * k();
		return new MutableVector3f(v.x() * (r2 + i2 - j2 - k2) + 2 * (v.y() * (i() * j() - r() * k()) + v.z() * (i() * k() + r() * y())), v.y() * (r2 - i2 + j2 - k2) + 2 * (v.x() * (r() * k() + i() * j()) + v.z() * (-r() * i() + j() * k())), v.z() * (r2 - i2 - j2 + k2) + 2 * (v.x() * (-r() * j() + i() * k()) + v.y() * (r() * i() + j() * k())));
	}
	
	@Override
	public Vector4f rijk()
	{
		return new MutableVector4f(r(), i(), j(), k());
	}
	
	@Override
	public Vector4f xyzw()
	{
		return new MutableVector4f(this);
	}
	
	public Vector3f vector()
	{
		return rotate(Axis.X);
	}
	
	public Matrix4f matrix()
	{
		double l = length();
		float s = (float) (1 / (l * l));
		float i2 = i() * i();
		float j2 = j() * j();
		float k2 = k() * k();
		return new Matrix4f(new float[][] {
			{1 - 2 * s * (j2 + k2), 2 * s * (i() * j() - k() * r()), 2 * s * (i() * k() + j() * r()), 0},
			{2 * s * (i() * j() + k() * r()), 1 - 2 * s * (i2 + k2), 2 * s * (j() * k() - i() * r()), 0},
			{2 * s * (i() * k() - j() * r()), 2 * s * (j() * k() + i() * r()), 1 - 2 * s * (i2 + j2), 0},
			{0, 0, 0, 1}
		});
	}
	
	@Override
	public float r()
	{
		return W;
	}
	
	@Override
	public float i()
	{
		return X;
	}
	
	@Override
	public float j()
	{
		return Y;
	}
	
	@Override
	public float k()
	{
		return Z;
	}
	
	@Override
	public String toString()
	{
		String s = "";
		boolean r, i, j;
		if (r = (int) (r() * 1000) != 0) s += r();
		if (i = (int) (i() * 1000) != 0)
		{
			if (i() > 0)
			{
				if (r) s += " + ";
				s += i();
			}
			else if (r) s += " - " + -i();
			else s += i();
			s += "i";
		}
		if (j = (int) (j() * 1000) != 0)
		{
			if (j() > 0)
			{
				if (r | i) s += " + ";
				s += j();
			}
			else if (r | i) s += " - " + -j();
			else s += j();
			s += "j";
		}
		if ((int) (k() * 1000) != 0)
		{
			if (k() > 0)
			{
				if (r | i | j) s += " + ";
				s += k();
			}
			else if (r | i | j) s += " - " + -k();
			else s += k();
			s += "k";
		}
		return s.length() == 0 ? "0" : s;
	}
}

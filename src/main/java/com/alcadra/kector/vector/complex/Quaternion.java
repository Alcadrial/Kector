package com.alcadra.kector.vector.complex;

import com.alcadra.kector.Math;
import com.alcadra.kector.angle.Angle;
import com.alcadra.kector.angle.AngleUnit;
import com.alcadra.kector.vector.MutableVector3f;
import com.alcadra.kector.vector.MutableVector4f;
import com.alcadra.kector.vector.Vector2f;
import com.alcadra.kector.vector.Vector3f;
import com.alcadra.kector.vector.Vector3i;
import com.alcadra.kector.vector.Vector4f;
import com.alcadra.kector.vector.axis.Axis;

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
	public static final Quaternion X_HALF = new Quaternion(Axis.X, Angle.V90_DEG);
	public static final Quaternion X_OPPOSITE = new Quaternion(Axis.X, Angle.V180_DEG);
	public static final Quaternion X_NEGATIVE_HALF = new Quaternion(Axis.X, Angle.V270_DEG);
	public static final Quaternion Y_HALF = new Quaternion(Axis.Y, Angle.V90_DEG);
	public static final Quaternion Y_OPPOSITE = new Quaternion(Axis.Y, Angle.V180_DEG);
	public static final Quaternion Y_NEGATIVE_HALF = new Quaternion(Axis.Y, Angle.V270_DEG);
	public static final Quaternion Z_HALF = new Quaternion(Axis.Z, Angle.V90_DEG);
	public static final Quaternion Z_OPPOSITE = new Quaternion(Axis.Z, Angle.V180_DEG);
	public static final Quaternion Z_NEGATIVE_HALF = new Quaternion(Axis.Z, Angle.V270_DEG);
	
	private static Vector4f factory(Vector3f axis, Angle angle)
	{
		float angleValue = angle.asFloat(AngleUnit.RADIANS) / 2;
		float s = Math.sin(angleValue);
		return new MutableVector4f(axis.x() * s, axis.y() * s, axis.z() * s, Math.cos(angleValue));
	}
	
	private static Vector4f factory(Vector3i axis, Angle angle)
	{
		float angleValue = angle.asFloat(AngleUnit.RADIANS) / 2;
		float s = Math.sin(angleValue);
		return new MutableVector4f(axis.x() * s, axis.y() * s, axis.z() * s, Math.cos(angleValue));
	}
	
	private static Vector4f factory(Vector3f axis, float angle)
	{
		float angleValue = angle / 2;
		float s = Math.sin(angleValue);
		return new MutableVector4f(axis.x() * s, axis.y() * s, axis.z() * s, Math.cos(angleValue));
	}
	
	private static Vector4f factory(Vector3i axis, float angle)
	{
		float angleValue = angle / 2;
		float s = Math.sin(angleValue);
		return new MutableVector4f(axis.x() * s, axis.y() * s, axis.z() * s, Math.cos(angleValue));
	}
	
	private static Vector4f factory(Angle xRotation, Angle yRotation, Angle zRotation)
	{
		float xRotationValue = xRotation.asFloat(AngleUnit.RADIANS);
		float yRotationValue = yRotation.asFloat(AngleUnit.RADIANS);
		float zRotationValue = zRotation.asFloat(AngleUnit.RADIANS);
		float xCos = Math.cos(xRotationValue);
		float xSin = Math.sin(xRotationValue);
		float yCos = Math.cos(yRotationValue);
		float ySin = Math.sin(yRotationValue);
		float zCos = Math.cos(zRotationValue);
		float zSin = Math.sin(zRotationValue);
		return new MutableVector4f(xSin * yCos * zCos - xCos * ySin * zSin, xCos * ySin * zCos + xSin * yCos * zSin, xCos * yCos * zSin - xSin * ySin * zCos, xCos * yCos * zCos + xSin * ySin * zSin);
	}
	
	private static Vector4f factory(float xRotation, float yRotation, float zRotation)
	{
		float xCos = Math.cos(xRotation);
		float xSin = Math.sin(xRotation);
		float yCos = Math.cos(yRotation);
		float ySin = Math.sin(yRotation);
		float zCos = Math.cos(zRotation);
		float zSin = Math.sin(zRotation);
		return new MutableVector4f(xSin * yCos * zCos - xCos * ySin * zSin, xCos * ySin * zCos + xSin * yCos * zSin, xCos * yCos * zSin - xSin * ySin * zCos, xCos * yCos * zCos + xSin * ySin * zSin);
	}
	
	public Quaternion(Vector3i axis, Angle angle)
	{
		super(factory(axis, angle));
	}
	
	public Quaternion(Vector3f axis, Angle angle)
	{
		super(factory(axis, angle));
	}
	
	public Quaternion(Vector3i axis, float angle)
	{
		super(factory(axis, angle));
	}
	
	public Quaternion(Vector3f axis, float angle)
	{
		super(factory(axis, angle));
	}
	
	public Quaternion(float xRotation, float yRotation, float zRotation)
	{
		super(factory(xRotation, yRotation, zRotation));
	}
	
	public Quaternion(Angle xRotation, Angle yRotation, Angle zRotation)
	{
		super(factory(xRotation, yRotation, zRotation));
	}
	
	public Quaternion(Vector4f quaternion)
	{
		super(new MutableVector4f(quaternion).unitary());
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
	public Vector3f rotate(Vector2f v)
	{
		float r2 = r() * r();
		float i2 = i() * i();
		float j2 = j() * j();
		float k2 = k() * k();
		return new MutableVector3f(v.x() * (r2 + i2 - j2 - k2) + 2 * v.y() * (i() * j() - r() * k()), v.y() * (i2 - j2 + k2 - r2) + 2 * v.x() * (x() * w() + y() * z()), 2 * (v.x() * (-x() * z() + y() * w()) + v.y() * (x() * y() + z() * w())));
	}
	
	@Override
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

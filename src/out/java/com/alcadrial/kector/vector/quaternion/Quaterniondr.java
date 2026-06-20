package com.alcadrial.kector.vector.quaternion;

import com.alcadrial.kector.Math;
import com.alcadrial.kector.annotation.Angle;
import com.alcadrial.kector.annotation.Direction;
import com.alcadrial.kector.annotation.Preserve;
import com.alcadrial.kector.annotation.Unitary;
import com.alcadrial.kector.vector.Vector4dr;
import com.alcadrial.kector.vector.Vector3f;
import com.alcadrial.kector.vector.Vector3d;
import com.alcadrial.kector.vector.Vector3ir;
import com.alcadrial.kector.vector.quaternion.readonly.ReadOnlyQuaterniond;

public interface Quaterniondr extends Vector4dr {

	static Quaterniondr of(double i, double j, double k, double r)
	{
		return new ReadOnlyQuaterniond(i, j, k, r);
	}
	static Quaterniondr of(Quaternionfr q)
	{
		return new ReadOnlyQuaterniond(q);
	}
	static Quaterniondr of(Quaterniondr q)
	{
		return new ReadOnlyQuaterniond(q);
	}
	static Quaterniondr ofAxis(@Direction Vector3ir axis, @Angle float angle)
	{
		double angleValue = angle / 2, s = Math.sin(angleValue);
		return new ReadOnlyQuaterniond(axis.x() * s, axis.y() * s, axis.z() * s, Math.cos(angleValue));
	}
	static Quaterniondr ofAngles(@Angle float xRotation, @Angle float yRotation, @Angle float zRotation)
	{
		double xCos = Math.cos(xRotation), xSin = Math.sin(xRotation);
		double yCos = Math.cos(yRotation), ySin = Math.sin(yRotation);
		double zCos = Math.cos(zRotation), zSin = Math.sin(zRotation);
		return new ReadOnlyQuaterniond(xSin * yCos * zCos - xCos * ySin * zSin, xCos * ySin * zCos + xSin * yCos * zSin, xCos * yCos * zSin - xSin * ySin * zCos, xCos * yCos * zCos + xSin * ySin * zSin);
	}

	@Preserve({Unitary.class})
	Vector3f rotate(Vector3f v);
	@Preserve({Unitary.class})
	Vector3d rotate(Vector3d v);

	double getI();
	double i();
	double getJ();
	double j();
	double getK();
	double k();
	double getR();
	double r();
}
package com.alcadrial.kector.vector.quaternion;

import com.alcadrial.kector.Math;
import com.alcadrial.kector.annotation.Angle;
import com.alcadrial.kector.annotation.Direction;
import com.alcadrial.kector.annotation.Preserve;
import com.alcadrial.kector.annotation.Unitary;
import com.alcadrial.kector.vector.Vector4fr;
import com.alcadrial.kector.vector.Vector3f;
import com.alcadrial.kector.vector.Vector3d;
import com.alcadrial.kector.vector.Vector3ir;
import com.alcadrial.kector.vector.quaternion.readonly.ReadOnlyQuaternionf;

public interface Quaternionfr extends Vector4fr {

	static Quaternionfr of(float i, float j, float k, float r)
	{
		return new ReadOnlyQuaternionf(i, j, k, r);
	}
	static Quaternionfr of(Quaternionfr q)
	{
		return new ReadOnlyQuaternionf(q);
	}
	static Quaternionfr of(Quaterniondr q)
	{
		return new ReadOnlyQuaternionf(q);
	}
	static Quaternionfr ofAxis(@Direction Vector3ir axis, @Angle float angle)
	{
		float angleValue = angle / 2, s = Math.sin(angleValue);
		return new ReadOnlyQuaternionf(axis.x() * s, axis.y() * s, axis.z() * s, Math.cos(angleValue));
	}
	static Quaternionfr ofAngles(@Angle float xRotation, @Angle float yRotation, @Angle float zRotation)
	{
		float xCos = Math.cos(xRotation), xSin = Math.sin(xRotation);
		float yCos = Math.cos(yRotation), ySin = Math.sin(yRotation);
		float zCos = Math.cos(zRotation), zSin = Math.sin(zRotation);
		return new ReadOnlyQuaternionf(xSin * yCos * zCos - xCos * ySin * zSin, xCos * ySin * zCos + xSin * yCos * zSin, xCos * yCos * zSin - xSin * ySin * zCos, xCos * yCos * zCos + xSin * ySin * zSin);
	}

	@Preserve({Unitary.class})
	Vector3f rotate(Vector3f v);
	@Preserve({Unitary.class})
	Vector3d rotate(Vector3d v);

	float getI();
	float i();
	float getJ();
	float j();
	float getK();
	float k();
	float getR();
	float r();
}
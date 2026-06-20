package com.alcadrial.kector.vector.quaternion;

import com.alcadrial.kector.Math;
import com.alcadrial.kector.annotation.Angle;
import com.alcadrial.kector.annotation.Direction;
import com.alcadrial.kector.vector.Vector4f;
import com.alcadrial.kector.vector.Vector2ir;
import com.alcadrial.kector.vector.Vector2lr;
import com.alcadrial.kector.vector.Vector2fr;
import com.alcadrial.kector.vector.Vector2dr;
import com.alcadrial.kector.vector.Vector3ir;
import com.alcadrial.kector.vector.Vector3lr;
import com.alcadrial.kector.vector.Vector3fr;
import com.alcadrial.kector.vector.Vector3dr;
import com.alcadrial.kector.vector.Vector4ir;
import com.alcadrial.kector.vector.Vector4lr;
import com.alcadrial.kector.vector.Vector4fr;
import com.alcadrial.kector.vector.Vector4dr;
import com.alcadrial.kector.vector.quaternion.mutable.MutableQuaternionf;

public interface Quaternionf extends Vector4f, Quaternionfr {

	static Quaternionf of(float i, float j, float k, float r)
	{
		return new MutableQuaternionf(i, j, k, r);
	}
	static Quaternionf of(Quaternionfr q)
	{
		return new MutableQuaternionf(q);
	}
	static Quaternionf of(Quaterniondr q)
	{
		return new MutableQuaternionf(q);
	}
	static Quaternionf ofAxis(@Direction Vector3ir axis, @Angle float angle)
	{
		float angleValue = angle / 2, s = Math.sin(angleValue);
		return new MutableQuaternionf(axis.x() * s, axis.y() * s, axis.z() * s, Math.cos(angleValue));
	}
	static Quaternionf ofAngles(@Angle float xRotation, @Angle float yRotation, @Angle float zRotation)
	{
		float xCos = Math.cos(xRotation), xSin = Math.sin(xRotation);
		float yCos = Math.cos(yRotation), ySin = Math.sin(yRotation);
		float zCos = Math.cos(zRotation), zSin = Math.sin(zRotation);
		return new MutableQuaternionf(xSin * yCos * zCos - xCos * ySin * zSin, xCos * ySin * zCos + xSin * yCos * zSin, xCos * yCos * zSin - xSin * ySin * zCos, xCos * yCos * zCos + xSin * ySin * zSin);
	}

	Quaternionf multiply(Quaternionfr q);
	Quaternionf multiply(Quaterniondr q);

	Quaternionf setI(float i);
	Quaternionf i(float i);
	Quaternionf setJ(float j);
	Quaternionf j(float j);
	Quaternionf setK(float k);
	Quaternionf k(float k);
	Quaternionf setR(float r);
	Quaternionf r(float r);
	@Override
	Quaternionf add(Vector4ir vector);
	@Override
	Quaternionf add(Vector4lr vector);
	@Override
	Quaternionf add(Vector4fr vector);
	@Override
	Quaternionf add(Vector4dr vector);
	@Override
	Quaternionf add(float x, float y, float z, float w);
	@Override
	Quaternionf add(int x, int y, int z, int w);
	@Override
	Quaternionf subtract(Vector4ir vector);
	@Override
	Quaternionf subtract(Vector4lr vector);
	@Override
	Quaternionf subtract(Vector4fr vector);
	@Override
	Quaternionf subtract(Vector4dr vector);
	@Override
	Quaternionf subtract(float x, float y, float z, float w);
	@Override
	Quaternionf subtract(int x, int y, int z, int w);
	@Override
	Quaternionf multiply(Vector4ir vector);
	@Override
	Quaternionf multiply(Vector4lr vector);
	@Override
	Quaternionf multiply(Vector4fr vector);
	@Override
	Quaternionf multiply(Vector4dr vector);
	@Override
	Quaternionf multiply(float x, float y, float z, float w);
	@Override
	Quaternionf multiply(int x, int y, int z, int w);
	@Override
	Quaternionf divide(Vector4ir vector);
	@Override
	Quaternionf divide(Vector4lr vector);
	@Override
	Quaternionf divide(Vector4fr vector);
	@Override
	Quaternionf divide(Vector4dr vector);
	@Override
	Quaternionf divide(float x, float y, float z, float w);
	@Override
	Quaternionf divide(int x, int y, int z, int w);
	@Override
	Quaternionf add(Vector3ir vector);
	@Override
	Quaternionf add(Vector3lr vector);
	@Override
	Quaternionf add(Vector3fr vector);
	@Override
	Quaternionf add(Vector3dr vector);
	@Override
	Quaternionf add(float x, float y, float z);
	@Override
	Quaternionf add(int x, int y, int z);
	@Override
	Quaternionf subtract(Vector3ir vector);
	@Override
	Quaternionf subtract(Vector3lr vector);
	@Override
	Quaternionf subtract(Vector3fr vector);
	@Override
	Quaternionf subtract(Vector3dr vector);
	@Override
	Quaternionf subtract(float x, float y, float z);
	@Override
	Quaternionf subtract(int x, int y, int z);
	@Override
	Quaternionf multiply(Vector3ir vector);
	@Override
	Quaternionf multiply(Vector3lr vector);
	@Override
	Quaternionf multiply(Vector3fr vector);
	@Override
	Quaternionf multiply(Vector3dr vector);
	@Override
	Quaternionf multiply(float x, float y, float z);
	@Override
	Quaternionf multiply(int x, int y, int z);
	@Override
	Quaternionf divide(Vector3ir vector);
	@Override
	Quaternionf divide(Vector3lr vector);
	@Override
	Quaternionf divide(Vector3fr vector);
	@Override
	Quaternionf divide(Vector3dr vector);
	@Override
	Quaternionf divide(float x, float y, float z);
	@Override
	Quaternionf divide(int x, int y, int z);
	@Override
	Quaternionf add(Vector2ir vector);
	@Override
	Quaternionf add(Vector2lr vector);
	@Override
	Quaternionf add(Vector2fr vector);
	@Override
	Quaternionf add(Vector2dr vector);
	@Override
	Quaternionf add(float x, float y);
	@Override
	Quaternionf add(int x, int y);
	@Override
	Quaternionf subtract(Vector2ir vector);
	@Override
	Quaternionf subtract(Vector2lr vector);
	@Override
	Quaternionf subtract(Vector2fr vector);
	@Override
	Quaternionf subtract(Vector2dr vector);
	@Override
	Quaternionf subtract(float x, float y);
	@Override
	Quaternionf subtract(int x, int y);
	@Override
	Quaternionf multiply(Vector2ir vector);
	@Override
	Quaternionf multiply(Vector2lr vector);
	@Override
	Quaternionf multiply(Vector2fr vector);
	@Override
	Quaternionf multiply(Vector2dr vector);
	@Override
	Quaternionf multiply(float x, float y);
	@Override
	Quaternionf multiply(int x, int y);
	@Override
	Quaternionf divide(Vector2ir vector);
	@Override
	Quaternionf divide(Vector2lr vector);
	@Override
	Quaternionf divide(Vector2fr vector);
	@Override
	Quaternionf divide(Vector2dr vector);
	@Override
	Quaternionf divide(float x, float y);
	@Override
	Quaternionf divide(int x, int y);
	@Override
	Quaternionf addAll(int value);
	@Override
	Quaternionf addAll(float value);
	@Override
	Quaternionf subtractAll(int value);
	@Override
	Quaternionf subtractAll(float value);
	@Override
	Quaternionf multiplyAll(int value);
	@Override
	Quaternionf multiplyAll(float value);
	@Override
	Quaternionf divideAll(int value);
	@Override
	Quaternionf divideAll(float value);

	@Override
	Quaternionf opposite();
	@Override
	Quaternionf absolute();
	@Override
	Quaternionf conjugate();

	@Override
	Quaternionf setX(float x);
	@Override
	Quaternionf x(float x);
	@Override
	Quaternionf setY(float y);
	@Override
	Quaternionf y(float y);
	@Override
	Quaternionf setZ(float z);
	@Override
	Quaternionf z(float z);
	@Override
	Quaternionf setW(float w);
	@Override
	Quaternionf w(float w);

	@Override
	Quaternionf setAll(float x, float y, float z, float w);
	@Override
	Quaternionf setAll(Vector4ir vector);
	@Override
	Quaternionf setAll(Vector4lr vector);
	@Override
	Quaternionf setAll(Vector4fr vector);
	@Override
	Quaternionf setAll(Vector4dr vector);

}
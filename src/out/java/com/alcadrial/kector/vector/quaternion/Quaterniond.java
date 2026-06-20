package com.alcadrial.kector.vector.quaternion;

import com.alcadrial.kector.Math;
import com.alcadrial.kector.annotation.Angle;
import com.alcadrial.kector.annotation.Direction;
import com.alcadrial.kector.vector.Vector4d;
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
import com.alcadrial.kector.vector.quaternion.mutable.MutableQuaterniond;

public interface Quaterniond extends Vector4d, Quaterniondr {

	static Quaterniond of(double i, double j, double k, double r)
	{
		return new MutableQuaterniond(i, j, k, r);
	}
	static Quaterniond of(Quaternionfr q)
	{
		return new MutableQuaterniond(q);
	}
	static Quaterniond of(Quaterniondr q)
	{
		return new MutableQuaterniond(q);
	}
	static Quaterniond ofAxis(@Direction Vector3ir axis, @Angle float angle)
	{
		double angleValue = angle / 2, s = Math.sin(angleValue);
		return new MutableQuaterniond(axis.x() * s, axis.y() * s, axis.z() * s, Math.cos(angleValue));
	}
	static Quaterniond ofAngles(@Angle float xRotation, @Angle float yRotation, @Angle float zRotation)
	{
		double xCos = Math.cos(xRotation), xSin = Math.sin(xRotation);
		double yCos = Math.cos(yRotation), ySin = Math.sin(yRotation);
		double zCos = Math.cos(zRotation), zSin = Math.sin(zRotation);
		return new MutableQuaterniond(xSin * yCos * zCos - xCos * ySin * zSin, xCos * ySin * zCos + xSin * yCos * zSin, xCos * yCos * zSin - xSin * ySin * zCos, xCos * yCos * zCos + xSin * ySin * zSin);
	}

	Quaterniond multiply(Quaternionfr q);
	Quaterniond multiply(Quaterniondr q);

	Quaterniond setI(double i);
	Quaterniond i(double i);
	Quaterniond setJ(double j);
	Quaterniond j(double j);
	Quaterniond setK(double k);
	Quaterniond k(double k);
	Quaterniond setR(double r);
	Quaterniond r(double r);
	@Override
	Quaterniond add(Vector4ir vector);
	@Override
	Quaterniond add(Vector4lr vector);
	@Override
	Quaterniond add(Vector4fr vector);
	@Override
	Quaterniond add(Vector4dr vector);
	@Override
	Quaterniond add(double x, double y, double z, double w);
	@Override
	Quaterniond add(long x, long y, long z, long w);
	@Override
	Quaterniond subtract(Vector4ir vector);
	@Override
	Quaterniond subtract(Vector4lr vector);
	@Override
	Quaterniond subtract(Vector4fr vector);
	@Override
	Quaterniond subtract(Vector4dr vector);
	@Override
	Quaterniond subtract(double x, double y, double z, double w);
	@Override
	Quaterniond subtract(long x, long y, long z, long w);
	@Override
	Quaterniond multiply(Vector4ir vector);
	@Override
	Quaterniond multiply(Vector4lr vector);
	@Override
	Quaterniond multiply(Vector4fr vector);
	@Override
	Quaterniond multiply(Vector4dr vector);
	@Override
	Quaterniond multiply(double x, double y, double z, double w);
	@Override
	Quaterniond multiply(long x, long y, long z, long w);
	@Override
	Quaterniond divide(Vector4ir vector);
	@Override
	Quaterniond divide(Vector4lr vector);
	@Override
	Quaterniond divide(Vector4fr vector);
	@Override
	Quaterniond divide(Vector4dr vector);
	@Override
	Quaterniond divide(double x, double y, double z, double w);
	@Override
	Quaterniond divide(long x, long y, long z, long w);
	@Override
	Quaterniond add(Vector3ir vector);
	@Override
	Quaterniond add(Vector3lr vector);
	@Override
	Quaterniond add(Vector3fr vector);
	@Override
	Quaterniond add(Vector3dr vector);
	@Override
	Quaterniond add(double x, double y, double z);
	@Override
	Quaterniond add(long x, long y, long z);
	@Override
	Quaterniond subtract(Vector3ir vector);
	@Override
	Quaterniond subtract(Vector3lr vector);
	@Override
	Quaterniond subtract(Vector3fr vector);
	@Override
	Quaterniond subtract(Vector3dr vector);
	@Override
	Quaterniond subtract(double x, double y, double z);
	@Override
	Quaterniond subtract(long x, long y, long z);
	@Override
	Quaterniond multiply(Vector3ir vector);
	@Override
	Quaterniond multiply(Vector3lr vector);
	@Override
	Quaterniond multiply(Vector3fr vector);
	@Override
	Quaterniond multiply(Vector3dr vector);
	@Override
	Quaterniond multiply(double x, double y, double z);
	@Override
	Quaterniond multiply(long x, long y, long z);
	@Override
	Quaterniond divide(Vector3ir vector);
	@Override
	Quaterniond divide(Vector3lr vector);
	@Override
	Quaterniond divide(Vector3fr vector);
	@Override
	Quaterniond divide(Vector3dr vector);
	@Override
	Quaterniond divide(double x, double y, double z);
	@Override
	Quaterniond divide(long x, long y, long z);
	@Override
	Quaterniond add(Vector2ir vector);
	@Override
	Quaterniond add(Vector2lr vector);
	@Override
	Quaterniond add(Vector2fr vector);
	@Override
	Quaterniond add(Vector2dr vector);
	@Override
	Quaterniond add(double x, double y);
	@Override
	Quaterniond add(long x, long y);
	@Override
	Quaterniond subtract(Vector2ir vector);
	@Override
	Quaterniond subtract(Vector2lr vector);
	@Override
	Quaterniond subtract(Vector2fr vector);
	@Override
	Quaterniond subtract(Vector2dr vector);
	@Override
	Quaterniond subtract(double x, double y);
	@Override
	Quaterniond subtract(long x, long y);
	@Override
	Quaterniond multiply(Vector2ir vector);
	@Override
	Quaterniond multiply(Vector2lr vector);
	@Override
	Quaterniond multiply(Vector2fr vector);
	@Override
	Quaterniond multiply(Vector2dr vector);
	@Override
	Quaterniond multiply(double x, double y);
	@Override
	Quaterniond multiply(long x, long y);
	@Override
	Quaterniond divide(Vector2ir vector);
	@Override
	Quaterniond divide(Vector2lr vector);
	@Override
	Quaterniond divide(Vector2fr vector);
	@Override
	Quaterniond divide(Vector2dr vector);
	@Override
	Quaterniond divide(double x, double y);
	@Override
	Quaterniond divide(long x, long y);
	@Override
	Quaterniond addAll(long value);
	@Override
	Quaterniond addAll(double value);
	@Override
	Quaterniond subtractAll(long value);
	@Override
	Quaterniond subtractAll(double value);
	@Override
	Quaterniond multiplyAll(long value);
	@Override
	Quaterniond multiplyAll(double value);
	@Override
	Quaterniond divideAll(long value);
	@Override
	Quaterniond divideAll(double value);

	@Override
	Quaterniond opposite();
	@Override
	Quaterniond absolute();
	@Override
	Quaterniond conjugate();

	@Override
	Quaterniond setX(double x);
	@Override
	Quaterniond x(double x);
	@Override
	Quaterniond setY(double y);
	@Override
	Quaterniond y(double y);
	@Override
	Quaterniond setZ(double z);
	@Override
	Quaterniond z(double z);
	@Override
	Quaterniond setW(double w);
	@Override
	Quaterniond w(double w);

	@Override
	Quaterniond setAll(double x, double y, double z, double w);
	@Override
	Quaterniond setAll(Vector4ir vector);
	@Override
	Quaterniond setAll(Vector4lr vector);
	@Override
	Quaterniond setAll(Vector4fr vector);
	@Override
	Quaterniond setAll(Vector4dr vector);

}
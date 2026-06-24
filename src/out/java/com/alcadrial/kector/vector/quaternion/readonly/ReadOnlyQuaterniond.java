package com.alcadrial.kector.vector.quaternion.readonly;

import com.alcadrial.kector.vector.readonly.ReadOnlyVector4d;
import com.alcadrial.kector.VectorMath;
import com.alcadrial.kector.vector.Vector3f;
import com.alcadrial.kector.vector.Vector3d;
import com.alcadrial.kector.vector.quaternion.Quaternionfr;
import com.alcadrial.kector.vector.quaternion.Quaterniondr;

public class ReadOnlyQuaterniond extends ReadOnlyVector4d implements Quaterniondr {

	public ReadOnlyQuaterniond(double i, double j, double k, double r)
	{
		super(i, j, k, r);
	}
	public ReadOnlyQuaterniond(Quaternionfr q)
	{
		this((double) q.x(), (double) q.y(), (double) q.z(), (double) q.w());
	}
	public ReadOnlyQuaterniond(Quaterniondr q)
	{
		this((double) q.x(), (double) q.y(), (double) q.z(), (double) q.w());
	}

	public Vector3f rotate(Vector3f v)
	{
		return VectorMath.rotate(this, v);
	}
	public Vector3d rotate(Vector3d v)
	{
		return VectorMath.rotate(this, v);
	}

	public double getI()
	{
		return i();
	}
	public double i()
	{
		return x();
	}
	public double getJ()
	{
		return j();
	}
	public double j()
	{
		return y();
	}
	public double getK()
	{
		return k();
	}
	public double k()
	{
		return z();
	}
	public double getR()
	{
		return r();
	}
	public double r()
	{
		return w();
	}
	public String toString()
	{
		StringBuilder ss = new StringBuilder(25);
		return ss.append("Quaterniondr{").append(i()).append("i + ").append(j()).append("j + ").append(k()).append("k + ").append(r()).append("}").toString();
	}
}
package com.alcadrial.kector.vector.quaternion.readonly;

import com.alcadrial.kector.vector.readonly.ReadOnlyVector4f;
import com.alcadrial.kector.VectorMath;
import com.alcadrial.kector.vector.Vector3f;
import com.alcadrial.kector.vector.Vector3d;
import com.alcadrial.kector.vector.quaternion.Quaternionfr;
import com.alcadrial.kector.vector.quaternion.Quaterniondr;

public class ReadOnlyQuaternionf extends ReadOnlyVector4f implements Quaternionfr {

	public ReadOnlyQuaternionf(float i, float j, float k, float r)
	{
		super(i, j, k, r);
	}
	public ReadOnlyQuaternionf(Quaternionfr q)
	{
		this((float) q.x(), (float) q.y(), (float) q.z(), (float) q.w());
	}
	public ReadOnlyQuaternionf(Quaterniondr q)
	{
		this((float) q.x(), (float) q.y(), (float) q.z(), (float) q.w());
	}

	public Vector3f rotate(Vector3f v)
	{
		return VectorMath.rotate(this, v);
	}
	public Vector3d rotate(Vector3d v)
	{
		return VectorMath.rotate(this, v);
	}

	public float getI()
	{
		return i();
	}
	public float i()
	{
		return x();
	}
	public float getJ()
	{
		return j();
	}
	public float j()
	{
		return y();
	}
	public float getK()
	{
		return k();
	}
	public float k()
	{
		return z();
	}
	public float getR()
	{
		return r();
	}
	public float r()
	{
		return w();
	}
}
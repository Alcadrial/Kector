package com.alcadrial.kector.vector.quaternion.mutable;

import com.alcadrial.kector.VectorMath;
import com.alcadrial.kector.vector.mutable.MutableVector4f;
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
import com.alcadrial.kector.vector.Vector3f;
import com.alcadrial.kector.vector.Vector3d;
import com.alcadrial.kector.vector.quaternion.Quaternionf;
import com.alcadrial.kector.vector.quaternion.Quaternionfr;
import com.alcadrial.kector.vector.quaternion.Quaterniondr;

public class MutableQuaternionf extends MutableVector4f implements Quaternionf {

	public MutableQuaternionf(float i, float j, float k, float r)
	{
		super(i, j, k, r);
	}
	public MutableQuaternionf(Quaternionfr q)
	{
		this((float) q.x(), (float) q.y(), (float) q.z(), (float) q.w());
	}
	public MutableQuaternionf(Quaterniondr q)
	{
		this((float) q.x(), (float) q.y(), (float) q.z(), (float) q.w());
	}

	public Quaternionf multiply(Quaternionfr q)
	{
		float i0 = i(), j0 = j(), k0 = k(), r0 = r();
		float i1 = q.i(), j1 = q.j(), k1 = q.k(), r1 = q.r();
		i(r0 * i1 + i0 * r1 + j0 * k1 - k0 * j1);
		j(r0 * j1 + j0 * r1 - i0 * k1 + k0 * i1);
		k(r0 * k1 + k0 * r1 + i0 * j1 - j0 * i1);
		r(r0 * r1 - i0 * i1 - j0 * j1 - k0 * k1);
		return this;
	}
	public Quaternionf multiply(Quaterniondr q)
	{
		float i0 = i(), j0 = j(), k0 = k(), r0 = r();
		double i1 = q.i(), j1 = q.j(), k1 = q.k(), r1 = q.r();
		i((float) (r0 * i1 + i0 * r1 + j0 * k1 - k0 * j1));
		j((float) (r0 * j1 + j0 * r1 - i0 * k1 + k0 * i1));
		k((float) (r0 * k1 + k0 * r1 + i0 * j1 - j0 * i1));
		r((float) (r0 * r1 - i0 * i1 - j0 * j1 - k0 * k1));
		return this;
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

	public Quaternionf setI(float i)
	{
		return i(i);
	}
	public Quaternionf i(float i)
	{
		return x(i);
	}
	public Quaternionf setJ(float j)
	{
		return j(j);
	}
	public Quaternionf j(float j)
	{
		return y(j);
	}
	public Quaternionf setK(float k)
	{
		return k(k);
	}
	public Quaternionf k(float k)
	{
		return z(k);
	}
	public Quaternionf setR(float r)
	{
		return r(r);
	}
	public Quaternionf r(float r)
	{
		return w(r);
	}

	@Override
	public Quaternionf add(Vector4ir vector)
	{
		return (Quaternionf) super.add(vector);
	}
	@Override
	public Quaternionf add(Vector4lr vector)
	{
		return (Quaternionf) super.add(vector);
	}
	@Override
	public Quaternionf add(Vector4fr vector)
	{
		return (Quaternionf) super.add(vector);
	}
	@Override
	public Quaternionf add(Vector4dr vector)
	{
		return (Quaternionf) super.add(vector);
	}
	@Override
	public Quaternionf add(float x, float y, float z, float w)
	{
		return (Quaternionf) super.add(x, y, z, w);
	}
	@Override
	public Quaternionf add(int x, int y, int z, int w)
	{
		return (Quaternionf) super.add(x, y, z, w);
	}
	@Override
	public Quaternionf subtract(Vector4ir vector)
	{
		return (Quaternionf) super.subtract(vector);
	}
	@Override
	public Quaternionf subtract(Vector4lr vector)
	{
		return (Quaternionf) super.subtract(vector);
	}
	@Override
	public Quaternionf subtract(Vector4fr vector)
	{
		return (Quaternionf) super.subtract(vector);
	}
	@Override
	public Quaternionf subtract(Vector4dr vector)
	{
		return (Quaternionf) super.subtract(vector);
	}
	@Override
	public Quaternionf subtract(float x, float y, float z, float w)
	{
		return (Quaternionf) super.subtract(x, y, z, w);
	}
	@Override
	public Quaternionf subtract(int x, int y, int z, int w)
	{
		return (Quaternionf) super.subtract(x, y, z, w);
	}
	@Override
	public Quaternionf multiply(Vector4ir vector)
	{
		return (Quaternionf) super.multiply(vector);
	}
	@Override
	public Quaternionf multiply(Vector4lr vector)
	{
		return (Quaternionf) super.multiply(vector);
	}
	@Override
	public Quaternionf multiply(Vector4fr vector)
	{
		return (Quaternionf) super.multiply(vector);
	}
	@Override
	public Quaternionf multiply(Vector4dr vector)
	{
		return (Quaternionf) super.multiply(vector);
	}
	@Override
	public Quaternionf multiply(float x, float y, float z, float w)
	{
		return (Quaternionf) super.multiply(x, y, z, w);
	}
	@Override
	public Quaternionf multiply(int x, int y, int z, int w)
	{
		return (Quaternionf) super.multiply(x, y, z, w);
	}
	@Override
	public Quaternionf divide(Vector4ir vector)
	{
		return (Quaternionf) super.divide(vector);
	}
	@Override
	public Quaternionf divide(Vector4lr vector)
	{
		return (Quaternionf) super.divide(vector);
	}
	@Override
	public Quaternionf divide(Vector4fr vector)
	{
		return (Quaternionf) super.divide(vector);
	}
	@Override
	public Quaternionf divide(Vector4dr vector)
	{
		return (Quaternionf) super.divide(vector);
	}
	@Override
	public Quaternionf divide(float x, float y, float z, float w)
	{
		return (Quaternionf) super.divide(x, y, z, w);
	}
	@Override
	public Quaternionf divide(int x, int y, int z, int w)
	{
		return (Quaternionf) super.divide(x, y, z, w);
	}
	@Override
	public Quaternionf add(Vector3ir vector)
	{
		return (Quaternionf) super.add(vector);
	}
	@Override
	public Quaternionf add(Vector3lr vector)
	{
		return (Quaternionf) super.add(vector);
	}
	@Override
	public Quaternionf add(Vector3fr vector)
	{
		return (Quaternionf) super.add(vector);
	}
	@Override
	public Quaternionf add(Vector3dr vector)
	{
		return (Quaternionf) super.add(vector);
	}
	@Override
	public Quaternionf add(float x, float y, float z)
	{
		return (Quaternionf) super.add(x, y, z);
	}
	@Override
	public Quaternionf add(int x, int y, int z)
	{
		return (Quaternionf) super.add(x, y, z);
	}
	@Override
	public Quaternionf subtract(Vector3ir vector)
	{
		return (Quaternionf) super.subtract(vector);
	}
	@Override
	public Quaternionf subtract(Vector3lr vector)
	{
		return (Quaternionf) super.subtract(vector);
	}
	@Override
	public Quaternionf subtract(Vector3fr vector)
	{
		return (Quaternionf) super.subtract(vector);
	}
	@Override
	public Quaternionf subtract(Vector3dr vector)
	{
		return (Quaternionf) super.subtract(vector);
	}
	@Override
	public Quaternionf subtract(float x, float y, float z)
	{
		return (Quaternionf) super.subtract(x, y, z);
	}
	@Override
	public Quaternionf subtract(int x, int y, int z)
	{
		return (Quaternionf) super.subtract(x, y, z);
	}
	@Override
	public Quaternionf multiply(Vector3ir vector)
	{
		return (Quaternionf) super.multiply(vector);
	}
	@Override
	public Quaternionf multiply(Vector3lr vector)
	{
		return (Quaternionf) super.multiply(vector);
	}
	@Override
	public Quaternionf multiply(Vector3fr vector)
	{
		return (Quaternionf) super.multiply(vector);
	}
	@Override
	public Quaternionf multiply(Vector3dr vector)
	{
		return (Quaternionf) super.multiply(vector);
	}
	@Override
	public Quaternionf multiply(float x, float y, float z)
	{
		return (Quaternionf) super.multiply(x, y, z);
	}
	@Override
	public Quaternionf multiply(int x, int y, int z)
	{
		return (Quaternionf) super.multiply(x, y, z);
	}
	@Override
	public Quaternionf divide(Vector3ir vector)
	{
		return (Quaternionf) super.divide(vector);
	}
	@Override
	public Quaternionf divide(Vector3lr vector)
	{
		return (Quaternionf) super.divide(vector);
	}
	@Override
	public Quaternionf divide(Vector3fr vector)
	{
		return (Quaternionf) super.divide(vector);
	}
	@Override
	public Quaternionf divide(Vector3dr vector)
	{
		return (Quaternionf) super.divide(vector);
	}
	@Override
	public Quaternionf divide(float x, float y, float z)
	{
		return (Quaternionf) super.divide(x, y, z);
	}
	@Override
	public Quaternionf divide(int x, int y, int z)
	{
		return (Quaternionf) super.divide(x, y, z);
	}
	@Override
	public Quaternionf add(Vector2ir vector)
	{
		return (Quaternionf) super.add(vector);
	}
	@Override
	public Quaternionf add(Vector2lr vector)
	{
		return (Quaternionf) super.add(vector);
	}
	@Override
	public Quaternionf add(Vector2fr vector)
	{
		return (Quaternionf) super.add(vector);
	}
	@Override
	public Quaternionf add(Vector2dr vector)
	{
		return (Quaternionf) super.add(vector);
	}
	@Override
	public Quaternionf add(float x, float y)
	{
		return (Quaternionf) super.add(x, y);
	}
	@Override
	public Quaternionf add(int x, int y)
	{
		return (Quaternionf) super.add(x, y);
	}
	@Override
	public Quaternionf subtract(Vector2ir vector)
	{
		return (Quaternionf) super.subtract(vector);
	}
	@Override
	public Quaternionf subtract(Vector2lr vector)
	{
		return (Quaternionf) super.subtract(vector);
	}
	@Override
	public Quaternionf subtract(Vector2fr vector)
	{
		return (Quaternionf) super.subtract(vector);
	}
	@Override
	public Quaternionf subtract(Vector2dr vector)
	{
		return (Quaternionf) super.subtract(vector);
	}
	@Override
	public Quaternionf subtract(float x, float y)
	{
		return (Quaternionf) super.subtract(x, y);
	}
	@Override
	public Quaternionf subtract(int x, int y)
	{
		return (Quaternionf) super.subtract(x, y);
	}
	@Override
	public Quaternionf multiply(Vector2ir vector)
	{
		return (Quaternionf) super.multiply(vector);
	}
	@Override
	public Quaternionf multiply(Vector2lr vector)
	{
		return (Quaternionf) super.multiply(vector);
	}
	@Override
	public Quaternionf multiply(Vector2fr vector)
	{
		return (Quaternionf) super.multiply(vector);
	}
	@Override
	public Quaternionf multiply(Vector2dr vector)
	{
		return (Quaternionf) super.multiply(vector);
	}
	@Override
	public Quaternionf multiply(float x, float y)
	{
		return (Quaternionf) super.multiply(x, y);
	}
	@Override
	public Quaternionf multiply(int x, int y)
	{
		return (Quaternionf) super.multiply(x, y);
	}
	@Override
	public Quaternionf divide(Vector2ir vector)
	{
		return (Quaternionf) super.divide(vector);
	}
	@Override
	public Quaternionf divide(Vector2lr vector)
	{
		return (Quaternionf) super.divide(vector);
	}
	@Override
	public Quaternionf divide(Vector2fr vector)
	{
		return (Quaternionf) super.divide(vector);
	}
	@Override
	public Quaternionf divide(Vector2dr vector)
	{
		return (Quaternionf) super.divide(vector);
	}
	@Override
	public Quaternionf divide(float x, float y)
	{
		return (Quaternionf) super.divide(x, y);
	}
	@Override
	public Quaternionf divide(int x, int y)
	{
		return (Quaternionf) super.divide(x, y);
	}
	@Override
	public Quaternionf addAll(int value)
	{
		return (Quaternionf) super.addAll(value);
	}
	@Override
	public Quaternionf addAll(float value)
	{
		return (Quaternionf) super.addAll(value);
	}
	@Override
	public Quaternionf subtractAll(int value)
	{
		return (Quaternionf) super.subtractAll(value);
	}
	@Override
	public Quaternionf subtractAll(float value)
	{
		return (Quaternionf) super.subtractAll(value);
	}
	@Override
	public Quaternionf multiplyAll(int value)
	{
		return (Quaternionf) super.multiplyAll(value);
	}
	@Override
	public Quaternionf multiplyAll(float value)
	{
		return (Quaternionf) super.multiplyAll(value);
	}
	@Override
	public Quaternionf divideAll(int value)
	{
		return (Quaternionf) super.divideAll(value);
	}
	@Override
	public Quaternionf divideAll(float value)
	{
		return (Quaternionf) super.divideAll(value);
	}

	@Override
	public Quaternionf opposite()
	{
		return (Quaternionf) super.opposite();
	}
	@Override
	public Quaternionf absolute()
	{
		return (Quaternionf) super.absolute();
	}
	@Override
	public Quaternionf conjugate()
	{
		return (Quaternionf) super.conjugate();
	}

	@Override
	public Quaternionf setX(float x)
	{
		return (Quaternionf) super.setX(x);
	}
	@Override
	public Quaternionf x(float x)
	{
		return (Quaternionf) super.x(x);
	}
	@Override
	public Quaternionf setY(float y)
	{
		return (Quaternionf) super.setY(y);
	}
	@Override
	public Quaternionf y(float y)
	{
		return (Quaternionf) super.y(y);
	}
	@Override
	public Quaternionf setZ(float z)
	{
		return (Quaternionf) super.setZ(z);
	}
	@Override
	public Quaternionf z(float z)
	{
		return (Quaternionf) super.z(z);
	}
	@Override
	public Quaternionf setW(float w)
	{
		return (Quaternionf) super.setW(w);
	}
	@Override
	public Quaternionf w(float w)
	{
		return (Quaternionf) super.w(w);
	}

	@Override
	public Quaternionf setAll(float x, float y, float z, float w)
	{
		return (Quaternionf) super.setAll(x, y, z, w);
	}
	@Override
	public Quaternionf setAll(Vector4ir vector)
	{
		return (Quaternionf) super.setAll(vector);
	}
	@Override
	public Quaternionf setAll(Vector4lr vector)
	{
		return (Quaternionf) super.setAll(vector);
	}
	@Override
	public Quaternionf setAll(Vector4fr vector)
	{
		return (Quaternionf) super.setAll(vector);
	}
	@Override
	public Quaternionf setAll(Vector4dr vector)
	{
		return (Quaternionf) super.setAll(vector);
	}

}
package com.alcadrial.kector.vector.quaternion.mutable;

import com.alcadrial.kector.VectorMath;
import com.alcadrial.kector.vector.mutable.MutableVector4d;
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
import com.alcadrial.kector.vector.quaternion.Quaterniond;
import com.alcadrial.kector.vector.quaternion.Quaternionfr;
import com.alcadrial.kector.vector.quaternion.Quaterniondr;

public class MutableQuaterniond extends MutableVector4d implements Quaterniond {

	public MutableQuaterniond(double i, double j, double k, double r)
	{
		super(i, j, k, r);
	}
	public MutableQuaterniond(Quaternionfr q)
	{
		this((double) q.x(), (double) q.y(), (double) q.z(), (double) q.w());
	}
	public MutableQuaterniond(Quaterniondr q)
	{
		this((double) q.x(), (double) q.y(), (double) q.z(), (double) q.w());
	}

	public Quaterniond multiply(Quaternionfr q)
	{
		double i0 = i(), j0 = j(), k0 = k(), r0 = r();
		float i1 = q.i(), j1 = q.j(), k1 = q.k(), r1 = q.r();
		i((double) (r0 * i1 + i0 * r1 + j0 * k1 - k0 * j1));
		j((double) (r0 * j1 + j0 * r1 - i0 * k1 + k0 * i1));
		k((double) (r0 * k1 + k0 * r1 + i0 * j1 - j0 * i1));
		r((double) (r0 * r1 - i0 * i1 - j0 * j1 - k0 * k1));
		return this;
	}
	public Quaterniond multiply(Quaterniondr q)
	{
		double i0 = i(), j0 = j(), k0 = k(), r0 = r();
		double i1 = q.i(), j1 = q.j(), k1 = q.k(), r1 = q.r();
		i(r0 * i1 + i0 * r1 + j0 * k1 - k0 * j1);
		j(r0 * j1 + j0 * r1 - i0 * k1 + k0 * i1);
		k(r0 * k1 + k0 * r1 + i0 * j1 - j0 * i1);
		r(r0 * r1 - i0 * i1 - j0 * j1 - k0 * k1);
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

	public Quaterniond setI(double i)
	{
		return i(i);
	}
	public Quaterniond i(double i)
	{
		return x(i);
	}
	public Quaterniond setJ(double j)
	{
		return j(j);
	}
	public Quaterniond j(double j)
	{
		return y(j);
	}
	public Quaterniond setK(double k)
	{
		return k(k);
	}
	public Quaterniond k(double k)
	{
		return z(k);
	}
	public Quaterniond setR(double r)
	{
		return r(r);
	}
	public Quaterniond r(double r)
	{
		return w(r);
	}

	@Override
	public Quaterniond add(Vector4ir vector)
	{
		return (Quaterniond) super.add(vector);
	}
	@Override
	public Quaterniond add(Vector4lr vector)
	{
		return (Quaterniond) super.add(vector);
	}
	@Override
	public Quaterniond add(Vector4fr vector)
	{
		return (Quaterniond) super.add(vector);
	}
	@Override
	public Quaterniond add(Vector4dr vector)
	{
		return (Quaterniond) super.add(vector);
	}
	@Override
	public Quaterniond add(double x, double y, double z, double w)
	{
		return (Quaterniond) super.add(x, y, z, w);
	}
	@Override
	public Quaterniond add(long x, long y, long z, long w)
	{
		return (Quaterniond) super.add(x, y, z, w);
	}
	@Override
	public Quaterniond subtract(Vector4ir vector)
	{
		return (Quaterniond) super.subtract(vector);
	}
	@Override
	public Quaterniond subtract(Vector4lr vector)
	{
		return (Quaterniond) super.subtract(vector);
	}
	@Override
	public Quaterniond subtract(Vector4fr vector)
	{
		return (Quaterniond) super.subtract(vector);
	}
	@Override
	public Quaterniond subtract(Vector4dr vector)
	{
		return (Quaterniond) super.subtract(vector);
	}
	@Override
	public Quaterniond subtract(double x, double y, double z, double w)
	{
		return (Quaterniond) super.subtract(x, y, z, w);
	}
	@Override
	public Quaterniond subtract(long x, long y, long z, long w)
	{
		return (Quaterniond) super.subtract(x, y, z, w);
	}
	@Override
	public Quaterniond multiply(Vector4ir vector)
	{
		return (Quaterniond) super.multiply(vector);
	}
	@Override
	public Quaterniond multiply(Vector4lr vector)
	{
		return (Quaterniond) super.multiply(vector);
	}
	@Override
	public Quaterniond multiply(Vector4fr vector)
	{
		return (Quaterniond) super.multiply(vector);
	}
	@Override
	public Quaterniond multiply(Vector4dr vector)
	{
		return (Quaterniond) super.multiply(vector);
	}
	@Override
	public Quaterniond multiply(double x, double y, double z, double w)
	{
		return (Quaterniond) super.multiply(x, y, z, w);
	}
	@Override
	public Quaterniond multiply(long x, long y, long z, long w)
	{
		return (Quaterniond) super.multiply(x, y, z, w);
	}
	@Override
	public Quaterniond divide(Vector4ir vector)
	{
		return (Quaterniond) super.divide(vector);
	}
	@Override
	public Quaterniond divide(Vector4lr vector)
	{
		return (Quaterniond) super.divide(vector);
	}
	@Override
	public Quaterniond divide(Vector4fr vector)
	{
		return (Quaterniond) super.divide(vector);
	}
	@Override
	public Quaterniond divide(Vector4dr vector)
	{
		return (Quaterniond) super.divide(vector);
	}
	@Override
	public Quaterniond divide(double x, double y, double z, double w)
	{
		return (Quaterniond) super.divide(x, y, z, w);
	}
	@Override
	public Quaterniond divide(long x, long y, long z, long w)
	{
		return (Quaterniond) super.divide(x, y, z, w);
	}
	@Override
	public Quaterniond add(Vector3ir vector)
	{
		return (Quaterniond) super.add(vector);
	}
	@Override
	public Quaterniond add(Vector3lr vector)
	{
		return (Quaterniond) super.add(vector);
	}
	@Override
	public Quaterniond add(Vector3fr vector)
	{
		return (Quaterniond) super.add(vector);
	}
	@Override
	public Quaterniond add(Vector3dr vector)
	{
		return (Quaterniond) super.add(vector);
	}
	@Override
	public Quaterniond add(double x, double y, double z)
	{
		return (Quaterniond) super.add(x, y, z);
	}
	@Override
	public Quaterniond add(long x, long y, long z)
	{
		return (Quaterniond) super.add(x, y, z);
	}
	@Override
	public Quaterniond subtract(Vector3ir vector)
	{
		return (Quaterniond) super.subtract(vector);
	}
	@Override
	public Quaterniond subtract(Vector3lr vector)
	{
		return (Quaterniond) super.subtract(vector);
	}
	@Override
	public Quaterniond subtract(Vector3fr vector)
	{
		return (Quaterniond) super.subtract(vector);
	}
	@Override
	public Quaterniond subtract(Vector3dr vector)
	{
		return (Quaterniond) super.subtract(vector);
	}
	@Override
	public Quaterniond subtract(double x, double y, double z)
	{
		return (Quaterniond) super.subtract(x, y, z);
	}
	@Override
	public Quaterniond subtract(long x, long y, long z)
	{
		return (Quaterniond) super.subtract(x, y, z);
	}
	@Override
	public Quaterniond multiply(Vector3ir vector)
	{
		return (Quaterniond) super.multiply(vector);
	}
	@Override
	public Quaterniond multiply(Vector3lr vector)
	{
		return (Quaterniond) super.multiply(vector);
	}
	@Override
	public Quaterniond multiply(Vector3fr vector)
	{
		return (Quaterniond) super.multiply(vector);
	}
	@Override
	public Quaterniond multiply(Vector3dr vector)
	{
		return (Quaterniond) super.multiply(vector);
	}
	@Override
	public Quaterniond multiply(double x, double y, double z)
	{
		return (Quaterniond) super.multiply(x, y, z);
	}
	@Override
	public Quaterniond multiply(long x, long y, long z)
	{
		return (Quaterniond) super.multiply(x, y, z);
	}
	@Override
	public Quaterniond divide(Vector3ir vector)
	{
		return (Quaterniond) super.divide(vector);
	}
	@Override
	public Quaterniond divide(Vector3lr vector)
	{
		return (Quaterniond) super.divide(vector);
	}
	@Override
	public Quaterniond divide(Vector3fr vector)
	{
		return (Quaterniond) super.divide(vector);
	}
	@Override
	public Quaterniond divide(Vector3dr vector)
	{
		return (Quaterniond) super.divide(vector);
	}
	@Override
	public Quaterniond divide(double x, double y, double z)
	{
		return (Quaterniond) super.divide(x, y, z);
	}
	@Override
	public Quaterniond divide(long x, long y, long z)
	{
		return (Quaterniond) super.divide(x, y, z);
	}
	@Override
	public Quaterniond add(Vector2ir vector)
	{
		return (Quaterniond) super.add(vector);
	}
	@Override
	public Quaterniond add(Vector2lr vector)
	{
		return (Quaterniond) super.add(vector);
	}
	@Override
	public Quaterniond add(Vector2fr vector)
	{
		return (Quaterniond) super.add(vector);
	}
	@Override
	public Quaterniond add(Vector2dr vector)
	{
		return (Quaterniond) super.add(vector);
	}
	@Override
	public Quaterniond add(double x, double y)
	{
		return (Quaterniond) super.add(x, y);
	}
	@Override
	public Quaterniond add(long x, long y)
	{
		return (Quaterniond) super.add(x, y);
	}
	@Override
	public Quaterniond subtract(Vector2ir vector)
	{
		return (Quaterniond) super.subtract(vector);
	}
	@Override
	public Quaterniond subtract(Vector2lr vector)
	{
		return (Quaterniond) super.subtract(vector);
	}
	@Override
	public Quaterniond subtract(Vector2fr vector)
	{
		return (Quaterniond) super.subtract(vector);
	}
	@Override
	public Quaterniond subtract(Vector2dr vector)
	{
		return (Quaterniond) super.subtract(vector);
	}
	@Override
	public Quaterniond subtract(double x, double y)
	{
		return (Quaterniond) super.subtract(x, y);
	}
	@Override
	public Quaterniond subtract(long x, long y)
	{
		return (Quaterniond) super.subtract(x, y);
	}
	@Override
	public Quaterniond multiply(Vector2ir vector)
	{
		return (Quaterniond) super.multiply(vector);
	}
	@Override
	public Quaterniond multiply(Vector2lr vector)
	{
		return (Quaterniond) super.multiply(vector);
	}
	@Override
	public Quaterniond multiply(Vector2fr vector)
	{
		return (Quaterniond) super.multiply(vector);
	}
	@Override
	public Quaterniond multiply(Vector2dr vector)
	{
		return (Quaterniond) super.multiply(vector);
	}
	@Override
	public Quaterniond multiply(double x, double y)
	{
		return (Quaterniond) super.multiply(x, y);
	}
	@Override
	public Quaterniond multiply(long x, long y)
	{
		return (Quaterniond) super.multiply(x, y);
	}
	@Override
	public Quaterniond divide(Vector2ir vector)
	{
		return (Quaterniond) super.divide(vector);
	}
	@Override
	public Quaterniond divide(Vector2lr vector)
	{
		return (Quaterniond) super.divide(vector);
	}
	@Override
	public Quaterniond divide(Vector2fr vector)
	{
		return (Quaterniond) super.divide(vector);
	}
	@Override
	public Quaterniond divide(Vector2dr vector)
	{
		return (Quaterniond) super.divide(vector);
	}
	@Override
	public Quaterniond divide(double x, double y)
	{
		return (Quaterniond) super.divide(x, y);
	}
	@Override
	public Quaterniond divide(long x, long y)
	{
		return (Quaterniond) super.divide(x, y);
	}
	@Override
	public Quaterniond addAll(long value)
	{
		return (Quaterniond) super.addAll(value);
	}
	@Override
	public Quaterniond addAll(double value)
	{
		return (Quaterniond) super.addAll(value);
	}
	@Override
	public Quaterniond subtractAll(long value)
	{
		return (Quaterniond) super.subtractAll(value);
	}
	@Override
	public Quaterniond subtractAll(double value)
	{
		return (Quaterniond) super.subtractAll(value);
	}
	@Override
	public Quaterniond multiplyAll(long value)
	{
		return (Quaterniond) super.multiplyAll(value);
	}
	@Override
	public Quaterniond multiplyAll(double value)
	{
		return (Quaterniond) super.multiplyAll(value);
	}
	@Override
	public Quaterniond divideAll(long value)
	{
		return (Quaterniond) super.divideAll(value);
	}
	@Override
	public Quaterniond divideAll(double value)
	{
		return (Quaterniond) super.divideAll(value);
	}

	@Override
	public Quaterniond opposite()
	{
		return (Quaterniond) super.opposite();
	}
	@Override
	public Quaterniond absolute()
	{
		return (Quaterniond) super.absolute();
	}
	@Override
	public Quaterniond conjugate()
	{
		return (Quaterniond) super.conjugate();
	}

	@Override
	public Quaterniond setX(double x)
	{
		return (Quaterniond) super.setX(x);
	}
	@Override
	public Quaterniond x(double x)
	{
		return (Quaterniond) super.x(x);
	}
	@Override
	public Quaterniond setY(double y)
	{
		return (Quaterniond) super.setY(y);
	}
	@Override
	public Quaterniond y(double y)
	{
		return (Quaterniond) super.y(y);
	}
	@Override
	public Quaterniond setZ(double z)
	{
		return (Quaterniond) super.setZ(z);
	}
	@Override
	public Quaterniond z(double z)
	{
		return (Quaterniond) super.z(z);
	}
	@Override
	public Quaterniond setW(double w)
	{
		return (Quaterniond) super.setW(w);
	}
	@Override
	public Quaterniond w(double w)
	{
		return (Quaterniond) super.w(w);
	}

	@Override
	public Quaterniond setAll(double x, double y, double z, double w)
	{
		return (Quaterniond) super.setAll(x, y, z, w);
	}
	@Override
	public Quaterniond setAll(Vector4ir vector)
	{
		return (Quaterniond) super.setAll(vector);
	}
	@Override
	public Quaterniond setAll(Vector4lr vector)
	{
		return (Quaterniond) super.setAll(vector);
	}
	@Override
	public Quaterniond setAll(Vector4fr vector)
	{
		return (Quaterniond) super.setAll(vector);
	}
	@Override
	public Quaterniond setAll(Vector4dr vector)
	{
		return (Quaterniond) super.setAll(vector);
	}

}
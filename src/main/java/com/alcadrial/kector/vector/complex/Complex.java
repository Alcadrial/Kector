package com.alcadrial.kector.vector.complex;

import com.alcadrial.kector.angle.Angle;
import com.alcadrial.kector.angle.AngleUnit;
import com.alcadrial.kector.vector.Vector2f;

public interface Complex {
	
	static Complex of(float r, float i)
	{
		return new CartesianComplex(r, i);
	}
	
	static Complex of(Vector2f vector)
	{
		return new CartesianComplex(vector);
	}
	
	static Complex ofPolar(float magnitude, float angle)
	{
		return new PolarComplex(magnitude, Angle.of(angle, AngleUnit.RADIANS));
	}
	
	static Complex ofPolar(float magnitude, Angle angle)
	{
		return new PolarComplex(magnitude, angle);
	}
	
	static Complex ofPolar(Vector2f vector)
	{
		return new PolarComplex(vector, AngleUnit.RADIANS);
	}
	
	static Complex ofFullState(float r, float i)
	{
		return new FullStateComplex(r, i);
	}
	
	static Complex ofFullState(Vector2f vector)
	{
		return new FullStateComplex(vector);
	}
	
	static Complex ofFullStatePolar(float magnitude, float angle)
	{
		return new FullStateComplex(magnitude, Angle.of(angle, AngleUnit.RADIANS));
	}
	
	static Complex ofFullStatePolar(float magnitude, Angle angle)
	{
		return new FullStateComplex(magnitude, angle);
	}
	
	static Complex ofFullStatePolar(Vector2f vector)
	{
		return new FullStateComplex(vector.x(), Angle.of(vector.y(), AngleUnit.RADIANS));
	}
	
	static Complex ofFullStatePolar(Vector2f vector, AngleUnit unit)
	{
		return new FullStateComplex(vector.x(), Angle.of(vector.y(), unit));
	}
	
	static Complex ofImmutable(float r, float i)
	{
		return new ImmutableCartesianComplex(r, i);
	}
	
	static Complex ofImmutable(Vector2f vector)
	{
		return new ImmutableCartesianComplex(vector);
	}
	
	static Complex ofImmutablePolar(float magnitude, float angle)
	{
		return new ImmutablePolarComplex(magnitude, Angle.of(angle, AngleUnit.RADIANS));
	}
	
	static Complex ofImmutablePolar(float magnitude, Angle angle)
	{
		return new ImmutablePolarComplex(magnitude, angle);
	}
	
	static Complex ofImmutablePolar(Vector2f vector)
	{
		return new ImmutablePolarComplex(vector, AngleUnit.RADIANS);
	}
	
	static Complex ofImmutablePolar(Vector2f vector, AngleUnit unit)
	{
		return new ImmutablePolarComplex(vector, unit);
	}
	
	static Complex copyOf(Complex complex)
	{
		return new CartesianComplex(complex);
	}
	
	static Complex copyOfPolar(Complex complex)
	{
		return new ImmutableCartesianComplex(complex);
	}
	
	static Complex copyOfImmutable(Complex complex)
	{
		return new PolarComplex(complex);
	}
	
	static Complex copyOfImmutablePolar(Complex complex)
	{
		return new ImmutablePolarComplex(complex);
	}
	
	Complex add(Complex complex);
	Complex multiply(Complex complex);
	
	Vector2f rotate(Vector2f v);
	
	Complex conjugate();
	
	Vector2f asVector();
	
	float r();
	float i();
	Angle angle();
	float angle(AngleUnit unit);
	float magnitude();
	
	Complex setR(float r);
	Complex setI(float i);
}

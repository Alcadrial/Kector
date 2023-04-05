package com.alcadrial.kector.vector;

import java.util.Arrays;
import java.util.List;

public abstract class AbstractVector4f implements Vector4f {
	
	public AbstractVector4f()
	{
		
	}
	
	@Override
	public Vector4f add(Vector4f vector)
	{
		return add(vector.x(), vector.y(), vector.z(), vector.w());
	}
	
	@Override
	public Vector4f add(Vector4i vector)
	{
		return add(vector.x(), vector.y(), vector.z(), vector.w());
	}
	
	@Override
	public Vector4f addAll(float value)
	{
		return add(value, value, value, value);
	}
	
	@Override
	public Vector4f subtract(Vector4f vector)
	{
		return subtract(vector.x(), vector.y(), vector.z(), vector.w());
	}
	
	@Override
	public Vector4f subtract(Vector4i vector)
	{
		return subtract(vector.x(), vector.y(), vector.z(), vector.w());
	}
	
	@Override
	public Vector4f subtractAll(float value)
	{
		return subtract(value, value, value, value);
	}
	
	@Override
	public Vector4f multiply(Vector4f vector)
	{
		return multiply(vector.x(), vector.y(), vector.z(), vector.w());
	}
	
	@Override
	public Vector4f multiply(Vector4i vector)
	{
		return multiply(vector.x(), vector.y(), vector.z(), vector.w());
	}
	
	@Override
	public Vector4f multiplyAll(float value)
	{
		return multiply(value, value, value, value);
	}
	
	@Override
	public Vector4f divide(Vector4f vector)
	{
		return divide(vector.x(), vector.y(), vector.z(), vector.w());
	}
	
	@Override
	public Vector4f divide(Vector4i vector)
	{
		return divide(vector.x(), vector.y(), vector.z(), vector.w());
	}
	
	@Override
	public Vector4f divideAll(float value)
	{
		return divide(value, value, value, value);
	}
	
	@Override
	public Vector4f unitary()
	{
		return multiplyAll((float) (1 / length()));
	}
	
	@Override
	public boolean isGreater(Vector4f vector)
	{
		return x() > vector.x() && y() > vector.y() && z() > vector.z() && w() > vector.w();
	}
	
	@Override
	public boolean isMinor(Vector4f vector)
	{
		return x() < vector.x() && y() < vector.y() && z() < vector.z() && w() < vector.w();
	}
	
	@Override
	public boolean isGreater(Vector4i vector)
	{
		return x() > vector.x() && y() > vector.y() && z() > vector.z() && w() > vector.w();
	}
	
	@Override
	public boolean isMinor(Vector4i vector)
	{
		return x() < vector.x() && y() < vector.y() && z() < vector.z() && w() < vector.w();
	}
	
	@Override
	public double length()
	{
		return Math.sqrt((double) x() * x() + (double) y() * y() + (double) z() * z() + (double) w() * w());
	}
	
	@Override
	public double size()
	{
		return length();
	}
	
	@Override
	public double distance(Vector4f vector)
	{
		float x = x() - vector.x();
		float y = y() - vector.y();
		float z = z() - vector.z();
		float w = w() - vector.w();
		return Math.sqrt(x * x + y * y + z * z + w * w);
	}
	
	@Override
	public double distance(Vector4i vector)
	{
		float x = x() - vector.x();
		float y = y() - vector.y();
		float z = z() - vector.z();
		float w = w() - vector.w();
		return Math.sqrt(x * x + y * y + z * z + w * w);
	}
	
	@Override
	public Vector4f setAll(Vector4f vector)
	{
		return setAll(vector.x(), vector.y(), vector.z(), vector.w());
	}
	
	@Override
	public List<Float> getValues()
	{
		return Arrays.asList(x(), y(), z(), w());
	}
	
	@Override
	public float[] getValuesArray()
	{
		return new float[] {x(), y(), z(), w()};
	}
}

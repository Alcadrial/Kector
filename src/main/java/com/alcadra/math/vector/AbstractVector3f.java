package com.alcadra.math.vector;

import java.util.Arrays;
import java.util.List;

public abstract class AbstractVector3f extends AbstractVector4f implements Vector3f {
	
	public AbstractVector3f()
	{
		
	}
	
	@Override
	public Vector3f add(Vector3f vector)
	{
		return add(vector.x(), vector.y(), vector.z());
	}
	
	@Override
	public Vector3f add(Vector3i vector)
	{
		return add(vector.x(), vector.y(), vector.z());
	}
	
	@Override
	public Vector3f addAll(float value)
	{
		return add(value, value, value);
	}
	
	@Override
	public Vector3f subtract(Vector3f vector)
	{
		return subtract(vector.x(), vector.y(), vector.z());
	}
	
	@Override
	public Vector3f subtract(Vector3i vector)
	{
		return subtract(vector.x(), vector.y(), vector.z());
	}
	
	@Override
	public Vector3f subtractAll(float value)
	{
		return subtract(value, value, value);
	}
	
	@Override
	public Vector3f multiply(Vector3f vector)
	{
		return multiply(vector.x(), vector.y(), vector.z());
	}
	
	@Override
	public Vector3f multiply(Vector3i vector)
	{
		return multiply(vector.x(), vector.y(), vector.z());
	}
	
	@Override
	public Vector3f multiplyAll(float value)
	{
		return multiply(value, value, value);
	}
	
	@Override
	public Vector3f divide(Vector3f vector)
	{
		return divide(vector.x(), vector.y(), vector.z());
	}
	
	@Override
	public Vector3f divide(Vector3i vector)
	{
		return divide(vector.x(), vector.y(), vector.z());
	}
	
	@Override
	public Vector3f divideAll(float value)
	{
		return divide(value, value, value);
	}
	
	@Override
	public Vector3f unitary()
	{
		return multiplyAll((float) (1 / length()));
	}
	
	@Override
	public boolean isGreater(Vector3f vector)
	{
		return x() > vector.x() && y() > vector.y() && z() > vector.z();
	}
	
	@Override
	public boolean isMinor(Vector3f vector)
	{
		return x() < vector.x() && y() < vector.y() && z() < vector.z();
	}
	
	@Override
	public boolean isGreater(Vector3i vector)
	{
		return x() > vector.x() && y() > vector.y() && z() > vector.z();
	}
	
	@Override
	public boolean isMinor(Vector3i vector)
	{
		return x() < vector.x() && y() < vector.y() && z() < vector.z();
	}
	
	@Override
	public double length()
	{
		return Math.sqrt((double) x() * x() + (double) y() * y() + (double) z() * z());
	}
	
	@Override
	public double distance(Vector3f vector)
	{
		float x = x() - vector.x();
		float y = y() - vector.y();
		float z = z() - vector.z();
		return Math.sqrt(x * x + y * y + z * z);
	}
	
	@Override
	public double distance(Vector3i vector)
	{
		float x = x() - vector.x();
		float y = y() - vector.y();
		float z = z() - vector.z();
		return Math.sqrt(x * x + y * y + z * z);
	}
	
	@Override
	public Vector3f setAll(Vector3f vector)
	{
		return setAll(vector.x(), vector.y(), vector.z());
	}
	
	@Override
	public List<Float> getValues()
	{
		return Arrays.asList(x(), y(), z());
	}
	
	@Override
	public float[] getValuesArray()
	{
		return new float[] {x(), y(), z()};
	}
}

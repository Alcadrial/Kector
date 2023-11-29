package com.alcadrial.kector.vector;

import java.util.Arrays;
import java.util.List;

public abstract class AbstractVector2i extends AbstractVector3i implements Vector2i {
	
	public AbstractVector2i()
	{
		
	}
	
	@Override
	public Vector2f add(Vector2f vector)
	{
		return add(vector.x(), vector.y());
	}
	
	@Override
	public Vector2i add(Vector2i vector)
	{
		return add(vector.x(), vector.y());
	}
	
	@Override
	public Vector2f addAll(float value)
	{
		return add(value, value);
	}
	
	@Override
	public Vector2i addAll(int value)
	{
		return add(value, value);
	}
	
	@Override
	public Vector2f subtract(Vector2f vector)
	{
		return subtract(vector.x(), vector.y());
	}
	
	@Override
	public Vector2i subtract(Vector2i vector)
	{
		return subtract(vector.x(), vector.y());
	}
	
	@Override
	public Vector2f subtractAll(float value)
	{
		return subtract(value, value);
	}
	
	@Override
	public Vector2i subtractAll(int value)
	{
		return subtract(value, value);
	}
	
	@Override
	public Vector2f multiply(Vector2f vector)
	{
		return multiply(vector.x(), vector.y());
	}
	
	@Override
	public Vector2i multiply(Vector2i vector)
	{
		return multiply(vector.x(), vector.y());
	}
	
	@Override
	public Vector2f multiplyAll(float value)
	{
		return multiply(value, value);
	}
	
	@Override
	public Vector2i multiplyAll(int value)
	{
		return multiply(value, value);
	}
	
	@Override
	public Vector2f divide(Vector2f vector)
	{
		return divide(vector.x(), vector.y());
	}
	
	@Override
	public Vector2i divide(Vector2i vector)
	{
		return divide(vector.x(), vector.y());
	}
	
	@Override
	public Vector2f divideAll(float value)
	{
		return divide(value, value);
	}
	
	@Override
	public Vector2i divideAll(int value)
	{
		return divide(value, value);
	}
	
	@Override
	public float dotProduct(Vector2f vector)
	{
		return x() * vector.x() + y() * vector.y();
	}
	
	@Override
	public int dotProduct(Vector2i vector)
	{
		return x() * vector.x() + y() * vector.y();
	}
	
	@Override
	public float dotProduct(Vector3f vector)
	{
		return x() * vector.x() + y() * vector.y();
	}
	
	@Override
	public int dotProduct(Vector3i vector)
	{
		return x() * vector.x() + y() * vector.y();
	}
	
	@Override
	public float dotProduct(Vector4f vector)
	{
		return x() * vector.x() + y() * vector.y();
	}
	
	@Override
	public int dotProduct(Vector4i vector)
	{
		return x() * vector.x() + y() * vector.y();
	}
	
	@Override
	public Vector2f unitary()
	{
		return multiplyAll((float) (1 / length()));
	}
	
	@Override
	public boolean isGreater(Vector2f vector)
	{
		return x() > vector.x() && y() > vector.y();
	}
	
	@Override
	public boolean isMinor(Vector2f vector)
	{
		return x() < vector.x() && y() < vector.y();
	}
	
	@Override
	public boolean isGreater(Vector2i vector)
	{
		return x() > vector.x() && y() > vector.y();
	}
	
	@Override
	public boolean isMinor(Vector2i vector)
	{
		return x() < vector.x() && y() < vector.y();
	}
	
	@Override
	public double squareLength()
	{
		return (double) x() * x() + (double) y() * y();
	}
	
	@Override
	public double distance(Vector2f vector)
	{
		float x = x() - vector.x();
		float y = y() - vector.y();
		return Math.sqrt(x * x + y * y);
	}
	
	@Override
	public double distance(Vector2i vector)
	{
		float x = x() - vector.x();
		float y = y() - vector.y();
		return Math.sqrt(x * x + y * y);
	}
	
	@Override
	public double axialLength()
	{
		return (double) x() + y();
	}
	
	@Override
	public double axialDistance(Vector2f vector)
	{
		float x = Math.abs(x() - vector.x());
		float y = Math.abs(y() - vector.y());
		return x + y;
	}
	
	@Override
	public double axialDistance(Vector2i vector)
	{
		double x = Math.abs(x() - vector.x());
		double y = Math.abs(y() - vector.y());
		return x + y;
	}
	
	@Override
	public Vector2i setAll(Vector2i vector)
	{
		return setAll(vector.x(), vector.y());
	}
	
	@Override
	public List<Integer> getValues()
	{
		return Arrays.asList(x(), y());
	}
	
	@Override
	public int[] getValuesArray()
	{
		return new int[] {x(), y()};
	}
}

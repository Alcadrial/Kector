package com.alcadrial.kector.matrix;

import com.alcadrial.kector.AngleUnit;
import com.alcadrial.kector.annotation.Angle;
import com.alcadrial.kector.shape.OrthoShape;
import com.alcadrial.kector.vector.Vector2fr;
import com.alcadrial.kector.vector.Vector3fr;
import com.alcadrial.kector.vector.Vector3ir;
import com.alcadrial.kector.vector.Vector4f;
import com.alcadrial.kector.vector.Vector4fr;

class IdentityMatrix4f extends Matrix4f {
	
	public static final Matrix4f IDENTITY = new IdentityMatrix4f();
	private static final String TO_STRING = "Matrix{[[1, 0, 0, 0], [0, 1, 0, 0], [0, 0, 1, 0], [0, 0, 0, 1]]}";
	private static final float[] VALUES = new float[] {1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1};
	
	private IdentityMatrix4f()
	{
		values = VALUES;
	}
	
	@Override
	public float get(int i, int j)
	{
		return i == j ? 1 : 0;
	}
	
	@Override
	public Matrix4f set(int i, int j, float value)
	{
		return this;
	}
	
	@Override
	public Matrix4f identity()
	{
		return this;
	}
	
	@Override
	public Matrix4f orthographicPositive(float width, float height)
	{
		return this;
	}
	
	@Override
	public Matrix4f orthographic(float width, float height)
	{
		return this;
	}
	
	@Override
	public Matrix4f orthographic(float width, float height, float length)
	{
		return this;
	}
	
	@Override
	public Matrix4f orthographic(OrthoShape boxShape)
	{
		return this;
	}
	
	@Override
	public Matrix4f plane(float width, float height)
	{
		return this;
	}
	
	@Override
	public Matrix4f cursor(float width, float height, Vector2fr mousePos)
	{
		return this;
	}
	
	@Override
	public Matrix4f cursor(float width, float height, float centerX, float centerY)
	{
		return this;
	}
	
	@Override
	public Matrix4f project(@Angle(AngleUnit.RADIANS) float fieldOfView, float maxDistance, float minDistance, float aspectRatio)
	{
		return this;
	}
	
	@Override
	public Matrix4f view(Vector3fr position, @Angle(AngleUnit.RADIANS) float rotationX, @Angle(AngleUnit.RADIANS) float rotationY)
	{
		return this;
	}
	
	@Override
	public Matrix4f view(@Angle(AngleUnit.RADIANS) float rotationX, @Angle(AngleUnit.RADIANS) float rotationY)
	{
		return this;
	}
	
	@Override
	public Matrix4f scale(Vector3fr vector)
	{
		return this;
	}
	
	@Override
	public Matrix4f scaleRelative(Vector3fr vector)
	{
		return this;
	}
	
	@Override
	public Matrix4f translateTo(Vector3ir vector)
	{
		return this;
	}
	
	@Override
	public Matrix4f translateXTo(float x)
	{
		return this;
	}
	
	@Override
	public Matrix4f translateYTo(float y)
	{
		return this;
	}
	
	@Override
	public Matrix4f translateZTo(float z)
	{
		return this;
	}
	
	@Override
	public Matrix4f translateTo(Vector3fr vector)
	{
		return this;
	}
	
	@Override
	public Matrix4f translate(Vector3ir vector)
	{
		return this;
	}
	
	@Override
	public Matrix4f translateX(float x)
	{
		return this;
	}
	
	@Override
	public Matrix4f translateY(float y)
	{
		return this;
	}
	
	@Override
	public Matrix4f translateZ(float z)
	{
		return this;
	}
	
	@Override
	public Matrix4f translate(Vector3fr vector)
	{
		return this;
	}
	
	@Override
	public Matrix4f rotateX(@Angle(AngleUnit.RADIANS) float angle)
	{
		return this;
	}
	
	@Override
	public Matrix4f rotateY(@Angle(AngleUnit.RADIANS) float angle)
	{
		return this;
	}
	
	@Override
	public Matrix4f rotateZ(@Angle(AngleUnit.RADIANS) float angle)
	{
		return this;
	}
	
	@Override
	public Matrix4f multiply(Matrix4f other)
	{
		throw new UnsupportedOperationException("Immutable instance");
	}
	
	@Override
	public Vector4f multiply(Vector4fr vector)
	{
		return Vector4f.of(vector);
	}
	
	@Override
	public float determinant()
	{
		return 1;
	}
	
	@Override
	public Matrix4f transpose()
	{
		return this;
	}
	
	@Override
	public Matrix4f inverse()
	{
		return this;
	}
	
	@Override
	public float[] toArray()
	{
		return VALUES;
	}
	
	@Override
	public float[] toTransposedArray()
	{
		return VALUES;
	}
	
	@Override
	public String toString()
	{
		return TO_STRING;
	}
}

package com.alcadrial.kector.shape;

import com.alcadrial.kector.angle.Angle;
import com.alcadrial.kector.vector.Vector3f;
import com.alcadrial.kector.vector.complex.Quaternion;

public abstract class Shape {
	
	protected Shape()
	{}
	
	public boolean isInside(Vector3f pos)
	{
		return getEnclosingCube().isInside(pos);
	}
	
	public boolean clip(OrthoShape shape)
	{
		return getEnclosingCube().clip(shape);
	}
	
	public boolean clip(Shape shape)
	{
		return getEnclosingCube().clip(shape);
	}
	
	public IntersectionResult intersect(OrthoShape shape)
	{
		return getEnclosingCube().intersect(shape);
	}
	
	public Vector3f getIntersectionPosition(Shape shape)
	{
		return getEnclosingCube().getIntersectionPosition(shape);
	}
	
	public abstract OrthoShape getEnclosingCube();
	
	public Shape rotate(Angle xRotation, Angle yRotation)
	{
		return rotate(new Quaternion(xRotation, yRotation, Angle.V0_RAD));
	}
	
	public abstract Shape rotate(Quaternion quaternion);
	
	public Shape translate(Vector3f vector)
	{
		return translate(vector.x(), vector.y(), vector.z());
	}
	
	public abstract Shape translate(float x, float y, float z);
	
	public abstract Vector3f[] getVertices();
}

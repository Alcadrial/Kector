package com.alcadrial.kector.shape;

import com.alcadrial.kector.AngleUnit;
import com.alcadrial.kector.annotation.Angle;
import com.alcadrial.kector.annotation.Temporary;
import com.alcadrial.kector.vector.Vector3fr;
import com.alcadrial.kector.vector.quaternion.Quaternionfr;

public interface Shape {
	
	default boolean isInside(Vector3fr pos)
	{
		return getEnclosingCube().isInside(pos);
	}
	
	default boolean clip(OrthoShape shape)
	{
		return getEnclosingCube().clip(shape);
	}
	
	default boolean clip(Shape shape)
	{
		return getEnclosingCube().clip(shape);
	}
	
	default IntersectionResult intersect(OrthoShape shape)
	{
		return getEnclosingCube().intersect(shape);
	}
	
	default Vector3fr getIntersectionPosition(Shape shape)
	{
		return getEnclosingCube().getIntersectionPosition(shape);
	}
	
	OrthoShape getEnclosingCube();
	
	default Shape rotate(@Angle(AngleUnit.RADIANS) float xRotation, @Angle(AngleUnit.RADIANS) float yRotation)
	{
		return rotate(Quaternionfr.ofAngles(xRotation, yRotation, 0));
	}
	
	public abstract Shape rotate(Quaternionfr quaternion);
	
	default Shape translate(Vector3fr vector)
	{
		return translate(vector.x(), vector.y(), vector.z());
	}
	
	Shape translate(float x, float y, float z);
	
	/**
	 * Returns a lazy iterator over the vertices of this shape with no specific order,
	 * check implementations documentation for a specific ordering
	 */
	@Temporary
	Iterable<Vector3fr> getVertices();
}

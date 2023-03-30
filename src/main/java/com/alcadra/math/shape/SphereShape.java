package com.alcadra.math.shape;

import com.alcadra.math.angle.Angle;
import com.alcadra.math.vector.Vector3f;
import com.alcadra.math.vector.complex.Quaternion;

public class SphereShape extends Shape {
	
	private Vector3f origin;
	private float size;
	private OrthoShape enclosingCube;
	
	public SphereShape(Vector3f origin, float size)
	{
		this.origin = Vector3f.copyOf(origin);
		this.size = size;
		Vector3f halfDiagonal = Vector3f.of(size, size, size);
		enclosingCube = new OrthoShape(Vector3f.copyOf(origin).subtract(halfDiagonal), halfDiagonal.add(origin));
	}
	
	@Override
	public OrthoShape getEnclosingCube()
	{
		return enclosingCube;
	}
	
	@Override
	public SphereShape rotate(Angle xRotation, Angle yRotation)
	{
		return new SphereShape(origin, size);
	}
	
	@Override
	public SphereShape rotate(Quaternion quaternion)
	{
		return new SphereShape(origin, size);
	}
	
	@Override
	public SphereShape translate(float x, float y, float z)
	{
		return new SphereShape(Vector3f.copyOf(origin).add(x, y, z), size);
	}
	
	@Override
	public boolean isInside(Vector3f pos)
	{
		float x = pos.x() - origin.x();
		float y = pos.y() - origin.y();
		float z = pos.z() - origin.z();
		return x * x + y * y + z * z <= size * size;
	}
	
	@Override
	public Vector3f[] getVertices()
	{
		return new Vector3f[] {Vector3f.copyOf(origin), Vector3f.copyOf(origin).add(Vector3f.of(0, size, 0))};
	}
	
	public Vector3f getOrigin()
	{
		return origin;
	}
	
	public float getSize()
	{
		return size;
	}
}

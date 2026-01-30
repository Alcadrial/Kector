package com.alcadrial.kector.shape;

import java.util.List;

import com.alcadrial.kector.angle.AngleUnit;
import com.alcadrial.kector.annotation.Angle;
import com.alcadrial.kector.vector.Vector3f;
import com.alcadrial.kector.vector.complex.Quaternion;

public class SphereShape implements Shape {
	
	private Vector3f origin;
	private float ray;
	private OrthoShape enclosingCube;
	
	public SphereShape(Vector3f origin, float ray)
	{
		this.origin = Vector3f.copyOfImmutable(origin);
		this.ray = ray;
	}
	
	@Override
	public OrthoShape getEnclosingCube()
	{
		if (enclosingCube == null) enclosingCube = OrthoShape.byEnd(this.origin.subtract(ray, ray, ray), this.origin.add(ray, ray, ray));
		return enclosingCube;
	}
	
	@Override
	public Shape rotate(@Angle(AngleUnit.RADIANS) float xRotation, @Angle(AngleUnit.RADIANS) float yRotation)
	{
		return new SphereShape(origin, ray);
	}
	
	@Override
	public SphereShape rotate(Quaternion quaternion)
	{
		return new SphereShape(origin, ray);
	}
	
	@Override
	public SphereShape translate(float x, float y, float z)
	{
		return new SphereShape(origin.add(x, y, z), ray);
	}
	
	@Override
	public boolean isInside(Vector3f pos)
	{
		float x = pos.x() - origin.x();
		float y = pos.y() - origin.y();
		float z = pos.z() - origin.z();
		return x * x + y * y + z * z <= ray * ray;
	}
	
	@Override
	public Iterable<Vector3f> getVertices()
	{
		return List.of(origin);
	}
	
	public Vector3f getOrigin()
	{
		return origin;
	}
	
	public float getRay()
	{
		return ray;
	}
}

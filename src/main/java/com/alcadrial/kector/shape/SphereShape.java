package com.alcadrial.kector.shape;

import java.util.List;

import com.alcadrial.kector.annotation.Angle;
import com.alcadrial.kector.vector.Vector3f;
import com.alcadrial.kector.vector.Vector3fr;
import com.alcadrial.kector.vector.quaternion.Quaternionfr;

public class SphereShape implements Shape {
	
	private Vector3fr origin;
	private float ray;
	private OrthoShape enclosingCube;
	
	public SphereShape(Vector3fr origin, float ray)
	{
		this.origin = origin;
		this.ray = ray;
	}
	
	@Override
	public OrthoShape getEnclosingCube()
	{
		if (enclosingCube == null) enclosingCube = OrthoShape.byEnd(Vector3f.of(origin).subtract(ray, ray, ray), Vector3f.of(origin).add(ray, ray, ray));
		return enclosingCube;
	}
	
	@Override
	public Shape rotate(@Angle float xRotation, @Angle float yRotation)
	{
		return new SphereShape(origin, ray);
	}
	
	@Override
	public SphereShape rotate(Quaternionfr quaternion)
	{
		return new SphereShape(origin, ray);
	}
	
	@Override
	public SphereShape translate(float x, float y, float z)
	{
		return new SphereShape(Vector3f.of(origin).add(x, y, z), ray);
	}
	
	@Override
	public boolean isInside(Vector3fr pos)
	{
		return pos.squareDistance(pos) <= ray * ray;
	}
	
	@Override
	public Iterable<Vector3fr> getVertices()
	{
		return List.of(origin);
	}
	
	public Vector3fr getOrigin()
	{
		return origin;
	}
	
	public float getRay()
	{
		return ray;
	}
}

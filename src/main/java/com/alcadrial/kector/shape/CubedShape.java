package com.alcadrial.kector.shape;

import com.alcadrial.kector.vector.Vector3f;
import com.alcadrial.kector.vector.complex.Quaternion;

public class CubedShape extends Shape {
	
	protected final Vector3f position, size, direction;
	
	public CubedShape(Vector3f position, Vector3f size, Vector3f direction)
	{
		this.position = Vector3f.copyOf(position);
		this.size = Vector3f.copyOf(size);
		this.direction = Vector3f.copyOf(direction);
	}
	
	@Override
	public OrthoShape getEnclosingCube()
	{
		Vector3f[] points = getVertices();
		Vector3f min = points[0], max = points[0];
		for (int i = 1; i < points.length; i++)
		{
			min = Vector3f.of(Math.min(points[i].x(), min.x()), Math.min(points[i].y(), min.y()), Math.min(points[i].z(), min.z()));
			max = Vector3f.of(Math.max(points[i].x(), max.x()), Math.max(points[i].y(), max.y()), Math.max(points[i].z(), max.z()));
		}
		return new OrthoShape(min, max);
	}
	
	@Override
	public CubedShape rotate(Quaternion q)
	{
		return new CubedShape(q.rotate(position), q.rotate(size), q.rotate(direction));
	}
	
	@Override
	public CubedShape translate(float x, float y, float z)
	{
		return new CubedShape(Vector3f.copyOf(position).add(x, y, z), size, direction);
	}
	
	@Override
	public Vector3f[] getVertices()
	{
		Vector3f[] vertices = new Vector3f[8];
		Quaternion q = getDirectionQuaternion().conjugate();
		Vector3f v = q.rotate(size).xyz();
		Vector3f x = Vector3f.of(v.x(), 0), y = Vector3f.of(0, v.y()), z = Vector3f.of(0, 0, v.z());
		x = q.rotate(x).xyz();
		y = q.rotate(y).xyz();
		z = q.rotate(z).xyz();
		vertices[0] = Vector3f.copyOf(position).add(y);
		vertices[1] = Vector3f.copyOf(position).add(y).add(x);
		vertices[2] = Vector3f.copyOf(position).add(x);
		vertices[3] = Vector3f.copyOf(position);
		vertices[4] = Vector3f.copyOf(position).add(z).add(y);
		vertices[5] = Vector3f.copyOf(position).add(size);
		vertices[6] = Vector3f.copyOf(position).add(z).add(x);
		vertices[7] = Vector3f.copyOf(position).add(z);
		return vertices;
	}
	
	@Override
	public boolean isInside(Vector3f pos)
	{
		if (super.isInside(pos)) return true;
		Quaternion q = getDirectionQuaternion().conjugate();
		Vector3f v = q.rotate(pos);
		Vector3f s = q.rotate(pos);
		return v.isGreater(Vector3f.origin()) && v.isMinor(s);
	}
	
	@Override
	public IntersectionResult intersect(OrthoShape shape)
	{
		for (Vector3f vertex : getVertices()) if (shape.isInside(vertex)) return new IntersectionResult(true, Vector3f.copyOf(vertex), null);
		
		return new IntersectionResult(false, null, null);
	}
	
	public Vector3f getCenter()
	{
		return Vector3f.copyOf(position).add(size.x() * 0.5F, size.y() * 0.5F, size.z() * 0.5F);
	}
	
	public Vector3f getPosition()
	{
		return position;
	}
	
	public Vector3f getSize()
	{
		return size;
	}
	
	public Vector3f getDirection()
	{
		return direction;
	}
	
	public Quaternion getDirectionQuaternion()
	{
		return new Quaternion(direction);
	}
}

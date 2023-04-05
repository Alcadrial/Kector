package com.alcadra.kector.shape;

import com.alcadra.kector.vector.Vector3f;
import com.alcadra.kector.vector.axis.Axis;
import com.alcadra.kector.vector.complex.Quaternion;

public class OrthoShape extends Shape {
	
	private Vector3f start;
	private Vector3f end;
	
	public OrthoShape(Vector3f start, Vector3f end)
	{
		this.start = Vector3f.of(Math.min(start.x(), end.x()), Math.min(start.y(), end.y()), Math.min(start.z(), end.z()));
		this.end = Vector3f.of(Math.max(start.x(), end.x()), Math.max(start.y(), end.y()), Math.max(start.z(), end.z()));
	}
	
	private OrthoShape(Vector3f start, Vector3f end, int i)
	{
		this.start = start;
		this.end = end;
	}
	
	@Override
	public CubedShape rotate(Quaternion q)
	{
		return new CubedShape(q.rotate(start).xyz(), q.rotate(Vector3f.copyOf(end).add(start)).subtract(start), Axis.Z);
	}
	
	@Override
	public OrthoShape translate(float x, float y, float z)
	{
		return new OrthoShape(Vector3f.copyOf(start).add(x, y, z), Vector3f.copyOf(end).add(x, y, z), 0);
	}
	
	@Override
	public boolean isInside(Vector3f pos)
	{
		return pos.isGreater(start) && pos.isMinor(end);
	}
	
	@Override
	public boolean clip(OrthoShape shape)
	{
		return !shape.start.isGreater(end) && !shape.end.isMinor(start);
	}
	
	@Override
	public boolean clip(Shape shape)
	{
		return shape.clip(this);
	}
	
	@Override
	public IntersectionResult intersect(OrthoShape shape)
	{
		for (Vector3f vertex : getVertices()) if (shape.isInside(vertex)) return new IntersectionResult(true, Vector3f.copyOf(start), Vector3f.copyOf(vertex));
		for (Vector3f vertex : shape.getVertices()) if (isInside(vertex)) return new IntersectionResult(true, Vector3f.copyOf(shape.start), Vector3f.copyOf(vertex));
		return new IntersectionResult(false, null, null);
	}
	
	@Override
	public Vector3f[] getVertices()
	{
		Vector3f[] vertices = new Vector3f[8];
		vertices[0] = Vector3f.of(start.x(), end.y(), start.z());
		vertices[1] = Vector3f.of(end.x(), end.y(), start.z());
		vertices[2] = Vector3f.of(end.x(), start.y(), start.z());
		vertices[3] = Vector3f.of(start.x(), start.y(), start.z());
		vertices[4] = Vector3f.of(start.x(), end.y(), end.z());
		vertices[5] = Vector3f.of(end.x(), end.y(), end.z());
		vertices[6] = Vector3f.of(end.x(), start.y(), end.z());
		vertices[7] = Vector3f.of(start.x(), start.y(), end.z());
		return vertices;
	}
	
	@Override
	public OrthoShape getEnclosingCube()
	{
		return this;
	}
	
	public Vector3f getStart()
	{
		return start;
	}
	
	public Vector3f getEnd()
	{
		return end;
	}
	
	@Override
	public String toString()
	{
		String s = start.toString();
		String e = end.toString();
		return s.substring(s.indexOf('{')) + "->" + e.substring(e.indexOf('{'));
	}
}

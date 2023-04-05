package com.alcadra.kector.shape;

import com.alcadra.kector.vector.Vector3f;
import com.alcadra.kector.vector.complex.Quaternion;

public class ParallelepipedShape extends Shape {
	
	private final Vector3f width, height, lenght, position;
	
	public ParallelepipedShape(Vector3f width, Vector3f height, Vector3f lenght, Vector3f position)
	{
		this.width = Vector3f.copyOf(width);
		this.height = Vector3f.copyOf(height);
		this.lenght = Vector3f.copyOf(lenght);
		this.position = Vector3f.copyOf(position);
	}
	
	@Override
	public OrthoShape getEnclosingCube()
	{
		return new OrthoShape(position, Vector3f.copyOf(position).add(width).add(height).add(lenght));
	}
	
	@Override
	public ParallelepipedShape rotate(Quaternion q)
	{
		return new ParallelepipedShape(q.rotate(width), q.rotate(lenght), q.rotate(lenght), q.rotate(position));
	}
	
	@Override
	public ParallelepipedShape translate(float x, float y, float z)
	{
		return new ParallelepipedShape(width, height, lenght, Vector3f.copyOf(position).add(x, y, z));
	}
	
	@Override
	public Vector3f[] getVertices()
	{
		Vector3f[] vertices = new Vector3f[8];
		vertices[0] = Vector3f.copyOf(position).add(height);
		vertices[1] = Vector3f.copyOf(position).add(height).add(width);
		vertices[2] = Vector3f.copyOf(position).add(width);
		vertices[3] = Vector3f.copyOf(position);
		vertices[4] = Vector3f.copyOf(position).add(lenght).add(height);
		vertices[5] = Vector3f.copyOf(position).add(lenght).add(height).add(width);
		vertices[6] = Vector3f.copyOf(position).add(lenght).add(width);
		vertices[7] = Vector3f.copyOf(position).add(lenght);
		return vertices;
	}
	
	public Vector3f getWidth()
	{
		return width;
	}
	
	public Vector3f getHeight()
	{
		return height;
	}
	
	public Vector3f getLenght()
	{
		return lenght;
	}
	
	public Vector3f getPosition()
	{
		return position;
	}
}

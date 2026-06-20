package com.alcadrial.kector.shape;

import com.alcadrial.kector.annotation.Temporary;
import com.alcadrial.kector.shape.utils.FixedSizeIterator;
import com.alcadrial.kector.vector.Vector3f;
import com.alcadrial.kector.vector.Vector3fr;
import com.alcadrial.kector.vector.quaternion.Quaternionfr;

public class ParallelepipedShape implements Shape {
	
	private final Vector3fr width, height, length, position;
	
	public ParallelepipedShape(Vector3fr width, Vector3fr height, Vector3fr length, Vector3fr position)
	{
		this.width = width;
		this.height = height;
		this.length = length;
		this.position = position;
	}
	
	@Override
	public OrthoShape getEnclosingCube()
	{
		return OrthoShape.byEnd(position, Vector3f.of(position).add(width).add(height).add(length));
	}
	
	@Override
	public ParallelepipedShape rotate(Quaternionfr q)
	{
		Vector3f newPosition = q.rotate(Vector3f.of(position));
		return new ParallelepipedShape(q.rotate(Vector3f.of(width).add(position)).subtract(newPosition), q.rotate(Vector3f.of(height).add(position)).subtract(newPosition), q.rotate(Vector3f.of(length).add(position)).subtract(newPosition), newPosition);
	}
	
	@Override
	public ParallelepipedShape translate(float x, float y, float z)
	{
		return new ParallelepipedShape(width, height, length, Vector3f.of(position).add(x, y, z));
	}
	
	@Override
	@Temporary
	public Iterable<Vector3fr> getVertices()
	{
		return () -> {
			Vector3f v = Vector3f.of(position);
			return FixedSizeIterator.of(8, i -> {
				switch (i % 4)
				{
					case 0 -> v.add(height);
					case 1 -> v.add(width);
					case 2 -> v.subtract(height);
					case 3 -> v.subtract(width);
				}
				if (i == 4) v.add(length);
				return v;
			});
		};
	}
	
	public Vector3fr getWidth()
	{
		return width;
	}
	
	public Vector3fr getHeight()
	{
		return height;
	}
	
	public Vector3fr getLength()
	{
		return length;
	}
	
	public Vector3fr getPosition()
	{
		return position;
	}
}

package com.alcadrial.kector.shape;

import com.alcadrial.kector.shape.utils.FixedSizeIterator;
import com.alcadrial.kector.vector.Vector3f;
import com.alcadrial.kector.vector.complex.Quaternion;

public class ParallelepipedShape implements Shape {
	
	private final Vector3f width, height, length, position;
	
	public ParallelepipedShape(Vector3f width, Vector3f height, Vector3f length, Vector3f position)
	{
		this.width = Vector3f.copyOfImmutable(width);
		this.height = Vector3f.copyOfImmutable(height);
		this.length = Vector3f.copyOfImmutable(length);
		this.position = Vector3f.copyOfImmutable(position);
	}
	
	@Override
	public OrthoShape getEnclosingCube()
	{
		return OrthoShape.byEnd(position, position.add(width).add(height).add(length));
	}
	
	@Override
	public ParallelepipedShape rotate(Quaternion q)
	{
		Vector3f newPosition = q.rotate(position);
		return new ParallelepipedShape(q.rotate(width.add(position)).subtract(newPosition), q.rotate(height.add(position)).subtract(newPosition), q.rotate(length.add(position)).subtract(newPosition), newPosition);
	}
	
	@Override
	public ParallelepipedShape translate(float x, float y, float z)
	{
		return new ParallelepipedShape(width, height, length, position.add(x, y, z));
	}
	
	@Override
	public Iterable<Vector3f> getVertices()
	{
		return () -> {
			Vector3f v = Vector3f.copyOf(position);
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
	
	public Vector3f getWidth()
	{
		return width;
	}
	
	public Vector3f getHeight()
	{
		return height;
	}
	
	public Vector3f getLength()
	{
		return length;
	}
	
	public Vector3f getPosition()
	{
		return position;
	}
}

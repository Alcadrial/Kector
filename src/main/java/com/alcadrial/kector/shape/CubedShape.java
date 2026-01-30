package com.alcadrial.kector.shape;

import com.alcadrial.kector.annotation.NoZeroComponents;
import com.alcadrial.kector.annotation.SharedInstance;
import com.alcadrial.kector.shape.utils.FixedSizeIterator;
import com.alcadrial.kector.vector.Vector3f;
import com.alcadrial.kector.vector.axis.Axis;
import com.alcadrial.kector.vector.complex.Quaternion;

public class CubedShape implements Shape {
	
	protected final Vector3f position;
	protected final @NoZeroComponents Vector3f size;
	protected final Quaternion rotation;
	
	public CubedShape(Vector3f position, @NoZeroComponents Vector3f size, Quaternion rotation)
	{
		this.position = Vector3f.copyOfImmutable(position);
		this.size = Vector3f.copyOfImmutable(size);
		this.rotation = new Quaternion(rotation);
	}
	
	@Override
	public OrthoShape getEnclosingCube()
	{
		Vector3f min = Vector3f.copyOf(position);
		Vector3f max = Vector3f.copyOf(position);
		Vector3f x = rotation.rotate(Axis.X).multiplyAll(size.x());
		Vector3f y = rotation.rotate(Axis.Y).multiplyAll(size.y());
		Vector3f z = rotation.rotate(Axis.Z).multiplyAll(size.z());
		
		for (Vector3f v : new Vector3f[] {x, y, z})
		{
			if (v.x() < 0) min.setX(min.x() + v.x());
			else if (v.x() > 0) max.setX(max.x() + v.x());
			if (v.y() < 0) min.setY(min.y() + v.y());
			else if (v.y() > 0) max.setY(max.y() + v.y());
			if (v.z() < 0) min.setZ(min.z() + v.z());
			else if (v.z() > 0) max.setZ(max.z() + v.z());
		}
		
		return OrthoShape.byEnd(min, max);
	}
	
	@Override
	public CubedShape rotate(Quaternion q)
	{
		return new CubedShape(q.rotate(position), q.rotate(size), q.multiply(rotation));
	}
	
	@Override
	public CubedShape translate(float x, float y, float z)
	{
		return new CubedShape(position.add(x, y, z), size, rotation);
	}
	
	/**
	 * Iteration order:
	 * <p>
	 * <code>v = {@link #position}</code><br>
	 * <code>x = {@link #size}.x()</code><br>
	 * <code>y = size.y()</code><br>
	 * <code>z = size.z()</code><br>
	 * <ol start="0">
	 *   <li><code>v + y</code></li>
	 *   <li><code>v + x + y</code></li>
	 *   <li><code>v + x</code></li>
	 *   <li><code>v</code></li>
	 *   <li><code>v + z + y</code></li>
	 *   <li><code>v + z + x + y</code></li>
	 *   <li><code>v + z + x</code></li>
	 *   <li><code>v + z</code></li>
	 * </ol>
	 */
	@Override
	@SharedInstance
	public Iterable<Vector3f> getVertices()
	{
		Vector3f x = rotation.rotate(Axis.X).multiplyAll(size.x());
		Vector3f y = rotation.rotate(Axis.Y).multiplyAll(size.y());
		Vector3f z = rotation.rotate(Axis.Z).multiplyAll(size.z());
		return () -> {
			Vector3f v = Vector3f.copyOf(position);
			return FixedSizeIterator.of(8, i -> {
				switch (i % 4)
				{
					case 0 -> v.add(y);
					case 1 -> v.add(x);
					case 2 -> v.subtract(y);
					case 3 -> v.subtract(x);
				}
				if (i == 4) v.add(z);
				return v;
			});
		};
	}
	
	@Override
	public boolean isInside(Vector3f pos)
	{
		Vector3f relativePos = rotation.rotate(pos.subtract(position));
		if (!relativePos.isGreater(position)) return false;
		return position.add(size).isGreater(relativePos);
	}
	
	@Override
	public IntersectionResult intersect(OrthoShape shape)
	{
		for (Vector3f vertex : getVertices()) if (shape.isInside(vertex)) return new IntersectionResult(true, Vector3f.copyOf(vertex), null);
		
		return new IntersectionResult(false, null, null);
	}
	
	public Vector3f getCenter()
	{
		return position.add(size.x() * 0.5F, size.y() * 0.5F, size.z() * 0.5F);
	}
	
	public Vector3f getPosition()
	{
		return position;
	}
	
	public @NoZeroComponents Vector3f getSize()
	{
		return size;
	}
	
	public Quaternion getRotation()
	{
		return rotation;
	}
}

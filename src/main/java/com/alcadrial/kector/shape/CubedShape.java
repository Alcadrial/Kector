package com.alcadrial.kector.shape;

import com.alcadrial.kector.annotation.NoZeroComponents;
import com.alcadrial.kector.annotation.Temporary;
import com.alcadrial.kector.shape.utils.FixedSizeIterator;
import com.alcadrial.kector.vector.Vector3f;
import com.alcadrial.kector.vector.Vector3fr;
import com.alcadrial.kector.vector.axis.Axisf;
import com.alcadrial.kector.vector.quaternion.Quaternionf;
import com.alcadrial.kector.vector.quaternion.Quaternionfr;

public class CubedShape implements Shape {
	
	protected final Vector3fr position;
	protected final @NoZeroComponents Vector3fr size;
	protected final Quaternionfr rotation;
	
	public CubedShape(Vector3fr position, @NoZeroComponents Vector3fr size, Quaternionfr rotation)
	{
		this.position = position;
		this.size = size;
		this.rotation = rotation;
	}
	
	@Override
	public OrthoShape getEnclosingCube()
	{
		Vector3f min = Vector3f.of(position);
		Vector3f max = Vector3f.of(position);
		Vector3f v = Vector3f.of(Axisf.X);
		
		for (int i = 0; i < 3; i++)
		{
			switch (i)
			{
				case 0 -> rotation.rotate(v).multiplyAll(size.x());
				case 1 -> rotation.rotate(v.setAll(Axisf.Y)).multiplyAll(size.y());
				case 2 -> rotation.rotate(v.setAll(Axisf.Z)).multiplyAll(size.z());
			}
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
	public CubedShape rotate(Quaternionfr q)
	{
		return new CubedShape(q.rotate(Vector3f.of(position)), q.rotate(Vector3f.of(size)), Quaternionf.of(q).multiply(rotation));
	}
	
	@Override
	public CubedShape translate(float x, float y, float z)
	{
		return new CubedShape(Vector3f.of(position).add(x, y, z), size, rotation);
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
	@Temporary
	public Iterable<Vector3fr> getVertices()
	{
		Vector3f x = rotation.rotate(Vector3f.of(Axisf.X)).multiplyAll(size.x());
		Vector3f y = rotation.rotate(Vector3f.of(Axisf.Y)).multiplyAll(size.y());
		Vector3f z = rotation.rotate(Vector3f.of(Axisf.Z)).multiplyAll(size.z());
		return () -> {
			Vector3f v = Vector3f.of(position);
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
	public boolean isInside(Vector3fr pos)
	{
		Vector3f relativePos = rotation.rotate(Vector3f.of(pos).subtract(position));
		if (!relativePos.isGreater(position)) return false;
		return Vector3f.of(position).add(size).isGreater(relativePos);
	}
	
	@Override
	public IntersectionResult intersect(OrthoShape shape)
	{
		for (Vector3fr vertex : getVertices()) if (shape.isInside(vertex)) return new IntersectionResult(true, Vector3f.of(vertex), null);
		
		return new IntersectionResult(false, null, null);
	}
	
	public Vector3f getCenter()
	{
		return Vector3f.of(position).add(size.x() * 0.5F, size.y() * 0.5F, size.z() * 0.5F);
	}
	
	public Vector3fr getPosition()
	{
		return position;
	}
	
	public @NoZeroComponents Vector3fr getSize()
	{
		return size;
	}
	
	public Quaternionfr getRotation()
	{
		return rotation;
	}
}

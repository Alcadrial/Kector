package com.alcadrial.kector.shape;

import com.alcadrial.kector.shape.utils.FixedSizeIterator;
import com.alcadrial.kector.vector.Vector3f;
import com.alcadrial.kector.vector.complex.Quaternion;

public class OrthoShape implements Shape {
	
	private Vector3f start;
	private Vector3f end;
	
	public static OrthoShape bySize(Vector3f start, Vector3f size)
	{
		return new OrthoShape(Vector3f.copyOfImmutable(start), Vector3f.copyOfImmutable(start).add(size));
	}
	
	public static OrthoShape byEnd(Vector3f start, Vector3f end)
	{
		return new OrthoShape(Vector3f.copyOfImmutable(start), Vector3f.copyOfImmutable(end));
	}
	
	private OrthoShape(Vector3f start, Vector3f end)
	{
		this.start = start;
		this.end = end;
	}
	
	@Override
	public CubedShape rotate(Quaternion q)
	{
		return new CubedShape(start, end.subtract(start), q);
	}
	
	@Override
	public OrthoShape translate(float x, float y, float z)
	{
		return new OrthoShape(start.add(x, y, z), end.add(x, y, z));
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

	/**
	 * Iteration order:
	 * <p>
	 * <code>s = {@link #start}</code><br>
	 * <code>e = {@link #end}</code><br>
	 * <ol start="0">
	 *   <li><code>s.x + e.y + s.z</code></li>
	 *   <li><code>e.x + e.y + s.z</code></li>
	 *   <li><code>e.x + s.y + s.z</code></li>
	 *   <li><code>s.x + s.y + s.z</code></li>
	 *   <li><code>s.x + e.y + e.z</code></li>
	 *   <li><code>e.x + e.y + e.z</code></li>
	 *   <li><code>e.x + s.y + e.z</code></li>
	 *   <li><code>s.x + s.y + e.z</code></li>
	 * </ol>
	 */
	@Override
	public Iterable<Vector3f> getVertices()
	{
		return () -> {
			Vector3f v = Vector3f.of(start.x(), end.y(), start.z());
			return FixedSizeIterator.of(8, i -> {
				switch (i % 4)
				{
					case 0 -> v.setY(end.y());
					case 1 -> v.setX(end.x());
					case 2 -> v.setY(start.y());
					case 3 -> v.setX(start.x());
				}
				if (i == 4) v.setZ(end.z());
				return v;
			});
		};
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

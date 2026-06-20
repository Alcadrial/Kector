package com.alcadrial.kector.shape;

import com.alcadrial.kector.annotation.Temporary;
import com.alcadrial.kector.shape.utils.FixedSizeIterator;
import com.alcadrial.kector.vector.Vector3f;
import com.alcadrial.kector.vector.Vector3fr;
import com.alcadrial.kector.vector.quaternion.Quaternionfr;

public class OrthoShape implements Shape {
	
	private Vector3fr start;
	private Vector3fr end;
	
	public static OrthoShape bySize(Vector3fr start, Vector3fr size)
	{
		return new OrthoShape(start, Vector3f.of(start).add(size));
	}
	
	public static OrthoShape byEnd(Vector3fr start, Vector3fr end)
	{
		return new OrthoShape(start, end);
	}
	
	private OrthoShape(Vector3fr start, Vector3fr end)
	{
		this.start = start;
		this.end = end;
	}
	
	@Override
	public CubedShape rotate(Quaternionfr q)
	{
		return new CubedShape(start, Vector3f.of(end).subtract(start), q);
	}
	
	@Override
	public OrthoShape translate(float x, float y, float z)
	{
		return new OrthoShape(Vector3f.of(start).add(x, y, z), Vector3f.of(end).add(x, y, z));
	}
	
	@Override
	public boolean isInside(Vector3fr pos)
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
		for (Vector3fr vertex : getVertices()) if (shape.isInside(vertex)) return new IntersectionResult(true, Vector3f.of(start), Vector3f.of(vertex));
		for (Vector3fr vertex : shape.getVertices()) if (isInside(vertex)) return new IntersectionResult(true, Vector3f.of(shape.start), Vector3f.of(vertex));
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
	@Temporary
	public Iterable<Vector3fr> getVertices()
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
	
	public Vector3fr getStart()
	{
		return start;
	}
	
	public Vector3fr getEnd()
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

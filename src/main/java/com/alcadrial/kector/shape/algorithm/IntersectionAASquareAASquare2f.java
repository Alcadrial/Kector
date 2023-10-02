package com.alcadrial.kector.shape.algorithm;

import java.util.Optional;

import com.alcadrial.kector.shape.api.curve.AASegment2f;
import com.alcadrial.kector.shape.api.quadrilateral.AARectangle2f;
import com.alcadrial.kector.shape.api.quadrilateral.AASquare2f;
import com.alcadrial.kector.shape.kector.curve.KectorAASegment2f;
import com.alcadrial.kector.shape.kector.quadrilateral.KectorAARectangle2f;
import com.alcadrial.kector.shape.kector.quadrilateral.KectorSquare2f;
import com.alcadrial.kector.vector.Vector2f;

public class IntersectionAASquareAASquare2f implements Intersection2f {
	
	private AASquare2f abcd;
	private AASquare2f efgh;
	
	private Boolean intersect;
	private Optional<Vector2f> pointIntersection;
	private Optional<AASegment2f> segmentIntersection;
	private Optional<AARectangle2f> rectangleIntersection;
	private Optional<AASquare2f> squareIntersection;
	
	public IntersectionAASquareAASquare2f(AASquare2f abcd, AASquare2f efgh)
	{
		this.abcd = abcd;
		this.efgh = efgh;
	}
	
	private Vector2f a;
	private Vector2f b;
	private Vector2f c;
	private Vector2f d;
	private Vector2f e;
	private Vector2f f;
	private Vector2f h;
	
	public AASquare2f abcd()
	{
		return abcd;
	}
	
	public AASquare2f efgh()
	{
		return efgh;
	}
	
	private Vector2f a()
	{
		if (a == null) a = abcd.getLeftUpVertex();
		return a;
	}
	
	private Vector2f b()
	{
		if (b == null) b = abcd.getRigthUpVertex();
		return b;
	}
	
	private Vector2f c()
	{
		if (c == null) c = abcd.getRigthDownVertex();
		return c;
	}
	
	private Vector2f d()
	{
		if (d == null) d = abcd.getLeftDownVertex();
		return d;
	}
	
	private Vector2f e()
	{
		if (e == null) e = efgh.getLeftUpVertex();
		return e;
	}
	
	private Vector2f f()
	{
		if (f == null) f = efgh.getRigthUpVertex();
		return f;
	}
	
	private Vector2f h()
	{
		if (h == null) h = efgh.getLeftDownVertex();
		return h;
	}
	
	@Override
	public boolean intersect()
	{
		if (intersect == null)
		{
			if (h.y() < d.y())
			{
				if (h.x() < d.x()) intersect = f.y() > d.y() && f.x() > d.x();
				else intersect = h.x() < b.x() && f.y() > d.y();
			}
			else if (h.y() < b.y())
			{
				if (h.x() < d.x()) intersect = f.x() > d.x();
				else intersect = h.x() < b.x();
			}
			else intersect = false;
		}
		return intersect;
	}
	
	public Optional<Vector2f> pointIntersection()
	{
		if (pointIntersection == null)
		{
			b();
			d();
			f();
			h();
			if (d.x() == f.x() && b.y() == h.y()) pointIntersection = Optional.of(a());
			else if (b.equals(h)) pointIntersection = Optional.of(b);
			else if (b.x() == h.x() && d.y() == f.y()) pointIntersection = Optional.of(c());
			else if (f.equals(d)) pointIntersection = Optional.of(d);
			else pointIntersection = Optional.empty();
		}
		return pointIntersection;
	}
	
	public Optional<AASegment2f> segmentIntersection()
	{
		if (segmentIntersection == null)
		{
			b();
			d();
			f();
			h();
			
			if (d.y() == f.y())
			{
				if (d.x() >= h.x())
				{
					if (d.x() < f.x())
					{
						if (b.x() >= f.x()) segmentIntersection = Optional.of(new KectorAASegment2f(d, f.x() - d.x(), false));
						else segmentIntersection = Optional.of(new KectorAASegment2f(d, abcd.getWidth(), false));
					}
					else segmentIntersection = Optional.empty();
				}
				else if (b.x() >= h.x())
				{
					if (b.x() < f.x()) segmentIntersection = Optional.of(new KectorAASegment2f(e(), b.x() - h.x(), false));
					else segmentIntersection = Optional.of(new KectorAASegment2f(f, efgh.getWidth(), false));
				}
				else segmentIntersection = Optional.empty();
			}
			else if (b.y() == h.y())
			{
				if (d.x() >= h.x())
				{
					if (d.x() < f.x())
					{
						if (b.x() >= f.x()) segmentIntersection = Optional.of(new KectorAASegment2f(a(), f.x() - d.x(), false));
						else segmentIntersection = Optional.of(new KectorAASegment2f(d, abcd.getWidth(), false));
					}
					else segmentIntersection = Optional.empty();
				}
				else if (b.x() >= h.x())
				{
					if (b.x() < f.x()) segmentIntersection = Optional.of(new KectorAASegment2f(h, b.x() - h.x(), false));
					else segmentIntersection = Optional.of(new KectorAASegment2f(f, efgh.getWidth(), false));
				}
				else segmentIntersection = Optional.empty();
			}
			else if (b.x() == h.x())
			{
				if (d.y() >= h.y())
				{
					if (d.y() < f.y())
					{
						if (b.y() >= f.y()) segmentIntersection = Optional.of(new KectorAASegment2f(c(), f.y() - d.y(), true));
						else segmentIntersection = Optional.of(new KectorAASegment2f(d, abcd.getHeight(), true));
					}
					else segmentIntersection = Optional.empty();
				}
				else if (b.y() >= h.y())
				{
					if (b.y() < f.y()) segmentIntersection = Optional.of(new KectorAASegment2f(h, b.y() - h.y(), true));
					else segmentIntersection = Optional.of(new KectorAASegment2f(f, efgh.getHeight(), true));
				}
				else segmentIntersection = Optional.empty();
			}
			else if (d.x() == f.x())
			{
				if (d.y() >= h.y())
				{
					if (d.y() < f.y())
					{
						if (b.y() >= f.y()) segmentIntersection = Optional.of(new KectorAASegment2f(d, f.y() - d.y(), true));
						else segmentIntersection = Optional.of(new KectorAASegment2f(d, abcd.getHeight(), true));
					}
					else segmentIntersection = Optional.empty();
				}
				else if (b.y() >= h.y())
				{
					if (b.y() < f.y()) segmentIntersection = Optional.of(new KectorAASegment2f(c(), b.y() - h.y(), true));
					else segmentIntersection = Optional.of(new KectorAASegment2f(f, efgh.getHeight(), true));
				}
				else segmentIntersection = Optional.empty();
			}
			else segmentIntersection = Optional.empty();
		}
		return segmentIntersection;
	}
	
	public Optional<AARectangle2f> rectangleIntersection()
	{
		if (rectangleIntersection == null)
		{
			b();
			d();
			f();
			h();
			
			if (h.y() < d.y())
			{
				if (h.x() < d.x())
				{
					if (f.y() > d.y() && f.x() > d.x())
					{
						if (f.y() < b.y())
						{
							if (f.x() < b.x())
							{
								rectangleIntersection = Optional.of(new KectorAARectangle2f(d, f.x() - d.x(), f.y() - d.y()));
							}
							else rectangleIntersection = Optional.of(new KectorAARectangle2f(d, abcd.getWidth(), f.y() - d.y()));
						}
						else if (f.x() < b.x())
						{
							rectangleIntersection = Optional.of(new KectorAARectangle2f(d, f.x() - d.x(), abcd.getHeight()));
						}
						else rectangleIntersection = Optional.of(abcd);
					}
					else rectangleIntersection = Optional.empty();
				}
				else if ((h.x() < b.x()) && (f.y() > d.y()))
				{
					if (f.y() < b.y())
					{
						if (f.x() < b.x())
						{
							rectangleIntersection = Optional.of(new KectorAARectangle2f(f, -efgh.getWidth(), d.y() - f.y()));
						}
						else rectangleIntersection = Optional.of(new KectorAARectangle2f(Vector2f.of(h.x(), d.y()), b.x() - h.x(), f.y() - d.y()));
					}
					else if (f.x() < b.x())
					{
						rectangleIntersection = Optional.of(new KectorAARectangle2f(Vector2f.of(h.x(), d.y()), efgh.getWidth(), abcd.getHeight()));
					}
					else rectangleIntersection = Optional.of(new KectorAARectangle2f(Vector2f.of(h.x(), d.y()), b.x() - h.x(), abcd.getHeight()));
				}
				else rectangleIntersection = Optional.empty();
			}
			else if (h.y() < b.y())
			{
				if (h.x() < d.x())
				{
					if (f.x() > d.x())
					{
						if (f.y() < b.y())
						{
							if (f.x() < b.x())
							{
								rectangleIntersection = Optional.of(new KectorAARectangle2f(f, d.x() - f.x(), -efgh.getHeight()));
							}
							else rectangleIntersection = Optional.of(new KectorAARectangle2f(Vector2f.of(d.x(), h.y()), abcd.getWidth(), efgh.getHeight()));
						}
						else if (f.x() < b.x())
						{
							rectangleIntersection = Optional.of(new KectorAARectangle2f(Vector2f.of(d.x(), h.y()), f.x() - d.x(), b.y() - h.y()));
						}
						else rectangleIntersection = Optional.of(new KectorAARectangle2f(b, -abcd.getWidth(), h.y() - b.y()));
					}
					else rectangleIntersection = Optional.empty();
				}
				else if (h.x() < b.x())
				{
					if (f.y() < b.y())
					{
						if (f.x() < b.x())
						{
							rectangleIntersection = Optional.of(efgh);
						}
						else rectangleIntersection = Optional.of(new KectorAARectangle2f(h, b.x() - h.x(), efgh.getHeight()));
					}
					else if (f.x() < b.x())
					{
						rectangleIntersection = Optional.of(new KectorAARectangle2f(h, efgh.getWidth(), b.y() - h.y()));
					}
					else rectangleIntersection = Optional.of(new KectorAARectangle2f(h, b.x() - h.x(), b.y() - h.y()));
				}
				else rectangleIntersection = Optional.empty();
			}
			else rectangleIntersection = Optional.empty();
		}
		return rectangleIntersection;
	}
	
	public Optional<AASquare2f> squareIntersection()
	{
		if (squareIntersection == null)
		{
			Optional<AARectangle2f> rectangle = rectangleIntersection();
			if (rectangle.isPresent())
			{
				AARectangle2f r = rectangle.get();
				if (r.getWidth() == r.getHeight()) squareIntersection = Optional.of(new KectorSquare2f(r.getWidth(), r.getLeftDownVertex()));
				else squareIntersection = Optional.empty();
			}
			else squareIntersection = Optional.empty();
		}
		return squareIntersection;
	}
}

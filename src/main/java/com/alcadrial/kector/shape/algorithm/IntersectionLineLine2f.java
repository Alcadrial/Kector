package com.alcadrial.kector.shape.algorithm;

import java.util.Optional;

import com.alcadrial.kector.Math;
import com.alcadrial.kector.shape.api.ImplementationSpecialization;
import com.alcadrial.kector.shape.api.curve.Line2f;
import com.alcadrial.kector.vector.Vector2f;

public class IntersectionLineLine2f implements Intersection2f {
	
	private Line2f r;
	private Line2f s;
	private Boolean intersect;
	private Boolean parallels;
	private Float minDistance;
	private Optional<Vector2f> pointIntersection;
	private Optional<Line2f> lineIntersection;
	
	public IntersectionLineLine2f(Line2f r, Line2f s)
	{
		this.r = r;
		this.s = s;
	}
	
	public Line2f getR()
	{
		return r;
	}
	
	public Line2f getS()
	{
		return s;
	}
	
	@Override
	public boolean intersect()
	{
		if (intersect == null) intersect = !parallels() || r.getHorizontalTranslation() == s.getHorizontalTranslation();
		return intersect;
	}
	
	public boolean parallels()
	{
		if (parallels == null)
		{
			ImplementationSpecialization specialization = ImplementationSpecialization.preferConstant(r.getAngleSpecialization(), s.getAngleSpecialization());
			parallels = switch (specialization)
			{
				case CONSTANT -> r.getAngularCoefficient() == s.getAngularCoefficient();
				case ANGLE -> r.getAngle().equals(s.getAngle());
				default -> throw new UnsupportedOperationException("Unknown specialization " + specialization);
			};
		}
		return parallels;
	}
	
	public Optional<Vector2f> pointIntersection()
	{
		if (pointIntersection == null)
		{
			if (parallels()) pointIntersection = Optional.empty();
			else
			{
				float x = (s.getVerticalTranslation() - r.getVerticalTranslation()) / (r.getAngularCoefficient() - s.getAngularCoefficient());
				float y = (r.getAngleSpecialization() == ImplementationSpecialization.CONSTANT ? r : s).getY(x);
				pointIntersection = Optional.of(Vector2f.of(x, y));
			}
		}
		return pointIntersection;
	}
	
	public Optional<Line2f> lineIntersection()
	{
		if (lineIntersection == null) lineIntersection = parallels() && r.getHorizontalTranslation() == s.getHorizontalTranslation() ? Optional.of(r) : Optional.empty();
		return lineIntersection;
	}
	
	public Float minDistance()
	{
		if (minDistance == null) minDistance = parallels() ? Math.distance(r.getHorizontalTranslation(), s.getVerticalTranslation()) : 0;
		return minDistance;
	}
}

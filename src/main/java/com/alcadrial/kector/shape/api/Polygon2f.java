package com.alcadrial.kector.shape.api;

import com.alcadrial.kector.angle.Angle;

public interface Polygon2f {
	
	/**
	 * Tests whether this polygon is convex.
	 * @return true if this polygon is convex
	 */
	boolean isConvex();
	/**
	 * Tests whether this polygon is concave.
	 * @return true if this polygon is concave
	 */
	boolean isConcave();
	
	/**
	 * Returns the perimeter of this polygon.
	 * @return the perimeter of this polygon
	 */
	float getPerimeter();
	/**
	 * Returns the area of this polygon.
	 * @return the area of this polygon
	 */
	float getArea();
	/**
	 * Returns the sum of all the interior angles of this polygon.
	 * @return the sum of all the interior angles of this polygon
	 */
	Angle getAnglesSum();
}

package com.alcadrial.kector.shape.api.curve;

import com.alcadrial.kector.angle.Angle;
import com.alcadrial.kector.vector.Vector2f;

public interface Segment2f {
	
	/**
	 * Returns the vector to the A point of this segment.
	 * @return the vector to the A point of this segment
	 */
	Vector2f getA();
	/**
	 * Returns the vector to the B point of this segment.
	 * @return the vector to the B point of this segment
	 */
	Vector2f getB();
	/**
	 * Returns the angle between the x axis and this segment.
	 * @return the angle between the x axis and this segment
	 */
	Angle getAngle();
	/**
	 * Returns the length of this segment.
	 * @return the length of this segment
	 */
	float getLength();
}

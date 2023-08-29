package com.alcadrial.kector.shape.api.curve;

import com.alcadrial.kector.angle.Angle;
import com.alcadrial.kector.vector.Vector2f;

public interface SemiLine2f {
	
	/**
	 * Returns the angle between the x axis and this line.
	 * @return the angle between the x axis and this line
	 */
	Angle getAngle();
	/**
	 * Returns the origin of this semiline.
	 * @return the origin of this semiline
	 */
	Vector2f getOrigin();
}

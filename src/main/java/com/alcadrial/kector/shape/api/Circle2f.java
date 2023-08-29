package com.alcadrial.kector.shape.api;

import com.alcadrial.kector.angle.Angle;
import com.alcadrial.kector.vector.Vector2f;

/**
 * A collection of points distant less than <b>r</b> from the origin <b>O</b>.
 * <p>
 * An object permits to retrieve some information about the circle plus the information of a {@link Polygon2f}:
 * <ul>
 *     <li>Ray <b>r</b></li>
 *     <li>Origin <b>O</b></li>
 * </ul>
 * @author Alcadrial
 */
public interface Circle2f extends Polygon2f {
	
	@Override
	default Angle getAnglesSum()
	{
		return Angle.DOUBLE_PI_RAD;
	}
	
	/**
	 * Returns the ray of the circumference.
	 * @return the ray of the circumference
	 */
	float getRay();
	/**
	 * Returns the origin of the circumference.
	 * @return the origin of the circumference
	 */
	Vector2f getOrigin();
}

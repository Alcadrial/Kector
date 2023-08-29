package com.alcadrial.kector.shape.api;

import com.alcadrial.kector.angle.Angle;
import com.alcadrial.kector.shape.api.curve.Segment2f;
import com.alcadrial.kector.vector.Vector2f;

/**
 * An angular sector of a circle.
 * <p>
 * An object permits to retrieve some information about the sector plus the information of a {@link Polygon2f}:
 * <ul>
 *     <li>Ray <b>r</b></li>
 *     <li>Origin <b>O</b></li>
 *     <li>Point <b>A</b> at the end of the sector</li>
 *     <li>Point <b>B</b> at the start of the sector</li>
 *     <li>Segment <b>OA</b></li>
 *     <li>Segment <b>OB</b></li>
 *     <li>Angle <b>AOB</b></li>
 *     <li>Start Angle <b>XOB</b></li>
 *     <li>End Angle <b>XOA</b></li>
 * </ul>
 * @author Alcadrial
 */
public interface Sector2f extends Polygon2f {
	
	/**
	 * Returns the length of the sector.
	 * @return the length of the sector
	 */
	float getRay();
	
	/**
	 * Returns the width of the sector.
	 * @return the width of the sector
	 */
	Angle getAngle();
	/**
	* Returns the angle between the x axis and the <b>OB</b> segment of the sector.
	* @return the angle between the x axis and the <b>OB</b> segment of the sector
	*/
	Angle getStartAngle();
	/**
	* Returns the angle between the x axis and the <b>OA</b> segment of the sector.
	* @return the angle between the x axis and the <b>OA</b> segment of the sector
	*/
	Angle getEndAngle();
	
	/**
	 * Returns the origin of the sector.
	 * @return the origin of the sector
	 */
	Vector2f getOrigin();
	/**
	 * Returns the A vector of the sector.
	 * @return the A vector of the sector
	 */
	Vector2f getA();
	/**
	 * Returns the B vector of the sector.
	 * @return the B vector of the sector
	 */
	Vector2f getB();
	
	/**
	 * Returns the <b>OA</b> segment of the sector.
	 * @return the <b>OA</b> segment of the sector
	 */
	Segment2f getOASegment();
	/**
	 * Returns the <b>OB</b> segment of the sector.
	 * @return the <b>OB</b> segment of the sector
	 */
	Segment2f getOBSegment();
}

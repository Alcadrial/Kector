package com.alcadrial.kector.shape.api.curve;

import com.alcadrial.kector.angle.Angle;
import com.alcadrial.kector.misc.Direction1f;
import com.alcadrial.kector.shape.api.ImplementationSpecialization;
import com.alcadrial.kector.vector.Vector2f;

public interface SemiLine2f {
	
	/**
	 * The angle between the x axis and this line.
	 * @return an angle
	 */
	Angle getAngle();
	/**
	 * The ration y / x, if the ration is infinite then the line is horizontal.
	 * @return the y / x ration
	 */
	float getAngularCoefficient();
	
	/**
	 * The direction of this semiline, {@link Direction1f#POSITIVE POSITIVE} means toward positive x.
	 * @return POSITIVE if directed toward positive x otherwise NEGATIVE
	 */
	Direction1f getXDirection();
	/**
	 * The direction of this semiline, {@link Direction1f#POSITIVE POSITIVE} means toward positive y.
	 * @return POSITIVE if directed toward positive y otherwise NEGATIVE
	 */
	Direction1f getYDirection();
	
	/**
	 * Returns the origin of this semiline.
	 * @return the origin of this semiline
	 */
	Vector2f getOrigin();
	
	/**
	 * Returns the {@link ImplementationSpecialization} used by the implementation in order to use faster methods in computations.
	 * @return the {@link ImplementationSpecialization} used
	 */
	ImplementationSpecialization getAngleSpecialization();
}

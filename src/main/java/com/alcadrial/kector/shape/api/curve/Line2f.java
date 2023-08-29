package com.alcadrial.kector.shape.api.curve;

import com.alcadrial.kector.angle.Angle;
import com.alcadrial.kector.shape.api.ImplementationSpecialization;

public interface Line2f {
	
	/**
	 * The y component of the point on this line with the given x.
	 * @param x
	 * @return the corrispondent y value
	 */
	float getY(float x);
	
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
	 * Returns the {@link ImplementationSpecialization} used by the implementation in order to use faster methods in computations.
	 * @return the {@link ImplementationSpecialization} used
	 */
	ImplementationSpecialization getAngleSpecialization();
	
	/**
	 * Translation towards positive x.
	 * @return x positive translation
	 */
	float getHorizontalTranslation();
	/**
	 * Translation towards positive y.
	 * @return y positive translation
	 */
	float getVerticalTranslation();
}

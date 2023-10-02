package com.alcadrial.kector.shape.api.curve;

import com.alcadrial.kector.angle.Angle;

public interface AASegment2f extends Segment2f {
	
	boolean isVertical();
	boolean isHorizontal();
	
	@Override
	default Angle getAngle()
	{
		return isVertical() ? Angle.HALF_PI_RAD : Angle.V0_RAD;
	}
}

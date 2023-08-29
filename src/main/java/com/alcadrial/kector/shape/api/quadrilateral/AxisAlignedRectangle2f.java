package com.alcadrial.kector.shape.api.quadrilateral;

import com.alcadrial.kector.angle.Angle;

public interface AxisAlignedRectangle2f extends Rectangle2f {
	
	@Override
	default Angle getAngleRdLdX()
	{
		return Angle.V0_RAD;
	}
	
	@Override
	default Angle getAngleLuLdY()
	{
		return Angle.V0_RAD;
	}
}

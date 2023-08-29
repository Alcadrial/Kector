package com.alcadrial.kector.shape.api.quadrilateral;

import com.alcadrial.kector.Math;
import com.alcadrial.kector.angle.Angle;
import com.alcadrial.kector.angle.AngleUnit;
import com.alcadrial.kector.vector.Vector2f;

public interface Rectangle2f extends Parallelogram2f, RigthAngledTrapezoid2f, IsoscelesTrapezoid2f {
	
	@Override
	default Angle getAngleDAB()
	{
		return Angle.HALF_PI_RAD;
	}
	
	@Override
	default Angle getAngleABC()
	{
		return Angle.HALF_PI_RAD;
	}
	
	@Override
	default Angle getAngleBCD()
	{
		return Angle.HALF_PI_RAD;
	}
	
	@Override
	default Angle getAngleCDA()
	{
		return Angle.HALF_PI_RAD;
	}
	
	@Override
	default Angle getAngleDAC()
	{
		return Angle.of(Math.HALF_PI / 2, AngleUnit.RADIANS);
	}
	
	@Override
	default Angle getAngleCAB()
	{
		return Angle.of(Math.HALF_PI / 2, AngleUnit.RADIANS);
	}
	
	@Override
	default Angle getAngleABD()
	{
		return Angle.of(Math.HALF_PI / 2, AngleUnit.RADIANS);
	}
	
	@Override
	default Angle getAngleDBC()
	{
		return Angle.of(Math.HALF_PI / 2, AngleUnit.RADIANS);
	}
	
	@Override
	default Angle getAngleBCA()
	{
		return Angle.of(Math.HALF_PI / 2, AngleUnit.RADIANS);
	}
	
	@Override
	default Angle getAngleACD()
	{
		return Angle.of(Math.HALF_PI / 2, AngleUnit.RADIANS);
	}
	
	@Override
	default Angle getAngleCDB()
	{
		return Angle.of(Math.HALF_PI / 2, AngleUnit.RADIANS);
	}
	
	@Override
	default Angle getAngleBDA()
	{
		return Angle.of(Math.HALF_PI / 2, AngleUnit.RADIANS);
	}
	
	float getWidth();
	float getHeight();
	Vector2f getPosition();//alias D
	
}

package com.alcadrial.kector.shape.api.quadrilateral;

import com.alcadrial.kector.angle.Angle;
import com.alcadrial.kector.shape.api.Polygon2f;
import com.alcadrial.kector.shape.api.curve.Segment2f;
import com.alcadrial.kector.vector.Vector2f;

public interface Quadrilateral2f extends Polygon2f {
	
	@Override
	default Angle getAnglesSum()
	{
		return Angle.DOUBLE_PI_RAD;
	}
	
	boolean isSimple();
	boolean isComplex();
	
	Vector2f getA();
	Vector2f getB();
	Vector2f getC();
	Vector2f getD();
	
	Vector2f getRigthUpVertex();
	Vector2f getRigthDownVertex();
	Vector2f getLeftUpVertex();
	Vector2f getLeftDownVertex();
	
	Angle getAngleDAB();
	Angle getAngleABC();
	Angle getAngleBCD();
	Angle getAngleCDA();
	
	Angle getAngleDAC();
	Angle getAngleCAB();
	Angle getAngleABD();
	Angle getAngleDBC();
	Angle getAngleBCA();
	Angle getAngleACD();
	Angle getAngleCDB();
	Angle getAngleBDA();
	
	Angle getAngleRdLdX();
	Angle getAngleLuLdY();
	
	Segment2f getSegmentAB();
	Segment2f getSegmentBC();
	Segment2f getSegmentCD();
	Segment2f getSegmentDA();
	Segment2f getSegmentAC();
	Segment2f getSegmentDB();
	
	float getABLength();
	float getBCLength();
	float getCDLength();
	float getDALength();
}

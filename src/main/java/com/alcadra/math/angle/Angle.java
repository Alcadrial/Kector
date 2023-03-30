package com.alcadra.math.angle;

import java.math.BigDecimal;

import com.alcadra.math.Math;

public interface Angle {
	
	static Angle of(float angle, AngleUnit unit)
	{
		return new AngleFloat(unit, angle);
	}
	
	static Angle of(double angle, AngleUnit unit)
	{
		return new AngleDouble(unit, angle);
	}
	
	static Angle of(BigDecimal angle, AngleUnit unit)
	{
		return new AngleBigDecimal(unit, angle);
	}
	
	static Angle V0_RAD = of(0, AngleUnit.RADIANS);
	static Angle HALF_PI_RAD = of(Math.HALF_PI, AngleUnit.RADIANS);
	static Angle PI_RAD = of(Math.PI, AngleUnit.RADIANS);
	static Angle NEGATIVE_HALF_PI_RAD = of(-Math.HALF_PI, AngleUnit.RADIANS);
	
	static Angle V0_GRAD = of(0D, AngleUnit.GRADIANS);
	static Angle V100_GRAD = of(100D, AngleUnit.GRADIANS);
	static Angle V200_GRAD = of(200D, AngleUnit.GRADIANS);
	static Angle V300_GRAD = of(300D, AngleUnit.GRADIANS);
	
	static Angle V0_TURN = of(0D, AngleUnit.TURNS);
	static Angle V0_5_TURN = of(0.5, AngleUnit.TURNS);
	static Angle V1_TURN = of(1D, AngleUnit.TURNS);
	static Angle V2_TURN = of(2D, AngleUnit.TURNS);
	
	static Angle V0_DEG = of(0D, AngleUnit.DEGREES);
	static Angle V90_DEG = of(90D, AngleUnit.DEGREES);
	static Angle V180_DEG = of(180D, AngleUnit.DEGREES);
	static Angle V270_DEG = of(270D, AngleUnit.DEGREES);
	
	float asFloat();
	double asDouble();
	BigDecimal asBigDecimal();
	
	float asFloat(AngleUnit unit);
	double asDouble(AngleUnit unit);
	BigDecimal asBigDecimal(AngleUnit unit);
	
	void setValue(AngleUnit unit, float value);
	void setValue(AngleUnit unit, double value);
	void setValue(AngleUnit unit, BigDecimal value);
}

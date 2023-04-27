package com.alcadrial.kector.angle;

import java.math.BigDecimal;

import com.alcadrial.kector.Math;

/**
 * An interface representing an immutable angle and it's the measurement {@link AngleUnit unit}
 * that can be converted easily into other units with methods like {@link #asFloat(AngleUnit)}
 * or used in mathematical operation like {@link #add(Angle)}
 * <p>
 * This is meant for being used when angles with different units or precision are to be used
 * together without the need to know anything
 * <p>
 * There are some pre-allocated constants for some of the most useful values like {@link #PI_RAD}
 * for an angle of π rads or {@link #V180_DEG} for an angle of 180°
 * 
 * @author alcadrial
 */
public interface Angle {
	
	/**
	 * Construct a new angle with the given value and unit
	 * 
	 * @param angle the value of the new angle in the given unit
	 * @param unit the unit of the angle
	 * 
	 * @return a new angle with float precision
	 */
	static Angle of(float angle, AngleUnit unit)
	{
		return new AngleFloat(unit, angle);
	}
	
	/**
	 * Construct a new angle with the given value and unit
	 * 
	 * @param angle the value of the new angle in the given unit
	 * @param unit the unit of the angle
	 * 
	 * @return a new angle with double precision
	 */
	static Angle of(double angle, AngleUnit unit)
	{
		return new AngleDouble(unit, angle);
	}
	
	/**
	 * Construct a new angle with the given value and unit
	 * 
	 * @param angle the value of the new angle in the given unit
	 * @param unit the unit of the angle
	 * 
	 * @return a new angle with {@link BigDecimal}'s arbitrary precision
	 */
	static Angle of(BigDecimal angle, AngleUnit unit)
	{
		return new AngleBigDecimal(unit, angle);
	}
	
	/**
	 * Construct a new angle as a copy of the given one
	 * 
	 * @param angle the value to copy
	 * 
	 * @return a copy of the given angle
	 */
	static Angle copyOf(Angle angle)
	{
		if (angle instanceof AngleFloat) return new AngleFloat(angle.getUnit(), angle.asFloat());
		if (angle instanceof AngleDouble) return new AngleDouble(angle.getUnit(), angle.asDouble());
		return new AngleBigDecimal(angle.getUnit(), angle.asBigDecimal());
	}
	
	Angle V0_RAD = of(0, AngleUnit.RADIANS);
	Angle HALF_PI_RAD = of(Math.HALF_PI, AngleUnit.RADIANS);
	Angle PI_RAD = of(Math.PI, AngleUnit.RADIANS);
	Angle NEGATIVE_HALF_PI_RAD = of(-Math.HALF_PI, AngleUnit.RADIANS);
	
	Angle V0_GRAD = of(0D, AngleUnit.GRADIANS);
	Angle V100_GRAD = of(100D, AngleUnit.GRADIANS);
	Angle V200_GRAD = of(200D, AngleUnit.GRADIANS);
	Angle V300_GRAD = of(300D, AngleUnit.GRADIANS);
	
	Angle V0_TURN = of(0D, AngleUnit.TURNS);
	Angle V0_5_TURN = of(0.5, AngleUnit.TURNS);
	Angle V1_TURN = of(1D, AngleUnit.TURNS);
	Angle V2_TURN = of(2D, AngleUnit.TURNS);
	
	Angle V0_DEG = of(0D, AngleUnit.DEGREES);
	Angle V90_DEG = of(90D, AngleUnit.DEGREES);
	Angle V180_DEG = of(180D, AngleUnit.DEGREES);
	Angle V270_DEG = of(270D, AngleUnit.DEGREES);
	
	/**
	 * Returns an angle being the sum of this and the given one
	 * 
	 * @param angle the angle to add
	 * 
	 * @return the sum of this and the given one
	 */
	Angle add(Angle angle);
	
	/**
	 * Returns an angle like this but with the value negated
	 * 
	 * @return the opposite angle
	 */
	Angle opposite();
	
	/**
	 * Returns the value of this angle
	 * 
	 * @return the value of this angle
	 */
	float asFloat();
	/**
	 * Returns the value of this angle
	 * 
	 * @return the value of this angle
	 */
	double asDouble();
	/**
	 * Returns the value of this angle
	 * 
	 * @return the value of this angle
	 */
	BigDecimal asBigDecimal();
	
	/**
	 * Convert the value of this angle to the given unit and returns it
	 * 
	 * @param unit the {@link AngleUnit} requested
	 * 
	 * @return the value in the requested unit
	 */
	float asFloat(AngleUnit unit);
	/**
	 * Convert the value of this angle to the given unit and returns it
	 * 
	 * @param unit the {@link AngleUnit} requested
	 * 
	 * @return the value in the requested unit
	 */
	double asDouble(AngleUnit unit);
	/**
	 * Convert the value of this angle to the given unit and returns it
	 * 
	 * @param unit the {@link AngleUnit} requested
	 * 
	 * @return the value in the requested unit
	 */
	BigDecimal asBigDecimal(AngleUnit unit);
	
	/**
	 * The current unit used when extracting a value using {@link #asFloat()}, {@link #asDouble()} and {@link #asBigDecimal()}
	 * 
	 * @return the current unit
	 */
	AngleUnit getUnit();
	
	/**
	 * Set the value of this angle using the current {@link AngleUnit unit}
	 * 
	 * @param value the value to set
	 */
	void setValue(float value);
	/**
	 * Set the value of this angle using the given {@link AngleUnit unit}
	 * 
	 * @param unit the {@link AngleUnit} of the value
	 * @param value the value to set
	 */
	void setValue(AngleUnit unit, float value);
	/**
	 * Set the value of this angle using the current {@link AngleUnit unit}
	 * 
	 * @param value the value to set
	 */
	void setValue(double value);
	/**
	 * Set the value of this angle using the given {@link AngleUnit unit}
	 * 
	 * @param unit the {@link AngleUnit} of the value
	 * @param value the value to set
	 */
	void setValue(AngleUnit unit, double value);
	/**
	 * Set the value of this angle using the current {@link AngleUnit unit}
	 * 
	 * @param value the value to set
	 */
	void setValue(BigDecimal value);
	/**
	 * Set the value of this angle using the given {@link AngleUnit unit}
	 * 
	 * @param unit the {@link AngleUnit} of the value
	 * @param value the value to set
	 */
	void setValue(AngleUnit unit, BigDecimal value);
}

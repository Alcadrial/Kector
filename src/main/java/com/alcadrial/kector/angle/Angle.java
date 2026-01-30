package com.alcadrial.kector.angle;

import java.math.BigDecimal;

import com.alcadrial.kector.Math;

/**
 * An interface representing an immutable angle and it's the measurement {@link AngleUnit unit}
 * that can be converted easily into other units with methods like {@link #asFloat(AngleUnit)}
 * or used in mathematical operation like {@link #add(Angle)}.
 * <p>
 * This is meant for being used when angles with different units or precision are to be used
 * together without the need to know anything.
 * <p>
 * There are some pre-allocated constants for some of the most useful values like {@link #PI_RAD}
 * for an angle of π rads or {@link #V180_DEG} for an angle of 180°.
 * 
 * @author alcadrial
 * 
 * @deprecated in favor of {@link com.alcadrial.kector.annotation.Angle @Angle} annotation
 */
@Deprecated
public interface Angle {
	
	/**
	 * Construct a new angle with the given value and unit.
	 * 
	 * @param angle the value of the new angle in the given unit
	 * @param unit the unit of the angle
	 * 
	 * @return a new angle with float precision
	 */
	@Deprecated
	static Angle of(float angle, AngleUnit unit)
	{
		return new AngleFloat(unit, angle);
	}
	
	/**
	 * Construct a new angle with the given value and unit.
	 * 
	 * @param angle the value of the new angle in the given unit
	 * @param unit the unit of the angle
	 * 
	 * @return a new angle with double precision
	 */
	@Deprecated
	static Angle of(double angle, AngleUnit unit)
	{
		return new AngleDouble(unit, angle);
	}
	
	/**
	 * Construct a new angle with the given value and unit.
	 * 
	 * @param angle the value of the new angle in the given unit
	 * @param unit the unit of the angle
	 * 
	 * @return a new angle with {@link BigDecimal}'s arbitrary precision
	 */
	@Deprecated
	static Angle of(BigDecimal angle, AngleUnit unit)
	{
		return new AngleBigDecimal(unit, angle);
	}
	
	/**
	 * Construct a new angle as a copy of the given one.
	 * 
	 * @param angle the value to copy
	 * 
	 * @return a copy of the given angle
	 */
	@Deprecated
	static Angle copyOf(Angle angle)
	{
		if (angle instanceof AngleFloat) return new AngleFloat(angle.getUnit(), angle.asFloat());
		if (angle instanceof AngleDouble) return new AngleDouble(angle.getUnit(), angle.asDouble());
		return new AngleBigDecimal(angle.getUnit(), angle.asBigDecimal());
	}
	
	/**
	 * Construct a new angle, with the given unit, as a copy of the given one.
	 * 
	 * @param angle the value to copy
	 * 
	 * @return a copy of the given angle
	 */
	@Deprecated
	static Angle copyOf(Angle angle, AngleUnit unit)
	{
		if (angle instanceof AngleFloat) return new AngleFloat(unit, angle.asFloat(unit));
		if (angle instanceof AngleDouble) return new AngleDouble(unit, angle.asDouble(unit));
		return new AngleBigDecimal(unit, angle.asBigDecimal(unit));
	}
	
	@Deprecated
	Angle NEGATIVE_HALF_PI_RAD = of(-Math.HALF_PI, AngleUnit.RADIANS);
	@Deprecated
	Angle V0_RAD = of(0, AngleUnit.RADIANS);
	@Deprecated
	Angle HALF_PI_RAD = of(Math.HALF_PI, AngleUnit.RADIANS);
	@Deprecated
	Angle PI_RAD = of(Math.PI, AngleUnit.RADIANS);
	@Deprecated
	Angle DOUBLE_PI_RAD = of(2 * Math.PI, AngleUnit.RADIANS);
	
	@Deprecated
	Angle V0_GRAD = of(0D, AngleUnit.GRADIANS);
	@Deprecated
	Angle V100_GRAD = of(100D, AngleUnit.GRADIANS);
	@Deprecated
	Angle V200_GRAD = of(200D, AngleUnit.GRADIANS);
	@Deprecated
	Angle V300_GRAD = of(300D, AngleUnit.GRADIANS);
	@Deprecated
	Angle V400_GRAD = of(400D, AngleUnit.GRADIANS);
	
	@Deprecated
	Angle V0_TURN = of(0D, AngleUnit.TURNS);
	@Deprecated
	Angle V0_5_TURN = of(0.5, AngleUnit.TURNS);
	@Deprecated
	Angle V1_TURN = of(1D, AngleUnit.TURNS);
	@Deprecated
	Angle V1_5_TURN = of(1.5, AngleUnit.TURNS);
	@Deprecated
	Angle V2_TURN = of(2D, AngleUnit.TURNS);
	
	@Deprecated
	Angle V0_DEG = of(0D, AngleUnit.DEGREES);
	@Deprecated
	Angle V90_DEG = of(90D, AngleUnit.DEGREES);
	@Deprecated
	Angle V180_DEG = of(180D, AngleUnit.DEGREES);
	@Deprecated
	Angle V270_DEG = of(270D, AngleUnit.DEGREES);
	@Deprecated
	Angle V360_DEG = of(360D, AngleUnit.DEGREES);
	
	/**
	 * Returns an angle being the sum of this and the given one.
	 * 
	 * @param a the angle to add
	 * @return the sum of this and the given one
	 */
	@Deprecated
	Angle add(Angle a);
	
	/**
	 * Returns this angle plus 0.5 turns, that is the opposite angle.
	 * 
	 * @return the opposite angle
	 */
	@Deprecated
	Angle opposite();
	
	/**
	 * Returns an angle like this but with the value negated.
	 * 
	 * @return this angle negated
	 */
	@Deprecated
	Angle negative();
	
	/**
	 * Returns the value of this angle.
	 * 
	 * @return the value of this angle
	 */
	@Deprecated
	float asFloat();
	/**
	 * Returns the value of this angle.
	 * 
	 * @return the value of this angle
	 */
	@Deprecated
	double asDouble();
	/**
	 * Returns the value of this angle.
	 * 
	 * @return the value of this angle
	 */
	@Deprecated
	BigDecimal asBigDecimal();
	
	/**
	 * Convert the value of this angle to the given unit.
	 * 
	 * @param unit the {@link AngleUnit} requested
	 * @return the value in the requested unit
	 */
	@Deprecated
	float asFloat(AngleUnit unit);
	/**
	 * Convert the value of this angle to the given unit.
	 * 
	 * @param unit the {@link AngleUnit} requested
	 * @return the value in the requested unit
	 */
	@Deprecated
	double asDouble(AngleUnit unit);
	/**
	 * Convert the value of this angle to the given unit.
	 * 
	 * @param unit the {@link AngleUnit} requested
	 * @return the value in the requested unit
	 */
	@Deprecated
	BigDecimal asBigDecimal(AngleUnit unit);
	
	/**
	 * Returns the value of this angle mapped to the unit's bounds, for example [0;2π] for RADIANS.
	 * 
	 * @return the value of this angle inside the unit's bounds
	 */
	@Deprecated
	float asFloatBounded();
	/**
	 * Returns the value of this angle mapped to the unit's bounds, for example [0;2π] for RADIANS.
	 * 
	 * @return the value of this angle inside the unit's bounds
	 */
	@Deprecated
	double asDoubleBounded();
	/**
	 * Returns the value of this angle mapped to the unit's bounds, for example [0;2π] for RADIANS.
	 * 
	 * @return the value of this angle inside the unit's bounds
	 */
	@Deprecated
	BigDecimal asBigDecimalBounded();
	/**
	 * Convert the value of this angle to the given unit and maps the value to the unit's bounds, for example [0;2π] for RADIANS.
	 * 
	 * @param unit the {@link AngleUnit} requested
	 * @return the value in the requested unit inside the unit's bounds
	 */
	@Deprecated
	float asFloatBounded(AngleUnit unit);
	/**
	 * Convert the value of this angle to the given unit and maps the value to the unit's bounds, for example [0;2π] for RADIANS.
	 * 
	 * @param unit the {@link AngleUnit} requested
	 * @return the value in the requested unit inside the unit's bounds
	 */
	@Deprecated
	double asDoubleBounded(AngleUnit unit);
	/**
	 * Convert the value of this angle to the given unit and maps the value to the unit's bounds, for example [0;2π] for RADIANS.
	 * 
	 * @param unit the {@link AngleUnit} requested
	 * @return the value in the requested unit inside the unit's bounds
	 */
	@Deprecated
	BigDecimal asBigDecimalBounded(AngleUnit unit);
	
	/**
	 * The current unit used when extracting a value using {@link #asFloat()}, {@link #asDouble()} and {@link #asBigDecimal()}.
	 * 
	 * @return the current unit
	 */
	@Deprecated
	AngleUnit getUnit();
	
	/**
	 * Set the value of this angle using the current {@link AngleUnit unit}.
	 * 
	 * @param value the value to set
	 */
	@Deprecated
	void setValue(float value);
	/**
	 * Set the value of this angle using the given {@link AngleUnit unit}.
	 * 
	 * @param unit the {@link AngleUnit} of the value
	 * @param value the value to set
	 */
	@Deprecated
	void setValue(AngleUnit unit, float value);
	/**
	 * Set the value of this angle using the current {@link AngleUnit unit}.
	 * 
	 * @param value the value to set
	 */
	@Deprecated
	void setValue(double value);
	/**
	 * Set the value of this angle using the given {@link AngleUnit unit}.
	 * 
	 * @param unit the {@link AngleUnit} of the value
	 * @param value the value to set
	 */
	@Deprecated
	void setValue(AngleUnit unit, double value);
	/**
	 * Set the value of this angle using the current {@link AngleUnit unit}.
	 * 
	 * @param value the value to set
	 */
	@Deprecated
	void setValue(BigDecimal value);
	/**
	 * Set the value of this angle using the given {@link AngleUnit unit}.
	 * 
	 * @param unit the {@link AngleUnit} of the value
	 * @param value the value to set
	 */
	@Deprecated
	void setValue(AngleUnit unit, BigDecimal value);
	
	/**
	 * Compare this angle numerically with then given one in a common {@link AngleUnit unit}, resulting in -1, 0 or 1 if this
	 * angle is less than, equal to, or greater than the given one.
	 * 
	 * @param a the angle to test
	 * @return -1, 0 or 1 if less than, equal to, or greater than in a common {@link AngleUnit unit}
	 */
	@Deprecated
	int compareTo(Angle a);
	
	/**
	 * Test whether this angle is the equal to the give one in a common {@link AngleUnit unit}.
	 * 
	 * @param a the angle to test
	 * @return True if this angle is equal to the given one in a common {@link AngleUnit unit}
	 */
	@Deprecated
	boolean equals(Angle a);
	
	/**
	 * Test whether this angle is greater than or equal to the first angle and less than the second angle in a common {@link AngleUnit unit}.
	 * 
	 * @param a the first angle value to test
	 * @param b the second angle value to test
	 * @return True if this angle value is between the first angle and the second angle in a common {@link AngleUnit unit}.
	 */
	@Deprecated
	boolean between(Angle a, Angle b);
}

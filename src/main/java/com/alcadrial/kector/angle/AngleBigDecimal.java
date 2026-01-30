package com.alcadrial.kector.angle;

import java.math.BigDecimal;

/**
 * @deprecated see {@link Angle}
 */
@Deprecated
public class AngleBigDecimal implements Angle {
	
	private AngleUnit unit;
	private BigDecimal value;
	
	@Deprecated
	public AngleBigDecimal(AngleUnit unit, BigDecimal value)
	{
		this.unit = unit;
		this.value = value;
	}
	
	@Deprecated
	@Override
	public Angle add(Angle a)
	{
		value = value.add(unit == a.getUnit() ? a.asBigDecimal() : a.asBigDecimal(unit));
		return this;
	}
	
	@Deprecated
	@Override
	public Angle opposite()
	{
		value = value.add(new BigDecimal(unit.getTurnSize() / 2));
		return this;
	}
	
	@Deprecated
	@Override
	public Angle negative()
	{
		value = value.negate();
		return this;
	}
	
	@Deprecated
	@Override
	public float asFloat()
	{
		return value.floatValue();
	}
	
	@Deprecated
	@Override
	public double asDouble()
	{
		return value.doubleValue();
	}
	
	@Deprecated
	@Override
	public BigDecimal asBigDecimal()
	{
		return value;
	}
	
	@Deprecated
	@Override
	public float asFloat(AngleUnit unit)
	{
		return unit.from(this.unit, value).floatValue();
	}
	
	@Deprecated
	@Override
	public double asDouble(AngleUnit unit)
	{
		return unit.from(this.unit, value).doubleValue();
	}
	
	@Deprecated
	@Override
	public BigDecimal asBigDecimal(AngleUnit unit)
	{
		return unit.from(this.unit, value);
	}
	
	@Deprecated
	@Override
	public float asFloatBounded()
	{
		double f = asFloat() % unit.getTurnSize();
		return (float) (f < 0 ? f + unit.getTurnSize() : f);
	}
	
	@Deprecated
	@Override
	public double asDoubleBounded()
	{
		double f = asDouble() % unit.getTurnSize();
		return f < 0 ? f + unit.getTurnSize() : f;
	}
	
	@Deprecated
	@Override
	public BigDecimal asBigDecimalBounded()
	{
		BigDecimal f = asBigDecimal();
		BigDecimal turnSize = new BigDecimal(unit.getTurnSize());
		f = f.remainder(turnSize);
		return f.signum() < 0 ? f.add(turnSize) : f;
	}
	
	@Deprecated
	@Override
	public float asFloatBounded(AngleUnit unit)
	{
		double f = asFloat(unit) % unit.getTurnSize();
		return (float) (f < 0 ? f + unit.getTurnSize() : f);
	}
	
	@Deprecated
	@Override
	public double asDoubleBounded(AngleUnit unit)
	{
		double f = asDouble(unit) % unit.getTurnSize();
		return (float) (f < 0 ? f + unit.getTurnSize() : f);
	}
	
	@Deprecated
	@Override
	public BigDecimal asBigDecimalBounded(AngleUnit unit)
	{
		BigDecimal f = asBigDecimal(unit);
		BigDecimal turnSize = new BigDecimal(unit.getTurnSize());
		f = f.remainder(turnSize);
		return f.signum() < 0 ? f.add(turnSize) : f;
	}
	
	@Deprecated
	@Override
	public AngleUnit getUnit()
	{
		return unit;
	}
	
	@Deprecated
	@Override
	public void setValue(float value)
	{
		this.value = new BigDecimal(value);
	}
	
	@Deprecated
	@Override
	public void setValue(AngleUnit unit, float value)
	{
		this.value = this.unit.from(unit, new BigDecimal(value));
	}
	
	@Deprecated
	@Override
	public void setValue(double value)
	{
		this.value = new BigDecimal(value);
	}
	
	@Deprecated
	@Override
	public void setValue(AngleUnit unit, double value)
	{
		this.value = this.unit.from(unit, new BigDecimal(value));
	}
	
	@Deprecated
	@Override
	public void setValue(BigDecimal value)
	{
		this.value = value;
	}
	
	@Deprecated
	@Override
	public void setValue(AngleUnit unit, BigDecimal value)
	{
		this.value = this.unit.from(unit, value);
	}
	
	@Deprecated
	@Override
	public boolean equals(Angle a)
	{
		return asBigDecimalBounded().equals(a.asBigDecimalBounded(unit));
	}
	
	@Deprecated
	@Override
	public int compareTo(Angle a)
	{
		return asBigDecimalBounded().compareTo(a.asBigDecimalBounded(unit));
	}
	
	@Deprecated
	@Override
	public boolean between(Angle a, Angle b)
	{
		return compareTo(a) >= 0 && compareTo(b) < 0;
	}
}

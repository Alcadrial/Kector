package com.alcadrial.kector.angle;

import java.math.BigDecimal;

public class AngleBigDecimal implements Angle {
	
	private AngleUnit unit;
	private BigDecimal value;
	
	public AngleBigDecimal(AngleUnit unit, BigDecimal value)
	{
		this.unit = unit;
		this.value = value;
	}
	
	@Override
	public Angle add(Angle a)
	{
		value = value.add(unit == a.getUnit() ? a.asBigDecimal() : a.asBigDecimal(unit));
		return this;
	}
	
	@Override
	public Angle opposite()
	{
		value = value.add(new BigDecimal(unit.getTurnSize() / 2));
		return this;
	}
	
	@Override
	public Angle negative()
	{
		value = value.negate();
		return this;
	}
	
	@Override
	public float asFloat()
	{
		return value.floatValue();
	}
	
	@Override
	public double asDouble()
	{
		return value.doubleValue();
	}
	
	@Override
	public BigDecimal asBigDecimal()
	{
		return value;
	}
	
	@Override
	public float asFloat(AngleUnit unit)
	{
		return unit.from(this.unit, value).floatValue();
	}
	
	@Override
	public double asDouble(AngleUnit unit)
	{
		return unit.from(this.unit, value).doubleValue();
	}
	
	@Override
	public BigDecimal asBigDecimal(AngleUnit unit)
	{
		return unit.from(this.unit, value);
	}
	
	@Override
	public float asFloatBounded()
	{
		double f = asFloat() % unit.getTurnSize();
		return (float) (f < 0 ? f + unit.getTurnSize() : f);
	}
	
	@Override
	public double asDoubleBounded()
	{
		double f = asDouble() % unit.getTurnSize();
		return f < 0 ? f + unit.getTurnSize() : f;
	}
	
	@Override
	public BigDecimal asBigDecimalBounded()
	{
		BigDecimal f = asBigDecimal();
		BigDecimal turnSize = new BigDecimal(unit.getTurnSize());
		f = f.remainder(turnSize);
		return f.signum() < 0 ? f.add(turnSize) : f;
	}
	
	@Override
	public float asFloatBounded(AngleUnit unit)
	{
		double f = asFloat(unit) % unit.getTurnSize();
		return (float) (f < 0 ? f + unit.getTurnSize() : f);
	}
	
	@Override
	public double asDoubleBounded(AngleUnit unit)
	{
		double f = asDouble(unit) % unit.getTurnSize();
		return (float) (f < 0 ? f + unit.getTurnSize() : f);
	}
	
	@Override
	public BigDecimal asBigDecimalBounded(AngleUnit unit)
	{
		BigDecimal f = asBigDecimal(unit);
		BigDecimal turnSize = new BigDecimal(unit.getTurnSize());
		f = f.remainder(turnSize);
		return f.signum() < 0 ? f.add(turnSize) : f;
	}
	
	@Override
	public AngleUnit getUnit()
	{
		return unit;
	}
	
	@Override
	public void setValue(float value)
	{
		this.value = new BigDecimal(value);
	}
	
	@Override
	public void setValue(AngleUnit unit, float value)
	{
		this.value = this.unit.from(unit, new BigDecimal(value));
	}
	
	@Override
	public void setValue(double value)
	{
		this.value = new BigDecimal(value);
	}
	
	@Override
	public void setValue(AngleUnit unit, double value)
	{
		this.value = this.unit.from(unit, new BigDecimal(value));
	}
	
	@Override
	public void setValue(BigDecimal value)
	{
		this.value = value;
	}
	
	@Override
	public void setValue(AngleUnit unit, BigDecimal value)
	{
		this.value = this.unit.from(unit, value);
	}
	
	@Override
	public boolean equals(Angle a)
	{
		return asBigDecimalBounded().equals(a.asBigDecimalBounded(unit));
	}
	
	@Override
	public int compareTo(Angle a)
	{
		return asBigDecimalBounded().compareTo(a.asBigDecimalBounded(unit));
	}
	
	@Override
	public boolean between(Angle a, Angle b)
	{
		return compareTo(a) >= 0 && compareTo(b) < 0;
	}
}

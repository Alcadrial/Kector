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
	public Angle add(Angle angle)
	{
		value = value.add(unit == angle.getUnit() ? angle.asBigDecimal() : angle.asBigDecimal(unit));
		return this;
	}
	
	@Override
	public Angle opposite()
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
}

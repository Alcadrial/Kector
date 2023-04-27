package com.alcadrial.kector.angle;

import java.math.BigDecimal;

public class AngleDouble implements Angle {
	
	private AngleUnit unit;
	private double value;
	
	public AngleDouble(AngleUnit unit, double value)
	{
		this.unit = unit;
		this.value = value;
	}
	
	@Override
	public Angle add(Angle angle)
	{
		value += unit == angle.getUnit() ? angle.asDouble() : angle.asDouble(unit);
		return this;
	}
	
	@Override
	public Angle opposite()
	{
		value = -value;
		return this;
	}
	
	@Override
	public float asFloat()
	{
		return (float) value;
	}
	
	@Override
	public double asDouble()
	{
		return value;
	}
	
	@Override
	public BigDecimal asBigDecimal()
	{
		return new BigDecimal(value);
	}
	
	@Override
	public float asFloat(AngleUnit unit)
	{
		return (float) unit.from(this.unit, value);
	}
	
	@Override
	public double asDouble(AngleUnit unit)
	{
		return unit.from(this.unit, value);
	}
	
	@Override
	public BigDecimal asBigDecimal(AngleUnit unit)
	{
		return unit.from(this.unit, new BigDecimal(value));
	}
	
	@Override
	public AngleUnit getUnit()
	{
		return unit;
	}
	
	@Override
	public void setValue(float value)
	{
		this.value = value;
	}
	
	@Override
	public void setValue(AngleUnit unit, float value)
	{
		this.value = this.unit.from(unit, value);
	}
	
	@Override
	public void setValue(double value)
	{
		this.value = value;
	}
	
	@Override
	public void setValue(AngleUnit unit, double value)
	{
		this.value = this.unit.from(unit, value);
	}
	
	@Override
	public void setValue(BigDecimal value)
	{
		this.value = value.doubleValue();
	}
	
	@Override
	public void setValue(AngleUnit unit, BigDecimal value)
	{
		this.value = this.unit.from(unit, value).doubleValue();
	}
}

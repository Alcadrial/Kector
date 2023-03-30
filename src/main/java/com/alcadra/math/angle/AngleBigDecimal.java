package com.alcadra.math.angle;

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
	public void setValue(AngleUnit unit, float value)
	{
		this.value = this.unit.from(unit, new BigDecimal(value));
	}
	
	@Override
	public void setValue(AngleUnit unit, double value)
	{
		this.value = this.unit.from(unit, new BigDecimal(value));
	}
	
	@Override
	public void setValue(AngleUnit unit, BigDecimal value)
	{
		this.value = this.unit.from(unit, value);
	}
}

package com.alcadra.math.angle;

import java.math.BigDecimal;

public class AngleFloat implements Angle {
	
	private AngleUnit unit;
	private float value;
	
	public AngleFloat(AngleUnit unit, float value)
	{
		this.unit = unit;
		this.value = value;
	}
	
	@Override
	public float asFloat()
	{
		return value;
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
	public void setValue(AngleUnit unit, float value)
	{
		this.value = (float) this.unit.from(unit, value);
	}
	
	@Override
	public void setValue(AngleUnit unit, double value)
	{
		this.value = (float) this.unit.from(unit, value);
	}
	
	@Override
	public void setValue(AngleUnit unit, BigDecimal value)
	{
		this.value = this.unit.from(unit, value).floatValue();
	}
}

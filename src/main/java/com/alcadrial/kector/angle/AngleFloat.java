package com.alcadrial.kector.angle;

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
	public Angle add(Angle a)
	{
		value += unit == a.getUnit() ? a.asFloat() : a.asFloat(unit);
		return this;
	}
	
	@Override
	public Angle opposite()
	{
		value += unit.getTurnSize() / 2;
		return this;
	}
	
	@Override
	public Angle negative()
	{
		value = -value;
		return this;
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
	public float asFloatBounded()
	{
		double f = value % unit.getTurnSize();
		return (float) (f < 0 ? f + unit.getTurnSize() : f);
	}
	
	@Override
	public double asDoubleBounded()
	{
		double f = value % unit.getTurnSize();
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
		return f < 0 ? f + unit.getTurnSize() : f;
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
		this.value = value;
	}
	
	@Override
	public void setValue(AngleUnit unit, float value)
	{
		this.value = (float) this.unit.from(unit, value);
	}
	
	@Override
	public void setValue(double value)
	{
		this.value = (float) value;
	}
	
	@Override
	public void setValue(AngleUnit unit, double value)
	{
		this.value = (float) this.unit.from(unit, value);
	}
	
	@Override
	public void setValue(BigDecimal value)
	{
		this.value = value.floatValue();
	}
	
	@Override
	public void setValue(AngleUnit unit, BigDecimal value)
	{
		this.value = this.unit.from(unit, value).floatValue();
	}
	
	@Override
	public boolean equals(Angle a)
	{
		return compareTo(a) == 0;
	}
	
	@Override
	public int compareTo(Angle a)
	{
		return Double.compare(asFloatBounded(), a.asDoubleBounded(unit));
	}
	
	@Override
	public boolean between(Angle a, Angle b)
	{
		return compareTo(a) >= 0 && compareTo(b) < 0;
	}
}

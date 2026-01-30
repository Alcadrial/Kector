package com.alcadrial.kector.angle;

import java.math.BigDecimal;

/**
 * @deprecated see {@link Angle}
 */
@Deprecated
public class AngleDouble implements Angle {
	
	private AngleUnit unit;
	private double value;
	
	@Deprecated
	public AngleDouble(AngleUnit unit, double value)
	{
		this.unit = unit;
		this.value = value;
	}
	
	@Deprecated
	@Override
	public Angle add(Angle angle)
	{
		value += unit == angle.getUnit() ? angle.asDouble() : angle.asDouble(unit);
		return this;
	}
	
	@Deprecated
	@Override
	public Angle opposite()
	{
		value += unit.getTurnSize() / 2;
		return this;
	}
	
	@Deprecated
	@Override
	public Angle negative()
	{
		value = -value;
		return this;
	}
	
	@Deprecated
	@Override
	public float asFloat()
	{
		return (float) value;
	}
	
	@Deprecated
	@Override
	public double asDouble()
	{
		return value;
	}
	
	@Deprecated
	@Override
	public BigDecimal asBigDecimal()
	{
		return new BigDecimal(value);
	}
	
	@Deprecated
	@Override
	public float asFloat(AngleUnit unit)
	{
		return (float) unit.from(this.unit, value);
	}
	
	@Deprecated
	@Override
	public double asDouble(AngleUnit unit)
	{
		return unit.from(this.unit, value);
	}
	
	@Deprecated
	@Override
	public BigDecimal asBigDecimal(AngleUnit unit)
	{
		return unit.from(this.unit, new BigDecimal(value));
	}
	
	@Deprecated
	@Override
	public float asFloatBounded()
	{
		double f = value % unit.getTurnSize();
		return (float) (f < 0 ? f + unit.getTurnSize() : f);
	}
	
	@Deprecated
	@Override
	public double asDoubleBounded()
	{
		double f = value % unit.getTurnSize();
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
		return f < 0 ? f + unit.getTurnSize() : f;
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
		this.value = value;
	}
	
	@Deprecated
	@Override
	public void setValue(AngleUnit unit, float value)
	{
		this.value = this.unit.from(unit, value);
	}
	
	@Deprecated
	@Override
	public void setValue(double value)
	{
		this.value = value;
	}
	
	@Deprecated
	@Override
	public void setValue(AngleUnit unit, double value)
	{
		this.value = this.unit.from(unit, value);
	}
	
	@Deprecated
	@Override
	public void setValue(BigDecimal value)
	{
		this.value = value.doubleValue();
	}
	
	@Deprecated
	@Override
	public void setValue(AngleUnit unit, BigDecimal value)
	{
		this.value = this.unit.from(unit, value).doubleValue();
	}
	
	@Deprecated
	@Override
	public boolean equals(Angle a)
	{
		return compareTo(a) == 0;
	}
	
	@Deprecated
	@Override
	public int compareTo(Angle a)
	{
		return Double.compare(asFloatBounded(), a.asDoubleBounded(unit));
	}
	
	@Deprecated
	@Override
	public boolean between(Angle a, Angle b)
	{
		return compareTo(a) >= 0 && compareTo(b) < 0;
	}
}

package com.alcadrial.kector;

import java.math.BigDecimal;

public enum AngleUnit {
	
	RADIANS(1, Math.PI / 200, Math.PI * 2, Math.PI / 180),
	GRADIANS(200 / Math.PI, 1, 400, 10 / 9),
	TURNS(0.5 / Math.PI, 0.0025, 1, 0.025 / 9),
	DEGREES(180 / Math.PI, 0.9, 360, 1);
	
	private double fromRadians;
	private double fromGradians;
	private double fromTurns;
	private double fromDegrees;
	
	AngleUnit(double fromRadians, double fromGradians, double fromTurns, double fromDegrees)
	{
		this.fromRadians = fromRadians;
		this.fromGradians = fromGradians;
		this.fromTurns = fromTurns;
		this.fromDegrees = fromDegrees;
	}
	
	public double from(AngleUnit unit, double angle)
	{
		return switch (unit)
		{
			case RADIANS -> fromRadians(angle);
			case GRADIANS -> fromGradians(angle);
			case TURNS -> fromTurns(angle);
			case DEGREES -> fromDegrees(angle);
		};
	}
	
	public BigDecimal from(AngleUnit unit, BigDecimal angle)
	{
		return switch (unit)
		{
			case RADIANS -> fromRadians(angle);
			case GRADIANS -> fromGradians(angle);
			case TURNS -> fromTurns(angle);
			case DEGREES -> fromDegrees(angle);
		};
	}
	
	public float fromRadians(float angle)
	{
		return (float) (angle * fromRadians);
	}
	
	public float fromGradians(float angle)
	{
		return (float) (angle * fromGradians);
	}
	
	public float fromTurns(float angle)
	{
		return (float) (angle * fromTurns);
	}
	
	public float fromDegrees(float angle)
	{
		return (float) (angle * fromDegrees);
	}
	
	public double fromRadians(double angle)
	{
		return angle * fromRadians;
	}
	
	public double fromGradians(double angle)
	{
		return angle * fromGradians;
	}
	
	public double fromTurns(double angle)
	{
		return angle * fromTurns;
	}
	
	public double fromDegrees(double angle)
	{
		return angle * fromDegrees;
	}
	
	public BigDecimal fromRadians(BigDecimal angle)
	{
		return angle.multiply(new BigDecimal(fromRadians));
	}
	
	public BigDecimal fromGradians(BigDecimal angle)
	{
		return angle.multiply(new BigDecimal(fromGradians));
	}
	
	public BigDecimal fromTurns(BigDecimal angle)
	{
		return angle.multiply(new BigDecimal(fromTurns));
	}
	
	public BigDecimal fromDegrees(BigDecimal angle)
	{
		return angle.multiply(new BigDecimal(fromDegrees));
	}
	
	public double getTurnSize()
	{
		return fromTurns;
	}
}

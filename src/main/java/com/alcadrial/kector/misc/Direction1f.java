package com.alcadrial.kector.misc;

public enum Direction1f {
	
	POSITIVE,
	NEGATIVE;
	
	public boolean isPositive()
	{
		return this == POSITIVE;
	}
	
	public boolean isNegative()
	{
		return this == NEGATIVE;
	}
	
	public static Direction1f of(boolean positive)
	{
		if (positive) return POSITIVE;
		return NEGATIVE;
	}
}

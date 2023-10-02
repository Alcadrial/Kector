package com.alcadrial.kector.shape.api;

public enum ImplementationSpecialization {
	
	CONSTANT,
	ANGLE;
	
	public boolean useAngle()
	{
		return this == ANGLE;
	}
	
	public boolean useConstant()
	{
		return this == CONSTANT;
	}
	
	public static ImplementationSpecialization preferConstant(ImplementationSpecialization s0, ImplementationSpecialization s1)
	{
		if (s0.useConstant() || s1.useConstant()) return CONSTANT;
		return ANGLE;
	}
}

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
}

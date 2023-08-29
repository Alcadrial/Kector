package com.alcadrial.kector.shape.api.quadrilateral;

public interface SimpleQuadrilateral2f extends Quadrilateral2f {
	
	@Override
	default boolean isSimple()
	{
		return true;
	}
	
	@Override
	default boolean isComplex()
	{
		return false;
	}
}

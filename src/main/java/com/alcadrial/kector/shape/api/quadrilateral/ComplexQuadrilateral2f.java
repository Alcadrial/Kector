package com.alcadrial.kector.shape.api.quadrilateral;

public interface ComplexQuadrilateral2f extends Quadrilateral2f {
	
	@Override
	default boolean isConvex()
	{
		return false;
	}
	
	@Override
	default boolean isConcave()
	{
		return false;
	}
	
	@Override
	default boolean isSimple()
	{
		return false;
	}
	
	@Override
	default boolean isComplex()
	{
		return true;
	}
}

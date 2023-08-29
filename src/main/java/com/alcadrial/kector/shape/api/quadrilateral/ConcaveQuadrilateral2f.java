package com.alcadrial.kector.shape.api.quadrilateral;

public interface ConcaveQuadrilateral2f extends SimpleQuadrilateral2f {
	
	@Override
	default boolean isConvex()
	{
		return false;
	}
	
	@Override
	default boolean isConcave()
	{
		return true;
	}
}

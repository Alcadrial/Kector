package com.alcadrial.kector.shape.api.quadrilateral;

public interface ConvexQuadrilateral2f extends SimpleQuadrilateral2f {
	
	@Override
	default boolean isConvex()
	{
		return true;
	}
	
	@Override
	default boolean isConcave()
	{
		return false;
	}
}

package com.alcadra.kector.vector.axis;

import com.alcadra.kector.vector.immutable.ImmutableVector2f;

/**
 * Class representing an immutable unit vector of 1 dimension
 */
public final class Axis1f extends ImmutableVector2f implements Axis {
	
	/***/
	Axis1f(float x)
	{
		super(x < 0 ? -1 : 1, 0);
	}
}
package com.alcadrial.kector.vector.axis;

import com.alcadrial.kector.vector.Vector2f;
import com.alcadrial.kector.vector.immutable.ImmutableVector2f;

/**
 * Class representing an immutable unit vector of 2 dimensions
 */
public final class Axis2f extends ImmutableVector2f implements Axis {
	
	Axis2f(float x, float y)
	{
		super(Vector2f.of(x, y).unitary());
	}
}
package com.alcadra.math.vector.axis;

import com.alcadra.math.vector.Vector4f;
import com.alcadra.math.vector.immutable.ImmutableVector4f;

/**
 * Class representing an immutable unit vector of 4 dimensions
 */
public final class Axis4f extends ImmutableVector4f implements Axis {
	
	/***/
	Axis4f(float x, float y, float z, float w)
	{
		super(Vector4f.of(x, y, z, w).unitary());
	}
}
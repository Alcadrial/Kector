package com.alcadra.math.vector.axis;

import com.alcadra.math.vector.Vector3f;
import com.alcadra.math.vector.immutable.ImmutableVector3f;

/**
 * Class representing an immutable unit vector of 3 dimensions
 */
public final class Axis3f extends ImmutableVector3f implements Axis {
	
	/***/
	Axis3f(float x, float y, float z)
	{
		super(Vector3f.of(x, y, z).unitary());
	}
}
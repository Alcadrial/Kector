package com.alcadra.math.vector.axis;

import com.alcadra.math.vector.Vector4f;

/**
 * Interface representing an immutable unit vector
 */
public sealed interface Axis extends Vector4f permits Axis1f, Axis2f, Axis3f, Axis4f {
	
	/**
	 * The X Axis {1, 0, 0, 0}
	 */
	Axis1f X = new Axis1f(1);
	/**
	 * The -X Axis {-1, 0, 0, 0}
	 */
	Axis1f NEGATIVE_X = new Axis1f(-1);
	
	/**
	 * The Y Axis {0, 1, 0, 0}
	 */
	Axis2f Y = new Axis2f(0, 1);
	
	/**
	 * The -Y Axis {0, -1, 0, 0}
	 */
	Axis2f NEGATIVE_Y = new Axis2f(0, -1);
	
	/**
	 * The Z Axis {0, 0, 1, 0}
	 */
	Axis3f Z = new Axis3f(0, 0, 1);
	
	/**
	 * The -Z Axis {0, 0, -1, 0}
	 */
	Axis3f NEGATIVE_Z = new Axis3f(0, 0, -1);
	
	/**
	 * The W Axis {0, 0, 0, 1}
	 */
	Axis4f W = new Axis4f(0, 0, 0, 1);
	
	/**
	 * The -W Axis {0, 0, 0, -1}
	 */
	Axis4f NEGATIVE_W = new Axis4f(0, 0, 0, -1);
	
	/***/
	static Axis valueOf(String name)
	{
		return switch (name.toLowerCase())
		{
			case "x" -> X;
			case "y" -> Y;
			case "z" -> Z;
			case "w" -> W;
			case "-x" -> NEGATIVE_X;
			case "-y" -> NEGATIVE_Y;
			case "-z" -> NEGATIVE_Z;
			case "-w" -> NEGATIVE_W;
			default -> null;
		};
	}
	
	/**
	 * Returns an array containing the value of every <code>Axis</code> in this interface in the order: X, -X, Y, -Y, Z, -Z, W, -W
	 * @return an array of <code>Axis</code>
	 */
	static Axis[] values()
	{
		return new Axis[] {X, NEGATIVE_X, Y, NEGATIVE_Y, Z, NEGATIVE_Z, W, NEGATIVE_W};
	}
	
	/**
	 * Returns an array containing the value of every positive <code>Axis</code> in this interface in the order: X, Y, Z, W
	 * @return an array of <code>Axis</code>
	 */
	static Axis[] positiveValues()
	{
		return new Axis[] {X, Y, Z, W};
	}
	
	/**
	 * Returns an array containing the value of every negative <code>Axis</code> in this interface in the order: -X, -Y, -Z, -W
	 * @return an array of <code>Axis</code>
	 */
	static Axis[] negativeValues()
	{
		return new Axis[] {NEGATIVE_X, NEGATIVE_Y, NEGATIVE_Z, NEGATIVE_W};
	}
}

package com.alcadrial.kector.vector.axis;

import java.util.Locale;
import org.jspecify.annotations.Nullable;
import com.alcadrial.kector.vector.AbstractVector4f;
import com.alcadrial.kector.vector.Vector4fr;

public final class Axisf {

	public static final X X = new X();
	public static final NX NEGATIVE_X = new NX();
	public static final Y Y = new Y();
	public static final NY NEGATIVE_Y = new NY();
	public static final Z Z = new Z();
	public static final NZ NEGATIVE_Z = new NZ();
	public static final W W = new W();
	public static final NW NEGATIVE_W = new NW();
	
	static @Nullable Vector4fr valueOf(String name)
	{
		return switch (name.toLowerCase(Locale.ROOT))
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
	 *
	 * @return an array of <code>Axis</code>
	 */
	static Vector4fr[] values()
	{
		return new Vector4fr[] {X, NEGATIVE_X, Y, NEGATIVE_Y, Z, NEGATIVE_Z, W, NEGATIVE_W};
	}
	
	/**
	 * Returns an array containing the value of every positive <code>Axis</code> in this interface in the order: X, Y, Z, W
	 *
	 * @return an array of <code>Axis</code>
	 */
	static Vector4fr[] positiveValues()
	{
		return new Vector4fr[] {X, Y, Z, W};
	}
	
	/**
	 * Returns an array containing the value of every negative <code>Axis</code> in this interface in the order: -X, -Y, -Z, -W
	 *
	 * @return an array of <code>Axis</code>
	 */
	static Vector4fr[] negativeValues()
	{
		return new Vector4fr[] {NEGATIVE_X, NEGATIVE_Y, NEGATIVE_Z, NEGATIVE_W};
	}

	public static final class X extends AbstractVector4f implements Vector4fr {
	
		@Override
		public float x()
		{
			return 1;
		}
		@Override
		public float y()
		{
			return 0;
		}
		@Override
		public float z()
		{
			return 0;
		}
		@Override
		public float w()
		{
			return 0;
		}
		public String toString()
		{
			return "Axis{X}";
		}
	}
	public static final class NX extends AbstractVector4f implements Vector4fr {
	
		@Override
		public float x()
		{
			return -1;
		}
		@Override
		public float y()
		{
			return 0;
		}
		@Override
		public float z()
		{
			return 0;
		}
		@Override
		public float w()
		{
			return 0;
		}
		public String toString()
		{
			return "Axis{-X}";
		}
	}
	public static final class Y extends AbstractVector4f implements Vector4fr {
	
		@Override
		public float x()
		{
			return 0;
		}
		@Override
		public float y()
		{
			return 1;
		}
		@Override
		public float z()
		{
			return 0;
		}
		@Override
		public float w()
		{
			return 0;
		}
		public String toString()
		{
			return "Axis{Y}";
		}
	}
	public static final class NY extends AbstractVector4f implements Vector4fr {
	
		@Override
		public float x()
		{
			return 0;
		}
		@Override
		public float y()
		{
			return -1;
		}
		@Override
		public float z()
		{
			return 0;
		}
		@Override
		public float w()
		{
			return 0;
		}
		public String toString()
		{
			return "Axis{-Y}";
		}
	}
	public static final class Z extends AbstractVector4f implements Vector4fr {
	
		@Override
		public float x()
		{
			return 0;
		}
		@Override
		public float y()
		{
			return 0;
		}
		@Override
		public float z()
		{
			return 1;
		}
		@Override
		public float w()
		{
			return 0;
		}
		public String toString()
		{
			return "Axis{Z}";
		}
	}
	public static final class NZ extends AbstractVector4f implements Vector4fr {
	
		@Override
		public float x()
		{
			return 0;
		}
		@Override
		public float y()
		{
			return 0;
		}
		@Override
		public float z()
		{
			return -1;
		}
		@Override
		public float w()
		{
			return 0;
		}
		public String toString()
		{
			return "Axis{-Z}";
		}
	}
	public static final class W extends AbstractVector4f implements Vector4fr {
	
		@Override
		public float x()
		{
			return 0;
		}
		@Override
		public float y()
		{
			return 0;
		}
		@Override
		public float z()
		{
			return 0;
		}
		@Override
		public float w()
		{
			return 1;
		}
		public String toString()
		{
			return "Axis{W}";
		}
	}
	public static final class NW extends AbstractVector4f implements Vector4fr {
	
		@Override
		public float x()
		{
			return 0;
		}
		@Override
		public float y()
		{
			return 0;
		}
		@Override
		public float z()
		{
			return 0;
		}
		@Override
		public float w()
		{
			return -1;
		}
		public String toString()
		{
			return "Axis{-W}";
		}
	}
}
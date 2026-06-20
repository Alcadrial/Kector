package com.alcadrial.kector.vector.axis;

import java.util.Locale;
import org.jspecify.annotations.Nullable;
import com.alcadrial.kector.vector.AbstractVector4i;
import com.alcadrial.kector.vector.Vector4ir;

public final class Axisi {

	public static final X X = new X();
	public static final NX NEGATIVE_X = new NX();
	public static final Y Y = new Y();
	public static final NY NEGATIVE_Y = new NY();
	public static final Z Z = new Z();
	public static final NZ NEGATIVE_Z = new NZ();
	public static final W W = new W();
	public static final NW NEGATIVE_W = new NW();
	
	static @Nullable Vector4ir valueOf(String name)
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
	static Vector4ir[] values()
	{
		return new Vector4ir[] {X, NEGATIVE_X, Y, NEGATIVE_Y, Z, NEGATIVE_Z, W, NEGATIVE_W};
	}
	
	/**
	 * Returns an array containing the value of every positive <code>Axis</code> in this interface in the order: X, Y, Z, W
	 *
	 * @return an array of <code>Axis</code>
	 */
	static Vector4ir[] positiveValues()
	{
		return new Vector4ir[] {X, Y, Z, W};
	}
	
	/**
	 * Returns an array containing the value of every negative <code>Axis</code> in this interface in the order: -X, -Y, -Z, -W
	 *
	 * @return an array of <code>Axis</code>
	 */
	static Vector4ir[] negativeValues()
	{
		return new Vector4ir[] {NEGATIVE_X, NEGATIVE_Y, NEGATIVE_Z, NEGATIVE_W};
	}

	public static final class X extends AbstractVector4i implements Vector4ir {
	
		@Override
		public int x()
		{
			return 1;
		}
		@Override
		public int y()
		{
			return 0;
		}
		@Override
		public int z()
		{
			return 0;
		}
		@Override
		public int w()
		{
			return 0;
		}
	}
	public static final class NX extends AbstractVector4i implements Vector4ir {
	
		@Override
		public int x()
		{
			return -1;
		}
		@Override
		public int y()
		{
			return 0;
		}
		@Override
		public int z()
		{
			return 0;
		}
		@Override
		public int w()
		{
			return 0;
		}
	}
	public static final class Y extends AbstractVector4i implements Vector4ir {
	
		@Override
		public int x()
		{
			return 0;
		}
		@Override
		public int y()
		{
			return 1;
		}
		@Override
		public int z()
		{
			return 0;
		}
		@Override
		public int w()
		{
			return 0;
		}
	}
	public static final class NY extends AbstractVector4i implements Vector4ir {
	
		@Override
		public int x()
		{
			return 0;
		}
		@Override
		public int y()
		{
			return -1;
		}
		@Override
		public int z()
		{
			return 0;
		}
		@Override
		public int w()
		{
			return 0;
		}
	}
	public static final class Z extends AbstractVector4i implements Vector4ir {
	
		@Override
		public int x()
		{
			return 0;
		}
		@Override
		public int y()
		{
			return 0;
		}
		@Override
		public int z()
		{
			return 1;
		}
		@Override
		public int w()
		{
			return 0;
		}
	}
	public static final class NZ extends AbstractVector4i implements Vector4ir {
	
		@Override
		public int x()
		{
			return 0;
		}
		@Override
		public int y()
		{
			return 0;
		}
		@Override
		public int z()
		{
			return -1;
		}
		@Override
		public int w()
		{
			return 0;
		}
	}
	public static final class W extends AbstractVector4i implements Vector4ir {
	
		@Override
		public int x()
		{
			return 0;
		}
		@Override
		public int y()
		{
			return 0;
		}
		@Override
		public int z()
		{
			return 0;
		}
		@Override
		public int w()
		{
			return 1;
		}
	}
	public static final class NW extends AbstractVector4i implements Vector4ir {
	
		@Override
		public int x()
		{
			return 0;
		}
		@Override
		public int y()
		{
			return 0;
		}
		@Override
		public int z()
		{
			return 0;
		}
		@Override
		public int w()
		{
			return -1;
		}
	}
}
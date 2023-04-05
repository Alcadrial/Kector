package com.alcadrial.kector.test;

import com.alcadrial.kector.Math;
import com.alcadrial.kector.angle.AngleUnit;
import com.alcadrial.kector.shape.CubedShape;
import com.alcadrial.kector.vector.Vector2f;
import com.alcadrial.kector.vector.Vector3f;
import com.alcadrial.kector.vector.axis.Axis;
import com.alcadrial.kector.vector.complex.Complex;
import com.alcadrial.kector.vector.complex.Quaternion;

public class Launch {
	
	private static String blocks = "";
	
	public static void main(String[] args)
	{
		Vector3f start = Vector3f.of(5, 10, 0);
		Vector3f end = Vector3f.of(22, 15, 0);
		
		startBlock("Interpolation Test");
		{
			float a = 100;
			float b = 400;
			startBlock("Linear Interpolation");
			for (float i = 0; i <= 1; i += 0.125F) println("delta=" + i + " Result[" + a + "; " + b + "]=" + Math.interpolation(a, b, i, x -> x));
			endBlock();
			
			startBlock("Anti-Linear Interpolation");
			for (float i = 0; i <= 1; i += 0.125F) println("delta=" + i + " Result[" + a + "; " + b + "]=" + Math.interpolation(a, b, i, x -> 1 - x));
			endBlock();
			
			startBlock("Cosine Interpolation");
			for (float i = 0; i <= 1; i += 0.125F) println("delta=" + i + " Result[" + a + "; " + b + "]=" + Math.interpolation(a, b, i, x -> Math.cos(x * Math.PIF / 2)));
			endBlock();
			
			startBlock("Default Cosine Interpolation");
			for (float i = 0; i <= 1; i += 0.125F) println("delta=" + i + " Result[" + a + "; " + b + "]=" + Math.cosineInterpolation(a, b, i));
			endBlock();
			
			startBlock("Sine Interpolation");
			for (float i = 0; i <= 1; i += 0.125F) println("delta=" + i + " Result[" + a + "; " + b + "]=" + Math.interpolation(a, b, i, x -> Math.sin(x * Math.PIF / 2)));
			endBlock();
			
			startBlock("Square Interpolation");
			for (float i = 0; i <= 1; i += 0.125F) println("delta=" + i + " Result[" + a + "; " + b + "]=" + Math.interpolation(a, b, i, x -> x * x));
			endBlock();
			
			startBlock("Square Cosine Interpolation");
			for (float i = 0; i <= 1; i += 0.125F) println("delta=" + i + " Result[" + a + "; " + b + "]=" + Math.interpolation(a, b, i, x -> {
				double c = Math.cos(AngleUnit.RADIANS.fromTurns(x / 4D));
				return (float) (c * c);
			}));
			endBlock();
			
			startBlock("Cosine Square Interpolation");
			for (float i = 0; i <= 1; i += 0.125F) println("delta=" + i + " Result[" + a + "; " + b + "]=" + Math.interpolation(a, b, i, x -> (float) Math.cos(AngleUnit.RADIANS.fromTurns(x * x / 4D))));
			endBlock();
		}
		endBlock();
		startBlock("Shape Test");
		{
			Vector3f direction = Vector3f.of(65, 150, 0);
			CubedShape cubedShape = new CubedShape(start, end, direction);
			Vector3f ry = direction.crossProduct(Axis.X);
			Vector3f rx = ry.crossProduct(Axis.Z);
			
			Vector3f dimension = end.xyz().subtract(start);
			Vector3f rDimension = new Complex(dimension.xy()).multiply(new Complex(direction.xy())).multiply(new Complex(Axis.X));
			
			println("f°=" + toExternedRad(AngleUnit.RADIANS, angles(ry, null)).x() + "π");
			println("d°=" + toExternedRad(AngleUnit.RADIANS, angles(dimension.xyz().unitary(), null)).x() + "π");
			println("y'=" + ry);
			println("y'°=" + toExternedRad(AngleUnit.RADIANS, angles(ry, null)).x() + "π");
			println("x'=" + rx);
			println("x'°=" + toExternedRad(AngleUnit.RADIANS, angles(rx, null)).x() + "π");
			println("d'=" + rDimension);
			println("d'°=" + toExternedRad(AngleUnit.RADIANS, angles(rDimension.xyz().unitary(), null)).x() + "π");
			
			println(cubedShape.getEnclosingCube());
		}
		endBlock();
		startBlock("Quaternion Test");
		{
			Quaternion q = new Quaternion(0, 1, 0, 0);
			Quaternion r = Quaternion.X_HALF;
			println(q);
			println(r);
			println(q.multiply(r));
			println(r.multiply(q));
			quaternionTest0(Vector3f.of(0, 0, 0), q, r);
			quaternionTest0(Vector3f.of(2, 0, 0), q, r);
			quaternionTest0(Vector3f.of(0, 2, 0), q, r);
			quaternionTest0(Vector3f.of(2, 2, 0), q, r);
			quaternionTest0(Vector3f.of(0, 0, 2), q, r);
			quaternionTest0(Vector3f.of(2, 0, 2), q, r);
			quaternionTest0(Vector3f.of(0, 2, 2), q, r);
			quaternionTest0(Vector3f.of(2, 2, 2), q, r);
		}
		endBlock();
	}
	
	public static void quaternionTest0(Vector3f v, Quaternion q, Quaternion r)
	{
		startBlock();
		println(v);
		println(q.rotate(v));
		println(r.rotate(v));
		endBlock();
	}
	
	public static Vector2f toDegrees(AngleUnit unit, Vector2f v)
	{
		return Vector2f.of((float) AngleUnit.DEGREES.from(unit, v.x()), (float) AngleUnit.DEGREES.from(unit, v.y()));
	}
	
	public static Vector2f toRad(AngleUnit unit, Vector2f v)
	{
		return Vector2f.of((float) AngleUnit.RADIANS.from(unit, v.x()), (float) AngleUnit.RADIANS.from(unit, v.y()));
	}
	
	public static Vector2f toExternedRad(AngleUnit unit, Vector2f v)
	{
		return Vector2f.of((float) AngleUnit.RADIANS.from(unit, v.x() / Math.PI), (float) (AngleUnit.RADIANS.from(unit, v.y()) / Math.PI));
	}
	
	public static Vector2f angles(Vector3f v, Axis a)
	{
		return Vector2f.of((float) Math.asin(v.y()) * (v.y() < 0 ? -1 : 1), (float) Math.asin(v.z()) * (v.z() < 0 ? -1 : 1));
	}
	
	public static void startBlock()
	{
		println("{");
		blocks += '\t';
	}
	
	public static void startBlock(String name)
	{
		println(name + " {");
		blocks += '\t';
	}
	
	public static void println(Object object)
	{
		System.out.println(blocks + object);
	}
	
	public static void endBlock()
	{
		blocks = blocks.substring(0, blocks.length() - 1);
		println("}");
	}
}

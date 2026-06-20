package com.alcadrial.kector;

import com.alcadrial.kector.shape.CubedShape;
import com.alcadrial.kector.vector.Vector2f;
import com.alcadrial.kector.vector.Vector2fr;
import com.alcadrial.kector.vector.Vector3f;
import com.alcadrial.kector.vector.Vector3fr;
import com.alcadrial.kector.vector.axis.Axisi;
import com.alcadrial.kector.vector.quaternion.Quaternionf;
import com.alcadrial.kector.vector.quaternion.Quaternionfr;

public class Launch {
	
	private static String blocks = "";
	
	public static void main(String[] args)
	{
		Vector3fr start = Vector3fr.of(5, 10, 0);
		Vector3fr end = Vector3fr.of(22, 15, 1);
		
		startBlock("Interpolation Test");
		{
			float a = 100;
			float b = 400;
			startBlock("Linear Interpolation");
			for (float i = 0; i <= 1; i += 0.125F) println("delta=" + i + " Result[" + a + "; " + b + "]=" + Math.interpolation(a, b, i, x -> x));
			endBlock();
			
			startBlock("Cosine Interpolation");
			for (float i = 0; i <= 1; i += 0.125F) println("delta=" + i + " Result[" + a + "; " + b + "]=" + Math.interpolation(a, b, i, x -> 1 - Math.cos(x * Math.PIF / 2)));
			endBlock();
			
			startBlock("Default Cosine Interpolation");
			for (float i = 0; i <= 1; i += 0.125F) println("delta=" + i + " Result[" + a + "; " + b + "]=" + Math.cosineInterpolation(a, b, i));
			endBlock();
			
			startBlock("Half Cosine Interpolation");
			for (float i = 0; i <= 1; i += 0.125F) println("delta=" + i + " Result[" + a + "; " + b + "]=" + Math.halfCosineInterpolation(a, b, i));
			endBlock();
			
			startBlock("Sine Interpolation");
			for (float i = 0; i <= 1; i += 0.125F) println("delta=" + i + " Result[" + a + "; " + b + "]=" + Math.interpolation(a, b, i, x -> Math.sin(x * Math.PIF / 2)));
			endBlock();
			
			startBlock("Inverse Interpolation");
			for (float i = 0; i <= 1; i += 0.125F) println("delta=" + i + " Result[" + a + "; " + b + "]=" + Math.interpolation(a, b, i, x -> x / (2 - x)));
			endBlock();
			
			startBlock("Square Interpolation");
			for (float i = 0; i <= 1; i += 0.125F) println("delta=" + i + " Result[" + a + "; " + b + "]=" + Math.interpolation(a, b, i, x -> x * x));
			endBlock();
			
			startBlock("Square Cosine Interpolation");
			for (float i = 0; i <= 1; i += 0.125F) println("delta=" + i + " Result[" + a + "; " + b + "]=" + Math.interpolation(a, b, i, x -> {
				double c = 1 - Math.cos(AngleUnit.RADIANS.fromTurns(x / 4D));
				return (float) (c * c);
			}));
			endBlock();
			
			startBlock("Cosine Square Interpolation");
			for (float i = 0; i <= 1; i += 0.125F) println("delta=" + i + " Result[" + a + "; " + b + "]=" + Math.interpolation(a, b, i, x -> 1 - (float) Math.cos(AngleUnit.RADIANS.fromTurns(x * x / 4D))));
			endBlock();
			
			startBlock("Logarithmic Interpolation");
			for (float i = 0; i <= 1; i += 0.125F) println("delta=" + i + " Result[" + a + "; " + b + "]=" + Math.interpolation(a, b, i, x -> (float) Math.log(x * (Math.E - 1) + 1)));
			endBlock();
		}
		endBlock();
		startBlock("Quaternion Test");
		{
			Quaternionf q = Quaternionf.ofAxis(Axisi.Y, Math.HALF_PIF / 3);
			Quaternionf r = Quaternionf.ofAxis(Axisi.X, Math.HALF_PIF / 3);
			println(q);
			println(r);
			println(q.length());
			println(r.length());
			println(q.multiply(r));
			println(r.multiply(q));
			println(q.multiply(r).length());
			println(r.multiply(q).length());
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
		startBlock("Shape Test");
		{
			Quaternionf rotation = Quaternionf.ofAxis(Axisi.Z, Math.HALF_PIF / 2);
			CubedShape cubedShape = new CubedShape(start, Vector3f.of(end).subtract(start), rotation);

			println("Start: " + start);
			println("End: " + end);
			println("Size: " + cubedShape.getSize());
			startBlock("Vertices");
			for (Vector3fr vertex : cubedShape.getVertices()) println(vertex);
			endBlock();
			
			println("Enclosing cube: " + cubedShape.getEnclosingCube());
		}
		endBlock();
	}
	
	private static void quaternionTest0(Vector3fr v, Quaternionfr q, Quaternionfr r)
	{
		startBlock();
		println(v);
		println(q.rotate(Vector3f.of(v)) + " " + q.rotate(Vector3f.of(v)).length());
		println(r.rotate(Vector3f.of(v)) + " " + r.rotate(Vector3f.of(v)).length());
		endBlock();
	}
	
	public static Vector2f toDegrees(AngleUnit unit, Vector2fr v)
	{
		return Vector2f.of((float) AngleUnit.DEGREES.from(unit, v.x()), (float) AngleUnit.DEGREES.from(unit, v.y()));
	}
	
	public static Vector2f toRad(AngleUnit unit, Vector2fr v)
	{
		return Vector2f.of((float) AngleUnit.RADIANS.from(unit, v.x()), (float) AngleUnit.RADIANS.from(unit, v.y()));
	}
	
	public static Vector2f toExternedRad(AngleUnit unit, Vector2fr v)
	{
		return Vector2f.of((float) AngleUnit.RADIANS.from(unit, v.x() / Math.PI), (float) (AngleUnit.RADIANS.from(unit, v.y()) / Math.PI));
	}
	
	public static Vector2f angles(Vector3fr v, Axisi a)
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

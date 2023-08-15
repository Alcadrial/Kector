package com.alcadrial.kector.test;

import com.alcadrial.kector.Math;
import com.alcadrial.kector.angle.AngleUnit;
import com.alcadrial.kector.function.one.Function1f;
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
		startBlock("Shape Test");
		{
			Vector3f direction = Vector3f.of(65, 150, 0);
			CubedShape cubedShape = new CubedShape(start, end, direction);
			Vector3f ry = direction.crossProduct(Axis.X);
			Vector3f rx = ry.crossProduct(Axis.Z);
			
			Vector3f dimension = end.xyz().subtract(start);
			Vector3f rDimension = Complex.of(dimension.xy()).multiply(Complex.of(direction.xy())).multiply(Complex.of(Axis.X)).asVector();
			
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
		startBlock("Functions Test");
		{
			startBlock("1->1 Test");
			{
				startBlock("parabolic Test");
				{
					for (int i = -1; i < 2; i++)
					{
						for (int j = -1; j < 2; j++)
						{
							for (int k = -1; k < 2; k++)
							{
								parabolicTest(i, j, k);
								parabolicTest(2 * i, 2 * j, 2 * k);
							}
						}
					}
				}
				endBlock();
				
				startBlock("exponential Test");
				{
					Function1f f = Function1f.ofExponential();
					Function1f fd = f.derivate();
					Function1f fdd = fd.derivate();
					println(f + " " + fd + " " + fdd);
					f = Function1f.ofMultiplication(Function1f.ofExponential(), Function1f.ofIdentity());
					fd = f.derivate();
					fdd = fd.derivate();
					println(f + " " + fd + " " + fdd);
				}
				endBlock();
				startBlock("exponential nest Test");
				{
					Function1f f = Function1f.ofFunction(Function1f.ofExponential(), Function1f.ofAddition(Function1f.ofExponential(), Function1f.ofLinear(-1, 0)));
					Function1f fd = f.derivate();
					Function1f fdd = fd.derivate();
					Function1f fddd = fdd.derivate();
					println(f);
					println(fd);
					println(fdd);
					println(fddd);
				}
				endBlock();
				startBlock("logarithm Test");
				{
					Function1f f = Function1f.ofLn();
					Function1f fd = f.derivate();
					Function1f fdd = fd.derivate();
					println(f + " " + fd + " " + fdd);
					f = Function1f.ofMultiplication(Function1f.ofLn(), Function1f.ofIdentity());
					fd = f.derivate();
					fdd = fd.derivate();
					println(f + " " + fd + " " + fdd);
				}
				endBlock();
			}
			endBlock();
			startBlock("1->3 Test");
			{
				
			}
			endBlock();
			startBlock("3->3 Test");
			{
				
			}
			endBlock();
		}
		endBlock();
	}
	
	private static Function1f movementFunction(float a, float b, float c)
	{
		return Function1f.ofAddition(Function1f.ofMonomial(a, 2), Function1f.ofLinear(b, c));
	}
	
	private static void parabolicTest(float a, float b, float c)
	{
		Function1f f = movementFunction(a, b, c);
		Function1f fd = f.derivate();
		Function1f fdd = fd.derivate();
		println(f + " " + fd + " " + fdd);
	}
	
	private static void quaternionTest0(Vector3f v, Quaternion q, Quaternion r)
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

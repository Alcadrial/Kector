package com.alcadrial.kector;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.alcadrial.kector.angle.AngleUnit;
import com.alcadrial.kector.matrix.Matrix4f;
import com.alcadrial.kector.shape.OrthoShape;
import com.alcadrial.kector.vector.Vector2f;
import com.alcadrial.kector.vector.Vector3f;
import com.alcadrial.kector.vector.Vector3i;
import com.alcadrial.kector.vector.Vector4f;
import com.alcadrial.kector.vector.axis.Axis;

class Matrix4fTest {
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception
	{}
	
	@AfterAll
	static void tearDownAfterClass() throws Exception
	{}
	
	@BeforeEach
	void setUp() throws Exception
	{}
	
	@AfterEach
	void tearDown() throws Exception
	{}
	
	private static final float[] IDENTITY_ARRAY = new float[] {1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1};
	private static final Vector4f X = Vector4f.ofImmutable(1, 0, 0, 1);
	private static final Vector4f Y = Vector4f.ofImmutable(0, 1, 0, 1);
	private static final Vector4f Z = Vector4f.ofImmutable(0, 0, 1, 1);
	private static final Vector4f NEGATIVE_X = Vector4f.ofImmutable(-1, 0, 0, 1);
	private static final Vector4f NEGATIVE_Y = Vector4f.ofImmutable(0, -1, 0, 1);
	private static final Vector4f NEGATIVE_Z = Vector4f.ofImmutable(0, 0, -1, 1);
	private static final Vector4f ZERO = Vector4f.ofImmutable(0, 0, 0, 1);
	
	public static void assertAtInfinity(Vector4f actual)
	{
		assertTrue(Math.looseEquals(actual.w(), 0));
	}
	
	public static void assertEquivalent(Vector4f expected, Vector4f actual)
	{
		Vector4f v = Vector4f.copyOf(expected);
		Vector4f w = Vector4f.copyOf(actual);
		if (v.equals(Vector4f.origin())) fail("expected value is not a projective point");
		if (w.equals(Vector4f.origin())) fail("expected: <" + v + "> but was: <" + w + ">");
		if (Math.looseEquals(v.w(), 0) != Math.looseEquals(w.w(), 0)) fail("expected: <" + v + "> but was: <" + w + ">");
		if (Math.looseEquals(v.w(), 0))
		{
			if (Math.looseEquals(v.z(), 0) != Math.looseEquals(w.z(), 0)) fail("expected: <" + v + "> but was: <" + w + ">");
			if (Math.looseEquals(v.z(), 0))
			{
				if (Math.looseEquals(v.y(), 0) != Math.looseEquals(w.y(), 0)) fail("expected: <" + v + "> but was: <" + w + ">");
				if (Math.looseEquals(v.y(), 0)) return;
				assertEquals(v.divideAll(v.y()), w.divideAll(w.y()));
			}
			assertEquals(v.divideAll(v.z()), w.divideAll(w.z()));
		}
		assertEquals(v.divideAll(v.w()), w.divideAll(w.w()));
	}
	
	@Test
	final void testMatrix4f()
	{
		Matrix4f matrix = new Matrix4f();
		assertArrayEquals(IDENTITY_ARRAY, matrix.toArray());
	}
	
	@Test
	final void testMatrix4fFloatArrayArray()
	{
		Matrix4f matrix = new Matrix4f(new float[][] {
			{1, 2, 3, 4},
			{1, 3, 5, 7},
			{11, 12, 5, 1},
			{67, 14, 86, 12}
		});
		assertArrayEquals(new float[] {1, 2, 3, 4, 1, 3, 5, 7, 11, 12, 5, 1, 67, 14, 86, 12}, matrix.toArray());
	}
	
	@Test
	final void testMatrix4fMatrix4f()
	{
		Matrix4f matrix0 = new Matrix4f(new float[][] {
			{1, 2, 3, 4},
			{1, 3, 5, 7},
			{11, 12, 5, 1},
			{67, 14, 86, 12}
		});
		Matrix4f matrix = new Matrix4f(matrix0);
		assertArrayEquals(new float[] {1, 2, 3, 4, 1, 3, 5, 7, 11, 12, 5, 1, 67, 14, 86, 12}, matrix.toArray());
	}
	
	@Test
	final void testIdentity()
	{
		Matrix4f matrix = new Matrix4f(new float[][] {
			{1, 2, 3, 4},
			{1, 3, 5, 7},
			{11, 12, 5, 1},
			{67, 14, 86, 12}
		});
		matrix.identity();
		assertArrayEquals(IDENTITY_ARRAY, matrix.toArray());
	}
	
	@Test
	final void testOrthographicPositive()
	{
		Matrix4f matrix = new Matrix4f();
		matrix.orthographicPositive(11, 17);
		Matrix4f expected = new Matrix4f();
		expected.orthographic(OrthoShape.byEnd(Vector3f.of(0, 0, 0), Vector3f.of(11, 17, 100)));
		assertEquals(expected, matrix);
	}
	
	@Test
	final void testOrthographicFloatFloat()
	{
		Matrix4f matrix = new Matrix4f();
		matrix.orthographic(11, 17);
		Matrix4f expected = new Matrix4f();
		expected.orthographic(OrthoShape.byEnd(Vector3f.of(-11F / 2, -17F / 2, 0), Vector3f.of(11F / 2, 17F / 2, 100)));
		assertEquals(expected, matrix);
	}
	
	@Test
	final void testOrthographicFloatFloatFloat()
	{
		Matrix4f matrix = new Matrix4f();
		matrix.orthographic(11, 17, 23);
		Matrix4f expected = new Matrix4f();
		expected.orthographic(OrthoShape.byEnd(Vector3f.of(-11F / 2, -17F / 2, -23F / 2), Vector3f.of(11F / 2, 17F / 2, 23F / 2)));
		assertEquals(expected, matrix);
	}
	
	@Test
	final void testOrthographicOrthoShape()
	{
		Matrix4f matrix = new Matrix4f();
		matrix.orthographic(OrthoShape.byEnd(Vector3f.of(2, 3, 5), Vector3f.of(11, 13, 17)));
		
		assertEquals(Vector4f.of(-1, -1, 1, 1), matrix.multiply(Vector4f.of(2, 3, 5, 1)));
		assertEquals(Vector4f.of(-1, -1, -1, 1), matrix.multiply(Vector4f.of(2, 3, 17, 1)));
		assertEquals(Vector4f.of(-1, 1, 1, 1), matrix.multiply(Vector4f.of(2, 13, 5, 1)));
		assertEquals(Vector4f.of(-1, 1, -1, 1), matrix.multiply(Vector4f.of(2, 13, 17, 1)));
		assertEquals(Vector4f.of(1, -1, 1, 1), matrix.multiply(Vector4f.of(11, 3, 5, 1)));
		assertEquals(Vector4f.of(1, -1, -1, 1), matrix.multiply(Vector4f.of(11, 3, 17, 1)));
		assertEquals(Vector4f.of(1, 1, 1, 1), matrix.multiply(Vector4f.of(11, 13, 5, 1)));
		assertEquals(Vector4f.of(1, 1, -1, 1), matrix.multiply(Vector4f.of(11, 13, 17, 1)));
		assertEquals(ZERO, matrix.multiply(Vector4f.of(13F / 2, 8, 11, 1)));
	}
	
	@Test
	final void testPlane()
	{
		Matrix4f matrix = new Matrix4f();
		matrix.plane(11, 17);
		Matrix4f expected = new Matrix4f();
		expected.orthographic(OrthoShape.bySize(Vector3f.of(-11F / 2, -17F / 2, -1), Vector3f.of(11, 17, 2)));
		assertEquals(expected, matrix);
	}
	
	@Test
	final void testCursorFloatFloatVector2f()
	{
		Matrix4f matrix = new Matrix4f();
		matrix.cursor(11, 17, Vector2f.of(2, 3));
		Matrix4f expected = new Matrix4f();
		expected.cursor(11, 17, 2, 3);
		assertEquals(expected, matrix);
	}
	
	@Test
	final void testCursorFloatFloatFloatFloat()
	{
		Matrix4f matrix = new Matrix4f();
		matrix.cursor(11, 17, 2, 3);
		Matrix4f expected = new Matrix4f();
		expected.orthographic(OrthoShape.bySize(Vector3f.of(-11F / 2, -17F / 2, -1), Vector3f.of(11, 17, 2)));
		expected.multiply(new Matrix4f().translate(Vector3f.of(-2, -3, 0)));
		assertEquals(expected, matrix);
	}
	
	@Test
	final void testProject()
	{
		Matrix4f matrix = new Matrix4f();
		matrix.project(AngleUnit.RADIANS.fromDegrees(120), 10, 1, 3);
		float minDepth = 1;
		float maxDepth = 10;
		float halfWidth = Math.tan(AngleUnit.RADIANS.fromDegrees(120));
		float halfHeight = halfWidth / 3;
		
		assertEquivalent(Vector4f.of(-1, 0, 1, 1), matrix.multiply(Vector4f.of(halfWidth * maxDepth, 0, -maxDepth, 1)));
		assertEquivalent(Vector4f.of(1, 0, 1, 1), matrix.multiply(Vector4f.of(-halfWidth * maxDepth, 0, -maxDepth, 1)));
		assertEquivalent(Vector4f.of(0, -1, 1, 1), matrix.multiply(Vector4f.of(0, halfHeight * maxDepth, -maxDepth, 1)));
		assertEquivalent(Vector4f.of(0, 1, 1, 1), matrix.multiply(Vector4f.of(0, -halfHeight * maxDepth, -maxDepth, 1)));
		assertEquivalent(Vector4f.of(-1, 0, -1, 1), matrix.multiply(Vector4f.of(halfWidth * minDepth, 0, -minDepth, 1)));
		assertEquivalent(Vector4f.of(1, 0, -1, 1), matrix.multiply(Vector4f.of(-halfWidth * minDepth, 0, -minDepth, 1)));
		assertEquivalent(Vector4f.of(0, -1, -1, 1), matrix.multiply(Vector4f.of(0, halfHeight * minDepth, -minDepth, 1)));
		assertEquivalent(Vector4f.of(0, 1, -1, 1), matrix.multiply(Vector4f.of(0, -halfHeight * minDepth, -minDepth, 1)));
		assertAtInfinity(matrix.multiply(ZERO));
	}
	
	@Test
	final void testProjectPositiveZ()
	{
		Matrix4f matrix = new Matrix4f();
		matrix.projectPositiveZ(11, 23, 17, 0.1F);
		Matrix4f expected = new Matrix4f();
		expected.scale(Vector3f.of(1, 1, 0.5F)).translate(Vector3f.of(0, 0, 0.5F));
		expected.multiply(new Matrix4f().project(11, 23, 17, 0.1F));
		assertEquals(expected, matrix);
	}
	
	@Test
	final void testViewVector3fFloatFloat()
	{
		Matrix4f matrix = new Matrix4f();
		matrix.view(Vector3f.of(2, 3, 5), 11, 17);
		Matrix4f expected = new Matrix4f();
		expected.rotateXY(11, 17);
		expected.multiply(new Matrix4f().translate(Vector3f.of(-2, -3, -5)));
		assertEquals(expected, matrix);
	}
	
	@Test
	final void testViewFloatFloat()
	{
		Matrix4f matrix = new Matrix4f();
		matrix.view(11, 17);
		Matrix4f expected = new Matrix4f();
		expected.view(Vector3f.origin(), 11, 17);
		assertEquals(expected, matrix);
	}
	
	@Test
	final void testScale()
	{
		Matrix4f matrix = new Matrix4f();
		matrix.scale(Vector3f.of(2, 3, 5));
		
		assertEquals(X.multiply(2, 3, 5, 1), matrix.multiply(X));
		assertEquals(Y.multiply(2, 3, 5, 1), matrix.multiply(Y));
		assertEquals(Z.multiply(2, 3, 5, 1), matrix.multiply(Z));
		assertEquals(ZERO, matrix.multiply(ZERO));
	}
	
	@Test
	final void testScaleRelative()
	{
		Matrix4f matrix = new Matrix4f();
		matrix.scaleRelative(Vector3f.of(1, 2, 5));
		matrix.scaleRelative(Vector3f.of(3, 7, 11));
		Matrix4f expected = new Matrix4f();
		expected.scale(Vector3f.of(3, 14, 55));
		assertEquals(expected, matrix);
	}
	
	@Test
	final void testTranslateToVector3f()
	{
		Matrix4f matrix = new Matrix4f();
		matrix.translateTo(Vector3f.of(1, 2, 3));
		matrix.translateTo(Vector3f.of(3, 7, 11));
		Matrix4f expected = new Matrix4f();
		expected.translate(Vector3f.of(3, 7, 11));
		assertEquals(expected, matrix);
	}
	
	@Test
	final void testTranslateToVector3i()
	{
		Matrix4f matrix = new Matrix4f();
		matrix.translateTo(Vector3i.of(1, 2, 3));
		matrix.translateTo(Vector3i.of(3, 7, 11));
		Matrix4f expected = new Matrix4f();
		expected.translateTo(Vector3f.of(3, 7, 11));
		assertEquals(expected, matrix);
	}
	
	@Test
	final void testTranslateXTo()
	{
		Matrix4f matrix = new Matrix4f();
		matrix.translateXTo(11);
		matrix.translateXTo(1);
		Matrix4f expected = new Matrix4f();
		expected.translate(Vector3f.of(1, 0, 0));
		assertEquals(expected, matrix);
	}
	
	@Test
	final void testTranslateYTo()
	{
		Matrix4f matrix = new Matrix4f();
		matrix.translateYTo(11);
		matrix.translateYTo(2);
		Matrix4f expected = new Matrix4f();
		expected.translate(Vector3f.of(0, 2, 0));
		assertEquals(expected, matrix);
	}
	
	@Test
	final void testTranslateZTo()
	{
		Matrix4f matrix = new Matrix4f();
		matrix.translateZTo(11);
		matrix.translateZTo(3);
		Matrix4f expected = new Matrix4f();
		expected.translate(Vector3f.of(0, 0, 3));
		assertEquals(expected, matrix);
	}
	
	@Test
	final void testTranslateX()
	{
		Matrix4f matrix = new Matrix4f();
		matrix.translateX(3);
		matrix.translateX(4);
		Matrix4f expected = new Matrix4f();
		expected.translate(Vector3f.of(7, 0, 0));
		assertEquals(expected, matrix);
	}
	
	@Test
	final void testTranslateY()
	{
		Matrix4f matrix = new Matrix4f();
		matrix.translateY(3);
		matrix.translateY(4);
		Matrix4f expected = new Matrix4f();
		expected.translate(Vector3f.of(0, 7, 0));
		assertEquals(expected, matrix);
	}
	
	@Test
	final void testTranslateZ()
	{
		Matrix4f matrix = new Matrix4f();
		matrix.translateZ(3);
		matrix.translateZ(4);
		Matrix4f expected = new Matrix4f();
		expected.translate(Vector3f.of(0, 0, 7));
		assertEquals(expected, matrix);
	}
	
	@Test
	final void testTranslateVector3f()
	{
		Matrix4f matrix = new Matrix4f();
		matrix.translate(Vector3f.of(1, 2, 3));
		
		assertEquals(Vector4f.of(2, 2, 3, 1), matrix.multiply(X));
		assertEquals(Vector4f.of(1, 3, 3, 1), matrix.multiply(Y));
		assertEquals(Vector4f.of(1, 2, 4, 1), matrix.multiply(Z));
		assertEquals(Vector4f.of(1, 2, 3, 1), matrix.multiply(ZERO));
	}
	
	@Test
	final void testTranslateVector3i()
	{
		Matrix4f matrix = new Matrix4f();
		matrix.translate(Vector3i.of(1, 2, 3));
		Matrix4f expected = new Matrix4f();
		expected.translate(Vector3f.of(1, 2, 3));
		assertEquals(expected, matrix);
	}
	
	@Test
	final void testRotateX()
	{
		Matrix4f matrix = new Matrix4f();
		matrix.rotateX(Math.PIF / 3);
		
		assertEquals(X, matrix.multiply(X));
		assertEquals(NEGATIVE_X, matrix.multiply(NEGATIVE_X));
		assertEquals(Vector4f.of(0, 1F / 2, Math.SQUARE_ROOT_3F / 2, 1), matrix.multiply(Y));
		assertEquals(Vector4f.of(0, -1F / 2, -Math.SQUARE_ROOT_3F / 2, 1), matrix.multiply(NEGATIVE_Y));
		assertEquals(Vector4f.of(0, -Math.SQUARE_ROOT_3F / 2, 1F / 2, 1), matrix.multiply(Z));
		assertEquals(Vector4f.of(0, Math.SQUARE_ROOT_3F / 2, -1F / 2, 1), matrix.multiply(NEGATIVE_Z));
		assertEquals(ZERO, matrix.multiply(ZERO));
	}
	
	@Test
	final void testRotateY()
	{
		Matrix4f matrix = new Matrix4f();
		matrix.rotateY(Math.PIF / 3);
		
		assertEquals(Vector4f.of(1F / 2, 0, -Math.SQUARE_ROOT_3F / 2, 1), matrix.multiply(X));
		assertEquals(Vector4f.of(-1F / 2, 0, Math.SQUARE_ROOT_3F / 2, 1), matrix.multiply(NEGATIVE_X));
		assertEquals(Y, matrix.multiply(Y));
		assertEquals(NEGATIVE_Y, matrix.multiply(NEGATIVE_Y));
		assertEquals(Vector4f.of(Math.SQUARE_ROOT_3F / 2, 0, 1F / 2, 1), matrix.multiply(Z));
		assertEquals(Vector4f.of(-Math.SQUARE_ROOT_3F / 2, 0, -1F / 2, 1), matrix.multiply(NEGATIVE_Z));
		assertEquals(ZERO, matrix.multiply(ZERO));
	}
	
	@Test
	final void testRotateZ()
	{
		Matrix4f matrix = new Matrix4f();
		matrix.rotateZ(Math.PIF / 3);
		
		assertEquals(Vector4f.of(1F / 2, Math.SQUARE_ROOT_3F / 2, 0, 1), matrix.multiply(X));
		assertEquals(Vector4f.of(-1F / 2, -Math.SQUARE_ROOT_3F / 2, 0, 1), matrix.multiply(NEGATIVE_X));
		assertEquals(Vector4f.of(-Math.SQUARE_ROOT_3F / 2, 1F / 2, 0, 1), matrix.multiply(Y));
		assertEquals(Vector4f.of(Math.SQUARE_ROOT_3F / 2, -1F / 2, 0, 1), matrix.multiply(NEGATIVE_Y));
		assertEquals(Z, matrix.multiply(Z));
		assertEquals(NEGATIVE_Z, matrix.multiply(NEGATIVE_Z));
		assertEquals(ZERO, matrix.multiply(ZERO));
	}
	
	@Test
	final void testRotateXY()
	{
		Matrix4f matrix = new Matrix4f();
		matrix.rotateXY(Math.PIF / 11, Math.PIF / 17);
		
		Matrix4f rx = new Matrix4f();
		rx.rotateX(Math.PIF / 11);
		Matrix4f ry = new Matrix4f();
		ry.rotateY(Math.PIF / 17);
		Matrix4f expected = new Matrix4f(rx).multiply(ry);
		assertEquals(expected, matrix);
	}
	
	@Test
	final void testMultiplyMatrix4f()
	{
		Matrix4f l = new Matrix4f(new float[][] {
			{1, 0, 0, 0},
			{5, -4, 0, 0},
			{10, -10, 1, 0},
			{10, -9, -2, 25F / 4},
		});
		Matrix4f u = new Matrix4f(new float[][] {
			{1, 2, 3, 5},
			{0, 1, 2, 17F / 4},
			{0, 0, 1, 7F / 2},
			{0, 0, 0, 1},
		});
		Matrix4f expected = new Matrix4f(new float[][] {
			{1, 2, 3, 5},
			{5, 6, 7, 8},
			{10, 10, 11, 11},
			{10, 11, 10, 11},
		});
		Matrix4f result = new Matrix4f(l).multiply(u);
		assertEquals(expected, result);
	}
	
	@Test
	final void testMultiplyVector4f()
	{
		Matrix4f matrix = new Matrix4f(new float[][] {
			{1, 2, 3, 4},
			{5, 6, 7, 8},
			{10, 10, 11, 11},
			{10, 11, 10, 11},
		});
		assertEquals(Vector4f.of(1, 5, 10, 10), matrix.multiply(Axis.X));
		assertEquals(Vector4f.of(2, 6, 10, 11), matrix.multiply(Axis.Y));
		assertEquals(Vector4f.of(3, 7, 11, 10), matrix.multiply(Axis.Z));
		assertEquals(Vector4f.of(4, 8, 11, 11), matrix.multiply(Axis.W));
	}
	
	@Test
	final void testDeterminant()
	{
		Matrix4f matrix = new Matrix4f(new float[][] {
			{1, 2, 3, 4},
			{5, 6, 7, 8},
			{10, 10, 11, 11},
			{10, 11, 10, 11},
		});
		float det = matrix.determinant();
		assertEquals(0, det);
		matrix = new Matrix4f(new float[][] {
			{1, 2, 3, 5},
			{5, 6, 7, 8},
			{10, 10, 11, 11},
			{10, 11, 10, 11},
		});
		det = matrix.determinant();
		assertEquals(-25, det);
	}
	
	@Test
	final void testTranspose()
	{
		Matrix4f matrix = new Matrix4f(new float[][] {
			{1, 2, 3, 4},
			{5, 6, 7, 8},
			{9, 10, 11, 12},
			{13, 14, 15, 16},
		});
		matrix.transpose();
		Matrix4f matrix0 = new Matrix4f(new float[][] {
			{1, 5, 9, 13},
			{2, 6, 10, 14},
			{3, 7, 11, 15},
			{4, 8, 12, 16},
		});
		assertEquals(matrix0, matrix);
	}
	
	@Test
	final void testInverse()
	{
		Matrix4f matrix = new Matrix4f(new float[][] {
			{1, 2, 3, 5},
			{5, 6, 7, 8},
			{10, 10, 11, 11},
			{10, 11, 10, 11},
		});
		Matrix4f inverse = matrix.inverse();
		matrix.multiply(inverse);
		assertEquals(Matrix4f.IDENTITY, matrix);
	}
	
	@Test
	final void testToArray()
	{
		Matrix4f matrix = new Matrix4f(new float[][] {
			{1, 2, 3, 4},
			{5, 6, 7, 8},
			{9, 10, 11, 12},
			{13, 14, 15, 16},
		});
		assertArrayEquals(new float[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16}, matrix.toArray());
		assertArrayEquals(new float[] {1, 5, 9, 13, 2, 6, 10, 14, 3, 7, 11, 15, 4, 8, 12, 16}, matrix.toTransposedArray());
	}
	
	@Test
	final void testGetIdentity()
	{
		Matrix4f matrix = Matrix4f.getIdentity();
		assertSame(matrix, Matrix4f.IDENTITY);
		matrix.cursor(1, 2, Vector2f.of(1, 2));
		assertArrayEquals(IDENTITY_ARRAY, matrix.toArray());
	}
	
}

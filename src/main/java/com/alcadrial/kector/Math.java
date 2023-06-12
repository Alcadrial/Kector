package com.alcadrial.kector;

import java.math.RoundingMode;
import java.util.function.Function;

import com.alcadrial.kector.angle.AngleUnit;
import com.alcadrial.kector.vector.Vector2f;

public class Math {
	
	public static final double PI = java.lang.Math.PI;
	public static final double HALF_PI = PI / 2;
	public static final double E = java.lang.Math.E;
	public static final double SQUARE_ROOT_3 = sqrt(3);
	public static final double HALF_SQUARE_ROOT_3 = SQUARE_ROOT_3 / 2;
	public static final double SQUARE_ROOT_2 = sqrt(2);
	public static final double HALF_SQUARE_ROOT_2 = SQUARE_ROOT_2 / 2;
	
	public static final float PIF = (float) PI;
	public static final float HALF_PIF = (float) HALF_PI;
	public static final float EF = (float) E;
	public static final float SQUARE_ROOT_3F = (float) SQUARE_ROOT_3;
	public static final float HALF_SQUARE_ROOT_3F = (float) HALF_SQUARE_ROOT_3;
	public static final float SQUARE_ROOT_2F = (float) SQUARE_ROOT_2;
	public static final float HALF_SQUARE_ROOT_2F = (float) HALF_SQUARE_ROOT_2;
	
	public static double interpolation(Double a, Double b, Double delta, Function<Double, Double> interpolationFunction)
	{
		return (b - a) * interpolationFunction.apply(delta) + a;
	}
	
	public static float interpolation(Float a, Float b, Float delta, Function<Float, Float> interpolationFunction)
	{
		return (b - a) * interpolationFunction.apply(delta) + a;
	}
	
	public static Vector2f interpolation(Vector2f v, Vector2f w, float delta, Function<Float, Float> interpolationFunction)
	{
		return Vector2f.copyOf(w).subtract(v).multiplyAll(interpolationFunction.apply(delta)).add(v);
	}
	
	public static double cosineInterpolation(double a, double b, double delta)
	{
		return (b - a) * ((1 - cos(AngleUnit.RADIANS.fromTurns(delta / 2))) * 0.5) + a;
	}
	
	public static float cosineInterpolation(float a, float b, float delta)
	{
		return (float) ((b - a) * ((1 - cos(AngleUnit.RADIANS.fromTurns(delta / 2D))) * 0.5) + a);
	}
	
	public static Vector2f cosineInterpolation(Vector2f v, Vector2f w, float delta)
	{
		return Vector2f.copyOf(w).subtract(v).multiplyAll((float) ((1 - cos(AngleUnit.RADIANS.fromTurns(delta / 2D))) * 0.5)).add(v);
	}
	
	public static double halfCosineInterpolation(double a, double b, double delta)
	{
		return (b - a) * (1 - cos(AngleUnit.RADIANS.fromTurns(delta / 4))) + a;
	}
	
	public static float halfCosineInterpolation(float a, float b, float delta)
	{
		return (float) ((b - a) * (1 - cos(AngleUnit.RADIANS.fromTurns(delta / 4D))) + a);
	}
	
	public static Vector2f halfCosineInterpolation(Vector2f v, Vector2f w, float delta)
	{
		return Vector2f.copyOf(w).subtract(v).multiplyAll((float) (1 - cos(AngleUnit.RADIANS.fromTurns(delta / 4D)))).add(v);
	}
	
	public static double lerp(double a, double b, double delta)
	{
		return (b - a) * delta + a;
	}
	
	public static float lerp(float a, float b, float delta)
	{
		return (b - a) * delta + a;
	}
	
	public static Vector2f lerp(Vector2f v, Vector2f w, float delta)
	{
		return Vector2f.copyOf(w).subtract(v).multiplyAll(delta).add(v);
	}
	
	/**
	 * Returns the fraction of the argument closest to zero.
	 * The computed value is in range [-1; 1].
	 * 
	 * @param a a value
	 * 
	 * @return the fraction of a
	 */
	public static double fraction(double a)
	{
		return a % 1;
	}
	
	/**
	 * Returns the fraction of the argument closest to zero.
	 * The computed value is in range [-1; 1].
	 * 
	 * @param a a value
	 * 
	 * @return the fraction of a
	 */
	public static float fraction(float a)
	{
		return a % 1;
	}
	
	/**
	 * Returns the fraction of the argument away from zero.
	 * The computed value is in range [-1; 1].
	 * 
	 * @param a a value
	 * 
	 * @return the up fraction of a
	 */
	public static double fractionUp(double a)
	{
		return a >= 0 ? 1 - a % 1 : -(1 + a % 1);
	}
	
	/**
	 * Returns the fraction of the argument away from zero.
	 * The computed value is in range [-1; 1].
	 * 
	 * @param a a value
	 * 
	 * @return the up fraction of a
	 */
	public static float fractionUp(float a)
	{
		return a >= 0 ? 1 - a % 1 : -(1 + a % 1);
	}
	
	/**
	 * Returns the fraction of the argument closest to negative infinity.
	 * The computed value is in range [-1; 1].
	 * 
	 * @param a a value
	 * 
	 * @return the floor fraction of a
	 */
	
	public static double fractionCeiling(double a)
	{
		return a >= 0 ? a % 1 : 1 - a % 1;
	}
	
	/**
	 * Returns the fraction of the argument closest to negative infinity.
	 * The computed value is in range [-1; 1].
	 * 
	 * @param a a value
	 * 
	 * @return the floor fraction of a
	 */
	
	public static float fractionCeiling(float a)
	{
		return a >= 0 ? a % 1 : 1 - a % 1;
	}
	
	/**
	 * Returns the fraction of the argument closest to positive infinity.
	 * The computed value is in range [-1; 1].
	 * 
	 * @param a a value
	 * 
	 * @return the floor fraction of a
	 */
	
	public static double fractionFloor(double a)
	{
		return a > 0 ? 1 - a % 1 : a % 1;
	}
	
	/**
	 * Returns the fraction of the argument closest to positive infinity.
	 * The computed value is in range [-1; 1].
	 * 
	 * @param a a value
	 * 
	 * @return the floor fraction of a
	 */
	
	public static float fractionFloor(float a)
	{
		return a > 0 ? 1 - a % 1 : a % 1;
	}
	
	/**
	 * @see java.lang.Math#sin(double)
	 */
	public static double sin(double a)
	{
		return java.lang.Math.sin(a);
	}
	
	/**
	 * @see java.lang.Math#sin(double)
	 */
	public static float sin(float a)
	{
		return (float) java.lang.Math.sin(a);
	}
	
	/**
	 * @see java.lang.Math#cos(double)
	 */
	public static double cos(double a)
	{
		return java.lang.Math.cos(a);
	}
	
	/**
	 * @see java.lang.Math#cos(double)
	 */
	public static float cos(float a)
	{
		return (float) java.lang.Math.cos(a);
	}
	
	/**
	 * @see java.lang.Math#tan(double)
	 */
	public static double tan(double a)
	{
		return java.lang.Math.tan(a);
	}
	
	/**
	 * @see java.lang.Math#tan(double)
	 */
	public static float tan(float a)
	{
		return (float) java.lang.Math.tan(a);
	}
	
	/**
	 * @see java.lang.Math#asin(double)
	 */
	public static double asin(double a)
	{
		return java.lang.Math.asin(a);
	}
	
	/**
	 * @see java.lang.Math#acos(double)
	 */
	public static double acos(double a)
	{
		return java.lang.Math.acos(a);
	}
	
	/**
	 * @see java.lang.Math#atan(double)
	 */
	public static double atan(double a)
	{
		return java.lang.Math.atan(a);
	}
	
	/**
	 * @see java.lang.Math#toRadians(double)
	 */
	public static double toRadians(double angdeg)
	{
		return java.lang.Math.toRadians(angdeg);
	}
	
	/**
	 * @see java.lang.Math#toDegrees(double)
	 */
	public static double toDegrees(double angrad)
	{
		return java.lang.Math.toDegrees(angrad);
	}
	
	/**
	 * @see java.lang.Math#exp(double)
	 */
	public static double exp(double a)
	{
		return java.lang.Math.exp(a);
	}
	
	/**
	 * @see java.lang.Math#log(double)
	 */
	public static double log(double a)
	{
		return java.lang.Math.log(a);
	}
	
	/**
	 * @see java.lang.Math#log10(double)
	 */
	public static double log10(double a)
	{
		return java.lang.Math.log10(a);
	}
	
	/**
	 * @see java.lang.Math#sqrt(double)
	 */
	public static float sqrt(float a)
	{
		return (float) java.lang.Math.sqrt(a);
	}
	
	/**
	 * @see java.lang.Math#sqrt(double)
	 */
	public static double sqrt(double a)
	{
		return java.lang.Math.sqrt(a);
	}
	
	/**
	 * @see java.lang.Math#cbrt(double)
	 */
	public static double cbrt(double a)
	{
		return java.lang.Math.cbrt(a);
	}
	
	/**
	 * @see java.lang.Math#IEEEremainder(double, double)
	 */
	public static double IEEEremainder(double f1, double f2)
	{
		return java.lang.Math.IEEEremainder(f1, f2);
	}
	
	/**
	 * @see java.lang.Math#ceil(double)
	 */
	public static double ceil(double a)
	{
		return java.lang.Math.ceil(a);
	}
	
	/**
	 * @see java.lang.Math#floor(double)
	 */
	public static double floor(double a)
	{
		return java.lang.Math.floor(a);
	}
	
	/**
	 * @see java.lang.Math#rint(double)
	 */
	public static double rint(double a)
	{
		return java.lang.Math.rint(a);
	}
	
	/**
	 * @see java.lang.Math#atan2(double, double)
	 */
	public static double atan2(double y, double x)
	{
		return java.lang.Math.atan2(y, x);
	}
	
	/**
	 * @see java.lang.Math#pow(double, double)
	 */
	public static float pow(float a, float b)
	{
		return (float) java.lang.Math.pow(a, b);
	}
	
	/**
	 * @see java.lang.Math#pow(double, double)
	 */
	public static double pow(double a, double b)
	{
		return java.lang.Math.pow(a, b);
	}
	
	/**
	 * @see java.lang.Math#round(float)
	 */
	public static int round(float a)
	{
		return java.lang.Math.round(a);
	}
	
	/**
	 * @see java.lang.Math#round(double)
	 */
	public static long round(double a)
	{
		return java.lang.Math.round(a);
	}
	
	/**
	 * @see java.lang.Math#random()
	 */
	public static double random()
	{
		return java.lang.Math.random();
	}
	
	/**
	 * @see java.lang.Math#addExact(int, int)
	 */
	public static int addExact(int x, int y)
	{
		return java.lang.Math.addExact(x, y);
	}
	
	/**
	 * @see java.lang.Math#addExact(long, long)
	 */
	public static long addExact(long x, long y)
	{
		return java.lang.Math.addExact(x, y);
	}
	
	/**
	 * @see java.lang.Math#subtractExact(int, int)
	 */
	public static int subtractExact(int x, int y)
	{
		return java.lang.Math.subtractExact(x, y);
	}
	
	/**
	 * @see java.lang.Math#subtractExact(long, long)
	 */
	public static long subtractExact(long x, long y)
	{
		return java.lang.Math.subtractExact(x, y);
	}
	
	/**
	 * @see java.lang.Math#multiplyExact(int, int)
	 */
	public static int multiplyExact(int x, int y)
	{
		return java.lang.Math.multiplyExact(x, y);
	}
	
	/**
	 * @see java.lang.Math#multiplyExact(long, int)
	 */
	public static long multiplyExact(long x, int y)
	{
		return java.lang.Math.multiplyExact(x, y);
	}
	
	/**
	 * @see java.lang.Math#multiplyExact(long, long)
	 */
	public static long multiplyExact(long x, long y)
	{
		return java.lang.Math.multiplyExact(x, y);
	}
	
	/**
	 * @see java.lang.Math#incrementExact(int)
	 */
	public static int incrementExact(int a)
	{
		return java.lang.Math.incrementExact(a);
	}
	
	/**
	 * @see java.lang.Math#incrementExact(long)
	 */
	public static long incrementExact(long a)
	{
		return java.lang.Math.incrementExact(a);
	}
	
	/**
	 * @see java.lang.Math#decrementExact(int)
	 */
	public static int decrementExact(int a)
	{
		return java.lang.Math.decrementExact(a);
	}
	
	/**
	 * @see java.lang.Math#decrementExact(long)
	 */
	public static long decrementExact(long a)
	{
		return java.lang.Math.decrementExact(a);
	}
	
	/**
	 * @see java.lang.Math#negateExact(int)
	 */
	public static int negateExact(int a)
	{
		return java.lang.Math.negateExact(a);
	}
	
	/**
	 * @see java.lang.Math#negateExact(long)
	 */
	public static long negateExact(long a)
	{
		return java.lang.Math.negateExact(a);
	}
	
	/**
	 * @see java.lang.Math#toIntExact(long)
	 */
	public static int toIntExact(long value)
	{
		return java.lang.Math.toIntExact(value);
	}
	
	/**
	 * @see java.lang.Math#multiplyFull(int, int)
	 */
	public static long multiplyFull(int x, int y)
	{
		return java.lang.Math.multiplyFull(x, y);
	}
	
	/**
	 * @see java.lang.Math#multiplyHigh(long, long)
	 */
	public static long multiplyHigh(long x, long y)
	{
		return java.lang.Math.multiplyHigh(x, y);
	}
	
	/**
	 * @see java.lang.Math#floorDiv(int, int)
	 */
	public static int floorDiv(int x, int y)
	{
		return java.lang.Math.floorDiv(x, y);
	}
	
	/**
	 * @see java.lang.Math#floorDiv(long, int)
	 */
	public static long floorDiv(long x, int y)
	{
		return java.lang.Math.floorDiv(x, y);
	}
	
	/**
	 * @see java.lang.Math#floorDiv(long, long)
	 */
	public static long floorDiv(long x, long y)
	{
		return java.lang.Math.floorDiv(x, y);
	}
	
	/**
	 * @see java.lang.Math#floorMod(int, int)
	 */
	public static int floorMod(int x, int y)
	{
		return java.lang.Math.floorMod(x, y);
	}
	
	/**
	 * @see java.lang.Math#floorMod(long, int)
	 */
	public static int floorMod(long x, int y)
	{
		return java.lang.Math.floorMod(x, y);
	}
	
	/**
	 * @see java.lang.Math#floorMod(long, long)
	 */
	public static long floorMod(long x, long y)
	{
		return java.lang.Math.floorMod(x, y);
	}
	
	/**
	 * @see java.lang.Math#abs(int)
	 */
	public static int abs(int a)
	{
		return java.lang.Math.abs(a);
	}
	
	/**
	 * @see java.lang.Math#absExact(int)
	 */
	public static int absExact(int a)
	{
		return java.lang.Math.absExact(a);
	}
	
	/**
	 * @see java.lang.Math#abs(long)
	 */
	public static long abs(long a)
	{
		return java.lang.Math.abs(a);
	}
	
	/**
	 * @see java.lang.Math#absExact(long)
	 */
	public static long absExact(long a)
	{
		return java.lang.Math.absExact(a);
	}
	
	/**
	 * @see java.lang.Math#abs(float)
	 */
	public static float abs(float a)
	{
		return java.lang.Math.abs(a);
	}
	
	/**
	 * @see java.lang.Math#abs(double)
	 */
	public static double abs(double a)
	{
		return java.lang.Math.abs(a);
	}
	
	/**
	 * @see java.lang.Math#max(int, int)
	 */
	public static int max(int a, int b)
	{
		return java.lang.Math.max(a, b);
	}
	
	/**
	 * @see java.lang.Math#max(long, long)
	 */
	public static long max(long a, long b)
	{
		return java.lang.Math.max(a, b);
	}
	
	/**
	 * @see java.lang.Math#max(float, float)
	 */
	public static float max(float a, float b)
	{
		return java.lang.Math.max(a, b);
	}
	
	/**
	 * @see java.lang.Math#max(double, double)
	 */
	public static double max(double a, double b)
	{
		return java.lang.Math.max(a, b);
	}
	
	/**
	 * @see java.lang.Math#min(int, int)
	 */
	public static int min(int a, int b)
	{
		return java.lang.Math.min(a, b);
	}
	
	/**
	 * @see java.lang.Math#min(long, long)
	 */
	public static long min(long a, long b)
	{
		return java.lang.Math.min(a, b);
	}
	
	/**
	 * @see java.lang.Math#min(float, float)
	 */
	public static float min(float a, float b)
	{
		return java.lang.Math.min(a, b);
	}
	
	/**
	 * @see java.lang.Math#min(double, double)
	 */
	public static double min(double a, double b)
	{
		return java.lang.Math.min(a, b);
	}
	
	/**
	 * @see java.lang.Math#fma(double, double, double)
	 */
	public static double fma(double a, double b, double c)
	{
		return java.lang.Math.fma(a, b, c);
	}
	
	/**
	 * @see java.lang.Math#fma(float, float, float)
	 */
	public static float fma(float a, float b, float c)
	{
		return java.lang.Math.fma(a, b, c);
	}
	
	/**
	 * @see java.lang.Math#ulp(double)
	 */
	public static double ulp(double d)
	{
		return java.lang.Math.ulp(d);
	}
	
	/**
	 * @see java.lang.Math#ulp(float)
	 */
	public static float ulp(float f)
	{
		return java.lang.Math.ulp(f);
	}
	
	/**
	 * @see java.lang.Math#signum(double)
	 */
	public static double signum(double d)
	{
		return java.lang.Math.signum(d);
	}
	
	/**
	 * @see java.lang.Math#signum(float)
	 */
	public static float signum(float f)
	{
		return java.lang.Math.signum(f);
	}
	
	/**
	 * @see java.lang.Math#signum(float)
	 */
	public static int signum(int f)
	{
		return (int) java.lang.Math.signum(f);
	}
	
	/**
	 * @see java.lang.Math#sinh(double)
	 */
	public static double sinh(double x)
	{
		return java.lang.Math.sinh(x);
	}
	
	/**
	 * @see java.lang.Math#cosh(double)
	 */
	public static double cosh(double x)
	{
		return java.lang.Math.cosh(x);
	}
	
	/**
	 * @see java.lang.Math#tanh(double)
	 */
	public static double tanh(double x)
	{
		return java.lang.Math.tanh(x);
	}
	
	/**
	 * @see java.lang.Math#hypot(double, double)
	 */
	public static double hypot(double x, double y)
	{
		return java.lang.Math.hypot(x, y);
	}
	
	/**
	 * @see java.lang.Math#expm1(double)
	 */
	public static double expm1(double x)
	{
		return java.lang.Math.expm1(x);
	}
	
	/**
	 * @see java.lang.Math#log1p(double)
	 */
	public static double log1p(double x)
	{
		return java.lang.Math.log1p(x);
	}
	
	/**
	 * @see java.lang.Math#copySign(double, double)
	 */
	public static double copySign(double magnitude, double sign)
	{
		return java.lang.Math.copySign(magnitude, sign);
	}
	
	/**
	 * @see java.lang.Math#copySign(float, float)
	 */
	public static float copySign(float magnitude, float sign)
	{
		return java.lang.Math.copySign(magnitude, sign);
	}
	
	/**
	 * @see java.lang.Math#getExponent(float)
	 */
	public static int getExponent(float f)
	{
		return java.lang.Math.getExponent(f);
	}
	
	/**
	 * @see java.lang.Math#getExponent(double)
	 */
	public static int getExponent(double d)
	{
		return java.lang.Math.getExponent(d);
	}
	
	/**
	 * @see java.lang.Math#nextAfter(double, double)
	 */
	public static double nextAfter(double start, double direction)
	{
		return java.lang.Math.nextAfter(start, direction);
	}
	
	/**
	 * @see java.lang.Math#nextAfter(float, double)
	 */
	public static float nextAfter(float start, double direction)
	{
		return java.lang.Math.nextAfter(start, direction);
	}
	
	/**
	 * @see java.lang.Math#nextUp(double)
	 */
	public static double nextUp(double d)
	{
		return java.lang.Math.nextUp(d);
	}
	
	/**
	 * @see java.lang.Math#nextUp(float)
	 */
	public static float nextUp(float f)
	{
		return java.lang.Math.nextUp(f);
	}
	
	/**
	 * @see java.lang.Math#nextDown(double)
	 */
	public static double nextDown(double d)
	{
		return java.lang.Math.nextDown(d);
	}
	
	/**
	 * @see java.lang.Math#nextDown(float)
	 */
	public static float nextDown(float f)
	{
		return java.lang.Math.nextDown(f);
	}
	
	/**
	 * @see java.lang.Math#scalb(double, int)
	 */
	public static double scalb(double d, int scaleFactor)
	{
		return java.lang.Math.scalb(d, scaleFactor);
	}
	
	/**
	 * @see java.lang.Math#scalb(float, int)
	 */
	public static float scalb(float f, int scaleFactor)
	{
		return java.lang.Math.scalb(f, scaleFactor);
	}
	
	public static int toInt(float f, RoundingMode mode)
	{
		return switch (mode)
		{
			case UP -> f % 1 == 0 ? (int) f : (int) f + (f < 0 ? -1 : 1);
			case CEILING -> f <= 0 ? (int) f : f % 1 == 0 ? (int) f + 1 : (int) f;
			case DOWN -> (int) f;
			case FLOOR -> f >= 0 ? (int) f : f % 1 < 0 ? (int) f - 1 : (int) f;
			case HALF_DOWN ->
			{
				float r = f % 1;
				yield r > 0.5 ? (int) f + 1 : r < 0.5 ? (int) f - 1 : (int) f;
			}
			case HALF_EVEN ->
			{
				float r = f % 1;
				yield r > 0.5 ? (int) f + 1 : r < -0.5 ? (int) f - 1 : (int) f % 2 == 0 ? (int) f + 1 : (int) f;
			}
			case HALF_UP ->
			{
				float r = f % 1;
				yield r >= 0.5 ? (int) f + 1 : r <= -0.5 ? (int) f - 1 : (int) f;
			}
			case UNNECESSARY ->
			{
				if (f % 1 != 0) throw new ArithmeticException();
				yield (int) f;
			}
		};
	}
	
	public static int toInt(double d, RoundingMode mode)
	{
		return switch (mode)
		{
			case UP -> d % 1 == 0 ? (int) d : (int) d + (d < 0 ? -1 : 1);
			case CEILING -> d <= 0 ? (int) d : d % 1 == 0 ? (int) d + 1 : (int) d;
			case DOWN -> (int) d;
			case FLOOR -> d >= 0 ? (int) d : d % 1 < 0 ? (int) d - 1 : (int) d;
			case HALF_DOWN ->
			{
				double r = d % 1;
				yield r > 0.5 ? (int) d + 1 : r < 0.5 ? (int) d - 1 : (int) d;
			}
			case HALF_EVEN ->
			{
				double r = d % 1;
				yield r > 0.5 ? (int) d + 1 : r < -0.5 ? (int) d - 1 : (int) d % 2 == 0 ? (int) d + 1 : (int) d;
			}
			case HALF_UP ->
			{
				double r = d % 1;
				yield r >= 0.5 ? (int) d + 1 : r <= -0.5 ? (int) d - 1 : (int) d;
			}
			case UNNECESSARY ->
			{
				if (d % 1 != 0) throw new ArithmeticException();
				yield (int) d;
			}
		};
	}
	
	public static long toLong(float f, RoundingMode mode)
	{
		return switch (mode)
		{
			case UP -> f % 1 == 0 ? (long) f : (long) f + (f < 0 ? -1 : 1);
			case CEILING -> f <= 0 ? (long) f : f % 1 == 0 ? (long) f + 1 : (long) f;
			case DOWN -> (long) f;
			case FLOOR -> f >= 0 ? (long) f : f % 1 < 0 ? (long) f - 1 : (long) f;
			case HALF_DOWN ->
			{
				float r = f % 1;
				yield r > 0.5 ? (long) f + 1 : r < 0.5 ? (long) f - 1 : (long) f;
			}
			case HALF_EVEN ->
			{
				float r = f % 1;
				yield r > 0.5 ? (long) f + 1 : r < -0.5 ? (long) f - 1 : (long) f % 2 == 0 ? (long) f + 1 : (long) f;
			}
			case HALF_UP ->
			{
				float r = f % 1;
				yield r >= 0.5 ? (long) f + 1 : r <= -0.5 ? (long) f - 1 : (long) f;
			}
			case UNNECESSARY ->
			{
				if (f % 1 != 0) throw new ArithmeticException();
				yield (long) f;
			}
		};
	}
	
	public static long toLong(double d, RoundingMode mode)
	{
		return switch (mode)
		{
			case UP -> d % 1 == 0 ? (long) d : (long) d + (d < 0 ? -1 : 1);
			case CEILING -> d <= 0 ? (long) d : d % 1 == 0 ? (long) d + 1 : (long) d;
			case DOWN -> (long) d;
			case FLOOR -> d >= 0 ? (long) d : d % 1 < 0 ? (long) d - 1 : (long) d;
			case HALF_DOWN ->
			{
				double r = d % 1;
				yield r > 0.5 ? (long) d + 1 : r < 0.5 ? (long) d - 1 : (long) d;
			}
			case HALF_EVEN ->
			{
				double r = d % 1;
				yield r > 0.5 ? (long) d + 1 : r < -0.5 ? (long) d - 1 : (long) d % 2 == 0 ? (long) d + 1 : (long) d;
			}
			case HALF_UP ->
			{
				double r = d % 1;
				yield r >= 0.5 ? (long) d + 1 : r <= -0.5 ? (long) d - 1 : (long) d;
			}
			case UNNECESSARY ->
			{
				if (d % 1 != 0) throw new ArithmeticException();
				yield (long) d;
			}
		};
	}
}

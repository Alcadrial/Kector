package com.alcadrial.kector.vector.util;

import com.alcadrial.kector.Math;
import com.alcadrial.kector.vector.getter.Vector2fGetter;
import com.alcadrial.kector.vector.getter.Vector3fGetter;
import com.alcadrial.kector.vector.getter.Vector4fGetter;

public class VectorUtils {
	
	public static boolean equals(Vector4fGetter v, Vector4fGetter w)
	{
		return Math.looseEquals(v.x(), w.x()) && Math.looseEquals(v.y(), w.y()) && Math.looseEquals(v.z(), w.z()) && Math.looseEquals(v.w(), w.w());
	}
	
	public static boolean equals(Vector4fGetter v, Vector3fGetter w)
	{
		return Math.looseEquals(v.x(), w.x()) && Math.looseEquals(v.y(), w.y()) && Math.looseEquals(v.z(), w.z()) && Math.nearZero(v.w());
	}
	
	public static boolean equals(Vector4fGetter v, Vector2fGetter w)
	{
		return Math.looseEquals(v.x(), w.x()) && Math.looseEquals(v.y(), w.y()) && Math.nearZero(v.z()) && Math.nearZero(v.w());
	}
	
	public static boolean equals(Vector3fGetter v, Vector4fGetter w)
	{
		return Math.looseEquals(v.x(), w.x()) && Math.looseEquals(v.y(), w.y()) && Math.looseEquals(v.z(), w.z()) && Math.nearZero(w.w());
	}
	
	public static boolean equals(Vector3fGetter v, Vector3fGetter w)
	{
		return Math.looseEquals(v.x(), w.x()) && Math.looseEquals(v.y(), w.y()) && Math.looseEquals(v.z(), w.z());
	}
	
	public static boolean equals(Vector3fGetter v, Vector2fGetter w)
	{
		return Math.looseEquals(v.x(), w.x()) && Math.looseEquals(v.y(), w.y()) && Math.nearZero(v.z());
	}
	
	public static boolean equals(Vector2fGetter v, Vector4fGetter w)
	{
		return Math.looseEquals(v.x(), w.x()) && Math.looseEquals(v.y(), w.y()) && Math.nearZero(w.z()) && Math.nearZero(w.w());
	}
	
	public static boolean equals(Vector2fGetter v, Vector3fGetter w)
	{
		return Math.looseEquals(v.x(), w.x()) && Math.looseEquals(v.y(), w.y()) && Math.nearZero(w.z());
	}
	
	public static boolean equals(Vector2fGetter v, Vector2fGetter w)
	{
		return Math.looseEquals(v.x(), w.x()) && Math.looseEquals(v.y(), w.y());
	}
}

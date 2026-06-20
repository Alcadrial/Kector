package com.alcadrial.kector;

import static com.alcadrial.kector.Math.*;
import com.alcadrial.kector.vector.Vector2ir;
import com.alcadrial.kector.vector.Vector2lr;
import com.alcadrial.kector.vector.Vector2fr;
import com.alcadrial.kector.vector.Vector2dr;
import com.alcadrial.kector.vector.Vector3ir;
import com.alcadrial.kector.vector.Vector3lr;
import com.alcadrial.kector.vector.Vector3fr;
import com.alcadrial.kector.vector.Vector3dr;
import com.alcadrial.kector.vector.Vector4ir;
import com.alcadrial.kector.vector.Vector4lr;
import com.alcadrial.kector.vector.Vector4fr;
import com.alcadrial.kector.vector.Vector4dr;
import com.alcadrial.kector.vector.Vector3f;
import com.alcadrial.kector.vector.quaternion.Quaternionfr;
import com.alcadrial.kector.vector.Vector3d;
import com.alcadrial.kector.vector.quaternion.Quaterniondr;

public class VectorMath {

	public static int squareLength(Vector2ir v)
	{
		return v.x() * v.x() + v.y() * v.y();
	}
	public static int absoluteLength(Vector2ir v)
	{
		return abs(v.x()) + abs(v.y());
	}
	public static int absoluteSize(Vector2ir v)
	{
		return absoluteLength(v);
	}
	public static float length(Vector2ir v)
	{
		return sqrt(squareLength(v));
	}
	public static float size(Vector2ir v)
	{
		return length(v);
	}
	public static int maxSize(Vector2ir v)
	{
		int a = abs(v.x()), b;
		b = abs(v.y());
		if (a < b) a = b;
		return a;
	}
	public static long squareDistance(Vector2ir v, Vector2ir w)
	{
		return (v.x() - w.x()) * (v.x() - w.x()) + (v.y() - w.y()) * (v.y() - w.y());
	}
	public static long absoluteDistance(Vector2ir v, Vector2ir w)
	{
		return abs(v.x() - w.x()) + abs(v.y() - w.y());
	}
	public static long dotProduct(Vector2ir v, Vector2ir w)
	{
		return v.x() * w.x() + v.y() * w.y();
	}
	public static int distance(Vector2ir v, Vector2ir w)
	{
		return (int) sqrt(squareDistance(v, w));
	}
	public static int maxDistance(Vector2ir v, Vector2ir w)
	{
		int a = abs(v.x() - w.x()), b;
		b = abs(v.y() - w.y());
		if (a < b) a = b;
		return a;
	}
	public static boolean equals(Vector2ir v, Vector2ir w)
	{
		return v.x() == w.x() && v.y() == w.y();
	}
	public static boolean looseEquals(Vector2ir v, Vector2ir w)
	{
		return Math.looseEquals(v.x(), w.x()) && Math.looseEquals(v.y(), w.y());
	}

	public static long squareDistance(Vector2ir v, Vector2lr w)
	{
		return (v.x() - w.x()) * (v.x() - w.x()) + (v.y() - w.y()) * (v.y() - w.y());
	}
	public static long absoluteDistance(Vector2ir v, Vector2lr w)
	{
		return abs(v.x() - w.x()) + abs(v.y() - w.y());
	}
	public static long dotProduct(Vector2ir v, Vector2lr w)
	{
		return v.x() * w.x() + v.y() * w.y();
	}
	public static long distance(Vector2ir v, Vector2lr w)
	{
		return (long) sqrt(squareDistance(v, w));
	}
	public static long maxDistance(Vector2ir v, Vector2lr w)
	{
		long a = abs(v.x() - w.x()), b;
		b = abs(v.y() - w.y());
		if (a < b) a = b;
		return a;
	}
	public static boolean equals(Vector2ir v, Vector2lr w)
	{
		return v.x() == w.x() && v.y() == w.y();
	}
	public static boolean looseEquals(Vector2ir v, Vector2lr w)
	{
		return Math.looseEquals(v.x(), w.x()) && Math.looseEquals(v.y(), w.y());
	}

	public static float squareDistance(Vector2ir v, Vector2fr w)
	{
		return (v.x() - w.x()) * (v.x() - w.x()) + (v.y() - w.y()) * (v.y() - w.y());
	}
	public static float absoluteDistance(Vector2ir v, Vector2fr w)
	{
		return abs(v.x() - w.x()) + abs(v.y() - w.y());
	}
	public static float dotProduct(Vector2ir v, Vector2fr w)
	{
		return v.x() * w.x() + v.y() * w.y();
	}
	public static float distance(Vector2ir v, Vector2fr w)
	{
		return (float) sqrt(squareDistance(v, w));
	}
	public static float maxDistance(Vector2ir v, Vector2fr w)
	{
		float a = abs(v.x() - w.x()), b;
		b = abs(v.y() - w.y());
		if (a < b) a = b;
		return a;
	}
	public static boolean equals(Vector2ir v, Vector2fr w)
	{
		return v.x() == w.x() && v.y() == w.y();
	}
	public static boolean looseEquals(Vector2ir v, Vector2fr w)
	{
		return Math.looseEquals(v.x(), w.x()) && Math.looseEquals(v.y(), w.y());
	}

	public static double squareDistance(Vector2ir v, Vector2dr w)
	{
		return (v.x() - w.x()) * (v.x() - w.x()) + (v.y() - w.y()) * (v.y() - w.y());
	}
	public static double absoluteDistance(Vector2ir v, Vector2dr w)
	{
		return abs(v.x() - w.x()) + abs(v.y() - w.y());
	}
	public static double dotProduct(Vector2ir v, Vector2dr w)
	{
		return v.x() * w.x() + v.y() * w.y();
	}
	public static double distance(Vector2ir v, Vector2dr w)
	{
		return (double) sqrt(squareDistance(v, w));
	}
	public static double maxDistance(Vector2ir v, Vector2dr w)
	{
		double a = abs(v.x() - w.x()), b;
		b = abs(v.y() - w.y());
		if (a < b) a = b;
		return a;
	}
	public static boolean equals(Vector2ir v, Vector2dr w)
	{
		return v.x() == w.x() && v.y() == w.y();
	}
	public static boolean looseEquals(Vector2ir v, Vector2dr w)
	{
		return Math.looseEquals(v.x(), w.x()) && Math.looseEquals(v.y(), w.y());
	}

	public static long squareDistance(Vector2ir v, Vector3ir w)
	{
		return (v.x() - w.x()) * (v.x() - w.x()) + (v.y() - w.y()) * (v.y() - w.y());
	}
	public static long absoluteDistance(Vector2ir v, Vector3ir w)
	{
		return abs(v.x() - w.x()) + abs(v.y() - w.y());
	}
	public static long dotProduct(Vector2ir v, Vector3ir w)
	{
		return v.x() * w.x() + v.y() * w.y();
	}
	public static int distance(Vector2ir v, Vector3ir w)
	{
		return (int) sqrt(squareDistance(v, w));
	}
	public static int maxDistance(Vector2ir v, Vector3ir w)
	{
		int a = abs(v.x() - w.x()), b;
		b = abs(v.y() - w.y());
		if (a < b) a = b;
		return a;
	}
	public static boolean equals(Vector2ir v, Vector3ir w)
	{
		return v.x() == w.x() && v.y() == w.y();
	}
	public static boolean looseEquals(Vector2ir v, Vector3ir w)
	{
		return Math.looseEquals(v.x(), w.x()) && Math.looseEquals(v.y(), w.y());
	}

	public static long squareDistance(Vector2ir v, Vector3lr w)
	{
		return (v.x() - w.x()) * (v.x() - w.x()) + (v.y() - w.y()) * (v.y() - w.y());
	}
	public static long absoluteDistance(Vector2ir v, Vector3lr w)
	{
		return abs(v.x() - w.x()) + abs(v.y() - w.y());
	}
	public static long dotProduct(Vector2ir v, Vector3lr w)
	{
		return v.x() * w.x() + v.y() * w.y();
	}
	public static long distance(Vector2ir v, Vector3lr w)
	{
		return (long) sqrt(squareDistance(v, w));
	}
	public static long maxDistance(Vector2ir v, Vector3lr w)
	{
		long a = abs(v.x() - w.x()), b;
		b = abs(v.y() - w.y());
		if (a < b) a = b;
		return a;
	}
	public static boolean equals(Vector2ir v, Vector3lr w)
	{
		return v.x() == w.x() && v.y() == w.y();
	}
	public static boolean looseEquals(Vector2ir v, Vector3lr w)
	{
		return Math.looseEquals(v.x(), w.x()) && Math.looseEquals(v.y(), w.y());
	}

	public static float squareDistance(Vector2ir v, Vector3fr w)
	{
		return (v.x() - w.x()) * (v.x() - w.x()) + (v.y() - w.y()) * (v.y() - w.y());
	}
	public static float absoluteDistance(Vector2ir v, Vector3fr w)
	{
		return abs(v.x() - w.x()) + abs(v.y() - w.y());
	}
	public static float dotProduct(Vector2ir v, Vector3fr w)
	{
		return v.x() * w.x() + v.y() * w.y();
	}
	public static float distance(Vector2ir v, Vector3fr w)
	{
		return (float) sqrt(squareDistance(v, w));
	}
	public static float maxDistance(Vector2ir v, Vector3fr w)
	{
		float a = abs(v.x() - w.x()), b;
		b = abs(v.y() - w.y());
		if (a < b) a = b;
		return a;
	}
	public static boolean equals(Vector2ir v, Vector3fr w)
	{
		return v.x() == w.x() && v.y() == w.y();
	}
	public static boolean looseEquals(Vector2ir v, Vector3fr w)
	{
		return Math.looseEquals(v.x(), w.x()) && Math.looseEquals(v.y(), w.y());
	}

	public static double squareDistance(Vector2ir v, Vector3dr w)
	{
		return (v.x() - w.x()) * (v.x() - w.x()) + (v.y() - w.y()) * (v.y() - w.y());
	}
	public static double absoluteDistance(Vector2ir v, Vector3dr w)
	{
		return abs(v.x() - w.x()) + abs(v.y() - w.y());
	}
	public static double dotProduct(Vector2ir v, Vector3dr w)
	{
		return v.x() * w.x() + v.y() * w.y();
	}
	public static double distance(Vector2ir v, Vector3dr w)
	{
		return (double) sqrt(squareDistance(v, w));
	}
	public static double maxDistance(Vector2ir v, Vector3dr w)
	{
		double a = abs(v.x() - w.x()), b;
		b = abs(v.y() - w.y());
		if (a < b) a = b;
		return a;
	}
	public static boolean equals(Vector2ir v, Vector3dr w)
	{
		return v.x() == w.x() && v.y() == w.y();
	}
	public static boolean looseEquals(Vector2ir v, Vector3dr w)
	{
		return Math.looseEquals(v.x(), w.x()) && Math.looseEquals(v.y(), w.y());
	}

	public static long squareDistance(Vector2ir v, Vector4ir w)
	{
		return (v.x() - w.x()) * (v.x() - w.x()) + (v.y() - w.y()) * (v.y() - w.y());
	}
	public static long absoluteDistance(Vector2ir v, Vector4ir w)
	{
		return abs(v.x() - w.x()) + abs(v.y() - w.y());
	}
	public static long dotProduct(Vector2ir v, Vector4ir w)
	{
		return v.x() * w.x() + v.y() * w.y();
	}
	public static int distance(Vector2ir v, Vector4ir w)
	{
		return (int) sqrt(squareDistance(v, w));
	}
	public static int maxDistance(Vector2ir v, Vector4ir w)
	{
		int a = abs(v.x() - w.x()), b;
		b = abs(v.y() - w.y());
		if (a < b) a = b;
		return a;
	}
	public static boolean equals(Vector2ir v, Vector4ir w)
	{
		return v.x() == w.x() && v.y() == w.y();
	}
	public static boolean looseEquals(Vector2ir v, Vector4ir w)
	{
		return Math.looseEquals(v.x(), w.x()) && Math.looseEquals(v.y(), w.y());
	}

	public static long squareDistance(Vector2ir v, Vector4lr w)
	{
		return (v.x() - w.x()) * (v.x() - w.x()) + (v.y() - w.y()) * (v.y() - w.y());
	}
	public static long absoluteDistance(Vector2ir v, Vector4lr w)
	{
		return abs(v.x() - w.x()) + abs(v.y() - w.y());
	}
	public static long dotProduct(Vector2ir v, Vector4lr w)
	{
		return v.x() * w.x() + v.y() * w.y();
	}
	public static long distance(Vector2ir v, Vector4lr w)
	{
		return (long) sqrt(squareDistance(v, w));
	}
	public static long maxDistance(Vector2ir v, Vector4lr w)
	{
		long a = abs(v.x() - w.x()), b;
		b = abs(v.y() - w.y());
		if (a < b) a = b;
		return a;
	}
	public static boolean equals(Vector2ir v, Vector4lr w)
	{
		return v.x() == w.x() && v.y() == w.y();
	}
	public static boolean looseEquals(Vector2ir v, Vector4lr w)
	{
		return Math.looseEquals(v.x(), w.x()) && Math.looseEquals(v.y(), w.y());
	}

	public static float squareDistance(Vector2ir v, Vector4fr w)
	{
		return (v.x() - w.x()) * (v.x() - w.x()) + (v.y() - w.y()) * (v.y() - w.y());
	}
	public static float absoluteDistance(Vector2ir v, Vector4fr w)
	{
		return abs(v.x() - w.x()) + abs(v.y() - w.y());
	}
	public static float dotProduct(Vector2ir v, Vector4fr w)
	{
		return v.x() * w.x() + v.y() * w.y();
	}
	public static float distance(Vector2ir v, Vector4fr w)
	{
		return (float) sqrt(squareDistance(v, w));
	}
	public static float maxDistance(Vector2ir v, Vector4fr w)
	{
		float a = abs(v.x() - w.x()), b;
		b = abs(v.y() - w.y());
		if (a < b) a = b;
		return a;
	}
	public static boolean equals(Vector2ir v, Vector4fr w)
	{
		return v.x() == w.x() && v.y() == w.y();
	}
	public static boolean looseEquals(Vector2ir v, Vector4fr w)
	{
		return Math.looseEquals(v.x(), w.x()) && Math.looseEquals(v.y(), w.y());
	}

	public static double squareDistance(Vector2ir v, Vector4dr w)
	{
		return (v.x() - w.x()) * (v.x() - w.x()) + (v.y() - w.y()) * (v.y() - w.y());
	}
	public static double absoluteDistance(Vector2ir v, Vector4dr w)
	{
		return abs(v.x() - w.x()) + abs(v.y() - w.y());
	}
	public static double dotProduct(Vector2ir v, Vector4dr w)
	{
		return v.x() * w.x() + v.y() * w.y();
	}
	public static double distance(Vector2ir v, Vector4dr w)
	{
		return (double) sqrt(squareDistance(v, w));
	}
	public static double maxDistance(Vector2ir v, Vector4dr w)
	{
		double a = abs(v.x() - w.x()), b;
		b = abs(v.y() - w.y());
		if (a < b) a = b;
		return a;
	}
	public static boolean equals(Vector2ir v, Vector4dr w)
	{
		return v.x() == w.x() && v.y() == w.y();
	}
	public static boolean looseEquals(Vector2ir v, Vector4dr w)
	{
		return Math.looseEquals(v.x(), w.x()) && Math.looseEquals(v.y(), w.y());
	}

	public static long squareLength(Vector2lr v)
	{
		return v.x() * v.x() + v.y() * v.y();
	}
	public static long absoluteLength(Vector2lr v)
	{
		return abs(v.x()) + abs(v.y());
	}
	public static long absoluteSize(Vector2lr v)
	{
		return absoluteLength(v);
	}
	public static double length(Vector2lr v)
	{
		return sqrt(squareLength(v));
	}
	public static double size(Vector2lr v)
	{
		return length(v);
	}
	public static long maxSize(Vector2lr v)
	{
		long a = abs(v.x()), b;
		b = abs(v.y());
		if (a < b) a = b;
		return a;
	}
	public static double squareDistance(Vector2lr v, Vector2lr w)
	{
		return (v.x() - w.x()) * (v.x() - w.x()) + (v.y() - w.y()) * (v.y() - w.y());
	}
	public static double absoluteDistance(Vector2lr v, Vector2lr w)
	{
		return abs(v.x() - w.x()) + abs(v.y() - w.y());
	}
	public static double dotProduct(Vector2lr v, Vector2lr w)
	{
		return v.x() * w.x() + v.y() * w.y();
	}
	public static long distance(Vector2lr v, Vector2lr w)
	{
		return (long) sqrt(squareDistance(v, w));
	}
	public static long maxDistance(Vector2lr v, Vector2lr w)
	{
		long a = abs(v.x() - w.x()), b;
		b = abs(v.y() - w.y());
		if (a < b) a = b;
		return a;
	}
	public static boolean equals(Vector2lr v, Vector2lr w)
	{
		return v.x() == w.x() && v.y() == w.y();
	}
	public static boolean looseEquals(Vector2lr v, Vector2lr w)
	{
		return Math.looseEquals(v.x(), w.x()) && Math.looseEquals(v.y(), w.y());
	}

	public static float squareDistance(Vector2lr v, Vector2fr w)
	{
		return (v.x() - w.x()) * (v.x() - w.x()) + (v.y() - w.y()) * (v.y() - w.y());
	}
	public static float absoluteDistance(Vector2lr v, Vector2fr w)
	{
		return abs(v.x() - w.x()) + abs(v.y() - w.y());
	}
	public static float dotProduct(Vector2lr v, Vector2fr w)
	{
		return v.x() * w.x() + v.y() * w.y();
	}
	public static float distance(Vector2lr v, Vector2fr w)
	{
		return (float) sqrt(squareDistance(v, w));
	}
	public static float maxDistance(Vector2lr v, Vector2fr w)
	{
		float a = abs(v.x() - w.x()), b;
		b = abs(v.y() - w.y());
		if (a < b) a = b;
		return a;
	}
	public static boolean equals(Vector2lr v, Vector2fr w)
	{
		return v.x() == w.x() && v.y() == w.y();
	}
	public static boolean looseEquals(Vector2lr v, Vector2fr w)
	{
		return Math.looseEquals(v.x(), w.x()) && Math.looseEquals(v.y(), w.y());
	}

	public static double squareDistance(Vector2lr v, Vector2dr w)
	{
		return (v.x() - w.x()) * (v.x() - w.x()) + (v.y() - w.y()) * (v.y() - w.y());
	}
	public static double absoluteDistance(Vector2lr v, Vector2dr w)
	{
		return abs(v.x() - w.x()) + abs(v.y() - w.y());
	}
	public static double dotProduct(Vector2lr v, Vector2dr w)
	{
		return v.x() * w.x() + v.y() * w.y();
	}
	public static double distance(Vector2lr v, Vector2dr w)
	{
		return (double) sqrt(squareDistance(v, w));
	}
	public static double maxDistance(Vector2lr v, Vector2dr w)
	{
		double a = abs(v.x() - w.x()), b;
		b = abs(v.y() - w.y());
		if (a < b) a = b;
		return a;
	}
	public static boolean equals(Vector2lr v, Vector2dr w)
	{
		return v.x() == w.x() && v.y() == w.y();
	}
	public static boolean looseEquals(Vector2lr v, Vector2dr w)
	{
		return Math.looseEquals(v.x(), w.x()) && Math.looseEquals(v.y(), w.y());
	}

	public static double squareDistance(Vector2lr v, Vector3lr w)
	{
		return (v.x() - w.x()) * (v.x() - w.x()) + (v.y() - w.y()) * (v.y() - w.y());
	}
	public static double absoluteDistance(Vector2lr v, Vector3lr w)
	{
		return abs(v.x() - w.x()) + abs(v.y() - w.y());
	}
	public static double dotProduct(Vector2lr v, Vector3lr w)
	{
		return v.x() * w.x() + v.y() * w.y();
	}
	public static long distance(Vector2lr v, Vector3lr w)
	{
		return (long) sqrt(squareDistance(v, w));
	}
	public static long maxDistance(Vector2lr v, Vector3lr w)
	{
		long a = abs(v.x() - w.x()), b;
		b = abs(v.y() - w.y());
		if (a < b) a = b;
		return a;
	}
	public static boolean equals(Vector2lr v, Vector3lr w)
	{
		return v.x() == w.x() && v.y() == w.y();
	}
	public static boolean looseEquals(Vector2lr v, Vector3lr w)
	{
		return Math.looseEquals(v.x(), w.x()) && Math.looseEquals(v.y(), w.y());
	}

	public static float squareDistance(Vector2lr v, Vector3fr w)
	{
		return (v.x() - w.x()) * (v.x() - w.x()) + (v.y() - w.y()) * (v.y() - w.y());
	}
	public static float absoluteDistance(Vector2lr v, Vector3fr w)
	{
		return abs(v.x() - w.x()) + abs(v.y() - w.y());
	}
	public static float dotProduct(Vector2lr v, Vector3fr w)
	{
		return v.x() * w.x() + v.y() * w.y();
	}
	public static float distance(Vector2lr v, Vector3fr w)
	{
		return (float) sqrt(squareDistance(v, w));
	}
	public static float maxDistance(Vector2lr v, Vector3fr w)
	{
		float a = abs(v.x() - w.x()), b;
		b = abs(v.y() - w.y());
		if (a < b) a = b;
		return a;
	}
	public static boolean equals(Vector2lr v, Vector3fr w)
	{
		return v.x() == w.x() && v.y() == w.y();
	}
	public static boolean looseEquals(Vector2lr v, Vector3fr w)
	{
		return Math.looseEquals(v.x(), w.x()) && Math.looseEquals(v.y(), w.y());
	}

	public static double squareDistance(Vector2lr v, Vector3dr w)
	{
		return (v.x() - w.x()) * (v.x() - w.x()) + (v.y() - w.y()) * (v.y() - w.y());
	}
	public static double absoluteDistance(Vector2lr v, Vector3dr w)
	{
		return abs(v.x() - w.x()) + abs(v.y() - w.y());
	}
	public static double dotProduct(Vector2lr v, Vector3dr w)
	{
		return v.x() * w.x() + v.y() * w.y();
	}
	public static double distance(Vector2lr v, Vector3dr w)
	{
		return (double) sqrt(squareDistance(v, w));
	}
	public static double maxDistance(Vector2lr v, Vector3dr w)
	{
		double a = abs(v.x() - w.x()), b;
		b = abs(v.y() - w.y());
		if (a < b) a = b;
		return a;
	}
	public static boolean equals(Vector2lr v, Vector3dr w)
	{
		return v.x() == w.x() && v.y() == w.y();
	}
	public static boolean looseEquals(Vector2lr v, Vector3dr w)
	{
		return Math.looseEquals(v.x(), w.x()) && Math.looseEquals(v.y(), w.y());
	}

	public static double squareDistance(Vector2lr v, Vector4lr w)
	{
		return (v.x() - w.x()) * (v.x() - w.x()) + (v.y() - w.y()) * (v.y() - w.y());
	}
	public static double absoluteDistance(Vector2lr v, Vector4lr w)
	{
		return abs(v.x() - w.x()) + abs(v.y() - w.y());
	}
	public static double dotProduct(Vector2lr v, Vector4lr w)
	{
		return v.x() * w.x() + v.y() * w.y();
	}
	public static long distance(Vector2lr v, Vector4lr w)
	{
		return (long) sqrt(squareDistance(v, w));
	}
	public static long maxDistance(Vector2lr v, Vector4lr w)
	{
		long a = abs(v.x() - w.x()), b;
		b = abs(v.y() - w.y());
		if (a < b) a = b;
		return a;
	}
	public static boolean equals(Vector2lr v, Vector4lr w)
	{
		return v.x() == w.x() && v.y() == w.y();
	}
	public static boolean looseEquals(Vector2lr v, Vector4lr w)
	{
		return Math.looseEquals(v.x(), w.x()) && Math.looseEquals(v.y(), w.y());
	}

	public static float squareDistance(Vector2lr v, Vector4fr w)
	{
		return (v.x() - w.x()) * (v.x() - w.x()) + (v.y() - w.y()) * (v.y() - w.y());
	}
	public static float absoluteDistance(Vector2lr v, Vector4fr w)
	{
		return abs(v.x() - w.x()) + abs(v.y() - w.y());
	}
	public static float dotProduct(Vector2lr v, Vector4fr w)
	{
		return v.x() * w.x() + v.y() * w.y();
	}
	public static float distance(Vector2lr v, Vector4fr w)
	{
		return (float) sqrt(squareDistance(v, w));
	}
	public static float maxDistance(Vector2lr v, Vector4fr w)
	{
		float a = abs(v.x() - w.x()), b;
		b = abs(v.y() - w.y());
		if (a < b) a = b;
		return a;
	}
	public static boolean equals(Vector2lr v, Vector4fr w)
	{
		return v.x() == w.x() && v.y() == w.y();
	}
	public static boolean looseEquals(Vector2lr v, Vector4fr w)
	{
		return Math.looseEquals(v.x(), w.x()) && Math.looseEquals(v.y(), w.y());
	}

	public static double squareDistance(Vector2lr v, Vector4dr w)
	{
		return (v.x() - w.x()) * (v.x() - w.x()) + (v.y() - w.y()) * (v.y() - w.y());
	}
	public static double absoluteDistance(Vector2lr v, Vector4dr w)
	{
		return abs(v.x() - w.x()) + abs(v.y() - w.y());
	}
	public static double dotProduct(Vector2lr v, Vector4dr w)
	{
		return v.x() * w.x() + v.y() * w.y();
	}
	public static double distance(Vector2lr v, Vector4dr w)
	{
		return (double) sqrt(squareDistance(v, w));
	}
	public static double maxDistance(Vector2lr v, Vector4dr w)
	{
		double a = abs(v.x() - w.x()), b;
		b = abs(v.y() - w.y());
		if (a < b) a = b;
		return a;
	}
	public static boolean equals(Vector2lr v, Vector4dr w)
	{
		return v.x() == w.x() && v.y() == w.y();
	}
	public static boolean looseEquals(Vector2lr v, Vector4dr w)
	{
		return Math.looseEquals(v.x(), w.x()) && Math.looseEquals(v.y(), w.y());
	}

	public static float squareLength(Vector2fr v)
	{
		return v.x() * v.x() + v.y() * v.y();
	}
	public static float absoluteLength(Vector2fr v)
	{
		return abs(v.x()) + abs(v.y());
	}
	public static float absoluteSize(Vector2fr v)
	{
		return absoluteLength(v);
	}
	public static float length(Vector2fr v)
	{
		return sqrt(squareLength(v));
	}
	public static float size(Vector2fr v)
	{
		return length(v);
	}
	public static float maxSize(Vector2fr v)
	{
		float a = abs(v.x()), b;
		b = abs(v.y());
		if (a < b) a = b;
		return a;
	}
	public static double squareDistance(Vector2fr v, Vector2fr w)
	{
		return (v.x() - w.x()) * (v.x() - w.x()) + (v.y() - w.y()) * (v.y() - w.y());
	}
	public static double absoluteDistance(Vector2fr v, Vector2fr w)
	{
		return abs(v.x() - w.x()) + abs(v.y() - w.y());
	}
	public static double dotProduct(Vector2fr v, Vector2fr w)
	{
		return v.x() * w.x() + v.y() * w.y();
	}
	public static float distance(Vector2fr v, Vector2fr w)
	{
		return (float) sqrt(squareDistance(v, w));
	}
	public static float maxDistance(Vector2fr v, Vector2fr w)
	{
		float a = abs(v.x() - w.x()), b;
		b = abs(v.y() - w.y());
		if (a < b) a = b;
		return a;
	}
	public static boolean equals(Vector2fr v, Vector2fr w)
	{
		return v.x() == w.x() && v.y() == w.y();
	}
	public static boolean looseEquals(Vector2fr v, Vector2fr w)
	{
		return Math.looseEquals(v.x(), w.x()) && Math.looseEquals(v.y(), w.y());
	}

	public static double squareDistance(Vector2fr v, Vector2dr w)
	{
		return (v.x() - w.x()) * (v.x() - w.x()) + (v.y() - w.y()) * (v.y() - w.y());
	}
	public static double absoluteDistance(Vector2fr v, Vector2dr w)
	{
		return abs(v.x() - w.x()) + abs(v.y() - w.y());
	}
	public static double dotProduct(Vector2fr v, Vector2dr w)
	{
		return v.x() * w.x() + v.y() * w.y();
	}
	public static double distance(Vector2fr v, Vector2dr w)
	{
		return (double) sqrt(squareDistance(v, w));
	}
	public static double maxDistance(Vector2fr v, Vector2dr w)
	{
		double a = abs(v.x() - w.x()), b;
		b = abs(v.y() - w.y());
		if (a < b) a = b;
		return a;
	}
	public static boolean equals(Vector2fr v, Vector2dr w)
	{
		return v.x() == w.x() && v.y() == w.y();
	}
	public static boolean looseEquals(Vector2fr v, Vector2dr w)
	{
		return Math.looseEquals(v.x(), w.x()) && Math.looseEquals(v.y(), w.y());
	}

	public static double squareDistance(Vector2fr v, Vector3fr w)
	{
		return (v.x() - w.x()) * (v.x() - w.x()) + (v.y() - w.y()) * (v.y() - w.y());
	}
	public static double absoluteDistance(Vector2fr v, Vector3fr w)
	{
		return abs(v.x() - w.x()) + abs(v.y() - w.y());
	}
	public static double dotProduct(Vector2fr v, Vector3fr w)
	{
		return v.x() * w.x() + v.y() * w.y();
	}
	public static float distance(Vector2fr v, Vector3fr w)
	{
		return (float) sqrt(squareDistance(v, w));
	}
	public static float maxDistance(Vector2fr v, Vector3fr w)
	{
		float a = abs(v.x() - w.x()), b;
		b = abs(v.y() - w.y());
		if (a < b) a = b;
		return a;
	}
	public static boolean equals(Vector2fr v, Vector3fr w)
	{
		return v.x() == w.x() && v.y() == w.y();
	}
	public static boolean looseEquals(Vector2fr v, Vector3fr w)
	{
		return Math.looseEquals(v.x(), w.x()) && Math.looseEquals(v.y(), w.y());
	}

	public static double squareDistance(Vector2fr v, Vector3dr w)
	{
		return (v.x() - w.x()) * (v.x() - w.x()) + (v.y() - w.y()) * (v.y() - w.y());
	}
	public static double absoluteDistance(Vector2fr v, Vector3dr w)
	{
		return abs(v.x() - w.x()) + abs(v.y() - w.y());
	}
	public static double dotProduct(Vector2fr v, Vector3dr w)
	{
		return v.x() * w.x() + v.y() * w.y();
	}
	public static double distance(Vector2fr v, Vector3dr w)
	{
		return (double) sqrt(squareDistance(v, w));
	}
	public static double maxDistance(Vector2fr v, Vector3dr w)
	{
		double a = abs(v.x() - w.x()), b;
		b = abs(v.y() - w.y());
		if (a < b) a = b;
		return a;
	}
	public static boolean equals(Vector2fr v, Vector3dr w)
	{
		return v.x() == w.x() && v.y() == w.y();
	}
	public static boolean looseEquals(Vector2fr v, Vector3dr w)
	{
		return Math.looseEquals(v.x(), w.x()) && Math.looseEquals(v.y(), w.y());
	}

	public static double squareDistance(Vector2fr v, Vector4fr w)
	{
		return (v.x() - w.x()) * (v.x() - w.x()) + (v.y() - w.y()) * (v.y() - w.y());
	}
	public static double absoluteDistance(Vector2fr v, Vector4fr w)
	{
		return abs(v.x() - w.x()) + abs(v.y() - w.y());
	}
	public static double dotProduct(Vector2fr v, Vector4fr w)
	{
		return v.x() * w.x() + v.y() * w.y();
	}
	public static float distance(Vector2fr v, Vector4fr w)
	{
		return (float) sqrt(squareDistance(v, w));
	}
	public static float maxDistance(Vector2fr v, Vector4fr w)
	{
		float a = abs(v.x() - w.x()), b;
		b = abs(v.y() - w.y());
		if (a < b) a = b;
		return a;
	}
	public static boolean equals(Vector2fr v, Vector4fr w)
	{
		return v.x() == w.x() && v.y() == w.y();
	}
	public static boolean looseEquals(Vector2fr v, Vector4fr w)
	{
		return Math.looseEquals(v.x(), w.x()) && Math.looseEquals(v.y(), w.y());
	}

	public static double squareDistance(Vector2fr v, Vector4dr w)
	{
		return (v.x() - w.x()) * (v.x() - w.x()) + (v.y() - w.y()) * (v.y() - w.y());
	}
	public static double absoluteDistance(Vector2fr v, Vector4dr w)
	{
		return abs(v.x() - w.x()) + abs(v.y() - w.y());
	}
	public static double dotProduct(Vector2fr v, Vector4dr w)
	{
		return v.x() * w.x() + v.y() * w.y();
	}
	public static double distance(Vector2fr v, Vector4dr w)
	{
		return (double) sqrt(squareDistance(v, w));
	}
	public static double maxDistance(Vector2fr v, Vector4dr w)
	{
		double a = abs(v.x() - w.x()), b;
		b = abs(v.y() - w.y());
		if (a < b) a = b;
		return a;
	}
	public static boolean equals(Vector2fr v, Vector4dr w)
	{
		return v.x() == w.x() && v.y() == w.y();
	}
	public static boolean looseEquals(Vector2fr v, Vector4dr w)
	{
		return Math.looseEquals(v.x(), w.x()) && Math.looseEquals(v.y(), w.y());
	}

	public static double squareLength(Vector2dr v)
	{
		return v.x() * v.x() + v.y() * v.y();
	}
	public static double absoluteLength(Vector2dr v)
	{
		return abs(v.x()) + abs(v.y());
	}
	public static double absoluteSize(Vector2dr v)
	{
		return absoluteLength(v);
	}
	public static double length(Vector2dr v)
	{
		return sqrt(squareLength(v));
	}
	public static double size(Vector2dr v)
	{
		return length(v);
	}
	public static double maxSize(Vector2dr v)
	{
		double a = abs(v.x()), b;
		b = abs(v.y());
		if (a < b) a = b;
		return a;
	}
	public static double squareDistance(Vector2dr v, Vector2dr w)
	{
		return (v.x() - w.x()) * (v.x() - w.x()) + (v.y() - w.y()) * (v.y() - w.y());
	}
	public static double absoluteDistance(Vector2dr v, Vector2dr w)
	{
		return abs(v.x() - w.x()) + abs(v.y() - w.y());
	}
	public static double dotProduct(Vector2dr v, Vector2dr w)
	{
		return v.x() * w.x() + v.y() * w.y();
	}
	public static double distance(Vector2dr v, Vector2dr w)
	{
		return (double) sqrt(squareDistance(v, w));
	}
	public static double maxDistance(Vector2dr v, Vector2dr w)
	{
		double a = abs(v.x() - w.x()), b;
		b = abs(v.y() - w.y());
		if (a < b) a = b;
		return a;
	}
	public static boolean equals(Vector2dr v, Vector2dr w)
	{
		return v.x() == w.x() && v.y() == w.y();
	}
	public static boolean looseEquals(Vector2dr v, Vector2dr w)
	{
		return Math.looseEquals(v.x(), w.x()) && Math.looseEquals(v.y(), w.y());
	}

	public static double squareDistance(Vector2dr v, Vector3dr w)
	{
		return (v.x() - w.x()) * (v.x() - w.x()) + (v.y() - w.y()) * (v.y() - w.y());
	}
	public static double absoluteDistance(Vector2dr v, Vector3dr w)
	{
		return abs(v.x() - w.x()) + abs(v.y() - w.y());
	}
	public static double dotProduct(Vector2dr v, Vector3dr w)
	{
		return v.x() * w.x() + v.y() * w.y();
	}
	public static double distance(Vector2dr v, Vector3dr w)
	{
		return (double) sqrt(squareDistance(v, w));
	}
	public static double maxDistance(Vector2dr v, Vector3dr w)
	{
		double a = abs(v.x() - w.x()), b;
		b = abs(v.y() - w.y());
		if (a < b) a = b;
		return a;
	}
	public static boolean equals(Vector2dr v, Vector3dr w)
	{
		return v.x() == w.x() && v.y() == w.y();
	}
	public static boolean looseEquals(Vector2dr v, Vector3dr w)
	{
		return Math.looseEquals(v.x(), w.x()) && Math.looseEquals(v.y(), w.y());
	}

	public static double squareDistance(Vector2dr v, Vector4dr w)
	{
		return (v.x() - w.x()) * (v.x() - w.x()) + (v.y() - w.y()) * (v.y() - w.y());
	}
	public static double absoluteDistance(Vector2dr v, Vector4dr w)
	{
		return abs(v.x() - w.x()) + abs(v.y() - w.y());
	}
	public static double dotProduct(Vector2dr v, Vector4dr w)
	{
		return v.x() * w.x() + v.y() * w.y();
	}
	public static double distance(Vector2dr v, Vector4dr w)
	{
		return (double) sqrt(squareDistance(v, w));
	}
	public static double maxDistance(Vector2dr v, Vector4dr w)
	{
		double a = abs(v.x() - w.x()), b;
		b = abs(v.y() - w.y());
		if (a < b) a = b;
		return a;
	}
	public static boolean equals(Vector2dr v, Vector4dr w)
	{
		return v.x() == w.x() && v.y() == w.y();
	}
	public static boolean looseEquals(Vector2dr v, Vector4dr w)
	{
		return Math.looseEquals(v.x(), w.x()) && Math.looseEquals(v.y(), w.y());
	}

	public static int squareLength(Vector3ir v)
	{
		return v.x() * v.x() + v.y() * v.y() + v.z() * v.z();
	}
	public static int absoluteLength(Vector3ir v)
	{
		return abs(v.x()) + abs(v.y()) + abs(v.z());
	}
	public static int absoluteSize(Vector3ir v)
	{
		return absoluteLength(v);
	}
	public static float length(Vector3ir v)
	{
		return sqrt(squareLength(v));
	}
	public static float size(Vector3ir v)
	{
		return length(v);
	}
	public static int maxSize(Vector3ir v)
	{
		int a = abs(v.x()), b;
		b = abs(v.y());
		if (a < b) a = b;
		b = abs(v.z());
		if (a < b) a = b;
		return a;
	}
	public static long squareDistance(Vector3ir v, Vector3ir w)
	{
		return (v.x() - w.x()) * (v.x() - w.x()) + (v.y() - w.y()) * (v.y() - w.y()) + (v.z() - w.z()) * (v.z() - w.z());
	}
	public static long absoluteDistance(Vector3ir v, Vector3ir w)
	{
		return abs(v.x() - w.x()) + abs(v.y() - w.y()) + abs(v.z() - w.z());
	}
	public static long dotProduct(Vector3ir v, Vector3ir w)
	{
		return v.x() * w.x() + v.y() * w.y() + v.z() * w.z();
	}
	public static int distance(Vector3ir v, Vector3ir w)
	{
		return (int) sqrt(squareDistance(v, w));
	}
	public static int maxDistance(Vector3ir v, Vector3ir w)
	{
		int a = abs(v.x() - w.x()), b;
		b = abs(v.y() - w.y());
		if (a < b) a = b;
		b = abs(v.z() - w.z());
		if (a < b) a = b;
		return a;
	}
	public static boolean equals(Vector3ir v, Vector3ir w)
	{
		return v.x() == w.x() && v.y() == w.y() && v.z() == w.z();
	}
	public static boolean looseEquals(Vector3ir v, Vector3ir w)
	{
		return Math.looseEquals(v.x(), w.x()) && Math.looseEquals(v.y(), w.y()) && Math.looseEquals(v.z(), w.z());
	}

	public static long squareDistance(Vector3ir v, Vector3lr w)
	{
		return (v.x() - w.x()) * (v.x() - w.x()) + (v.y() - w.y()) * (v.y() - w.y()) + (v.z() - w.z()) * (v.z() - w.z());
	}
	public static long absoluteDistance(Vector3ir v, Vector3lr w)
	{
		return abs(v.x() - w.x()) + abs(v.y() - w.y()) + abs(v.z() - w.z());
	}
	public static long dotProduct(Vector3ir v, Vector3lr w)
	{
		return v.x() * w.x() + v.y() * w.y() + v.z() * w.z();
	}
	public static long distance(Vector3ir v, Vector3lr w)
	{
		return (long) sqrt(squareDistance(v, w));
	}
	public static long maxDistance(Vector3ir v, Vector3lr w)
	{
		long a = abs(v.x() - w.x()), b;
		b = abs(v.y() - w.y());
		if (a < b) a = b;
		b = abs(v.z() - w.z());
		if (a < b) a = b;
		return a;
	}
	public static boolean equals(Vector3ir v, Vector3lr w)
	{
		return v.x() == w.x() && v.y() == w.y() && v.z() == w.z();
	}
	public static boolean looseEquals(Vector3ir v, Vector3lr w)
	{
		return Math.looseEquals(v.x(), w.x()) && Math.looseEquals(v.y(), w.y()) && Math.looseEquals(v.z(), w.z());
	}

	public static float squareDistance(Vector3ir v, Vector3fr w)
	{
		return (v.x() - w.x()) * (v.x() - w.x()) + (v.y() - w.y()) * (v.y() - w.y()) + (v.z() - w.z()) * (v.z() - w.z());
	}
	public static float absoluteDistance(Vector3ir v, Vector3fr w)
	{
		return abs(v.x() - w.x()) + abs(v.y() - w.y()) + abs(v.z() - w.z());
	}
	public static float dotProduct(Vector3ir v, Vector3fr w)
	{
		return v.x() * w.x() + v.y() * w.y() + v.z() * w.z();
	}
	public static float distance(Vector3ir v, Vector3fr w)
	{
		return (float) sqrt(squareDistance(v, w));
	}
	public static float maxDistance(Vector3ir v, Vector3fr w)
	{
		float a = abs(v.x() - w.x()), b;
		b = abs(v.y() - w.y());
		if (a < b) a = b;
		b = abs(v.z() - w.z());
		if (a < b) a = b;
		return a;
	}
	public static boolean equals(Vector3ir v, Vector3fr w)
	{
		return v.x() == w.x() && v.y() == w.y() && v.z() == w.z();
	}
	public static boolean looseEquals(Vector3ir v, Vector3fr w)
	{
		return Math.looseEquals(v.x(), w.x()) && Math.looseEquals(v.y(), w.y()) && Math.looseEquals(v.z(), w.z());
	}

	public static double squareDistance(Vector3ir v, Vector3dr w)
	{
		return (v.x() - w.x()) * (v.x() - w.x()) + (v.y() - w.y()) * (v.y() - w.y()) + (v.z() - w.z()) * (v.z() - w.z());
	}
	public static double absoluteDistance(Vector3ir v, Vector3dr w)
	{
		return abs(v.x() - w.x()) + abs(v.y() - w.y()) + abs(v.z() - w.z());
	}
	public static double dotProduct(Vector3ir v, Vector3dr w)
	{
		return v.x() * w.x() + v.y() * w.y() + v.z() * w.z();
	}
	public static double distance(Vector3ir v, Vector3dr w)
	{
		return (double) sqrt(squareDistance(v, w));
	}
	public static double maxDistance(Vector3ir v, Vector3dr w)
	{
		double a = abs(v.x() - w.x()), b;
		b = abs(v.y() - w.y());
		if (a < b) a = b;
		b = abs(v.z() - w.z());
		if (a < b) a = b;
		return a;
	}
	public static boolean equals(Vector3ir v, Vector3dr w)
	{
		return v.x() == w.x() && v.y() == w.y() && v.z() == w.z();
	}
	public static boolean looseEquals(Vector3ir v, Vector3dr w)
	{
		return Math.looseEquals(v.x(), w.x()) && Math.looseEquals(v.y(), w.y()) && Math.looseEquals(v.z(), w.z());
	}

	public static long squareDistance(Vector3ir v, Vector4ir w)
	{
		return (v.x() - w.x()) * (v.x() - w.x()) + (v.y() - w.y()) * (v.y() - w.y()) + (v.z() - w.z()) * (v.z() - w.z());
	}
	public static long absoluteDistance(Vector3ir v, Vector4ir w)
	{
		return abs(v.x() - w.x()) + abs(v.y() - w.y()) + abs(v.z() - w.z());
	}
	public static long dotProduct(Vector3ir v, Vector4ir w)
	{
		return v.x() * w.x() + v.y() * w.y() + v.z() * w.z();
	}
	public static int distance(Vector3ir v, Vector4ir w)
	{
		return (int) sqrt(squareDistance(v, w));
	}
	public static int maxDistance(Vector3ir v, Vector4ir w)
	{
		int a = abs(v.x() - w.x()), b;
		b = abs(v.y() - w.y());
		if (a < b) a = b;
		b = abs(v.z() - w.z());
		if (a < b) a = b;
		return a;
	}
	public static boolean equals(Vector3ir v, Vector4ir w)
	{
		return v.x() == w.x() && v.y() == w.y() && v.z() == w.z();
	}
	public static boolean looseEquals(Vector3ir v, Vector4ir w)
	{
		return Math.looseEquals(v.x(), w.x()) && Math.looseEquals(v.y(), w.y()) && Math.looseEquals(v.z(), w.z());
	}

	public static long squareDistance(Vector3ir v, Vector4lr w)
	{
		return (v.x() - w.x()) * (v.x() - w.x()) + (v.y() - w.y()) * (v.y() - w.y()) + (v.z() - w.z()) * (v.z() - w.z());
	}
	public static long absoluteDistance(Vector3ir v, Vector4lr w)
	{
		return abs(v.x() - w.x()) + abs(v.y() - w.y()) + abs(v.z() - w.z());
	}
	public static long dotProduct(Vector3ir v, Vector4lr w)
	{
		return v.x() * w.x() + v.y() * w.y() + v.z() * w.z();
	}
	public static long distance(Vector3ir v, Vector4lr w)
	{
		return (long) sqrt(squareDistance(v, w));
	}
	public static long maxDistance(Vector3ir v, Vector4lr w)
	{
		long a = abs(v.x() - w.x()), b;
		b = abs(v.y() - w.y());
		if (a < b) a = b;
		b = abs(v.z() - w.z());
		if (a < b) a = b;
		return a;
	}
	public static boolean equals(Vector3ir v, Vector4lr w)
	{
		return v.x() == w.x() && v.y() == w.y() && v.z() == w.z();
	}
	public static boolean looseEquals(Vector3ir v, Vector4lr w)
	{
		return Math.looseEquals(v.x(), w.x()) && Math.looseEquals(v.y(), w.y()) && Math.looseEquals(v.z(), w.z());
	}

	public static float squareDistance(Vector3ir v, Vector4fr w)
	{
		return (v.x() - w.x()) * (v.x() - w.x()) + (v.y() - w.y()) * (v.y() - w.y()) + (v.z() - w.z()) * (v.z() - w.z());
	}
	public static float absoluteDistance(Vector3ir v, Vector4fr w)
	{
		return abs(v.x() - w.x()) + abs(v.y() - w.y()) + abs(v.z() - w.z());
	}
	public static float dotProduct(Vector3ir v, Vector4fr w)
	{
		return v.x() * w.x() + v.y() * w.y() + v.z() * w.z();
	}
	public static float distance(Vector3ir v, Vector4fr w)
	{
		return (float) sqrt(squareDistance(v, w));
	}
	public static float maxDistance(Vector3ir v, Vector4fr w)
	{
		float a = abs(v.x() - w.x()), b;
		b = abs(v.y() - w.y());
		if (a < b) a = b;
		b = abs(v.z() - w.z());
		if (a < b) a = b;
		return a;
	}
	public static boolean equals(Vector3ir v, Vector4fr w)
	{
		return v.x() == w.x() && v.y() == w.y() && v.z() == w.z();
	}
	public static boolean looseEquals(Vector3ir v, Vector4fr w)
	{
		return Math.looseEquals(v.x(), w.x()) && Math.looseEquals(v.y(), w.y()) && Math.looseEquals(v.z(), w.z());
	}

	public static double squareDistance(Vector3ir v, Vector4dr w)
	{
		return (v.x() - w.x()) * (v.x() - w.x()) + (v.y() - w.y()) * (v.y() - w.y()) + (v.z() - w.z()) * (v.z() - w.z());
	}
	public static double absoluteDistance(Vector3ir v, Vector4dr w)
	{
		return abs(v.x() - w.x()) + abs(v.y() - w.y()) + abs(v.z() - w.z());
	}
	public static double dotProduct(Vector3ir v, Vector4dr w)
	{
		return v.x() * w.x() + v.y() * w.y() + v.z() * w.z();
	}
	public static double distance(Vector3ir v, Vector4dr w)
	{
		return (double) sqrt(squareDistance(v, w));
	}
	public static double maxDistance(Vector3ir v, Vector4dr w)
	{
		double a = abs(v.x() - w.x()), b;
		b = abs(v.y() - w.y());
		if (a < b) a = b;
		b = abs(v.z() - w.z());
		if (a < b) a = b;
		return a;
	}
	public static boolean equals(Vector3ir v, Vector4dr w)
	{
		return v.x() == w.x() && v.y() == w.y() && v.z() == w.z();
	}
	public static boolean looseEquals(Vector3ir v, Vector4dr w)
	{
		return Math.looseEquals(v.x(), w.x()) && Math.looseEquals(v.y(), w.y()) && Math.looseEquals(v.z(), w.z());
	}

	public static long squareLength(Vector3lr v)
	{
		return v.x() * v.x() + v.y() * v.y() + v.z() * v.z();
	}
	public static long absoluteLength(Vector3lr v)
	{
		return abs(v.x()) + abs(v.y()) + abs(v.z());
	}
	public static long absoluteSize(Vector3lr v)
	{
		return absoluteLength(v);
	}
	public static double length(Vector3lr v)
	{
		return sqrt(squareLength(v));
	}
	public static double size(Vector3lr v)
	{
		return length(v);
	}
	public static long maxSize(Vector3lr v)
	{
		long a = abs(v.x()), b;
		b = abs(v.y());
		if (a < b) a = b;
		b = abs(v.z());
		if (a < b) a = b;
		return a;
	}
	public static double squareDistance(Vector3lr v, Vector3lr w)
	{
		return (v.x() - w.x()) * (v.x() - w.x()) + (v.y() - w.y()) * (v.y() - w.y()) + (v.z() - w.z()) * (v.z() - w.z());
	}
	public static double absoluteDistance(Vector3lr v, Vector3lr w)
	{
		return abs(v.x() - w.x()) + abs(v.y() - w.y()) + abs(v.z() - w.z());
	}
	public static double dotProduct(Vector3lr v, Vector3lr w)
	{
		return v.x() * w.x() + v.y() * w.y() + v.z() * w.z();
	}
	public static long distance(Vector3lr v, Vector3lr w)
	{
		return (long) sqrt(squareDistance(v, w));
	}
	public static long maxDistance(Vector3lr v, Vector3lr w)
	{
		long a = abs(v.x() - w.x()), b;
		b = abs(v.y() - w.y());
		if (a < b) a = b;
		b = abs(v.z() - w.z());
		if (a < b) a = b;
		return a;
	}
	public static boolean equals(Vector3lr v, Vector3lr w)
	{
		return v.x() == w.x() && v.y() == w.y() && v.z() == w.z();
	}
	public static boolean looseEquals(Vector3lr v, Vector3lr w)
	{
		return Math.looseEquals(v.x(), w.x()) && Math.looseEquals(v.y(), w.y()) && Math.looseEquals(v.z(), w.z());
	}

	public static float squareDistance(Vector3lr v, Vector3fr w)
	{
		return (v.x() - w.x()) * (v.x() - w.x()) + (v.y() - w.y()) * (v.y() - w.y()) + (v.z() - w.z()) * (v.z() - w.z());
	}
	public static float absoluteDistance(Vector3lr v, Vector3fr w)
	{
		return abs(v.x() - w.x()) + abs(v.y() - w.y()) + abs(v.z() - w.z());
	}
	public static float dotProduct(Vector3lr v, Vector3fr w)
	{
		return v.x() * w.x() + v.y() * w.y() + v.z() * w.z();
	}
	public static float distance(Vector3lr v, Vector3fr w)
	{
		return (float) sqrt(squareDistance(v, w));
	}
	public static float maxDistance(Vector3lr v, Vector3fr w)
	{
		float a = abs(v.x() - w.x()), b;
		b = abs(v.y() - w.y());
		if (a < b) a = b;
		b = abs(v.z() - w.z());
		if (a < b) a = b;
		return a;
	}
	public static boolean equals(Vector3lr v, Vector3fr w)
	{
		return v.x() == w.x() && v.y() == w.y() && v.z() == w.z();
	}
	public static boolean looseEquals(Vector3lr v, Vector3fr w)
	{
		return Math.looseEquals(v.x(), w.x()) && Math.looseEquals(v.y(), w.y()) && Math.looseEquals(v.z(), w.z());
	}

	public static double squareDistance(Vector3lr v, Vector3dr w)
	{
		return (v.x() - w.x()) * (v.x() - w.x()) + (v.y() - w.y()) * (v.y() - w.y()) + (v.z() - w.z()) * (v.z() - w.z());
	}
	public static double absoluteDistance(Vector3lr v, Vector3dr w)
	{
		return abs(v.x() - w.x()) + abs(v.y() - w.y()) + abs(v.z() - w.z());
	}
	public static double dotProduct(Vector3lr v, Vector3dr w)
	{
		return v.x() * w.x() + v.y() * w.y() + v.z() * w.z();
	}
	public static double distance(Vector3lr v, Vector3dr w)
	{
		return (double) sqrt(squareDistance(v, w));
	}
	public static double maxDistance(Vector3lr v, Vector3dr w)
	{
		double a = abs(v.x() - w.x()), b;
		b = abs(v.y() - w.y());
		if (a < b) a = b;
		b = abs(v.z() - w.z());
		if (a < b) a = b;
		return a;
	}
	public static boolean equals(Vector3lr v, Vector3dr w)
	{
		return v.x() == w.x() && v.y() == w.y() && v.z() == w.z();
	}
	public static boolean looseEquals(Vector3lr v, Vector3dr w)
	{
		return Math.looseEquals(v.x(), w.x()) && Math.looseEquals(v.y(), w.y()) && Math.looseEquals(v.z(), w.z());
	}

	public static double squareDistance(Vector3lr v, Vector4lr w)
	{
		return (v.x() - w.x()) * (v.x() - w.x()) + (v.y() - w.y()) * (v.y() - w.y()) + (v.z() - w.z()) * (v.z() - w.z());
	}
	public static double absoluteDistance(Vector3lr v, Vector4lr w)
	{
		return abs(v.x() - w.x()) + abs(v.y() - w.y()) + abs(v.z() - w.z());
	}
	public static double dotProduct(Vector3lr v, Vector4lr w)
	{
		return v.x() * w.x() + v.y() * w.y() + v.z() * w.z();
	}
	public static long distance(Vector3lr v, Vector4lr w)
	{
		return (long) sqrt(squareDistance(v, w));
	}
	public static long maxDistance(Vector3lr v, Vector4lr w)
	{
		long a = abs(v.x() - w.x()), b;
		b = abs(v.y() - w.y());
		if (a < b) a = b;
		b = abs(v.z() - w.z());
		if (a < b) a = b;
		return a;
	}
	public static boolean equals(Vector3lr v, Vector4lr w)
	{
		return v.x() == w.x() && v.y() == w.y() && v.z() == w.z();
	}
	public static boolean looseEquals(Vector3lr v, Vector4lr w)
	{
		return Math.looseEquals(v.x(), w.x()) && Math.looseEquals(v.y(), w.y()) && Math.looseEquals(v.z(), w.z());
	}

	public static float squareDistance(Vector3lr v, Vector4fr w)
	{
		return (v.x() - w.x()) * (v.x() - w.x()) + (v.y() - w.y()) * (v.y() - w.y()) + (v.z() - w.z()) * (v.z() - w.z());
	}
	public static float absoluteDistance(Vector3lr v, Vector4fr w)
	{
		return abs(v.x() - w.x()) + abs(v.y() - w.y()) + abs(v.z() - w.z());
	}
	public static float dotProduct(Vector3lr v, Vector4fr w)
	{
		return v.x() * w.x() + v.y() * w.y() + v.z() * w.z();
	}
	public static float distance(Vector3lr v, Vector4fr w)
	{
		return (float) sqrt(squareDistance(v, w));
	}
	public static float maxDistance(Vector3lr v, Vector4fr w)
	{
		float a = abs(v.x() - w.x()), b;
		b = abs(v.y() - w.y());
		if (a < b) a = b;
		b = abs(v.z() - w.z());
		if (a < b) a = b;
		return a;
	}
	public static boolean equals(Vector3lr v, Vector4fr w)
	{
		return v.x() == w.x() && v.y() == w.y() && v.z() == w.z();
	}
	public static boolean looseEquals(Vector3lr v, Vector4fr w)
	{
		return Math.looseEquals(v.x(), w.x()) && Math.looseEquals(v.y(), w.y()) && Math.looseEquals(v.z(), w.z());
	}

	public static double squareDistance(Vector3lr v, Vector4dr w)
	{
		return (v.x() - w.x()) * (v.x() - w.x()) + (v.y() - w.y()) * (v.y() - w.y()) + (v.z() - w.z()) * (v.z() - w.z());
	}
	public static double absoluteDistance(Vector3lr v, Vector4dr w)
	{
		return abs(v.x() - w.x()) + abs(v.y() - w.y()) + abs(v.z() - w.z());
	}
	public static double dotProduct(Vector3lr v, Vector4dr w)
	{
		return v.x() * w.x() + v.y() * w.y() + v.z() * w.z();
	}
	public static double distance(Vector3lr v, Vector4dr w)
	{
		return (double) sqrt(squareDistance(v, w));
	}
	public static double maxDistance(Vector3lr v, Vector4dr w)
	{
		double a = abs(v.x() - w.x()), b;
		b = abs(v.y() - w.y());
		if (a < b) a = b;
		b = abs(v.z() - w.z());
		if (a < b) a = b;
		return a;
	}
	public static boolean equals(Vector3lr v, Vector4dr w)
	{
		return v.x() == w.x() && v.y() == w.y() && v.z() == w.z();
	}
	public static boolean looseEquals(Vector3lr v, Vector4dr w)
	{
		return Math.looseEquals(v.x(), w.x()) && Math.looseEquals(v.y(), w.y()) && Math.looseEquals(v.z(), w.z());
	}

	public static float squareLength(Vector3fr v)
	{
		return v.x() * v.x() + v.y() * v.y() + v.z() * v.z();
	}
	public static float absoluteLength(Vector3fr v)
	{
		return abs(v.x()) + abs(v.y()) + abs(v.z());
	}
	public static float absoluteSize(Vector3fr v)
	{
		return absoluteLength(v);
	}
	public static float length(Vector3fr v)
	{
		return sqrt(squareLength(v));
	}
	public static float size(Vector3fr v)
	{
		return length(v);
	}
	public static float maxSize(Vector3fr v)
	{
		float a = abs(v.x()), b;
		b = abs(v.y());
		if (a < b) a = b;
		b = abs(v.z());
		if (a < b) a = b;
		return a;
	}
	public static double squareDistance(Vector3fr v, Vector3fr w)
	{
		return (v.x() - w.x()) * (v.x() - w.x()) + (v.y() - w.y()) * (v.y() - w.y()) + (v.z() - w.z()) * (v.z() - w.z());
	}
	public static double absoluteDistance(Vector3fr v, Vector3fr w)
	{
		return abs(v.x() - w.x()) + abs(v.y() - w.y()) + abs(v.z() - w.z());
	}
	public static double dotProduct(Vector3fr v, Vector3fr w)
	{
		return v.x() * w.x() + v.y() * w.y() + v.z() * w.z();
	}
	public static float distance(Vector3fr v, Vector3fr w)
	{
		return (float) sqrt(squareDistance(v, w));
	}
	public static float maxDistance(Vector3fr v, Vector3fr w)
	{
		float a = abs(v.x() - w.x()), b;
		b = abs(v.y() - w.y());
		if (a < b) a = b;
		b = abs(v.z() - w.z());
		if (a < b) a = b;
		return a;
	}
	public static boolean equals(Vector3fr v, Vector3fr w)
	{
		return v.x() == w.x() && v.y() == w.y() && v.z() == w.z();
	}
	public static boolean looseEquals(Vector3fr v, Vector3fr w)
	{
		return Math.looseEquals(v.x(), w.x()) && Math.looseEquals(v.y(), w.y()) && Math.looseEquals(v.z(), w.z());
	}

	public static double squareDistance(Vector3fr v, Vector3dr w)
	{
		return (v.x() - w.x()) * (v.x() - w.x()) + (v.y() - w.y()) * (v.y() - w.y()) + (v.z() - w.z()) * (v.z() - w.z());
	}
	public static double absoluteDistance(Vector3fr v, Vector3dr w)
	{
		return abs(v.x() - w.x()) + abs(v.y() - w.y()) + abs(v.z() - w.z());
	}
	public static double dotProduct(Vector3fr v, Vector3dr w)
	{
		return v.x() * w.x() + v.y() * w.y() + v.z() * w.z();
	}
	public static double distance(Vector3fr v, Vector3dr w)
	{
		return (double) sqrt(squareDistance(v, w));
	}
	public static double maxDistance(Vector3fr v, Vector3dr w)
	{
		double a = abs(v.x() - w.x()), b;
		b = abs(v.y() - w.y());
		if (a < b) a = b;
		b = abs(v.z() - w.z());
		if (a < b) a = b;
		return a;
	}
	public static boolean equals(Vector3fr v, Vector3dr w)
	{
		return v.x() == w.x() && v.y() == w.y() && v.z() == w.z();
	}
	public static boolean looseEquals(Vector3fr v, Vector3dr w)
	{
		return Math.looseEquals(v.x(), w.x()) && Math.looseEquals(v.y(), w.y()) && Math.looseEquals(v.z(), w.z());
	}

	public static double squareDistance(Vector3fr v, Vector4fr w)
	{
		return (v.x() - w.x()) * (v.x() - w.x()) + (v.y() - w.y()) * (v.y() - w.y()) + (v.z() - w.z()) * (v.z() - w.z());
	}
	public static double absoluteDistance(Vector3fr v, Vector4fr w)
	{
		return abs(v.x() - w.x()) + abs(v.y() - w.y()) + abs(v.z() - w.z());
	}
	public static double dotProduct(Vector3fr v, Vector4fr w)
	{
		return v.x() * w.x() + v.y() * w.y() + v.z() * w.z();
	}
	public static float distance(Vector3fr v, Vector4fr w)
	{
		return (float) sqrt(squareDistance(v, w));
	}
	public static float maxDistance(Vector3fr v, Vector4fr w)
	{
		float a = abs(v.x() - w.x()), b;
		b = abs(v.y() - w.y());
		if (a < b) a = b;
		b = abs(v.z() - w.z());
		if (a < b) a = b;
		return a;
	}
	public static boolean equals(Vector3fr v, Vector4fr w)
	{
		return v.x() == w.x() && v.y() == w.y() && v.z() == w.z();
	}
	public static boolean looseEquals(Vector3fr v, Vector4fr w)
	{
		return Math.looseEquals(v.x(), w.x()) && Math.looseEquals(v.y(), w.y()) && Math.looseEquals(v.z(), w.z());
	}

	public static double squareDistance(Vector3fr v, Vector4dr w)
	{
		return (v.x() - w.x()) * (v.x() - w.x()) + (v.y() - w.y()) * (v.y() - w.y()) + (v.z() - w.z()) * (v.z() - w.z());
	}
	public static double absoluteDistance(Vector3fr v, Vector4dr w)
	{
		return abs(v.x() - w.x()) + abs(v.y() - w.y()) + abs(v.z() - w.z());
	}
	public static double dotProduct(Vector3fr v, Vector4dr w)
	{
		return v.x() * w.x() + v.y() * w.y() + v.z() * w.z();
	}
	public static double distance(Vector3fr v, Vector4dr w)
	{
		return (double) sqrt(squareDistance(v, w));
	}
	public static double maxDistance(Vector3fr v, Vector4dr w)
	{
		double a = abs(v.x() - w.x()), b;
		b = abs(v.y() - w.y());
		if (a < b) a = b;
		b = abs(v.z() - w.z());
		if (a < b) a = b;
		return a;
	}
	public static boolean equals(Vector3fr v, Vector4dr w)
	{
		return v.x() == w.x() && v.y() == w.y() && v.z() == w.z();
	}
	public static boolean looseEquals(Vector3fr v, Vector4dr w)
	{
		return Math.looseEquals(v.x(), w.x()) && Math.looseEquals(v.y(), w.y()) && Math.looseEquals(v.z(), w.z());
	}

	public static double squareLength(Vector3dr v)
	{
		return v.x() * v.x() + v.y() * v.y() + v.z() * v.z();
	}
	public static double absoluteLength(Vector3dr v)
	{
		return abs(v.x()) + abs(v.y()) + abs(v.z());
	}
	public static double absoluteSize(Vector3dr v)
	{
		return absoluteLength(v);
	}
	public static double length(Vector3dr v)
	{
		return sqrt(squareLength(v));
	}
	public static double size(Vector3dr v)
	{
		return length(v);
	}
	public static double maxSize(Vector3dr v)
	{
		double a = abs(v.x()), b;
		b = abs(v.y());
		if (a < b) a = b;
		b = abs(v.z());
		if (a < b) a = b;
		return a;
	}
	public static double squareDistance(Vector3dr v, Vector3dr w)
	{
		return (v.x() - w.x()) * (v.x() - w.x()) + (v.y() - w.y()) * (v.y() - w.y()) + (v.z() - w.z()) * (v.z() - w.z());
	}
	public static double absoluteDistance(Vector3dr v, Vector3dr w)
	{
		return abs(v.x() - w.x()) + abs(v.y() - w.y()) + abs(v.z() - w.z());
	}
	public static double dotProduct(Vector3dr v, Vector3dr w)
	{
		return v.x() * w.x() + v.y() * w.y() + v.z() * w.z();
	}
	public static double distance(Vector3dr v, Vector3dr w)
	{
		return (double) sqrt(squareDistance(v, w));
	}
	public static double maxDistance(Vector3dr v, Vector3dr w)
	{
		double a = abs(v.x() - w.x()), b;
		b = abs(v.y() - w.y());
		if (a < b) a = b;
		b = abs(v.z() - w.z());
		if (a < b) a = b;
		return a;
	}
	public static boolean equals(Vector3dr v, Vector3dr w)
	{
		return v.x() == w.x() && v.y() == w.y() && v.z() == w.z();
	}
	public static boolean looseEquals(Vector3dr v, Vector3dr w)
	{
		return Math.looseEquals(v.x(), w.x()) && Math.looseEquals(v.y(), w.y()) && Math.looseEquals(v.z(), w.z());
	}

	public static double squareDistance(Vector3dr v, Vector4dr w)
	{
		return (v.x() - w.x()) * (v.x() - w.x()) + (v.y() - w.y()) * (v.y() - w.y()) + (v.z() - w.z()) * (v.z() - w.z());
	}
	public static double absoluteDistance(Vector3dr v, Vector4dr w)
	{
		return abs(v.x() - w.x()) + abs(v.y() - w.y()) + abs(v.z() - w.z());
	}
	public static double dotProduct(Vector3dr v, Vector4dr w)
	{
		return v.x() * w.x() + v.y() * w.y() + v.z() * w.z();
	}
	public static double distance(Vector3dr v, Vector4dr w)
	{
		return (double) sqrt(squareDistance(v, w));
	}
	public static double maxDistance(Vector3dr v, Vector4dr w)
	{
		double a = abs(v.x() - w.x()), b;
		b = abs(v.y() - w.y());
		if (a < b) a = b;
		b = abs(v.z() - w.z());
		if (a < b) a = b;
		return a;
	}
	public static boolean equals(Vector3dr v, Vector4dr w)
	{
		return v.x() == w.x() && v.y() == w.y() && v.z() == w.z();
	}
	public static boolean looseEquals(Vector3dr v, Vector4dr w)
	{
		return Math.looseEquals(v.x(), w.x()) && Math.looseEquals(v.y(), w.y()) && Math.looseEquals(v.z(), w.z());
	}

	public static int squareLength(Vector4ir v)
	{
		return v.x() * v.x() + v.y() * v.y() + v.z() * v.z() + v.w() * v.w();
	}
	public static int absoluteLength(Vector4ir v)
	{
		return abs(v.x()) + abs(v.y()) + abs(v.z()) + abs(v.w());
	}
	public static int absoluteSize(Vector4ir v)
	{
		return absoluteLength(v);
	}
	public static float length(Vector4ir v)
	{
		return sqrt(squareLength(v));
	}
	public static float size(Vector4ir v)
	{
		return length(v);
	}
	public static int maxSize(Vector4ir v)
	{
		int a = abs(v.x()), b;
		b = abs(v.y());
		if (a < b) a = b;
		b = abs(v.z());
		if (a < b) a = b;
		b = abs(v.w());
		if (a < b) a = b;
		return a;
	}
	public static long squareDistance(Vector4ir v, Vector4ir w)
	{
		return (v.x() - w.x()) * (v.x() - w.x()) + (v.y() - w.y()) * (v.y() - w.y()) + (v.z() - w.z()) * (v.z() - w.z()) + (v.w() - w.w()) * (v.w() - w.w());
	}
	public static long absoluteDistance(Vector4ir v, Vector4ir w)
	{
		return abs(v.x() - w.x()) + abs(v.y() - w.y()) + abs(v.z() - w.z()) + abs(v.w() - w.w());
	}
	public static long dotProduct(Vector4ir v, Vector4ir w)
	{
		return v.x() * w.x() + v.y() * w.y() + v.z() * w.z() + v.w() * w.w();
	}
	public static int distance(Vector4ir v, Vector4ir w)
	{
		return (int) sqrt(squareDistance(v, w));
	}
	public static int maxDistance(Vector4ir v, Vector4ir w)
	{
		int a = abs(v.x() - w.x()), b;
		b = abs(v.y() - w.y());
		if (a < b) a = b;
		b = abs(v.z() - w.z());
		if (a < b) a = b;
		b = abs(v.w() - w.w());
		if (a < b) a = b;
		return a;
	}
	public static boolean equals(Vector4ir v, Vector4ir w)
	{
		return v.x() == w.x() && v.y() == w.y() && v.z() == w.z() && v.w() == w.w();
	}
	public static boolean looseEquals(Vector4ir v, Vector4ir w)
	{
		return Math.looseEquals(v.x(), w.x()) && Math.looseEquals(v.y(), w.y()) && Math.looseEquals(v.z(), w.z()) && Math.looseEquals(v.w(), w.w());
	}

	public static long squareDistance(Vector4ir v, Vector4lr w)
	{
		return (v.x() - w.x()) * (v.x() - w.x()) + (v.y() - w.y()) * (v.y() - w.y()) + (v.z() - w.z()) * (v.z() - w.z()) + (v.w() - w.w()) * (v.w() - w.w());
	}
	public static long absoluteDistance(Vector4ir v, Vector4lr w)
	{
		return abs(v.x() - w.x()) + abs(v.y() - w.y()) + abs(v.z() - w.z()) + abs(v.w() - w.w());
	}
	public static long dotProduct(Vector4ir v, Vector4lr w)
	{
		return v.x() * w.x() + v.y() * w.y() + v.z() * w.z() + v.w() * w.w();
	}
	public static long distance(Vector4ir v, Vector4lr w)
	{
		return (long) sqrt(squareDistance(v, w));
	}
	public static long maxDistance(Vector4ir v, Vector4lr w)
	{
		long a = abs(v.x() - w.x()), b;
		b = abs(v.y() - w.y());
		if (a < b) a = b;
		b = abs(v.z() - w.z());
		if (a < b) a = b;
		b = abs(v.w() - w.w());
		if (a < b) a = b;
		return a;
	}
	public static boolean equals(Vector4ir v, Vector4lr w)
	{
		return v.x() == w.x() && v.y() == w.y() && v.z() == w.z() && v.w() == w.w();
	}
	public static boolean looseEquals(Vector4ir v, Vector4lr w)
	{
		return Math.looseEquals(v.x(), w.x()) && Math.looseEquals(v.y(), w.y()) && Math.looseEquals(v.z(), w.z()) && Math.looseEquals(v.w(), w.w());
	}

	public static float squareDistance(Vector4ir v, Vector4fr w)
	{
		return (v.x() - w.x()) * (v.x() - w.x()) + (v.y() - w.y()) * (v.y() - w.y()) + (v.z() - w.z()) * (v.z() - w.z()) + (v.w() - w.w()) * (v.w() - w.w());
	}
	public static float absoluteDistance(Vector4ir v, Vector4fr w)
	{
		return abs(v.x() - w.x()) + abs(v.y() - w.y()) + abs(v.z() - w.z()) + abs(v.w() - w.w());
	}
	public static float dotProduct(Vector4ir v, Vector4fr w)
	{
		return v.x() * w.x() + v.y() * w.y() + v.z() * w.z() + v.w() * w.w();
	}
	public static float distance(Vector4ir v, Vector4fr w)
	{
		return (float) sqrt(squareDistance(v, w));
	}
	public static float maxDistance(Vector4ir v, Vector4fr w)
	{
		float a = abs(v.x() - w.x()), b;
		b = abs(v.y() - w.y());
		if (a < b) a = b;
		b = abs(v.z() - w.z());
		if (a < b) a = b;
		b = abs(v.w() - w.w());
		if (a < b) a = b;
		return a;
	}
	public static boolean equals(Vector4ir v, Vector4fr w)
	{
		return v.x() == w.x() && v.y() == w.y() && v.z() == w.z() && v.w() == w.w();
	}
	public static boolean looseEquals(Vector4ir v, Vector4fr w)
	{
		return Math.looseEquals(v.x(), w.x()) && Math.looseEquals(v.y(), w.y()) && Math.looseEquals(v.z(), w.z()) && Math.looseEquals(v.w(), w.w());
	}

	public static double squareDistance(Vector4ir v, Vector4dr w)
	{
		return (v.x() - w.x()) * (v.x() - w.x()) + (v.y() - w.y()) * (v.y() - w.y()) + (v.z() - w.z()) * (v.z() - w.z()) + (v.w() - w.w()) * (v.w() - w.w());
	}
	public static double absoluteDistance(Vector4ir v, Vector4dr w)
	{
		return abs(v.x() - w.x()) + abs(v.y() - w.y()) + abs(v.z() - w.z()) + abs(v.w() - w.w());
	}
	public static double dotProduct(Vector4ir v, Vector4dr w)
	{
		return v.x() * w.x() + v.y() * w.y() + v.z() * w.z() + v.w() * w.w();
	}
	public static double distance(Vector4ir v, Vector4dr w)
	{
		return (double) sqrt(squareDistance(v, w));
	}
	public static double maxDistance(Vector4ir v, Vector4dr w)
	{
		double a = abs(v.x() - w.x()), b;
		b = abs(v.y() - w.y());
		if (a < b) a = b;
		b = abs(v.z() - w.z());
		if (a < b) a = b;
		b = abs(v.w() - w.w());
		if (a < b) a = b;
		return a;
	}
	public static boolean equals(Vector4ir v, Vector4dr w)
	{
		return v.x() == w.x() && v.y() == w.y() && v.z() == w.z() && v.w() == w.w();
	}
	public static boolean looseEquals(Vector4ir v, Vector4dr w)
	{
		return Math.looseEquals(v.x(), w.x()) && Math.looseEquals(v.y(), w.y()) && Math.looseEquals(v.z(), w.z()) && Math.looseEquals(v.w(), w.w());
	}

	public static long squareLength(Vector4lr v)
	{
		return v.x() * v.x() + v.y() * v.y() + v.z() * v.z() + v.w() * v.w();
	}
	public static long absoluteLength(Vector4lr v)
	{
		return abs(v.x()) + abs(v.y()) + abs(v.z()) + abs(v.w());
	}
	public static long absoluteSize(Vector4lr v)
	{
		return absoluteLength(v);
	}
	public static double length(Vector4lr v)
	{
		return sqrt(squareLength(v));
	}
	public static double size(Vector4lr v)
	{
		return length(v);
	}
	public static long maxSize(Vector4lr v)
	{
		long a = abs(v.x()), b;
		b = abs(v.y());
		if (a < b) a = b;
		b = abs(v.z());
		if (a < b) a = b;
		b = abs(v.w());
		if (a < b) a = b;
		return a;
	}
	public static double squareDistance(Vector4lr v, Vector4lr w)
	{
		return (v.x() - w.x()) * (v.x() - w.x()) + (v.y() - w.y()) * (v.y() - w.y()) + (v.z() - w.z()) * (v.z() - w.z()) + (v.w() - w.w()) * (v.w() - w.w());
	}
	public static double absoluteDistance(Vector4lr v, Vector4lr w)
	{
		return abs(v.x() - w.x()) + abs(v.y() - w.y()) + abs(v.z() - w.z()) + abs(v.w() - w.w());
	}
	public static double dotProduct(Vector4lr v, Vector4lr w)
	{
		return v.x() * w.x() + v.y() * w.y() + v.z() * w.z() + v.w() * w.w();
	}
	public static long distance(Vector4lr v, Vector4lr w)
	{
		return (long) sqrt(squareDistance(v, w));
	}
	public static long maxDistance(Vector4lr v, Vector4lr w)
	{
		long a = abs(v.x() - w.x()), b;
		b = abs(v.y() - w.y());
		if (a < b) a = b;
		b = abs(v.z() - w.z());
		if (a < b) a = b;
		b = abs(v.w() - w.w());
		if (a < b) a = b;
		return a;
	}
	public static boolean equals(Vector4lr v, Vector4lr w)
	{
		return v.x() == w.x() && v.y() == w.y() && v.z() == w.z() && v.w() == w.w();
	}
	public static boolean looseEquals(Vector4lr v, Vector4lr w)
	{
		return Math.looseEquals(v.x(), w.x()) && Math.looseEquals(v.y(), w.y()) && Math.looseEquals(v.z(), w.z()) && Math.looseEquals(v.w(), w.w());
	}

	public static float squareDistance(Vector4lr v, Vector4fr w)
	{
		return (v.x() - w.x()) * (v.x() - w.x()) + (v.y() - w.y()) * (v.y() - w.y()) + (v.z() - w.z()) * (v.z() - w.z()) + (v.w() - w.w()) * (v.w() - w.w());
	}
	public static float absoluteDistance(Vector4lr v, Vector4fr w)
	{
		return abs(v.x() - w.x()) + abs(v.y() - w.y()) + abs(v.z() - w.z()) + abs(v.w() - w.w());
	}
	public static float dotProduct(Vector4lr v, Vector4fr w)
	{
		return v.x() * w.x() + v.y() * w.y() + v.z() * w.z() + v.w() * w.w();
	}
	public static float distance(Vector4lr v, Vector4fr w)
	{
		return (float) sqrt(squareDistance(v, w));
	}
	public static float maxDistance(Vector4lr v, Vector4fr w)
	{
		float a = abs(v.x() - w.x()), b;
		b = abs(v.y() - w.y());
		if (a < b) a = b;
		b = abs(v.z() - w.z());
		if (a < b) a = b;
		b = abs(v.w() - w.w());
		if (a < b) a = b;
		return a;
	}
	public static boolean equals(Vector4lr v, Vector4fr w)
	{
		return v.x() == w.x() && v.y() == w.y() && v.z() == w.z() && v.w() == w.w();
	}
	public static boolean looseEquals(Vector4lr v, Vector4fr w)
	{
		return Math.looseEquals(v.x(), w.x()) && Math.looseEquals(v.y(), w.y()) && Math.looseEquals(v.z(), w.z()) && Math.looseEquals(v.w(), w.w());
	}

	public static double squareDistance(Vector4lr v, Vector4dr w)
	{
		return (v.x() - w.x()) * (v.x() - w.x()) + (v.y() - w.y()) * (v.y() - w.y()) + (v.z() - w.z()) * (v.z() - w.z()) + (v.w() - w.w()) * (v.w() - w.w());
	}
	public static double absoluteDistance(Vector4lr v, Vector4dr w)
	{
		return abs(v.x() - w.x()) + abs(v.y() - w.y()) + abs(v.z() - w.z()) + abs(v.w() - w.w());
	}
	public static double dotProduct(Vector4lr v, Vector4dr w)
	{
		return v.x() * w.x() + v.y() * w.y() + v.z() * w.z() + v.w() * w.w();
	}
	public static double distance(Vector4lr v, Vector4dr w)
	{
		return (double) sqrt(squareDistance(v, w));
	}
	public static double maxDistance(Vector4lr v, Vector4dr w)
	{
		double a = abs(v.x() - w.x()), b;
		b = abs(v.y() - w.y());
		if (a < b) a = b;
		b = abs(v.z() - w.z());
		if (a < b) a = b;
		b = abs(v.w() - w.w());
		if (a < b) a = b;
		return a;
	}
	public static boolean equals(Vector4lr v, Vector4dr w)
	{
		return v.x() == w.x() && v.y() == w.y() && v.z() == w.z() && v.w() == w.w();
	}
	public static boolean looseEquals(Vector4lr v, Vector4dr w)
	{
		return Math.looseEquals(v.x(), w.x()) && Math.looseEquals(v.y(), w.y()) && Math.looseEquals(v.z(), w.z()) && Math.looseEquals(v.w(), w.w());
	}

	public static float squareLength(Vector4fr v)
	{
		return v.x() * v.x() + v.y() * v.y() + v.z() * v.z() + v.w() * v.w();
	}
	public static float absoluteLength(Vector4fr v)
	{
		return abs(v.x()) + abs(v.y()) + abs(v.z()) + abs(v.w());
	}
	public static float absoluteSize(Vector4fr v)
	{
		return absoluteLength(v);
	}
	public static float length(Vector4fr v)
	{
		return sqrt(squareLength(v));
	}
	public static float size(Vector4fr v)
	{
		return length(v);
	}
	public static float maxSize(Vector4fr v)
	{
		float a = abs(v.x()), b;
		b = abs(v.y());
		if (a < b) a = b;
		b = abs(v.z());
		if (a < b) a = b;
		b = abs(v.w());
		if (a < b) a = b;
		return a;
	}
	public static double squareDistance(Vector4fr v, Vector4fr w)
	{
		return (v.x() - w.x()) * (v.x() - w.x()) + (v.y() - w.y()) * (v.y() - w.y()) + (v.z() - w.z()) * (v.z() - w.z()) + (v.w() - w.w()) * (v.w() - w.w());
	}
	public static double absoluteDistance(Vector4fr v, Vector4fr w)
	{
		return abs(v.x() - w.x()) + abs(v.y() - w.y()) + abs(v.z() - w.z()) + abs(v.w() - w.w());
	}
	public static double dotProduct(Vector4fr v, Vector4fr w)
	{
		return v.x() * w.x() + v.y() * w.y() + v.z() * w.z() + v.w() * w.w();
	}
	public static float distance(Vector4fr v, Vector4fr w)
	{
		return (float) sqrt(squareDistance(v, w));
	}
	public static float maxDistance(Vector4fr v, Vector4fr w)
	{
		float a = abs(v.x() - w.x()), b;
		b = abs(v.y() - w.y());
		if (a < b) a = b;
		b = abs(v.z() - w.z());
		if (a < b) a = b;
		b = abs(v.w() - w.w());
		if (a < b) a = b;
		return a;
	}
	public static boolean equals(Vector4fr v, Vector4fr w)
	{
		return v.x() == w.x() && v.y() == w.y() && v.z() == w.z() && v.w() == w.w();
	}
	public static boolean looseEquals(Vector4fr v, Vector4fr w)
	{
		return Math.looseEquals(v.x(), w.x()) && Math.looseEquals(v.y(), w.y()) && Math.looseEquals(v.z(), w.z()) && Math.looseEquals(v.w(), w.w());
	}

	public static double squareDistance(Vector4fr v, Vector4dr w)
	{
		return (v.x() - w.x()) * (v.x() - w.x()) + (v.y() - w.y()) * (v.y() - w.y()) + (v.z() - w.z()) * (v.z() - w.z()) + (v.w() - w.w()) * (v.w() - w.w());
	}
	public static double absoluteDistance(Vector4fr v, Vector4dr w)
	{
		return abs(v.x() - w.x()) + abs(v.y() - w.y()) + abs(v.z() - w.z()) + abs(v.w() - w.w());
	}
	public static double dotProduct(Vector4fr v, Vector4dr w)
	{
		return v.x() * w.x() + v.y() * w.y() + v.z() * w.z() + v.w() * w.w();
	}
	public static double distance(Vector4fr v, Vector4dr w)
	{
		return (double) sqrt(squareDistance(v, w));
	}
	public static double maxDistance(Vector4fr v, Vector4dr w)
	{
		double a = abs(v.x() - w.x()), b;
		b = abs(v.y() - w.y());
		if (a < b) a = b;
		b = abs(v.z() - w.z());
		if (a < b) a = b;
		b = abs(v.w() - w.w());
		if (a < b) a = b;
		return a;
	}
	public static boolean equals(Vector4fr v, Vector4dr w)
	{
		return v.x() == w.x() && v.y() == w.y() && v.z() == w.z() && v.w() == w.w();
	}
	public static boolean looseEquals(Vector4fr v, Vector4dr w)
	{
		return Math.looseEquals(v.x(), w.x()) && Math.looseEquals(v.y(), w.y()) && Math.looseEquals(v.z(), w.z()) && Math.looseEquals(v.w(), w.w());
	}

	public static double squareLength(Vector4dr v)
	{
		return v.x() * v.x() + v.y() * v.y() + v.z() * v.z() + v.w() * v.w();
	}
	public static double absoluteLength(Vector4dr v)
	{
		return abs(v.x()) + abs(v.y()) + abs(v.z()) + abs(v.w());
	}
	public static double absoluteSize(Vector4dr v)
	{
		return absoluteLength(v);
	}
	public static double length(Vector4dr v)
	{
		return sqrt(squareLength(v));
	}
	public static double size(Vector4dr v)
	{
		return length(v);
	}
	public static double maxSize(Vector4dr v)
	{
		double a = abs(v.x()), b;
		b = abs(v.y());
		if (a < b) a = b;
		b = abs(v.z());
		if (a < b) a = b;
		b = abs(v.w());
		if (a < b) a = b;
		return a;
	}
	public static double squareDistance(Vector4dr v, Vector4dr w)
	{
		return (v.x() - w.x()) * (v.x() - w.x()) + (v.y() - w.y()) * (v.y() - w.y()) + (v.z() - w.z()) * (v.z() - w.z()) + (v.w() - w.w()) * (v.w() - w.w());
	}
	public static double absoluteDistance(Vector4dr v, Vector4dr w)
	{
		return abs(v.x() - w.x()) + abs(v.y() - w.y()) + abs(v.z() - w.z()) + abs(v.w() - w.w());
	}
	public static double dotProduct(Vector4dr v, Vector4dr w)
	{
		return v.x() * w.x() + v.y() * w.y() + v.z() * w.z() + v.w() * w.w();
	}
	public static double distance(Vector4dr v, Vector4dr w)
	{
		return (double) sqrt(squareDistance(v, w));
	}
	public static double maxDistance(Vector4dr v, Vector4dr w)
	{
		double a = abs(v.x() - w.x()), b;
		b = abs(v.y() - w.y());
		if (a < b) a = b;
		b = abs(v.z() - w.z());
		if (a < b) a = b;
		b = abs(v.w() - w.w());
		if (a < b) a = b;
		return a;
	}
	public static boolean equals(Vector4dr v, Vector4dr w)
	{
		return v.x() == w.x() && v.y() == w.y() && v.z() == w.z() && v.w() == w.w();
	}
	public static boolean looseEquals(Vector4dr v, Vector4dr w)
	{
		return Math.looseEquals(v.x(), w.x()) && Math.looseEquals(v.y(), w.y()) && Math.looseEquals(v.z(), w.z()) && Math.looseEquals(v.w(), w.w());
	}

	public static Vector3f rotate(Quaternionfr q, Vector3f v)
	{
		float x = v.x(), y = v.y(), z = v.z();
		float i = q.i(), j = q.j(), k = q.k(), r = q.r();
		float i2 = i * i, j2 = j * j, k2 = k * k, r2 = r * r;
		return v.setAll(x * (r2 + i2 - j2 - k2) + 2 * (y * (i * j - r * k) + z * (i * k + r * y)), y * (r2 - i2 + j2 - k2) + 2 * (x * (r * k + i * j) + z * (-r * i + j * k)), z * (r2 - i2 - j2 + k2) + 2 * (x * (-r * j + i * k) + y * (r * i + j * k)));
	}
	public static Vector3d rotate(Quaternionfr q, Vector3d v)
	{
		double x = v.x(), y = v.y(), z = v.z();
		double i = q.i(), j = q.j(), k = q.k(), r = q.r();
		double i2 = i * i, j2 = j * j, k2 = k * k, r2 = r * r;
		return v.setAll(x * (r2 + i2 - j2 - k2) + 2 * (y * (i * j - r * k) + z * (i * k + r * y)), y * (r2 - i2 + j2 - k2) + 2 * (x * (r * k + i * j) + z * (-r * i + j * k)), z * (r2 - i2 - j2 + k2) + 2 * (x * (-r * j + i * k) + y * (r * i + j * k)));
	}
	public static Vector3f rotate(Quaterniondr q, Vector3f v)
	{
		double x = v.x(), y = v.y(), z = v.z();
		double i = q.i(), j = q.j(), k = q.k(), r = q.r();
		double i2 = i * i, j2 = j * j, k2 = k * k, r2 = r * r;
		return v.setAll((float) (x * (r2 + i2 - j2 - k2) + 2 * (y * (i * j - r * k) + z * (i * k + r * y))), (float) (y * (r2 - i2 + j2 - k2) + 2 * (x * (r * k + i * j) + z * (-r * i + j * k))), (float) (z * (r2 - i2 - j2 + k2) + 2 * (x * (-r * j + i * k) + y * (r * i + j * k))));
	}
	public static Vector3d rotate(Quaterniondr q, Vector3d v)
	{
		double x = v.x(), y = v.y(), z = v.z();
		double i = q.i(), j = q.j(), k = q.k(), r = q.r();
		double i2 = i * i, j2 = j * j, k2 = k * k, r2 = r * r;
		return v.setAll(x * (r2 + i2 - j2 - k2) + 2 * (y * (i * j - r * k) + z * (i * k + r * y)), y * (r2 - i2 + j2 - k2) + 2 * (x * (r * k + i * j) + z * (-r * i + j * k)), z * (r2 - i2 - j2 + k2) + 2 * (x * (-r * j + i * k) + y * (r * i + j * k)));
	}
}
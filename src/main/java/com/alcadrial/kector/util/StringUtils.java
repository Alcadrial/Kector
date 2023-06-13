package com.alcadrial.kector.util;

public final class StringUtils {
	
	private StringUtils()
	{}
	
	public static String toString(float f)
	{
		String s = String.valueOf(f);
		if (s.endsWith(".0")) return s.substring(0, s.length() - 2);
		return s;
	}
	
	public static String multiplicationBounds(String s)
	{
		boolean[] added = new boolean[1];
		s = boundsCheck(s, '+', added);
		if (!added[0]) s = boundsCheck(s, '-', added);
		return s;
	}
	
	private static String boundsCheck(String s, char c, boolean[] added)
	{
		int i = s.indexOf("(");
		int j = s.indexOf(")");
		int k = s.indexOf(c);
		while (k != -1 && i != -1 && j != -1)
		{
			if (k < i) break;
			if (k < j) k = s.indexOf(c, k + 1);
			else
			{
				i = s.indexOf("(", i + 1);
				j = s.indexOf(")", i + 1);
			}
		}
		if (k != -1)
		{
			s = "(" + s + ")";
			added[0] = true;
		}
		return s;
	}
}

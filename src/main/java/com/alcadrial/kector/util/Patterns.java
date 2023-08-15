package com.alcadrial.kector.util;

import java.util.regex.Pattern;

public class Patterns {
	
	private Patterns()
	{}
	
	public static final Pattern WHITESPACE_PATTERN = Pattern.compile("\\p{javaWhitespace}+");
	public static final Pattern FIND_ANY_PATTERN = Pattern.compile("(?s).*");
	public static final Pattern NON_ASCII_DIGIT = Pattern.compile("[\\p{javaDigit}&&[^0-9]]");
	
	/**
	 * Locale dependent values used to scan numbers
	 */
	private static String groupSeparator = "\\,";
	private static String decimalSeparator = "\\.";
	private static String nanString = "NaN";
	private static String infinityString = "Infinity";
	private static String positivePrefix = "";
	private static String negativePrefix = "\\-";
	private static String positiveSuffix = "";
	private static String negativeSuffix = "";
	
	/**
	 * Fields and an accessor method to match booleans
	 */
	private static volatile Pattern boolPattern;
	private static final String BOOLEAN_PATTERN = "true|false";
	
	public static Pattern boolPattern()
	{
		if (boolPattern == null) boolPattern = Pattern.compile(BOOLEAN_PATTERN, Pattern.CASE_INSENSITIVE);
		return boolPattern;
	}
	
	/**
	 * Fields and methods to match bytes, shorts, ints, and longs
	 */
	private static Pattern integerPattern;
	private static String digits = "0123456789";
	private static String non0Digit = "[\\p{javaDigit}&&[^0]]";
	
	private static String buildIntegerPatternString()
	{
		String radixDigits = digits;
		String digit = "((?i)[" + radixDigits + "\\p{javaDigit}])";
		String groupedNumeral = "(" + non0Digit + digit + "?" + digit + "?(" + groupSeparator + digit + digit + digit + ")+)";
		String numeral = "((" + digit + "++)|" + groupedNumeral + ")";
		String javaStyleInteger = "([-+]?(" + numeral + "))";
		String negativeInteger = negativePrefix + numeral + negativeSuffix;
		String positiveInteger = positivePrefix + numeral + positiveSuffix;
		return "(" + javaStyleInteger + ")|(" + positiveInteger + ")|(" + negativeInteger + ")";
	}
	
	public static Pattern integerPattern()
	{
		if (integerPattern == null) integerPattern = Pattern.compile(buildIntegerPatternString());
		return integerPattern;
	}
	
	/**
	 * Fields and an accessor method to match line separators
	 */
	private static volatile Pattern separatorPattern;
	private static volatile Pattern linePattern;
	private static final String LINE_SEPARATOR_PATTERN = "\r\n|[\n\r\u2028\u2029\u0085]";
	private static final String LINE_PATTERN = ".*(" + LINE_SEPARATOR_PATTERN + ")|.+$";
	
	public static Pattern separatorPattern()
	{
		if (separatorPattern == null) separatorPattern = Pattern.compile(LINE_SEPARATOR_PATTERN);
		return separatorPattern;
	}
	
	public static Pattern linePattern()
	{
		if (linePattern == null) linePattern = Pattern.compile(LINE_PATTERN);
		return linePattern;
	}
	
	/**
	 * Fields and methods to match floats and doubles
	 */
	private static Pattern floatPattern;
	private static Pattern decimalPattern;
	
	private static void buildFloatAndDecimalPattern()
	{
		String digit = "(([0-9\\p{javaDigit}]))";
		String exponent = "([eE][+-]?" + digit + "+)?";
		String groupedNumeral = "(" + non0Digit + digit + "?" + digit + "?(" + groupSeparator + digit + digit + digit + ")+)";
		String numeral = "((" + digit + "++)|" + groupedNumeral + ")";
		String decimalNumeral = "(" + numeral + "|" + numeral + decimalSeparator + digit + "*+|" + decimalSeparator + digit + "++)";
		String nonNumber = "(NaN|" + nanString + "|Infinity|" + infinityString + ")";
		String positiveFloat = "(" + positivePrefix + decimalNumeral + positiveSuffix + exponent + ")";
		String negativeFloat = "(" + negativePrefix + decimalNumeral + negativeSuffix + exponent + ")";
		String decimal = "(([-+]?" + decimalNumeral + exponent + ")|" + positiveFloat + "|" + negativeFloat + ")";
		String hexFloat = "[-+]?0[xX][0-9a-fA-F]*\\.[0-9a-fA-F]+([pP][-+]?[0-9]+)?";
		String positiveNonNumber = "(" + positivePrefix + nonNumber + positiveSuffix + ")";
		String negativeNonNumber = "(" + negativePrefix + nonNumber + negativeSuffix + ")";
		String signedNonNumber = "(([-+]?" + nonNumber + ")|" + positiveNonNumber + "|" + negativeNonNumber + ")";
		floatPattern = Pattern.compile(decimal + "|" + hexFloat + "|" + signedNonNumber);
		decimalPattern = Pattern.compile(decimal);
	}
	
	public static Pattern floatPattern()
	{
		if (floatPattern == null) buildFloatAndDecimalPattern();
		return floatPattern;
	}
	
	public static Pattern decimalPattern()
	{
		if (decimalPattern == null) buildFloatAndDecimalPattern();
		return decimalPattern;
	}
}

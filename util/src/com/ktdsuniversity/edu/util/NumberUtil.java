package com.ktdsuniversity.edu.util;

public abstract class NumberUtil {
	
	private NumberUtil( ) {}
		
	public static byte toByte (String string) {
		try {
			return Byte.parseByte(string);
		}
		catch (NumberFormatException nfe) {
			return 0;
		}	
	}
	
	public static byte toByte(String string, Byte defaultValue) {
		try {
			return Byte.parseByte(string);
		}
		catch (NumberFormatException nfe) {
			return defaultValue;
		}
	}
	
	public static short toShort (String string) {
		try {
			return Short.parseShort(string);
		}
		catch (NumberFormatException nfe) {
			return 0;
		}
	}
	
	public static short toShort (String string, short defaultValue) {
		try {
			return Short.parseShort(string);
		}
		catch (NumberFormatException nfe) {
			return defaultValue;
		}
	}
	
	public static int toInt (String string) {
		try {
			return Integer.parseInt(string);
		}
		catch (NumberFormatException nfe) {
			return 0;
		}
	}
	
	public static int toInt (String string, int defaultValue) {
		try {
			return Integer.parseInt(string);
		}
		catch (NumberFormatException nfe) {
			return defaultValue;
		}
	}
	
	public static long toLong (String string) {
		try {
			return Long.parseLong(string);
		}
		catch (NumberFormatException nfe) {
			return 0;
		}
	}
	
	public static long toLong (String string, Long defaultValue) {
		try {
			return Long.parseLong(string);
		}
		catch (NumberFormatException nfe) {
			return defaultValue;
		}
	}
	
	public static float toFloat (String string) {
		try {
			return Float.parseFloat(string);
		}
		catch (NumberFormatException nfe) {
			return 0;
		}
	}
	
	public static float toFloat (String string, float defaultValue) {
		try {
			return Float.parseFloat(string);
		}
		catch (NumberFormatException nfe) {
			return defaultValue;
		}
	}
	
	public static double toDouble (String string) {
		try {
			return Double.parseDouble(string);
		}
		catch (NumberFormatException nfe) {
			return 0;
		}
	}
	
	public static double toDouble (String string, double defaultValue) {
		try {
			return Double.parseDouble(string);
		}
		catch (NumberFormatException nfe) {
			return defaultValue;
		}
	}
}

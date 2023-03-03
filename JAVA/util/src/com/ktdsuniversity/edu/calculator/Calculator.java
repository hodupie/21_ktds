package com.ktdsuniversity.edu.calculator;

import java.util.Scanner;

import com.ktdsuniversity.edu.exceptions.NotSupportAgeException;
import com.ktdsuniversity.edu.util.NumberUtil;

public class Calculator {
	
	public static void checkAge (int age) {
		if (age > 150) {
			throw new NotSupportAgeException("151세 이상은 입력할 수 없습니다.");
		}
	}
	
	public static void main(String[] args) {
		
		checkAge(10);
		
		try {
			checkAge(200);
		} catch (NotSupportAgeException nsae) {
			System.out.println(nsae.getMessage());
		}
		
		
		int age = 200;
		if (age > 150) {
//			throw new NotSupportAgeException();
			throw new NotSupportAgeException("151세 이상은 입력할 수 없습니다.");
		}
		
		
		Scanner scanner = new Scanner(System.in);
		String string = scanner.nextLine();
		
		
		// byte로 변경
		// try문 안에 있으면 try에서만 변수 이용 가능
		byte b = NumberUtil.toByte(string, (byte) 99);
		short s = NumberUtil.toShort(string, (short) 100);
		int i = NumberUtil.toInt(string, 150);
		long l = NumberUtil.toLong(string, 700L);
		float f = NumberUtil.toFloat(string, 150.0F);
		double d = NumberUtil.toDouble(string, 200.0);
		
		
		
		System.out.println(b);
		System.out.println(s);
		System.out.println(i);
		System.out.println(l);
		System.out.println(f);
		System.out.println(d);
		
		
		
	}
}
package com.ktdsuniversity.edu.exceptions;

public class NumberFormatExceptionTest {
	
	public static boolean isInteger(String string) {
		if (string == null) { return false; }
		return string.matches("^[0-9]+$");
	}
	
	public static void main(String[] args) {
		
		System.out.println(isInteger("abc"));
		
		String str = "1234";
		if (isInteger(str)) {
			int num = Integer.parseInt(str);
			System.out.println(num);
		}
		
		try {
			Integer.parseInt("adfa");
		}
		catch (NumberFormatException nfe) {
			System.out.println("숫자로 변환 중에 에러가 발생했습니다. " + nfe.getMessage());
		}
		System.out.println("숫자로 변환 종료");
	}

}

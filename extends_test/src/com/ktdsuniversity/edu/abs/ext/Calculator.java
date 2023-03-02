package com.ktdsuniversity.edu.abs.ext;

/**
 * 추상클래스
 * @author User
 */
public abstract class Calculator {
	
	//구현된 메소드
	public int calculate(String calcType, int numberOne, int numberTwo) {
		if (calcType.equals("+")) {
			return sum(numberOne, numberTwo);
		}
		else if (calcType.equals("-")) {
			return minus(numberOne, numberTwo);
		}
		return 0;
	}
	
	//구현되지 않은 메소드 --> 다른 클래스가 구현해야 함
	protected abstract int sum(int numberOne, int numberTwo);
	protected abstract int minus(int numberOne, int numberTwo);

}

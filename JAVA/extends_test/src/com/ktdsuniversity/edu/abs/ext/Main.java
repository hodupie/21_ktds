package com.ktdsuniversity.edu.abs.ext;

public class Main {
	
	public static void main(String[] args) {
		
		Calculator calc = new SimpleCalculator();
		
		//calc.sum(10,40) -> protected이기 때문에 불가?
		System.out.println(calc.calculate("+", 10, 40));
		System.out.println(calc.calculate("-", 10, 40));
		
	}

}

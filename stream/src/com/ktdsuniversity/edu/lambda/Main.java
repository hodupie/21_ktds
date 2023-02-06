package com.ktdsuniversity.edu.lambda;

import java.util.Arrays;
import java.util.List;

public class Main {
	
	public static void print(Printable printable) {
		printable.print("고앵이");
	}
	
	public static void printSumResult(Computable computable) {
		int sumResult = computable.sum(10, 30);
		System.out.println(sumResult);
	}
	
	public static void main(String[] args) {
		//익명클래스
		printSumResult(new Computable() {
			@Override
			public int sum(int numberOne, int numberTwo) {
				return numberOne + numberTwo;
			}});
		
		//람다함수
		printSumResult((num1, num2) -> num1 + num2);
		printSumResult((num1, num2) -> {
			return num1 + num2;
		});
		
		print(System.out::println);
		print((data) -> System.out.println(data + "입니다."));
		print((data) -> { 
			System.out.println(data + "입니다.");
		});
		
		List<Integer> intList = List.of(10, 20, 30, 40, 50);
		List<Integer> intList2 = Arrays.asList(10, 20, 30, 40);
		
		intList.forEach(System.out::println);
		intList2.forEach(System.out::println);

		
		
	}	
}

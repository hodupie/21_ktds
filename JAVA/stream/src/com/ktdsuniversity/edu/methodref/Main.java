package com.ktdsuniversity.edu.methodref;

import java.util.List;
import java.util.function.Predicate;

public class Main {
	
	public static void printEvenNumber(List<NumberVO> numberList, Predicate<NumberVO> predicate) {
		for (NumberVO number: numberList) {
			if (predicate.test(number)) {
				System.out.println(number.getNumber());
			}
		}
	}
	
	public static void main(String[] args) {
		printEvenNumber(List.of(new NumberVO(1), new NumberVO(2), new NumberVO(3), new NumberVO(4),
								new NumberVO(5), new NumberVO(6), new NumberVO(7), new NumberVO(8),
								new NumberVO(9), new NumberVO(10)), NumberVO::isEven);
		
		printEvenNumber(List.of(new NumberVO(1), new NumberVO(2), new NumberVO(3), new NumberVO(4),
				new NumberVO(5), new NumberVO(6), new NumberVO(7), new NumberVO(8),
				new NumberVO(9), new NumberVO(10)), (numberVO) -> numberVO.isEven());
		
		
	}
}

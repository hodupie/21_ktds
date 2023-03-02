package com.ktdsuniversity.edu.exceptions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IndexOutOfBoundsExceptionTest {
	
	public static void main(String[] args) {
		String string = "대림산업(현 DL이앤씨)과 SK건설(현 SK에코플랜트)이 트루키예 정부로부터 2017년 3월 공동 수주했다. 3조2000억원짜리 초대형 공사였고, 지난해 3월 18일 개통됐다.";
		
		List <String> wordList = new ArrayList<>();
		wordList.addAll(Arrays.asList(string.split(" ")));	// split이 return한 배열을 List로 변환
		
		try {
			String word = wordList.get(50);
			System.out.println(word);
		}
		catch(IndexOutOfBoundsException ioobe) {
			System.out.println("인덱스 범위 초과");
		}
	}

}

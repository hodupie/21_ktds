package com.ktdsuniversity.edu.exceptions;

public class ArrayIndexOutOfBoundsExceptionTest {
	
	public static void main(String[] args) {
		String[] nameArr = new String[3];
		nameArr[0] = "호두";
		nameArr[1] = "땅콩";
		nameArr[2] = "아몬드";
		
		String name = nameArr[0];
		System.out.println(name);
		
		name = nameArr[1];
		System.out.println(name);
		
		name = nameArr[2];
		System.out.println(name);
		
		if (nameArr.length > 3) {
			name = nameArr[3];
			System.out.println(name);
		}
		
		String string = "대림산업(현 DL이앤씨)과 SK건설(현 SK에코플랜트)이 트루키예 정부로부터 2017년 3월 공동 수주했다. 3조2000억원짜리 초대형 공사였고, 지난해 3월 18일 개통됐다.";
		String[] wordArray = string.split(" "); // 공백으로 잘라 배열에 넣기
		
		if (wordArray.length > 50) {
			String word = wordArray[50];
			System.out.println(word);
		}
		
		try {
			String word = wordArray[70];
			System.out.println(word);
		}
		catch(ArrayIndexOutOfBoundsException aioobe) {
			System.out.println("인덱스 범위 초과");
		}
	}	

}

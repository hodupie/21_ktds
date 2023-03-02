package com.ktdsuniversity.edu.exceptions;

import java.util.HashMap;
import java.util.Map;

public class ThrowNewTest {
	
	static Map<String, String> memberMap = new HashMap<>();
	
	
	public static boolean isCreate(String memberID) {
		// ID가 이미 존재한다면 exception throw
		if(memberMap.containsKey(memberID)) {
//			RuntimeException memeberIdException = new DuplicateMemberIDException(memberID);
//			throw memeberIdException;
			throw new DuplicateMemberIDException(memberID);
		}
		memberMap.put(memberID, "생성" + memberID);
		return memberMap.containsKey(memberID);
	}
	
	public static void main(String[] args) {
		boolean isCreate = isCreate("ktds001");
		System.out.println(isCreate);

		isCreate = isCreate("ktds001");
		System.out.println(isCreate);
		
		System.out.println("회원가입 완료");
		
	}
	

}

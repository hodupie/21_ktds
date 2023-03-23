package com.hello.member.Service;

import com.hello.member.vo.MemberVO;

public interface MemberService {
	
	public boolean createNewMember(MemberVO memberVO);
	
	/**
	 * 로그인을 위한 메소드
	 */
	public MemberVO readOneMemberByEmailAndPassword(MemberVO memberVO);

}

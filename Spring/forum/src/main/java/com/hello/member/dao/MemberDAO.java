package com.hello.member.dao;

import com.hello.member.vo.MemberVO;

/**
 * MyBatis 환경에서 DAO 메소드의 Parameter 규칙:
 * 항상 하나의 파라미터만 전달해야 한다.
 */
public interface MemberDAO {

	public int createNewMember(MemberVO memberVO);
	
	public int readCountMemberByEmail(String email);
	
	/**
	 * 로그인을 위한 메소드
	 */
	public MemberVO readOneMemberByEmailAndPassword(MemberVO memberVO);
}

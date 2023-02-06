package com.ktdsuniversity.edu.chohj.service;

import java.util.List;

import com.ktdsuniversity.edu.chohj.dao.ListMemberDAOImpl;
import com.ktdsuniversity.edu.chohj.dao.MemberDAO;
import com.ktdsuniversity.edu.chohj.vo.MemberVO;

public class SecondMemberServiceImpl implements MemberService {
	
	private MemberDAO memberDAO;
	
	public SecondMemberServiceImpl() {
		//memberDAO = new MapMemberDAOImpl();
		memberDAO = new ListMemberDAOImpl();
		
	}

	@Override
	public boolean create(MemberVO memberVO) {
		System.out.println("SecondMemberServiceImpl.create");
		return memberDAO.create(memberVO) > 0;
	}

	@Override
	public List<MemberVO> readAll() {
		System.out.println("SecondMemberServiceImpl.readAll");
		return memberDAO.readAll();
	}

	@Override
	public MemberVO read(String key) {
		System.out.println("SecondMemberServiceImpl.read");
		return memberDAO.read(key);
	}

	@Override
	public MemberVO read(int index) {
		return null;
	}

}

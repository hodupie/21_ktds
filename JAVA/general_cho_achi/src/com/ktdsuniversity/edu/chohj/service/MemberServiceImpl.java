package com.ktdsuniversity.edu.chohj.service;

import java.util.List;

import com.ktdsuniversity.edu.chohj.dao.MapMemberDAOImpl;
import com.ktdsuniversity.edu.chohj.dao.MemberDAO;
import com.ktdsuniversity.edu.chohj.vo.MemberVO;


public class MemberServiceImpl implements MemberService {
	
	private MemberDAO memberDAO;
	
	public MemberServiceImpl() {
		memberDAO = new MapMemberDAOImpl();
	}

	@Override
	public boolean create(MemberVO memberVO) {
		return memberDAO.create(memberVO) > 0;
	}
	@Override
	public List<MemberVO> readAll() {
		return memberDAO.readAll();
	}

	@Override
	public MemberVO read(String key) {
		return memberDAO.read(key);
	}

	@Override
	public MemberVO read(int index) {
		return null;
	}
	

}

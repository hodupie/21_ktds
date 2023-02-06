package com.ktdsuniversity.edu.chohj.dao;

import java.util.List;

import com.ktdsuniversity.edu.chohj.vo.MemberVO;

public interface MemberDAO {
	
	public int create(MemberVO memberVO);
	
	public List<MemberVO> readAll();
	
	public MemberVO read(String key);
	
	public MemberVO read(int index);
	
}

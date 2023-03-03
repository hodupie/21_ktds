package com.ktdsuniversity.edu.chohj.service;

import java.util.List;

import com.ktdsuniversity.edu.chohj.vo.MemberVO;

public interface MemberService {
	
	// 성공/실패 여부 return
	public boolean create(MemberVO memberVO);
	
	public List<MemberVO> readAll();
	
	public MemberVO read(int index);
	
	public MemberVO read(String key);

}

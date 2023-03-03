package com.ktdsuniversity.edu.chohj.dao;

import java.util.ArrayList;
import java.util.List;

import com.ktdsuniversity.edu.chohj.vo.MemberVO;

public class ListMemberDAOImpl implements MemberDAO {
	
	private List<MemberVO> dataSource;
	
	public ListMemberDAOImpl() {
		dataSource = new ArrayList<>();
	}

	@Override
	public int create(MemberVO memberVO) {
		dataSource.add(memberVO);
		return 1;
	}

	@Override
	public List<MemberVO> readAll() {
		return dataSource;
	}
	
	@Override
	public MemberVO read(String key) {
		return null;
	}

	@Override
	public MemberVO read(int index) {
		return dataSource.get(index);
	}

}

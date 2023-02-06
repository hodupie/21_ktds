package com.ktdsuniversity.edu.chohj.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.ktdsuniversity.edu.chohj.vo.MemberVO;

public class MapMemberDAOImpl implements MemberDAO {
	
	private Map<String, MemberVO> dataSource;
	
	//생성자
	public MapMemberDAOImpl() {
		dataSource = new HashMap<>();
	}

	@Override
	public int create(MemberVO memberVO) {
		dataSource.put(memberVO.getId(), memberVO);
		return 1;
	}

	@Override
	public List<MemberVO> readAll() {
		return dataSource.entrySet().stream().map(entry -> entry.getValue()).collect(Collectors.toList());
	}

	@Override
	public MemberVO read(String key) {
		return dataSource.get(key);
	}

	@Override
	public MemberVO read(int index) {
		return null;
	}


	

}

package com.ktdsuniversity.edu.mv.mvppl.dao;

import java.util.List;

import com.ktdsuniversity.edu.mv.mvppl.vo.MvPplVO;

public interface MvPplDAO {
	
	/**
	 * 영화인 데이터 생성
	 * @param mvPplVO
	 * @return 생성된 데이터 수
	 */
	public int createMyPpl(MvPplVO mvPplVO);
	
	/**
	 * 모든 영화인 데이터 조회
	 * @return 영화인 데이터 List
	 */
	public List<MvPplVO> readAllMyPpl();
	
	/**
	 * 영화인 데이터 수정
	 * @param mvPplVO
	 * @return 수정된 데이터 수
	 */
	public int updateMyPpl(MvPplVO mvPplVO);
	
	/**
	 * 영화인 데이터 삭제
	 * @param mvPplId
	 * @return 삭제된 데이터 수
	 */
	public int deleteMyPpl(String mvPplId);
}

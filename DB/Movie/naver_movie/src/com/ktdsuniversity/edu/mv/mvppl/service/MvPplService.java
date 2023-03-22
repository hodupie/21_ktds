package com.ktdsuniversity.edu.mv.mvppl.service;

import java.util.List;

import com.ktdsuniversity.edu.mv.mvppl.vo.MvPplVO;

public interface MvPplService {
	
	/**
	 * 영화인 데이터 생성
	 * @param mvPplVO
	 * @return 생성 결과
	 */
	public boolean createMyPpl(MvPplVO mvPplVO);
	
	/**
	 * 모든 영화인 데이터 조회
	 * @return 모든 영화인 데이터 List
	 */
	public List<MvPplVO> readAllMyPpl();
	
	/**
	 * 영화인 데이터 수정
	 * @param mvPplVO
	 * @return 수정 결과
	 */
	public boolean updateMyPpl(MvPplVO mvPplVO);
	
	/**
	 * 영화인 데이터 삭제
	 * @param mvPplId (삭제할 데이터의 PK)
	 * @return 삭제 결과
	 */
	public boolean deleteMyPpl(String mvPplId);

}

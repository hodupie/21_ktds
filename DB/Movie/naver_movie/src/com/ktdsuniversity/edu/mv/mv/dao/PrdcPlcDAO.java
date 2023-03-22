package com.ktdsuniversity.edu.mv.mv.dao;

import com.ktdsuniversity.edu.mv.mv.vo.MvVO;

public interface PrdcPlcDAO {
	
	/**
	 * 영화 제작지 등록
	 * @param mvVO
	 * @return 등록 건수
	 */
	public int createPrdcPlc(MvVO mvVO);
	
	/**
	 * 영화 제작지 삭제
	 * @param mvVO
	 * @return 삭제 건수
	 */
	public int deletePrdcPlc(String mvId);

}

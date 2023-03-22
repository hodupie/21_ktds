package com.ktdsuniversity.edu.mv.mv.dao;

import com.ktdsuniversity.edu.mv.mv.vo.MvVO;

public interface PrdcPrtcptnPplDAO {
	
	/**
	 * 제작참여인 등록
	 * @param mvVO
	 * @return 제작참여인 데이터 등록 수
	 */
	public int createPrdcPrtcptnPpl(MvVO mvVO);
	
	/**
	 * 제작참여회인 삭제
	 * @param mvVO
	 * @return 삭제 건수
	 */
	public int deletePrdcPrtcptnPpl(String mvId);

}

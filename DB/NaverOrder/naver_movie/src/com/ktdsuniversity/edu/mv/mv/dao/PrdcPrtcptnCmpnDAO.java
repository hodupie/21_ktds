package com.ktdsuniversity.edu.mv.mv.dao;

import com.ktdsuniversity.edu.mv.mv.vo.MvVO;

public interface PrdcPrtcptnCmpnDAO {
	
	/**
	 * 제작참여회사 등록
	 * @param mvVO
	 * @return 제작참여회사 데이터 등록 건수
	 */
	public int createPrdcPrtcptnCmpn(MvVO mvVO);
	
	/**
	 * 제작참여회사 삭제
	 * @param mvVO
	 * @return 삭제 건수
	 */
	public int deletePrdcPrtcptnCmpn(String mvId);
}

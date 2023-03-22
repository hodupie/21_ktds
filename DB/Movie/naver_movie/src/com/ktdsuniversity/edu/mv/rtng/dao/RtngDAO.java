package com.ktdsuniversity.edu.mv.rtng.dao;

import java.util.List;

import com.ktdsuniversity.edu.mv.rtng.vo.RtngVO;

public interface RtngDAO {
	
	/**
	 * 평점 데이터 등록
	 * @param mvVO
	 * @return 등록된 평점 데이터 수
	 */
	public int createRtng(RtngVO rtngVO);
	
	/**
	 * 모든 평점 데이터 조회
	 * @return
	 */
	public List<RtngVO> readAllRtng();
	
	/**
	 * 평점 데이터 수정
	 * @param rtngVO
	 * @return 수정된 평점 데이터 수
	 */
	public int updateRtng(RtngVO rtngVO);
	
	/**
	 * 평점 데이터 삭제
	 * @param rtngId
	 * @return 삭제된 데이터 수
	 */
	public int deleteRtng(String rtngId);
}

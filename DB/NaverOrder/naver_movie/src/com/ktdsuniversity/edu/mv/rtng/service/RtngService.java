package com.ktdsuniversity.edu.mv.rtng.service;

import java.util.List;

import com.ktdsuniversity.edu.mv.rtng.vo.RtngVO;

public interface RtngService {
	
	/**
	 * 평점 데이터 등록
	 * @param mvVO
	 * @return 평점 데이터 등록 결과
	 */
	public boolean createRtngDAO(RtngVO rtngVO);
	
	/**
	 * 모든 평점 데이터 조회
	 * @return
	 */
	public List<RtngVO> readAllRtng();
	
	/**
	 * 평점 데이터 수정
	 * @param rtngVO
	 * @return 평점 데이터 수정 결과
	 */
	public boolean updateRtngDAO(RtngVO rtngVO);
	
	/**
	 * 평점 데이터 삭제
	 * @param rtngId
	 * @return 삭제된 데이터 수
	 */
	public boolean deleteRtng(String rtngId);

}

package com.ktdsuniversity.edu.mv.ntn.service;

import java.util.List;

import com.ktdsuniversity.edu.mv.ntn.vo.NtnVO;

public interface NtnService {
	
	/**
	 * 국가 데이터 생성
	 * @param ntnVO
	 * @return 생성 결과
	 */
	public boolean createNtn(NtnVO ntnVO);
	
	/**
	 * 모든 국가 데이터 조회
	 * @return 모든 국가 데이터 List
	 */
	public List<NtnVO> readAllNtn();
	
	/**
	 * 국가 데이터 수정
	 * @param ntnVO
	 * @return 수정 결과
	 */
	public boolean updateNtn(NtnVO ntnVO);

	/**
	 * 국가 데이터 삭제
	 * @param ntnId (삭제할 데이터의 PK)
	 * @return 삭제 결과
	 */
	public boolean deleteNtn(int ntnId);

}

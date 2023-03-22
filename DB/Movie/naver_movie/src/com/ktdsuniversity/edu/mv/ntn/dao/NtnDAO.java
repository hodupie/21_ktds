package com.ktdsuniversity.edu.mv.ntn.dao;

import java.util.List;

import com.ktdsuniversity.edu.mv.ntn.vo.NtnVO;

public interface NtnDAO {
	
	/**
	 * 국가 데이터 생성
	 * @param ntnVO
	 * @return 생성된 데이터 수
	 */
	public int createNtn(NtnVO ntnVO);
	
	/**
	 * 모든 국가 데이터 조회
	 * @return 모든 국가 데이터 List
	 */
	public List<NtnVO> readAllNtn();
	
	/**
	 * 국가 데이터 수정
	 * @param ntnVO
	 * @return 수정된 데이터 수
	 */
	public int updateNtn(NtnVO ntnVO);
	
	/**
	 * 국가 데이터 삭제
	 * @param ntnId (삭제할 데이터의 PK)
	 * @return 삭제된 데이터 수
	 */
	public int deleteNtn(int ntnId);

}

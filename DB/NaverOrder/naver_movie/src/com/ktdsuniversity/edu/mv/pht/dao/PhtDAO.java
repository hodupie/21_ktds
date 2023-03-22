package com.ktdsuniversity.edu.mv.pht.dao;

import java.util.List;

import com.ktdsuniversity.edu.mv.pht.vo.PhtVO;


public interface PhtDAO {
	
	/**
	 * 사진 데이터 생성
	 * @param PhtVO
	 * @return 생성된 데이터 수
	 */
	public int createPht(PhtVO phtVO);
	
	/**
	 * 모든 사진 데이터 조회
	 * @return 모든 사진 데이터 List
	 */
	public List<PhtVO> readAllPht();
	
	/**
	 * 사진 데이터 수정
	 * @param PhtVO
	 * @return 수정된 데이터 수
	 */
	public int updatePht(PhtVO phtVO);
	
	/**
	 * 사진 데이터 삭제
	 * @param PhtId (삭제할 데이터의 PK)
	 * @return 삭제된 데이터 수
	 */
	public int deletePht(String phtId);

}

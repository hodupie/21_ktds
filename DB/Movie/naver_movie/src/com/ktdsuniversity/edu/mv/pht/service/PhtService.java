package com.ktdsuniversity.edu.mv.pht.service;

import java.util.List;

import com.ktdsuniversity.edu.mv.pht.vo.PhtVO;

public interface PhtService {
	
	/**
	 * 사진 데이터 생성
	 * @param phtVO
	 * @return 생성 결과
	 */
	public boolean createPht(PhtVO phtVO);
	
	/**
	 * 모든 사진 데이터 조회
	 * @return 모든 사진 데이터 List
	 */
	public List<PhtVO> readAllPht();
	
	/**
	 * 사진 데이터 수정
	 * @param phtVO
	 * @return 수정 결과
	 */
	public boolean updatePht(PhtVO phtVO);

	/**
	 * 사진 데이터 삭제
	 * @param phtId (삭제할 데이터의 PK)
	 * @return 삭제 결과
	 */
	public boolean deletePht(String phtId);

}

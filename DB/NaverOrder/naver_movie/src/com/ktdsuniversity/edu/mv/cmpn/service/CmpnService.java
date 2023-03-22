package com.ktdsuniversity.edu.mv.cmpn.service;

import java.util.List;

import com.ktdsuniversity.edu.mv.cmpn.vo.CmpnVO;

public interface CmpnService {
	
	/**
	 * 회사 데이터 생성
	 * @param cmpnVO
	 * @return 생성 결과
	 */
	public boolean createCmpn(CmpnVO cmpnVO);
	
	/**
	 * 모든 회사 데이터 조회
	 * @return 모든 회사 데이터 List
	 */
	public List<CmpnVO> readAllCmpn();
	
	/**
	 * 회사 데이터 수정
	 * @param cmpnVO
	 * @return 수정 결과
	 */
	public boolean updateCmpn(CmpnVO cmpnVO);
	
	/**
	 * 회사 데이터 삭제
	 * @param cmpnId (삭제할 데이터의 PK)
	 * @return 삭제 결과
	 */
	public boolean deleteCmpn(String cmpnId);

}

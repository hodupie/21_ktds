package com.ktdsuniversity.edu.mv.cmpn.dao;

import java.util.List;

import com.ktdsuniversity.edu.mv.cmpn.vo.CmpnVO;

public interface CmpnDAO {
	
	/**
	 * 회사 데이터 생성
	 * @param cmpnVO
	 * @return 생성된 데이터 수
	 */
	public int createCmpn(CmpnVO cmpnVO);
	
	/**
	 * 모든 회사 데이터 조회
	 * @return 모든 회사 데이터 List
	 */
	public List<CmpnVO> readAllCmpn();
	
	/**
	 * 회사 데이터 수정
	 * @param cmpnVO
	 * @return 수정된 데이터 수
	 */
	public int updateCmpn(CmpnVO cmpnVO);
	
	/**
	 * 회사 데이터 삭제
	 * @param cmpnId (삭제할 데이터의 PK)
	 * @return 삭제된 데이터 수
	 */
	public int deleteCmpn(String cmpnId);


}

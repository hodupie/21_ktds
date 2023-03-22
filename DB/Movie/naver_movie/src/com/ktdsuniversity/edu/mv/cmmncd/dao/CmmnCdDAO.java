package com.ktdsuniversity.edu.mv.cmmncd.dao;

import java.util.List;

import com.ktdsuniversity.edu.mv.cmmncd.vo.CmmnCdVO;

public interface CmmnCdDAO {
	
	/**
	 * 공통코드 데이터 생성
	 * @param cmmnCdVO
	 * @return 생성된 데이터 수
	 */
	public int createCmmnCd(CmmnCdVO cmmnCdVO);
	
	/**
	 * 모든 공통코드 데이터 조회
	 * @return 모든 공통코드 데이터 List
	 */
	public List<CmmnCdVO> readAllCmmnCd();
	
	/**
	 * 공통코드 데이터 수정
	 * @param cmmnCdVO
	 * @return 수정된 데이터 수
	 */
	public int updateCmmnCd(CmmnCdVO cmmnCdVO);
	
	/**
	 * 공통코드 데이터 삭제
	 * @param cdId (삭제할 데이터의 PK)
	 * @return 삭제한 데이터 수
	 */
	public int deleteCmmnCd(String cdId);
}

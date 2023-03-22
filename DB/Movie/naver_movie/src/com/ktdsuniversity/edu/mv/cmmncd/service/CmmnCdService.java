package com.ktdsuniversity.edu.mv.cmmncd.service;

import java.util.List;

import com.ktdsuniversity.edu.mv.cmmncd.vo.CmmnCdVO;

public interface CmmnCdService {
	
	/**
	 * 공통코드 데이터 생성
	 * @param cmmnCdVO
	 * @return 생성 결과
	 */
	public boolean createCmmnCd(CmmnCdVO cmmnCdVO);
	
	/**
	 * 모든 공통코드 데이터 조회
	 * @return 모든 공통코드 데이터 List
	 */
	public List<CmmnCdVO> readAllCmmnCd();
	
	/**
	 * 공통코드 데이터 수정
	 * @param cmmnCdVO
	 * @return 수정 결과
	 */
	public boolean updateCmmnCd(CmmnCdVO cmmnCdVO);
	
	/**
	 * 공통코드 데이터 삭제
	 * @param cdId (삭제할 데이터의 PK)
	 * @return 삭제 결과
	 */
	public boolean deleteCmmnCd(String cdId);

}

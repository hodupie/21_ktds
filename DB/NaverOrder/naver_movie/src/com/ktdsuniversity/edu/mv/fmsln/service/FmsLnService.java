package com.ktdsuniversity.edu.mv.fmsln.service;

import java.util.List;

import com.ktdsuniversity.edu.mv.fmsln.vo.FmsLnVO;

public interface FmsLnService {
	/**
	 * 명대사 데이터 등록
	 * @param fmsLnVO
	 * @return 데이터 등록 결과
	 */
	public boolean createFmsLn(FmsLnVO fmsLnVO);
	
	/**
	 * 모든 명대사 데이터 조회
	 * @return
	 */
	public List<FmsLnVO> readAllFmsLn();
	
	/**
	 * 명대사 데이터 수정
	 * @param fmsLnVO
	 * @return 데이터 수정 결과
	 */
	public boolean updateFmsLn(FmsLnVO fmsLnVO);
	
	/**
	 * 명대사 데이터 삭제
	 * @param fmsLnId
	 * @return 삭제된 데이터 수
	 */
	public boolean deleteFmsLn(String fmsLnId);

}

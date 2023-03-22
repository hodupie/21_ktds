package com.ktdsuniversity.edu.mv.fmsln.dao;

import java.util.List;

import com.ktdsuniversity.edu.mv.fmsln.vo.FmsLnVO;

public interface FmsLnDAO {
	
	/**
	 * 명대사 데이터 등록
	 * @param fmsLnVO
	 * @return 등록된 데이터 수
	 */
	public int createFmsLn(FmsLnVO fmsLnVO);
	
	/**
	 * 모든 명대사 데이터 조회
	 * @return
	 */
	public List<FmsLnVO> readAllFmsLn();
	
	/**
	 * 명대사 데이터 업데이트
	 * @param fmsLnVO
	 * @return 업데이트된 데이터 수
	 */
	public int updateFmsLn(FmsLnVO fmsLnVO);
	
	/**
	 * 명대사 데이터 삭제
	 * @param fmsLnId
	 * @return 삭제된 데이터 수
	 */
	public int deleteFmsLn(String fmsLnId);

}

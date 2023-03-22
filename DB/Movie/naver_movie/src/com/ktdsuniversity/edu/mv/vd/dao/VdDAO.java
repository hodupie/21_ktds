package com.ktdsuniversity.edu.mv.vd.dao;

import java.util.List;

import com.ktdsuniversity.edu.mv.vd.vo.VdVO;

public interface VdDAO {
	
	/**
	 * 동영상 데이터 생성
	 * @param vdVO
	 * @return 생성된 데이터 수
	 */
	public int creatdVd(VdVO vdVO);
	
	/**
	 * 모든 동영상 데이터 조회
	 * @return
	 */
	public List<VdVO> readAllVd();
	
	/**
	 * 동영상 데이터 수정
	 * @param vdVO
	 * @return 수정된 데이터 수
	 */
	public int updateVd(VdVO vdVO);
	
	/**
	 * 동영상 데이터 삭제
	 * @param vdId
	 * @return 삭제된 데이터 수
	 */
	public int deleteVd(String vdId);
}

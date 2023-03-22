package com.ktdsuniversity.edu.mv.vd.service;

import java.util.List;

import com.ktdsuniversity.edu.mv.vd.vo.VdVO;

public interface VdService {
	
	/**
	 * 동영상 데이터 생성
	 * @param vdVO
	 * @return 데이터 생성된 수
	 */
	public boolean creatdVd(VdVO vdVO);
	
	/**
	 * 모든 동영상 데이터 조회
	 * @return
	 */
	public List<VdVO> readAllVd();
	
	/**
	 * 동영상 데이터 수정
	 * @param vdVO
	 * @return 데이터 수정 결과
	 */
	public boolean updateVd(VdVO vdVO);
	
	/**
	 * 동영상 데이터 삭제
	 * @param vdId
	 * @return 데이터 삭제 결과
	 */
	public boolean deleteVd(String vdId);


}

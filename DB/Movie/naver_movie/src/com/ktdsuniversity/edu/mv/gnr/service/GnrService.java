package com.ktdsuniversity.edu.mv.gnr.service;

import java.util.List;

import com.ktdsuniversity.edu.mv.gnr.vo.GnrVO;

public interface GnrService {
	
	/**
	 * 생성 (create)
	 * @param gnrVO (생성할 내용)
	 * @return 등록 결과(성공/실패)
	 */
	public boolean createGnr(GnrVO gnrVO);
	
	/**
	 * 조회 (read)
	 * @return GNR 테이블의 모든 정보 List
	 */
	public List<GnrVO> readAllGnr();
	
	/**
	 * 수정 (update)
	 * PK값은 수정 불가
	 * @param gnrVO (변경될 내용)
	 * @return 변경 결과(성공/실패)
	 */
	public boolean updateGnr(GnrVO gnrVO);
	
	/**
	 * 삭제 (delete)
	 * 참조되고 있는 다른 테이블 상관 X
	 * @param gnrId (삭제대상id = GNR의 PK)
	 * @return 삭제 결과(성공/실패)
	 */
	public boolean deleteGnr(int gnrId);


}

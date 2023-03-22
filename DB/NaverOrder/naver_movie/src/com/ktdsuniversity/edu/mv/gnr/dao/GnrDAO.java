package com.ktdsuniversity.edu.mv.gnr.dao;

import java.util.List;

import com.ktdsuniversity.edu.mv.gnr.vo.GnrVO;

/**
 * GNR 테이블과 연동하기 위한 DAO
 * @author User
 *
 */
public interface GnrDAO {
	
	/**
	 * 장르 데이터 생성 (create)
	 * @param gnrVO (생성할 내용)
	 * @return 생성된 데이터 수
	 */
	public int createGnr(GnrVO gnrVO);
	
	/**
	 * 모든 장르 데이터 조회 (read)
	 * @return GNR 테이블의 모든 정보 List
	 */
	public List<GnrVO> readAllGnr();
	
	/**
	 * 장르 데이터 수정 (update)
	 * PK값은 수정 불가
	 * @param gnrVO (변경될 내용)
	 * @return 변경된 데이터 수
	 */
	public int updateGnr(GnrVO gnrVO);
	
	/**
	 * 장르 데이터 삭제 (delete)
	 * 참조되고 있는 다른 테이블 상관 X
	 * @param gnrId (삭제대상id = GNR의 PK)
	 * @return 삭제된 데이터 수
	 */
	public int deleteGnr(int gnrId);

}

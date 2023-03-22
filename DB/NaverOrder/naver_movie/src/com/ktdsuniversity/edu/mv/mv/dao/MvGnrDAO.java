package com.ktdsuniversity.edu.mv.mv.dao;

import com.ktdsuniversity.edu.mv.mv.vo.MvVO;

/**
 * 영화_장르 테이블
 * @author User
 *
 */
public interface MvGnrDAO {
	
	// 하나의 영화는 여러 장르를 가진다
	// -> 영화ID와 장르리스트의 정보를 모두 가지고 있는 mvVO를 파라미터로 
	/**
	 * 영화_장르 등록
	 * @param mvVO
	 * @return 등록 건수
	 */
	public int createMvGnr(MvVO mvVO);
	
	/**
	 * 영화_장르 삭제
	 * @param mvVO
	 * @return 삭제 건수
	 */
	public int deleteMvGnr(String mvId);

}

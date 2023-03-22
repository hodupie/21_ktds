package com.ktdsuniversity.edu.mv.rtng.dao;

import java.util.List;

import com.ktdsuniversity.edu.mv.rtng.vo.RtngVO;
import com.ktdsuniversity.edu.mv.util.db.AbstractAutoDaoPoolSupport;

public class RtngDAOImpl extends AbstractAutoDaoPoolSupport<RtngVO> implements RtngDAO {

	@Override
	public int createRtng(RtngVO rtngVO) {
		StringBuffer query = new StringBuffer();
		query.append(" INSERT INTO RTNG ");
		query.append("  (RTNG_ID        ");
		query.append(" , MV_ID          ");
		query.append(" , RTNG           ");
		query.append(" , RTNG_CNTNT     ");
		query.append(" , RTNG_WRTR      ");
		query.append(" , RTNG_RGST_TM   ");
		query.append(" , LK_CNT         ");
		query.append(" , DSLK_CNT)      ");
		query.append(" VALUES           ");
		query.append("  ('MR-' || TO_CHAR(SYSDATE, 'YYYYMMDD') || '-' || LPAD(SEQ_RTNG_PK.NEXTVAL, 5, '0') ");
		query.append(" , ?              ");
		query.append(" , ?              ");
		query.append(" , ?              ");
		query.append(" , ?              ");
		query.append(" , SYSDATE        ");
		query.append(" , 0              ");
		query.append(" , 0)             ");
		
		
		return super.insert(query.toString(), (pstmt) -> {
			pstmt.setString(1, rtngVO.getMvId());
			pstmt.setInt(2, rtngVO.getRtng());
			pstmt.setString(3, rtngVO.getRtngCntnt());
			pstmt.setString(4, rtngVO.getRtngWrtr());
		});
	}
	
	@Override
	public List<RtngVO> readAllRtng() {
		StringBuffer query = new StringBuffer();
		query.append(" SELECT RTNG_ID       ");
		query.append("  	 , MV_ID        ");
		query.append("  	 , RTNG         ");
		query.append("  	 , RTNG_CNTNT   ");
		query.append("  	 , RTNG_WRTR    ");
		query.append("  	 , RTNG_RGST_TM ");
		query.append("  	 , LK_CNT       ");
		query.append("  	 , DSLK_CNT     ");
		query.append("    FROM RTNG         ");

		return super.select(query.toString(), null, RtngVO.class);
	}

	@Override
	public int updateRtng(RtngVO rtngVO) {
		StringBuffer query = new StringBuffer();
		query.append(" UPDATE RTNG             ");
		query.append("    SET RTNG = ?         ");
		query.append("      , RTNG_CNTNT = ?   ");
		query.append("  WHERE RTNG_ID = ?      ");

		return super.update(query.toString(), (pstmt) -> {
			pstmt.setInt(1, rtngVO.getRtng());
			pstmt.setString(2, rtngVO.getRtngCntnt());
			pstmt.setString(3, rtngVO.getRtngId());
		});
	}

	@Override
	public int deleteRtng(String rtngId) {
		StringBuffer query = new StringBuffer();
		query.append(" DELETE             ");
		query.append("   FROM RTNG        ");
		query.append("  WHERE RTNG_ID = ? ");
		return super.delete(query.toString(), (pstmt) -> {
			pstmt.setString(1, rtngId);
		});
	}

}

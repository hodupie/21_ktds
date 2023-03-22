package com.ktdsuniversity.edu.mv.gnr.dao;

import java.util.List;

import com.ktdsuniversity.edu.mv.gnr.vo.GnrVO;
import com.ktdsuniversity.edu.mv.util.db.AbstractAutoDaoPoolSupport;

public class GnrDAOImpl extends AbstractAutoDaoPoolSupport<GnrVO> implements GnrDAO {

	@Override
	public int createGnr(GnrVO gnrVO) {
		StringBuffer query = new StringBuffer();
		query.append(" INSERT INTO GNR      ");
		query.append("  (GNR_ID             ");
		query.append(" , GNR_NM)            ");
		query.append(" VALUES               ");
		query.append("  (SEQ_GNR_PK.NEXTVAL ");
		query.append(" , ?)                ");
		 
		return super.insert(query.toString(), (pstmt) -> {
			pstmt.setString(1, gnrVO.getGnrNm());
		});

	}

	@Override
	public List<GnrVO> readAllGnr() {
		StringBuffer query = new StringBuffer();
		query.append(" SELECT GNR_ID ");
		query.append("      , GNR_NM ");
		query.append("   FROM GNR    ");
		
		return super.select(query.toString(), null, GnrVO.class);
	}

	@Override
	public int updateGnr(GnrVO gnrVO) {
		StringBuffer query = new StringBuffer();
		query.append(" UPDATE GNR        ");
		query.append("    SET GNR_NM = ? ");
		query.append("  WHERE GNR_ID = ? ");
		
		return super.update(query.toString(), (pstmt) -> {
			pstmt.setString(1, gnrVO.getGnrNm());
			pstmt.setInt(2, gnrVO.getGnrId());
		});
	}

	@Override
	public int deleteGnr(int gnrId) {
		StringBuffer query = new StringBuffer();
		query.append(" DELETE             ");
		query.append("   FROM GNR        ");
		query.append("  WHERE GNR_ID = ? ");
		return super.delete(query.toString(), (pstmt) -> {
			pstmt.setInt(1, gnrId);
		});
	}
	

}

package com.ktdsuniversity.edu.mv.pht.dao;

import java.util.List;

import com.ktdsuniversity.edu.mv.pht.vo.PhtVO;
import com.ktdsuniversity.edu.mv.util.db.AbstractAutoDaoPoolSupport;

public class PhtDAOImpl extends AbstractAutoDaoPoolSupport<PhtVO> implements PhtDAO {

	@Override
	public int createPht(PhtVO phtVO) {
		StringBuffer query = new StringBuffer();
		query.append(" INSERT INTO PHT ");
		query.append("  (PHT_ID        ");
		query.append(" , MV_ID         ");
		query.append(" , PHT_TP        ");
		query.append(" , THMBNL_PHT    ");
		query.append(" , ORGNL_PHT)    ");
		query.append(" VALUES          ");
		query.append("  ('PT-' || TO_CHAR(SYSDATE, 'YYYYMMDD') || '-' || LPAD(SEQ_PHT_PK.NEXTVAL, 5, '0') ");
		query.append(" , ?             ");
		query.append(" , ?             ");
		query.append(" , ?             ");
		query.append(" , ?)            ");
		
		return super.insert(query.toString(), (pstmt) -> {
			pstmt.setString(1, phtVO.getMvId());
			pstmt.setString(2, phtVO.getPhtTp());
			pstmt.setString(3, phtVO.getThmbnlPht());
			pstmt.setString(4, phtVO.getOrgnlPht());
		});
	}

	@Override
	public List<PhtVO> readAllPht() {
		StringBuffer query = new StringBuffer();
		query.append(" SELECT PHT_ID     ");
		query.append("      , MV_ID      ");
		query.append("      , PHT_TP     ");
		query.append("      , THMBNL_PHT ");
		query.append("      , ORGNL_PHT  ");
		query.append("   FROM PHT        ");
		
		return super.select(query.toString(), null, PhtVO.class);

	}

	@Override
	public int updatePht(PhtVO phtVO) {
		StringBuffer query = new StringBuffer();
		query.append(" UPDATE PHT            ");
		query.append(" 	  SET PHT_TP = ?     ");
		query.append(" 	    , THMBNL_PHT = ? ");
		query.append(" 	    , ORGNL_PHT = ?  ");
		query.append("  WHERE PHT_ID = ?     ");

		return super.update(query.toString(), (pstmt) -> {
			pstmt.setString(1, phtVO.getPhtTp());
			pstmt.setString(2, phtVO.getThmbnlPht());
			pstmt.setString(3, phtVO.getOrgnlPht());
			pstmt.setString(4, phtVO.getPhtId());
		});
	}

	@Override
	public int deletePht(String phtId) {
		StringBuffer query = new StringBuffer();
		query.append(" DELETE             ");
		query.append("   FROM PHT        ");
		query.append("  WHERE PHT_ID = ? ");
		return super.delete(query.toString(), (pstmt) -> {
			pstmt.setString(1, phtId);
		});
	}

}

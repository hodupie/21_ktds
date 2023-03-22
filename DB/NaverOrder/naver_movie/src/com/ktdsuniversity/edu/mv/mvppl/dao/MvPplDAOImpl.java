package com.ktdsuniversity.edu.mv.mvppl.dao;

import java.util.List;

import com.ktdsuniversity.edu.mv.mvppl.vo.MvPplVO;
import com.ktdsuniversity.edu.mv.util.db.AbstractAutoDaoPoolSupport;

public class MvPplDAOImpl extends AbstractAutoDaoPoolSupport<MvPplVO> implements MvPplDAO{

	@Override
	public int createMyPpl(MvPplVO mvPplVO) {
		StringBuffer query = new StringBuffer();
		
		query.append(" INSERT INTO MV_PPL                                                                    ");
		query.append("  (MV_PPL_ID                                                                           ");
		query.append(" , PRFL_PHT                                                                            ");
		query.append(" , NM                                                                                  ");
		query.append(" , RL_NM)                                                                              ");
		query.append(" VALUES                                                                                ");
		query.append("  ('PD-' || TO_CHAR(SYSDATE, 'YYYYMMDD') || '-' || LPAD(SEQ_MV_PPL_PK.NEXTVAL, 5, '0') ");
		query.append(" , ? 						                                                             ");
		query.append(" , ?                                                                                   ");
		query.append(" , ?)                                                                                  ");
		
		return super.insert(query.toString(), (pstmt) -> {
			pstmt.setString(1, mvPplVO.getPrflPht());
			pstmt.setString(2, mvPplVO.getNm());
			pstmt.setString(3, mvPplVO.getRlNm());
		});
	}

	@Override
	public List<MvPplVO> readAllMyPpl() {
		StringBuffer query = new StringBuffer();
		query.append(" SELECT MV_PPL_ID ");
		query.append("      , PRFL_PHT  ");
		query.append("      , NM, RL_NM ");
		query.append("   FROM MV_PPL    ");

		return super.select(query.toString(), null, MvPplVO.class);
	}

	@Override
	public int updateMyPpl(MvPplVO mvPplVO) {
		StringBuffer query = new StringBuffer();
		
		query.append(" UPDATE MV_PPL        ");
		query.append("    SET PRFL_PHT = ?  ");
		query.append(" 	 , NM = ?           ");
		query.append(" 	 , RL_NM = ?        ");
		query.append("  WHERE MV_PPL_ID = ? ");

		return super.update(query.toString(), (pstmt) -> {
			pstmt.setString(1, mvPplVO.getPrflPht());
			pstmt.setString(2, mvPplVO.getNm());
			pstmt.setString(3, mvPplVO.getRlNm());
			pstmt.setString(4, mvPplVO.getMvPplId());
		});
	}

	@Override
	public int deleteMyPpl(String mvPplId) {
		StringBuffer query = new StringBuffer();
		query.append(" DELETE             ");
		query.append("   FROM MV_PPL        ");
		query.append("  WHERE MV_PPL_ID = ? ");
		return super.delete(query.toString(), (pstmt) -> {
			pstmt.setString(1, mvPplId);
		});
	}

}

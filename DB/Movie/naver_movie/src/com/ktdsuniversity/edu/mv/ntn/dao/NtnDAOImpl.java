package com.ktdsuniversity.edu.mv.ntn.dao;

import java.util.List;

import com.ktdsuniversity.edu.mv.ntn.vo.NtnVO;
import com.ktdsuniversity.edu.mv.util.db.AbstractAutoDaoPoolSupport;

public class NtnDAOImpl extends AbstractAutoDaoPoolSupport<NtnVO> implements NtnDAO {

	@Override
	public int createNtn(NtnVO ntnVO) {
		StringBuffer query = new StringBuffer();
		query.append(" INSERT INTO NTN     ");
		query.append("  (NTN_ID            ");
		query.append(" , NTN_NM)           ");
		query.append(" VALUES              ");
		query.append(" (SEQ_NTN_PK.NEXTVAL ");
		query.append(" , ?)                ");
		
		return super.insert(query.toString(), (pstmt) -> {
			pstmt.setString(1, ntnVO.getNtnNm());
		});
	}

	@Override
	public List<NtnVO> readAllNtn() {
		StringBuffer query = new StringBuffer();
		query.append(" SELECT NTN_ID ");
		query.append("      , NTN_NM ");
		query.append("   FROM NTN    ");

		return super.select(query.toString(), null, NtnVO.class);
	}

	@Override
	public int updateNtn(NtnVO ntnVO) {
		StringBuffer query = new StringBuffer();
		query.append(" UPDATE NTN        ");
		query.append("    SET NTN_NM = ? ");
		query.append("  WHERE NTN_ID = ? ");

		return super.update(query.toString(), (pstmt) -> {
			pstmt.setString(1, ntnVO.getNtnNm());
			pstmt.setInt(2, ntnVO.getNtnId());
		});
	}

	@Override
	public int deleteNtn(int ntnId) {
		StringBuffer query = new StringBuffer();
		query.append(" DELETE             ");
		query.append("   FROM NTN        ");
		query.append("  WHERE NTN_ID = ? ");
		return super.delete(query.toString(), (pstmt) -> {
			pstmt.setInt(1, ntnId);
		});
	}
	

}

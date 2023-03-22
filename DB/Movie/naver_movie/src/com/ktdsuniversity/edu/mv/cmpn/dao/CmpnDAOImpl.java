package com.ktdsuniversity.edu.mv.cmpn.dao;

import java.util.List;

import com.ktdsuniversity.edu.mv.cmpn.vo.CmpnVO;
import com.ktdsuniversity.edu.mv.util.db.AbstractAutoDaoPoolSupport;

public class CmpnDAOImpl extends AbstractAutoDaoPoolSupport<CmpnVO> implements CmpnDAO {

	@Override
	public int createCmpn(CmpnVO cmpnVO) {
		StringBuffer query = new StringBuffer();
		
		query.append(" INSERT INTO CMPN                                                                     ");
		query.append("  (CMPN_ID                                                                            ");
		query.append(" , CMPN_NM)                                                                           ");
		query.append(" VALUES                                                                               ");
		query.append("  ('CO-' || TO_CHAR(SYSDATE, 'YYYYMMDD') || '-' || LPAD(SEQ_CMPN_PK.NEXTVAL, 5, '0')  ");
		query.append(" , ?)                                                                                 ");
		
		return super.insert(query.toString(), (pstmt) -> {
			pstmt.setString(1, cmpnVO.getCmpnNm());
		});
	}

	@Override
	public List<CmpnVO> readAllCmpn() {
		StringBuffer query = new StringBuffer();
		query.append(" SELECT CMPN_ID  ");
	    query.append("   	 , CMPN_NM ");
	    query.append("   FROM CMPN     ");
		return super.select(query.toString(), null, CmpnVO.class);
	}

	@Override
	public int updateCmpn(CmpnVO cmpnVO) {
		StringBuffer query = new StringBuffer();
		
		query.append(" UPDATE CMPN        ");
		query.append("    SET CMPN_NM = ? ");
		query.append("  WHERE CMPN_ID = ? ");

		return super.update(query.toString(), (pstmt) -> {
			pstmt.setString(1, cmpnVO.getCmpnNm());
			pstmt.setString(2, cmpnVO.getCmpnId());
		});
	}

	@Override
	public int deleteCmpn(String cmpnId) {
		StringBuffer query = new StringBuffer();
		query.append(" DELETE             ");
		query.append("   FROM CMPN        ");
		query.append("  WHERE CMPN_ID = ? ");
		return super.delete(query.toString(), (pstmt) -> {
			pstmt.setString(1, cmpnId);
		});
	}

}

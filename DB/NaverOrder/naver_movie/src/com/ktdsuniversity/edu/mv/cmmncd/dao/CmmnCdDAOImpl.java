package com.ktdsuniversity.edu.mv.cmmncd.dao;

import java.util.List;

import com.ktdsuniversity.edu.mv.cmmncd.vo.CmmnCdVO;
import com.ktdsuniversity.edu.mv.util.db.AbstractAutoDaoPoolSupport;

public class CmmnCdDAOImpl extends AbstractAutoDaoPoolSupport<CmmnCdVO> implements CmmnCdDAO {

	@Override
	public int createCmmnCd(CmmnCdVO cmmnCdVO) {
		StringBuffer query = new StringBuffer();
		query.append(" INSERT INTO CMMN_CD ");
		query.append("  (CD_ID             ");
		query.append(" , CD_NM             ");
		query.append(" , PRCDNC_CD_ID)     ");
		query.append(" VALUES              ");
		query.append("  ( ?                ");
		query.append("  , ?                ");
		query.append("  , ?)               ");
		
		return super.insert(query.toString(), (pstmt) -> {
			pstmt.setString(1, cmmnCdVO.getCdId());
			pstmt.setString(2, cmmnCdVO.getCdNm());
			pstmt.setString(3, cmmnCdVO.getPrcdncCdId());
		});
	}

	@Override
	public List<CmmnCdVO> readAllCmmnCd() {
		StringBuffer query = new StringBuffer();
		query.append(" SELECT CD_ID        ");
		query.append("      , CD_NM        ");
		query.append("      , PRCDNC_CD_ID ");
		query.append("   FROM CMMN_CD      ");
		
		return super.select(query.toString(), null, CmmnCdVO.class);
	}

	@Override
	public int updateCmmnCd(CmmnCdVO cmmnCdVO) {
		return 0;
	}

	@Override
	public int deleteCmmnCd(String cdId) {
		return 0;
	}

}

package com.ktdsuniversity.edu.mv.fmsln.dao;

import java.util.List;

import com.ktdsuniversity.edu.mv.fmsln.vo.FmsLnVO;
import com.ktdsuniversity.edu.mv.util.db.AbstractAutoDaoPoolSupport;

public class FmsLnDAOImpl extends AbstractAutoDaoPoolSupport<FmsLnVO> implements FmsLnDAO {

	@Override
	public int createFmsLn(FmsLnVO fmsLnVO) {
		StringBuffer query = new StringBuffer();
		query.append(" INSERT INTO FMS_LN ");
		query.append("  (FMS_LN_ID        ");
		query.append(" , MV_ID            ");
		query.append(" , MV_PPL_ID        ");
		query.append(" , FMS_LN           ");
		query.append(" , XPLNTN           ");
		query.append(" , RGST_TM          ");
		query.append(" , RGST_PPL_NM      ");
		query.append(" , RCMMND_CNT)      ");
		query.append(" VALUES             ");
		query.append("  ('FL-' || TO_CHAR(SYSDATE, 'YYYYMMDD') || '-' || LPAD(SEQ_FMS_LN_PK.NEXTVAL, 5, '0') ");
		query.append(" , ?               ");
		query.append(" , ?               ");
		query.append(" , ?               ");
		query.append(" , ?               ");
		query.append(" , SYSDATE         ");
		query.append(" , ?               ");
		query.append(" , 0)              ");
		
		return super.insert(query.toString(), (pstmt) -> {
			pstmt.setString(1, fmsLnVO.getMvId());
			pstmt.setString(2, fmsLnVO.getMvPplId());
			pstmt.setString(3, fmsLnVO.getFmsLn());
			pstmt.setString(4, fmsLnVO.getXplntn());
			pstmt.setString(5, fmsLnVO.getRgstPplNm());
		});
	}
	
	@Override
	public List<FmsLnVO> readAllFmsLn() {
		StringBuffer query = new StringBuffer();
		query.append(" SELECT FMS_LN_ID   ");
		query.append("      , MV_ID       ");
		query.append("      , MV_PPL_ID   ");
		query.append("      , FMS_LN      ");
		query.append("      , XPLNTN      ");
		query.append("      , RGST_TM     ");
		query.append("      , RGST_PPL_NM ");
		query.append("      , RCMMND_CNT  ");
		query.append("   FROM FMS_LN      ");
		
		return super.select(query.toString(), null, FmsLnVO.class);
	}

	@Override
	public int updateFmsLn(FmsLnVO fmsLnVO) {
		StringBuffer query = new StringBuffer();
		query.append(" UPDATE FMS_LN        ");
		query.append("    SET MV_PPL_ID = ? ");
		query.append("      , FMS_LN = ?    ");
		query.append("      , XPLNTN = ?    ");
		query.append("  WHERE FMS_LN_ID = ? ");

		return super.update(query.toString(), (pstmt) -> {
			pstmt.setString(1, fmsLnVO.getMvPplId());
			pstmt.setString(2, fmsLnVO.getFmsLn());
			pstmt.setString(3, fmsLnVO.getXplntn());
			pstmt.setString(4, fmsLnVO.getFmsLnId());
		});
	}

	@Override
	public int deleteFmsLn(String fmsLnId) {
		StringBuffer query = new StringBuffer();
		query.append(" DELETE             ");
		query.append("   FROM FMS_LN        ");
		query.append("  WHERE FMS_LN_ID = ? ");
		return super.delete(query.toString(), (pstmt) -> {
			pstmt.setString(1, fmsLnId);
		});
	}



}

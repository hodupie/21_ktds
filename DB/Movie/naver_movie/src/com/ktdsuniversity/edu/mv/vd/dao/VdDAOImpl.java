package com.ktdsuniversity.edu.mv.vd.dao;

import java.util.List;

import com.ktdsuniversity.edu.mv.util.db.AbstractAutoDaoPoolSupport;
import com.ktdsuniversity.edu.mv.vd.vo.VdVO;

public class VdDAOImpl extends AbstractAutoDaoPoolSupport<VdVO> implements VdDAO {

	@Override
	public int creatdVd(VdVO vdVO) {
		StringBuffer query = new StringBuffer();
		query.append(" INSERT INTO VD                                                                    ");
		query.append("  (VD_ID                                                                           ");
		query.append(" , MV_ID                                                                           ");
		query.append(" , VD_TP                                                                           ");
		query.append(" , VD_TTL                                                                          ");
		query.append(" , THMBNL                                                                          ");
		query.append(" , VD_PLY_CNT                                                                      ");
		query.append(" , VD_URL                                                                          ");
		query.append(" , RGST_DT)                                                                        ");
		query.append(" VALUES                                                                            ");
		query.append("  ('VD-' || TO_CHAR(SYSDATE, 'YYYYMMDD') || '-' || LPAD(SEQ_VD_PK.NEXTVAL, 5, '0') ");
		query.append(" , ?                                                                               ");
		query.append(" , ?                                                                               ");
		query.append(" , ?                                                                               ");
		query.append(" , ?                                                                               ");
		query.append(" , 0                                                                               ");
		query.append(" , ?                                                                               ");
		query.append(" , SYSDATE)                                                        ");
		
		return super.insert(query.toString(), (pstmt) -> {
			pstmt.setString(1, vdVO.getMvId());
			pstmt.setString(2, vdVO.getVdTp());
			pstmt.setString(3, vdVO.getVdTtl());
			pstmt.setString(4, vdVO.getThmbnl());
			pstmt.setString(5, vdVO.getVdUrl());
		});
	}
	
	@Override
	public List<VdVO> readAllVd() {
		StringBuffer query = new StringBuffer();
		query.append(" SELECT VD_ID      ");
		query.append("      , MV_ID      ");
		query.append("      , VD_TP      ");
		query.append("      , VD_TTL     ");
		query.append("      , THMBNL     ");
		query.append("      , VD_PLY_CNT ");
		query.append("      , VD_URL     ");
		query.append("      , RGST_DT    ");
		query.append("   FROM VD         ");

		return super.select(query.toString(), null, VdVO.class);
	}

	@Override
	public int updateVd(VdVO vdVO) {
		StringBuffer query = new StringBuffer();
		query.append(" UPDATE VD         ");
		query.append("    SET VD_TP = ?  ");
		query.append("      , VD_TTL = ? ");
		query.append("      , THMBNL = ? ");
		query.append("      , VD_URL = ? ");
		query.append("  WHERE VD_ID = ?  ");

		return super.update(query.toString(), (pstmt) -> {
			pstmt.setString(1, vdVO.getVdTp());
			pstmt.setString(2, vdVO.getVdTtl());
			pstmt.setString(3, vdVO.getThmbnl());
			pstmt.setString(4, vdVO.getVdUrl());
			pstmt.setString(5, vdVO.getMvId());
		});
	}

	@Override
	public int deleteVd(String vdId) {
		StringBuffer query = new StringBuffer();
		query.append(" DELETE             ");
		query.append("   FROM VD        ");
		query.append("  WHERE VD_ID = ? ");
		return super.delete(query.toString(), (pstmt) -> {
			pstmt.setString(1, vdId);
		});
	}

}

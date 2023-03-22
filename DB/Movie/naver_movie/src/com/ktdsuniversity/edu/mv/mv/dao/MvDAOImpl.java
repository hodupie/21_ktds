package com.ktdsuniversity.edu.mv.mv.dao;

import java.util.List;

import com.ktdsuniversity.edu.mv.mv.vo.MvVO;
import com.ktdsuniversity.edu.mv.util.db.AbstractAutoDaoPoolSupport;

public class MvDAOImpl extends AbstractAutoDaoPoolSupport<MvVO> implements MvDAO {

	@Override
	public String createNewMvId() {
		StringBuffer query = new StringBuffer();
		query.append(" SELECT 'MV-' || TO_CHAR(SYSDATE, 'YYYYMMDD') || '-' || LPAD(SEQ_MV_PK.NEXTVAL, 5, '0') NEW_SEQ");
		query.append("   FROM DUAL ");
		
		return super.selectOneString(query.toString(), null);
	}
	
	@Override
	public int createMv(MvVO mvVO) {
		StringBuffer query = new StringBuffer();
		query.append(" INSERT INTO MV              ");
		query.append("  (MV_ID                     ");
		query.append("  , MV_TTL                   ");
		query.append("  , ENG_TTL                  ");
		query.append("  , SCRN_STT                 ");
		query.append("  , SCRN_TM                  ");
		query.append("  , OPNG_DT                  ");
		query.append("  , GRD                      ");
		query.append("  , PSTR                     ");
		query.append("  , SMR)                     ");
		query.append(" VALUES                      ");
		query.append("  ( ? 					   ");
		query.append("  , ?                        ");
		query.append("  , ?                        ");
		query.append("  , ?                        ");
		query.append("  , ?                        ");
		query.append("  , TO_DATE(?, 'YYYY.MM.DD') ");
		query.append("  , ?                        ");
		query.append("  , ?                        ");
		query.append("  , ?)                       ");
		
		return super.insert(query.toString(), (pstmt) -> {
			pstmt.setString(1, mvVO.getMvId());
			pstmt.setString(2, mvVO.getMvTtl());
			pstmt.setString(3, mvVO.getEngTtl());
			pstmt.setString(4, mvVO.getScrnStt());
			pstmt.setInt(5, mvVO.getScrnTm());
			pstmt.setString(6, mvVO.getOpngDt());
			pstmt.setString(7, mvVO.getGrd());
			pstmt.setString(8, mvVO.getPstr());
			pstmt.setString(9, mvVO.getSmr());
		});
	}
	
	@Override
	public List<MvVO> readAllMovie() {
		StringBuffer query = new StringBuffer();
		query.append(" SELECT M.MV_ID              ");
		query.append("      , M.MV_TTL             ");
		query.append("      , M.ENG_TTL            ");
		query.append("      , M.SCRN_STT           ");
		query.append("      , M.SCRN_TM            ");
		query.append("      , M.OPNG_DT            ");
		query.append("      , M.GRD                ");
		query.append("      , M.PSTR               ");
		query.append("      , M.SMR                ");
		query.append("      , G.GNR_ID             ");
		query.append("      , G.GNR_NM             ");
		query.append("      , N.NTN_ID             ");
		query.append("      , N.NTN_NM             ");
	    query.append("   FROM MV M                 ");
	    query.append("  INNER JOIN MV_GNR MG       ");
	    query.append("     ON M.MV_ID = MG.MV_ID   ");
	    query.append("  INNER JOIN GNR G           ");
	    query.append("     ON MG.GNR_ID = G.GNR_ID ");
	    query.append("  INNER JOIN PRDC_PLC PP     ");
	    query.append("     ON M.MV_ID = PP.MV_ID   ");
	    query.append("  INNER JOIN NTN N           ");
	    query.append("     ON PP.NTN_ID = N.NTN_ID ");
	    
		return selectByKey(query.toString(), null, MvVO.class);
	}
	
	@Override
	public MvVO readOneMv(String mvId) {
		StringBuffer query = new StringBuffer();
		query.append(" SELECT M.MV_ID              ");
		query.append("      , M.MV_TTL             ");
		query.append("      , M.ENG_TTL            ");
		query.append("      , M.SCRN_STT           ");
		query.append("      , M.SCRN_TM            ");
		query.append("      , M.OPNG_DT            ");
		query.append("      , M.GRD                ");
		query.append("      , M.PSTR               ");
		query.append("      , M.SMR                ");
		query.append("      , G.GNR_ID             ");
		query.append("      , G.GNR_NM             ");
		query.append("      , N.NTN_ID             ");
		query.append("      , N.NTN_NM             ");
	    query.append("   FROM MV M                 ");
	    query.append("  INNER JOIN MV_GNR MG       ");
	    query.append("     ON M.MV_ID = MG.MV_ID   ");
	    query.append("  INNER JOIN GNR G           ");
	    query.append("     ON MG.GNR_ID = G.GNR_ID ");
	    query.append("  INNER JOIN PRDC_PLC PP     ");
	    query.append("     ON M.MV_ID = PP.MV_ID   ");
	    query.append("  INNER JOIN NTN N           ");
	    query.append("     ON PP.NTN_ID = N.NTN_ID ");
	    query.append("  WHERE M.MV_ID = ?          ");
	    
		return selectOne(query.toString(), (pstmt) -> {
			pstmt.setString(1, mvId);
		}, MvVO.class);
	}

	@Override
	public int updateMv(MvVO mvVO) {
		StringBuffer query = new StringBuffer();
		query.append(" UPDATE MV           ");
		query.append("    SET MV_TTL = ?   ");
		query.append("      , ENG_TTL = ?  ");
		query.append("      , SCRN_STT = ? ");
		query.append("      , SCRN_TM = ?  ");
		query.append("      , OPNG_DT = TO_DATE(?, 'YYYY.MM.DD')  ");
		query.append("      , GRD = ?      ");
		query.append("      , PSTR = ?     ");
		query.append("      , SMR = ?      ");
		query.append("  WHERE MV_ID = ?    ");
		
		return super.update(query.toString(), (pstmt) -> {
			pstmt.setString(1, mvVO.getMvTtl());
			pstmt.setString(2, mvVO.getEngTtl());
			pstmt.setString(3, mvVO.getScrnStt());
			pstmt.setInt(4, mvVO.getScrnTm());
			pstmt.setString(5, mvVO.getOpngDt());
			pstmt.setString(6, mvVO.getGrd());
			pstmt.setString(7, mvVO.getPstr());
			pstmt.setString(8, mvVO.getSmr());
			pstmt.setString(9, mvVO.getMvId());
		});
	}

	@Override
	public int deleteMv(String mvId) {
		StringBuffer query = new StringBuffer();
		query.append(" DELETE           ");
		query.append("   FROM MV        ");
		query.append("  WHERE MV_ID = ? ");
		return super.delete(query.toString(), (pstmt) -> {
			pstmt.setString(1, mvId);
		});
	}

}

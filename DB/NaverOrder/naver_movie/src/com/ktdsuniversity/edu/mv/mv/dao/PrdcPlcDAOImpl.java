package com.ktdsuniversity.edu.mv.mv.dao;

import java.util.List;

import com.ktdsuniversity.edu.mv.mv.vo.MvVO;
import com.ktdsuniversity.edu.mv.ntn.vo.NtnVO;
import com.ktdsuniversity.edu.mv.util.db.AbstractAutoDaoPoolSupport;

public class PrdcPlcDAOImpl extends AbstractAutoDaoPoolSupport<NtnVO> implements PrdcPlcDAO {

	@Override
	public int createPrdcPlc(MvVO mvVO) {
		int insertCount = 0;
		StringBuffer query = new StringBuffer();
		
		String mvId = mvVO.getMvId();
		List<NtnVO> ntnList = mvVO.getNtnList();
		
		query.append(" INSERT INTO PRDC_PLC ");
		query.append("  (MV_ID              ");
		query.append(" , NTN_ID)            ");
		query.append(" VALUES               ");
		query.append("  (?                  ");
		query.append(" , ?)                 ");
		
		for (NtnVO ntn : ntnList) {
			insertCount += super.insert(query.toString(), (pstmt) -> {
				pstmt.setString(1, mvId);
				pstmt.setInt(2, ntn.getNtnId());
			});
		}
		
		return insertCount;
	}

	@Override
	public int deletePrdcPlc(String mvId) {
		StringBuffer query = new StringBuffer();
		query.append(" DELETE           ");
		query.append("   FROM PRDC_PLC    ");
		query.append("  WHERE MV_ID = ? ");
		
		return super.delete(query.toString(), (pstmt) -> {
			pstmt.setString(1, mvId);
		});
	}

}

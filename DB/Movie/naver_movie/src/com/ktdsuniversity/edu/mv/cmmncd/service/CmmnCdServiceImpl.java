package com.ktdsuniversity.edu.mv.cmmncd.service;

import java.util.List;

import com.ktdsuniversity.edu.mv.cmmncd.dao.CmmnCdDAO;
import com.ktdsuniversity.edu.mv.cmmncd.dao.CmmnCdDAOImpl;
import com.ktdsuniversity.edu.mv.cmmncd.vo.CmmnCdVO;

public class CmmnCdServiceImpl implements CmmnCdService {
	
	private CmmnCdDAO cmmnCdDAO;
	
	public CmmnCdServiceImpl() {
		cmmnCdDAO = new CmmnCdDAOImpl();
	}

	@Override
	public boolean createCmmnCd(CmmnCdVO cmmnCdVO) {
		int insertCount = cmmnCdDAO.createCmmnCd(cmmnCdVO);
		return insertCount > 0;
	}

	@Override
	public List<CmmnCdVO> readAllCmmnCd() {
		return cmmnCdDAO.readAllCmmnCd();
	}

	@Override
	public boolean updateCmmnCd(CmmnCdVO cmmnCdVO) {
		return false;
	}

	@Override
	public boolean deleteCmmnCd(String cdId) {
		return false;
	}

}

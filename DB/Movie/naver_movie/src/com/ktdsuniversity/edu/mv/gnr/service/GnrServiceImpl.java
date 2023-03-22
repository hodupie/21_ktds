package com.ktdsuniversity.edu.mv.gnr.service;

import java.util.List;

import com.ktdsuniversity.edu.mv.gnr.dao.GnrDAO;
import com.ktdsuniversity.edu.mv.gnr.dao.GnrDAOImpl;
import com.ktdsuniversity.edu.mv.gnr.vo.GnrVO;

public class GnrServiceImpl implements GnrService {

	private GnrDAO gnrDAO;
	
	public GnrServiceImpl() {
		gnrDAO = new GnrDAOImpl();
	}
	
	@Override
	public boolean createGnr(GnrVO gnrVO) {
		return gnrDAO.createGnr(gnrVO) > 0;
	}

	@Override
	public List<GnrVO> readAllGnr() {
		return gnrDAO.readAllGnr();
	}

	@Override
	public boolean updateGnr(GnrVO gnrVO) {
		int updateCount = gnrDAO.updateGnr(gnrVO);
		return updateCount > 0;
	}

	@Override
	public boolean deleteGnr(int gnrId) {
		return gnrDAO.deleteGnr(gnrId) > 0;
	}


}

package com.ktdsuniversity.edu.mv.pht.service;

import java.util.List;

import com.ktdsuniversity.edu.mv.pht.dao.PhtDAO;
import com.ktdsuniversity.edu.mv.pht.dao.PhtDAOImpl;
import com.ktdsuniversity.edu.mv.pht.vo.PhtVO;

public class PhtServiceImpl implements PhtService {
	
	private PhtDAO phtDAO;
	
	public PhtServiceImpl() {
		phtDAO = new PhtDAOImpl();
	}

	@Override
	public boolean createPht(PhtVO phtVO) {
		return phtDAO.createPht(phtVO) > 0;
	}

	@Override
	public List<PhtVO> readAllPht() {
		return phtDAO.readAllPht();
	}

	@Override
	public boolean updatePht(PhtVO phtVO) {
		return phtDAO.updatePht(phtVO) > 0;
	}

	@Override
	public boolean deletePht(String phtId) {
		return phtDAO.deletePht(phtId) > 0;
	}

}

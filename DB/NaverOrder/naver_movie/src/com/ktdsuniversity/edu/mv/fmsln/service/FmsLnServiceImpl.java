package com.ktdsuniversity.edu.mv.fmsln.service;

import java.util.List;

import com.ktdsuniversity.edu.mv.fmsln.dao.FmsLnDAO;
import com.ktdsuniversity.edu.mv.fmsln.dao.FmsLnDAOImpl;
import com.ktdsuniversity.edu.mv.fmsln.vo.FmsLnVO;

public class FmsLnServiceImpl implements FmsLnService {

	private FmsLnDAO fmsLnDAO;
	
	public FmsLnServiceImpl() {
		fmsLnDAO = new FmsLnDAOImpl();
	}
	@Override
	public boolean createFmsLn(FmsLnVO fmsLnVO) {
		return fmsLnDAO.createFmsLn(fmsLnVO) > 0;
	}
	
	@Override
	public List<FmsLnVO> readAllFmsLn() {
		return fmsLnDAO.readAllFmsLn();
	}
	
	@Override
	public boolean updateFmsLn(FmsLnVO fmsLnVO) {
		return fmsLnDAO.updateFmsLn(fmsLnVO) > 0;
	}
	
	@Override
	public boolean deleteFmsLn(String fmsLnId) {
		return fmsLnDAO.deleteFmsLn(fmsLnId) > 0;
	}


}

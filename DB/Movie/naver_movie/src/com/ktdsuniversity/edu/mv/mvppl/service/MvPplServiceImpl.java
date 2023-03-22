package com.ktdsuniversity.edu.mv.mvppl.service;

import java.util.List;

import com.ktdsuniversity.edu.mv.mvppl.dao.MvPplDAO;
import com.ktdsuniversity.edu.mv.mvppl.dao.MvPplDAOImpl;
import com.ktdsuniversity.edu.mv.mvppl.vo.MvPplVO;

public class MvPplServiceImpl implements MvPplService {
	
	private MvPplDAO mvPplDAO;
	
	public MvPplServiceImpl() {
		mvPplDAO = new MvPplDAOImpl();
	}
	
	@Override
	public boolean createMyPpl(MvPplVO mvPplVO) {
		return mvPplDAO.createMyPpl(mvPplVO) > 0;
	}

	@Override
	public List<MvPplVO> readAllMyPpl() {
		return mvPplDAO.readAllMyPpl();
	}

	@Override
	public boolean updateMyPpl(MvPplVO mvPplVO) {
		return mvPplDAO.updateMyPpl(mvPplVO) > 0;
	}

	@Override
	public boolean deleteMyPpl(String mvPplId) {
		return mvPplDAO.deleteMyPpl(mvPplId) > 0;
	}
	
	

}

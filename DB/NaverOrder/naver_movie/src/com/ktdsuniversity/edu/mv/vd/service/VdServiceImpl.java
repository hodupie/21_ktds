package com.ktdsuniversity.edu.mv.vd.service;

import java.util.List;

import com.ktdsuniversity.edu.mv.vd.dao.VdDAO;
import com.ktdsuniversity.edu.mv.vd.dao.VdDAOImpl;
import com.ktdsuniversity.edu.mv.vd.vo.VdVO;

public class VdServiceImpl implements VdService {

	private VdDAO vdDAO;
	
	public VdServiceImpl() {
		vdDAO = new VdDAOImpl();
	}
	@Override
	public boolean creatdVd(VdVO vdVO) {
		return vdDAO.creatdVd(vdVO) > 0;
	}
	
	@Override
	public List<VdVO> readAllVd() {
		return vdDAO.readAllVd();
	}
	
	@Override
	public boolean updateVd(VdVO vdVO) {
		return vdDAO.updateVd(vdVO) > 0;
	}
	@Override
	public boolean deleteVd(String vdId) {
		return vdDAO.deleteVd(vdId) > 0;
	}

}

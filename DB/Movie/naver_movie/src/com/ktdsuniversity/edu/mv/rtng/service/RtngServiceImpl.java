package com.ktdsuniversity.edu.mv.rtng.service;

import java.util.List;

import com.ktdsuniversity.edu.mv.rtng.dao.RtngDAO;
import com.ktdsuniversity.edu.mv.rtng.dao.RtngDAOImpl;
import com.ktdsuniversity.edu.mv.rtng.vo.RtngVO;

public class RtngServiceImpl implements RtngService {
	
	private RtngDAO rtngDAO;
	
	public RtngServiceImpl() {
		rtngDAO = new RtngDAOImpl();
	}
	
	@Override
	public boolean createRtngDAO(RtngVO rtngVO) {
		return rtngDAO.createRtng(rtngVO) > 0;
	}
	
	@Override
	public List<RtngVO> readAllRtng() {
		return rtngDAO.readAllRtng();
	}

	@Override
	public boolean updateRtngDAO(RtngVO rtngVO) {
		return rtngDAO.updateRtng(rtngVO) > 0;
	}

	@Override
	public boolean deleteRtng(String rtngId) {
		return rtngDAO.deleteRtng(rtngId) > 0;
	}

}

package com.ktdsuniversity.admin.mbr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktdsuniversity.admin.mbr.dao.MbrDAO;
import com.ktdsuniversity.admin.mbr.vo.MbrVO;

@Service
public class MbrServiceImpl implements MbrService{
	
	@Autowired
	private MbrDAO mbrDAO;

	@Override
	public MbrVO readOneMbrByIdAndPwd(MbrVO mbrVO) {
		return mbrDAO.readOneMbrByIdAndPwd(mbrVO);
	}
	
	

}

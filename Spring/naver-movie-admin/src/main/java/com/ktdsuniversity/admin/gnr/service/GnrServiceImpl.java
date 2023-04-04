package com.ktdsuniversity.admin.gnr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktdsuniversity.admin.common.api.exceptions.ApiException;
import com.ktdsuniversity.admin.gnr.dao.GnrDAO;
import com.ktdsuniversity.admin.gnr.vo.GnrVO;

@Service
public class GnrServiceImpl implements GnrService {
	
	@Autowired
	private GnrDAO gnrDAO;

	@Override
	public List<GnrVO> readAllGnrVO(GnrVO gnrVO) {
		return gnrDAO.readAllGnrVO(gnrVO);
	}

	@Override
	public boolean createOneGnr(GnrVO gnrVO) {
		return gnrDAO.createOneGnr(gnrVO) > 0;
	}

	@Override
	public boolean updateOneGnr(GnrVO gnrVO) {
		return gnrDAO.updateOneGnr(gnrVO) > 0;
	}

	@Override
	public boolean deleteOneGnrByGnrId(int gnrId) {
		return gnrDAO.deleteOneGnrByGnrId(gnrId) > 0;
	}

	@Override
	public boolean deleteGnrBySelectedGnrId(List<Integer> gnrId) {
		int delCount = gnrDAO.deleteGnrBySelectedGnrId(gnrId);
		boolean isSuccess =  gnrDAO.deleteGnrBySelectedGnrId(gnrId) == gnrId.size();
		if (!isSuccess) {
			throw new ApiException("500", "삭제 실패. 요청건수: " + gnrId.size() + "건, 삭제건수: " + delCount + "건");
		}
		return isSuccess;
	}

}

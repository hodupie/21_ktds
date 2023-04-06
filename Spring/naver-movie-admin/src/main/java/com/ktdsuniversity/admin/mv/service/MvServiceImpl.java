package com.ktdsuniversity.admin.mv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktdsuniversity.admin.common.api.exceptions.ApiArgsException;
import com.ktdsuniversity.admin.mv.dao.MvDAO;
import com.ktdsuniversity.admin.mv.vo.MvVO;
import com.ktdsuniversity.admin.mvgnr.dao.MvGnrDAO;
import com.ktdsuniversity.admin.mvgnr.vo.MvGnrVO;
import com.ktdsuniversity.admin.prdcprtcptnppl.dao.PrdcPrtcptnPplDAO;
import com.ktdsuniversity.admin.prdcprtcptnppl.vo.PrdcPrtcptnPplVO;

@Service
public class MvServiceImpl implements MvService {
	
	@Autowired
	private MvDAO mvDAO;
	
	@Autowired
	private MvGnrDAO mvGnrDAO;
	
	@Autowired
	private PrdcPrtcptnPplDAO prdcPrtcptnPplDAO;

	@Override
	public boolean createNewMv(MvVO mvVO) {
		int mvCreateCount = mvDAO.createNewMv(mvVO);
		if (mvCreateCount > 0) {
			// 장르등록 반복
			List<MvGnrVO> gnrList = mvVO.getGnrList();
			if (gnrList == null || gnrList.isEmpty()) {
				throw new ApiArgsException("404", "장르를 선택하세요.");
			}
			for (MvGnrVO gnr: gnrList) {
				mvGnrDAO.createNewMvGnr(gnr);
			}
			// 영화참여인 등록 반복
			List<PrdcPrtcptnPplVO> pplList = mvVO.getPplList();
			if (pplList == null || pplList.isEmpty()) {
				throw new ApiArgsException("404", "영화 참여인을 선택하세요.");
			}
			for (PrdcPrtcptnPplVO ppl: pplList) {
				prdcPrtcptnPplDAO.createNewPrdcPrtcptnPpl(ppl);
			}
		}
		
		return mvCreateCount > 0;
	}

	@Override
	public boolean updateOneMv(MvVO mvVO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteOneMvByMvId(String mvId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteMvByMvIdList(List<String> mvIdList) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public MvVO readOneMvByMvId(String mvId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MvVO> readAllMv(MvVO mvVO) {
		// TODO Auto-generated method stub
		return null;
	}

}

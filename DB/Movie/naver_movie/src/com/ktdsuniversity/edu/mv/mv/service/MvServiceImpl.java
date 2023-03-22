package com.ktdsuniversity.edu.mv.mv.service;

import java.util.List;

import com.ktdsuniversity.edu.mv.mv.dao.MvDAO;
import com.ktdsuniversity.edu.mv.mv.dao.MvDAOImpl;
import com.ktdsuniversity.edu.mv.mv.dao.MvGnrDAO;
import com.ktdsuniversity.edu.mv.mv.dao.MvGnrDAOImpl;
import com.ktdsuniversity.edu.mv.mv.dao.PrdcPlcDAO;
import com.ktdsuniversity.edu.mv.mv.dao.PrdcPlcDAOImpl;
import com.ktdsuniversity.edu.mv.mv.dao.PrdcPrtcptnCmpnDAO;
import com.ktdsuniversity.edu.mv.mv.dao.PrdcPrtcptnCmpnDAOImpl;
import com.ktdsuniversity.edu.mv.mv.dao.PrdcPrtcptnPplDAO;
import com.ktdsuniversity.edu.mv.mv.dao.PrdcPrtcptnPplDAOImpl;
import com.ktdsuniversity.edu.mv.mv.vo.MvVO;

public class MvServiceImpl implements MvService {
	
	private MvDAO mvDAO;
	private MvGnrDAO mvGnrDAO;
	private PrdcPlcDAO prdcPlcDAO;
	private PrdcPrtcptnCmpnDAO prdcPrtcptnCmpnDAO;
	private PrdcPrtcptnPplDAO prdcPrtcptnPplDAO;
	
	public MvServiceImpl() {
		mvDAO = new MvDAOImpl();
		mvGnrDAO = new MvGnrDAOImpl();
		prdcPlcDAO = new PrdcPlcDAOImpl();
		prdcPrtcptnCmpnDAO = new PrdcPrtcptnCmpnDAOImpl();
		prdcPrtcptnPplDAO = new PrdcPrtcptnPplDAOImpl();
	}

	@Override
	public boolean createMv(MvVO mvVO) {
		// 1. 영화의 새로운 ID를 발급받는다
		String newMvId = mvDAO.createNewMvId();
		
		// 2. 발급받은 ID를 mvID에 할당한다
		mvVO.setMvId(newMvId);
		
		// 3. 영화를 등록한다
		// insertCount (등록 여부 확인)
		int insertCount = mvDAO.createMv(mvVO);
		
		// 4. 영화_장르를 등록한다
		// 3번이 등록에 실패했다면 진행하지 않음
		if (insertCount == 1) {
			insertCount += mvGnrDAO.createMvGnr(mvVO);
		}
		
		// 5. 제작지를 등록한다
		if (insertCount > 1) {
			insertCount += prdcPlcDAO.createPrdcPlc(mvVO);
		}
		
		// 6. 제작참여회사를 등록한다
		if (insertCount > 2) {
			insertCount += prdcPrtcptnCmpnDAO.createPrdcPrtcptnCmpn(mvVO);
		}
		
		// 7. 제작참여인을 등록한다
		if (insertCount > 3) {
			insertCount += prdcPrtcptnPplDAO.createPrdcPrtcptnPpl(mvVO);
		}
		
		return insertCount > 0;
	}
	
	
	@Override
	public List<MvVO> readAllMovie() {
		return mvDAO.readAllMovie();
	}
	
	@Override
	public MvVO readOneMv(String mvId) {
		return mvDAO.readOneMv(mvId);
	}
	
	@Override
	public boolean updateMv(MvVO mvVO) {
		// 1. 영화 수정
		int updateCount = mvDAO.updateMv(mvVO);
		
		// 2. 영화_장르 데이터 삭제
		updateCount += mvGnrDAO.deleteMvGnr(mvVO.getMvId());

		// 3. 영화_장르 데이터 추가
		updateCount += mvGnrDAO.createMvGnr(mvVO);
		
		// 4. 제작지 데이터 삭제
		updateCount += prdcPlcDAO.deletePrdcPlc(mvVO.getMvId());
		
		// 5. 제작지 데이터 추가
		updateCount += prdcPlcDAO.createPrdcPlc(mvVO);
		
		// 6. 제작참여회사 데이터 삭제
		updateCount += prdcPrtcptnCmpnDAO.deletePrdcPrtcptnCmpn(mvVO.getMvId());
		
		// 7. 제작참여회사 데이터 추가
		updateCount += prdcPrtcptnCmpnDAO.createPrdcPrtcptnCmpn(mvVO);
		
		// 8. 제작참여인 데이터 삭제
		updateCount += prdcPrtcptnPplDAO.deletePrdcPrtcptnPpl(mvVO.getMvId());
		
		// 9. 제작참여인 데이터 추가
		updateCount += prdcPrtcptnPplDAO.createPrdcPrtcptnPpl(mvVO);
		
		return updateCount > 0;
	}

	@Override
	public boolean deleteMv(String mvId) {
		// 1. 영화 데이터 삭제
		int deleteCount = mvDAO.deleteMv(mvId);
		
		// 2. 장르 데이터 삭제
		deleteCount += mvGnrDAO.deleteMvGnr(mvId);
		
		// 3. 제작지 데이터 삭제
		deleteCount += prdcPlcDAO.deletePrdcPlc(mvId);
		
		// 4 제작참여회사 데이터 삭제
		deleteCount += prdcPrtcptnCmpnDAO.deletePrdcPrtcptnCmpn(mvId);
		
		// 5. 제작참여인 데이터 삭제
		deleteCount += prdcPrtcptnPplDAO.deletePrdcPrtcptnPpl(mvId);
		
		return deleteCount > 0;
	}

}

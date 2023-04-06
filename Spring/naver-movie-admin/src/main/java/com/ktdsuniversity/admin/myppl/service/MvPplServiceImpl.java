package com.ktdsuniversity.admin.myppl.service;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ktdsuniversity.admin.common.api.exceptions.ApiException;
import com.ktdsuniversity.admin.myppl.dao.MvPplDAO;
import com.ktdsuniversity.admin.myppl.vo.MvPplVO;

@Service
public class MvPplServiceImpl implements MvPplService {
	
	private static final Logger logger = LoggerFactory.getLogger(MvPplServiceImpl.class);
	
	@Value("${upload.profile.path=:/naver-movie-admin/files/profiles}")
	private String profilePath;
	
	@Autowired
	private MvPplDAO mvPplDAO;
	
	@Override
	public List<MvPplVO> readAllMvPpl(MvPplVO mvPplVO) {
		// Calendar
		// startDt가 비어있을 경우, 현재일의 한 달 전 날짜를 가져와서 세팅한다
		if (mvPplVO.getStartDt() == null || mvPplVO.getStartDt().length() == 0) {
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.MONTH, -1); // 한 달 전
			// 연도
			int year = cal.get(Calendar.YEAR);
			// 월
			int month = cal.get(Calendar.MONTH) + 1;
			// 일
			int day = cal.get(Calendar.DAY_OF_MONTH);
			
			// 2023-4-4 -> 2023-04-04 (쿼리 포맷 맞추기)
			String strMonth = month < 10 ? "0" + month : month + "";
			String strDay = day < 10 ? "0" + day : day + "";
			
			String strDt = year + "-" + strMonth + "-" + strDay;
			mvPplVO.setStartDt(strDt);
		}
		// endDt가 비어있을 경우, 현재일을 가져와서 생성한다
		if (mvPplVO.getEndDt() == null || mvPplVO.getEndDt().length() == 0) {
			Calendar cal = Calendar.getInstance();
			// 연도
			int year = cal.get(Calendar.YEAR);
			// 월
			int month = cal.get(Calendar.MONTH) + 1;
			// 일
			int day = cal.get(Calendar.DAY_OF_MONTH);
			
			// 2023-4-4 -> 2023-04-04 (쿼리 포맷 맞추기)
			String endMonth = month < 10 ? "0" + month : month + "";
			String endDay = day < 10 ? "0" + day : day + "";
			
			String endDt = year + "-" + endMonth + "-" + endDay;
			mvPplVO.setEndDt(endDt);
		}
		return mvPplDAO.readAllMvPpl(mvPplVO);
	}

	@Override
	public boolean createOneMvPpl(MvPplVO mvPplVO, MultipartFile uploadFile) {
		if (uploadFile != null && !uploadFile.isEmpty()) {
			File dir = new File(profilePath);
			if (!dir.exists()) {
				dir.mkdirs();
			}
			String uuidFileName = UUID.randomUUID().toString();
			File profileFile = new File(dir, uuidFileName);
			
			try {
				uploadFile.transferTo(profileFile);
			} catch (IllegalStateException | IOException e) {
				logger.error(e.getMessage(), e);
			}
			
			mvPplVO.setPrflPht(uuidFileName);
		}
		return mvPplDAO.createOneMvPpl(mvPplVO) > 0;
	}

	@Override
	public boolean updateOneMvPpl(MvPplVO mvPplVO, MultipartFile uploadFile) {
		if (uploadFile != null && !uploadFile.isEmpty()) {
			File dir = new File(profilePath);
			if (!dir.exists()) {
				dir.mkdirs();
			}
			String uuidFileName = UUID.randomUUID().toString();
			File profileFile = new File(dir, uuidFileName);
			
			try {
				uploadFile.transferTo(profileFile);
			} catch (IllegalStateException | IOException e) {
				logger.error(e.getMessage(), e);
			}
			
			mvPplVO.setPrflPht(uuidFileName);
		}
		
		boolean isModify = false;
		MvPplVO originalMvPplData = mvPplDAO.readOneMvPplVOByMvPplId(mvPplVO.getMvPplId());
		
		MvPplVO updateMvPplVO = new MvPplVO();
		updateMvPplVO.setMdfyr(mvPplVO.getMdfyr());
		updateMvPplVO.setMvPplId(mvPplVO.getMvPplId());
		updateMvPplVO.setRlNm(mvPplVO.getRlNm());
		
		if ((mvPplVO.getPrflPht() == null || mvPplVO.getPrflPht().length() == 0) && mvPplVO.getIsDeletePctr().equals("N")) {
			updateMvPplVO.setPrflPht(originalMvPplData.getPrflPht());
		}
		else {
			isModify = true;
			updateMvPplVO.setPrflPht(mvPplVO.getPrflPht());
		}
		
		if (!originalMvPplData.getNm().equals(mvPplVO.getNm())) {
			isModify = true;
			updateMvPplVO.setNm(mvPplVO.getNm());
		}
		
		String rlNm = originalMvPplData.getRlNm();
		if (rlNm == null) {
			rlNm = "";
		}
		if (!rlNm.equals(mvPplVO.getRlNm())) {
			isModify = true;
		}
		
		String requestUseYn = mvPplVO.getUseYn() == null || mvPplVO.getUseYn().length() == 0 ? "N" : mvPplVO.getUseYn();
		
		if(!originalMvPplData.getUseYn().equals(requestUseYn)) {
			isModify = true;
			updateMvPplVO.setUseYn(mvPplVO.getUseYn());
		}
		
		if (isModify) {
			return mvPplDAO.updateOneMvPpl(updateMvPplVO) > 0;			
		}
		else {
			throw new ApiException("400", "변경된 정보가 없습니다.");
		}
	}

	@Override
	public boolean deleteOneMvPplByMvPplId(String MvPplId) {
		return mvPplDAO.deleteOneMvPplByMvPplId(MvPplId) > 0;
	}

	@Override
	public boolean deleteMvPplBySelectedMvPplId(List<String> mvPplIdList) {
		int delCount = mvPplDAO.deleteMvPplBySelectedMvPplId(mvPplIdList);
		boolean isSuccess = mvPplDAO.deleteMvPplBySelectedMvPplId(mvPplIdList) == mvPplIdList.size();
		if (!isSuccess) {
			throw new ApiException("500", "삭제 실패. 요청건수: " + mvPplIdList.size() + "건, 삭제건수: " + delCount + "건");
		}
		return isSuccess;
	}

}

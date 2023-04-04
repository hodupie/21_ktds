package com.ktdsuniversity.admin.myppl.service;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktdsuniversity.admin.common.api.exceptions.ApiException;
import com.ktdsuniversity.admin.myppl.dao.MvPplDAO;
import com.ktdsuniversity.admin.myppl.vo.MvPplVO;

@Service
public class MvPplServiceImpl implements MvPplService {
	
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
	public boolean createOneMvPpl(MvPplVO mvPplVO) {
		return mvPplDAO.createOneMvPpl(mvPplVO) > 0;
	}

	@Override
	public boolean updateOneMvPpl(MvPplVO mvPplVO) {
		return mvPplDAO.updateOneMvPpl(mvPplVO) > 0;
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

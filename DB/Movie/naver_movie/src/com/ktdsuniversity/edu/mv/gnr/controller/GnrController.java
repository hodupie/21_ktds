package com.ktdsuniversity.edu.mv.gnr.controller;

import com.ktdsuniversity.edu.mv.gnr.service.GnrService;
import com.ktdsuniversity.edu.mv.gnr.vo.GnrVO;

public interface GnrController {
	
	default public void createGnr(GnrService gnrService, String gnrNm) {
		GnrVO gnrVO = new GnrVO();
		gnrVO.setGnrNm(gnrNm);
		gnrService.createGnr(gnrVO);
	}
	default public void readAllGnr(GnrService gnrService) {
		gnrService.readAllGnr();
	}
	default public void updateGnr(GnrService gnrService, int gnrId, String gnrNm) {
		GnrVO gnrVO = new GnrVO();
		gnrVO.setGnrId(gnrId);
		gnrVO.setGnrNm(gnrNm);
		gnrService.updateGnr(gnrVO);
	}
	default public void deleteGnr(GnrService gnrService, int gnrId) {
		gnrService.deleteGnr(gnrId);
	}


}

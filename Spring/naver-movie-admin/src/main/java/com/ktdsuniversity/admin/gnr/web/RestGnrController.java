package com.ktdsuniversity.admin.gnr.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.ktdsuniversity.admin.common.api.exceptions.ApiArgsException;
import com.ktdsuniversity.admin.common.api.vo.ApiResponseVO;
import com.ktdsuniversity.admin.common.api.vo.ApiStatus;
import com.ktdsuniversity.admin.gnr.service.GnrService;
import com.ktdsuniversity.admin.gnr.vo.GnrVO;
import com.ktdsuniversity.admin.mbr.vo.MbrVO;

@RestController
public class RestGnrController {
	
	@Autowired
	private GnrService gnrService;
	
	@PostMapping("/api/gnr/create")
	public ApiResponseVO doCreateGnr(GnrVO gnrVO,
			@SessionAttribute("__ADMIN__") MbrVO mbrVO) {
		gnrVO.setCrtr(mbrVO.getMbrId());
		gnrVO.setMdfyr(mbrVO.getMbrId());

		String gnrNm = gnrVO.getGnrNm();
		
		if (gnrNm == null || gnrNm.trim().length() == 0) {
			throw new ApiArgsException("400", "장르명 누락");
		}
		
		boolean createResult = gnrService.createOneGnr(gnrVO);
		
		if (createResult) {
			return new ApiResponseVO(ApiStatus.OK);
		}
		else {
			return new ApiResponseVO(ApiStatus.FAIL,"장르를 등록할 수 없습니다.", "500", "");
		}
	}
	
	@PostMapping("api/gnr/update")
	public ApiResponseVO doUpdateGnr(GnrVO gnrVO,
			@SessionAttribute("__ADMIN__") MbrVO mbrVO) {
		gnrVO.setMdfyr(mbrVO.getMbrId());
		
		String gnrNm = gnrVO.getGnrNm();
		
		if (gnrNm == null || gnrNm.trim().length() == 0) {
			throw new ApiArgsException("400", "장르명 누락");
		}
		
		boolean updateResult = gnrService.updateOneGnr(gnrVO);
		
		if (updateResult) {
			return new ApiResponseVO(ApiStatus.OK);
		}
		else {
			return new ApiResponseVO(ApiStatus.FAIL, "장르 수정 실패");
		}
	}
	
	@GetMapping("api/gnr/delete/{gnrId}")
	public ApiResponseVO doDeleteGnr(@PathVariable int gnrId) {
		boolean deleteResult = gnrService.deleteOneGnrByGnrId(gnrId);
		
		if (deleteResult) {
			return new ApiResponseVO(ApiStatus.OK);
		}
		else {
			return new ApiResponseVO(ApiStatus.FAIL, "장르 삭제 실패");
		}
	}
	
	@PostMapping("api/gnr/delete")
	public ApiResponseVO deDeleteGnrBySelectedGnrId(@RequestParam List <Integer> gnrId) {
		boolean deleteResult = gnrService.deleteGnrBySelectedGnrId(gnrId);
		
		if (deleteResult) {
			return new ApiResponseVO(ApiStatus.OK);
		}
		else {
			return new ApiResponseVO(ApiStatus.FAIL, "장르 삭제 실패");
		}
	}
}
	

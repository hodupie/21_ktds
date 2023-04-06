package com.ktdsuniversity.admin.myppl.web;


import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;

import com.ktdsuniversity.admin.common.api.vo.ApiResponseVO;
import com.ktdsuniversity.admin.common.api.vo.ApiStatus;
import com.ktdsuniversity.admin.mbr.vo.MbrVO;
import com.ktdsuniversity.admin.myppl.service.MvPplService;
import com.ktdsuniversity.admin.myppl.vo.MvPplVO;

@RestController
public class RestMvPplController {
	
	private static final Logger logger = LoggerFactory.getLogger(RestMvPplController.class);
	
	@Autowired
	private MvPplService mvPplService;
	
	@Value("${upload.profile.path=:/naver-movie-admin/files/profiles}")
	private String profilePath;
	
	@PostMapping("api/mvppl/create")
	public ApiResponseVO doCreateMvPpl(MvPplVO mvPplVO, MultipartFile uploadFile, @SessionAttribute("__ADMIN__") MbrVO mbrVO) {
		
		mvPplVO.setCrtr(mbrVO.getMbrId());
		mvPplVO.setMdfyr(mbrVO.getMbrId());
		
		boolean isSuccess = mvPplService.createOneMvPpl(mvPplVO, uploadFile);
		if (isSuccess) {
			return new ApiResponseVO(ApiStatus.OK);
		}
		else {
			return new ApiResponseVO(ApiStatus.FAIL);
		}
	}
	
	@PostMapping("api/mvppl/update")
	public ApiResponseVO doUpdateMvPpl(MvPplVO mvPplVO, MultipartFile uploadFile, @SessionAttribute("__ADMIN__") MbrVO mbrVO) {
		
		mvPplVO.setMdfyr(mbrVO.getMbrId());
		
		boolean isSuccess = mvPplService.updateOneMvPpl(mvPplVO, uploadFile);
		if (isSuccess) {
			return new ApiResponseVO(ApiStatus.OK);
		}
		else {
			return new ApiResponseVO(ApiStatus.FAIL);
		}
	}
}

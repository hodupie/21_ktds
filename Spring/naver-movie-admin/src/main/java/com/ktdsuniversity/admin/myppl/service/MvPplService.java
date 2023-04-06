package com.ktdsuniversity.admin.myppl.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ktdsuniversity.admin.myppl.vo.MvPplVO;

public interface MvPplService {
	
	public List<MvPplVO> readAllMvPpl(MvPplVO mvPplVO);
	public boolean createOneMvPpl(MvPplVO mvPplVO, MultipartFile uploadFile);
	public boolean updateOneMvPpl(MvPplVO mvPplVO, MultipartFile uploadFile);
	public boolean deleteOneMvPplByMvPplId(String MvPplId);
	public boolean deleteMvPplBySelectedMvPplId(List<String> mvPplIdList);

}

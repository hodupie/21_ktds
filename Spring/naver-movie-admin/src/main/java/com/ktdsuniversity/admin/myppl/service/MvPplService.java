package com.ktdsuniversity.admin.myppl.service;

import java.util.List;

import com.ktdsuniversity.admin.myppl.vo.MvPplVO;

public interface MvPplService {
	
	public List<MvPplVO> readAllMvPpl(MvPplVO mvPplVO);
	public boolean createOneMvPpl(MvPplVO mvPplVO);
	public boolean updateOneMvPpl(MvPplVO mvPplVO);
	public boolean deleteOneMvPplByMvPplId(String MvPplId);
	public boolean deleteMvPplBySelectedMvPplId(List<String> mvPplIdList);

}

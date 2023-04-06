package com.ktdsuniversity.admin.myppl.dao;

import java.util.List;

import com.ktdsuniversity.admin.myppl.vo.MvPplVO;

public interface MvPplDAO {
	
	public List<MvPplVO> readAllMvPpl(MvPplVO mvPplVO);
	public MvPplVO readOneMvPplVOByMvPplId(String mvPplId);
	public int createOneMvPpl(MvPplVO mvPplVO);
	public int updateOneMvPpl(MvPplVO mvPplVO);
	public int deleteOneMvPplByMvPplId(String MvPplId);
	public int deleteMvPplBySelectedMvPplId(List<String> mvPplIdList);

}

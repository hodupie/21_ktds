package com.ktdsuniversity.admin.myppl.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ktdsuniversity.admin.myppl.vo.MvPplVO;

@Repository
public class MvPplDAOImpl extends SqlSessionDaoSupport implements MvPplDAO {
	
	@Override
	@Autowired
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}

	@Override
	public List<MvPplVO> readAllMvPpl(MvPplVO mvPplVO) {
		return getSqlSession().selectList("MvPpl.readAllMvPpl", mvPplVO);
	}

	@Override
	public int createOneMvPpl(MvPplVO mvPplVO) {
		return getSqlSession().insert("MvPpl.createOneMvPpl", mvPplVO);
	}

	@Override
	public int updateOneMvPpl(MvPplVO mvPplVO) {
		return getSqlSession().update("MvPpl.updateOneMvPpl", mvPplVO);
	}

	@Override
	public int deleteOneMvPplByMvPplId(String MvPplId) {
		return getSqlSession().update("MvPpl.deleteOneMvPplByMvPplId", MvPplId);
	}

	@Override
	public int deleteMvPplBySelectedMvPplId(List<String> mvPplIdList) {
		return getSqlSession().update("MvPpl.deleteMvPplBySelectedMvPplId", mvPplIdList);
	}

}

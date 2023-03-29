package com.ktdsuniversity.admin.mbr.dao;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ktdsuniversity.admin.mbr.vo.MbrVO;

@Repository
public class MbrDAOImpl extends SqlSessionDaoSupport implements MbrDAO {
	
	@Autowired
	@Override
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	@Override
	public MbrVO readOneMbrByIdAndPwd(MbrVO mbrVO) {
		return getSqlSession().selectOne("Mbr.readOneMbrByIdAndPwd", mbrVO);
	}

}

package com.hello.attachfile.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hello.attachfile.vo.AttachFileVO;

@Repository
public class AttachFileDAOImpl extends SqlSessionDaoSupport implements AttachFileDAO {
	
	@Autowired
	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}
	
	@Override
	public int createAttachFile(AttachFileVO attacheFileVO) {
		return getSqlSessionTemplate().insert("Attach.createAttachFile", attacheFileVO);
	}

	@Override
	public AttachFileVO readOneAttachFileByTopicIdAndFileId(AttachFileVO attachFileVO) {
		return getSqlSessionTemplate().selectOne("Attach.readOneAttachFileByTopicIdAndFileId", attachFileVO);
	}

	@Override
	public String readOneAttachFileUUIDByFileId(long fileId) {
		// Service에서 물리적 경로의 파일을 삭제하기 위해 파일의 UUID명 조회
		return getSqlSessionTemplate().selectOne("Attach.readOneAttachFileUUIDByFileId", fileId);
	}

	@Override
	public int deleteOneAttachFileByFileId(long fileId) {
		// DB에서만 삭제
		return getSqlSession().delete("Attach.readOneAttachFileByTopicIdAndFileId", fileId);
	}

}

package com.hello.attachfile.service;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.hello.attachfile.dao.AttachFileDAO;
import com.hello.attachfile.vo.AttachFileVO;

@Service
public class AttachFileServiceImpl implements AttachFileService {
	
	@Autowired
	private AttachFileDAO attachFileDAO;
	
	@Value("${upload.path:/spring-app/upload-files}")
	private String uploadPath;

	@Override
	public boolean createAttachFile(AttachFileVO attacheFileVO) {
		return attachFileDAO.createAttachFile(attacheFileVO) > 0;
	}

	@Override
	public AttachFileVO readOneAttachFileByTopicIdAndFileId(AttachFileVO attachFileVO) {
		return attachFileDAO.readOneAttachFileByTopicIdAndFileId(attachFileVO);
	}

	@Override
	public boolean deleteOneAttachFileByFileId(long fileId) {
		// 실제 물리적 경로의 파일 삭제 필요
		// 1. 업로드 파일이 있는 위치 필요 : @Value("${upload.path}")
		// 2. 업로드 파일의 이름 필요 : fileId로 파일의 UUID명 조회
		String uuidFileName = attachFileDAO.readOneAttachFileUUIDByFileId(fileId);
		
		// 파일 삭제
		// 1. 물리 파일 객체 가져오기
		File file = new File(uploadPath, uuidFileName);
		if (file.exists()) {
			file.delete();
		}
		return attachFileDAO.deleteOneAttachFileByFileId(fileId) > 0;
	}

}

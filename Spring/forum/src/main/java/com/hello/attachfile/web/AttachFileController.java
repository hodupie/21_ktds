package com.hello.attachfile.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.hello.attachfile.service.AttachFileService;
import com.hello.attachfile.vo.AttachFileVO;
import com.hello.common.handler.DownloadUtil;

@Controller
public class AttachFileController {

	@Value("${upload.path}")
	private String uploadPath;
	
	@Autowired
	private AttachFileService attachFileService;
	
	@GetMapping("/file/download/{topicId}/{fileId}")
	public void downloadFile(@PathVariable int topicId, @PathVariable long fileId, HttpServletRequest request, HttpServletResponse response) {
		
		AttachFileVO fileVO = new AttachFileVO();
		fileVO.setFileId(fileId);
		fileVO.setTopicId(topicId);
		AttachFileVO attachFile = attachFileService.readOneAttachFileByTopicIdAndFileId(fileVO);
		
		new DownloadUtil(response, request, this.uploadPath + "/" + attachFile.getUuidFileName()).download(attachFile.getOriginFileName());
		
	}
}

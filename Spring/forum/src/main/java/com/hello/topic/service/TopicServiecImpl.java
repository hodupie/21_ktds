package com.hello.topic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.hello.common.handler.UploadHandler;
import com.hello.topic.dao.TopicDAO;
import com.hello.topic.vo.TopicVO;

@Service
public class TopicServiecImpl implements TopicService {
	
	@Autowired
	private TopicDAO topicDAO;
	
	@Autowired
	private UploadHandler uploadHandler;
	
	@Override
	public List<TopicVO> readAllTopics() {
		return topicDAO.readAllTopics();
	}

	@Override
	public TopicVO readOneTopicByTopicID(int id) {
		TopicVO topicVO = topicDAO.readOneTopicByTopicID(id);
		
		if (topicVO == null) {
			throw new RuntimeException("잘못된 접근입니다!");
		}
		return topicVO;
	}

	@Override
	public boolean createNewTopic(TopicVO topicVO, List<MultipartFile> uploadFile) {
		boolean createResult = topicDAO.createNewTopic(topicVO) > 0;
		uploadHandler.upload(uploadFile, topicVO.getId());
		return createResult;
	}

	@Override
	public boolean updateOneTopic(TopicVO topicVO) {
		return topicDAO.updateOneTopic(topicVO) > 0;
	}

	@Override
	public boolean deleteOneTopicByID(int id) {
		return topicDAO.deleteOneTopicByID(id) > 0;
	}

}

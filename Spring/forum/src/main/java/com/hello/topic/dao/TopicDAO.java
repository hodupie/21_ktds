package com.hello.topic.dao;

import java.util.List;

import com.hello.topic.vo.TopicVO;

public interface TopicDAO {
	
	/**
	 * Topic의 정보 + 작성자 정보 read
	 */
	public List<TopicVO> readAllTopics();
	
	public TopicVO readOneTopicByTopicID(int id);
	
	public int createNewTopic(TopicVO topicVO);

	public int updateOneTopic(TopicVO topicVO);
	
	public int deleteOneTopicByID(int id);

}

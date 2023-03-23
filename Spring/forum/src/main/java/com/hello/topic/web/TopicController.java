package com.hello.topic.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.hello.topic.service.TopicService;
import com.hello.topic.vo.TopicVO;

@Controller
public class TopicController {
	
	@Autowired
	private TopicService topicService;
	
	@GetMapping("/topics")
	public String viewTopicListPage(Model model) {
		List<TopicVO> topicList = topicService.readAllTopics();
		model.addAttribute("topicList", topicList);
		return "topic/list";
	}
	
	@GetMapping("/topic/{topicId}")
	public String viewTopicDetailPage(@PathVariable int topicId, Model model) {
		System.out.println("URL 변수 topicId의 값: " + topicId);
		
		TopicVO topic = topicService.readOneTopicByTopicID(topicId);
		model.addAttribute("topic", topic);
		return "topic/detail";
	}
	
	@GetMapping("/topic/write")
	public String viewTopicWritePage() {
		return "topic/write";
	}
	
	@PostMapping("/topic/write")
	public String doTopicWrite(TopicVO topicVO) {
		boolean createResult = topicService.createNewTopic(topicVO);
		if (!createResult) {
			return "/topic/write";
		}
		return "redirect:/topic/" + topicVO.getId();
	}
	
	@GetMapping("/topic/delete/{topicId}")
	public String doTopicDelete(@PathVariable int topicId) {
		boolean deleteResult = topicService.deleteOneTopicByID(topicId);
		if (deleteResult) {
			return "redirect:/topics";
		}
		else {
			return "redirect:/topic/" + topicId;
		}
	}
	
	@GetMapping("/topic/update/{topicId}")
	public String viewTopicUpdatePage(@PathVariable int topicId, Model model) {
		TopicVO topic = topicService.readOneTopicByTopicID(topicId);
		model.addAttribute("topic", topic);
		return "topic/update";
	}
	
	@PostMapping("/topic/update/{topicId}")
	public String doTopicUpdate(@PathVariable int topicId, TopicVO topicVO) {
		topicVO.setId(topicId);
		boolean updateResult = topicService.updateOneTopic(topicVO);
		
		if (updateResult) {
			return "redirect:/topic/" + topicId;
		}
		else {
			return "redirect:/topic/detail";
		}
	}
	
}

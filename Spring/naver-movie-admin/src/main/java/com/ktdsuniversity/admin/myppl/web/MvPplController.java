package com.ktdsuniversity.admin.myppl.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ktdsuniversity.admin.myppl.service.MvPplService;
import com.ktdsuniversity.admin.myppl.vo.MvPplVO;

@Controller
public class MvPplController {
	
	@Autowired
	private MvPplService mvPplService;
	
	@GetMapping("/mvppl/list")
	public String viewMvPplListPage(MvPplVO mvPplVO, Model model) {
		List<MvPplVO> mvPplList = mvPplService.readAllMvPpl(mvPplVO);
		model.addAttribute("mvPplList", mvPplList);
		model.addAttribute("mvPplVO", mvPplVO);
		
		return "mvppl/list";
	}
}

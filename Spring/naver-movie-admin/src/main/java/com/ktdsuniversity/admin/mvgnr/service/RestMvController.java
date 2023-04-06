package com.ktdsuniversity.admin.mvgnr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.ktdsuniversity.admin.mv.service.MvService;

@RestController
public class RestMvController {
	
	@Autowired
	private MvService mvService;
}

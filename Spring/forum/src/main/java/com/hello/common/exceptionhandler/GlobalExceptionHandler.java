package com.hello.common.exceptionhandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice({"com.hello", "org.springframework"})
public class GlobalExceptionHandler {
	
	private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	@org.springframework.web.bind.annotation.ExceptionHandler(RuntimeException.class)
	public String handleRuntimeException(RuntimeException re, Model model) {
		logger.info("예외가 발생했습니다!! {}", re.getMessage());
		model.addAttribute("messgae", re.getMessage());
		return "errors/500";
	}
}

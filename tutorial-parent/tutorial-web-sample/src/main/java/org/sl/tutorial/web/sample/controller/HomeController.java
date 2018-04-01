package org.sl.tutorial.web.sample.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("home")
public class HomeController {

	
	@RequestMapping
	public String home(){
		logger.info("enter home.");
		return "home/home";
	}
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
}

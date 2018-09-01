package org.sl.food.web.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("home")
public class HomeController {

	@RequestMapping
	public String home(){
		
		return "home/home";
	}
}

package com.jhj.cinema.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@RequestMapping (value = "/")
	public String index() {
		return "index";
	}
	
	@RequestMapping (value = "/index")
	public String indexOk() {
		return "index";
	}
	
	@RequestMapping (value = "/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping (value = "/join")
	public String join() {
		return "join";
	}
	
}

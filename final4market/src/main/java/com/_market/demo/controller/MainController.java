package com._market.demo.controller;

import org.springframework.stereotype.Controller;

@Controller
public class MainController {

	public String main() {
		return "index";
	}
	
	public String index() {
		return "main";
	}
}

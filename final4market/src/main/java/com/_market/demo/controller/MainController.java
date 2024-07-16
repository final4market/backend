package com._market.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import com._market.demo.service.ProductService;

@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MainController {
	private ProductService service;

	@Autowired
	public MainController(ProductService service) {
		this.service = service;
	}

	@GetMapping("/")
	public String MyStore() {
		return "my_store";
	}

}
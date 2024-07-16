package com._market.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com._market.demo.service.ProductService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MainController {
	private ProductService service;

	public MainController(ProductService service) {
		this.service = service;
	}

	@GetMapping("/mypage")
	public String MyStore() {
		return service.selectAllMypage();
	}

}
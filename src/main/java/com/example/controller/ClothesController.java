package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/clothes")
public class ClothesController {

	@RequestMapping("")
	public String index() {
		return "clothes";
	}
}

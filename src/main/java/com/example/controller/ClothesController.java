package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Clothes;
import com.example.form.ClothesForm;
import com.example.service.ClothesService;

@Controller
@RequestMapping("/clothes")
public class ClothesController {
	
	@Autowired
	private ClothesService service;
	
	@ModelAttribute
	public ClothesForm setClothesForm() {
		return new ClothesForm();
	}

	@RequestMapping("")
	public String index(Model model) {
		Clothes clothes = new Clothes();
		
		model.addAttribute("clothes", clothes);
		
		return "clothes";
	}
	
	@RequestMapping("/result")
	public String result(ClothesForm form, Model model) {
		List<Clothes> clothesList = new ArrayList<>();
		
		clothesList = service.receive(Integer.parseInt(form.getGender()), form.getColor());
		
		model.addAttribute("clothesList", clothesList);
		
		return "clothes";
	}
}

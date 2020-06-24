package com.example.controller;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Hotel;
import com.example.form.HotelForm;
import com.example.service.HotelService;

@Controller
@RequestMapping("/hotel")
public class HotelController {

	@Autowired
	private HotelService service;
	
	@ModelAttribute
	public HotelForm setHotel() {
		return new HotelForm();
	}
	
	@RequestMapping("")
	public String index() {
		return "hotel";
	}
	
	@RequestMapping("/result")
	public String result(HotelForm form, Model model) {
		List<Hotel> hotelList = new ArrayList<>();
		
		if(form.getPrice()==null) {
			hotelList = service.receiveAll();
		} else {
			hotelList = service.receive(form.getPrice());
		}
		model.addAttribute("hotelList", hotelList);
		
		return "hotel";
	}
}

package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Hotel;
import com.example.service.HotelService;

@Controller
@RequestMapping("/hotel")
public class HotelController {

	@Autowired
	private HotelService service;
	
	@ModelAttribute
	public Hotel setHotel() {
		return new Hotel();
	}
	
	@RequestMapping("")
	public String index() {
		return "hotel";
	}
	
	@RequestMapping("/result")
	public String result(Hotel hotel, Model model) {
		service.receive(hotel.getPrice());
		
		model.addAttribute("hotel", hotel);
		
		return "hotel";
	}
}

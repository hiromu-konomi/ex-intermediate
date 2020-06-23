package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.service.TeamService;

@Controller
@RequestMapping("/teams")
public class TeamController {

	@Autowired
	private TeamService service;
	
	@RequestMapping("/list")
	public String list() {
		return "team-list";
	}
}

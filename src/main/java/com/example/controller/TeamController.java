package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Team;
import com.example.service.TeamService;

@Controller
@RequestMapping("/team")
public class TeamController {

	@Autowired
	private TeamService service;

	@RequestMapping("/list")
	public String list(Model model) {
		List<Team> teamList = service.showList();
		model.addAttribute("teamList", teamList);

		return "team-list";
	}
}

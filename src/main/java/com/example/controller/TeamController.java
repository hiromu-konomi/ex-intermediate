package com.example.controller;

import java.util.ArrayList;
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
		List<Team> teamList = new ArrayList<>();
		teamList.addAll(service.showList());
		model.addAttribute("teamList", teamList);
		System.out.println("おはよう");
		return "team-list";
	}
}

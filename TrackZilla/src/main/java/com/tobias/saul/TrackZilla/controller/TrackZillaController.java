package com.tobias.saul.TrackZilla.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tobias.saul.TrackZilla.entity.Application;
import com.tobias.saul.TrackZilla.entity.Release;
import com.tobias.saul.TrackZilla.entity.Ticket;
import com.tobias.saul.TrackZilla.service.ApplicationService;
import com.tobias.saul.TrackZilla.service.ReleaseService;
import com.tobias.saul.TrackZilla.service.TicketService;

@Controller
public class TrackZillaController {
	
	@Autowired
	private ApplicationService appService;
	@Autowired
	private ReleaseService releaseService;
	@Autowired
	private TicketService ticketService;
	
	@GetMapping("/")
	public String toIndex(Model model) {
		return "index";
	}
	
	@RequestMapping("/applications")
	public String toRetrieveApplications(Model model) {
		List<Application> applications = appService.getAll();
		model.addAttribute("applications", applications);
		return "applications";
	}
	
	@RequestMapping("/releases")
	public String toRetrieveReleases(Model model) {
		List<Release> releases = releaseService.getAll();
		model.addAttribute("releases", releases);
		return "releases";
	}
	
	@RequestMapping("/tickets")
	public String toRetrieveTickets(Model model) {
		List<Ticket> tickets = ticketService.getAll();
		model.addAttribute("tickets", tickets);
		return "tickets";
	}

}

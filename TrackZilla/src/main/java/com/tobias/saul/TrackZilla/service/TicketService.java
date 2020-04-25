package com.tobias.saul.TrackZilla.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tobias.saul.TrackZilla.entity.Ticket;
import com.tobias.saul.TrackZilla.repository.TicketRepository;

@Service
public class TicketService {
	
	@Autowired
	private TicketRepository ticketRepo;

	public void add(Ticket ticket) {
		ticketRepo.save(ticket);
		
	}

	public Ticket get(Long ticketId) {
		Optional<Ticket> ticket = ticketRepo.findById(ticketId);
		if(ticket.isPresent()) {
			return ticket.get();
		}
		return null;
	}

	public void update(Ticket ticket) {
		if(ticketRepo.existsById(ticket.getTicketId())) {
			ticketRepo.save(ticket);
		} else {
			System.out.println("Ticket does not exist");
		}
		
	}

	public List<Ticket> getAll() {
		List<Ticket> tickets = (List<Ticket>) ticketRepo.findAll();
		return tickets;
	}

}

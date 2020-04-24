package com.tobias.saul.TrackZilla.repository;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.tobias.saul.TrackZilla.entity.Application;
import com.tobias.saul.TrackZilla.entity.Release;
import com.tobias.saul.TrackZilla.entity.Ticket;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TrackZillaRepositoryTests {
	
	@Autowired
	ApplicationContext context;
	@Autowired
	ApplicationRepository appRepo;
	@Autowired
	ReleaseRepository releaseRepo;
	@Autowired
	TicketRepository ticketRepo;
	
	@Before
	public void setUp() throws Exception {
		
	}
	
	@Test
	public void test_ApplicationRepositorySavesApplication() {
		Application app = context.getBean(Application.class);
		app.setName("App Demo");
		app.setDescription("App Description");
		app.setOwner("Saul Tobias");
		
		appRepo.save(app);
		
		assertEquals(appRepo.findById(app.getApplicationId()).get(), app);
	}
	
	@Test
	public void test_ReleaseRepositorySavesRelease() {
		Release release = context.getBean(Release.class);
		releaseRepo.save(release);
		
		assertEquals(releaseRepo.findById(release.getReleaseId()).get(), release);
	}
	
	@Test
	public void test_TicketRepositorySavesTicket() {
		Application app = context.getBean(Application.class);
		appRepo.save(app);
		Ticket ticket = context.getBean(Ticket.class);
		ticket.setApplication(appRepo.findById(app.getApplicationId()).get());
		ticketRepo.save(ticket);
		
		assertEquals(ticketRepo.findById(ticket.getTicketId()).get(), ticket);
		
	}

}

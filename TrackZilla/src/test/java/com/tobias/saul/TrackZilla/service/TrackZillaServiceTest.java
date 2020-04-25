package com.tobias.saul.TrackZilla.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
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
public class TrackZillaServiceTest {
	
	@Autowired
	ApplicationContext context;
	@Autowired
	ApplicationService appService;
	@Autowired
	ReleaseService releaseService;
	@Autowired
	TicketService ticketService;

	@Test
	public void test_ApplicationServiceAddApplicationToDb() {
		Application app = context.getBean(Application.class);
		appService.add(app);
		
		assertEquals(appService.get(app.getApplicationId()), app);
	}
	
	@Test
	public void test_ApplicationServiceUpdateApplication() {
		Application app = context.getBean(Application.class);
		app.setOwner("Sal Tobias");
		appService.add(app);
		app.setOwner("Saul Tobias");
		appService.update(app);
		
		assertEquals(appService.get(app.getApplicationId()), app);
		
	}
	
	@Test
	public void test_ApplicationServiceGetAllApplications() {
		Application app = context.getBean(Application.class);
		appService.add(app);
		app = context.getBean(Application.class);
		appService.add(app);
		app = context.getBean(Application.class);
		appService.add(app);
		
		List<Application> apps = appService.getAll();
		
		assertTrue(apps.contains(app));
	}
	
	@Test
	public void test_ApplicationServiceDeleteApplication() {
		Application app = context.getBean(Application.class);
		appService.add(app);
		appService.delete(app);
		
		assertNull(appService.get(app.getApplicationId()));
	}
	
	@Test 
	public void test_ReleaseServiceAddsRelease() {
		Release release = context.getBean(Release.class);
		releaseService.add(release);
		
		assertEquals(releaseService.get(release.getReleaseId()), release);
	}
	
	@Test
	public void test_ReleaseServiceUpdateRelease() {
		Release release = context.getBean(Release.class);
		release.setDescription("wrong desc");
		releaseService.add(release);
		release.setDescription("right desc");
		releaseService.update(release);
		
		assertEquals(releaseService.get(release.getReleaseId()), release);
		
	}
	
	@Test
	public void test_ReleaseServiceGetAllReleases() {
		Release release = context.getBean(Release.class);
		releaseService.add(release);
		release = context.getBean(Release.class);
		releaseService.add(release);
		release = context.getBean(Release.class);
		releaseService.add(release);
		
		List<Release> releases = releaseService.getAll();
		
		assertTrue(releases.contains(release));
	}
	
	@Test
	public void test_ReleaseServiceDeleteRelease() {
		Release release = context.getBean(Release.class);
		releaseService.add(release);
		releaseService.delete(release);
		
		assertNull(releaseService.get(release.getReleaseId()));
	}
	
	@Test
	public void test_TicketServiceAddTicketToDb() {
		Application app = context.getBean(Application.class);
		appService.add(app);
		Ticket ticket = context.getBean(Ticket.class);
		ticket.setApplication(app);
		ticketService.add(ticket);
		
		assertEquals(ticketService.get(ticket.getTicketId()), ticket);
	}
	
	@Test
	public void test_TicketServiceUpdateTicket() {
		Application app = context.getBean(Application.class);
		appService.add(app);
		Ticket ticket = context.getBean(Ticket.class);
		ticket.setApplication(app);
		ticket.setDescription("wrong description");
		ticketService.add(ticket);
		ticket.setDescription("right description");
		ticketService.update(ticket);
		
		assertEquals(ticketService.get(ticket.getTicketId()), ticket);
	}
	
	@Test
	public void test_TicketServiceGetAllAtickets() {
		Application app = context.getBean(Application.class);
		appService.add(app);
		Ticket ticket = context.getBean(Ticket.class);
		ticket.setApplication(app);
		ticketService.add(ticket);
		
		List<Ticket> tickets = ticketService.getAll();
		
		assertTrue(tickets.contains(ticket));
	}
}

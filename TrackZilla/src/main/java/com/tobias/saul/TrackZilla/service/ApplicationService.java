package com.tobias.saul.TrackZilla.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tobias.saul.TrackZilla.entity.Application;
import com.tobias.saul.TrackZilla.entity.Release;
import com.tobias.saul.TrackZilla.repository.ApplicationRepository;

@Service
public class ApplicationService {
	
	@Autowired
	private ApplicationRepository appRepo;

	public void add(Application app) {
		appRepo.save(app);
	}

	public Application get(Long applicationId) {
		Optional<Application> app = appRepo.findById(applicationId);
		if(app.isPresent()) {
			return app.get();
		}
		return null;
	}

	public void update(Application app) {
		if(appRepo.existsById(app.getApplicationId())) {
			appRepo.save(app);
		} else {
			System.out.println("Application does not exist");
		}
	}

	public List<Application> getAll() {
		List<Application> apps = (List<Application>) appRepo.findAll();
		return apps;
	}

	public void delete(Application app) {
		appRepo.delete(app);
	}

}

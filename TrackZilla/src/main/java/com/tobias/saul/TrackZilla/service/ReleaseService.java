package com.tobias.saul.TrackZilla.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tobias.saul.TrackZilla.entity.Release;
import com.tobias.saul.TrackZilla.repository.ReleaseRepository;

@Service
public class ReleaseService {
	
	@Autowired
	private ReleaseRepository releaseRepo;
	
	public void add(Release release) {
		releaseRepo.save(release);
		
	}

	public Release get(Long releaseId) {
		Optional<Release> release = releaseRepo.findById(releaseId);
		if(release.isPresent()) {
			return release.get();
		}
		return null;
	}

	public void update(Release release) {
		if(releaseRepo.existsById(release.getReleaseId())) {
			releaseRepo.save(release);
		} else {
			System.out.println("Release does not exist");
		}
	}

	public List<Release> getAll() {
		List<Release> releases = (List<Release>) releaseRepo.findAll();
		return releases;
	}

	public void delete(Release release) {
		releaseRepo.delete(release);
	}

}

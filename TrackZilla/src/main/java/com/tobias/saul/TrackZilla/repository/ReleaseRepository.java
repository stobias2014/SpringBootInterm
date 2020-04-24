package com.tobias.saul.TrackZilla.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tobias.saul.TrackZilla.entity.Release;

@Repository
public interface ReleaseRepository extends CrudRepository<Release, Long>{

}

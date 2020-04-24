package com.tobias.saul.TrackZilla.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tobias.saul.TrackZilla.entity.Application;

@Repository
public interface ApplicationRepository extends CrudRepository<Application, Long>{

}

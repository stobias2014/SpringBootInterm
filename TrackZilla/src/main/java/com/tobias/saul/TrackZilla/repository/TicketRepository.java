package com.tobias.saul.TrackZilla.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tobias.saul.TrackZilla.entity.Ticket;

@Repository
public interface TicketRepository extends CrudRepository<Ticket, Long>{

}

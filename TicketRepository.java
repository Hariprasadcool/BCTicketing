package com.hp.bc.tickets.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.hp.bc.tickets.model.Tickets;

public interface TicketRepository extends CrudRepository<Tickets, Long>{

	List<Tickets> findAllByDefectID(long defectID);	
}

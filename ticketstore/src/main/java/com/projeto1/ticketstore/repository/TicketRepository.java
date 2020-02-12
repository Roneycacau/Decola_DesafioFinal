package com.projeto1.ticketstore.repository;

import java.util.List;

import com.projeto1.ticketstore.domain.entities.Tickets;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Tickets, Integer>{

    List<Tickets> findByIdUser_id(Integer idUser);

    List<Tickets> findByIdSessionMovie_id(Integer idSession);
    

}


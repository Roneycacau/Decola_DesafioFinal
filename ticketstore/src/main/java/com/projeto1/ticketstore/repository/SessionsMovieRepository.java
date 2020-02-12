package com.projeto1.ticketstore.repository;

import com.projeto1.ticketstore.domain.entities.SessionsMovie;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionsMovieRepository extends JpaRepository<SessionsMovie, Integer> {

    List<SessionsMovie> findByIdMovie_id(Integer id);
}
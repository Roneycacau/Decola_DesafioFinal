package com.projeto1.ticketstore.repository;

import com.projeto1.ticketstore.domain.entities.Rooms;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomsRepository extends JpaRepository<Rooms, Integer> {

}
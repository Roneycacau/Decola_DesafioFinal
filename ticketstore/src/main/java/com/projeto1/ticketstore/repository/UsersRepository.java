package com.projeto1.ticketstore.repository;

import com.projeto1.ticketstore.domain.entities.Users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {
    
    Users findByEmail(String email);
}
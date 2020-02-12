package com.projeto1.ticketstore.service;

import java.util.List;
import java.util.Optional;

import com.projeto1.ticketstore.domain.entities.Users;
import com.projeto1.ticketstore.exception.DataNotFoundException;
import com.projeto1.ticketstore.repository.UsersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    private final UsersRepository usersRepository;

    @Autowired
    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public Users createUser(Users model) {
        return usersRepository.save(model);
    }

    public List<Users> listClient() {
        return usersRepository.findAll();
    }

    public Users findById(Integer id) {
        Optional<Users> user = usersRepository.findById(id);
        return user.orElseThrow(() -> new DataNotFoundException("Usuário não encontrado"));
    }

    public Users findByEmail(String email) {
        return usersRepository.findByEmail(email);
    }

    // public Users delete(Integer id) {

    // Optional<Users> user = usersRepository.findById(id);

    // usersRepository.deleteById(id);

    // return user.orElseThrow(() -> new DataNotFoundException("Usuário não
    // encontrado"));
    // }

    // public Users update(Integer id, Users model) {
    // Optional<Users> user = usersRepository.findById(id);

    // model.setId(id);

    // usersRepository.save(model);

    // return user.orElseThrow(() -> new DataNotFoundException("Usuário não
    // encontrado"));
    // }
}
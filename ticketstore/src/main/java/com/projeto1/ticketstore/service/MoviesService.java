package com.projeto1.ticketstore.service;

import java.util.List;
import java.util.Optional;

import com.projeto1.ticketstore.domain.entities.Movies;
import com.projeto1.ticketstore.exception.DataNotFoundException;
import com.projeto1.ticketstore.repository.MoviesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MoviesService {

    private final MoviesRepository moviesRepository;

    @Autowired
    public MoviesService(MoviesRepository moviesRepository) {
        this.moviesRepository = moviesRepository;
    }

    public List<Movies> listMovies() {
        return moviesRepository.findAll();
    }

    public Movies findById(Integer id) {
        Optional<Movies> status = moviesRepository.findById(id);
        return status.orElseThrow(() -> new DataNotFoundException("Filme não encontrado"));
    }

}
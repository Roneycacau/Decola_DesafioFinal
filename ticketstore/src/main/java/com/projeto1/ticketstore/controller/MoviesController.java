package com.projeto1.ticketstore.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.projeto1.ticketstore.domain.dto.response.MoviesResponse;
import com.projeto1.ticketstore.mapper.MoviesMapper;
import com.projeto1.ticketstore.service.MoviesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
@CrossOrigin(origins = "*")
public class MoviesController {

    private final MoviesService moviesService;
    private final MoviesMapper moviesMapper;

    @Autowired
    public MoviesController(MoviesMapper moviesMapper, MoviesService moviesService) {
        this.moviesMapper = moviesMapper;
        this.moviesService = moviesService;
    }

    @GetMapping
    public ResponseEntity<List<MoviesResponse>> list() {
        return ResponseEntity.ok(moviesService.listMovies().stream() //
                .map(x -> moviesMapper.toDto(x)) //
                .collect(Collectors.toList()));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<MoviesResponse> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(moviesMapper.toDto(moviesService.findById(id)));
    }

}
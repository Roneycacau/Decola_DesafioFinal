package com.projeto1.ticketstore.controller;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.projeto1.ticketstore.domain.dto.request.SessionsMovieRequest;
import com.projeto1.ticketstore.domain.dto.response.SessionsMovieModelResponse;
import com.projeto1.ticketstore.domain.dto.response.SessionsMovieResponse;
import com.projeto1.ticketstore.domain.entities.SessionsMovie;
import com.projeto1.ticketstore.mapper.SessionsMovieMapper;
import com.projeto1.ticketstore.service.SessionsMovieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sessionsmovie")
@CrossOrigin(origins = "*")
public class SessionsMovieController {

    private final SessionsMovieService service;
    private final SessionsMovieMapper mapper;

    @Autowired
    public SessionsMovieController(SessionsMovieMapper sessionsmovieMapper, SessionsMovieService sessionsMovieService) {
        this.mapper = sessionsmovieMapper;
        this.service = sessionsMovieService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<SessionsMovieModelResponse> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(mapper.toNewDto(service.findById(id)));
    }

    @GetMapping(value = "/listsessionsmovie/{id}")
    public ResponseEntity<List<SessionsMovieModelResponse>> listSessionsMovie(@PathVariable Integer id) {
        return ResponseEntity.ok(service.findByIdMovie_id(id).stream()
        .map(x -> mapper.toNewDto(x)).collect(Collectors.toList()));
    }

    @GetMapping
    public ResponseEntity<List<SessionsMovieModelResponse>> list() {
        return ResponseEntity.ok(service.listTickets().stream() //
                .map(x -> mapper.toNewDto(x)) //
                .collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity<SessionsMovieResponse> post(@Valid @RequestBody SessionsMovieRequest model) {

        SessionsMovie sessionsmovie = service.createSessionsMovie(mapper.fromDto(model));

        return ResponseEntity.ok(mapper.toDto(sessionsmovie));
    }

}
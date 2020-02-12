package com.projeto1.ticketstore.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.projeto1.ticketstore.domain.dto.request.TicketsRequest;
import com.projeto1.ticketstore.domain.dto.response.FrontTicketsResponse;
import com.projeto1.ticketstore.domain.dto.response.TicketsResponse;
import com.projeto1.ticketstore.domain.entities.Tickets;
import com.projeto1.ticketstore.mapper.TicketsMapper;
import com.projeto1.ticketstore.service.TicketsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/tickets")
@CrossOrigin(origins = "*")
public class TicketsController {

	private final TicketsService service;
	private final TicketsMapper mapper;

	@Autowired
	public TicketsController(TicketsMapper mapper, TicketsService service) {

		this.mapper = mapper;
		this.service = service;
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<FrontTicketsResponse> getById(@PathVariable Integer id) {
		return ResponseEntity.ok(mapper.toNewDto(service.findById(id)));
	}

	@GetMapping
	public ResponseEntity<List<FrontTicketsResponse>> list() {
		return ResponseEntity.ok(service.listTickets().stream() //
				.map(x -> mapper.toNewDto(x)) //
				.collect(Collectors.toList()));
	}

	@GetMapping(value = "/ticketsUser")
	public ResponseEntity<List<FrontTicketsResponse>> listTicketsUser(@RequestParam Integer userId) {
		return ResponseEntity.ok(service.findTicketsUser(userId).stream() //
				.map(x -> mapper.toNewDto(x)) //
				.collect(Collectors.toList()));
	}

	@GetMapping(value = "/ticketsSession")
	public ResponseEntity<List<FrontTicketsResponse>> listTicketsSession(@RequestParam Integer sessionId) {
		return ResponseEntity.ok(service.findTicketsSession(sessionId).stream() //
				.map(x -> mapper.toNewDto(x)) //
				.collect(Collectors.toList()));
			
	}



	@PostMapping
	public ResponseEntity<TicketsResponse> post(@Valid @RequestBody TicketsRequest model,
			UriComponentsBuilder uriComponentsBuilder) {

		Tickets tickets = service.createTicket(mapper.fromDto(model));

		URI uri = uriComponentsBuilder.path("/tickets/{id}").buildAndExpand(tickets.getId()).toUri();

		return ResponseEntity.created(uri).body(mapper.toDto(tickets));

	}

}
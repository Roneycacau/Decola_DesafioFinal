package com.projeto1.ticketstore.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.projeto1.ticketstore.domain.dto.response.RoomsResponse;
import com.projeto1.ticketstore.domain.dto.response.SeatResponse;
import com.projeto1.ticketstore.mapper.RoomsMapper;
import com.projeto1.ticketstore.service.RoomsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rooms")
@CrossOrigin(origins = "*")
public class RoomsController {

    private final RoomsService roomsService;
    private final RoomsMapper roomsMapper;

    @Autowired
    public RoomsController(RoomsMapper roomsMapper, RoomsService roomsService) {
        this.roomsMapper = roomsMapper;
        this.roomsService = roomsService;
    }

    @GetMapping
    public ResponseEntity<List<RoomsResponse>> list() {
    return ResponseEntity.ok(roomsService.listRooms().stream() //
    .map(x -> roomsMapper.toDto(x)) //
    .collect(Collectors.toList()));
    }
    
    // @GetMapping()
    // public ResponseEntity<SeatResponse> list() {
    //     return ResponseEntity.ok(roomsService.listSeat());
    // }

    @GetMapping(value = "/{id}")
    public ResponseEntity<RoomsResponse> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(roomsMapper.toDto(roomsService.findById(id)));
    }

}
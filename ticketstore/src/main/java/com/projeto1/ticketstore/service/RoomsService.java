package com.projeto1.ticketstore.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.projeto1.ticketstore.domain.dto.response.SeatResponse;
import com.projeto1.ticketstore.domain.entities.Rooms;
import com.projeto1.ticketstore.exception.DataNotFoundException;
import com.projeto1.ticketstore.mapper.RoomsMapper;
import com.projeto1.ticketstore.repository.RoomsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomsService {

    private final RoomsRepository roomsRepository;
    private final RoomsMapper mapper;

    @Autowired
    public RoomsService(RoomsRepository roomsRepository, RoomsMapper mapper) {
        this.roomsRepository = roomsRepository;
        this.mapper = mapper;
    }

    public List<Rooms> listRooms() {
        return roomsRepository.findAll();
    }

    public SeatResponse listSeat() {
        SeatResponse seat = new SeatResponse();
        Rooms room = this.findById(1);
        List<Integer> list = new ArrayList<>();
        list.add(room.getRowNum());
        list.add(room.getColNum());
        seat.setRoom(mapper.toDto(room));
        seat.setSeat(list);
        return seat;
    }

    public Rooms findById(Integer id) {
        Optional<Rooms> status = roomsRepository.findById(id);
        return status.orElseThrow(() -> new DataNotFoundException("Sala não encontrada"));
    }

}
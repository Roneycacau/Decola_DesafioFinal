package com.projeto1.ticketstore.mapper;

import com.projeto1.ticketstore.domain.dto.response.RoomsResponse;
import com.projeto1.ticketstore.domain.entities.Rooms;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoomsMapper {

    private final ModelMapper mapper;

    @Autowired
    public RoomsMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public RoomsResponse toDto(Rooms input) {
        return mapper.map(input, RoomsResponse.class);
    }
}
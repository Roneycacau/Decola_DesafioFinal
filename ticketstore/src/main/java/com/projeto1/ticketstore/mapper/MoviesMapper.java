package com.projeto1.ticketstore.mapper;

import com.projeto1.ticketstore.domain.dto.response.MoviesResponse;
import com.projeto1.ticketstore.domain.entities.Movies;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MoviesMapper {

    private final ModelMapper mapper;

    @Autowired
    public MoviesMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public MoviesResponse toDto(Movies input) {
        return mapper.map(input, MoviesResponse.class);
    }
}
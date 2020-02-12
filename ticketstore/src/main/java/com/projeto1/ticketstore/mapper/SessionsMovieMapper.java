package com.projeto1.ticketstore.mapper;

import com.projeto1.ticketstore.domain.dto.response.SessionsMovieModelResponse;
import com.projeto1.ticketstore.domain.dto.response.SessionsMovieResponse;
import com.projeto1.ticketstore.domain.dto.request.SessionsMovieRequest;
import com.projeto1.ticketstore.domain.entities.SessionsMovie;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SessionsMovieMapper {

    private final ModelMapper mapper;

    @Autowired
    public SessionsMovieMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public SessionsMovieResponse toDto(SessionsMovie input) {
        return mapper.map(input, SessionsMovieResponse.class);
    }

    public SessionsMovie fromDto(SessionsMovieRequest input) {
        return mapper.map(input, SessionsMovie.class);
    }

    public SessionsMovieModelResponse toNewDto(SessionsMovie x) {

        SessionsMovieModelResponse model = SessionsMovieModelResponse.builder().id(x.getId())
                .movieId(x.getIdMovie().getId()).roomId(x.getIdRoom().getId()).date(x.getDateSession().toString().substring(0,10))
                .time(x.getDateSession().toString().substring(11, 16)).build();
        return model;
    }
}
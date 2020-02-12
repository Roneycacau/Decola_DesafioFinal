package com.projeto1.ticketstore.domain.dto.response;

import java.util.Date;

import com.projeto1.ticketstore.domain.entities.Movies;
import com.projeto1.ticketstore.domain.entities.Rooms;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SessionsMovieResponse {

    private Integer id;
    private Date dateSession;
    private Movies idMovie;
    private Rooms idRoom;
}
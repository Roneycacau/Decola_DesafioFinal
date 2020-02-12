package com.projeto1.ticketstore.mapper;

import com.projeto1.ticketstore.domain.dto.request.TicketsRequest;
import com.projeto1.ticketstore.domain.dto.response.FrontTicketsResponse;
import com.projeto1.ticketstore.domain.dto.response.TicketsResponse;
import com.projeto1.ticketstore.domain.entities.Movies;
import com.projeto1.ticketstore.domain.entities.SessionsMovie;
import com.projeto1.ticketstore.domain.entities.Tickets;
import com.projeto1.ticketstore.domain.entities.Users;
import com.projeto1.ticketstore.service.MoviesService;
import com.projeto1.ticketstore.service.SessionsMovieService;
import com.projeto1.ticketstore.service.UsersService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TicketsMapper {

    @Autowired
    private final ModelMapper mapper;
    @Autowired
    private final MoviesService mService;
    @Autowired
    private final SessionsMovieService sService;
    @Autowired
    private final UsersService userService;

    @Autowired
    public TicketsMapper(ModelMapper mapper, SessionsMovieService sService, UsersService userService,
            MoviesService mService) {

        this.mapper = mapper;
        this.mService = mService;
        this.sService = sService;
        this.userService = userService;

    }

    public TicketsResponse toDto(Tickets response) {

        return mapper.map(response, TicketsResponse.class);
    }

    public FrontTicketsResponse toNewDto(Tickets response) {

        FrontTicketsResponse ftr = FrontTicketsResponse.builder().id(response.getId())
                .sessionId(response.getIdSessionMovie().getId()).userId(response.getIdUser().getId())
                .col(response.getSeatColunm()).row(response.getSeatRow()).build();

        return ftr;
    }

    public Tickets fromDto(TicketsRequest request) {

        SessionsMovie session = sService.findById(request.getSessionId());
        Users user = userService.findById(request.getUserId());

        Tickets tickets = Tickets.builder().idSessionMovie(session).idUser(user).seatColunm(request.getCol())
                .seatRow(request.getRow()).build();

        return tickets;

    }

}
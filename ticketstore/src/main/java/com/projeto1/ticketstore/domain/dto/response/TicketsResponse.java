package com.projeto1.ticketstore.domain.dto.response;

import com.projeto1.ticketstore.domain.entities.SessionsMovie;
import com.projeto1.ticketstore.domain.entities.Users;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TicketsResponse {

    private Integer id;

    private Users idUser;

    private SessionsMovie idSessionMovie;

    private Integer seatRow;

    private Integer seatColunm;

}
package com.projeto1.ticketstore.domain.dto.request;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SessionsMovieRequest {

    // @NotNull()
    private Date datesession;

    // @NotNull()
    private Integer idmovie;

    // @NotNull()
    private Integer idroom;

}
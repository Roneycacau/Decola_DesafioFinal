package com.projeto1.ticketstore.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MoviesResponse {

    private Integer id;
    private String title;
    private String photo;
    private String category;
    private String plot;
    private String director;
    private String writer;
    private Integer yearOfCreation;
}
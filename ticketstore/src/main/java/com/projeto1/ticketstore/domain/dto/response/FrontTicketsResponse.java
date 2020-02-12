package com.projeto1.ticketstore.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FrontTicketsResponse {

    private Integer id;

    private Integer userId;

    private Integer sessionId;

    private Integer row;

    private Integer col;

}
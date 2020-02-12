package com.projeto1.ticketstore.domain.dto.request;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TicketsRequest {


    @NotNull
    private Integer userId;

    @NotNull
    private Integer sessionId;

    @NotNull
    private Integer row;

    @NotNull
    private Integer col;
}
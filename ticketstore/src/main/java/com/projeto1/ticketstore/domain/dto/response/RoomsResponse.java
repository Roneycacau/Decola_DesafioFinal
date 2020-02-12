package com.projeto1.ticketstore.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoomsResponse {

    private Integer id;
    private Integer rowNum;
    private Integer colNum;
}
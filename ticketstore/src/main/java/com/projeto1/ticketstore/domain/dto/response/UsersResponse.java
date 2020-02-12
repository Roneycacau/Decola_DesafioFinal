package com.projeto1.ticketstore.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsersResponse {

    private Integer id;

    private String name;

    private String email;

    private String password;

    private Boolean isAdmin;

}
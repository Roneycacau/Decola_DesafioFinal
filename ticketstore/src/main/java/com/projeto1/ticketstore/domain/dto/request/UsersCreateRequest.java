package com.projeto1.ticketstore.domain.dto.request;

import javax.validation.constraints.NotEmpty;

import com.projeto1.ticketstore.domain.validators.ValidEmail;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsersCreateRequest {

    @NotEmpty()
    private String name;

    @NotEmpty()
    @ValidEmail
    private String email;

    @NotEmpty()
    private String password;

    // @NotNull()
    private Boolean admin;

}
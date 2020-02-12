package com.projeto1.ticketstore.mapper;

import com.projeto1.ticketstore.domain.dto.request.UsersCreateRequest;
import com.projeto1.ticketstore.domain.dto.response.UsersResponse;
import com.projeto1.ticketstore.domain.entities.Users;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsersMapper {

    private final ModelMapper mapper;

    @Autowired
    public UsersMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public UsersResponse toDto(Users input) {
        return mapper.map(input, UsersResponse.class);
    }

    public Users fromDto(UsersCreateRequest input) {
        Users user = Users.builder().username(input.getName()).email(input.getEmail()).password(input.getPassword())
                .build();
        // return mapper.map(input, Users.class);
        return user;

    }

}
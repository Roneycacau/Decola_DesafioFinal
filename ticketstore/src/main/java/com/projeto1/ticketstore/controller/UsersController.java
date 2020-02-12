package com.projeto1.ticketstore.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.projeto1.ticketstore.domain.dto.request.UsersCreateRequest;
import com.projeto1.ticketstore.domain.dto.response.UsersResponse;
import com.projeto1.ticketstore.domain.entities.Users;
import com.projeto1.ticketstore.mapper.UsersMapper;
import com.projeto1.ticketstore.service.UsersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UsersController {

    private final UsersService usersService;
    private final UsersMapper mapper;

    @Autowired
    public UsersController(UsersService usersService, UsersMapper usersMapper) {
        this.usersService = usersService;
        this.mapper = usersMapper;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UsersResponse> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(mapper.toDto(usersService.findById(id)));
    }

    @GetMapping
    public ResponseEntity<UsersResponse> getByEmail(@RequestParam String email) {
        return ResponseEntity.ok(mapper.toDto(usersService.findByEmail(email)));
    }

    @GetMapping(value = "listUsers")
    public ResponseEntity<List<UsersResponse>> list() {
        return ResponseEntity.ok(usersService.listClient().stream() //
                .map(x -> mapper.toDto(x)) //
                .collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity<UsersResponse> post(@Valid @RequestBody UsersCreateRequest model) {

        Users user = usersService.createUser(mapper.fromDto(model));
        // user.setIsAdmin(false);
        return ResponseEntity.ok(mapper.toDto(user));
    }

    // @PutMapping(value = "/{id}")
    // public ResponseEntity<UsersResponse> put(@PathVariable Integer id, @Valid
    // @RequestBody UsersCreateRequest model) {

    // Users user = usersService.update(id, mapper.fromDto(model));

    // return ResponseEntity.ok(mapper.toDto(user));
    // }

    // @DeleteMapping(value = "/{id}")
    // public ResponseEntity<UsersResponse> delete(@PathVariable Integer id) {
    // return ResponseEntity.ok(mapper.toDto(usersService.delete(id)));

    // }

}
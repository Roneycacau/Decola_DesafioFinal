package com.projeto1.ticketstore.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "username", length = 100, nullable = false, columnDefinition = "nvarchar")
    private String username;

    @Column(name = "password", length = 100, nullable = false, columnDefinition = "nvarchar")
    private String password;

    @Column(name = "email", length = 100, nullable = false, columnDefinition = "nvarchar")
    private String email;
    @Builder.Default
    @Column(name = "isAdmin", columnDefinition = "bit default 0")
    private Boolean isAdmin = false;

}
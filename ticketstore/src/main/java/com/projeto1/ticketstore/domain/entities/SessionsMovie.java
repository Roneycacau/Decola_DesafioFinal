package com.projeto1.ticketstore.domain.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "SessionsMovie")
public class SessionsMovie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "dateSession", nullable = false)
    private Date dateSession;

    @ManyToOne
    @JoinColumn(name = "idMovie", nullable = false)
    private Movies idMovie;

    @ManyToOne
    @JoinColumn(name = "idRoom", nullable = false)
    private Rooms idRoom;

}
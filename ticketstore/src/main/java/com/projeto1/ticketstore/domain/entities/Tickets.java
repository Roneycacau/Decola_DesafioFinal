package com.projeto1.ticketstore.domain.entities;

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
@Table(name = "Tickets")
public class Tickets {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "idUser", nullable = false)
    private Users idUser;

    @ManyToOne
    @JoinColumn(name = "idSessionMovie", nullable = false)
    private SessionsMovie idSessionMovie;

    @Column(name = "seatRow", nullable = false)
    private Integer seatRow;

    @Column(name = "seatColunm", nullable = false)
    private Integer seatColunm;

}
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
@Table(name = "Movies")
public class Movies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "title", length = 100, nullable = false, columnDefinition = "nvarchar")
    private String title;

    @Column(name = "photo", length = 255, nullable = false, columnDefinition = "nvarchar")
    private String photo;

    @Column(name = "category", length = 100, nullable = false, columnDefinition = "nvarchar")
    private String category;

    @Column(name = "plot", length = 300, nullable = false, columnDefinition = "nvarchar")
    private String plot;

    @Column(name = "director", length = 100, nullable = false, columnDefinition = "nvarchar")
    private String director;

    @Column(name = "writer", length = 100, nullable = false, columnDefinition = "nvarchar")
    private String writer;

    @Column(name = "yearOfCreation", nullable = false)
    private Integer yearOfCreation;

}
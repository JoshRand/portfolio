package com.joshrand.portfoliobackend.model.db;

import lombok.*;

import java.util.*;

import javax.persistence.*;

// Project bean for storing information about projects
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "title")
    private String title;
    private String description;
    private String technologies;
    private String github;
    private String image;
    private String demo;
    
//    @OneToMany(mappedBy = "project")
    @OneToMany(orphanRemoval=true, cascade = CascadeType.ALL, mappedBy = "project")
    private List<Tile> tiles = new ArrayList<>();
//    @OneToMany(mappedBy = "project")
    @OneToMany(orphanRemoval=true, cascade = CascadeType.ALL , mappedBy = "project")
    private List<Slide> slides = new ArrayList<>();

}
package com.joshrand.portfoliobackend.model;

import com.joshrand.portfoliobackend.model.db.Slide;
import com.joshrand.portfoliobackend.model.db.Tile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectResponseObject {

    private Integer id;
    private String title;
    private String description;
    private List<String> technologies;
    private String github;
    private String image;
    private String demo;
    private List<Tile> tiles = new ArrayList<Tile>();
    private List<Slide> slides = new ArrayList<Slide>();
}

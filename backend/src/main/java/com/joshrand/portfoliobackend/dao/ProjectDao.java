package com.joshrand.portfoliobackend.dao;

import java.util.List;

import com.joshrand.portfoliobackend.model.db.Project;

public interface ProjectDao {

    public Project save(Project project);

    public Project findById(int id);

    public List<Project> findAll(); 

}
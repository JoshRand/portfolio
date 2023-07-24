package com.joshrand.portfoliobackend.service;

import java.util.*;

import com.joshrand.portfoliobackend.model.ProjectResponseObject;
import com.joshrand.portfoliobackend.model.db.Project;

// Basic functions for saving and retrieving project(s)
public interface ProjectService {

    public Project saveProject(Project project);
    
    public Project updateProject(Project project);

    public Boolean saveProjects(List<Project> projects);

    public Project getProjectById(int id);

    public List<ProjectResponseObject> getAllProjects();
    
}
package com.joshrand.portfoliobackend.repo;

import java.util.ArrayList;

import com.joshrand.portfoliobackend.model.db.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// Crud Repo for persistence of Project Beans
@Repository
public interface ProjectRepo extends CrudRepository<Project, Integer>{

    public Project findById(int id);

    public ArrayList<Project> findAll();
    
}

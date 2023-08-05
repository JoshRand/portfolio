package com.joshrand.portfoliobackend.controller;

import java.util.ArrayList;
import java.util.List;

import com.joshrand.portfoliobackend.model.ProjectResponseObject;
import com.joshrand.portfoliobackend.model.db.Project;
import com.joshrand.portfoliobackend.service.ProjectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

// Make sure to change these addresses to your address or if you're running the frontend on localhost:4200 leave it as is.
@CrossOrigin(originPatterns = {"https://joshrand.xyz","https://www.joshrand.xyz", "http://localhost:4200", "http://localhost:80", "http://localhost" , "http://192.168.1.187:4200", "http://147.182.193.83:4200", "http://147.182.193.83:80", "http://143.198.178.176", "http://172.18.0.3:4200"}, methods = {RequestMethod.POST ,RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
public class ProjectController {

    @Autowired
    ProjectService projectService;
    
    
    @GetMapping("/project")
    public ResponseEntity<Project> getTest(@RequestParam(defaultValue = "999") int id )
    {
        return new ResponseEntity<Project>(projectService.getProjectById(id), HttpStatus.OK);
    }
    
    @GetMapping("/projects")
    public ResponseEntity<List<ProjectResponseObject>> getProjects()
    {
        return new ResponseEntity<>(projectService.getAllProjects(), HttpStatus.OK);
    }

// Commenting out for Security reasons.
    @PostMapping("/project")
    public ResponseEntity<Project> saveProject(@RequestBody Project project)
    {
    	return new ResponseEntity<Project>(projectService.saveProject(project), HttpStatus.OK);
    }

    @PostMapping("/projects")
    public ResponseEntity<Boolean> saveProjects(@RequestBody ArrayList<Project> projects)
    {
        return new ResponseEntity<Boolean>(projectService.saveProjects(projects), HttpStatus.OK);
    }
    
    @PutMapping("/project")
    public ResponseEntity<Project> updateProject(@RequestBody Project project)
    {
    	System.out.println(project.getTiles().get(1).getContent());
    	return new ResponseEntity<Project>(projectService.updateProject(project), HttpStatus.ACCEPTED);
    }
}    
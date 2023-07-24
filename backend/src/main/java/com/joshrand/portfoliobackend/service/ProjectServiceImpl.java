package com.joshrand.portfoliobackend.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.joshrand.portfoliobackend.dao.ProjectDao;
import com.joshrand.portfoliobackend.dao.SlideDao;
import com.joshrand.portfoliobackend.dao.TileDao;
import com.joshrand.portfoliobackend.model.ProjectResponseObject;
import com.joshrand.portfoliobackend.model.db.Project;
import com.joshrand.portfoliobackend.model.db.Slide;
import com.joshrand.portfoliobackend.model.db.Tile;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProjectServiceImpl implements ProjectService{

    @Autowired
    ProjectDao projectDao;
    @Autowired
    SlideDao slideDao;
    @Autowired
    TileDao tileDao;

    @Override
    public Project saveProject(Project project) {
        return projectDao.save(project); 
    }

    @Override
    public Boolean saveProjects(List<Project> projects)
    {
        try{
            for (Project project : projects) {
            	for (Tile tile : project.getTiles())
                {
                    tile.setProject(project);
                }
                for (Slide slide : project.getSlides()) {
                    slide.setProject(project);
                }
                saveProject(project);
            }
        }
        catch(Exception saveProjectException)
        {
            return false;
        }
       return true;
    }

    @Override
    public Project getProjectById(int id) {
        return projectDao.findById(id);
    }

    @Override
    public List<ProjectResponseObject> getAllProjects() {
        log.info("Attempting to retrieve all Projects.");
        List<Project> projects = projectDao.findAll();
        List<ProjectResponseObject> projectResponseObjects = new ArrayList<>();
        for(Project project : projects)
        {
            ProjectResponseObject projectResponseObject = new ProjectResponseObject();
            projectResponseObject.setTiles(project.getTiles());
            projectResponseObject.setTitle(project.getTitle());
            projectResponseObject.setDemo(project.getDemo());
            projectResponseObject.setId(project.getId());
            projectResponseObject.setDescription(project.getDescription());
            projectResponseObject.setImage(project.getImage());
            projectResponseObject.setSlides(project.getSlides());
            projectResponseObject.setGithub(project.getGithub());
            projectResponseObject.setTechnologies(Arrays.asList(project.getTechnologies().split(",")));
            projectResponseObjects.add(projectResponseObject);
        }
        return projectResponseObjects;
    }

	@Override
	public Project updateProject(Project project) {
		 for (Tile tile : project.getTiles())
         {
             tile.setProject(project);
             tileDao.saveTile(tile);
             System.out.println(tile.getId());
         }
         for (Slide slide : project.getSlides()) {
             slide.setProject(project);
             slideDao.saveSlide(slide);
             System.out.println(slide.getId());
         }
         System.out.println(project.getId());
         return null;
         //return saveProject(project);
	}

}
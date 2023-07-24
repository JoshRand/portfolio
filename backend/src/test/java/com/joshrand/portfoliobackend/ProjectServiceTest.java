package com.joshrand.portfoliobackend;

import org.mockito.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.Mockito.when;

import java.util.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.joshrand.portfoliobackend.dao.ProjectDaoImpl;
import com.joshrand.portfoliobackend.model.db.Project;
import com.joshrand.portfoliobackend.model.db.Slide;
import com.joshrand.portfoliobackend.model.db.Tile;
import com.joshrand.portfoliobackend.service.ProjectServiceImpl;

public class ProjectServiceTest {

//	@Mock
//	private ProjectRepo projectRepo;
	
	@Mock
	private ProjectServiceImpl projectDaoImpl;
	
	@Mock
	private ProjectDaoImpl projectDao;
	
	@InjectMocks
	private ProjectServiceImpl projectService;
	
	private AutoCloseable closeable;
	
	@BeforeEach
	void initService()
	{
		closeable = MockitoAnnotations.openMocks(this);
	}

	@AfterEach
	void closeService() throws Exception
	{
		closeable.close();
	}
	
	@Test
	void createProjectSetsEverything()
	{

		// create project
		Project project = new Project();
		
		List<Slide> slides = new ArrayList<Slide>();
		slides.add(new Slide(project,"desc","image"));
		
		List<Tile> tiles = new ArrayList<Tile>();
		tiles.add(new Tile(project,"title","type","image", "section", "content"));
		// setup project with properties
		project = new Project();
		project.setSlides(slides);
		project.setTechnologies("hi,hello");
		
		// save the project
		when(projectDao.save(any(Project.class))).then(returnsFirstArg());
		Project savedProject = projectService.saveProject(project);
		assertEquals(savedProject.getTitle(), "Title");
		assertNotNull(savedProject);
		
	}
	
}

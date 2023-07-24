package com.joshrand.portfoliobackend.service;

import com.joshrand.portfoliobackend.dao.ProjectDao;
import com.joshrand.portfoliobackend.dao.SlideDao;
import com.joshrand.portfoliobackend.model.db.Project;
import com.joshrand.portfoliobackend.model.db.Slide;

import java.util.ArrayList;
//import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SlideServiceImpl implements SlideService{
   
   @Autowired
   SlideDao slideDao;
   @Autowired
   ProjectDao projectDao;
   
   @Override
   public Project saveSlide(Slide slide, int project_id)
   {	
	   Project proj = projectDao.findById(project_id);
	   List<Slide> slides = proj.getSlides();
	   if(slides == null)
	   {
		   slides = new ArrayList<Slide>();
	   }
	   slide.setProject(proj);
	   slides.add(slide);
	   proj.setSlides(slides); 
	   
       return projectDao.save(proj);
   }

   @Override
   public Integer deleteSlide(String image_url, int project_id) {
//	   int removeSlideId = 0;
	   System.out.println("Project Id " + project_id);
	   Project project = projectDao.findById(project_id);
	   List<Slide> slides = project.getSlides();
	   
	   for (Slide slide : slides){
		   if(slide.getImage().equals(image_url))
		   {
			   System.out.print("Deleting slide");
			   try {
				   System.out.println(slide);
				   slides.remove(slide);
				   project.setSlides(slides);
				   if(slides.contains(slide))
				   {
					   System.out.println("Didn't delete");
				   }
				   if(project.getSlides().contains(slide))
				   {
					   System.out.println("Didn't delete");
				   }
				   projectDao.save(project);
				   
			   }catch (Exception e) {
				   System.out.println("Exception at delete slide");
			   }
			   return 1;
		   }
	   }
	   return 0;
   }

@Override
public Slide saveSlide(Slide slide) {
	return slideDao.saveSlide(slide);
} 
   
}
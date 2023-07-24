package com.joshrand.portfoliobackend.service;

import com.joshrand.portfoliobackend.model.db.Project;
import com.joshrand.portfoliobackend.model.db.Slide;

// Basic functions for saving and retrieving Slide(s)
public interface SlideService {

    public Project saveSlide(Slide slide, int project_id);
    public Slide saveSlide(Slide slide);
    public Integer deleteSlide(String image_url, int project_id);
    
}

package com.joshrand.portfoliobackend.dao;

import com.joshrand.portfoliobackend.model.db.Slide;

public interface SlideDao {

    public Slide saveSlide(Slide slide);
    
    public Integer deleteSlide(String image_url);
}

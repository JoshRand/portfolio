package com.joshrand.portfoliobackend.dao;

import com.joshrand.portfoliobackend.model.db.Slide;
import com.joshrand.portfoliobackend.repo.SlideRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SlideDaoImpl implements SlideDao{

    @Autowired
    SlideRepo slideRepo;

    @Override
    public Slide saveSlide(Slide slide) {
       return slideRepo.save(slide);
    }

	@Override
	public Integer deleteSlide(String image_url) {
		return slideRepo.deleteByImage(image_url);
	}
    
}

package com.joshrand.portfoliobackend.repo;

import com.joshrand.portfoliobackend.model.db.Slide;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// Crud repo for Slides (Not Really needed)
@Repository
public interface SlideRepo extends CrudRepository<Slide, Integer>{
    
	public Integer deleteByImage(String image);
}

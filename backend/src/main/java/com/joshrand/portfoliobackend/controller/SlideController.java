package com.joshrand.portfoliobackend.controller;

import javax.transaction.Transactional;

import com.joshrand.portfoliobackend.model.db.Project;
import com.joshrand.portfoliobackend.model.db.Slide;
import com.joshrand.portfoliobackend.service.SlideService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(originPatterns = {"https://joshrand.xyz","https://www.joshrand.xyz", "http://localhost:4200", "http://localhost:80", "http://localhost" , "http://192.168.1.187:4200", "http://147.182.193.83:4200", "http://147.182.193.83:80", "http://143.198.178.176", "http://172.18.0.3:4200"}, methods = {RequestMethod.POST ,RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping(value = "/api")
public class SlideController {

	@Autowired
	SlideService slideService;
	@Transactional
	@PutMapping
	public ResponseEntity<Slide> saveSlide(@RequestBody Slide slide)
	{
		return new ResponseEntity<Slide>(slideService.saveSlide(slide), HttpStatus.OK);
	}
	@DeleteMapping("/slide/{id}")
	public ResponseEntity<Integer> deleteSlide(@RequestBody Slide slide, @PathVariable int id)
	{
	
		System.out.println(slide.getImage());
		return new ResponseEntity<Integer>(slideService.deleteSlide(slide.getImage(), id), HttpStatus.OK);
	}
	@PostMapping("/slide/{id}")
	public ResponseEntity<Project> createSlide(@RequestBody Slide slide, @PathVariable int id)
	{
		return new ResponseEntity<Project>(slideService.saveSlide(slide, id), HttpStatus.OK);
	}
}

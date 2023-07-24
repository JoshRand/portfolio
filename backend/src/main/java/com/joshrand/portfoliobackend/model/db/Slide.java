package com.joshrand.portfoliobackend.model.db;

import java.io.Serializable;

import javax.persistence.*;

// Slide bean for Carousel 
@Entity
public class Slide implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "project_id")
    private Project project;
    private String description;
    private String image;

    public void setProject(Project project) {
        this.project = project;
    }
    
    public int getId() {
		return id;
	}

	public Slide() {
    }

//    public Project getProject() {
//		return project;
//	}

	public Slide(Project project, String description, String image) {
        this.project = project;
        this.description = description;
        this.image = image;
    }

    @Override
	public String toString() {
		return "Slide [id=" + id + ", project=" + project + ", description=" + description + ", image=" + image + "]";
	}

	public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
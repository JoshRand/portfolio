package com.joshrand.portfoliobackend.model.db;

import java.io.Serializable;

import javax.persistence.*;

// Tile bean for info on tiles in frontend grid
@Entity
public class Tile implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(cascade = CascadeType.ALL)
    private Project project;
    private String title;
    private String type;
    private String image;
    private String section;
    // Lots of Data for content
    @Lob
    @Column( length = 100000 )
    private String content;

    public void setProject(Project project) {
        this.project = project;
    }
    
    public Tile() {
    }

    public int getId() {
		return id;
	}

	public Tile( Project project, String title, String type, String image, String section, String content) {
    
        this.project = project;
        this.title = title;
        this.type = type;
        this.image = image;
        this.section = section;
        this.content = content;
    }


    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSection() {
        return this.section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
}

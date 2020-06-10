package com.project.demo.dto;

import com.project.demo.model.Genre;
import java.util.ArrayList;
import java.util.Date;

public class BookDTO {
    private String name;
    private ArrayList<WriterDTO> writers;
    private String image;
    private Genre genre;
    private Date published;

    public BookDTO(String name, ArrayList<WriterDTO> writers, String image, Genre genre, Date published) {
        this.name = name;
        this.writers = writers;
        this.image = image;
        this.genre = genre;
        this.published = published;
    }

    public BookDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<WriterDTO> getWriters() {
        return writers;
    }

    public void setWriters(ArrayList<WriterDTO> writers) {
        this.writers = writers;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Date getPublished() {
        return published;
    }

    public void setPublished(Date published) {
        this.published = published;
    }
}

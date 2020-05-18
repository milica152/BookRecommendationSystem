package com.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "author", nullable = false)
    private String author;

    @Column(name = "published", nullable = false)
    private Date published;

    @Column(name = "written", nullable = false)
    private Date written;

    @Column(name = "oldness")
    private Oldness oldness;

    @Column(name = "genre", nullable = false)
    private Genre genre;

    @Column(name = "stars", nullable = false)
    private double stars;


    public Book(String name, String author, Date published, Date written, Oldness oldness, Genre genre, double stars) {
        this.name = name;
        this.author = author;
        this.published = published;
        this.written = written;
        this.oldness = oldness;
        this.genre = genre;
        this.stars = stars;
    }

    public double getStars() {
        return stars;
    }

    public void setStars(double stars) {
        this.stars = stars;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getPublished() {
        return published;
    }

    public void setPublished(Date published) {
        this.published = published;
    }

    public Date getWritten() {
        return written;
    }

    public void setWritten(Date written) {
        this.written = written;
    }

    public Oldness getOldness() {
        return oldness;
    }

    public void setOldness(Oldness oldness) {
        this.oldness = oldness;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}

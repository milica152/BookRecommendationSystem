package com.project.demo.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "image", nullable = false)
    private String image;

    @Column(name = "genre", nullable = false)
    private Genre genre;

    @Column(name = "published", nullable = false)
    private int published;

    @Column(name = "ageOfBook")
    private AgeOfBook ageOfBook;

    @Column(name = "ratingCount", nullable = false)
    private int ratingCount;

    @Column(name = "rating", nullable = false)
    private double rating;

    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinTable(name = "book_writer",
            joinColumns = {@JoinColumn(name = "book_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "writer_id", referencedColumnName = "id")}
    )
    private List<Writer> writers = new ArrayList<>();


    public Book() {
    }

    public Book(String name, String image, Genre genre, int published, AgeOfBook ageOfBook, int ratingCount, double rating, List<Writer> writers) {
        this.name = name;
        this.image = image;
        this.genre = genre;
        this.published = published;
        this.ageOfBook = ageOfBook;
        this.ratingCount = ratingCount;
        this.rating = rating;
        this.writers = writers;
    }

    public int getRatingCount() {
        return ratingCount;
    }

    public void setRatingCount(int ratingCount) {
        this.ratingCount = ratingCount;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getPublished() {
        return published;
    }

    public void setPublished(int published) {
        this.published = published;
    }

    public AgeOfBook getAgeOfBook() {
        return ageOfBook;
    }

    public void setAgeOfBook(AgeOfBook ageOfBook) {
        this.ageOfBook = ageOfBook;
    }

    public List<Writer> getWriters() {
        return writers;
    }

    public void setWriters(List<Writer> writers) {
        this.writers = writers;
    }
}



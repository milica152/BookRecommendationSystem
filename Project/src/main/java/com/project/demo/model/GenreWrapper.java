package com.project.demo.model;

public class GenreWrapper {
    private Genre genre;

    public GenreWrapper(Genre genre) {
        this.genre = genre;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}

package com.project.demo.model;

public class Answer {
    Genre genre;

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Answer(Genre genre) {
        this.genre = genre;
    }

    public Answer() {
    }
}

package com.project.demo.dto;

public class BookScore {
    private BookDTO book;
    private double score;

    public BookScore(BookDTO book, double score) {
        this.book = book;
        this.score = score;
    }

    public BookScore() {
    }

    public BookDTO getBook() {
        return book;
    }

    public void setBook(BookDTO book) {
        this.book = book;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}

package com.model;


import java.util.ArrayList;

public class PersonInfo {
    private int yearsOld;
    private Sex sex;
    private Genre genre;
    private double maxPrice;
    private ArrayList<Interest> interests;
    private ArrayList<Book> booksRead;
    private Age age;

    public PersonInfo(int yearsOld, Sex sex, Genre genre, double maxPrice, ArrayList<Interest> interests, ArrayList<Book> booksRead, Age age) {
        this.yearsOld = yearsOld;
        this.sex = sex;
        this.genre = genre;
        this.maxPrice = maxPrice;
        this.interests = interests;
        this.booksRead = booksRead;
        this.age = age;
    }

    public int getYearsOld() {
        return yearsOld;
    }

    public void setYearsOld(int yearsOld) {
        this.yearsOld = yearsOld;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(double maxPrice) {
        this.maxPrice = maxPrice;
    }

    public ArrayList<Interest> getInterests() {
        return interests;
    }

    public void setInterests(ArrayList<Interest> interests) {
        this.interests = interests;
    }

    public ArrayList<Book> getBooksRead() {
        return booksRead;
    }

    public void setBooksRead(ArrayList<Book> booksRead) {
        this.booksRead = booksRead;
    }

    public Age getAge() {
        return age;
    }

    public void setAge(Age age) {
        this.age = age;
    }
}

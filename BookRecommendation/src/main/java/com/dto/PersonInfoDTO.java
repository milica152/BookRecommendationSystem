package com.dto;

import java.util.ArrayList;

public class PersonInfoDTO {
    private String age;
    private String sex;
    private String genre;
    private double maxPrice;
    private ArrayList<String> interests;
    private ArrayList<String> booksRead;

    public PersonInfoDTO(String age, String sex, String genre, double maxPrice, ArrayList<String> interests, ArrayList<String> booksRead) {
        this.age = age;
        this.sex = sex;
        this.genre = genre;
        this.maxPrice = maxPrice;
        this.interests = interests;
        this.booksRead = booksRead;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(double maxPrice) {
        this.maxPrice = maxPrice;
    }

    public ArrayList<String> getInterests() {
        return interests;
    }

    public void setInterests(ArrayList<String> interests) {
        this.interests = interests;
    }

    public ArrayList<String> getBooksRead() {
        return booksRead;
    }

    public void setBooksRead(ArrayList<String> booksRead) {
        this.booksRead = booksRead;
    }
}

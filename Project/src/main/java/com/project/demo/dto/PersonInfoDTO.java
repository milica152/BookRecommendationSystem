package com.project.demo.dto;

import com.project.demo.model.Age;
import com.project.demo.model.Gender;
import com.project.demo.model.Genre;
import com.project.demo.model.SphereOfInterest;

import java.util.ArrayList;

public class PersonInfoDTO {
    private int age;
    private Age ageGroup;
    private Gender gender;
    private ArrayList<SphereOfInterest> sphereOfInterest;
    private ArrayList<String> booksRead;
    private double maxPrice;
    private String bookName;    // only for checking recommendation, otherwise null

    public PersonInfoDTO(int age, Age ageGroup, Gender gender, ArrayList<SphereOfInterest> sphereOfInterest, ArrayList<String> booksRead, double maxPrice, String bookName) {
        this.ageGroup = ageGroup;
        this.gender = gender;
        this.sphereOfInterest = sphereOfInterest;
        this.booksRead = booksRead;
        this.maxPrice = maxPrice;
        this.bookName = bookName;
        this.age = age;
    }

    public PersonInfoDTO(){

    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Age getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(Age ageGroup) {
        this.ageGroup = ageGroup;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public ArrayList<SphereOfInterest> getSphereOfInterest() {
        return sphereOfInterest;
    }

    public void setSphereOfInterest(ArrayList<SphereOfInterest> sphereOfInterest) {
        this.sphereOfInterest = sphereOfInterest;
    }

    public ArrayList<String> getBooksRead() {
        return booksRead;
    }

    public void setBooksRead(ArrayList<String> booksRead) {
        this.booksRead = booksRead;
    }

    public double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(double maxPrice) {
        this.maxPrice = maxPrice;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}

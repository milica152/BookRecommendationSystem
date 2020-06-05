package com.project.demo.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "writers")
public class Writer {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Column(name = "surname", unique = true, nullable = false)
    private String surname;

    @Column(name = "about", unique = true, nullable = false)
    private String about;

    @Column(name = "image", unique = true, nullable = false)
    private String image;

    @Column(name = "birth", unique = true, nullable = false)
    private Date birth;


    public Writer(String name, String surname, String about, String image, Date birth) {
        this.name = name;
        this.surname = surname;
        this.about = about;
        this.image = image;
        this.birth = birth;
    }

    public Writer() {
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }
}

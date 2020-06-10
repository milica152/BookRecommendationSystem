package com.project.demo.dto;

public class WriterDTO {
    private String name;
    private String surname;

    public WriterDTO(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public WriterDTO() {
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
}

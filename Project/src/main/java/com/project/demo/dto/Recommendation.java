package com.project.demo.dto;

import java.util.ArrayList;

public class Recommendation {
    private ArrayList<BookScore> topTen = new ArrayList<>();

    public Recommendation(ArrayList<BookScore> topTen) {
        this.topTen = topTen;
    }

    public Recommendation() {
    }

    public ArrayList<BookScore> getTopTen() {
        return topTen;
    }

    public void setTopTen(ArrayList<BookScore> topTen) {
        this.topTen = topTen;
    }
}

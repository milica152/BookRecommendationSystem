package com.project.demo.model;

import java.util.HashMap;

public class GenreScore {
    HashMap<Genre, Integer> genreScores = new HashMap<>();

    public HashMap<Genre, Integer> getGenreScores() {
        return genreScores;
    }

    public void setGenreScores(HashMap<Genre, Integer> genreScores) {     // ako ne radi nesto oko ovoga, pokusaj da namestis onako kako sigurno radi
        this.genreScores = genreScores;
    }

    public GenreScore(HashMap<Genre, Integer> genreScores) {
        this.genreScores = genreScores;
    }

    public GenreScore() {
    }
}

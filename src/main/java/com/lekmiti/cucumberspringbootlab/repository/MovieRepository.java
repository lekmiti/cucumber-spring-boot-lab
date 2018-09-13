package com.lekmiti.cucumberspringbootlab.repository;

import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class MovieRepository {

    private List<String> movies = Arrays.asList("Catch me if you can", "Transformers ", "Transporter");

    public List<String> getAllMovies() {
        return movies;
    }

    public String getMovieByIndex(int index) {
        return index < movies.size() ? movies.get(index) : null;
    }
}

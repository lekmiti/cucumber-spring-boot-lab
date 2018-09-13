package com.lekmiti.cucumberspringbootlab.services;

import com.lekmiti.cucumberspringbootlab.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {


    @Autowired
    MovieRepository movieRepository;


    public List<String> getAllMovies() {
        return movieRepository.getAllMovies();
    }

    public String getMovieByIndex(int index) {
        return movieRepository.getMovieByIndex(index);

    }
}

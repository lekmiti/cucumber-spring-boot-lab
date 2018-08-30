package com.lekmiti.cucumberspringbootlab;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieResource {

    @GetMapping("/all")
    public ResponseEntity<List<String>> getAllMovies() {
        List<String> movies = Arrays.asList("movie_1, movie_2, movie_3");
        return new ResponseEntity<>(movies, new HttpHeaders(), HttpStatus.OK);
    }
}
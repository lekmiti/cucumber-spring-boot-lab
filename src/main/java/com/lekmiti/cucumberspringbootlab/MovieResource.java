package com.lekmiti.cucumberspringbootlab;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieResource {

    List<String> movies = Arrays.asList("Catch me if you can", "Transformers ", "Transporter");

    @GetMapping("/all")
    public ResponseEntity<List<String>> getAllMovies() {
        return new ResponseEntity<>(movies, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}" )
    public ResponseEntity<String> getMovie(@PathVariable("id") int id) {
        return id < movies.size() ?
                new ResponseEntity<>(movies.get(id), new HttpHeaders(), HttpStatus.OK) :
                new ResponseEntity<>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }


}

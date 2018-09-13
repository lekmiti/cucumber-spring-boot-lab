package com.lekmiti.cucumberspringbootlab.resources;

import com.lekmiti.cucumberspringbootlab.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieResource {

    @Autowired
    MovieService movieService;

    @GetMapping("/all")
    public ResponseEntity<List<String>> getAllMovies() {
        return new ResponseEntity<>(movieService.getAllMovies(), new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}" )
    public ResponseEntity<String> getMovie(@PathVariable("id") int id) {

        String movie = movieService.getMovieByIndex(id);
        return movie != null ?
                new ResponseEntity<>(movie, new HttpHeaders(), HttpStatus.OK) :
                new ResponseEntity<>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }


}

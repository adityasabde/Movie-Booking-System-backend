package com.project.MovieBookingSystem.controller;

import com.project.MovieBookingSystem.Entity.Movie;
import com.project.MovieBookingSystem.Entity.MovieWrapper;
import com.project.MovieBookingSystem.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api")
public class MovieController {
    @Autowired
    MovieService service;

    //add movie to DB
    @GetMapping("/allmovies")
    public ResponseEntity<List<Movie>> getAllMovies(){
        return new ResponseEntity<>(service.getAllMovies() , HttpStatus.OK);
    }
    @PostMapping("/addmovie")
    public ResponseEntity<Movie> addMovie(@RequestBody MovieWrapper movie){
        return new ResponseEntity<>(service.addMovie(movie) , HttpStatus.CREATED);
    }
    @DeleteMapping("/deletemovie/{id}")
    public ResponseEntity<String> deleteMovie(@PathVariable("id") Long id){
        return new ResponseEntity<>(service.deleteMovie(id) , HttpStatus.OK);
    }

}

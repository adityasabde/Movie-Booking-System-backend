package com.project.MovieBookingSystem.services;

import com.project.MovieBookingSystem.Entity.Movie;
import com.project.MovieBookingSystem.Entity.MovieWrapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface MovieService {
    public List<Movie> getAllMovies();
    public Movie findByMovieName(String Movie_Name);
    public Movie addMovie( MovieWrapper movie);
    public String deleteMovie(Long id);
    public String BookMySeat(int[] no , String name , String showTime);
}

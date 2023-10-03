package com.project.MovieBookingSystem.repository;

import com.project.MovieBookingSystem.Entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepo extends JpaRepository<Movie , Long> {
    public Movie findByName(String movieName);
}

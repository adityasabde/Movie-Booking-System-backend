package com.project.MovieBookingSystem.servieImpl;

import com.project.MovieBookingSystem.Entity.Movie;
import com.project.MovieBookingSystem.Entity.MovieWrapper;
import com.project.MovieBookingSystem.Entity.Show;
import com.project.MovieBookingSystem.repository.MovieRepo;
import com.project.MovieBookingSystem.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    MovieRepo repo;
    @Override
    public List<Movie> getAllMovies() {
        return repo.findAll();
    }
    @Override
    public Movie findByMovieName(String Movie_Name) {
        return repo.findByName(Movie_Name);
    }

    @Override
    public Movie addMovie(MovieWrapper movieWrapper) {
        Movie movie = new Movie();
        movie.setId(movieWrapper.getId());
        movie.setName(movieWrapper.getName());
        movie.setPrice(movieWrapper.getPrice());
        movie.setNoOfShows(movieWrapper.getNoOfShows());
        movie.setImgurl(movieWrapper.getImgurl());
        List<Show> shows = new ArrayList<>();
        for (String showTime : movieWrapper.getShowTimes()) {
            Show show = new Show();
            show.setId(movieWrapper.getId()+1);
            show.setShowTime(showTime);
            show.setSeatsArray(new boolean[movieWrapper.getTotalSeats().intValue()]);
            show.setTotalSeats(movieWrapper.getTotalSeats());
            show.setMovie(movie); // Set the movie for the relationship

            shows.add(show);
        }
        movie.setShows(shows);
        System.out.println(movie);
        return repo.save(movie);
    }

    @Override
    public String deleteMovie(Long id) {
        Optional<Movie> p = repo.findById(id);
        if(p.isPresent()){
            repo.deleteById(id);
        }
        return "Deleted successfull";
    }

    @Override
    public String BookMySeat(int[] no, String name, String showTime) {
         Movie movie = repo.findByName(name);
         List<Show> shows  = movie.getShows();
         for(Show s : shows){
             if(s.getShowTime().equals(showTime)){
                 boolean [] seats = s.getSeatsArray();
                 for(int n : no){
                    if(n >= seats.length){
                        break;
                    }
                    seats[n] = true;
                }
                 s.setSeatsArray(seats);
                 repo.save(movie);
                 return "Your Seat is Confirm Thank you for Booking";
             }
         }
         return "sorry...... something wents wrong or you cannot choose this seat no.";
     }
}

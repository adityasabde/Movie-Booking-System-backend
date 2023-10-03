package com.project.MovieBookingSystem.controller;

import com.project.MovieBookingSystem.Entity.BookingWrapper;
import com.project.MovieBookingSystem.Entity.Movie;
import com.project.MovieBookingSystem.Entity.User;
import com.project.MovieBookingSystem.services.MovieService;
import com.project.MovieBookingSystem.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService service;

    @Autowired
    MovieService Movieservice;

    @PostMapping("/register")
    public ResponseEntity<User> register_user(@RequestBody User user){
        return new ResponseEntity<>(service.register_user(user) , HttpStatus.CREATED);
    }
    @GetMapping("/alluser")
    public ResponseEntity<List<User>> getAllUser(){
        return new ResponseEntity<>(service.getAllUser() , HttpStatus.OK);
    }

    @GetMapping("/findmovie/{name}")
    public ResponseEntity<Movie> findByMovieName(@PathVariable("name") String Movie_Name){
        return new ResponseEntity<>(Movieservice.findByMovieName(Movie_Name) , HttpStatus.OK);
    }

    @PostMapping("booking")
    public ResponseEntity<String> BookMySeat(@RequestBody BookingWrapper obj){
        return new ResponseEntity<>(Movieservice.BookMySeat(obj.getSeatno() , obj.getName() , obj.getShowTime()) , HttpStatus.OK);
    }

    @PostMapping("/payment")
    public ResponseEntity<Boolean> Payment(@RequestParam("UPI") String UPI ){
        return new ResponseEntity<>(service.Payment(UPI) , HttpStatus.OK);
    }
}

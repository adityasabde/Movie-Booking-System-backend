package com.project.MovieBookingSystem.services;

import com.project.MovieBookingSystem.Entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

public interface UserService {
    public User register_user(User user);
    public List<User> getAllUser();
    public Boolean Payment(String UPI );

}

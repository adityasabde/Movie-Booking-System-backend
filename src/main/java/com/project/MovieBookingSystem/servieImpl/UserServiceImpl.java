package com.project.MovieBookingSystem.servieImpl;

import com.project.MovieBookingSystem.Entity.User;
import com.project.MovieBookingSystem.repository.UserRepo;
import com.project.MovieBookingSystem.services.UserService;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Pattern;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo repo;
    @Override
    public User register_user(User user) {
        return repo.save(user);
    }
    @Override
    public List<User> getAllUser() {
        return repo.findAll();
    }

    @Override
    public Boolean Payment(String UPI) {
        final String UPI_ID_REGEX = "^[a-zA-Z0-9]+@[a-zA-Z0-9]+$";
        final Pattern pattern = Pattern.compile(UPI_ID_REGEX);

        return pattern.matcher(UPI).matches() ? true : false;
    }
}

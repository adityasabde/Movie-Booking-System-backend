package com.project.MovieBookingSystem.repository;

import com.project.MovieBookingSystem.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}

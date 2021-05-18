package com.softuni.judgeV2.repository;

import com.softuni.judgeV2.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsernameAndPassword(String username, String password);

    @Query("SELECT u.username FROM User u " +
            "ORDER BY u.username ")
    List<String> findAllUsernames();

    Optional<User> findByUsername(String username);
}

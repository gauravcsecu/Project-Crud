package com.example.latestapplication.user;

import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Id> {

    Optional<User> findById(Integer id);

    Long countById(Integer id);

    void deleteById(Integer id);
}

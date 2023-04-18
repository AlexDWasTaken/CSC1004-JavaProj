package com.alexd.messager.DAO;

import com.alexd.messager.DTO.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//Use JPA to interact with database.
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String username);

    void deleteByUsername(String username);
}

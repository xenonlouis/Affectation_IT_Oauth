package com.example.springsecure.Repository;

import com.example.springsecure.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    public User findByMail(String mail);


   // Optional<User> findByMail(String mail);
}

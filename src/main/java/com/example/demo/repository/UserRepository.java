package com.example.demo.repository;

import com.example.demo.config.STATUS;
import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByStatus(STATUS status);

    User findByIdAndStatus(Long id, STATUS status);

    User findByEmailAndStatus(String email, STATUS status);
}

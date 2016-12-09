package com.accentureacademy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accentureacademy.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}

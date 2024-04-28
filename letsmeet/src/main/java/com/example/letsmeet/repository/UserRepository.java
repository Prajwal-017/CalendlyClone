package com.example.letsmeet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.letsmeet.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	Object findByEmail(String email);

}

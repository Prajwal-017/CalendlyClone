package com.example.letsmeet.service;


import com.example.letsmeet.entity.User;

public interface UserService {

	void registerUser(User user);

	boolean validateUser(String firstName, String password);

	void saveUser(User user);

	boolean isUserExistsByEmail(String email);

}

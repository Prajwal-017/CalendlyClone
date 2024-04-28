package com.example.letsmeet.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.letsmeet.entity.User;
import com.example.letsmeet.repository.UserRepository;

import ch.qos.logback.core.net.SyslogOutputStream;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository urepo;

    private List<User> userList = new ArrayList<>();


    @Override
    public void registerUser(User user) {
        urepo.save(user);
    }

    @Override
    public boolean validateUser(String email, String password) {
        // Find the user by email using the UserRepository
        User user = (User) urepo.findByEmail(email);
        
        // Check if the user exists and if the provided password matches the stored password
        if (user != null) {
            // Compare the provided password with the stored password
            return user.getPassword().equals(password);
        }
        // Return false if the user does not exist or the password does not match
        return false;
    }


	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		urepo.save(user);
	}

	 @Override
	    public boolean isUserExistsByEmail(String email) {
	        return urepo.findByEmail(email)!= null;
	    }
}

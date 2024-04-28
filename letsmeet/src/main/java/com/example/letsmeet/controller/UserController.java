
package com.example.letsmeet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.letsmeet.entity.User;
import com.example.letsmeet.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user/register")
    public String registerUser(@ModelAttribute User user, RedirectAttributes redirectAttributes) {
        if (userService.isUserExistsByEmail(user.getEmail())) {
            // Show pop-up alert for error message
            String errorMessage = "User with this email already exists";
            redirectAttributes.addFlashAttribute("error", errorMessage);
            return "redirect:/error"; // Redirect to an error page
        }

        userService.registerUser(user);
        // Show pop-up alert for success message
        redirectAttributes.addFlashAttribute("message", "User registered successfully");
        return "appointment"; // Redirect to the appointment management page
    }

    @PostMapping("/user/login")
    public String loginUser(@RequestParam String email, @RequestParam String password, RedirectAttributes redirectAttributes) {
        boolean isValidUser = userService.validateUser(email, password);
        
        System.out.println("User validation result: " + isValidUser);
        
        if (isValidUser) {
            redirectAttributes.addFlashAttribute("message", "Login successful");
            return "appointment";
        } else {
            redirectAttributes.addFlashAttribute("error", "Invalid email or password");
            return "error";
        }
    }



    @PostMapping("/user/validate")
    public ResponseEntity<String> validateUser(@RequestBody User user) {
        if (userService.isUserExistsByEmail(user.getEmail())) {
            return ResponseEntity.badRequest().body("User with this email already exists");
        }
        return ResponseEntity.ok("User validation successful");
    }
}
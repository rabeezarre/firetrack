package com.firetrack.controller;

import com.firetrack.entity.User;
import com.firetrack.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private static final Logger logger = LogManager.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User credentials) {
        logger.debug("Login request received for email: {}", credentials.getEmail()); // DEBUG level
        Optional<User> user = userService.validateCredentials(credentials.getEmail(), credentials.getPassword());
        if (user.isPresent()) {
            logger.info("Login successful for user ID: {}", user.get().getUserId()); // INFO level
            return ResponseEntity.ok("User authenticated successfully. User ID: " + user.get().getUserId());
        } else {
            logger.warn("Login attempt failed for email: {}", credentials.getEmail()); // WARN level
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        logger.info("User registration attempt for email: {}", user.getEmail());
        User registeredUser = userService.registerUser(user);
        logger.info("User registered successfully with ID: {}", registeredUser.getUserId());
        return ResponseEntity.ok("User registered successfully with ID: " + registeredUser.getUserId());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> getUser(@PathVariable Long userId) {
        Optional<User> user = userService.getUserById(userId);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{userId}")
    public ResponseEntity<?> updateUser(@PathVariable Long userId, @RequestBody User user) {
        User updatedUser = userService.updateUser(userId, user);
        if (updatedUser != null) {
            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.ok("User deleted successfully");
    }
}

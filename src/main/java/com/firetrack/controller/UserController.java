package com.firetrack.controller;

import com.firetrack.entity.User;
import com.firetrack.exception.UserAlreadyExistsException;
import com.firetrack.repository.UserRepository;
import com.firetrack.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User credentials) {
        try {
            User user = userRepository.findByEmail(credentials.getEmail());
//            credentials.setPassword(passwordEncoder.encode(credentials.getPassword()));
//            User user = userService.validateCredentials(credentials.getEmail(), credentials.getPassword());
//            System.out.println(user);
            if (passwordEncoder.matches(user.getPassword(), passwordEncoder.encode(credentials.getPassword()))) {
                return ResponseEntity.status(201).body(user);
            } else {
                throw new UsernameNotFoundException("Null user");
            }
//            return ResponseEntity.status(201).body("user");  // ResponseEntity<User>
        } catch (Exception e) {
            return ResponseEntity.status(401).body("Invalid credentials");  // ResponseEntity<String>
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        try {
            User registeredUser = userService.registerUser(user);
            return ResponseEntity.status(201).body(registeredUser);  // ResponseEntity<User>
        } catch (UserAlreadyExistsException e) {
            return ResponseEntity.status(409).body("Error: User with given email already exists.");  // ResponseEntity<String>
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Internal Server Error: " + e.getMessage());  // ResponseEntity<String>
        }
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> getUser(@PathVariable Long userId) {
        Optional<User> user = userService.getUserById(userId);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{userId}")
    public ResponseEntity<?> updateUser(@PathVariable Long userId, @RequestBody User userUpdates) {
        try {
            User updatedUser = userService.updateUser(userId, userUpdates);
            return ResponseEntity.ok(updatedUser);  // Return the updated user object
        } catch (Exception e) {
            return ResponseEntity.status(404).body("User not found");
        }
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Long userId) {
        try {
            userService.deleteUser(userId);
            return ResponseEntity.ok("User deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(404).body("User not found");
        }
    }
}

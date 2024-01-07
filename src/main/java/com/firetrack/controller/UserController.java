package com.firetrack.controller;

import com.firetrack.dto.UserDTO;
import com.firetrack.entity.User;
import com.firetrack.exception.UserAlreadyExistsException;
import com.firetrack.repository.UserRepository;
import com.firetrack.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
        User existingUser = userRepository.findByEmail(credentials.getEmail());
        if (existingUser == null) {
            return ResponseEntity.status(401).body("User is not registered");
        }

        if (!passwordEncoder.matches(credentials.getPassword(), existingUser.getPassword())) {
            return ResponseEntity.status(401).body("Invalid credentials");
        } else {
            UserDTO userDTO = convertToDTO(existingUser);
            return ResponseEntity.ok(userDTO);
        }
    }

    private UserDTO convertToDTO(User user) {
        UserDTO dto = new UserDTO();
        dto.setUserId(user.getUserId());
        dto.setEmail(user.getEmail());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setPosition(user.getPosition());
        dto.setRole(user.getRole());
        return dto;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        try {
            User registeredUser = userService.registerUser(user);
            UserDTO userDTO = convertToDTO(registeredUser);
            return ResponseEntity.status(201).body(userDTO);
        } catch (UserAlreadyExistsException e) {
            return ResponseEntity.status(409).body("Error: User with given email already exists.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Internal Server Error: " + e.getMessage());
        }
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> getUser(@PathVariable Long userId) {
        Optional<User> user = userService.getUserById(userId);
        return user.map(u -> ResponseEntity.ok(convertToDTO(u)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{userId}")
    public ResponseEntity<?> updateUser(@PathVariable Long userId, @RequestBody User userUpdates) {
        try {
            User updatedUser = userService.updateUser(userId, userUpdates);
            UserDTO userDTO = convertToDTO(updatedUser);
            return ResponseEntity.ok(userDTO);
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

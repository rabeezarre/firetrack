/**
 * This package contains controller classes responsible for managing user-related operations.
 * Controllers handle incoming HTTP requests and interact with the corresponding service methods.
 */
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

/**
 * Controller class for managing user operations.
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * Authenticates a user and returns a UserDTO upon successful login.
     *
     * @param credentials The User object containing login credentials.
     * @return A ResponseEntity containing the UserDTO if authentication is successful, or an error response if not.
     */
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

    // ... (Continued)
    // Include Javadoc comments for other methods as well

    /**
     * Converts a User object to a UserDTO object for response purposes.
     *
     * @param user The User object to be converted.
     * @return A UserDTO object containing selected user information.
     */
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

    /**
     * Registers a new user.
     *
     * @param user The User object representing the user to be registered.
     * @return A ResponseEntity containing the newly registered UserDTO if successful,
     *         or an error response if the user already exists or an internal server error occurs.
     */
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

    /**
     * Retrieves a user by their user ID.
     *
     * @param userId The ID of the user to retrieve.
     * @return A ResponseEntity containing the UserDTO if the user is found, or a not found response if not found.
     */
    @GetMapping("/{userId}")
    public ResponseEntity<?> getUser(@PathVariable Long userId) {
        Optional<User> user = userService.getUserById(userId);
        return user.map(u -> ResponseEntity.ok(convertToDTO(u)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Updates a user's information by their user ID.
     *
     * @param userId       The ID of the user to update.
     * @param userUpdates  The User object containing the updated user information.
     * @return A ResponseEntity containing the updated UserDTO if the user is found and updated successfully,
     *         or a not found response if not found, or an error response if an internal server error occurs.
     */
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

    /**
     * Deletes a user by their user ID.
     *
     * @param userId The ID of the user to delete.
     * @return A ResponseEntity indicating success if the user is deleted successfully, or an error response if not found.
     */
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

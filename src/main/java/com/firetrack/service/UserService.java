/**
 * This package contains service classes responsible for handling business logic related to user management.
 * Service classes act as an intermediary between controllers and repositories, providing user-related functionality.
 */
package com.firetrack.service;

import com.firetrack.entity.User;
import com.firetrack.exception.UserAlreadyExistsException;
import com.firetrack.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service class for managing user-related operations such as authentication, registration, and user profile management.
 * UserService provides methods for validating user credentials, registering new users, retrieving and updating user information,
 * and deleting user accounts.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * Validate user credentials by checking the provided email and password against the database.
     *
     * @param email    The email address of the user.
     * @param password The password provided by the user.
     * @return The user object if the credentials are valid, or null if not found.
     */
    public User validateCredentials(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }

    /**
     * Register a new user with the provided user details.
     *
     * @param user The user object containing registration information.
     * @return The registered user with updated details.
     * @throws UserAlreadyExistsException if a user with the same email already exists in the database.
     */
    public User registerUser(User user) {
        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new UserAlreadyExistsException("A user with this email already exists");
        }

        return userRepository.save(user);
    }

    /**
     * Retrieve a user by their unique identifier (userId).
     *
     * @param userId The unique identifier of the user to retrieve.
     * @return An optional containing the user if found, or an empty optional if not found.
     */
    public Optional<User> getUserById(Long userId) {
        return userRepository.findById(userId);
    }

    /**
     * Update user information with the given userId and updated user details.
     *
     * @param userId      The unique identifier of the user to be updated.
     * @param updatedUser The updated user details, including first name, last name, and position.
     * @return The updated user with the modified details, or null if the user is not found.
     */
    public User updateUser(Long userId, User updatedUser) {
        return userRepository.findById(userId).map(user -> {
            user.setFirstName(updatedUser.getFirstName());
            user.setLastName(updatedUser.getLastName());
            user.setPosition(updatedUser.getPosition());
            return userRepository.save(user);
        }).orElse(null);
    }

    /**
     * Delete a user account by their unique identifier (userId).
     *
     * @param userId The unique identifier of the user account to be deleted.
     */
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}

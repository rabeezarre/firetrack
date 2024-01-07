package com.firetrack.service;

import com.firetrack.entity.User;
import com.firetrack.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service
public class UserService {
    private static final Logger logger = LogManager.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    public Optional<User> validateCredentials(String email, String password) {
        logger.trace("Checking credentials for email: {}", email); // TRACE level
        Optional<User> user = userRepository.findByEmailAndPassword(email, password);
        if (!user.isPresent()) {
            logger.error("User not found or invalid credentials for email: {}", email); // ERROR level
        }
        return user;
    }

    public User registerUser(User user) {
        logger.info("Registering new user with email: {}", user.getEmail()); // INFO level
        return userRepository.save(user);
    }

    public Optional<User> getUserById(Long userId) {
        return userRepository.findById(userId);
    }

    public User updateUser(Long userId, User updatedUser) {
        return userRepository.findById(userId).map(user -> {
            user.setFirstName(updatedUser.getFirstName());
            user.setLastName(updatedUser.getLastName());
            user.setPosition(updatedUser.getPosition());
            return userRepository.save(user);
        }).orElse(null);
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}

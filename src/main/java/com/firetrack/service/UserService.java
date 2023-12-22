package com.firetrack.service;

import com.firetrack.entity.User;
import com.firetrack.exception.UserAlreadyExistsException;
import com.firetrack.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> validateCredentials(String email, String password) {
        password = new BCryptPasswordEncoder().encode(password);
        return userRepository.findByEmailAndPassword(email, password);
    }

    public User registerUser(User user) {
        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new UserAlreadyExistsException("A user with this email already exists");
        }

        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
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

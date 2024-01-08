/**
 * This package contains classes related to security and authentication within the application.
 * Security-related classes are responsible for handling user authentication and authorization.
 */
package com.firetrack.security;

import com.firetrack.entity.User;
import com.firetrack.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Custom UserDetailsService implementation for user authentication.
 * This class loads user details by email and integrates with Spring Security for authentication.
 */
@Service
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    /**
     * Constructor for MyUserDetailsService.
     *
     * @param userRepository The UserRepository used for fetching user details.
     */
    public MyUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Load user details by email for authentication.
     *
     * @param email The email address of the user to load.
     * @return A UserDetails object representing the user, or throw UsernameNotFoundException if not found.
     * @throws UsernameNotFoundException If the user with the given email is not found.
     */
    @Override
    public UserDetails loadUserByUsername(String email) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException(email);
        }
        return user;
    }
}

package com.firetrack.service;

import com.firetrack.entity.User;
import com.firetrack.exception.UserAlreadyExistsException;
import com.firetrack.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void testValidateCredentials() {
        String email = "test@example.com";
        String password = "password";
        User mockUser = new User();
        when(userRepository.findByEmailAndPassword(email, password)).thenReturn(mockUser);

        User result = userService.validateCredentials(email, password);

        assertNotNull(result);
        verify(userRepository).findByEmailAndPassword(email, password);
    }

    @Test
    void testRegisterUser() {
        User newUser = new User();
        newUser.setEmail("new@example.com");
        when(userRepository.findByEmail(newUser.getEmail())).thenReturn(null);
        when(userRepository.save(newUser)).thenReturn(newUser);

        User result = userService.registerUser(newUser);

        assertNotNull(result);
        assertEquals("new@example.com", result.getEmail());
    }

    @Test
    void testRegisterUserThrowsException() {
        User existingUser = new User();
        existingUser.setEmail("existing@example.com");
        when(userRepository.findByEmail(existingUser.getEmail())).thenReturn(existingUser);

        assertThrows(UserAlreadyExistsException.class, () -> userService.registerUser(existingUser));
    }

    @Test
    void testUpdateUser() {
        Long userId = 1L;
        User existingUser = new User();
        existingUser.setUserId(userId);
        existingUser.setFirstName("OldFirstName");
        existingUser.setLastName("OldLastName");

        User updatedUser = new User();
        updatedUser.setFirstName("NewFirstName");
        updatedUser.setLastName("NewLastName");

        when(userRepository.findById(userId)).thenReturn(Optional.of(existingUser));
        when(userRepository.save(any(User.class))).thenReturn(updatedUser);

        User result = userService.updateUser(userId, updatedUser);

        assertNotNull(result);
        assertEquals("NewFirstName", result.getFirstName());
        assertEquals("NewLastName", result.getLastName());
        verify(userRepository).save(any(User.class));
    }

    @Test
    void testDeleteUser() {
        Long userId = 1L;
        doNothing().when(userRepository).deleteById(userId);

        userService.deleteUser(userId);

        verify(userRepository).deleteById(userId);
    }

    @Test
    void testGetUserById() {
        Long userId = 1L;
        User mockUser = new User();
        mockUser.setUserId(userId);
        when(userRepository.findById(userId)).thenReturn(Optional.of(mockUser));

        Optional<User> result = userService.getUserById(userId);

        assertTrue(result.isPresent());
        assertEquals(userId, result.get().getUserId());
        verify(userRepository).findById(userId);
    }
}

package com.firetrack.controller;

import com.firetrack.entity.User;
import com.firetrack.exception.UserAlreadyExistsException;
import com.firetrack.repository.UserRepository;
import com.firetrack.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    private MockMvc mockMvc;

    @Mock
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    public void testLoginFailure() throws Exception {
        when(userRepository.findByEmail("test@example.com")).thenReturn(null);

        mockMvc.perform(post("/api/users/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"email\":\"test@example.com\", \"password\":\"password\"}"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    public void testRegisterUser() throws Exception {
        User user = new User();
        user.setEmail("new@example.com");
        user.setPassword("password");

        when(userService.registerUser(any(User.class))).thenReturn(user);

        mockMvc.perform(post("/api/users/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"email\":\"new@example.com\", \"password\":\"password\"}"))
                .andExpect(status().isCreated());
    }

    @Test
    public void testRegisterUserFailure() throws Exception {
        when(userService.registerUser(any(User.class))).thenThrow(UserAlreadyExistsException.class);

        mockMvc.perform(post("/api/users/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"email\":\"existing@example.com\", \"password\":\"password\"}"))
                .andExpect(status().isConflict());
    }


    @Test
    public void testGetUserFound() throws Exception {
        Long userId = 1L;
        User user = new User();
        user.setUserId(userId);
        user.setEmail("test@example.com");
        user.setFirstName("John");
        user.setLastName("Doe");

        when(userService.getUserById(userId)).thenReturn(Optional.of(user));

        mockMvc.perform(get("/api/users/{userId}", userId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email").value(user.getEmail()));
    }

    @Test
    public void testGetUserNotFound() throws Exception {
        Long userId = 1L;
        when(userService.getUserById(userId)).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/users/{userId}", userId))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testDeleteUserSuccess() throws Exception {
        Long userId = 1L;
        doNothing().when(userService).deleteUser(userId);

        mockMvc.perform(delete("/api/users/{userId}", userId))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteUserNotFound() throws Exception {
        Long userId = 1L;
        doThrow(new RuntimeException("User not found")).when(userService).deleteUser(userId);

        mockMvc.perform(delete("/api/users/{userId}", userId))
                .andExpect(status().isNotFound());
    }

}

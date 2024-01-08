package com.firetrack.repository;

import com.firetrack.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    private User user;

    @BeforeEach
    public void setUp() {
        user = new User();
        user.setEmail("test@example.com");
        user.setPassword("password");
        // Set other fields of the User
        entityManager.persist(user);
        entityManager.flush();
    }

    @Test
    public void whenFindByEmail_thenReturnUser() {
        User found = userRepository.findByEmail(user.getEmail());
        assertNotNull(found);
        assertEquals(user.getEmail(), found.getEmail());
    }

    @Test
    public void whenFindByEmailAndPassword_thenReturnUser() {
        User found = userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
        assertNotNull(found);
        assertEquals(user.getEmail(), found.getEmail());
        assertEquals(user.getPassword(), found.getPassword());
    }

    @Test
    public void whenFindByEmail_thenReturnEmptyForUnknownEmail() {
        User found = userRepository.findByEmail("unknown@example.com");
        assertNull(found);
    }

    @Test
    public void whenFindByEmailAndPassword_thenReturnEmptyForWrongPassword() {
        User found = userRepository.findByEmailAndPassword(user.getEmail(), "wrongPassword");
        assertNull(found);
    }
}

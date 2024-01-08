/**
 * This package contains repository interfaces responsible for database operations related to user data.
 * Repository interfaces provide methods for accessing and manipulating user data in the database.
 */
package com.firetrack.repository;

import com.firetrack.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository interface for managing user data and related database operations.
 * UserRepository extends JpaRepository, providing CRUD (Create, Read, Update, Delete) functionality for users.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Retrieve a user by their email address.
     *
     * @param email The email address of the user to retrieve.
     * @return The user with the specified email address, or null if not found.
     */
    User findByEmail(String email);

    /**
     * Retrieve a user by their email address and password, used for authentication.
     *
     * @param email    The email address of the user to retrieve.
     * @param password The password associated with the user.
     * @return The user with the specified email and password, or null if not found.
     */
    User findByEmailAndPassword(String email, String password);
}

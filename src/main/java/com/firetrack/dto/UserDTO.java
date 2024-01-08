/**
 * This package contains Data Transfer Object (DTO) classes for representing user-related data.
 * DTOs are used to transfer user information between layers of the application.
 */
package com.firetrack.dto;

/**
 * A Data Transfer Object (DTO) representing user information.
 * UserDTO is used for transferring user-related data between different parts of the application.
 */
public class UserDTO {
    private Long userId;
    private String email;
    private String firstName;
    private String lastName;
    private String position;
    private String role;

    /**
     * Default constructor for UserDTO.
     */
    public UserDTO() {
    }

    /**
     * Constructor for UserDTO with parameters.
     *
     * @param userId    The unique identifier of the user.
     * @param email     The email address of the user.
     * @param firstName The first name of the user.
     * @param lastName  The last name of the user.
     * @param position  The position or job title of the user.
     * @param role      The role or permissions of the user.
     */
    public UserDTO(Long userId, String email, String firstName, String lastName, String position, String role) {
        this.userId = userId;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.role = role;
    }

    /**
     * Get the user's unique identifier.
     *
     * @return The user's unique identifier.
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * Set the user's unique identifier.
     *
     * @param userId The user's unique identifier.
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * Get the user's email address.
     *
     * @return The user's email address.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the user's email address.
     *
     * @param email The user's email address.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get the user's first name.
     *
     * @return The user's first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set the user's first name.
     *
     * @param firstName The user's first name.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Get the user's last name.
     *
     * @return The user's last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set the user's last name.
     *
     * @param lastName The user's last name.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Get the user's position or job title.
     *
     * @return The user's position or job title.
     */
    public String getPosition() {
        return position;
    }

    /**
     * Set the user's position or job title.
     *
     * @param position The user's position or job title.
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * Get the user's role or permissions.
     *
     * @return The user's role or permissions.
     */
    public String getRole() {
        return role;
    }

    /**
     * Set the user's role or permissions.
     *
     * @param role The user's role or permissions.
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "UserDTO{" +
                "userId=" + userId +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", position='" + position + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}

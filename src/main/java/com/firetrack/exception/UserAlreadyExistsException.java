/**
 * This package contains exception classes representing custom application-specific exceptions.
 * Custom exceptions are used to handle specific error scenarios within the application.
 */
package com.firetrack.exception;

/**
 * An exception class indicating that a user with the same email address already exists.
 * This exception is thrown when attempting to register a user with an email that is already in use.
 */
public class UserAlreadyExistsException extends RuntimeException {

    /**
     * Constructs a new UserAlreadyExistsException with no detail message.
     */
    public UserAlreadyExistsException() {
        super();
    }

    /**
     * Constructs a new UserAlreadyExistsException with the specified detail message.
     *
     * @param message The detail message explaining the exception.
     */
    public UserAlreadyExistsException(String message) {
        super(message);
    }

    /**
     * Constructs a new UserAlreadyExistsException with the specified detail message and cause.
     *
     * @param message The detail message explaining the exception.
     * @param cause   The cause of the exception.
     */
    public UserAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new UserAlreadyExistsException with the specified cause and no detail message.
     *
     * @param cause The cause of the exception.
     */
    public UserAlreadyExistsException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs a new UserAlreadyExistsException with the specified detail message, cause, suppression status,
     * and writable stack trace.
     *
     * @param message            The detail message explaining the exception.
     * @param cause              The cause of the exception.
     * @param enableSuppression  Whether or not suppression is enabled or disabled.
     * @param writableStackTrace Whether the stack trace should be writable.
     */
    protected UserAlreadyExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

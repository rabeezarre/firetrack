/**
 * This package contains repository interfaces responsible for database operations related to alerts.
 * Repository interfaces provide methods for accessing and manipulating alert data in the database.
 */
package com.firetrack.repository;

import com.firetrack.entity.Alert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for managing alert data and related database operations.
 * AlertRepository extends JpaRepository, providing CRUD (Create, Read, Update, Delete) functionality for alerts.
 */
@Repository
public interface AlertRepository extends JpaRepository<Alert, Long> {

    /**
     * Retrieve a list of alerts associated with a specific tracking point.
     *
     * @param pointId The ID of the tracking point for which alerts are retrieved.
     * @return A list of alerts associated with the specified tracking point.
     */
    List<Alert> findByPointId(Long pointId);

    /**
     * Retrieve a list of alerts with a specific status.
     *
     * @param status The status of alerts to retrieve (e.g., "active" for active alerts).
     * @return A list of alerts with the specified status.
     */
    List<Alert> findByStatus(String status);
}

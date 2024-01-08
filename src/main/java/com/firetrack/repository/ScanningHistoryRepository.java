/**
 * This package contains repository interfaces responsible for database operations related to scanning history.
 * Repository interfaces provide methods for accessing and manipulating scanning history data in the database.
 */
package com.firetrack.repository;

import com.firetrack.entity.ScanningHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repository interface for managing scanning history data and related database operations.
 * ScanningHistoryRepository extends JpaRepository, providing CRUD (Create, Read, Update, Delete) functionality for scanning history.
 */
public interface ScanningHistoryRepository extends JpaRepository<ScanningHistory, Long> {

    /**
     * Retrieve a list of scanning history records associated with a specific tracking point.
     *
     * @param pointId The ID of the tracking point for which scanning history records are retrieved.
     * @return A list of scanning history records associated with the specified tracking point.
     */
    List<ScanningHistory> findByPointId(Long pointId);

    /**
     * Retrieve a list of scanning history records associated with a specific user.
     *
     * @param userId The ID of the user for which scanning history records are retrieved.
     * @return A list of scanning history records associated with the specified user.
     */
    List<ScanningHistory> findByUserId(Long userId);
}

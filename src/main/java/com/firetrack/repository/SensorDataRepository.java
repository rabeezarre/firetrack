/**
 * This package contains repository interfaces responsible for database operations related to sensor data.
 * Repository interfaces provide methods for accessing and manipulating sensor data in the database.
 */
package com.firetrack.repository;

import com.firetrack.entity.SensorData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for managing sensor data and related database operations.
 * SensorDataRepository extends JpaRepository, providing CRUD (Create, Read, Update, Delete) functionality for sensor data.
 */
@Repository
public interface SensorDataRepository extends JpaRepository<SensorData, Long> {

    /**
     * Retrieve a list of sensor data records associated with a specific tracking point.
     *
     * @param pointId The ID of the tracking point for which sensor data records are retrieved.
     * @return A list of sensor data records associated with the specified tracking point.
     */
    List<SensorData> findByPointId(Long pointId);
}

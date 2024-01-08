/**
 * This package contains repository interfaces responsible for database operations related to tracking points.
 * Repository interfaces provide methods for accessing and manipulating tracking point data in the database.
 */
package com.firetrack.repository;

import com.firetrack.entity.TrackingPoint;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for managing tracking point data and related database operations.
 * TrackingPointRepository extends JpaRepository, providing CRUD (Create, Read, Update, Delete) functionality for tracking points.
 */
public interface TrackingPointRepository extends JpaRepository<TrackingPoint, Long> {
}

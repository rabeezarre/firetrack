/**
 * This package contains service classes responsible for handling business logic related to tracking points.
 * Service classes act as an intermediary between controllers and repositories, providing tracking point-related functionality.
 */
package com.firetrack.service;

import com.firetrack.entity.TrackingPoint;
import com.firetrack.repository.TrackingPointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for managing tracking points and related operations.
 * TrackingPointService provides methods for retrieving, creating, updating, and deleting tracking points.
 */
@Service
public class TrackingPointService {

    @Autowired
    private TrackingPointRepository trackingPointRepository;

    /**
     * Retrieve all tracking points stored in the database.
     *
     * @return A list of all tracking points.
     */
    public List<TrackingPoint> getAllTrackingPoints() {
        return trackingPointRepository.findAll();
    }

    /**
     * Retrieve a tracking point by its unique identifier (pointId).
     *
     * @param pointId The unique identifier of the tracking point to retrieve.
     * @return The tracking point with the specified pointId, or null if not found.
     */
    public TrackingPoint getTrackingPointById(Long pointId) {
        return trackingPointRepository.findById(pointId).orElse(null);
    }

    /**
     * Create or update a tracking point in the database.
     *
     * @param trackingPoint The tracking point object to be created or updated.
     * @return The created or updated tracking point with updated details.
     */
    public TrackingPoint saveTrackingPoint(TrackingPoint trackingPoint) {
        return trackingPointRepository.save(trackingPoint);
    }

    /**
     * Update the details of a tracking point with the given pointId.
     *
     * @param pointId             The unique identifier of the tracking point to be updated.
     * @param trackingPointDetails The updated tracking point details, including latitude, longitude, and status.
     * @return The updated tracking point with the modified details.
     */
    public TrackingPoint updateTrackingPoint(Long pointId, TrackingPoint trackingPointDetails) {
        return trackingPointRepository.findById(pointId).map(trackingPoint -> {
            trackingPoint.setLatitude(trackingPointDetails.getLatitude());
            trackingPoint.setLongitude(trackingPointDetails.getLongitude());
            trackingPoint.setStatus(trackingPointDetails.getStatus());
            return trackingPointRepository.save(trackingPoint);
        }).orElseGet(() -> {
            trackingPointDetails.setPointId(pointId);
            return trackingPointRepository.save(trackingPointDetails);
        });
    }

    /**
     * Delete a tracking point by its unique identifier (pointId).
     *
     * @param pointId The unique identifier of the tracking point to be deleted.
     */
    public void deleteTrackingPoint(Long pointId) {
        trackingPointRepository.deleteById(pointId);
    }
}

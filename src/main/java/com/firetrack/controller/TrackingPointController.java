/**
 * This package contains controller classes responsible for managing tracking points.
 * Controllers handle incoming HTTP requests and interact with the corresponding service methods.
 */
package com.firetrack.controller;

import com.firetrack.entity.TrackingPoint;
import com.firetrack.service.TrackingPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class for managing tracking points.
 */
@RestController
@RequestMapping("/api/trackingPoints")
public class TrackingPointController {

    @Autowired
    private TrackingPointService trackingPointService;

    /**
     * Retrieves all tracking points.
     *
     * @return A ResponseEntity containing a list of TrackingPoint objects.
     */
    @GetMapping
    public ResponseEntity<List<TrackingPoint>> getAllTrackingPoints() {
        return ResponseEntity.ok(trackingPointService.getAllTrackingPoints());
    }

    /**
     * Retrieves a tracking point by its ID.
     *
     * @param pointId The ID of the tracking point to retrieve.
     * @return A ResponseEntity containing the TrackingPoint object if found, or a not found response if not found.
     */
    @GetMapping("/{pointId}")
    public ResponseEntity<TrackingPoint> getTrackingPointById(@PathVariable Long pointId) {
        TrackingPoint trackingPoint = trackingPointService.getTrackingPointById(pointId);
        if (trackingPoint == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(trackingPoint);
    }

    /**
     * Creates a new tracking point.
     *
     * @param trackingPoint The TrackingPoint object to be created.
     * @return A ResponseEntity containing the newly created TrackingPoint object.
     */
    @PostMapping
    public ResponseEntity<TrackingPoint> createTrackingPoint(@RequestBody TrackingPoint trackingPoint) {
        return ResponseEntity.ok(trackingPointService.saveTrackingPoint(trackingPoint));
    }

    /**
     * Deletes a tracking point by its ID.
     *
     * @param pointId The ID of the tracking point to delete.
     * @return A ResponseEntity indicating success or not found response if the tracking point does not exist.
     */
    @DeleteMapping("/{pointId}")
    public ResponseEntity<Void> deleteTrackingPoint(@PathVariable Long pointId) {
        trackingPointService.deleteTrackingPoint(pointId);
        return ResponseEntity.ok().build();
    }

    /**
     * Updates a tracking point by its ID.
     *
     * @param pointId       The ID of the tracking point to update.
     * @param trackingPoint The updated TrackingPoint object.
     * @return A ResponseEntity containing the updated TrackingPoint object if found, or a not found response if not found.
     */
    @PutMapping("/{pointId}")
    public ResponseEntity<TrackingPoint> updateTrackingPoint(@PathVariable Long pointId, @RequestBody TrackingPoint trackingPoint) {
        TrackingPoint updatedTrackingPoint = trackingPointService.updateTrackingPoint(pointId, trackingPoint);
        if (updatedTrackingPoint == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedTrackingPoint);
    }
}

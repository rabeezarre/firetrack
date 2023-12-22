package com.firetrack.controller;

import com.firetrack.entity.TrackingPoint;
import com.firetrack.service.TrackingPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trackingPoints")
public class TrackingPointController {

    @Autowired
    private TrackingPointService trackingPointService;

    @GetMapping
    public ResponseEntity<List<TrackingPoint>> getAllTrackingPoints() {
        return ResponseEntity.ok(trackingPointService.getAllTrackingPoints());
    }

    @GetMapping("/{pointId}")
    public ResponseEntity<TrackingPoint> getTrackingPointById(@PathVariable Long pointId) {
        TrackingPoint trackingPoint = trackingPointService.getTrackingPointById(pointId);
        if (trackingPoint == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(trackingPoint);
    }

    @PostMapping
    public ResponseEntity<TrackingPoint> createTrackingPoint(@RequestBody TrackingPoint trackingPoint) {
        return ResponseEntity.ok(trackingPointService.saveTrackingPoint(trackingPoint));
    }

    @DeleteMapping("/{pointId}")
    public ResponseEntity<Void> deleteTrackingPoint(@PathVariable Long pointId) {
        trackingPointService.deleteTrackingPoint(pointId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{pointId}")
    public ResponseEntity<TrackingPoint> updateTrackingPoint(@PathVariable Long pointId, @RequestBody TrackingPoint trackingPoint) {
        TrackingPoint updatedTrackingPoint = trackingPointService.updateTrackingPoint(pointId, trackingPoint);
        if (updatedTrackingPoint == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedTrackingPoint);
    }
}

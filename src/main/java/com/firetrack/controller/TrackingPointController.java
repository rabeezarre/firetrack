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
        List<TrackingPoint> trackingPoints = trackingPointService.getAllTrackingPoints();
        return ResponseEntity.ok(trackingPoints);
    }

    @PutMapping("/{pointId}")
    public ResponseEntity<TrackingPoint> updateTrackingPoint(@PathVariable Long pointId, @RequestBody TrackingPoint trackingPoint) {
        TrackingPoint updatedTrackingPoint = trackingPointService.updateTrackingPoint(pointId, trackingPoint);
        return ResponseEntity.ok(updatedTrackingPoint);
    }
}

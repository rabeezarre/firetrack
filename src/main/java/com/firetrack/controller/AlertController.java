package com.firetrack.controller;

import com.firetrack.entity.Alert;
import com.firetrack.service.AlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class for managing alerts in the Firetrack system.
 */
@RestController
@RequestMapping("/api/alerts")
public class AlertController {

    @Autowired
    private AlertService alertService;

    /**
     * Retrieves all alerts.
     *
     * @return A ResponseEntity containing a list of Alert objects.
     */
    @GetMapping
    public ResponseEntity<List<Alert>> getAllAlerts() {
        List<Alert> alerts = alertService.getAllAlerts();
        return ResponseEntity.ok(alerts);
    }

    /**
     * Creates a new alert.
     *
     * @param alert The Alert object to be created.
     * @return A ResponseEntity containing the newly created Alert object.
     */
    @PostMapping
    public ResponseEntity<Alert> createAlert(@RequestBody Alert alert) {
        Alert newAlert = alertService.createAlert(alert);
        return ResponseEntity.ok(newAlert);
    }

    /**
     * Updates the status of a specific alert.
     *
     * @param alertId The ID of the alert to be updated.
     * @param alert   The updated Alert object.
     * @return A ResponseEntity containing the updated Alert object.
     */
    @PutMapping("/{alertId}")
    public ResponseEntity<Alert> updateAlertStatus(@PathVariable Long alertId, @RequestBody Alert alert) {
        Alert updatedAlert = alertService.updateAlertStatus(alertId, alert);
        return ResponseEntity.ok(updatedAlert);
    }

    /**
     * Retrieves alerts associated with a specific tracking point.
     *
     * @param pointId The ID of the tracking point.
     * @return A ResponseEntity containing a list of Alert objects.
     */
    @GetMapping("/trackingPoint/{pointId}")
    public ResponseEntity<List<Alert>> getAlertsByTrackingPoint(@PathVariable Long pointId) {
        List<Alert> alerts = alertService.getAlertsByTrackingPoint(pointId);
        if (alerts.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(alerts);
    }

    /**
     * Checks if there are any active alerts.
     *
     * @return A ResponseEntity containing a Boolean indicating whether there are active alerts.
     */
    @GetMapping("/active")
    public ResponseEntity<Boolean> checkActiveAlerts() {
        boolean hasActiveAlerts = alertService.hasActiveAlerts();
        return ResponseEntity.ok(hasActiveAlerts);
    }
}

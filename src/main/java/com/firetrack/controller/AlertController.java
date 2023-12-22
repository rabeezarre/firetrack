package com.firetrack.controller;

import com.firetrack.entity.Alert;
import com.firetrack.service.AlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alerts")
public class AlertController {

    @Autowired
    private AlertService alertService;

    @GetMapping
    public ResponseEntity<List<Alert>> getAllAlerts() {
        List<Alert> alerts = alertService.getAllAlerts();
        return ResponseEntity.ok(alerts);
    }

    @PostMapping
    public ResponseEntity<Alert> createAlert(@RequestBody Alert alert) {
        Alert newAlert = alertService.createAlert(alert);
        return ResponseEntity.ok(newAlert);
    }

    @PutMapping("/{alertId}")
    public ResponseEntity<Alert> updateAlertStatus(@PathVariable Long alertId, @RequestBody Alert alert) {
        Alert updatedAlert = alertService.updateAlertStatus(alertId, alert);
        return ResponseEntity.ok(updatedAlert);
    }

    @GetMapping("/trackingPoint/{pointId}")
    public ResponseEntity<List<Alert>> getAlertsByTrackingPoint(@PathVariable Long pointId) {
        List<Alert> alerts = alertService.getAlertsByTrackingPoint(pointId);
        if (alerts.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(alerts);
    }

    @GetMapping("/active")
    public ResponseEntity<Boolean> checkActiveAlerts() {
        boolean hasActiveAlerts = alertService.hasActiveAlerts();
        return ResponseEntity.ok(hasActiveAlerts);
    }
}

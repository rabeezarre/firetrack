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

    @PutMapping("/{alertId}")
    public ResponseEntity<Alert> updateAlertStatus(@PathVariable Long alertId, @RequestBody Alert alert) {
        Alert updatedAlert = alertService.updateAlertStatus(alertId, alert);
        return ResponseEntity.ok(updatedAlert);
    }
}

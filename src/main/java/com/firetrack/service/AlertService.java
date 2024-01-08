/**
 * This package contains service classes responsible for handling business logic related to alerts.
 * Service classes act as an intermediary between controllers and repositories, providing alert-related functionality.
 */
package com.firetrack.service;

import com.firetrack.entity.Alert;
import com.firetrack.repository.AlertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for managing alerts and related operations.
 * AlertService provides methods for retrieving, creating, updating, and querying alerts.
 */
@Service
public class AlertService {

    @Autowired
    private AlertRepository alertRepository;

    /**
     * Retrieve all alerts stored in the database.
     *
     * @return A list of all alerts.
     */
    public List<Alert> getAllAlerts() {
        return alertRepository.findAll();
    }

    /**
     * Create a new alert and store it in the database.
     *
     * @param alert The alert object to be created.
     * @return The created alert with updated details.
     */
    public Alert createAlert(Alert alert) {
        return alertRepository.save(alert);
    }

    /**
     * Update the status of an alert with the given alertId.
     *
     * @param alertId      The unique identifier of the alert to be updated.
     * @param alertDetails The updated alert details including status and timestamp.
     * @return The updated alert with the modified details.
     */
    public Alert updateAlertStatus(Long alertId, Alert alertDetails) {
        return alertRepository.findById(alertId).map(alert -> {
            alert.setStatus(alertDetails.getStatus());
            alert.setTimestamp(alertDetails.getTimestamp());
            return alertRepository.save(alert);
        }).orElseGet(() -> {
            alertDetails.setAlertId(alertId);
            return alertRepository.save(alertDetails);
        });
    }

    /**
     * Retrieve all alerts associated with a specific tracking point.
     *
     * @param pointId The ID of the tracking point for which alerts are retrieved.
     * @return A list of alerts associated with the specified tracking point.
     */
    public List<Alert> getAlertsByTrackingPoint(Long pointId) {
        return alertRepository.findByPointId(pointId);
    }

    /**
     * Check if there are any active alerts in the database.
     *
     * @return true if there are active alerts, false otherwise.
     */
    public boolean hasActiveAlerts() {
        List<Alert> activeAlerts = alertRepository.findByStatus("active"); // Assuming "active" is the status for active alerts
        return !activeAlerts.isEmpty();
    }
}

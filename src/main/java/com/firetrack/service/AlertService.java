package com.firetrack.service;

import com.firetrack.entity.Alert;
import com.firetrack.repository.AlertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AlertService {

    @Autowired
    private AlertRepository alertRepository;

    public List<Alert> getAllAlerts() {
        return alertRepository.findAll();
    }

    public Alert createAlert(Alert alert) {
        return alertRepository.save(alert);
    }

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

    public List<Alert> getAlertsByTrackingPoint(Long pointId) {
        return alertRepository.findByPointId(pointId);
    }

    public boolean hasActiveAlerts() {
        List<Alert> activeAlerts = alertRepository.findByStatus("active"); // Assuming "active" is the status for active alerts
        return !activeAlerts.isEmpty();
    }
}

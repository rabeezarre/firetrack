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
}

package com.firetrack.service;

import com.firetrack.entity.Alert;
import com.firetrack.repository.AlertRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AlertServiceTest {

    @Mock
    private AlertRepository alertRepository;

    @InjectMocks
    private AlertService alertService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllAlertsTest() {
        Alert alert1 = new Alert();
        Alert alert2 = new Alert();
        when(alertRepository.findAll()).thenReturn(Arrays.asList(alert1, alert2));

        List<Alert> alerts = alertService.getAllAlerts();

        assertNotNull(alerts);
        assertEquals(2, alerts.size());
    }

    @Test
    void createAlertTest() {
        Alert alert = new Alert();
        when(alertRepository.save(any(Alert.class))).thenReturn(alert);

        Alert createdAlert = alertService.createAlert(new Alert());

        assertNotNull(createdAlert);
    }

    @Test
    void updateAlertStatusTest() {
        Long alertId = 1L;
        Alert existingAlert = new Alert();
        existingAlert.setAlertId(alertId);
        existingAlert.setStatus("old status");

        Alert updatedDetails = new Alert();
        updatedDetails.setStatus("new status");

        when(alertRepository.findById(alertId)).thenReturn(Optional.of(existingAlert));
        when(alertRepository.save(any(Alert.class))).thenReturn(updatedDetails);

        Alert updatedAlert = alertService.updateAlertStatus(alertId, updatedDetails);

        assertNotNull(updatedAlert);
        assertEquals("new status", updatedAlert.getStatus());
    }

    @Test
    void getAlertsByTrackingPointTest() {
        Long pointId = 1L;
        Alert alert1 = new Alert();
        Alert alert2 = new Alert();
        List<Alert> alerts = Arrays.asList(alert1, alert2);

        when(alertRepository.findByPointId(pointId)).thenReturn(alerts);

        List<Alert> resultAlerts = alertService.getAlertsByTrackingPoint(pointId);

        assertNotNull(resultAlerts);
        assertEquals(2, resultAlerts.size());
    }

    @Test
    void hasActiveAlertsTest() {
        when(alertRepository.findByStatus("active")).thenReturn(List.of(new Alert()));

        boolean hasActive = alertService.hasActiveAlerts();

        assertTrue(hasActive);
    }


}

package com.firetrack.controller;

import com.firetrack.entity.Alert;
import com.firetrack.service.AlertService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
public class AlertControllerTest {

    private MockMvc mockMvc;

    @Mock
    private AlertService alertService;

    @InjectMocks
    private AlertController alertController;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(alertController).build();
    }

    @Test
    public void testGetAllAlerts() throws Exception {
        List<Alert> alerts = Arrays.asList(new Alert(), new Alert());
        when(alertService.getAllAlerts()).thenReturn(alerts);

        mockMvc.perform(get("/api/alerts"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testCreateAlert() throws Exception {
        Alert newAlert = new Alert();
        newAlert.setAlertId(1L);
        when(alertService.createAlert(any(Alert.class))).thenReturn(newAlert);

        mockMvc.perform(post("/api/alerts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"pointId\": 1, \"alertType\": \"fire\", \"timestamp\": \"2021-01-01T10:00:00\", \"status\": \"active\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.alertId").value(1L));
    }

    @Test
    public void testUpdateAlertStatus() throws Exception {
        Long alertId = 1L;
        Alert updatedAlert = new Alert();
        updatedAlert.setAlertId(alertId);
        when(alertService.updateAlertStatus(eq(alertId), any(Alert.class))).thenReturn(updatedAlert);

        mockMvc.perform(put("/api/alerts/" + alertId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"status\": \"resolved\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.alertId").value(alertId));
    }

    @Test
    public void testGetAlertsByTrackingPoint() throws Exception {
        Long pointId = 1L;
        List<Alert> alerts = Arrays.asList(new Alert(), new Alert());
        when(alertService.getAlertsByTrackingPoint(pointId)).thenReturn(alerts);

        mockMvc.perform(get("/api/alerts/trackingPoint/" + pointId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testCheckActiveAlerts() throws Exception {
        when(alertService.hasActiveAlerts()).thenReturn(true);

        mockMvc.perform(get("/api/alerts/active"))
                .andExpect(status().isOk())
                .andExpect(content().string("true"));
    }
}

package com.firetrack.controller;

import com.firetrack.entity.SensorData;
import com.firetrack.service.SensorDataService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
public class SensorDataControllerTest {

    private MockMvc mockMvc;

    @Mock
    private SensorDataService sensorDataService;

    @InjectMocks
    private SensorDataController sensorDataController;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(sensorDataController).build();
    }

    @Test
    public void testGetSensorDataByPointWithExistingId() throws Exception {
        Long existingPointId = 1L;
        SensorData sensorData = new SensorData(1L, existingPointId, LocalDateTime.now(), 25.0, 50.0, 1013.25, 150.0, 0.5, 60.0, "red");
        when(sensorDataService.getSensorDataByPointId(existingPointId)).thenReturn(List.of(sensorData));

        mockMvc.perform(get("/api/sensorData/{pointId}", existingPointId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].dataId").value(sensorData.getDataId()));
    }

    @Test
    public void testGetSensorDataByPointWithNonExistingId() throws Exception {
        Long nonExistingPointId = 2L;
        when(sensorDataService.getSensorDataByPointId(nonExistingPointId)).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/api/sensorData/{pointId}", nonExistingPointId))
                .andExpect(status().isNotFound())
                .andExpect(content().string("No sensor data found for pointId: " + nonExistingPointId));
    }

    @Test
    public void testAddSensorDataWithValidData() throws Exception {
        SensorData newSensorData = new SensorData(null, 1L, LocalDateTime.now(), 25.0, 50.0, 1013.25, 150.0, 0.5, 60.0, "red");
        when(sensorDataService.addSensorData(any(SensorData.class))).thenReturn(newSensorData);

        mockMvc.perform(post("/api/sensorData")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"pointId\":1,\"timestamp\":\"2024-01-01T12:00:00\",\"temperature\":25.0,\"humidity\":50.0,\"pressure\":1013.25,\"altitude\":150.0,\"magnetometer\":0.5,\"sound\":60.0,\"colour\":\"red\"}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.pointId").value(newSensorData.getPointId()));
    }

    @Test
    public void testAddSensorDataWithNullFields() throws Exception {
        mockMvc.perform(post("/api/sensorData")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}")) // Empty JSON to simulate null fields
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testAddSensorDataExceptionScenario() throws Exception {
        when(sensorDataService.addSensorData(any(SensorData.class))).thenThrow(new RuntimeException("Test exception"));

        mockMvc.perform(post("/api/sensorData")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"pointId\":1,\"timestamp\":\"2024-01-01T12:00:00\",\"temperature\":25.0,\"humidity\":50.0,\"pressure\":1013.25,\"altitude\":150.0,\"magnetometer\":0.5,\"sound\":60.0,\"colour\":\"red\"}"))
                .andExpect(status().isInternalServerError());
    }

}

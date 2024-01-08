package com.firetrack.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.firetrack.entity.TrackingPoint;
import com.firetrack.service.TrackingPointService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class TrackingPointControllerTest {

    private MockMvc mockMvc;

    @Mock
    private TrackingPointService trackingPointService;

    @InjectMocks
    private TrackingPointController trackingPointController;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(trackingPointController).build();
    }

    @Test
    public void testGetAllTrackingPoints() throws Exception {
        List<TrackingPoint> trackingPoints = List.of(new TrackingPoint(1L, 40.7128, -74.0060, "Active"));
        when(trackingPointService.getAllTrackingPoints()).thenReturn(trackingPoints);

        mockMvc.perform(get("/api/trackingPoints"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].pointId").value(trackingPoints.get(0).getPointId()));
    }

    @Test
    public void testGetTrackingPointByIdFound() throws Exception {
        TrackingPoint trackingPoint = new TrackingPoint(1L, 40.7128, -74.0060, "Active");
        when(trackingPointService.getTrackingPointById(1L)).thenReturn(trackingPoint);

        mockMvc.perform(get("/api/trackingPoints/{pointId}", 1L))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.pointId").value(trackingPoint.getPointId()));
    }

    @Test
    public void testGetTrackingPointByIdNotFound() throws Exception {
        when(trackingPointService.getTrackingPointById(anyLong())).thenReturn(null);

        mockMvc.perform(get("/api/trackingPoints/{pointId}", 1L))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testCreateTrackingPoint() throws Exception {
        TrackingPoint trackingPoint = new TrackingPoint(1L, 40.7128, -74.0060, "Active");
        when(trackingPointService.saveTrackingPoint(any(TrackingPoint.class))).thenReturn(trackingPoint);

        ObjectMapper objectMapper = new ObjectMapper();
        String trackingPointJson = objectMapper.writeValueAsString(trackingPoint);

        mockMvc.perform(post("/api/trackingPoints")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(trackingPointJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.pointId").value(trackingPoint.getPointId()));
    }

    @Test
    public void testDeleteTrackingPoint() throws Exception {
        doNothing().when(trackingPointService).deleteTrackingPoint(anyLong());

        mockMvc.perform(delete("/api/trackingPoints/{pointId}", 1L))
                .andExpect(status().isOk());
    }

    @Test
    public void testUpdateTrackingPointFound() throws Exception {
        TrackingPoint updatedTrackingPoint = new TrackingPoint(1L, 40.7130, -74.0070, "Updated");
        when(trackingPointService.updateTrackingPoint(eq(1L), any(TrackingPoint.class))).thenReturn(updatedTrackingPoint);

        ObjectMapper objectMapper = new ObjectMapper();
        String trackingPointJson = objectMapper.writeValueAsString(updatedTrackingPoint);

        mockMvc.perform(put("/api/trackingPoints/{pointId}", 1L)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(trackingPointJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(updatedTrackingPoint.getStatus()));
    }

    @Test
    public void testUpdateTrackingPointNotFound() throws Exception {
        when(trackingPointService.updateTrackingPoint(eq(1L), any(TrackingPoint.class))).thenReturn(null);

        ObjectMapper objectMapper = new ObjectMapper();
        String trackingPointJson = objectMapper.writeValueAsString(new TrackingPoint());

        mockMvc.perform(put("/api/trackingPoints/{pointId}", 1L)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(trackingPointJson))
                .andExpect(status().isNotFound());
    }
}

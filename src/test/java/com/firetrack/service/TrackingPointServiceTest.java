package com.firetrack.service;

import com.firetrack.entity.TrackingPoint;
import com.firetrack.repository.TrackingPointRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TrackingPointServiceTest {

    @Mock
    private TrackingPointRepository trackingPointRepository;

    @InjectMocks
    private TrackingPointService trackingPointService;

    @Test
    void getAllTrackingPointsTest() {
        TrackingPoint point1 = new TrackingPoint();
        TrackingPoint point2 = new TrackingPoint();
        when(trackingPointRepository.findAll()).thenReturn(Arrays.asList(point1, point2));

        List<TrackingPoint> points = trackingPointService.getAllTrackingPoints();

        assertNotNull(points);
        assertEquals(2, points.size());
    }

    @Test
    void getTrackingPointByIdTest() {
        Long pointId = 1L;
        TrackingPoint point = new TrackingPoint();
        when(trackingPointRepository.findById(pointId)).thenReturn(Optional.of(point));

        TrackingPoint result = trackingPointService.getTrackingPointById(pointId);

        assertNotNull(result);
    }

    @Test
    void saveTrackingPointTest() {
        TrackingPoint newPoint = new TrackingPoint();
        when(trackingPointRepository.save(newPoint)).thenReturn(newPoint);

        TrackingPoint savedPoint = trackingPointService.saveTrackingPoint(newPoint);

        assertNotNull(savedPoint);
    }

    @Test
    void updateTrackingPointTest() {
        Long pointId = 1L;
        TrackingPoint existingPoint = new TrackingPoint();
        TrackingPoint updatedDetails = new TrackingPoint();
        updatedDetails.setLatitude(10.0);
        updatedDetails.setLongitude(20.0);

        when(trackingPointRepository.findById(pointId)).thenReturn(Optional.of(existingPoint));
        when(trackingPointRepository.save(any(TrackingPoint.class))).thenReturn(updatedDetails);

        TrackingPoint updatedPoint = trackingPointService.updateTrackingPoint(pointId, updatedDetails);

        assertNotNull(updatedPoint);
        assertEquals(10.0, updatedPoint.getLatitude());
        assertEquals(20.0, updatedPoint.getLongitude());
    }

    @Test
    void deleteTrackingPointTest() {
        Long pointId = 1L;
        doNothing().when(trackingPointRepository).deleteById(pointId);

        trackingPointService.deleteTrackingPoint(pointId);

        verify(trackingPointRepository).deleteById(pointId);
    }
}

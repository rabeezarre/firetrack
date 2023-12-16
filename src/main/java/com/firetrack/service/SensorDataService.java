package com.firetrack.service;

import com.firetrack.entity.SensorData;
import com.firetrack.entity.TrackingPoint;
import com.firetrack.repository.SensorDataRepository;
import com.firetrack.repository.TrackingPointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SensorDataService {

    @Autowired
    private SensorDataRepository sensorDataRepository;

    @Autowired
    private TrackingPointRepository trackingPointRepository;

    public List<SensorData> getSensorDataByTrackingPoint(Long pointId) {
        TrackingPoint trackingPoint = trackingPointRepository.findById(pointId).orElse(null);
        return sensorDataRepository.findByTrackingPoint(trackingPoint);
    }

    public SensorData addSensorData(SensorData sensorData) {
        return sensorDataRepository.save(sensorData);
    }
}

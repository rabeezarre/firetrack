package com.firetrack.service;

import com.firetrack.entity.SensorData;
import com.firetrack.repository.SensorDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SensorDataService {

    @Autowired
    private SensorDataRepository sensorDataRepository;

    public List<SensorData> getSensorDataByPointId(Long pointId) {
        return sensorDataRepository.findByPointId(pointId);
    }

    public SensorData addSensorData(SensorData sensorData) {
        return sensorDataRepository.save(sensorData);
    }
}

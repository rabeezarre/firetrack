/**
 * This package contains service classes responsible for handling business logic related to sensor data.
 * Service classes act as an intermediary between controllers and repositories, providing sensor data-related functionality.
 */
package com.firetrack.service;

import com.firetrack.entity.SensorData;
import com.firetrack.repository.SensorDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for managing sensor data and related operations.
 * SensorDataService provides methods for retrieving sensor data by point ID and adding new sensor data.
 */
@Service
public class SensorDataService {

    @Autowired
    private SensorDataRepository sensorDataRepository;

    /**
     * Retrieve sensor data records associated with a specific tracking point.
     *
     * @param pointId The ID of the tracking point for which sensor data records are retrieved.
     * @return A list of sensor data records associated with the specified tracking point.
     */
    public List<SensorData> getSensorDataByPointId(Long pointId) {
        return sensorDataRepository.findByPointId(pointId);
    }

    /**
     * Add a new sensor data record to the database.
     *
     * @param sensorData The sensor data record to be added.
     * @return The added sensor data record with updated details.
     */
    public SensorData addSensorData(SensorData sensorData) {
        return sensorDataRepository.save(sensorData);
    }
}

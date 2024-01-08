/**
 * This package contains controller classes responsible for managing sensor data operations.
 * Controllers handle incoming HTTP requests and interact with the corresponding service methods.
 */
package com.firetrack.controller;

import com.firetrack.entity.SensorData;
import com.firetrack.service.SensorDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class for managing sensor data operations.
 */
@RestController
@RequestMapping("/api/sensorData")
public class SensorDataController {

    private final SensorDataService sensorDataService;
    private static final Logger logger = LoggerFactory.getLogger(SensorDataController.class);

    /**
     * Constructor for SensorDataController.
     *
     * @param sensorDataService The SensorDataService to be injected.
     */
    public SensorDataController(SensorDataService sensorDataService) {
        this.sensorDataService = sensorDataService;
    }

    /**
     * Retrieves sensor data records by a specific point ID.
     *
     * @param pointId The ID of the sensor data point.
     * @return A ResponseEntity containing a list of SensorData objects if found, or an error message if not found or an error occurs.
     */
    @GetMapping("/{pointId}")
    public ResponseEntity<?> getSensorDataByPoint(@PathVariable Long pointId) {
        try {
            List<SensorData> sensorDataList = sensorDataService.getSensorDataByPointId(pointId);
            if (sensorDataList.isEmpty()) {
                logger.info("No sensor data found for pointId: {}", pointId);
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("No sensor data found for pointId: " + pointId);
            }
            return ResponseEntity.ok(sensorDataList);
        } catch (Exception e) {
            logger.error("Error retrieving sensor data for pointId: {}", pointId, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error retrieving sensor data for the requested pointId.");
        }
    }

    /**
     * Adds a new sensor data record.
     *
     * @param sensorData The SensorData object to be added.
     * @return A ResponseEntity containing the newly added SensorData object if successful, or an error message if validation fails or an error occurs.
     */
    @PostMapping
    public ResponseEntity<?> addSensorData(@RequestBody SensorData sensorData) {
        try {
            if (!isSensorDataValid(sensorData)) {
                logger.error("Invalid sensor data received");
                return ResponseEntity.badRequest()
                        .body("Invalid sensor data");
            }

            SensorData addedSensorData = sensorDataService.addSensorData(sensorData);
            return ResponseEntity.status(HttpStatus.CREATED).body(addedSensorData);
        } catch (Exception e) {
            logger.error("Error adding sensor data", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Internal server error occurred while adding sensor data.");
        }
    }

    /**
     * Validates the SensorData object.
     *
     * @param sensorData The SensorData object to be validated.
     * @return True if the sensor data is valid; false otherwise.
     */
    private boolean isSensorDataValid(SensorData sensorData) {
        if (sensorData.getPointId() == null) {
            logger.info("SensorData Validation Failed: pointId is null");
            return false;
        }

        if (sensorData.getTimestamp() == null) {
            logger.info("SensorData Validation Failed: timestamp is null");
            return false;
        }

        if (sensorData.getTemperature() == null || sensorData.getTemperature() < -273.15) {
            logger.info("SensorData Validation Failed: Invalid temperature");
            return false;
        }

        return true;
    }
}

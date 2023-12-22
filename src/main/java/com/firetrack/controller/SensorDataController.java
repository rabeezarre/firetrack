package com.firetrack.controller;

import com.firetrack.entity.SensorData;
import com.firetrack.service.SensorDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sensorData")
public class SensorDataController {

    @Autowired
    private SensorDataService sensorDataService;

    @GetMapping("/{pointId}")
    public ResponseEntity<List<SensorData>> getSensorDataByPoint(@PathVariable Long pointId) {
        List<SensorData> sensorDataList = sensorDataService.getSensorDataByPointId(pointId);
        return ResponseEntity.ok(sensorDataList);
    }

    @PostMapping
    public ResponseEntity<SensorData> addSensorData(@RequestBody SensorData sensorData) {
        SensorData addedSensorData = sensorDataService.addSensorData(sensorData);
        return ResponseEntity.ok(addedSensorData);
    }
}

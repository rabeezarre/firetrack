package com.firetrack.service;

import com.firetrack.entity.SensorData;
import com.firetrack.repository.SensorDataRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SensorDataServiceTest {

    @Mock
    private SensorDataRepository sensorDataRepository;

    @InjectMocks
    private SensorDataService sensorDataService;

    @Test
    void getSensorDataByPointIdTest() {
        Long pointId = 1L;
        SensorData data1 = new SensorData();
        SensorData data2 = new SensorData();
        when(sensorDataRepository.findByPointId(pointId)).thenReturn(Arrays.asList(data1, data2));

        List<SensorData> sensorDataList = sensorDataService.getSensorDataByPointId(pointId);

        assertNotNull(sensorDataList);
        assertEquals(2, sensorDataList.size());
    }

    @Test
    void addSensorDataTest() {
        SensorData newSensorData = new SensorData();
        when(sensorDataRepository.save(newSensorData)).thenReturn(newSensorData);

        SensorData savedSensorData = sensorDataService.addSensorData(newSensorData);

        assertNotNull(savedSensorData);
    }
}

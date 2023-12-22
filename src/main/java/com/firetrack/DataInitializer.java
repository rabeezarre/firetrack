package com.firetrack;

import com.firetrack.entity.*;
import com.firetrack.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.Random;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initData(UserRepository userRepository,
                               TrackingPointRepository trackingPointRepository,
                               SensorDataRepository sensorDataRepository,
                               AlertRepository alertRepository,
                               ScanningHistoryRepository scanningHistoryRepository) {
        return args -> {
            // Create and save users
            User user1 = new User();
            user1.setEmail("rabina@example.com");
            user1.setPassword("rabina");
            user1.setRole("ADMIN");
            user1.setFirstName("Rabina");
            user1.setLastName("Abdrakhmanova");
            user1.setPosition("Administrator");
            userRepository.save(user1);

            User user2 = new User();
            user2.setEmail("worker@example.com");
            user2.setPassword("worker");
            user2.setRole("USER");
            user2.setFirstName("Jane");
            user2.setLastName("Doe");
            user2.setPosition("Ranger");
            userRepository.save(user2);

            // Create and save tracking points
            TrackingPoint trackingPoint1 = new TrackingPoint();
            trackingPoint1.setLatitude(10.0);
            trackingPoint1.setLongitude(20.0);
//            trackingPoint1.setLastCheckedTime(LocalDateTime.now());
            trackingPoint1.setStatus("Active");
//            trackingPoint1.setUser(userRepository.findById(2L).orElse(null));
            trackingPointRepository.save(trackingPoint1);

            TrackingPoint trackingPoint2 = new TrackingPoint();
            trackingPoint2.setLatitude(14.0);
            trackingPoint2.setLongitude(29.0);
//            trackingPoint2.setLastCheckedTime(LocalDateTime.now());
            trackingPoint2.setStatus("Active");
//            trackingPoint2.setUser(userRepository.findById(2L).orElse(null));
            trackingPointRepository.save(trackingPoint2);

            TrackingPoint trackingPoint3 = new TrackingPoint();
            trackingPoint3.setLatitude(9.0);
            trackingPoint3.setLongitude(10.0);
//            trackingPoint3.setLastCheckedTime(LocalDateTime.now());
            trackingPoint3.setStatus("Active");
//            trackingPoint3.setUser(userRepository.findById(2L).orElse(null));
            trackingPointRepository.save(trackingPoint3);

            TrackingPoint trackingPoint4 = new TrackingPoint();
            trackingPoint4.setLatitude(14.0);
            trackingPoint4.setLongitude(20.0);
//            trackingPoint4.setLastCheckedTime(LocalDateTime.now());
            trackingPoint4.setStatus("Active");
//            trackingPoint4.setUser(userRepository.findById(2L).orElse(null));
            trackingPointRepository.save(trackingPoint4);

            TrackingPoint trackingPoint5 = new TrackingPoint();
            trackingPoint5.setLatitude(16.0);
            trackingPoint5.setLongitude(22.0);
//            trackingPoint5.setLastCheckedTime(LocalDateTime.now());
            trackingPoint5.setStatus("Inactive");
//            trackingPoint5.setUser(userRepository.findById(2L).orElse(null));
            trackingPointRepository.save(trackingPoint5);

            ScanningHistory scanningHistory = new ScanningHistory();
            scanningHistory.setTimestamp(LocalDateTime.now());
            scanningHistory.setPointId(1L);
            scanningHistory.setUserId(2L);
            scanningHistoryRepository.save(scanningHistory);

            // Create and save sensor data
            for (int i = 1; i <= 5; i++) {
                SensorData sensorData = new SensorData();
                sensorData.setPointId(new long[]{1L, 2L, 3L, 4L, 5L}[new Random().nextInt(5)]);
                sensorData.setTimestamp(LocalDateTime.now());
                sensorData.setTemperature(25.0 + i);
                sensorData.setAltitude(25.0 + i);
                sensorData.setColour("Color" + i);
                sensorData.setSound(25.0 + i);
                sensorData.setMagnetometer(25.0 + i);
                sensorData.setTemperature(25.0 + i);
                sensorData.setHumidity(50.0 + i);
                sensorData.setPressure(1000.0 + i);
                sensorDataRepository.save(sensorData);
            }

            // Create and save alerts
            Alert alert = new Alert();
            alert.setPointId(2L);
            alert.setAlertType("Hight Risk");
            alert.setTimestamp(LocalDateTime.now());
            alert.setStatus("Active");
            alertRepository.save(alert);

            Alert alert2 = new Alert();
            alert2.setPointId(1L);
            alert2.setAlertType("Fire");
            alert2.setTimestamp(LocalDateTime.now());
            alert2.setStatus("Resolved");
            alertRepository.save(alert2);
        };
    }
}

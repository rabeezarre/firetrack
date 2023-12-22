package com.firetrack;

import com.firetrack.entity.*;
import com.firetrack.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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
            user1.setPassword(new BCryptPasswordEncoder().encode("rabina"));
            user1.setRole("ROLE_ADMIN");
            user1.setFirstName("Rabina");
            user1.setLastName("Abdrakhmanova");
            user1.setPosition("Administrator");
            userRepository.save(user1);

            User user2 = new User();
            user2.setEmail("worker@example.com");
            user2.setPassword(new BCryptPasswordEncoder().encode("worker"));
            user2.setRole("ROLE_USER");
            user2.setFirstName("Jane");
            user2.setLastName("Doe");
            user2.setPosition("Ranger");
            userRepository.save(user2);

            // Create and save tracking points
            TrackingPoint trackingPoint1 = new TrackingPoint();
            trackingPoint1.setLatitude(45.4869);
            trackingPoint1.setLongitude(7.0359);
            trackingPoint1.setStatus("Active");
            trackingPointRepository.save(trackingPoint1);

            TrackingPoint trackingPoint2 = new TrackingPoint();
            trackingPoint2.setLatitude(45.2950);
            trackingPoint2.setLongitude(6.8622);
            trackingPoint2.setStatus("Active");
            trackingPointRepository.save(trackingPoint2);

            TrackingPoint trackingPoint3 = new TrackingPoint();
            trackingPoint3.setLatitude(45.5184);
            trackingPoint3.setLongitude(7.0934);
            trackingPoint3.setStatus("Active");
            trackingPointRepository.save(trackingPoint3);

            TrackingPoint trackingPoint4 = new TrackingPoint();
            trackingPoint4.setLatitude(45.3271);
            trackingPoint4.setLongitude(6.6154);
            trackingPoint4.setStatus("Active");
            trackingPointRepository.save(trackingPoint4);

            TrackingPoint trackingPoint5 = new TrackingPoint();
            trackingPoint5.setLatitude(45.2315);
            trackingPoint5.setLongitude(7.0136);
            trackingPoint5.setStatus("Active");
            trackingPointRepository.save(trackingPoint5);

            ScanningHistory scanningHistory = new ScanningHistory();
            scanningHistory.setTimestamp(LocalDateTime.now());
            scanningHistory.setPointId(1L);
            scanningHistory.setUserId(2L);
            scanningHistoryRepository.save(scanningHistory);

            ScanningHistory scanningHistory2 = new ScanningHistory();
            scanningHistory2.setTimestamp(LocalDateTime.now());
            scanningHistory2.setPointId(2L);
            scanningHistory2.setUserId(2L);
            scanningHistoryRepository.save(scanningHistory2);

            ScanningHistory scanningHistory3 = new ScanningHistory();
            scanningHistory3.setTimestamp(LocalDateTime.now());
            scanningHistory3.setPointId(2L);
            scanningHistory3.setUserId(2L);
            scanningHistoryRepository.save(scanningHistory3);

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

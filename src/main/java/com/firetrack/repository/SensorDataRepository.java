package com.firetrack.repository;

import com.firetrack.entity.SensorData;
import com.firetrack.entity.TrackingPoint;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorDataRepository extends JpaRepository<SensorData, Long> {
    List<SensorData> findByTrackingPoint(TrackingPoint trackingPoint);
}

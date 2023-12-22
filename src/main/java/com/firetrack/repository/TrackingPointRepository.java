package com.firetrack.repository;

import com.firetrack.entity.TrackingPoint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrackingPointRepository extends JpaRepository<TrackingPoint, Long> {

}


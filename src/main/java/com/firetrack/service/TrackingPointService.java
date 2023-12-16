package com.firetrack.service;

import com.firetrack.entity.TrackingPoint;
import com.firetrack.repository.TrackingPointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TrackingPointService {

    @Autowired
    private TrackingPointRepository trackingPointRepository;

    public List<TrackingPoint> getAllTrackingPoints() {
        return trackingPointRepository.findAll();
    }

    public TrackingPoint updateTrackingPoint(Long pointId, TrackingPoint trackingPointDetails) {
        return trackingPointRepository.findById(pointId).map(trackingPoint -> {
            trackingPoint.setStatus(trackingPointDetails.getStatus());
            trackingPoint.setLastCheckedTime(trackingPointDetails.getLastCheckedTime());
            return trackingPointRepository.save(trackingPoint);
        }).orElseGet(() -> {
            trackingPointDetails.setPointId(pointId);
            return trackingPointRepository.save(trackingPointDetails);
        });
    }
}

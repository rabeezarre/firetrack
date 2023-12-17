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

    public TrackingPoint getTrackingPointById(Long pointId) {
        return trackingPointRepository.findById(pointId).orElse(null);
    }

    public TrackingPoint saveTrackingPoint(TrackingPoint trackingPoint) {
        return trackingPointRepository.save(trackingPoint);
    }

    public TrackingPoint updateTrackingPoint(Long pointId, TrackingPoint trackingPointDetails) {
        return trackingPointRepository.findById(pointId).map(trackingPoint -> {
            trackingPoint.setLatitude(trackingPointDetails.getLatitude());
            trackingPoint.setLongitude(trackingPointDetails.getLongitude());
            trackingPoint.setStatus(trackingPointDetails.getStatus());
            return trackingPointRepository.save(trackingPoint);
        }).orElseGet(() -> {
            trackingPointDetails.setPointId(pointId);
            return trackingPointRepository.save(trackingPointDetails);
        });
    }

    public void deleteTrackingPoint(Long pointId) {
        trackingPointRepository.deleteById(pointId);
    }
}



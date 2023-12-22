package com.firetrack.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "trackingPoints")
public class TrackingPoint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pointId;
    private Double latitude;
    private Double longitude;
    private String status;

    // Constructors
    public TrackingPoint() {
    }

    public TrackingPoint(Long pointId, Double latitude, Double longitude, String status) {
        this.pointId = pointId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.status = status;
    }

    // Getters and Setters
    public Long getPointId() {
        return pointId;
    }

    public void setPointId(Long pointId) {
        this.pointId = pointId;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

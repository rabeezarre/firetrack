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
    private LocalDateTime lastCheckedTime;
    private String status;

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private User user;

    // Constructors
    public TrackingPoint() {}

    public TrackingPoint(Long pointId, Double latitude, Double longitude, LocalDateTime lastCheckedTime, String status, User user) {
        this.pointId = pointId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.lastCheckedTime = lastCheckedTime;
        this.status = status;
        this.user = user;
    }

    // Getters and Setters
    public Long getPointId() { return pointId; }
    public void setPointId(Long pointId) { this.pointId = pointId; }

    public Double getLatitude() { return latitude; }
    public void setLatitude(Double latitude) { this.latitude = latitude; }

    public Double getLongitude() { return longitude; }
    public void setLongitude(Double longitude) { this.longitude = longitude; }

    public LocalDateTime getLastCheckedTime() { return lastCheckedTime; }
    public void setLastCheckedTime(LocalDateTime lastCheckedTime) { this.lastCheckedTime = lastCheckedTime; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
}


package com.firetrack.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "alerts")
public class Alert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long alertId;
    private Long pointId;
    private String alertType;
    private LocalDateTime timestamp;
    private String status;

    // Constructors
    public Alert() {}

    public Alert(Long alertId, Long pointId, String alertType, LocalDateTime timestamp, String status) {
        this.alertId = alertId;
        this.pointId = pointId;
        this.alertType = alertType;
        this.timestamp = timestamp;
        this.status = status;
    }

    // Getters and Setters
    public Long getAlertId() { return alertId; }
    public void setAlertId(Long alertId) { this.alertId = alertId; }

    public Long getPointId() { return pointId; }
    public void setPointId(Long pointId) { this.pointId = pointId; }

    public String getAlertType() { return alertType; }
    public void setAlertType(String alertType) { this.alertType = alertType; }

    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}


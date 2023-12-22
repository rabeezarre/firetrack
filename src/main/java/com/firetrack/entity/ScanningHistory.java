package com.firetrack.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "scanningHistory")
public class ScanningHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long historyId;

    private Long pointId; // Changed from TrackingPoint object to Long

    private Long userId; // Assuming this was already changed to Long

    private LocalDateTime timestamp;

    // Constructors
    public ScanningHistory() {
    }

    public ScanningHistory(Long historyId, Long pointId, Long userId, LocalDateTime timestamp) {
        this.historyId = historyId;
        this.pointId = pointId;
        this.userId = userId;
        this.timestamp = timestamp;
    }

    // Getters and Setters
    public Long getHistoryId() {
        return historyId;
    }

    public void setHistoryId(Long historyId) {
        this.historyId = historyId;
    }

    public Long getPointId() {
        return pointId;
    }

    public void setPointId(Long pointId) {
        this.pointId = pointId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}

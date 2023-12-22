package com.firetrack.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "sensorData")
public class SensorData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dataId;
    private Long pointId;
    private LocalDateTime timestamp;
    private Double temperature;
    private Double humidity;
    private Double pressure;
    private Double altitude;
    private Double magnetometer;
    private Double sound;
    private String colour;

    // Constructors
    public SensorData() {}

    public SensorData(Long dataId, Long pointId, LocalDateTime timestamp, Double temperature, Double humidity, Double pressure, Double altitude, Double magnetometer, Double sound, String colour) {
        this.dataId = dataId;
        this.pointId = pointId;
        this.timestamp = timestamp;
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        this.altitude = altitude;
        this.magnetometer = magnetometer;
        this.sound = sound;
        this.colour = colour;
    }

    // Getters and Setters
    public Long getDataId() { return dataId; }
    public void setDataId(Long dataId) { this.dataId = dataId; }

    public Long getPointId() { return pointId; }
    public void setPointId(Long pointId) { this.pointId = pointId; }

    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }

    public Double getTemperature() { return temperature; }
    public void setTemperature(Double temperature) { this.temperature = temperature; }

    public Double getHumidity() { return humidity; }
    public void setHumidity(Double humidity) { this.humidity = humidity; }

    public Double getPressure() { return pressure; }
    public void setPressure(Double pressure) { this.pressure = pressure; }

    public Double getAltitude() { return altitude; }
    public void setAltitude(Double altitude) { this.altitude = altitude; }

    public Double getMagnetometer() { return magnetometer; }
    public void setMagnetometer(Double magnetometer) { this.magnetometer = magnetometer; }

    public Double getSound() { return sound; }
    public void setSound(Double sound) { this.sound = sound; }

    public String getColour() { return colour; }
    public void setColour(String colour) { this.colour = colour; }
}


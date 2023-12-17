package com.firetrack.repository;

import com.firetrack.entity.Alert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlertRepository extends JpaRepository<Alert, Long> {
    List<Alert> findByPointId(Long pointId);
    List<Alert> findByStatus(String status);
}

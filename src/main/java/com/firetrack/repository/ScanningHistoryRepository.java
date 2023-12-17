package com.firetrack.repository;

import com.firetrack.entity.ScanningHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ScanningHistoryRepository extends JpaRepository<ScanningHistory, Long> {
    List<ScanningHistory> findByPointId(Long pointId);
    List<ScanningHistory> findByUserId(Long userId);
}

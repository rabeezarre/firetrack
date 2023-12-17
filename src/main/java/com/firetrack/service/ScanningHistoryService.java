package com.firetrack.service;

import com.firetrack.entity.ScanningHistory;
import com.firetrack.repository.ScanningHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ScanningHistoryService {

    private final ScanningHistoryRepository scanningHistoryRepository;

    @Autowired
    public ScanningHistoryService(ScanningHistoryRepository scanningHistoryRepository) {
        this.scanningHistoryRepository = scanningHistoryRepository;
    }

    public List<ScanningHistory> findAllScanningHistories() {
        return scanningHistoryRepository.findAll();
    }

    public ScanningHistory saveScanningHistory(ScanningHistory scanningHistory) {
        return scanningHistoryRepository.save(scanningHistory);
    }

    public List<ScanningHistory> getHistoryByPointId(Long pointId) {
        return scanningHistoryRepository.findByPointId(pointId);
    }

    public List<ScanningHistory> getScanningHistoryByUser(Long userId) {
        return scanningHistoryRepository.findByUserId(userId);
    }
}

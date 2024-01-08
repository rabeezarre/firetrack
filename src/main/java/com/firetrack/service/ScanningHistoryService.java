/**
 * This package contains service classes responsible for handling business logic related to scanning history.
 * Service classes act as an intermediary between controllers and repositories, providing scanning history-related functionality.
 */
package com.firetrack.service;

import com.firetrack.entity.ScanningHistory;
import com.firetrack.repository.ScanningHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for managing scanning history and related operations.
 * ScanningHistoryService provides methods for retrieving, creating, and querying scanning history records.
 */
@Service
public class ScanningHistoryService {

    private final ScanningHistoryRepository scanningHistoryRepository;

    /**
     * Constructor for ScanningHistoryService.
     *
     * @param scanningHistoryRepository The ScanningHistoryRepository used for database operations.
     */
    @Autowired
    public ScanningHistoryService(ScanningHistoryRepository scanningHistoryRepository) {
        this.scanningHistoryRepository = scanningHistoryRepository;
    }

    /**
     * Retrieve all scanning history records stored in the database.
     *
     * @return A list of all scanning history records.
     */
    public List<ScanningHistory> findAllScanningHistories() {
        return scanningHistoryRepository.findAll();
    }

    /**
     * Create and store a new scanning history record in the database.
     *
     * @param scanningHistory The scanning history record to be created.
     * @return The created scanning history record with updated details.
     */
    public ScanningHistory saveScanningHistory(ScanningHistory scanningHistory) {
        return scanningHistoryRepository.save(scanningHistory);
    }

    /**
     * Retrieve scanning history records associated with a specific tracking point.
     *
     * @param pointId The ID of the tracking point for which scanning history records are retrieved.
     * @return A list of scanning history records associated with the specified tracking point.
     */
    public List<ScanningHistory> getHistoryByPointId(Long pointId) {
        return scanningHistoryRepository.findByPointId(pointId);
    }

    /**
     * Retrieve scanning history records associated with a specific user.
     *
     * @param userId The ID of the user for which scanning history records are retrieved.
     * @return A list of scanning history records associated with the specified user.
     */
    public List<ScanningHistory> getScanningHistoryByUser(Long userId) {
        return scanningHistoryRepository.findByUserId(userId);
    }
}

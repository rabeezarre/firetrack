/**
 * This package contains controller classes responsible for handling scanning history-related operations.
 * Controllers manage incoming HTTP requests and invoke the corresponding service methods.
 */
package com.firetrack.controller;

import com.firetrack.entity.ScanningHistory;
import com.firetrack.service.ScanningHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class for managing scanning history operations.
 */
@RestController
@RequestMapping("/api/scanningHistory")
public class ScanningHistoryController {

    @Autowired
    private ScanningHistoryService scanningHistoryService;

    /**
     * Retrieves all scanning histories.
     *
     * @return A ResponseEntity containing a list of ScanningHistory objects.
     */
    @GetMapping
    public ResponseEntity<List<ScanningHistory>> getAllScanningHistories() {
        List<ScanningHistory> histories = scanningHistoryService.findAllScanningHistories();
        return ResponseEntity.ok(histories);
    }

    /**
     * Retrieves scanning history records for a specific user.
     *
     * @param userId The ID of the user.
     * @return A ResponseEntity containing a list of ScanningHistory objects for the user.
     */
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ScanningHistory>> getScanningHistoryByUser(@PathVariable Long userId) {
        List<ScanningHistory> userHistories = scanningHistoryService.getScanningHistoryByUser(userId);
        if (userHistories.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(userHistories);
    }

    /**
     * Retrieves scanning history records for a specific scanning point.
     *
     * @param pointId The ID of the scanning point.
     * @return A ResponseEntity containing a list of ScanningHistory objects for the point.
     */
    @GetMapping("/point/{pointId}")
    public ResponseEntity<List<ScanningHistory>> getHistoryByPointId(@PathVariable Long pointId) {
        List<ScanningHistory> pointHistories = scanningHistoryService.getHistoryByPointId(pointId);
        if (pointHistories.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(pointHistories);
    }

    /**
     * Creates a new scanning history record.
     *
     * @param scanningHistory The ScanningHistory object to be created.
     * @return A ResponseEntity containing the newly created ScanningHistory object.
     */
    @PostMapping
    public ResponseEntity<ScanningHistory> createScanningHistory(@RequestBody ScanningHistory scanningHistory) {
        ScanningHistory newScanningHistory = scanningHistoryService.saveScanningHistory(scanningHistory);
        return ResponseEntity.ok(newScanningHistory);
    }
}

package com.firetrack.controller;

import com.firetrack.entity.ScanningHistory;
import com.firetrack.service.ScanningHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/scanningHistory")
public class ScanningHistoryController {

    @Autowired
    private ScanningHistoryService scanningHistoryService;

    @GetMapping
    public ResponseEntity<List<ScanningHistory>> getAllScanningHistories() {
        List<ScanningHistory> histories = scanningHistoryService.findAllScanningHistories();
        return ResponseEntity.ok(histories);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ScanningHistory>> getScanningHistoryByUser(@PathVariable Long userId) {
        List<ScanningHistory> userHistories = scanningHistoryService.getScanningHistoryByUser(userId);
        if (userHistories.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(userHistories);
    }

    @GetMapping("/point/{pointId}")
    public ResponseEntity<List<ScanningHistory>> getHistoryByPointId(@PathVariable Long pointId) {
        List<ScanningHistory> pointHistories = scanningHistoryService.getHistoryByPointId(pointId);
        if (pointHistories.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(pointHistories);
    }

    @PostMapping
    public ResponseEntity<ScanningHistory> createScanningHistory(@RequestBody ScanningHistory scanningHistory) {
        ScanningHistory newScanningHistory = scanningHistoryService.saveScanningHistory(scanningHistory);
        return ResponseEntity.ok(newScanningHistory);
    }
}

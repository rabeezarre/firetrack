package com.firetrack.service;

import com.firetrack.entity.ScanningHistory;
import com.firetrack.repository.ScanningHistoryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ScanningHistoryServiceTest {

    @Mock
    private ScanningHistoryRepository scanningHistoryRepository;

    @InjectMocks
    private ScanningHistoryService scanningHistoryService;

    @Test
    void findAllScanningHistoriesTest() {
        ScanningHistory history1 = new ScanningHistory();
        ScanningHistory history2 = new ScanningHistory();
        when(scanningHistoryRepository.findAll()).thenReturn(Arrays.asList(history1, history2));

        List<ScanningHistory> histories = scanningHistoryService.findAllScanningHistories();

        assertNotNull(histories);
        assertEquals(2, histories.size());
    }

    @Test
    void saveScanningHistoryTest() {
        ScanningHistory history = new ScanningHistory();
        when(scanningHistoryRepository.save(history)).thenReturn(history);

        ScanningHistory savedHistory = scanningHistoryService.saveScanningHistory(history);

        assertNotNull(savedHistory);
    }

    @Test
    void getHistoryByPointIdTest() {
        Long pointId = 1L;
        ScanningHistory history = new ScanningHistory();
        when(scanningHistoryRepository.findByPointId(pointId)).thenReturn(List.of(history));

        List<ScanningHistory> resultHistories = scanningHistoryService.getHistoryByPointId(pointId);

        assertNotNull(resultHistories);
        assertFalse(resultHistories.isEmpty());
    }

    @Test
    void getScanningHistoryByUserTest() {
        Long userId = 1L;
        ScanningHistory history = new ScanningHistory();
        when(scanningHistoryRepository.findByUserId(userId)).thenReturn(List.of(history));

        List<ScanningHistory> resultHistories = scanningHistoryService.getScanningHistoryByUser(userId);

        assertNotNull(resultHistories);
        assertFalse(resultHistories.isEmpty());
    }
}

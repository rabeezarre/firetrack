package com.firetrack.controller;

import com.firetrack.entity.ScanningHistory;
import com.firetrack.service.ScanningHistoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
public class ScanningHistoryControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ScanningHistoryService scanningHistoryService;

    @InjectMocks
    private ScanningHistoryController scanningHistoryController;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(scanningHistoryController).build();
    }

    @Test
    public void testGetAllScanningHistories() throws Exception {
        List<ScanningHistory> histories = Arrays.asList(new ScanningHistory(), new ScanningHistory());
        when(scanningHistoryService.findAllScanningHistories()).thenReturn(histories);

        mockMvc.perform(get("/api/scanningHistory"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testGetScanningHistoryByUser() throws Exception {
        Long userId = 1L;
        List<ScanningHistory> userHistories = Arrays.asList(new ScanningHistory(), new ScanningHistory());
        when(scanningHistoryService.getScanningHistoryByUser(userId)).thenReturn(userHistories);

        mockMvc.perform(get("/api/scanningHistory/user/" + userId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testGetHistoryByPointId() throws Exception {
        Long pointId = 1L;
        List<ScanningHistory> pointHistories = Arrays.asList(new ScanningHistory(), new ScanningHistory());
        when(scanningHistoryService.getHistoryByPointId(pointId)).thenReturn(pointHistories);

        mockMvc.perform(get("/api/scanningHistory/point/" + pointId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

}

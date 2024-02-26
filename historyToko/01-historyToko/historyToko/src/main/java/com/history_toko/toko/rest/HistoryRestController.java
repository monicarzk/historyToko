package com.history_toko.toko.rest;

import com.history_toko.toko.dao.HistoryDAO;
import com.history_toko.toko.entity.History;
import com.history_toko.toko.service.HistoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HistoryRestController {

    private HistoryService historyService;

    public HistoryRestController(HistoryService theHistoryService) {
        historyService = theHistoryService;
    }

    @GetMapping("/histories")
    public List<History> findAll() {
        return historyService.findAll();
    }

    
}

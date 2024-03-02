package com.historyToko.caringin.rest;

import com.historyToko.caringin.entity.History;
import com.historyToko.caringin.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/api")
public class HistoryRestController {

    private HistoryService historyService;

    @Autowired
    public HistoryRestController(HistoryService theHistoryService) {
        historyService = theHistoryService;
    }

    @GetMapping("/histories")
    public List<History> findAll() {
        return historyService.findAll();
    }

    @GetMapping("/histories/{historyDate}")
    public History getHistory(@PathVariable LocalDate historyDate) {

        History theHistory = historyService.findByDate(historyDate);

        if (theHistory == null) {
            throw new RuntimeException("History date not found - " + historyDate);
        }

        return theHistory;
    }

    @PostMapping("/histories")
    public History addHistory(@RequestBody History theHistory) {

        theHistory.setDate(LocalDate.now());

        History dbHistory = historyService.save(theHistory);

        return dbHistory;
    }

    @PutMapping("/histories")
    public History updateHistory(@RequestBody History theHistory) {

        History dbHistory = historyService.save(theHistory);

        return dbHistory;
    }

    @DeleteMapping("/histories/{historyDate}")
    public String deleteHistory(@PathVariable @DateTimeFormat
            (iso = DateTimeFormat.ISO.DATE) LocalDate historyDate) {

        History tempHistory = historyService.findByDate(historyDate);

        if (tempHistory == null) {
            throw new RuntimeException("History date not found - " + historyDate);
        }

        historyService.deleteByDate(historyDate);

        return "Deleted history date - " + historyDate;
    }
}


package com.history_toko.toko.rest;

import com.history_toko.toko.entity.History;
import com.history_toko.toko.service.HistoryService;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/histories/{historyId}")
    public History getHistory(@PathVariable int historyId) {

        History theHistory = historyService.findById(historyId);

        if (theHistory == null) {
            throw new RuntimeException("History id not found - " + historyId);
        }

        return theHistory;
    }

    @PostMapping("/histories")
    public History addHistory (@RequestBody History theHistory) {

        theHistory.setId(0);

        History dbHistory = historyService.save(theHistory);

        return dbHistory;
    }

    @PutMapping("/histories")
    public History updateHistory(@RequestBody History theHistory) {

        History dbHistory = historyService.save(theHistory);

        return dbHistory;
    }

    @DeleteMapping("/histories/{historyId}")
    public String deleteHistory(@PathVariable int historyId) {

        History tempHistory = historyService.findById(historyId);

        if (tempHistory == null) {
            throw new RuntimeException("History id not found - " + historyId);
        }

        historyService.deleteById(historyId);

        return "Deleted history id - " + historyId;
    }

}

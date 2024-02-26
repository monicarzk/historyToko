package com.history_toko.toko.rest;

import com.history_toko.toko.dao.HistoryDAO;
import com.history_toko.toko.entity.History;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HistoryRestController {

    private HistoryDAO historyDAO;

    public HistoryRestController(HistoryDAO theHistoryDAO) {
        historyDAO =  theHistoryDAO;
    }

    @GetMapping("/histories")
    public List<History> findAll() {
        return historyDAO.findAll();
    }

}

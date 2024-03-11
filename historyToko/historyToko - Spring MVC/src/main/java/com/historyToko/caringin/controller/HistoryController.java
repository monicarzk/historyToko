package com.historyToko.caringin.controller;

import com.historyToko.caringin.entity.History;
import com.historyToko.caringin.service.HistoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/histories")
public class HistoryController {

    private HistoryService historyService;

    public HistoryController(HistoryService theHistoryService) {
        historyService = theHistoryService;
    }

    @GetMapping("/list")
    public String listHistories(Model themodel) {

        List<History> theHistories = historyService.findAll();

        themodel.addAttribute("histories", theHistories);

        return "List-histories";
    }

}

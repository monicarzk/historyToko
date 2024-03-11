package com.historyToko.caringin.controller;

import com.historyToko.caringin.entity.History;
import com.historyToko.caringin.service.HistoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

        return "histories/list-histories";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        History theHistory = new History();

        theModel.addAttribute("history", theHistory);

        return "histories/history-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("historyId") int theId, Model theModel) {

        History theHistory = historyService.findById(theId);

        theModel.addAttribute("history", theHistory);

        return "histories/history-form";
    }

    @PostMapping("/save")
    public String saveHistory(@ModelAttribute("history") History theHistory) {

        historyService.save(theHistory);

        return "redirect:/histories/list";
    }


}

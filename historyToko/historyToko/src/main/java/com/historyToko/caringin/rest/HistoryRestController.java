package com.historyToko.caringin.rest;

import com.historyToko.caringin.entity.History;
import com.historyToko.caringin.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

// @RestController anotasi yang menandakan bahwa kelas ini adalah pengendali RESTful API
// @RequestMapping anotasi untuk menetapkan URL
@RestController
@RequestMapping("/api")
public class HistoryRestController {


    // deklarasi sebuah variabel yang bertipe HistoryService
    // untuk melakukan injeksi dependensi (dependency injection)
    private HistoryService historyService;


    // @Autowired anotasi untuk melakukan injeksi dependensi secara otomatis
    // konstruktor ini bertanggung jawab untuk menerima instance melalui injeksi dependensi
    @Autowired
    public HistoryRestController(HistoryService theHistoryService) {
        historyService = theHistoryService;
    }


    // @GetMapping anotasi untuk menetapkan endpoint URL
    // metode untuk menangani permintaan HTTP GET yang datang ke endpoint /api/histories
    @GetMapping("/histories")
    public List<History> findAll() {
        return historyService.findAll();
    }


    // @GetMapping anotasi untuk menetapkan endpoint URL
    // metode untuk menangani permintaan HTTP GET yang datang ke endpoint /api/histories/{historyDate}
    // mencari riwayat berdasarkan tanggal yang diberikan,
    @GetMapping("/histories/{historyDate}")
    public History getHistory(@PathVariable LocalDate historyDate) {

        History theHistory = historyService.findByDate(historyDate);

        if (theHistory == null) {
            throw new RuntimeException("History date not found - " + historyDate);
        }

        return theHistory;
    }


    // @PostMapping anotasi untuk menetapkan endpoint URL
    // metode untuk menangani permintaan HTTP POST yang datang ke endpoint /api/histories
    // menyimpan riwayat yang diberikan
    @PostMapping("/histories")
    public History addHistory(@RequestBody History theHistory) {

        History dbHistory = historyService.save(theHistory);

        return dbHistory;
    }


    // @PutMapping anotasi untuk menetapkan endpoint URL
    // metode untuk menangani permintaan HTTP PUT yang datang ke endpoint /api/histories
    // menyimpan riwayat yang diberikan
    @PutMapping("/histories")
    public History updateHistory(@RequestBody History theHistory) {

        History dbHistory = historyService.save(theHistory);

        return dbHistory;
    }


    // @DeleteMapping anotasi untuk menetapkan endpoint URL
    // metode untuk menangani permintaan HTTP DELETE yang datang ke endpoint /api/histories/{historyDate}
    // mencari dan menghapus riwayat yang sesuai dengan tanggal yang diberikan
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


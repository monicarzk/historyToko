package com.historyToko.caringin.rest;

import com.historyToko.caringin.entity.History;
import com.historyToko.caringin.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/histories/{historyId}")
    public History getHistory(@PathVariable int historyId) {

        History theHistory = historyService.findById(historyId);

        if (theHistory == null) {
            throw new RuntimeException("History id not found - " + historyId);
        }

        return theHistory;
    }


    // @PostMapping anotasi untuk menetapkan endpoint URL
    // metode untuk menangani permintaan HTTP POST yang datang ke endpoint /api/histories
    // menyimpan riwayat yang diberikan
    @PostMapping("/histories")
    public History addHistory(@RequestBody History theHistory) {

        theHistory.setId(0);

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


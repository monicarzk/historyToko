package com.history_toko.toko.rest;

import com.history_toko.toko.entity.History;
import com.history_toko.toko.service.HistoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // anotasi komponen yang mengelola HTTP dalam format data
@RequestMapping("/api")  // anotasi yang menetapkan rute dasar URL untuk pengontrol
public class HistoryRestController {

    private HistoryService historyService;  // variabel ini digunakan untuk berinteraksi dengan lapisan layanan (service layer)

    public HistoryRestController(HistoryService theHistoryService) {
        historyService = theHistoryService;
    }  // injeksi dependensi

    @GetMapping("/histories")  // anotasi yg akan menangani permintaan HTTP GET yang dikirim ke URL
    public List<History> findAll() {
        return historyService.findAll();

    } // metode yang akan menangani permintaan GET untuk mengambil semua entitas History.

    @GetMapping("/histories/{historyId}")  // anotasi yg akan menangani permintaan HTTP GET yang dikirim ke URL
    public History getHistory(@PathVariable int historyId) {

        History theHistory = historyService.findById(historyId); // mencari entitas berdasarkan id-nya

        if (theHistory == null) {
            throw new RuntimeException("History id not found - " + historyId);
        }  // kondisi pengecekan id

        return theHistory; // jika id ditemukan maka metode ini akan mengembalikan entitas tersebut sebagai respons HTTP
    }

    @PostMapping("/histories")  // anotasi untuk menambah entitas baru kedalam database
    public History addHistory (@RequestBody History theHistory) {

        theHistory.setId(0);  // set untuk menambahkan entitas baru

        History dbHistory = historyService.save(theHistory);  // untuk menyimpan atau memperbarui entitas

        return dbHistory;  // Setelah menyimpan entitas ke dalam database, metode akan mengembalikan entitas yang disimpan
    }

    @PutMapping("/histories")  // anotasi untuk mengubah entitas
    public History updateHistory(@RequestBody History theHistory) {

        History dbHistory = historyService.save(theHistory);  // unruk menyimpan atau memperbarui entitas

        return dbHistory;  // Setelah menyimpan entitas ke dalam database, metode akan mengembalikan entitas yang disimpan
    }

    @DeleteMapping("/histories/{historyId}")  // anotasi untuk menghapus entitas dari database
    public String deleteHistory(@PathVariable int historyId) {

        History tempHistory = historyService.findById(historyId);  // mencari entitas berdasarkan id-nya

        if (tempHistory == null) {
            throw new RuntimeException("History id not found - " + historyId);
        } // kondisi pengecekan id

        historyService.deleteById(historyId);

        return "Deleted history id - " + historyId;
    }

}

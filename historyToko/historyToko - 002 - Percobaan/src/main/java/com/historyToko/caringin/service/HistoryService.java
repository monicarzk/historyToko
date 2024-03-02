package com.historyToko.caringin.service;

import com.historyToko.caringin.entity.History;

import java.time.LocalDate;
import java.util.List;

public interface HistoryService {


    // Metode untuk mendapatkan daftar semua entity History
    List<History> findAll();


    // Metode untuk menemukan entity History berdasarkan tanggal tertentu (theDate)
    History findByDate(LocalDate theDate);


    // Metode untuk menyimpan atau memperbarui entity History
    History save(History theHistory);


    // Metode untuk menghapus entity History
    void deleteByDate(LocalDate theDate);
}

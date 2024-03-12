package com.historyToko.caringin.service;

import com.historyToko.caringin.dao.HistoryRepository;
import com.historyToko.caringin.entity.History;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// @Service anotasi untuk menandai kelas sebagai bagian dari lapisan layanan (service layer)
@Service
public class HistoryServiceImpl implements HistoryService {


    // deklarasi sebuah variabel yang bertipe HistoryRepository
    // untuk melakukan injeksi dependensi (dependency injection)
    private HistoryRepository historyRepository;


    // @Autowired anotasi untuk melakukan injeksi dependensi secara otomatis
    // konstruktor ini bertanggung jawab untuk menerima instance melalui injeksi dependensi
    @Autowired
    public HistoryServiceImpl(HistoryRepository theHistoryRepository) {
        historyRepository = theHistoryRepository;
    }


    // @Override anotasi yang menandakan nama yang sama dari interface
    // metode findAll() ini bertanggung jawab untuk mengambil semua entity History dari database melalui repository
    @Override
    public List<History> findAll() {
        return historyRepository.findAllByOrderByDateAsc();
    }


    // @Override anotasi yang menandakan nama yang sama dari interface
    // metode untuk mencari entity History berdasarkan tanggal yang diberikan
    @Override
    public History findById(int theId) {
        Optional<History> result = historyRepository.findById(theId);

        History theHistory = null;

        if(result.isPresent()) {
            theHistory = result.get();
        }
        else {
            throw new RuntimeException("Did not find History id - " + theId);
        }

        return theHistory;

    }


    // @Override anotasi yang menandakan nama yang sama dari interface
    // metode untuk menyimpan entity History yang diberikan ke dalam repository
    @Override
    public History save(History theHistory) {
        return historyRepository.save(theHistory);
    }


    // @Override anotasi yang menandakan nama yang sama dari interface
    // metode untuk menghapus entity History berdasarkan tanggal yang diberikan
    @Override
    public void deleteById(int theId) {
        historyRepository.deleteById(theId);

    }
}

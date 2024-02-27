package com.history_toko.toko.service;

import com.history_toko.toko.entity.History;

import java.util.List;

public interface HistoryService {

    List<History> findAll();

    History findById(int theId);

    History save(History theHistory);

    void deleteById(int theId);
}

package com.historyToko.caringin.service;

import com.historyToko.caringin.entity.History;

import java.time.LocalDate;
import java.util.List;

public interface HistoryService {

    List<History> findAll();

    History findByDate(LocalDate theDate);

    History save(History theHistory);

    void deleteByDate(LocalDate theDate);
}

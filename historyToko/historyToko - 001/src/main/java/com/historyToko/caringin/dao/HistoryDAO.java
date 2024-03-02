package com.historyToko.caringin.dao;

import com.historyToko.caringin.entity.History;

import java.time.LocalDate;
import java.util.List;

public interface HistoryDAO {

    List<History> findAll();

    History findByDate(LocalDate theDate);

    History save(History theHistory);

    void deleteByDate(LocalDate theDate);
}

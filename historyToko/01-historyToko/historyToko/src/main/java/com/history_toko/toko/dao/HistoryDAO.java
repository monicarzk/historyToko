package com.history_toko.toko.dao;

import com.history_toko.toko.entity.History;

import java.util.List;

public interface HistoryDAO {

    List<History> findAll();

}

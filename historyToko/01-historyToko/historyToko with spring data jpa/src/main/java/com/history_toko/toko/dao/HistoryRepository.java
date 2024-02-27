package com.history_toko.toko.dao;

import com.history_toko.toko.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepository extends JpaRepository<History, Integer> {


}

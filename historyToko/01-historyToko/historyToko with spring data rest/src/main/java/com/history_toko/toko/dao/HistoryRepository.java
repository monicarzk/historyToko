package com.history_toko.toko.dao;

import com.history_toko.toko.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "history")
public interface HistoryRepository extends JpaRepository<History, Integer> {


}

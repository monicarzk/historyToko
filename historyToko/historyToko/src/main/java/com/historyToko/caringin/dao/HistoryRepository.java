package com.historyToko.caringin.dao;

import com.historyToko.caringin.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface HistoryRepository extends JpaRepository<History, LocalDate> {

    // that's it . . . NO ANY CODE :-)

    // JpaRepository adalah bagian dari Spring Data JPA yang menyediakan
    // berbagai metode bawaan untuk melakukan operasi CRUD (Create, Read, Update, Delete)
    // pada entity dalam basis data


}

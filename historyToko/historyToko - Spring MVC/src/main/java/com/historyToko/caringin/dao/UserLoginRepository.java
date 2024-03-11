package com.historyToko.caringin.dao;

import com.historyToko.caringin.entity.History;
import com.historyToko.caringin.entity.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserLoginRepository extends JpaRepository<UserLogin, Integer> {

    // that's it . . . NO ANY CODE :-)

    // JpaRepository adalah bagian dari Spring Data JPA yang menyediakan
    // berbagai metode bawaan untuk melakukan operasi CRUD (Create, Read, Update, Delete)
    // pada entity dalam basis data

    // add a method to sort by username
    public List<UserLogin> findAllByOrderByUsernameAsc();
}

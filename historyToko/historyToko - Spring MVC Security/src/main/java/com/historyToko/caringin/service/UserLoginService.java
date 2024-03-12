package com.historyToko.caringin.service;

import com.historyToko.caringin.entity.UserLogin;

import java.util.List;

public interface UserLoginService {


    // Metode untuk mendapatkan daftar semua entity UserLogin
    List<UserLogin> findAll();


    // Metode untuk menemukan entity UserLogin berdasarkan username
    UserLogin findById(int theId);


    // Metode untuk menyimpan atau memperbarui entity UserLogin
    UserLogin save(UserLogin theUserLogin);


    // Metode untuk menghapus entity UserLogin
    void deleteById(int theId);
}

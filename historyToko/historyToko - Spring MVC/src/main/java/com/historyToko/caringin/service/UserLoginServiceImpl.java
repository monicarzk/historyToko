package com.historyToko.caringin.service;

import com.historyToko.caringin.dao.UserLoginRepository;
import com.historyToko.caringin.entity.UserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// @Service anotasi untuk menandai kelas sebagai bagian dari lapisan layanan (service layer)
@Service
public class UserLoginServiceImpl implements UserLoginService{


    // deklarasi sebuah variabel yang bertipe HistoryRepository
    // untuk melakukan injeksi dependensi (dependency injection)
    private UserLoginRepository userLoginRepository;


    // @Autowired anotasi untuk melakukan injeksi dependensi secara otomatis
    // konstruktor ini bertanggung jawab untuk menerima instance melalui injeksi dependensi
    @Autowired
    public UserLoginServiceImpl(UserLoginRepository theUserLoginRepository) {
        userLoginRepository = theUserLoginRepository;
    }


    // @Override anotasi yang menandakan nama yang sama dari interface
    // metode findAll() ini bertanggung jawab untuk mengambil semua entity UserLogin dari database melalui repository
    @Override
    public List<UserLogin> findAll() {
        return userLoginRepository.findAll();
    }


    // @Override anotasi yang menandakan nama yang sama dari interface
    // metode untuk mencari entity UserLogin berdasarkan username
    @Override
    public UserLogin findById(int theId) {
        Optional<UserLogin> result = userLoginRepository.findById(theId);

        UserLogin theUserLogin = null;

        if (result.isPresent()) {
            theUserLogin = result.get();
        }
        else {
            throw new RuntimeException("Did not find user_login id - " + theId);
        }

        return theUserLogin;
    }


    // @Override anotasi yang menandakan nama yang sama dari interface
    // metode untuk menyimpan entity UserLogin yang diberikan ke dalam repository
    @Override
    public UserLogin save(UserLogin theUserLogin) {
        return userLoginRepository.save(theUserLogin);
    }


    // @Override anotasi yang menandakan nama yang sama dari interface
    // metode untuk menghapus entity UserLogin berdasarkan username
    @Override
    public void deleteById(int theId) {
        userLoginRepository.deleteById(theId);

    }
}

package com.historyToko.caringin.rest;

import com.historyToko.caringin.entity.UserLogin;
import com.historyToko.caringin.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// @RestController anotasi yang menandakan bahwa kelas ini adalah pengendali RESTful API
// @RequestMapping anotasi untuk menetapkan URL
@RestController
@RequestMapping("/api")
public class UserLoginRestController {


    // deklarasi sebuah variabel yang bertipe UserLogiService
    // untuk melakukan injeksi dependensi (dependency injection)
    private UserLoginService userLoginService;


    // @Autowired anotasi untuk melakukan injeksi dependensi secara otomatis
    // konstruktor ini bertanggung jawab untuk menerima instance melalui injeksi dependensi
    @Autowired
    public UserLoginRestController(UserLoginService theUserLoginService) {
        userLoginService = theUserLoginService;
    }


    // @GetMapping anotasi untuk menetapkan endpoint URL
    // metode untuk menangani permintaan HTTP GET yang datang ke endpoint /api/users
    @GetMapping("/users")
    public List<UserLogin> findAll() {
        return userLoginService.findAll();
    }


    // @GetMapping anotasi untuk menetapkan endpoint URL
    // metode untuk menangani permintaan HTTP GET yang datang ke endpoint /api/users/{userUsername}
    // mencari data login pengguna berdasarkan nama pengguna yang diberikan
    @GetMapping("/users/{userId}")
    public UserLogin getUserLogin(@PathVariable int userId) {

        UserLogin theUserLogin = userLoginService.findById(userId);

        if (theUserLogin == null) {
            throw new RuntimeException("UserLogin id not found - " + userId);

        }

        return theUserLogin;
    }


    // @PostMapping anotasi untuk menetapkan endpoint URL
    // metode untuk menangani permintaan HTTP POST yang datang ke endpoint /api/users
    // menyimpan data login pengguna yang diberikan
    @PostMapping("/users")
    public UserLogin addUserLogin(@RequestBody UserLogin theUserLogin) {

        theUserLogin.setId(0);

        UserLogin dbUserLogin = userLoginService.save(theUserLogin);

        return dbUserLogin;

    }


    // @PutMapping anotasi untuk menetapkan endpoint URL
    // metode untuk menangani permintaan HTTP PUT yang datang ke endpoint /api/users
    // menyimpan data login yang diberikan
    @PutMapping("/users")
    public UserLogin updateUserLogin(@RequestBody UserLogin theUserLogin) {

        UserLogin dbUserLogin = userLoginService.save(theUserLogin);

        return dbUserLogin;
    }


    // @DeleteMapping anotasi untuk menetapkan endpoint URL
    // metode untuk menangani permintaan HTTP DELETE yang datang ke endpoint /api/users/{userUser}
    // mencari dan menghapus data login pengguna berdasarkan nama pengguna yang diberikan
    @DeleteMapping("/users/{userId}")
    public String deleteUserLogin(@PathVariable int userId) {

        UserLogin tempUserLogin = userLoginService.findById(userId);

        if (tempUserLogin == null) {
            throw new RuntimeException("UserLogin id not found - " + userId);
        }

        userLoginService.deleteById(userId);

        return "Deleted user_login id - " + userId;
    }
}

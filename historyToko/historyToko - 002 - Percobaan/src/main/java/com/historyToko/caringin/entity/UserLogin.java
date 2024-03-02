package com.historyToko.caringin.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// @Entity anotasi yang menandakan kelas adalah entity JPA
// @Table anotasi yang mengonfigurasi nama tabel dalam db
@Entity
@Table(name = "user_login")
public class UserLogin {


    // @Id anotasi yang menandakan primary key
    // @Column anotasi yang mengonfigurasi kolom db
    @Id
    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "active")
    private boolean active;


    // default constructor
    public UserLogin() {

    }


    // Metode konstruktor dengan parameter untuk kelas UserLogin
    // konstruktor ini bertugas untuk membuat instance/objek baru dari kelas UserLogin
    public UserLogin(String username, String password, boolean active) {
        this.username = username;
        this.password = password;
        this.active = active;
    }


    // getters and setters
    // getters untuk mengakses nilai dari atribut objek
    // setters untuk mengubah nilai dari atribut objek
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }


    // toString
    // metode ini memudahkan untuk debugging, logging, dan pengembangan aplikasi secara umum
    @Override
    public String toString() {
        return "UserLogin{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", active=" + active +
                '}';
    }
}
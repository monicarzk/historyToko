package com.historyToko.caringin.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

// @Entity anotasi yang menandakan kelas adalah entity JPA
// @Table anotasi yang mengonfigurasi nama tabel dalam db
@Entity
@Table(name = "history")
public class History {


    // @Id anotasi yang menandakan primary key
    // @Column anotasi yang mengonfigurasi kolom db
    @Id
    @Column(name = "date")
    private LocalDate date;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private double price;


    // default constructor
    public History() {

    }


    // Metode konstruktor dengan parameter untuk kelas History
    // konstruktor ini bertugas untuk membuat instance/objek baru dari kelas History
    public History(LocalDate date, String description, double price) {
        this.date = date;
        this.description = description;
        this.price = price;
    }


    // getters and setters
    // getters untuk mengakses nilai dari atribut objek
    // setters untuk mengubah nilai dari atribut objek
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    // toString
    // metode ini memudahkan untuk debugging, logging, dan pengembangan aplikasi secara umum
    @Override
    public String toString() {
        return "History{" +
                "date=" + date +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
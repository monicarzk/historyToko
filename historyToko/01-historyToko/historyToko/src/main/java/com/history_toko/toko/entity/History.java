package com.history_toko.toko.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity  // anotasi untuk mapping ke database
@Table(name = "history")  // anotasi untuk menentukan nama tabel yang akan di mapping
public class History {

    @Id  // anotasi yang menandakan bahwa field id adalah primary key dari entitas
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // mengindikasikan bahwa nilai primary key akan di-generate oleh database
    @Column(name = "id")  // anotasi yang menandakan bahwa field ini akan di-mapping ke kolom bernama "id" di dalam tabel database
    private int id;  // deklarasi field id dalam kelas entitas

    @Column(name = "date")  // field ini akan di-mapping ke kolom bernama "date" di dalam tabel database
    private Date date;  // deklarasi field date dalam kelas entitas

    @Column(name = "description")  // field ini akan di-mapping ke kolom bernama "description" di dalam tabel database
    private String description;  // deklarasi field description dalam kelas entitas

    @Column(name = "price")  // field ini akan di-mapping ke kolom bernama "price" di dalam tabel database
    private double price;  // deklarasi field price dalam kelas entitas


    public History() {

    }  // konstruktor default (tanpa parameter) dari kelas History

    public History(int id, Date date, String description, double price) {
        this.id = id;
        this.date = date;
        this.description = description;
        this.price = price;

    }  // konstruktor yang menerima parameter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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

    @Override  // anotasi yang menunjukkan bahwa metode ini di override dari metode dgn nama yg sama di superclassnya -> history
    public String toString() {
        return "History{" +
                "id=" + id +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}

CREATE DATABASE  IF NOT EXISTS `toko_caringin`;
USE `toko_caringin`;


CREATE TABLE barang (
    id INT AUTO_INCREMENT PRIMARY KEY,
    kode_barang VARCHAR(100) UNIQUE NOT NULL,
    nama_barang VARCHAR(100) NOT NULL,
    stock DECIMAL,
    satuan VARCHAR(100),
    rak VARCHAR(100),
    jenis VARCHAR(100),
    merek VARCHAR(100),
    harga_pokok DECIMAL,
    barcode BIGINT,
    tanggal DATE
);

INSERT INTO barang (kode_barang, nama_barang, stock, satuan, rak, jenis, merek, harga_pokok, barcode, tanggal) 
VALUES 
('c01', 'ciki jaguar', 1.0, 'satuan2', 'Rak 2', 'ciki', 'jaguar', 20000, 12, NOW()),
('c02', 'roti', 1.0, 'satuan2', 'Rak 2', 'roti', 'aoka', 3000, 12, NOW()),
('c03', 'keripik', 1.0, 'satuan2', 'Rak 2', 'keripik', 'darih', 5000, 12, NOW());


CREATE TABLE pelanggan (
    id INT AUTO_INCREMENT PRIMARY KEY,
    kode_pelanggan VARCHAR(100) UNIQUE NOT NULL,
    mata_uang VARCHAR(100),
    nama VARCHAR(100) NOT NULL,
    group_pelanggan VARCHAR(100),
    alamat VARCHAR(100) NOT NULL,
    kota VARCHAR(100),
    wilayah VARCHAR(100),
    sub_wilayah VARCHAR(100),
    tanggal DATE
);

INSERT INTO pelanggan (kode_pelanggan, mata_uang, nama, group_pelanggan, alamat, kota, wilayah, sub_wilayah, tanggal) 
VALUES 
('p002', 'Rupiah', 'Rizky Subagja', 'group test', 'cikalong wetan', 'bandung barat', 'test wilayah', 'test sub wilayah', NOW());


CREATE TABLE nota (
    id INT AUTO_INCREMENT PRIMARY KEY,
    kode_nota VARCHAR(100) UNIQUE NOT NULL,
    id_pelanggan INT NOT NULL,
    total DECIMAL NOT NULL,
    potongan DECIMAL NOT NULL,
    bayar DECIMAL NOT NULL,
    kembalian DECIMAL NOT NULL,
    tanggal DATE NOT NULL,
    FOREIGN KEY (id_pelanggan) REFERENCES pelanggan(id)
);

INSERT INTO nota (kode_nota, id_pelanggan, total, potongan, bayar, kembalian, tanggal) 
VALUES 
('n01', 1, 1, 0, 0, 0, NOW());


CREATE TABLE penjualan(
	id INT AUTO_INCREMENT PRIMARY KEY,
    id_barang INT NOT NULL,
    quantity BIGINT NOT NULL,
    id_nota INT NOT NULL,
    tanggal DATE NOT NULL,
    FOREIGN KEY (id_nota) REFERENCES nota(id),
    FOREIGN KEY (id_barang) REFERENCES barang(id)
);

INSERT INTO penjualan (id_barang, quantity, id_nota, tanggal) 
VALUES 
(1, 1, 1, NOW()),
(2, 1, 1, NOW()),
(2, 1, 1, NOW()),
(3, 1, 1, NOW());

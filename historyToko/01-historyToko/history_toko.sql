CREATE DATABASE  IF NOT EXISTS `history_toko`;
USE `history_toko`;

DROP TABLE IF EXISTS `history_toko`;

CREATE TABLE `history` (
    id INT AUTO_INCREMENT PRIMARY KEY,
    date DATE,
    description VARCHAR(255),
    price DECIMAL(10, 2)
);

INSERT INTO `history` VALUES 
	(1,'2024-02-26','Beras 1/2 Kg','180000'),
	(2,'2024-02-27','Gas 5 biji','200000'),
	(3,'2024-02-28','Minyak kelapa 8 kg','200000'),
	(4,'2024-02-29','Keripik darih 1 pak','50000');
    
CREATE TABLE `user_login` (
    username VARCHAR(50) PRIMARY KEY,
    password VARCHAR(255),
    roles VARCHAR(50)
);

INSERT INTO user_login (username, password, roles) VALUES 
('admin', 'root', 'admin'),
('user', 'root', 'user'),
('owner', 'root', 'owner');

    


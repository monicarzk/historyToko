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
    
    
USE `history_toko`;

DROP TABLE IF EXISTS `roles`;
DROP TABLE IF EXISTS `user_login`;

--
-- Table structure for table `users`
--

CREATE TABLE `user_login` (
  `username` varchar(50) NOT NULL,
  `password` char(68) NOT NULL,
  `active` tinyint NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserting data for table `users`
--
-- NOTE: The passwords are encrypted using BCrypt
--
-- A generation tool is avail at: https://www.luv2code.com/generate-bcrypt-password
--
-- Default passwords here are: root
--

INSERT INTO `user_login`
VALUES
('owner','{bcrypt}$2a$10$qankMJRqLtyirVGoy.6MkOCw6sciIU.VWwGNXIuuhhEGddS/V4LbO',1),
('user','{bcrypt}$2a$10$qankMJRqLtyirVGoy.6MkOCw6sciIU.VWwGNXIuuhhEGddS/V4LbO',1),
('admin','{bcrypt}$2a$10$qankMJRqLtyirVGoy.6MkOCw6sciIU.VWwGNXIuuhhEGddS/V4LbO',1);


--
-- Table structure for table `roles`
--

CREATE TABLE `roles` (
  `username` varchar(50) NOT NULL,
  `role` varchar(50) NOT NULL,
  UNIQUE KEY `authorities5_idx_1` (`username`,`role`),
  CONSTRAINT `authorities5_ibfk_1` FOREIGN KEY (`username`) REFERENCES `user_login` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserting data for table `roles`
--

INSERT INTO `roles`
VALUES
('owner','ROLE_OWNER'),
('user','ROLE_OWNER'),
('user','ROLE_USER'),
('admin','ROLE_OWNER'),
('admin','ROLE_USER'),
('admin','ROLE_ADMIN');

ALTER TABLE user_login
ALTER COLUMN username SET DEFAULT 'default_value';

    

    


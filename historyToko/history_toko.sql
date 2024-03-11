CREATE DATABASE  IF NOT EXISTS `history_toko`;
USE `history_toko`;

DROP TABLE IF EXISTS `history_toko`;

CREATE TABLE `history` (
    id INT AUTO_INCREMENT PRIMARY KEY,
    date DATE,
    description VARCHAR(255),
    price DECIMAL(10, 2)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
    
    
USE `history_toko`;

DROP TABLE IF EXISTS `roles`;
DROP TABLE IF EXISTS `user_login`;

--
-- Table structure for table `user_login`
--

CREATE TABLE `user_login` (
   id INT AUTO_INCREMENT PRIMARY KEY,
  `username` varchar(50) NOT NULL,
  `password` char(68) NOT NULL,
  `active` tinyint NOT NULL,
   INDEX `idx_username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserting data for table `user_login`
--
-- NOTE: The passwords are encrypted using BCrypt
--
-- A generation tool is avail at: https://www.luv2code.com/generate-bcrypt-password
--
-- Default passwords here are: root
--

INSERT INTO `user_login`
VALUES
(1,'owner','{bcrypt}$2a$10$qankMJRqLtyirVGoy.6MkOCw6sciIU.VWwGNXIuuhhEGddS/V4LbO',1),
(2,'user','{bcrypt}$2a$10$qankMJRqLtyirVGoy.6MkOCw6sciIU.VWwGNXIuuhhEGddS/V4LbO',1),
(3,'admin','{bcrypt}$2a$10$qankMJRqLtyirVGoy.6MkOCw6sciIU.VWwGNXIuuhhEGddS/V4LbO',1);

--
-- Table structure for table `roles`
--

CREATE TABLE `roles` (
  `username` varchar(50),
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

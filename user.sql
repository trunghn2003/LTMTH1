/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  wetech
 * Created: Sep 18, 2024
 */

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    ip_address VARCHAR(45)
);

INSERT INTO users (username, password, ip_address) VALUES ('testuser', 'testpass', '127.0.0.1');

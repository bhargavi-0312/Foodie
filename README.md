-> 🍴 Food Ordering App (Java Servlet + JDBC + MySQL)

This is a simple food ordering web app using Servlets, JDBC, and MySQL.

->  Features
- Add items to cart
- View cart & total price
- Connects to MySQL 'fooddb' database
- Deployed using Tomcat (Eclipse)

-->  Tech Stack
- Java Servlet + JSP
- JDBC + MySQL
- HTML/CSS
- Apache Tomcat
- Eclipse IDE

-->  How to Run
1. Import into Eclipse
2. Run on Tomcat Server
3. Access: 'http://localhost:8082/FoodDB/'

-->  Database Setup (MySQL)
sql
CREATE DATABASE fooddb;
USE fooddb;

CREATE TABLE orders (
    id INT AUTO_INCREMENT PRIMARY KEY,
    item_name VARCHAR(100),
    quantity INT,
    price INT,
    total_price INT
);



---"BON APPETIT"---

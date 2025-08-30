-> 🍴Foodie- Food Ordering App (Java Servlet + JDBC + MySQL)

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
-->OUTPUT
<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/d1ce1565-51aa-4466-8639-7ef4feb46129" />
<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/1adbc7c3-0b10-466b-8f0f-fdd484ae30e2" />
<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/abdd0750-4453-4686-9575-bad8a0e2ae61" />
<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/89026b78-e51b-4904-86b3-8a34c1a270ce" />






---"BON APPETIT"---

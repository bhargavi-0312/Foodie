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
<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/6ce111c2-c07b-4736-80e7-d57cd38b1d2e" />
<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/d73d5bc1-40ce-49a1-b71a-82473a72f689" />
<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/e59971aa-8776-4820-a52d-09e38ddf1216" />
<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/cc4aa9ff-2d06-41c2-997f-8f3d4862be44" />

---"BON APPETIT"---

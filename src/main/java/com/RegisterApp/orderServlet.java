package com.RegisterApp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/orderServlet")
public class orderServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        // 🧾 Hardcoded values (no need for input form)
        String itemName = "Sample Biryani";
        int price = 350;
        int quantity = 1;
        int total_price = price * quantity;

        // 💾 Insert into DB
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO orders(item_name, quantity, price, total_price) VALUES (?, ?, ?, ?)"
            );
            ps.setString(1, itemName);
            ps.setInt(2, quantity);
            ps.setInt(3, price);
            ps.setInt(4, total_price);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            out.println("<h3 style='color:red;'>Database Error</h3>");
            return;
        }

        // ✅ Output confirmation
        out.println("<!DOCTYPE html><html><head><title>Order Added</title></head><body>");
        out.println("<div style='margin-bottom: 10px;'>");
        out.println("<button onclick=\"location.href='menu.html'\">⬅ Menu</button> ");
        out.println("<button onclick=\"location.href='viewOrders'\">📄 View Orders</button>");
        out.println("</div>");
        out.println("<h2 style='color:green;'>Item Successfully Added to Cart</h2>");
        out.println("<p><strong>Item:</strong> " + itemName + "</p>");
        out.println("<p><strong>Price:</strong> ₹" + price + "</p>");
        out.println("<p><strong>Quantity:</strong> " + quantity + "</p>");
        out.println("<p><strong>Total:</strong> ₹" + total_price + "</p>");
        out.println("<br><button onclick=\"location.href='menu.html'\">⬅ Back to Menu</button>");
        out.println("</body></html>");
    }
}

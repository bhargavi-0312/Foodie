package com.RegisterApp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/viewOrders")
public class viewOrders extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        out.println("<html><head><title>Orders</title></head><body>");
        out.println("<h2>All Orders</h2>");
        out.println("<table border='1'>");
        out.println("<tr><th>Item</th><th>Price</th><th>Quantity</th><th>Total</th></tr>");

        int grandTotal = 0;

        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM orders");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String item = rs.getString("item_name");
                int price = rs.getInt("price");
                int qty = rs.getInt("quantity");
                int total = rs.getInt("total_price");

                out.println("<tr>");
                out.println("<td>" + item + "</td>");
                out.println("<td>₹" + price + "</td>");
                out.println("<td>" + qty + "</td>");
                out.println("<td>₹" + total + "</td>");
                out.println("</tr>");

                grandTotal += total;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            out.println("<p>Error loading orders</p>");
        }

        out.println("</table>");
        out.println("<h3>Grand Total: ₹" + grandTotal + "</h3>");
        out.println("<button onclick=\"location.href='nonveg.html'\">⬅ Back to Menu</button>");
        out.println("</body></html>");
    }
}

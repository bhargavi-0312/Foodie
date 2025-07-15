package com.RegisterApp;
import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/nonveg")
public class FoodServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	    res.setContentType("text/html");
	    PrintWriter out = res.getWriter();

	    // ✅ Check if user is logged in
	    HttpSession session = req.getSession(false);
	    String user = (session != null) ? (String) session.getAttribute("user") : null;

	    if (user == null) {
	        // ❌ Not logged in, redirect to login
	        res.sendRedirect("login.html");
	        return;
	    }

	    // ✅ Continue if logged in
	    try (Connection con = DBConnection.getConnection()) {
	        PreparedStatement stmt = con.prepareStatement("select * from food_items");
	        ResultSet rs = stmt.executeQuery();

	        out.println("<!DOCTYPE html>");
	        out.println("<html lang=\"en\">");
	        out.println("<head>");
	        out.println("    <meta charset=\"UTF-8\">");
	        out.println("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
	        out.println("    <title>Food Items</title>");
	        out.println("    <style>");
	        out.println("        .grid { display: grid; grid-template-columns: repeat(auto-fit, minmax(200px, 1fr)); gap: 20px; padding: 20px; }");
	        out.println("        .item { border: 1px solid #ccc; padding: 15px; text-align: center; border-radius: 8px; }");
	        out.println("        img { width: 100%; height: 150px; object-fit: cover; }");
	        out.println("        .btn { margin-top: 10px; padding: 10px 15px; background-color: green; color: white; border: none; border-radius: 5px; cursor: pointer; }");
	        out.println("    </style>");
	        out.println("</head>");
	        out.println("<body>");

	        // 🟩 Optional: Greet user
	        out.println("<h2>Welcome, " + user + "!</h2>");

	        // Start grid container
	        out.println("<div class='grid'>");

	        while (rs.next()) {
	            String itemtype = rs.getString("description");
	            String imgpath = rs.getString("img_path");
	            int price = rs.getInt("price");

	            // Wrap each form in a grid item
	            out.println("<div class='item'>");
	            out.println("<form action='orderServlet' method='get'>");
	            out.println("<img src=\"" + imgpath + "\" alt=\"no image\">");
	            out.println("<p>" + itemtype + "</p>");
	            out.println("<p>₹" + price + "</p>");
	            out.println("<input type='hidden' name='itemName' value='" + itemtype + "'>");
	            out.println("<input type='hidden' name='price' value='" + price + "'>");
	            out.println("<input type='hidden' name='quantity' value='1'>");
	            out.println("<button type='submit' class='btn'>Add to Cart</button>");
	            out.println("</form>");
	            out.println("</div>");
	        }

	        // End grid container
	        out.println("</div>");

	        out.println("</body>");
	        out.println("</html>");
	    } catch (SQLException e) {
	        e.printStackTrace();
	        out.println("<h3>Database Error: " + e.getMessage() + "</h3>");
	    }
	}

	
}
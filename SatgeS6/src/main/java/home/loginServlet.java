package home;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet(name="loginServlet" ,value="/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			PrintWriter out =response.getWriter();
			String username= request.getParameter("email");
			String password= request.getParameter("password");
			Connection cn=ConnectionDB.getConnection();
			PreparedStatement ps= cn.prepareStatement("Select email from compte where email=? and password=? ");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs= ps.executeQuery();
			if(rs.next()) {
			RequestDispatcher rd=request.getRequestDispatcher("home.jsp");
			rd.forward(request, response);
				
			}
			else {
				out.println("connection failed");
			}
			
			}catch(SQLException e){
			e.printStackTrace();
		}
	}
}

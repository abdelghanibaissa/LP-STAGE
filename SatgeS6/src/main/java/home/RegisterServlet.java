package home;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet(name="RegisterServlet" ,value="/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String fullname= request.getParameter("fullname");
			String username= request.getParameter("username");
			String email= request.getParameter("email");
			String password= request.getParameter("password");
			Connection cn=ConnectionDB.getConnection();
			PreparedStatement ps= cn.prepareStatement("insert into compte(fullname,username,email,password)values(?,?,?,?)");
			ps.setString(1, fullname);
			ps.setString(2, username);
			ps.setString(3, email);
			ps.setString(4, password);
			ps.executeUpdate();
			RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
			}catch(SQLException e){
			e.printStackTrace();
		}
	}
}

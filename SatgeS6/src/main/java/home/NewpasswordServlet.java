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
import java.sql.SQLException;

/**
 * Servlet implementation class NewpasswordServlet
 */
@WebServlet(name="NewpasswordServlet" ,value="/NewpasswordServlet")
public class NewpasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			PrintWriter out =response.getWriter();
			String email= request.getParameter("email");
			String newpassword= request.getParameter("newpassword");
			String password= request.getParameter("password");
			if(newpassword.equals(password)) {
				Connection cn=ConnectionDB.getConnection();
				PreparedStatement ps= cn.prepareStatement("UPDATE compte SET password=? WHERE email=?");
				ps.setString(1, password);
				ps.setString(2, email);
				ps.executeUpdate();
				RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);	
			}
			else if(email.equals("") || password.equals("") || newpassword.equals("")){
				out.println("remplir les champs");
			}
			}catch(SQLException e){
			e.printStackTrace();
		}
	}
}

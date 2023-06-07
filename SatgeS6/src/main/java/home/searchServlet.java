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
 * Servlet implementation class searchServlet
 */
@WebServlet(name="searchServlet" ,value="/searchServlet")
public class searchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			PrintWriter out =response.getWriter();
			String nom= request.getParameter("name");
			Connection cn= ConnectionDB.getConnection();
			PreparedStatement ps= cn.prepareStatement("SELECT*FROM empolyee WHERE nom=? ");
			ps.setString(1, nom);
			ResultSet rs= ps.executeQuery();
			if(rs.next()) {
			RequestDispatcher rd=request.getRequestDispatcher("search.jsp");
			rd.forward(request, response);
			out.println("Name exist");
			}	
			}catch(SQLException e){
			e.printStackTrace();
		}
	}
}
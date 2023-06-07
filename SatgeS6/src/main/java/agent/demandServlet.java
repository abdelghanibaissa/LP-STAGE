package agent;

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

import home.ConnectionDB;

/**
 * Servlet implementation class demandServlet
 */
@WebServlet(name="demandServlet" ,value="/demandServlet")
public class demandServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			PrintWriter out =response.getWriter();
			String reason= request.getParameter("reason");
			String explain= request.getParameter("explain");
			String status= "en cours";
			Connection cn=ConnectionDB.getConnection();
			PreparedStatement ps= cn.prepareStatement("INSERT INTO `demand`(`type`, `explain`, `status`) VALUES (?,?,?)");
			ps.setString(1, reason);
			ps.setString(2, explain);
			ps.setString(3, status);
			ps.executeUpdate();
			RequestDispatcher rd=request.getRequestDispatcher("demands.jsp");
			rd.forward(request, response);			
			}catch(SQLException e){
			e.printStackTrace();
		}
		
	}

}

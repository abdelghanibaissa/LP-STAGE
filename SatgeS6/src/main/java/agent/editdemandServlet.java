package agent;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import home.ConnectionDB;
/**
 * Servlet implementation class editdemandServlet
 */

public class editdemandServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			PrintWriter out =response.getWriter();
			String type= request.getParameter("ty");
			String explain= request.getParameter("exp");
			String id= request.getParameter("id_de");
			
				Connection cn=ConnectionDB.getConnection();
				PreparedStatement ps= cn.prepareStatement("UPDATE `demand` SET `type`=?,`explain`=? WHERE id_dem=?");
				ps.setString(2, type);
				ps.setString(3, explain);
				ps.setString(1,String.valueOf(id));
				ps.executeUpdate();
				RequestDispatcher rd=request.getRequestDispatcher("demands.jsp");
				rd.forward(request, response);	
			
		
			}catch(SQLException e){
			e.printStackTrace();
		}
	
	}

}

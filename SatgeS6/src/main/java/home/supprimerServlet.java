package home;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Servlet implementation class supprimerServlet
 */
public class supprimerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
		    String nom= request.getParameter("nom2");
			String prenom= request.getParameter("prenom2");
			Connection cn=ConnectionDB.getConnection();
			PreparedStatement ps= cn.prepareStatement("DELETE FROM empolyee WHERE nom=? AND prenom=?");
			ps.setString(1, nom);
			ps.setString(2, prenom);
			ps.executeUpdate();
			RequestDispatcher rd=request.getRequestDispatcher("pointeur.jsp");
			rd.forward(request, response);
			}catch(SQLException e){
			e.printStackTrace();

		}
	}

}

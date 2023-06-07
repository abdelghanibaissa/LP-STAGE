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
 * Servlet implementation class modifierServlet
 */
@WebServlet(name="modifierServlet" ,value="/modifierServlet")
public class modifierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
		    String nom= request.getParameter("nom1");
			String prenom= request.getParameter("prenom1");
			String tempsa= request.getParameter("tempsa");
			String tempss= request.getParameter("tempss");
			Connection cn=ConnectionDB.getConnection();
			Double res= Double.valueOf(tempss)-Double.valueOf(tempsa);
				if(res>=6.24 && res<8) {
					PreparedStatement ps= cn.prepareStatement("UPDATE empolyee SET temps_arriver=?,temps_sortie=?,pp=1,pf=0 WHERE nom=? AND prenom=?");
					ps.setString(1, String.valueOf(tempsa));
					ps.setString(2, String.valueOf(tempss));
					ps.setString(3, nom);
					ps.setString(4, prenom);
					ps.executeUpdate();
					RequestDispatcher rd=request.getRequestDispatcher("pointeur.jsp");
					rd.forward(request, response);
				}
				else if(res<6){
					PreparedStatement ps= cn.prepareStatement("UPDATE empolyee SET temps_arriver=?,temps_sortie=?,pp=0,pf=0 WHERE nom=? AND prenom=?");
					ps.setString(1, String.valueOf(tempsa));
					ps.setString(2, String.valueOf(tempss));
					ps.setString(3, nom);
					ps.setString(4, prenom);
					ps.executeUpdate();
					RequestDispatcher rd=request.getRequestDispatcher("pointeur.jsp");
					rd.forward(request, response);
				}
				else if(res>8){
					PreparedStatement ps= cn.prepareStatement("UPDATE empolyee SET temps_arriver=?,temps_sortie=?,pp=1,pf=1 WHERE nom=? AND prenom=?");
					ps.setString(1, String.valueOf(tempsa));
					ps.setString(2, String.valueOf(tempss));
					ps.setString(3, nom);
					ps.setString(4, prenom);
					ps.executeUpdate();
					RequestDispatcher rd=request.getRequestDispatcher("pointeur.jsp");
					rd.forward(request, response);
				}
			}catch(SQLException e){
			e.printStackTrace();
		}
	}
}

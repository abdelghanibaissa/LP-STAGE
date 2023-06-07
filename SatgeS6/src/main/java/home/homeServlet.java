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
 * Servlet implementation class homeServlet
 */
@WebServlet(name="homeServlet" ,value="/homeServlet")
public class homeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
		    String nom= request.getParameter("nom");
			String prenom= request.getParameter("prenom");
			String tempsa= request.getParameter("tempsa");
			String tempss= request.getParameter("tempss");
			Connection cn=ConnectionDB.getConnection();
			Double res= Double.valueOf(tempss)-Double.valueOf(tempsa);
			if(res>=6.24 && res<8){
				PreparedStatement ps= cn.prepareStatement("insert into empolyee (nom,prenom,temps_arriver,temps_sortie,pp,pf)values(?,?,?,?,1,0)");
				ps.setString(1, nom);
				ps.setString(2, prenom);
				ps.setString(3, String.valueOf(tempsa));
				ps.setString(4, String.valueOf(tempss));
				ps.executeUpdate();	
				RequestDispatcher rd=request.getRequestDispatcher("pointeur.jsp");
				rd.forward(request, response);
			}else if(res<6){
			PreparedStatement ps= cn.prepareStatement("insert into empolyee (nom,prenom,temps_arriver,temps_sortie,pp,pf)values(?,?,?,?,0,0)");
				ps.setString(1, nom);
				ps.setString(2, prenom);
				ps.setString(3, String.valueOf(tempsa));
				ps.setString(4, String.valueOf(tempss));
				ps.executeUpdate();
				RequestDispatcher rd=request.getRequestDispatcher("pointeur.jsp");
				rd.forward(request, response);
			}
			else if(res>8){
				PreparedStatement ps= cn.prepareStatement("insert into empolyee (nom,prenom,temps_arriver,temps_sortie,pp,pf)values(?,?,?,?,1,1)");
				ps.setString(1, nom);
				ps.setString(2, prenom);
				ps.setString(3, String.valueOf(tempsa));
				ps.setString(4, String.valueOf(tempss));
				ps.executeUpdate();																				
				RequestDispatcher rd=request.getRequestDispatcher("pointeur.jsp");
				rd.forward(request, response);
			}
			if(tempss.equals("") || tempsa.equals("")) {
				PreparedStatement ps= cn.prepareStatement("insert into empolyee (nom,prenom,temps_arriver,temps_sortie,pp,pf)values(?,?,0,0,0,0)");
				ps.setString(1, nom);
				ps.setString(2, prenom);
				ps.setString(3, String.valueOf(tempsa));
				ps.setString(4, String.valueOf(tempss));
				ps.executeUpdate();
				RequestDispatcher rd=request.getRequestDispatcher("pointeur.jsp");
				rd.forward(request, response);
			}
			}catch(SQLException e){
			e.printStackTrace();
		}
	}
}

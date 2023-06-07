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
 * Servlet implementation class editreclamationServlet
 */
public class editreclamationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editreclamationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			PrintWriter out =response.getWriter();
			String type= request.getParameter("ty");
			String explain= request.getParameter("exp");
			String id= request.getParameter("id_de");
			
				Connection cn=ConnectionDB.getConnection();
				PreparedStatement ps= cn.prepareStatement("UPDATE `reclamation` SET `reason`=?,`exlpain`=? WHERE `id_rec`=?");
				ps.setString(1, type);
				ps.setString(2, explain);
				ps.setString(3,String.valueOf(id));
				ps.executeUpdate();
				RequestDispatcher rd=request.getRequestDispatcher("reclamation.jsp");
				rd.forward(request, response);	
			
		
			}catch(SQLException e){
			e.printStackTrace();
		}
	}

}

package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Vehicle;
import models.VehicleDAO;

/**
 * public class using server code to display vehicles stored in the database on a web page using an HTML table based on the searched criteria
 * @author Reece
 */
public class ServletSearchVehicle extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		VehicleDAO dao = new VehicleDAO();
		String search = (String) req.getParameter("search");
		ArrayList<Vehicle> searchVehicles = dao.searchVehicles(search);
		
		RequestDispatcher view = req.getRequestDispatcher("search.jsp");
		req.setAttribute("searchVehicles", searchVehicles);
		view.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		String searchSubmit = req.getParameter("searchBox");
		resp.sendRedirect("search?search=" + searchSubmit);
	}
}
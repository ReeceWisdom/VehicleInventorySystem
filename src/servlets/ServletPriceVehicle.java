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
 * public class using server code to display vehicles stored in the database on a web page using an HTML table based on the price range criteria
 * @author Reece
 */
public class ServletPriceVehicle extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		VehicleDAO dao = new VehicleDAO();
		int priceMin = Integer.valueOf(req.getParameter("priceMin"));
		int priceMax = Integer.valueOf(req.getParameter("priceMax"));
		ArrayList<Vehicle> priceVehicles = dao.priceVehicles(priceMin, priceMax);
		
		RequestDispatcher view = req.getRequestDispatcher("price.jsp");
		req.setAttribute("priceVehicles", priceVehicles);
		view.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		String priceMinSubmit = req.getParameter("priceMinBox");
		String priceMaxSubmit = req.getParameter("priceMaxBox");
		resp.sendRedirect("price?priceMin=" + priceMinSubmit + "&priceMax=" + priceMaxSubmit);
	}

}
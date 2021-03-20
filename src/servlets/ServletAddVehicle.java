package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Vehicle;
import models.VehicleDAO;

/**
 * public class using server code to add vehicles to the database via a web page using an HTML form
 * @author Reece
 */
public class ServletAddVehicle extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		RequestDispatcher view = req.getRequestDispatcher("add.jsp");
		view.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		int vehicle_id = Integer.valueOf(req.getParameter("vehicle_id"));
		String make = (String) req.getParameter("make");
		String model = (String) req.getParameter("model");
		int year = Integer.valueOf(req.getParameter("year"));
		int price = Integer.valueOf(req.getParameter("price"));
		String license_number = (String) req.getParameter("license_number");
		String colour = (String) req.getParameter("colour");
		int number_doors = Integer.valueOf(req.getParameter("number_doors"));
		String transmission = (String) req.getParameter("transmission");
		int mileage = Integer.valueOf(req.getParameter("mileage"));
		String fuel_type = (String) req.getParameter("fuel_type");
		int engine_size = Integer.valueOf(req.getParameter("engine_size"));
		String body_style = (String) req.getParameter("body_style");
		String condition = (String) req.getParameter("condition");
		String notes = (String) req.getParameter("notes");
		
		VehicleDAO dao = new VehicleDAO();
		Vehicle v = new Vehicle(vehicle_id, make, model, year, price, license_number, colour, number_doors, 
				                transmission, mileage, fuel_type, engine_size, body_style, condition, notes);
		try
		{
			boolean complete = dao.insertVehicle(v);
			System.out.println(complete);
			if (complete)
			{
				resp.sendRedirect("home");
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}	
	}
}
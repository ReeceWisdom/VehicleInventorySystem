package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import models.Vehicle;
import models.VehicleDAO;

public class ServletAPI extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	VehicleDAO dao = new VehicleDAO();
	Gson gson = new Gson();
	PrintWriter writer;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		ArrayList<Vehicle> allVehicles = dao.selectAllVehicles();
		resp.setContentType("application/json");
		writer = resp.getWriter();
		String vehicleJSON = gson.toJson(allVehicles);
		writer.write(vehicleJSON);
		writer.close();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		writer = resp.getWriter();
		resp.setContentType("text/html.charset=UTF-8");
		
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
		
	    Vehicle v = new Vehicle(vehicle_id, make, model, year, price, license_number, colour, number_doors, 
                transmission, mileage, fuel_type, engine_size, body_style, condition, notes);
		
	    System.out.println(v.getVehicle_id() + " " + v.getMake() + " " + v.getModel()  + " " + v.getYear()  + " " + v.getPrice() + " " + 
		v.getLicense_number() + " " + v.getColour() + " " + v.getNumber_doors() + " " +	v.getTransmission() + " " +	v.getMileage() + " " + 
		v.getFuel_type() + " " + v.getEngine_size() + " " + v.getBody_style() + " " + v.getCondition() + " " + v.getNotes());

		try
		{
			boolean complete = dao.insertVehicle(v);
			System.out.println(complete);
			if (complete)
			{
				writer.write("New Vehicle Inserted");
			}
			else
			{
				writer.write("Error!");
			}
			writer.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		writer = resp.getWriter();
		resp.setContentType("text/html.charset=UTF-8");
		
		int vehicle_id = Integer.valueOf(req.getParameter("vehicle_id"));
		
		try
		{
			boolean complete = dao.deleteVehicle(vehicle_id);
			System.out.println(complete);
			if (complete)
			{
				writer.write("Vehicle Deleted");
			}
			else
			{
				writer.write("Error!");
			}
			writer.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}	
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		writer = resp.getWriter();
		resp.setContentType("text/html.charset=UTF-8");
		
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
		
		Vehicle v = new Vehicle(vehicle_id, make, model, year, price, license_number, colour, number_doors, 
                transmission, mileage, fuel_type, engine_size, body_style, condition, notes);
		
		try
		{
			boolean complete = dao.updateVehicle(vehicle_id, v);
			System.out.println(complete);
			if (complete)
			{
				writer.write("Vehicle Updated");
			}
			writer.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}

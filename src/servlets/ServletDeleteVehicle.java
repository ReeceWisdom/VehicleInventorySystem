package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.VehicleDAO;

/**
 * public class using server code to delete a vehicle in the database via passing the vehicle's parameters to the SQL command
 * @author Reece
 */
public class ServletDeleteVehicle extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		VehicleDAO dao = new VehicleDAO();
		int vehicle_id = Integer.valueOf(req.getParameter("vehicle_id"));
		try
		{
			boolean complete = dao.deleteVehicle(vehicle_id);
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
package models;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

//import models.Vehicle;

/**
 * interface to the SQLite database (CRUD methods/operations)
 * @author Reece
 */
public class VehicleDAO
{
	Connection c = null;
	Statement s = null;
	ResultSet r = null;
	
	/**
	 * constructor establishing connection to database
	 * @return connection to database
	 */
	public Statement getConnection()
	{
		try 
		{
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:vehicles.sqlite");
			s = c.createStatement();				
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException c)
		{
			c.printStackTrace();
		}		
		return s;
    }
	
	/**
	 * method to close connection to database
	 */
	public void closeConnection()
	{
		try
	    {
			if(s!=null)
		    {
				s.close();
		    }
		    if(c!=null)
		    {
			    c.close();
		    }
	    }
	    catch (SQLException e)
	    {
	    	e.printStackTrace();
	    }
    }

	/**
	 * method to retrieve all vehicles from the database
	 * @return all vehicles within the database
	 */
	public ArrayList<Vehicle> selectAllVehicles()
	{		
		ArrayList<Vehicle> vehiclesArray = new ArrayList<Vehicle>();
		try
		{
			String sql = "SELECT * FROM  vehicles";
			System.out.println("DBQuery = " + sql);
			ResultSet rs = getConnection().executeQuery(sql);
			
			if(rs != null)
			{
				while(rs.next())
				{					
					Vehicle vehicle = new Vehicle();					
					try
					{
						vehicle.setVehicle_id(rs.getInt("Vehicle_id"));
						vehicle.setMake(rs.getString("Make"));
						vehicle.setModel(rs.getString("Model"));
						vehicle.setYear(rs.getInt("Year"));
						vehicle.setPrice(rs.getInt("Price"));
						vehicle.setLicense_number(rs.getString("License_number"));
						vehicle.setColour(rs.getString("Colour"));
						vehicle.setNumber_doors(rs.getInt("Number_doors"));
						vehicle.setTransmission(rs.getString("Transmission"));
						vehicle.setMileage(rs.getInt("Mileage"));
						vehicle.setFuel_type(rs.getString("Fuel_type"));
						vehicle.setEngine_size(rs.getInt("Engine_size"));
						vehicle.setBody_style(rs.getString("Body_style"));
						vehicle.setCondition(rs.getString("Condition"));
						vehicle.setNotes(rs.getString("Notes"));
				    }
					catch(SQLException s)
					{
						s.printStackTrace();
				    }							
					vehiclesArray.add(vehicle);
				}				
				rs.close();
			}
		}
		catch (SQLException s)
		{
			System.out.println(s);
		}
		closeConnection();
		return vehiclesArray;
	}
	
	/**
	 * method to retrieve a selected vehicle from the database
	 * @param vehicle_id Vehicle ID variable
	 * @return vehicles matching the Vehicle ID input
	 * @throws SQLException if the SQL command cannot be completed
	 */
	public Vehicle selectVehicle(int vehicle_id) throws SQLException
	{		
		Vehicle selectV = null;
		try
		{
			String sql = "SELECT * FROM vehicles WHERE vehicle_id = " + vehicle_id + ";";
			System.out.println("DBQuery = " + sql);
			ResultSet rs = getConnection().executeQuery(sql);
			
			if(rs != null)
			{
				while(rs.next())
				{									
					try
					{
						vehicle_id = rs.getInt("Vehicle_id");
						String make = rs.getString("Make");
						String model = rs.getString("Model");
						int year = rs.getInt("Year");
						int price = rs.getInt("Price");
						String license_number = rs.getString("License_number");
						String colour = rs.getString("Colour");
						int number_doors = rs.getInt("Number_doors");
						String transmission = rs.getString("Transmission");
						int mileage = rs.getInt("Mileage");
						String fuel_type = rs.getString("Fuel_type");
						int engine_size = rs.getInt("Engine_size");
						String body_style = rs.getString("Body_style");
						String condition = rs.getString("Condition");
						String notes = rs.getString("Notes");
						
						selectV = new Vehicle(vehicle_id, make, model, year, price, license_number, colour, 
								number_doors, transmission, mileage, fuel_type, engine_size, body_style, condition, notes);
				    }
					catch(SQLException s)
					{
						s.printStackTrace();
				    }
				}				
				rs.close();
			}
		}
		catch (SQLException s)
		{
			System.out.println(s);
		}
		closeConnection();
		return selectV;
	}

	/**
	 * method to delete a selected vehicle from the database
	 * @param vehicle_id Vehicle ID variable
	 * @return true when the vehicle has been deleted
	 * @throws SQLException if the SQL command cannot be completed
	 */
	public boolean deleteVehicle(int vehicle_id) throws SQLException
	{
		boolean b = false;
		try
		{
			String sql = "DELETE FROM vehicles WHERE vehicle_id = " + vehicle_id + ";";
			System.out.println("DBQuery = " + sql);
			b = getConnection().execute(sql);
			closeConnection();
			b = true;
	    }
		catch (SQLException s)
		{
			throw new SQLException("Vehicle Not Deleted");
		}	
		return b;
	}
	
	/**
	 * method to add a new vehicle to the database
	 * @param v Vehicle object
	 * @return true when the vehicle has been added
	 * @throws SQLException if the SQL command cannot be completed
	 */
	public boolean insertVehicle(Vehicle v) throws SQLException
	{		
		boolean b = false;
		try
		{
			String sql = "INSERT INTO vehicles (Vehicle_id, Make, Model, Year, Price, License_number, Colour, " 
					   + "Number_doors, Transmission, Mileage, Fuel_type, Engine_size, Body_style, Condition, Notes)"
					   + "values ('"+ v.getVehicle_id() + "','" + v.getMake() + "','" + v.getModel() + "','" 
					   + v.getYear() + "','" + v.getPrice() + "','" + v.getLicense_number() + "','" 
					   + v.getColour() + "','" + v.getNumber_doors() + "','" + v.getTransmission() + "','" 
					   + v.getMileage() + "','" + v.getFuel_type() + "','" + v.getEngine_size() + "','" 
					   + v.getBody_style() + "','" + v.getCondition() + "','" + v.getNotes() + "');";
			System.out.println("DBQuery = " + sql);
			b = getConnection().execute(sql);
			closeConnection();
			b = true;
		}
		catch (SQLException s)
		{
			throw new SQLException("Vehicle Not Added");
		}	  
		return b;
	}
	
	/**
	 * method to update a vehicle currently in the database
	 * @param vehicle_id Vehicle ID variable
	 * @param v Vehicle object
	 * @return true when the vehicle had been updated
	 * @throws SQLException if the SQL command cannot be completed
	 */
	public boolean updateVehicle(int vehicle_id, Vehicle v) throws SQLException
	{
		boolean b = false;
		try
		{
			String sql = "UPDATE vehicles SET Make = '" + v.getMake() + "', Model = '" + v.getModel() + 
					     "', Year = '" + v.getYear() + "', Price = '" + v.getPrice() + 
					     "', License_number = '" + v.getLicense_number() + "', Colour = '" + v.getColour() + 
					     "', Number_doors = '" + v.getNumber_doors() + "', Transmission = '" + v.getTransmission() + 
					     "', Mileage = '" + v.getMileage() + "', Fuel_type = '" + v.getFuel_type() + 
					     "', Engine_size = '" + v.getEngine_size() + "', Body_style = '" + v.getBody_style() + 
					     "', Condition = '" + v.getCondition() + "', Notes = '" + v.getNotes() + 
					     "' WHERE vehicle_id = " + v.getVehicle_id() + ";";
			System.out.println("DBQuery = " + sql);
			b = getConnection().execute(sql);
			closeConnection();
			b = true;
		}
		catch (SQLException s)
		{
			throw new SQLException("Vehicle Not Updated");
		}		
		return b;
	}
	
	/**
	 * method to search & retrieve all vehicles from the database which meet the criteria
	 * @return all vehicles within the database which meet the criteria
	 */
	public ArrayList<Vehicle> searchVehicles(String search)
	{		
		ArrayList<Vehicle> vehiclesArray = new ArrayList<Vehicle>();
		String sql = "";
		try
		{
			try
			{
				int searchInt = Integer.parseInt(search);
				sql = "SELECT * FROM  vehicles WHERE vehicle_id = " + searchInt + " OR make = " + searchInt + 
						     " OR model = " + searchInt + " OR year = " + searchInt + " OR price = " + searchInt + 
						     " OR license_number = " + searchInt + " OR colour = " + searchInt + " OR number_doors = " + 
						     searchInt + " OR transmission = " + searchInt + " OR mileage = " + searchInt + " OR fuel_type = " + 
						     searchInt + " OR engine_size = " + searchInt + " OR body_style = " + searchInt + " OR condition = " + 
						     searchInt + " OR notes = " + searchInt + ";";
			}
			catch (NumberFormatException e)
			{
				sql = "SELECT * FROM  vehicles WHERE make LIKE '%" + search + "%' OR model LIKE '%" + search + 
					  "%' OR license_number LIKE '%" + search + "%' OR colour LIKE '%" + search + "%' OR transmission LIKE '%" + 
					  search + "%' OR fuel_type LIKE '%" + search + "%' OR body_style LIKE '%" + search + "%' OR condition LIKE '%" + 
					  search + "%' OR notes LIKE '%" + search + "%';";
			}
			
			System.out.println("DBQuery = " + sql);
			ResultSet rs = getConnection().executeQuery(sql);
			
			if(rs != null)
			{
				while(rs.next())
				{					
					Vehicle vehicle = new Vehicle();					
					try
					{
						vehicle.setVehicle_id(rs.getInt("Vehicle_id"));
						vehicle.setMake(rs.getString("Make"));
						vehicle.setModel(rs.getString("Model"));
						vehicle.setYear(rs.getInt("Year"));
						vehicle.setPrice(rs.getInt("Price"));
						vehicle.setLicense_number(rs.getString("License_number"));
						vehicle.setColour(rs.getString("Colour"));
						vehicle.setNumber_doors(rs.getInt("Number_doors"));
						vehicle.setTransmission(rs.getString("Transmission"));
						vehicle.setMileage(rs.getInt("Mileage"));
						vehicle.setFuel_type(rs.getString("Fuel_type"));
						vehicle.setEngine_size(rs.getInt("Engine_size"));
						vehicle.setBody_style(rs.getString("Body_style"));
						vehicle.setCondition(rs.getString("Condition"));
						vehicle.setNotes(rs.getString("Notes"));
				    }
					catch(SQLException s)
					{
						s.printStackTrace();
				    }							
					vehiclesArray.add(vehicle);
				}				
				rs.close();
			}
		}
		catch (SQLException s)
		{
			System.out.println(s);
		}
		closeConnection();
		return vehiclesArray;
	}
	
	/**
	 * method to search & retrieve all vehicles from the database between a price range
	 * @return all vehicles within the database which prices are between the price range
	 */
	public ArrayList<Vehicle> priceVehicles(int priceMin, int priceMax)
	{		
		ArrayList<Vehicle> vehiclesArray = new ArrayList<Vehicle>();
		try
		{
			String sql = "SELECT * FROM  vehicles WHERE price BETWEEN " + priceMin + " AND " + priceMax + ";";
			System.out.println("DBQuery = " + sql);
			ResultSet rs = getConnection().executeQuery(sql);
			if(rs != null)
			{
				while(rs.next())
				{
					Vehicle vehicle = new Vehicle();					
					try
					{
						vehicle.setVehicle_id(rs.getInt("Vehicle_id"));
						vehicle.setMake(rs.getString("Make"));
						vehicle.setModel(rs.getString("Model"));
						vehicle.setYear(rs.getInt("Year"));
						vehicle.setPrice(rs.getInt("Price"));
						vehicle.setLicense_number(rs.getString("License_number"));
						vehicle.setColour(rs.getString("Colour"));
						vehicle.setNumber_doors(rs.getInt("Number_doors"));
						vehicle.setTransmission(rs.getString("Transmission"));
						vehicle.setMileage(rs.getInt("Mileage"));
						vehicle.setFuel_type(rs.getString("Fuel_type"));
						vehicle.setEngine_size(rs.getInt("Engine_size"));
						vehicle.setBody_style(rs.getString("Body_style"));
						vehicle.setCondition(rs.getString("Condition"));
						vehicle.setNotes(rs.getString("Notes"));
				    }
					catch(SQLException s)
					{
						s.printStackTrace();
				    }							
					vehiclesArray.add(vehicle);
				}				
				rs.close();
			}
		}
		catch (SQLException s)
		{
			System.out.println(s);
		}
		closeConnection();
		return vehiclesArray;
	}
}
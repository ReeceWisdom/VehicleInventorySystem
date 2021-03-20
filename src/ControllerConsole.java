import java.util.ArrayList;
import java.util.Scanner;

import models.Vehicle;
import models.VehicleDAO;

/**
 * public class testing CRUD (Create, Retrieve, Update and Delete) operations' functionality via a console menu system
 * @author Reece
 */
public class ControllerConsole
{	
	public static void main(String[] args) throws Exception
	{
		VehicleDAO dao = new VehicleDAO();
		Scanner in = new Scanner(System.in);
		int option = 0;
		int id;
		boolean z = true;
		
		while(z)
		{
			if (option == 0)
			{
				System.out.println("------------------------------------------");
			}
			else
			{
				System.out.println("\n\n\n\n------------------------------------------");
			}
			System.out.println("Vehicle Inventory System");
			System.out.println("Please Choose an Option");
			System.out.println("------------------------------------------");
			System.out.println("1 - Retrieve All Vehicles");
			System.out.println("2 - Search For Vehicle");
			System.out.println("3 - Add New Vehicle to Database");
			System.out.println("4 - Delete Existing Vehicle From Database");
			System.out.println("5 - Update Existing Vehicle From Database");
			System.out.println("6 - Exit Console");
			System.out.println("------------------------------------------");
			
			option = in.nextInt();
			switch (option)
			{
			case 1: //Retrieve All Vehicles
				System.out.println("Retrieving All Vehicles...");
				ArrayList<Vehicle> vehiclesArray = null;
				vehiclesArray = dao.selectAllVehicles();
				for (Vehicle v : vehiclesArray)
				{
					System.out.println("------------------------------------------");
					System.out.println("Vehicle ID: " + v.getVehicle_id());
					System.out.println("Make: " + v.getMake());
					System.out.println("Model: " + v.getModel());
					System.out.println("Year: " + v.getYear());
					System.out.println("Price: " + v.getPrice());
					System.out.println("License Number: " + v.getLicense_number());
					System.out.println("Colour: " + v.getColour());
					System.out.println("Number Doors: " + v.getNumber_doors());
					System.out.println("Transmission: " + v.getTransmission());
					System.out.println("Mileage: " + v.getMileage());
					System.out.println("Fuel Type: " + v.getFuel_type());
					System.out.println("Engine Size: " + v.getEngine_size());
					System.out.println("Body Style: " + v.getBody_style());
					System.out.println("Condition: " + v.getCondition());
					System.out.println("Notes: " + v.getNotes());
					System.out.println("------------------------------------------");
				}
				break;
				
			case 2: //Retrieve Selected Vehicle
				System.out.println("Please Enter The Vehicle's ID >>> ");
				id = in.nextInt();
				System.out.println("Retrieving Selected Vehicle...");
				Vehicle v = dao.selectVehicle(id);
				System.out.println("------------------------------------------");
				System.out.println("Vehicle ID: " + v.getVehicle_id());
				System.out.println("Make: " + v.getMake());
				System.out.println("Model: " + v.getModel());
				System.out.println("Year: " + v.getYear());
				System.out.println("Price: " + v.getPrice());
				System.out.println("License Number: " + v.getLicense_number());
				System.out.println("Colour: " + v.getColour());
				System.out.println("Number Doors: " + v.getNumber_doors());
				System.out.println("Transmission: " + v.getTransmission());
				System.out.println("Mileage: " + v.getMileage());
				System.out.println("Fuel Type: " + v.getFuel_type());
				System.out.println("Engine Size: " + v.getEngine_size());
				System.out.println("Body Style: " + v.getBody_style());
				System.out.println("Condition: " + v.getCondition());
				System.out.println("Notes: " + v.getNotes());
				System.out.println("------------------------------------------");
				break;
				
			case 3: //Add Vehicle
				System.out.println("Please Enter New Vehicle Details...");
				System.out.println("Vehicle ID >>> ");
				int vehicle_id = in.nextInt();
				in.nextLine();
				System.out.println("Make >>> ");
				String make = in.nextLine();
				System.out.println("Model >>> ");
				String model = in.nextLine();
				System.out.println("Year >>> ");
				int year = in.nextInt();
				in.nextLine();
				System.out.println("Price >>> ");
				int price = in.nextInt();
				in.nextLine();
				System.out.println("License Number >>> ");
				String license_number = in.nextLine();
				System.out.println("Colour >>> ");
				String colour = in.nextLine();
				System.out.println("Number of Doors >>> ");
				int number_doors = in.nextInt();
				in.nextLine();
				System.out.println("Transmission >>> ");
				String transmission = in.nextLine();
				System.out.println("Mileage >>> ");
				int mileage = in.nextInt();
				in.nextLine();
				System.out.println("Fuel Type >>> ");
				String fuel_type = in.nextLine();
				System.out.println("Engine Size >>> ");
				int engine_size = in.nextInt();
				in.nextLine();
				System.out.println("Body Style >>> ");
				String body_style = in.nextLine();
				System.out.println("Condition >>> ");
				String condition = in.nextLine();
				System.out.println("Notes >>> ");
				String notes = in.nextLine();
				Vehicle addV = new Vehicle(vehicle_id, make, model, year, price, license_number, colour, 
						number_doors, transmission, mileage, fuel_type, engine_size, body_style, condition, notes);
				dao.insertVehicle(addV);
				System.out.println("Vehicle Added!");
				break;
				
			case 4: //Delete Vehicle
				System.out.println("Please Enter The Vehicle's ID >>> ");
				id = in.nextInt();
				System.out.println(dao.deleteVehicle(id));
				System.out.println("Vehicle Deleted!");
				break;
				
			case 5: //Update Vehicle
				System.out.println("Please Enter Vehicle's New Details...");
				System.out.println("Vehicle ID >>> ");
				vehicle_id = in.nextInt();
				in.nextLine();
				System.out.println("Make >>> ");
				make = in.nextLine();
				System.out.println("Model >>> ");
				model = in.nextLine();
				System.out.println("Year >>> ");
				year = in.nextInt();
				in.nextLine();
				System.out.println("Price >>> ");
				price = in.nextInt();
				in.nextLine();
				System.out.println("License Number >>> ");
				license_number = in.nextLine();
				System.out.println("Colour >>> ");
				colour = in.nextLine();
				System.out.println("Number of Doors >>> ");
				number_doors = in.nextInt();
				in.nextLine();
				System.out.println("Transmission >>> ");
				transmission = in.nextLine();
				System.out.println("Mileage >>> ");
				mileage = in.nextInt();
				in.nextLine();
				System.out.println("Fuel Type >>> ");
				fuel_type = in.nextLine();
				System.out.println("Engine Size >>> ");
				engine_size = in.nextInt();
				in.nextLine();
				System.out.println("Body Style >>> ");
				body_style = in.nextLine();
				System.out.println("Condition >>> ");
				condition = in.nextLine();
				System.out.println("Notes >>> ");
				notes = in.nextLine();
				Vehicle updateV = new Vehicle(vehicle_id, make, model, year, price, license_number, colour, 
						number_doors, transmission, mileage, fuel_type, engine_size, body_style, condition, notes);
				dao.updateVehicle(vehicle_id, updateV);
				System.out.println("Vehicle Updated!");
				break;
				
			case 6: //Exit from Console
				System.out.println("Session Terminated...");
				z = false;
				break;
				
			default:
				System.out.println("Invalid Input");
				break;
			}
		}
		in.close();
	}
}
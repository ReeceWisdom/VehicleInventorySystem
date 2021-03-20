package models;

/**
 * public class managing Vehicle objects
 * Vehicle variables are defined
 * @author Reece
 */
public class Vehicle
{
	/**
	 * empty Vehicle constructor
	 */
	public Vehicle() {}
	
	/**
	 * Vehicle variables
	 * int for numbers & String for text variables
	 */
	private int vehicle_id;
	private String make;
	private String model;
	private int year;
	private int price;
	private String license_number;
	private String colour;
	private int number_doors;
	private String transmission;
	private int mileage;
	private String fuel_type;
	private int engine_size;
	private String body_style;
	private String condition;
	private String notes;
	
	/**
	 * Vehicle constructor initialising its variables
	 * @param vehicle_id
	 * @param make
	 * @param model
	 * @param year
	 * @param price
	 * @param license_number
	 * @param colour
	 * @param number_doors
	 * @param transmission
	 * @param mileage
	 * @param fuel_type
	 * @param engine_size
	 * @param body_style
	 * @param condition
	 * @param notes
	 */
	public Vehicle (int vehicle_id, String make, String model, int year, int price, String license_number, 
			        String colour, int number_doors, String transmission, int mileage, String fuel_type, 
			        int engine_size, String body_style, String condition, String notes)
	{
		this.vehicle_id = vehicle_id;
		this.make = make;
		this.model = model;
		this.year = year;
		this.price = price;
		this.license_number = license_number;
		this.colour = colour;
		this.number_doors = number_doors;
		this.transmission = transmission;
		this.mileage = mileage;
		this.fuel_type = fuel_type;
		this.engine_size = engine_size;
		this.body_style = body_style;
		this.condition = condition;
		this.notes = notes;
	}
	
	/**
	 * vehicle_id getter & setter method
	 * @return Vehicle's ID
	 */
	public int getVehicle_id() { return vehicle_id; }
	public void setVehicle_id(int vehicle_id) { this.vehicle_id = vehicle_id; }
	
	/**
	 * make getter & setter method
	 * @return Vehicle's Make
	 */
	public String getMake() { return make; }
	public void setMake(String make) { this.make = make; }
	
	/**
	 * model getter & setter method
	 * @return Vehicle's Model
	 */
	public String getModel() { return model; }
	public void setModel(String model) { this.model = model; }
	
	/**
	 * year getter & setter method
	 * @return Vehicle's Year
	 */
	public int getYear() { return year; }
	public void setYear(int year) { this.year = year; }
	
	/**
	 * price getter & setter method
	 * @return Vehicle's Price
	 */
	public int getPrice() { return price; }
	public void setPrice(int price) { this.price = price; }
	
	/**
	 * license_number getter & setter method
	 * @return Vehicle's License Number
	 */
	public String getLicense_number() {	return license_number; }
	public void setLicense_number(String license_number) { this.license_number = license_number; }
	
	/**
	 * colour getter & setter method
	 * @return Vehicle's Colour
	 */
	public String getColour() { return colour; }
	public void setColour(String colour) { this.colour = colour; }
	
	/**
	 * number_doors getter & setter method
	 * @return Vehicle's Number of Doors
	 */
	public int getNumber_doors() { return number_doors;	}
	public void setNumber_doors(int number_doors) {	this.number_doors = number_doors; }
	
	/**
	 * transmission_type getter & setter method
	 * @return Vehicle's Transmission Type
	 */
	public String getTransmission() { return transmission; }
	public void setTransmission(String transmission) { this.transmission = transmission; }
	
	/**
	 * mileage getter & setter method
	 * @return Vehicle's Mileage
	 */
	public int getMileage() { return mileage; }
	public void setMileage(int mileage) { this.mileage = mileage; }
	
	/**
	 * fuel_type getter & setter method
	 * @return Vehicle's Fuel Type
	 */
	public String getFuel_type() { return fuel_type; }
	public void setFuel_type(String fuel_type) { this.fuel_type = fuel_type; }
	
	/**
	 * engine_size getter & setter method
	 * @return Vehicle's Engine Size
	 */
	public int getEngine_size() { return engine_size; }
	public void setEngine_size(int engine_size) { this.engine_size = engine_size; }
	
	/**
	 * body_style getter & setter method
	 * @return Vehicle's Body Style
	 */
	public String getBody_style() { return body_style; }
	public void setBody_style(String body_style) { this.body_style = body_style; }
	
	/**
	 * condition getter & setter method
	 * @return Vehicle's Condition
	 */
	public String getCondition() { return condition; }
	public void setCondition(String condition) { this.condition = condition; }
	
	/**
	 * notes getter & setter method
	 * @return Vehicle's Notes
	 */
	public String getNotes() { return notes; }
	public void setNotes(String notes) { this.notes = notes; }
}

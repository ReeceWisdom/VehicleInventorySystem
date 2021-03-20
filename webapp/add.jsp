<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html id = "AddUpdateHTML">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/style.css">
<title>Add Vehicle</title>
</head>
<body>
<a href="./home" ><img id = "Home2Img" src="images/home.png" alt="home"></a><h1>Add Vehicle</h1>
<form method="POST" action="./add">
	<table id = "AddTable">
		<tr>
    		<td>Vehicle ID: </td>
    		<td><input type="text" name="vehicle_id"></td>
  		</tr>
  		<tr>
 			<td>Make: </td>
    		<td><input type="text" name="make"></td>
  		</tr>
  		<tr>
    		<td>Model: </td>
    		<td><input type="text" name="model"></td>
  		</tr>
  		<tr>
 			<td>Year: </td>
    		<td><input type="text" name="year"></td>
  		</tr>
  		<tr>
    		<td>Price: </td>
    		<td><input type="text" name="price"></td>
  		</tr>
  		<tr>
 			<td>License No.: </td>
    		<td><input type="text" name="license_number" maxlength=7></td>
  		</tr>
  		<tr>
 			<td>Colour: </td>
    		<td><input type="text" name="colour"></td>
  		</tr>
  		<tr>
 			<td>No. Doors: </td>
    		<td><input type="text" name="number_doors"></td>
  		</tr>
  		<tr>
 			<td>Transmission: </td>
    		<td><input type="text" name="transmission"></td>
  		</tr>
  		<tr>
 			<td>Mileage: </td>
    		<td><input type="text" name="mileage"></td>
  		</tr>
  		<tr>
 			<td>Fuel Type: </td>
    		<td><input type="text" name="fuel_type"></td>
  		</tr>
  		<tr>
 			<td>Engine Size: </td>
    		<td><input type="text" name="engine_size"></td>
  		</tr>
  		<tr>
 			<td>Body Style: </td>
    		<td><input type="text" name="body_style"></td>
  		</tr>
  		<tr>
 			<td>Condition: </td>
    		<td><input type="text" name="condition"></td>
  		</tr>
  		<tr>
 			<td>Notes: </td>
    		<td><input type="text" name="notes"></td>
  		</tr>
  		<tr>
  			<td><input type="submit"></td>
		</tr>
	</table>
</form>
</body>
</html>
<html id = "IndexHTML">
<head>
	<meta charset="UTF-8">
	<title>Vehicles</title>
	<meta <%@taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c"%>>
	<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<h1>Vehicle Inventory System</h1>
	<a href="./home" ><img id = "Home1Img" src="images/home.png" alt="home"></a>
	<a href="./add" ><img id = "Home1Img" src="images/add.png" alt="add"></a>
	<img id = "Home1Img" src="images/search.png" alt="search"><br><br>
	
	<form method="POST" action="./search">
		<input type="text" name="searchBox" placeholder="Search for Vehicle"><input type="submit" value="Search">
	</form>
	<form method="POST" action="./price">
		<input type="text" name="priceMinBox" placeholder="Min. Price">  to  
		<input type="text" name="priceMaxBox" placeholder="Max. Price"><input type="submit" value="Search"><br><br>
	</form>
	
	<table id = "IndexTable">
		<tr>
			<th>ID</th>
			<th>Make</th>
			<th>Model</th>
			<th>Year</th>
			<th>Price</th>
			<th>Licence No.</th>
			<th>Colour</th>
			<th>No. Doors</th>
			<th>Transmission</th>
			<th>Mileage</th>
			<th>Fuel Type</th>
			<th>Engine Size</th>
			<th>Body Style</th>
			<th>Condition</th>
			<th>Notes</th>
			<th id = "DelUp">Delete</th>
			<th id = "DelUp">Update</th>
		</tr>
		
		<c:forEach items="${searchVehicles}" var="c">
		<tr>
			<td>${c.getVehicle_id()}</td>
			<td>${c.getMake()}</td>
			<td>${c.getModel()}</td>
			<td>${c.getYear()}</td>
			<td>${c.getPrice()}</td>
			<td>${c.getLicense_number()}</td>
			<td>${c.getColour()}</td>
			<td>${c.getNumber_doors()}</td>
			<td>${c.getTransmission()}</td>
			<td>${c.getMileage()}</td>
			<td>${c.getFuel_type()}</td>
			<td>${c.getEngine_size()}</td>
			<td>${c.getBody_style()}</td>
			<td>${c.getCondition()}</td>
			<td>${c.getNotes()}</td>
			<td><a href="./delete?vehicle_id=${c.getVehicle_id()}"><img id = "BinImg" src="images/bin.png" alt="delete"></a></td>
			<td><a href="./update?vehicle_id=${c.getVehicle_id()}&make=${c.getMake()}&model=${c.getModel()}&year=${c.getYear()}
			&price=${c.getPrice()}&license_number=${c.getLicense_number()}&colour=${c.getColour()}&number_doors=${c.getNumber_doors()}
			&transmission=${c.getTransmission()}&mileage=${c.getMileage()}&fuel_type=${c.getFuel_type()}&engine_size=${c.getEngine_size()}
			&body_style=${c.getBody_style()}&condition=${c.getCondition()}&notes=${c.getNotes()}"><img id = "EditImg" src="images/edit.png" alt="update"></a></td>
		</tr>
		</c:forEach>				
	</table>
</body>
<html>
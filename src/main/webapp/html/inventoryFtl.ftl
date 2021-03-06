<!DOCTYPE html>
<html>
<head>
	<!-- change the path.  -->
	<script type="text/javascript" src="../javaScript/jquery-3.0.0.min.js"></script>
	<script type="text/javascript" src="../javaScript/canvasjs-1.8.1/canvasjs.min.js"></script>
	<script type="text/javascript" src="../javaScript/inventory.js"></script>
	<link rel="stylesheet" type="text/css" href="../css/inventory.css">
	<meta charset="UTF-8">
	<title>Inventory Management</title>
</head>
<body>
	<div id="sideMenu">
		<div class="menuHeader">Stationary</div>
			<div id="pens" class="menuItem">Pens</div>
			<div id="markers" class="menuItem">Markers</div>
			<div id="notes" class="menuItem">Notes</div>
			<div id="pencils" class="menuItem">Pencils</div>
			<div id="erasers" class="menuItem">Erasers</div>
			<div id="dusters" class="menuItem">Dusters</div>
		<div class="menuHeader">System</div>
			<div id="mouses" class="menuItem">Mouses</div>
			<div id="desktops" class="menuItem">Desktops</div>
			<div id="cpus" class="menuItem">CPUs</div>
			<div id="headsets" class="menuItem">HeadSets</div>
		<div class="menuHeader">Cleaning</div>
			<div id="tissues" class="menuItem">Tissues</div>
			<div id="handwash" class="menuItem">HandWash</div>
			<div id="sopes" class="menuItem">Soaps</div>
			<div id="liquides" class="menuItem">Liquides</div>
			<div id="brushes" class="menuItem">Brushes</div>
		<div class="menuHeader">Pantry</div>
			<div id="breads" class="menuItem">Bread</div>
			<div id="jams" class="menuItem">Jam</div>
			<div id="buscuits" class="menuItem">Biscuits</div>
			<div id="coffeePowder" class="menuItem">CoffeePowder</div>
			<div id="teaPowder" class="menuItem">TeaPowder</div>
			<div id="maggiePackets" class="menuItem">MaggiPackets</div>
			<div class="menuItem">PaperGlases</div>
		<div style="height:50px;"></div>
	</div>
	
	<div id="container">

		<div id="status">
			<p>Current Status</p>
			<div id="outerBar">
				<div id="innerBar">
					<div id="dangerMarker"></div>
				</div>
			</div>
			<div id="barIndex">
				<p id="dangerMark"></p>
			</div>
			
			<div id="statusCards">
				<div class="statusCard">
					<p class="statsCardHeader">Available Items</p>
					<p class="statusCardNumber">${avilableItems}</p>
				</div>
				<div class="statusCard">
					<p class="statsCardHeader">Inventory Capacity</p>
					<p class="statusCardNumber">${inventoryCapacity}</p>
				</div>
				<div class="statusCard">
					<p class="statsCardHeader">Fill Percentage</p>
					<p class="statusCardNumber">${fillPercentage}%</p>
				</div>
			</div>
		</div>

		<div id="editDiv">
	
			<p id="updateInventory">Update Inventory<p>
			<div class="editDivCard">
				<p class="editDivCardHeader">Update Inventory</p>
				<div>
					<div>
						<select id="updateAction" name="updateAction" id="user_role">
						  <option>Choose</option>
						  <option value="add">Add</option>
						  <option value="remove">Remove</option>
						</select><br>
						<input id ="updateNumber" name="updateNumber" type="number"/><br>
						<input id="doUpdateInventory" type="button" value="Update">
					</div>
				</div>
			</div>
			<div class="editDivCard">
				<p class="editDivCardHeader">Update Capacity</p>
				<p class="plusMinus">Enter New Capacity</p><br>
				<input id ="updateCapacity" name="updateCapaciry" type="number"/><br>
				<input id="doUpdateCapaciry" type="button" value="Update">
			</div>
			<div class="editDivCard">
				<p class="editDivCardHeader">Add Item</p>
				<select id="category" name="category" id="user_role">
						  <option>Category</option>
						  <option value="stationary">Stationary</option>
						  <option value="pantry">Pantry</option>
						  <option value="pantry">Cleaning</option>
						  <option value="pantry">System</option>
				</select><br>
				<input id ="addItem" name="addItem" type="text"/><br>
				<input id="doAddItem" type="button" value="Add Item">
				
			</div>
		</div>
	
		<div id="analytics">
			<p>Analytics</p>
			<div id="day" class="card">
				<p class="cardHeader">Day</p>
				<p class="cardNumber">${alalyticsDay}</p>
			</div>
			<div id="week" class="card">
				<p class="cardHeader">Week</p>
				<p class="cardNumber">${alalyticsWeek}</p>
			</div>
			<div id="month" class="card">
				<p class="cardHeader">Month</p>
				<p class="cardNumber">${alalyticsMonth}</p>
			</div>
			<div id="year" class="card">
				<p class="cardHeader">Year</p>
				<p class="cardNumber">${alalyticsYear}</p>
			</div>
		</div>
	
		<div id="graph">
			<p id="graphHeader"> Graphical Analysis</p>
				<div id="graphMenu">
					<div class="graphMenuHead">Time Span</div>
						<div id="graphWeek" class="graphMenuItem">Week</div>
						<div id="graphMonth" class="graphMenuItem">Month</div>
						<div id="graphYear" class="graphMenuItem">Year</div>
					<div class="graphMenuHead">Graph Type</div>
						<div id="column" class="graphMenuItem" >Column</div>
						<div id="line"class="graphMenuItem">line</div>
						<div id="area" class="graphMenuItem">area</div>
						<div id="pie" class="graphMenuItem">pie</div>
				</div>
				<div id="chartContainer"></div>
			
		</div>
	
		<div id ="test"> </div>

	</div>
	
	<div id="header">
		<h1 id="title"> OfficeSpace </h1>
			<div class="buttonDiv" style="background-color: #4682B4;"> <p class="buttonText">LogOut<p></div>
		<div id="statusBar">
			<p id="headerItem">${itemName}</p>
		</div>
	</div>
	
</body>
</html>

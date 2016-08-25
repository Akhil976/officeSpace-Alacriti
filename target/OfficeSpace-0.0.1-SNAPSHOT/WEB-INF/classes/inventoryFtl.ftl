
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
				<input id ="maxCapacity" name="maxCapacity" type="number"/> <br>
				<input id="doAddItem" type="button" value="Add Item">
				
			</div>
		</div>
		<div id="analytics">
			
						<div id="analyticsMenu">
				<div id="leftMenu">
					<select id="analyticsBy" name="analyticsBy">
						  <option>AnalyticsBy</option>
						  <option value="day">Day</option>
						  <option value="week">Week</option>
						  <option value="month">Month</option>
						  <option value="year">Year</option>
					</select><br>
					<div id="calBox">
						<input type="date" id="alalyticsCal">	
					</div>
					<input type="button" id="doAnalytics" value="Go">
					
				</div>
				<div id="analyticsTitle">
					<p>Analytics</p> 
				</div>
		   </div>
		   <div class="clear"></div>
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
						<div class="graphMenuHead">Tyme Span</div>
							<select id="graphAnalyticsBy" name="graphAnalyticsBy">
								  <option>AnalyticsBy</option>
								  <option value="week">Week</option>
								  <option value="month">Month</option>
								  <option value="year">Year</option>
							</select><br>
							<div id="graphCalBox">
							<input type="date" id="graphAnalalyticsCal">	
							</div>
							<input type="button" id="doGraphAnalytics" value="Generate">
						
						<div class="graphMenuHead">Graph Type</div>
							<div id="column" class="graphMenuItem" >Column</div>
							<div id="line"class="graphMenuItem">line</div>
							<div id="area" class="graphMenuItem">area</div>
							<div id="pie" class="graphMenuItem">pie</div>
				</div>
				<div id="chartContainer"></div>
		
		</div>

		

		
		<script type="text/javascript" src="../javaScript/inventory.js"></script>
		<script type="text/javascript">generateGraph();</script>
		
		<div id ="test"> </div>

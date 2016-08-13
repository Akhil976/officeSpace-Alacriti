
		<div id="status">
			<p>Current Status</p>
			<style>
			#innerBar{
				    position: absolute;
				    width: ${fillPercentage}%;
				    height: 100%;
				    background-color: ${barColor} ;
				    border-radius:5px;
					}
			</style>		
			<br>
			<div id="outerBar">
			  <div id="innerBar">
			    <div id="label">${fillPercentage}%</div>
			  </div>
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
		<div id="editScrollDiv">
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
				<p class="editDivCardHeader">Add Category</p>
				<p class="plusMinus">New Category Name</p><br>
				<input id ="newCategory" type="text"/><br>
				<input id="addNewCategory" type="button" value="Add">
			</div>
			<div class="editDivCard">
				<p class="editDivCardHeader">Add Item</p>
				<select id="category" name="category" class="categoryList" >
						<option>Category</option>
						<#list categoryList as category>		
							<option value="${category.categoryId}">${category.categoryName}</option>	
						</#list>
						  
				</select><br>
				<input id ="addItem" name="addItem" type="text" placeholder="Item Name" style="font-size:20px;"/><br>
				<input id ="maxCapacity" name="maxCapacity" type="number" placeholder="Max Capacity" style="font-size:20px;" /> <br>
				<input id="doAddItem" type="button" value="Add Item">
			</div>
			
			<div class="editDivCard">
				<p class="editDivCardHeader">Delete Category</p>
				<p class="plusMinus" style="margin-left:85px;">Select Category</p><br>
				<select id="deleteCategory" name="category" class="categoryList">
						<option>Category</option>
						<#list categoryList as category>		
							<option value="${category.categoryId}">${category.categoryName}</option>	
						</#list>
				</select><br>
				<input id="doDeleteCategory" type="button" value="Delete">
			</div>
			
			<div class="editDivCard">
				<p class="editDivCardHeader">Delete Item</p>
				<select id="deleteItemCategory" name="category" class="categoryList">
						<option>Category</option>
						<#list categoryList as category>		
							<option value="${category.categoryId}">${category.categoryName}</option>	
						</#list>
				</select><br>
				<select id="deleteItemItem" name="category" >
				
				</select><br>
				<input id="doDeleteItem" type="button" value="Delete">
			</div>
			
			
			<div class="editDivCard" style="box-shadow:0px 0px 0px white">
			</div>
			</div>
		</div>
		<div id="analytics">
				<div id="analyticsTitle">
					<p>Analytics</p> 
				</div>
		  <div id="analyticsMenu" >

				<div id="leftMenu" >
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
					
					
					<select id="paginationBy" name="paginationBy">
						  <option>AnalyticsBy</option>
						  <option value="month">Month</option>
					</select><br>
					
					<div id="paginationcalBox">
						<input type="date" id="paginationCal">	
					</div>
					<input type="button" id="doPagination" value="Go">
					
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
						<div class="graphMenuHead">Time Span</div>
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
				<div id="chartContainer"> 
					<img src="http://atu.net.au/uploads/widget/.thumbs/graph-increase_66ec01.jpg" style="width:600px; height:270px; margin-left:180px;">
				</div>
		</div>
		<div id ="test"> </div>

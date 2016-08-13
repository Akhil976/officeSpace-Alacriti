
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

adminInventory.ftl
		
		<div id="graph">
		
			<p id="graphHeader"> Graphical Analysis</p>
				
				<div id="graphMenu">
						<div class="graphMenuHead">Tyme Span</div>
							<select id="graphAnalyticsBy" name="graphAnalyticsBy">
								  <option>AnalyticsBy</option>
								  <option value="month">Month</option>
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

		

		
		<script type="text/javascript">generateGraph();</script>
		
		<div id ="test"> </div>

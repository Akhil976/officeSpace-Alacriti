
		<div id="status">

			<style>
			#innerBar{
				    position: absolute;
				    width: ${fillPercentage}%;
				    height: 100%;
				    background-color: ${barColor} ;
				    border-radius:5px;
					}
			#currentStatus{
				padding-top: 30px !important;
			}
			#status{
				margin-top:50px;
				border:0px solid white;
				box-shadow:0px 0px 0px white;
			}
			</style>		
			<br>
			<div id="outerBar">
			  <div id="innerBar">
			    <div id="label">${fillPercentage}%</div>
			  </div>
			</div>

			<p id="currentStatus">Current Status</p>
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

		<div id ="test"> </div>

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
						  <option value="week">Week</option>
						  <option value="month">Month</option>
						  <option value="year">Year</option>
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
			

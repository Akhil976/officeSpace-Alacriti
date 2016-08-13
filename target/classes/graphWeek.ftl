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
		
		<script type="text/javascript">
		pointArray = [
				{ label: "Mun", y: ${w1} },
				{ label: "Tue", y: ${w2} },
				{ label: "Wed", y: ${w3} },
				{ label: "Thu", y: ${w4} },
				{ label: "Fri", y: ${w5} },
				{ label: "Sat", y: ${w6} },
				{ label: "Sun", y: ${w7} },
				];
		graphType="area";
		generateGraph();
		</script>

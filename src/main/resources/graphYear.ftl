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
				{ label: "January", y: ${y1} },
				{ label: "February", y: ${y2} },
				{ label: "March", y: ${y3} },
				{ label: "April", y: ${y4} },
				{ label: "May", y: ${y5} },
				{ label: "June", y: ${y6} },
				{ label: "JUly", y: ${y7} },
				{ label: "August", y: ${y8} },
				{ label: "Sepetember", y: ${y9} },
				{ label: "October", y: ${y10} },
				{ label: "November", y: ${y11} },
				{ label: "December", y: ${y12} }
				];
		graphType="area";
		generateGraph();
		</script>

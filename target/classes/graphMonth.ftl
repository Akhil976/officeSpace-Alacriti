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
				{ label: "1", y: ${m1} },
				{ label: "2", y: ${m2} },
				{ label: "3", y: ${m3} },
				{ label: "4", y: ${m4} },
				{ label: "5", y: ${m5} },
				{ label: "6", y: ${m6} },
				{ label: "7", y: ${m7} },
				{ label: "8", y: ${m8} },
				{ label: "9", y: ${m9} },
				{ label: "10", y: ${m10} },
				{ label: "11", y: ${m11} },
				{ label: "12", y: ${m12} },
				{ label: "13", y: ${m13} },
				{ label: "14", y: ${m14} },
				{ label: "15", y: ${m15} },
				{ label: "16", y: ${m16} },
				{ label: "17", y: ${m17} },
				{ label: "18", y: ${m18} },
				{ label: "19", y: ${m19} },
				{ label: "20", y: ${m20} },
				{ label: "21", y: ${m21} },
				{ label: "22", y: ${m22} },
				{ label: "23", y: ${m23} },
				{ label: "24", y: ${m24} },
				{ label: "25", y: ${m25} },
				{ label: "26", y: ${m26} },
				{ label: "27", y: ${m27} },
				{ label: "28", y: ${m28} },
				{ label: "29", y: ${m29} },
				{ label: "30", y: ${m30} }
				];
		graphType="area";
		generateGraph();
		
		</script>

		
<style>
				.row{
					width:500px;
					height:50px;
					border:0px solid black;
				}
				.item{
					
					height:25px;
					padding-top:15px;
					width:200px;
					float:left;
					font-family: sans-serif;
					font-size: 20px;
					text-align: center;
					background-color: #cccccc;
					
				}
				#pageBox{
					border:0px solid black;
					width:600px;
					height:40px;
					overflow:auto;
					overflow-x:hidden;
				}
				#slidePage{
					border:0px solid red;
					width:600px;
					height:100px;
				}
				.clear{
					clear: both;
				}
				.numberDiv{
					width:20px;
					height:20px;
					margin-top: 10px;
					margin-left: 10px;
					text-align: center;
					color: green;
					float:left;
				}
				.numberDiv:HOVER{
					cursor:pointer;
				}
</style>
			

		  <div id="analyticsMenu" >
		  		<div id="analyticsTitle">
					<p>Analytics</p> 
				</div>
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

		<div style="margin-left:310px;">
			
			
			<div id="tableHead" class="headRow" style="color:green">
				<div class="item">Date </div>
				<div class="item">Consume Quantity </div>
			</div>
			
			<#list paginationConsumeVo.itemConsumeList as item>
				<div id="uniq_page" class="row">
					<div class="item">${item.date} </div>
					<div class="item">${item.consumeAmount} </div>
				</div>
			</#list>

			<div class="clear"></div>
			<div id="pageBox">
			<div id="slidePage" >
				<#list pagesList as page>
					<div id="${page.uniqueId}_${page.offset}_${page.limit}_${page.pageNumber}_${page.totalPages}" class="numberDiv" >${page.pageNumber}</div>
				</#list>
			</div>
			</div>

		</div>

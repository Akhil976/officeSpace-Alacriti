<!DOCTYPE html>
<html>
<head>
	<!-- change the path.  -->
	<script type="text/javascript" src="../javaScript/jquery-3.0.0.min.js"></script>
	<script type="text/javascript" src="../javaScript/canvasjs-1.8.1/canvasjs.min.js"></script>
	<link rel="stylesheet" type="text/css" href="../css/inventory.css">
	<meta charset="UTF-8">
	<title>Inventory Management</title>
</head>
<body>
	<div id="sideMenu">
	
	<#list itemsMenuResponseVo.menu as category>
		<div id="${category.categoryId}" class="menuHeader ${category.categoryId}_head">${category.categoryName} </div>
		<div class="${category.categoryId}_sub sub">
		<#list category.items as itemList>
			<div id="${category.categoryId}_${itemList.itemId}_${itemList.itemName}" class="menuItem">${itemList.itemName} </div>
		</#list>
		</div>
	</#list>
	
		<div style="height:50px;"></div>
	</div>

	<div id="container">
		
		<script type="text/javascript" src="../javaScript/inventory.js"></script>
			
		<div id="chartContainer" style="border:1px solid balck; height:450px; width:500px; margin-top:40px !important; margin-left:260px !important;">  </div>
		
		<script type="text/javascript">
			
			pointArray = [
			<#list itemsMenuResponseVo.graphCategoryList as categoryVo>
					{ label: "${categoryVo.categoryName}", y: ${categoryVo.categoryAvailableItems} },
			</#list>
					];
			graphType="pie";
			generateGraph();
		</script>
		
	</div>
		<div id="header">
			<h1 id="title"> OfficeSpace </h1>
				<div id="logout" class="buttonDiv" style="background-color: #4682B4;"> <p class="buttonText">LogOut<p></div>
			<div id="statusBar">
				<p id="headerItem" >Dashboard</p>
			</div>
		</div>
	

</body>
</html>
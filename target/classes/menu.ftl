	
	<#list itemsMenuResponseVo.menu as category>
		<div id="${category.categoryId}" class="menuHeader ${category.categoryId}_head">${category.categoryName} </div>
		<div class="${category.categoryId}_sub sub">
		<#list category.items as itemList>
			<div id="${category.categoryId}_${itemList.itemId}_${itemList.itemName}" class="menuItem">${itemList.itemName} </div>
		</#list>
		</div>
	</#list>
	
		<div style="height:50px;"></div>
